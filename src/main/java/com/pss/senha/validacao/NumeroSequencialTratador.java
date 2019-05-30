package com.pss.senha.validacao;

final class NumeroSequencialTratador extends TratadorSenha {

    @Override
    public String verificar(String senha) {

        String somenteNumeros = senha.replaceAll("[^0-9]", " ");
        String sequencia = "0123456789999977777888866666555554444433333222221111100000";

        int tamanhoSequencia = 3;
        int inicio = 0;
        int fim = tamanhoSequencia;
        if (!"".equals(somenteNumeros.trim())) {
            while (fim <= somenteNumeros.length()) {
                if ((sequencia.contains(somenteNumeros.substring(inicio, fim).trim())
                        || new StringBuilder(sequencia).reverse().toString().contains(somenteNumeros.substring(inicio, fim).trim()))
                        && somenteNumeros.substring(inicio, fim).trim().length() >= tamanhoSequencia) {

                    return "Senha nao deve possuir uma sequencia de numeros;";
                }
                inicio += 1;
                fim += 1;
            }
        }
        return "";
    }
}
