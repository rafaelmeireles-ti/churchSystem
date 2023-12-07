export class Pessoa {

    idPessoa: number;
    nome: string;
    situacao: string;
    dhInclusao: Date;
    dhSituacao: Date;
  
    constructor(idPessoa: number, nome: string, situacao: string, dhInclusao: Date, dhSituacao: Date) {
      this.idPessoa = idPessoa;
      this.nome = nome;
      this.situacao = situacao;
      this.dhInclusao = dhInclusao;
      this.dhSituacao = dhSituacao;
    }
  }