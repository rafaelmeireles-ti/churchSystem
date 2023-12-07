import { DadosPessoaisService } from './../../../services/dados-pessoais.service';
import { Component, OnChanges, OnDestroy, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Pessoa } from 'src/app/model/pessoa.model';
import { PessoaService } from 'src/app/services/pessoa.service';
import { takeWhile } from 'rxjs';
import { Table } from 'primeng/table';

@Component({
  selector: 'app-lista-pessoas',
  templateUrl: './lista-pessoas.component.html',
  styleUrls: ['./lista-pessoas.component.css']
})
export class ListaPessoasComponent implements OnInit , OnDestroy , OnChanges {

  constructor(private router: Router ,
    private pessoaService: PessoaService,
    private dadosPessoaisService: DadosPessoaisService) {}


  ngOnChanges(changes: SimpleChanges): void {

  }

  pessoas!: Pessoa[];
  isAlive = true;
  filterOptions: any[] = [
    { nome: 'RAFAEL PEDROSO MEIRELES' },
    { nome: 'VANESSA BORGONOVE DE OLIVEIRA' },
    { nome: 'Gilmar', codigo: 3 }
]



  ngOnInit() {
    this.pessoaService.getPessoas()
    .pipe(takeWhile(() => this.isAlive))
    .subscribe(data => {
      this.pessoas = data;
      console.log(this.pessoas);
    });

    
  }



  ngOnDestroy() {
    this.isAlive = false;
  }

  onVisualizaDados(id:number){
    this.dadosPessoaisService.getDadosPessoais(id)
    .pipe(takeWhile(() => this.isAlive))
    .subscribe(data => {
      console.log(data)
    })

  }

  filtro(value: string) {
    console.log("entrei")
    console.log(value);
    this.pessoas = this.pessoas.filter((pessoa) => pessoa.nome.includes(value));
}

}
