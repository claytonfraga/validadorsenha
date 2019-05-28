package com.pss.senha;

import com.pss.senha.validacao.ValidadorSenha;

public final class Principal {

    public static void main(String[] args) {
        
        ValidadorSenha validador = new ValidadorSenha();

        String senha = "aw123abc";

        validador.validar(senha);

    }

}
