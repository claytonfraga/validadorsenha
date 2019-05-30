package com.pss.senha.validacao;

final class LetrasSequencialTratador extends TratadorSenha {

    @Override
    public String verificar(String senha) {

        String somenteLetras = senha.replaceAll("[^A-Za-z]+", " ");
        String sequencia = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int tamanhoSequencia = 3;
        int inicio = 0;
        int fim = tamanhoSequencia;
        if (!"".equals(somenteLetras.trim())) {
            while (fim <= somenteLetras.length()) {
                if ((sequencia.contains(somenteLetras.substring(inicio, fim).trim())
                        || new StringBuilder(sequencia).reverse().toString().contains(somenteLetras.substring(inicio, fim).trim()))
                        && somenteLetras.substring(inicio, fim).trim().length() >= tamanhoSequencia) {

                    return "Senha nao deve possuir uma sequencia de letras;";
                }
                inicio += 1;
                fim += 1;
            }
        }

        return "";
    }
}
