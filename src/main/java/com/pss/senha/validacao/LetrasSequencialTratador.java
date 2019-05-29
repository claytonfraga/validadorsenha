package com.pss.senha.validacao;

final class LetrasSequencialTratador extends TratadorSenha {

    @Override
    public String aceitaSenha(String senha) {

        String somenteLetras = senha.replaceAll("[^A-Za-z]+", " ");
        String sequencia = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        int inicio = 0;
        if (!"".equals(somenteLetras.trim())) {
            while (inicio <= somenteLetras.length()) {
                if ((sequencia.contains(somenteLetras.substring(inicio, somenteLetras.length()).trim())
                        || new StringBuilder(sequencia).reverse().toString().contains(somenteLetras.substring(inicio, somenteLetras.length()).trim()))
                        && somenteLetras.substring(inicio, somenteLetras.length()).trim().length() >= 3) {

                    return "Senha nao deve possuir uma sequencia de letras;";
                }
                inicio += 1;
            }
        }

        return "";
    }
}
