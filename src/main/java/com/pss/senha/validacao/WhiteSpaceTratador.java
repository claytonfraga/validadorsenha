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
public class WhiteSpaceTratador extends TratadorSenha{

    @Override
    String verificar(String senha) {
        Pattern WHITE_SPACE = Pattern.compile("\\s+");
        Matcher temEspaco = WHITE_SPACE.matcher(senha);
        
        if(temEspaco.find()) {
            return "A senha não pode conter espaço em branco;";
        }
        return "";
    }
    
}
