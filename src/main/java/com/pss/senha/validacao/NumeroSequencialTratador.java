package com.pss.senha.validacao;

public final class NumeroSequencialTratador extends TratadorSenha {

    @Override
    public String aceitaSenha(String senha) {

        String somenteNumeros = senha.replaceAll("[^0-9]", " ");
        String sequencia = "0123456789999977777888866666555554444433333222221111100000";

        int inicio = 0;
        if (!"".equals(somenteNumeros.trim())) {
            while (inicio <= somenteNumeros.length()) {
                if ((sequencia.contains(somenteNumeros.substring(inicio, somenteNumeros.length()).trim())
                        || new StringBuilder(sequencia).reverse().toString().contains(somenteNumeros.substring(inicio, somenteNumeros.length()).trim()))
                        && somenteNumeros.substring(inicio, somenteNumeros.length()).trim().length() >= 3) {
                    return "Senha nao deve possuir uma sequencia de numeros;";
                }
                inicio += 1;
            }
        }
        return "";
    }
}
