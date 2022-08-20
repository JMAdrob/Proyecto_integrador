import { Component, OnInit } from '@angular/core';
import { Estudios } from 'src/app/model/estudios.model';
import { EstudiosService } from 'src/app/service/estudios.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-estudios',
  templateUrl: './estudios.component.html',
  styleUrls: ['./estudios.component.css'],
})
export class EstudiosComponent implements OnInit {
  public estudios: Estudios[] = [];
  public editEstudios: Estudios | undefined;
  public deleteEstudios: Estudios | undefined;

  constructor(private estudiosService: EstudiosService) {}

  ngOnInit(): void {
    this.getEstudios();
  }

  public getEstudios(): void {
    this.estudiosService.getEstudios().subscribe({
      next: (Response: Estudios[]) => {
        this.estudios = Response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  public onOpenModal(mode: string, estudio?: Estudios): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEstudiosModal');
    } else if (mode === 'delete') {
      this.deleteEstudios = estudio;
      button.setAttribute('data-target', '#deleteEstudiosModal');
    } else if (mode === 'edit') {
      this.editEstudios = estudio;
      button.setAttribute('data-target', '#editEstudiosModal');
    }

    container?.appendChild(button);
    button.click();
  }

  public onAddEstudios(addForm: NgForm): void {
    document.getElementById('add-estudios-form')?.click();
    this.estudiosService.addEstudios(addForm.value).subscribe({
      next: (response: Estudios) => {
        console.log(response);
        this.getEstudios();
        addForm.reset();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      },
    });
  }

  public onUpdateEstudios(estudios: Estudios) {
    this.editEstudios = estudios;
    this.estudiosService.updateEstudios(estudios).subscribe({
      next: (response: Estudios) => {
        console.log(response);
        this.getEstudios();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  public onDeleteEstudios(idEst: number): void {
    this.estudiosService.deleteEstudios(idEst).subscribe({
      next: (response: void) => {
        console.log(response);
        this.getEstudios();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }
}
