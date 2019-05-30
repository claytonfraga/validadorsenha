package com.pss.senha.validacao;

final class CaseSensitiveTratador extends TratadorSenha {

    private final boolean maiuscula;

    public CaseSensitiveTratador(boolean verificaMaiscula) {
        maiuscula = verificaMaiscula;
    }

    @Override
    public String verificar(String senha) {

        if (maiuscula) {
            boolean temMaiusculas = !senha.equals(senha.toLowerCase());
            if (!temMaiusculas) {
                return "A senha deve conter letras maiusculas;";
            }
            return "";
        } else {
            boolean temMinusculas = !senha.equals(senha.toUpperCase());
            if (!temMinusculas) {
                return "A senha deve conter letras minusculas;";
            }
        }
        return "";

    }
}
