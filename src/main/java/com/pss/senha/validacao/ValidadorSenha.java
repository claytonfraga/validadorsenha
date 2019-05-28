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
        tratadores.add(new CPFTratador());
    }

    public ArrayList<String> validar(String senha) {
        if (senha.isEmpty()) {
            return new ArrayList<>(Arrays.asList("Informe uma senha;"));
        }
        for (TratadorSenha tratador : tratadores) {
            erros.append(tratador.validaSenha(senha));
        }
        if (erros.toString() == null) {
            return null;
        }
        ArrayList<String> resultadosValidacao = new ArrayList<>(Arrays.asList(erros.toString().split(";")));

        if (resultadosValidacao.size() == 1) {
            if (resultadosValidacao.get(0).equals("")) {
                resultadosValidacao.clear();
            }
        }

        for (String resultadoValidacao : resultadosValidacao) {
            System.out.println(resultadoValidacao);
        }

        return resultadosValidacao;
    }

}
