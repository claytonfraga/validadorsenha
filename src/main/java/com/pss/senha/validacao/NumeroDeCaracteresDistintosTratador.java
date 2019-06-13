/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.senha.validacao;

/**
 *
 * @author Thiago
 */
public class NumeroDeCaracteresDistintosTratador extends TratadorSenha {

    private int minimo;
    private boolean caseSensitive;

    /* No construtor são definidos o número mínimo de caracteres distintos e se 
    caracteres maiúsculos contam (caseSensitive = True)*/
    public NumeroDeCaracteresDistintosTratador(int minimo, boolean caseSensitive) {
        this.minimo = minimo;
        this.caseSensitive = caseSensitive;
    }

    @Override
    String verificar(String senha) {
        if (countUniqueCharacters(senha) < minimo) {
            return "A senha deve conter no minimo " + minimo + " caracteres distintos;";
        }
        return "";
    }

    public int countUniqueCharacters(String input) {
        //Define se é case sensitive
        String novoInput = input;
        if (caseSensitive) {
            novoInput = input.toLowerCase();
        }

        boolean[] isItThere = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < novoInput.length(); i++) {
            isItThere[novoInput.charAt(i)] = true;
        }

        int count = 0;
        for (int i = 0; i < isItThere.length; i++) {
            if (isItThere[i] == true) {
                count++;
            }
        }
        return count;
    }

    public long countUniqueCharacters2(String input) {
        String novoInput = input;
        if (caseSensitive) {
            novoInput = input.toLowerCase();
        }
        return novoInput.chars()
                .distinct()
                .count();
    }
}
