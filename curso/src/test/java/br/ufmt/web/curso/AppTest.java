package br.ufmt.web.curso;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void nomeNulo(){
      Cliente cliente = new Cliente();
      String nome = cliente.getNome();
      assertNotNull("Erro: nome nulo", nome);
    }
}
