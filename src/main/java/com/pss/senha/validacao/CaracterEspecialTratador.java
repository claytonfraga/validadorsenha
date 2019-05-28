package com.pss.senha.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CaracterEspecialTratador extends TratadorSenha {

    @Override
    public String aceitaSenha(String senha) {
        Pattern especiais = Pattern.compile("[!@#$%&*/()_+=|<>?{}\\[\\]~-]");
        Matcher temEspecial = especiais.matcher(senha);
        if (!temEspecial.find()) {
            return "A senha deve conter caracteres especiais;";
        }
        return "";

    }
}
