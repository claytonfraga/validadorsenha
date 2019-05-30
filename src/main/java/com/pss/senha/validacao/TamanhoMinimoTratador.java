package com.pss.senha.validacao;

final class TamanhoMinimoTratador extends TratadorSenha {

    @Override
    public String verificar(String senha) {
        if (senha.length() <= 4) {
            return "Senha deve ter mais que 4 caracteres;";
        }
        return "";
    }
    

}
