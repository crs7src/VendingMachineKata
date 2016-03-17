/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinekata;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Caleb
 */
public class VendingMachineKataTest {
    private VendingMachine v;
    /**
     * Test of main method, of class VendingMachineKata.
     */
    public void setup() {
        v = new VendingMachine();
    }
    
    @Test
    public void testReturnCoinAmountOfTenShouldBeTen(){
        setup();
        v.insertCoin(10);
        assertEquals("10", v.getAmountPaid());
    }
    
}
