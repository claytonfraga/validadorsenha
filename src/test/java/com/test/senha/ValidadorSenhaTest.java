package com.test.senha;

import com.pss.senha.validacao.ValidadorSenha;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Clayton
 */
public class ValidadorSenhaTest {

    private ValidadorSenha validador;

    public ValidadorSenhaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        validador = new ValidadorSenha();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void senha1Test() {
        String senha = "aw123abc";

        List<String> resultado = validador.validar(senha);
        assertEquals(4, resultado.size());
    }

    @Test
    public void senha2Test() {
        String senha = "xfq*-8A";

        List<String> resultado = validador.validar(senha);
        assertEquals(0, resultado.size());
    }

    @Test
    public void senhaCPFTest() {
        //CPF Gerado em https://www.4devs.com.br/gerador_de_cpf
        String senha = "033.926.480-27";

        List<String> resultado = validador.validar(senha);
        assertEquals(4, resultado.size());
    }

    @Test
    public void senhaCPF2Test() {
        //CPF Gerado em https://www.4devs.com.br/gerador_de_cpf
        String senha = "23636116088";

        List<String> resultado = validador.validar(senha);
        assertEquals(7, resultado.size());
    }

    @Test
    public void senhaVazia() {
        String senha = "";

        List<String> resultado = validador.validar(senha);
        assertEquals(1, resultado.size());
    }
}
