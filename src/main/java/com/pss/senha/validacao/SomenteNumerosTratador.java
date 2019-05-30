package com.pss.senha.validacao;

final class SomenteNumerosTratador extends TratadorSenha {

    @Override
    public String verificar(String senha) {
        String somenteNumeros = senha.replaceAll("[^0-9]", " ").trim();

        if (somenteNumeros.length() == senha.length()) {
            return "Senha deve possuir numeros, letras minusculas e maiusculas e símbolos;";
        }
        return "";

    }
}
