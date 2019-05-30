package com.pss.senha.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class CaracterEspecialTratador extends TratadorSenha {

    @Override
    public String verificar(String senha) {
        Pattern especiais = Pattern.compile("[!@#$%&*/()_+=|<>?{}\\[\\]~-]");
        Matcher temEspecial = especiais.matcher(senha);
        if (!temEspecial.find()) {
            return "A senha deve conter caracteres especiais;";
        }
        return "";

    }
}
