import { Component, OnInit } from '@angular/core';
import { datosPersonales } from 'src/app/module/datosPersonales.model';
import { DatosPersonalesService } from 'src/app/service/datos-personales.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  DatosPersonales: datosPersonales = new datosPersonales("","");

  constructor(public datosPersonalesService: DatosPersonalesService) { }

  ngOnInit(): void {
    this.datosPersonalesService.getDatosPersonales().subscribe(data  => {this.DatosPersonales = data})
  }

}
