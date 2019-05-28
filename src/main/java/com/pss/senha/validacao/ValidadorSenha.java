package com.pss.senha.validacao;

import java.util.ArrayList;
import java.util.Arrays;

public final class ValidadorSenha {

    private final ArrayList<TratadorSenha> tratadores = new ArrayList<>();
    private final StringBuilder erros = new StringBuilder();

    public ValidadorSenha() {

        tratadores.add(new TamanhoMinimoTratador());
        tratadores.add(new TamanhoMaximoTratador());
        tratadores.add(new NumeroSequencialTratador());
        tratadores.add(new SomenteNumerosTratador());
        tratadores.add(new LetrasSequencialTratador());
        tratadores.add(new DataTratador());
        tratadores.add(new CaracterEspecialTratador());
        tratadores.add(new CaseSensitiveTratador(true));
        tratadores.add(new CaseSensitiveTratador(false));
        tratadores.add(new MaisUsadasTratador());
    }

    public ArrayList<String> validar(String senha) {
        for (TratadorSenha tratador : tratadores) {
            erros.append(tratador.aceitaSenha(senha));
        }
        if (erros.toString() == null) {
            return null;
        }
        ArrayList<String> resultadosValidacao = new ArrayList<>(Arrays.asList(erros.toString().split(";")));

        for (String resultadoValidacao : resultadosValidacao) {
            System.out.println(resultadoValidacao);
        }

        return resultadosValidacao;
    }

}
