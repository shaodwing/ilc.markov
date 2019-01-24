package cfranc.ilc;

import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

public class GehinMarkovWordTest {
    
    String[] when2SimpleWords = new String[] {"parapluie", "parachute"};
    
    
    /*
     * Test de processString()
     */
    
    @Test
    public void processString_oneWordAndNEqual2_10() {
        //Cas commun
        
        MarkovWord m = new MarkovWord();
        MarkovData expected = new MarkovData("pa", 1);
        MarkovData actual = m.processString(when2SimpleWords[0], 2).get(1);
        
        assertEquals(expected, actual);		
    }    
    

    /*
     * Test de common()
     */
    
    @Test
    public void common_sameWord_12() {
        MarkovWord m = new MarkovWord();
        List<MarkovData> mot1 = m.processString(when2SimpleWords[0], 4); //mot process
        
        int expected = 12; //nb de caractere identique
        int actual = m.common(mot1,mot1);
        assertEquals(expected, actual);
    }
    
    
    @Test
    public void common_when2SimpleWords_4() {
        MarkovWord m = new MarkovWord();
        List<MarkovData> mot1 = m.processString(when2SimpleWords[0], 4); //mot process
        List<MarkovData> mot2 = m.processString(when2SimpleWords[1], 4); //mot process
        
        int expected = 5; //nb de caractere identique
        int actual = m.common(mot1,mot2);
        assertEquals(expected, actual);
    }
    
    
    /*
     * Test de union()
     */
    
    @Test
    public void union_sameWord_0() {
        MarkovWord m = new MarkovWord();
        List<MarkovData> mot1 = m.processString(when2SimpleWords[0], 4); //mot process
        
        int expected = 12; //nb de caractere unique en tout
        int actual = m.union(mot1,mot1);
        assertEquals(expected, actual);
    }
    
    
    @Test
    public void union_when2SimpleWords_19() {
        MarkovWord m = new MarkovWord();
        List<MarkovData> mot1 = m.processString(when2SimpleWords[0], 4); //mot process
        List<MarkovData> mot2 = m.processString(when2SimpleWords[1], 4); //mot process
        
        int expected = 19; //nb de caractere unique en tout
        int actual = m.union(mot1,mot2);
        assertEquals(expected, actual);
    }
    
    
    /*
     * Test de contains
     */
    
    @Test
    public void contains_parapluieAnd2Andpa_1() {
        //Cas commun, la syllabe est dans la chaine de markov
        MarkovWord m = new MarkovWord(when2SimpleWords[0], 2);
        
        int expected = 1; //position de la syllabe dans la liste
        int actual = m.contains("pa");
        assertEquals(expected, actual);
    }
    
    @Test
    public void contains_parapluieAnd2Andzz_0() {
        //Cas commun, la syllabe n'est pas dans la chaine de markov
        MarkovWord m = new MarkovWord(when2SimpleWords[0], 2);
        
        int expected = 0; //position de la syllabe dans la liste
        int actual = m.contains("zz");
        assertEquals(expected, actual);
    }    
}