package com.pss.senha;

import com.pss.senha.validacao.ValidadorSenha;

public final class Principal {

    public static void main(String[] args) {
        
        ValidadorSenha validador = new ValidadorSenha();

//        String senha = "xfq*-8A";
        String senha = "aaa";

        validador.validar(senha);

    }

}
