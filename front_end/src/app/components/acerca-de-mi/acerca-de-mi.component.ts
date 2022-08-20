import { Component, OnInit } from '@angular/core';
import { datosPersonales } from 'src/app/model/datosPersonales.model';
import { DatosPersonalesService } from 'src/app/service/datos-personales.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-acerca-de-mi',
  templateUrl: './acerca-de-mi.component.html',
  styleUrls: ['./acerca-de-mi.component.css']
})
export class AcercaDeMiComponent implements OnInit {

  public datosPersonales: datosPersonales | undefined;
  public editarDatosPerosnales: datosPersonales | undefined;

  constructor(private datosPersonalesService: DatosPersonalesService) { }

  ngOnInit(): void {
    this.getDatosPersonales();
  }

  public getDatosPersonales():void{
    this.datosPersonalesService.getDatosPersonales().subscribe({
      next: (response: datosPersonales) =>{
        this.datosPersonales = response;
      },
      error:(error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }

  public onOpenModal(mode: string, datosPersonales?: datosPersonales): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    button.setAttribute('data-target', '#updateDatosPersonalesModal');

    container?.appendChild(button);
    button.click();
  }
  public onUpdateDatosPersonales(datosPersonales: datosPersonales): void {
    this.editarDatosPerosnales = datosPersonales;
    this.datosPersonalesService.updateDatosPersonales(datosPersonales).subscribe({
      next: (response: datosPersonales) => {
        console.log(response);
        this.getDatosPersonales();
      },
      error: (error: HttpErrorResponse) => {
        console.log('error');
      },
    });
  }
}
