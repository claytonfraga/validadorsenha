package com.pss.senha.validacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public final class ValidadorSenha {

    private final ArrayList<TratadorSenha> tratadores = new ArrayList<>();
    private final StringBuilder erros = new StringBuilder();
    private static final Logger logger = Logger.getLogger(ValidadorSenha.class);

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

    public List<String> validar(String senha) {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);

        if (senha == null) {
            return new ArrayList<>(Arrays.asList("Informe uma senha;"));
        }

        if (senha.isEmpty()) {
            return new ArrayList<>(Arrays.asList("Informe uma senha;"));
        }
        for (TratadorSenha tratador : tratadores) {
            erros.append(tratador.verificar(senha));
        }

        ArrayList<String> resultadosValidacao = new ArrayList<>(Arrays.asList(erros.toString().split(";")));

        if (resultadosValidacao.get(0).equals("")) {
            resultadosValidacao.clear();
        }

        for (String resultadoValidacao : resultadosValidacao) {
            logger.info(resultadoValidacao);
        }

        return resultadosValidacao;
    }

}
