package com.pss.senha.validacao;

/**
 *
 * @author Dalvan
 */
class CPFTratador extends TratadorSenha {

    private int sm = 0;
    private int peso = 10;

    @Override
    public String verificar(String senha) {
        String cpf = senha.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return "";
        } else {
            int r;
            char dig10 = 0;
            char dig11 = 0;

            sm = ajustaPeso(cpf, sm, peso, 9);

            r = 11 - (sm % 11);
            dig10 = defineDigito(dig10, r);

            sm = 0;
            peso = 11;
            sm = ajustaPeso(cpf, sm, peso, 10);

            r = 11 - (sm % 11);
            dig11 = defineDigito(dig11, r);

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return "Senha não pode conter um CPF;";
            } else {
                return "";
            }
        }

    }

    private int ajustaPeso(String cpf, int sm, int peso, int tamanho) {
        int num;
        for (int i = 0; i < tamanho; i++) {
            num = (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }
        return sm;
    }

    private char defineDigito(char digito, int r) {
        if ((r == 10) || (r == 11)) {
            digito = '0';
        } else {
            digito = (char) (r + 48);
        }
        return digito;
    }
}
