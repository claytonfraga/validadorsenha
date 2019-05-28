package com.pss.senha.validacao;

public final class SomenteNumerosTratador extends TratadorSenha {

    @Override
    public String aceitaSenha(String senha) {
        try {
            Long numeroQualquer = new Long(senha);
            return "Senha deve possuir numeros, letras minusculas e maiusculas e símbolos;";
        } catch (NumberFormatException e) {
            return "";
        }
    }
}
