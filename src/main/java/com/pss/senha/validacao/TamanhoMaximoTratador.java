package com.pss.senha.validacao;

public final class TamanhoMaximoTratador extends TratadorSenha {

    @Override
    public String aceitaSenha(String senha) {
        if (senha.length() > 10) {
            return "A senha deve ter no maximo 10 caracteres;";
        }
        return "";
    }

}
