import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pessoa } from '../model/pessoa.model';


@Injectable({
  providedIn: 'root'
})
export class PessoaService {
  private baseUrl = 'http://localhost:8080'; // URL base do seu backend
  constructor(private http: HttpClient) {}

  getPessoas(): Observable<any[]> {
    const url = `${this.baseUrl}/api/pessoa/lista-pessoa`; // URL completa do serviço
    return this.http.get<any[]>(url);
  }

}
