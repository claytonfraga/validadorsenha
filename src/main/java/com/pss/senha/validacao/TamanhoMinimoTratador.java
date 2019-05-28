package com.pss.senha.validacao;

public final class TamanhoMinimoTratador extends TratadorSenha {

    @Override
    public String aceitaSenha(String senha) {
        if (senha.length() <= 3) {
            return "Senha deve ter mais que 3 caracteres;";
        }
        return "";
    }
    

}
