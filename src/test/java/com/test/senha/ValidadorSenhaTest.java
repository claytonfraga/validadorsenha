package com.test.senha;

import com.pss.senha.validacao.ValidadorSenha;
import java.util.Iterator;
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
        //Resultado final mudado para 3 devido à novo tratador de caracteres distintos!
        List<String> resultado = validador.validar(senha);
        assertEquals(3, resultado.size());
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

    @Test
    public void senhaSequenciaLetras() {
        String senha = "abc*1A";

        List<String> resultado = validador.validar(senha);
        assertEquals(1, resultado.size());
    }

    @Test
    public void senhaSequenciaLetras1() {
        String senha = "cba*1A";

        List<String> resultado = validador.validar(senha);
        assertEquals(1, resultado.size());
    }

    @Test
    public void senhaSequenciaLetrasEnumeros() {
        String senha = "9xyzA123x*";

        List<String> resultado = validador.validar(senha);
        assertEquals(2, resultado.size());
    }
    @Test
    public void senhaNula() {
        String senha = null;

        List<String> resultado = validador.validar(senha);
        assertEquals(1, resultado.size());
    }
    
    //Teste Gerado Por Thiago V.
    @Test
    public void senhaComEmail() {
        
        //Mensagens geradas: CaseSensitive, TamanoMaximo, SenhaComEmail: 3 
        System.out.println("Teste senhaComEmail():");
        String senha = "thiago@hotmail.com";
        List<String> resultado = validador.validar(senha);
        assertEquals(3, resultado.size());
    }
    //Teste Gerado por Thiago V.
    @Test
    public void senhaComAcentos() {
        //Mensagens geradas: SenhaComAcento, CaseSensitive, CaracteresEspeciais: 3 
        System.out.println("Teste senhaComAcentos():");
        String senha = "sénhâ";
        List<String> resultado = validador.validar(senha);
        assertEquals(3, resultado.size());
    }
    
    //Teste Gerado por Thiago V.
    @Test
    public void senhaComCaracteresEspeciais() {
        //Teste para verificar se o tratador de caracteres especiais reconhece os caracteres `´^:
        //Mensagens geradas: Caracteres Especiais, CaseSensitive: 2
        System.out.println("Teste senhaComCaracteresEspeciais():");
        String senha = "´^senha^´";
        List<String> resultado = validador.validar(senha);
        assertEquals(2, resultado.size());
    }
    
    //Teste Gerado por Thiago V.
    @Test
    public void senhaComEspaco() {
        //Mensagens geradas: CaseSensitive,CaracterEspecial,TamanhoMaximo, SenhaComEspaco: 4
        String senha = "senha com espaco";
        System.out.println("Teste senhaComEspaco():");
        List<String> resultado = validador.validar(senha);
        
        for(String s:resultado) {
            System.out.println(s);
        }
        
        assertEquals(4, resultado.size());
    }
    
    //Teste Gerador por Thiago V.
    @Test
    public void senhaCom3CaracteresDistintos() {
        //Mensagens geradas: CaseSensitive, CaractereEspecial, NumeroCaracteresDistintos: 3
        String senha = "auoao";
        System.out.println("Teste senhaCom3CaracteresDistintos()");
        
        //Os parâmetros do Tratador são: 4 caracteres mínimos, sendo Case Sensitive
        List<String> resultado = validador.validar(senha);
        
        for(String s:resultado) {
            System.out.println(s);
        }
        assertEquals(3, resultado.size());
    }
   
}
