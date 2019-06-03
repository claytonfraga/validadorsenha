/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.senha.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Thiago
 */
public class EmailTratador extends TratadorSenha {

    @Override
    String verificar(String senha) {
        Pattern ENDERECO_DE_EMAIL_VALIDO_REGEX
                = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        
        Matcher isEmail = ENDERECO_DE_EMAIL_VALIDO_REGEX.matcher(senha);
        if(isEmail.find()) {
            return "A senha não pode ser um email;";
        }
        return "";
    }

}
