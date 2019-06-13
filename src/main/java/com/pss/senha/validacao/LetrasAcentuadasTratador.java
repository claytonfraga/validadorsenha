/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.senha.validacao;

import java.text.Normalizer;

/**
 *
 * @author Thiago
 */
public class LetrasAcentuadasTratador extends TratadorSenha {

    @Override
    String verificar(String senha) {
        if (temAcentos(senha)) {
            return "Senha não deve conter letras acentuadas;";
        }
        return "";
    }

    private String removeAcentos(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Texto e nulo!");
        }
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    private boolean temAcentos(String texto) {
        return !removeAcentos(texto).equals(texto);
    }

}
