package com.pss.senha.validacao;

/**
 *
 * @author Dalvan
 */
public class CPFTratador extends TratadorSenha {

    @Override
    public String aceitaSenha(String senha) {
        String cpf = senha.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return "";
        } else {
            char dig10, dig11;
            int sm, i, r, num, peso;

            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {

                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return "Senha não pode conter um CPF";
            } else {
                return "";
            }

        }

    }

}
