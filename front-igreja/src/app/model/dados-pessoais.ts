import { Pessoa } from "./pessoa.model";

export interface DadosPessoais {
    idDadosPessoais: number;
    pessoa: Pessoa;
    telefone: string;
    email: string;
    dataNascimento: string;
    profissao: string;
    cpf: string;
    identidade: string;
    estadoCivil: string;
    escolaridade: string;
    cargo: string;

}