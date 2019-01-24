/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfranc.ilc;

import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

public class GehinMarkovDataTest {
    
    String[] when2SimpleWords = new String[] {"parapluie", "parachute"};
    
    /*
     * Test du contructeur
     */
    
    @Test
    public void MarkovData_parapluieAnd2_parapluieAnd2() {
        MarkovData actualData = new MarkovData(when2SimpleWords[0], 2);
        
        String expectedString = when2SimpleWords[0];
        int expectedInt = 2;
        
        assertEquals(expectedString, actualData.getTheWord());
        assertEquals(expectedInt, actualData.getTheCount());
    }
}
