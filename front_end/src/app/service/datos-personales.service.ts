import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { datosPersonales } from '../model/datosPersonales.model';

@Injectable({
  providedIn: 'root'
})
export class DatosPersonalesService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getDatosPersonales(): Observable<datosPersonales> {
    return this.http.get<datosPersonales>(`${this.apiServerUrl}/datospersonales/1`);
  }
  public updateDatosPersonales(datosPersonales: datosPersonales): Observable<datosPersonales> {
    return this.http.put<datosPersonales>(`${this.apiServerUrl}/datospersonales/actualizar`, datosPersonales);
  }
}
