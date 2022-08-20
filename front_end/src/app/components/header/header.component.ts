import { Component, OnInit } from '@angular/core';
import { datosPersonales } from 'src/app/model/datosPersonales.model';
import { DatosPersonalesService } from 'src/app/service/datos-personales.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

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
}
