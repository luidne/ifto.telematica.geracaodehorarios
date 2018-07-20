package br.edu.ifto.telematica.geracaodehorarios;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luidne
 */
public class GeradorTest {

    private static Gerador instance;
    
    public GeradorTest() {}
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Gerador();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("[Inicializando] testes");
        instance.popular();
    }
    
    @Test
    public void naoFazNadaTest(){
        instance.gerar();
        assertTrue(true);
    }
    
    @After
    public void tearDown() {
        System.out.println("[Finalizando] testes");        
        instance.limparTudo();
    }
}
