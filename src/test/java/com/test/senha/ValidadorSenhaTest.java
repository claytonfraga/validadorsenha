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
    public void senhaCPF1Test() {
        //CPF Gerado em https://www.4devs.com.br/gerador_de_cpf
        String senha = "033.926.480-27";

        List<String> resultado = validador.validar(senha);
        assertEquals(5, resultado.size());
    }

    @Test
    public void senhaCPF2Test() {
        //CPF Gerado em https://www.4devs.com.br/gerador_de_cpf
        String senha = "23636116088";

        List<String> resultado = validador.validar(senha);
        assertEquals(7, resultado.size());
    }

    @Test
    public void senhaCPF3Test() {
        //CPF Gerado em https://www.4devs.com.br/gerador_de_cpf
        String senha = "953.413.810-09";

        List<String> resultado = validador.validar(senha);
        assertEquals(5, resultado.size());
    }

    @Test
    public void senhaCPF4Test() {
        //CPF Gerado em https://www.4devs.com.br/gerador_de_cpf
        String senha = "241.284.260-40";

        List<String> resultado = validador.validar(senha);
        assertEquals(5, resultado.size());
    }

    @Test
    public void senhaVazia() {
        String senha = "";

        List<String> resultado = validador.validar(senha);
        assertEquals(1, resultado.size());
    }

    @Test
    public void senha3Digitos() {
        String senha = "x*1";

        List<String> resultado = validador.validar(senha);
        assertEquals(2, resultado.size());
    }

    @Test
    public void senha4Digitos() {
        String senha = "x*1A";

        List<String> resultado = validador.validar(senha);
        assertEquals(1, resultado.size());
    }

    @Test
    public void senhaCorreta() {
        String senha = "xfq*-8A";

        List<String> resultado = validador.validar(senha);
        assertEquals(0, resultado.size());
    }
}
