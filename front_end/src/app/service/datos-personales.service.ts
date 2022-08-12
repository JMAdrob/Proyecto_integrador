import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { datosPersonales } from '../module/datosPersonales.model';

@Injectable({
  providedIn: 'root'
})
export class DatosPersonalesService {

  URL = 'http://localhost:8080/datospersonales';
  constructor(private http: HttpClient) { }

  public getDatosPersonales(): Observable<datosPersonales>{
    return this.http.get<datosPersonales>(this.URL+'/traer/yo');
  }
}
