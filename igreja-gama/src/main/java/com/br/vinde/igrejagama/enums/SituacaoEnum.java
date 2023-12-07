package com.br.vinde.igrejagama.enums;




public enum SituacaoEnum {

        ATIVO(true),
        INATIVO(false);

        private boolean valor;

    public boolean getValor() {
        return valor;
    }
    SituacaoEnum(boolean valor) {
            this.valor = valor;
        }
}
