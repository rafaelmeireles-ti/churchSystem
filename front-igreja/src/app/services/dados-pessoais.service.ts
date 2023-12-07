import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DadosPessoais } from '../model/dados-pessoais';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DadosPessoaisService {

  private baseUrl = 'http://localhost:8080'; // URL base do seu backend
  constructor(private http: HttpClient) {}

  getDadosPessoais(id:number): Observable<DadosPessoais[]> {
    const url = `${this.baseUrl}/api/dados-pessoais/busca-dados-pessoais/${id}`; 
    return this.http.get<DadosPessoais[]>(url);
  }

}
