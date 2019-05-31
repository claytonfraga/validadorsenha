package com.pss.senha.validacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public final class ValidadorSenha {

    private final ArrayList<TratadorSenha> tratadores = new ArrayList<>();
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
        //Tratadores adicionados por Thiago
        tratadores.add(new EmailTratador());
        tratadores.add(new LetrasAcentuadasTratador());
        tratadores.add(new WhiteSpaceTratador());
        tratadores.add(new NumeroDeCaracteresDistintosTratador(4, true));
        
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);

    }

    public List<String> validar(String senha) {

        if (senha == null) {
            return new ArrayList<>(Arrays.asList("Informe uma senha;"));
        }

        if (senha.isEmpty()) {
            return new ArrayList<>(Arrays.asList("Informe uma senha;"));
        }

        ArrayList<String> resultadosValidacao = new ArrayList<>();

        for (TratadorSenha tratador : tratadores) {
            String resultado = tratador.verificar(senha);
            if (!resultado.isEmpty()) {
                resultadosValidacao.add(resultado);
                logger.info(resultado);
            }
        }

        return resultadosValidacao;
    }

}
