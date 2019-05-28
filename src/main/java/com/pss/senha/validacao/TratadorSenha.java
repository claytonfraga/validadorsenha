package com.pss.senha.validacao;

public abstract class TratadorSenha {

    public final String validaSenha(String senha) {
        if (senha != null) {
            return aceitaSenha(senha);
        } 
        throw new IllegalArgumentException("Informe uma senha;");
    }

    abstract String aceitaSenha(String senha);

}
