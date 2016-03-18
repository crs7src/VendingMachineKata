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
    public void testGetAmountPaidTenShouldReturnTen(){
        setup();
        v.insertCoin("dime");
        assertEquals("10", v.display());
    }
    
    @Test
    public void testGetAmountPaidFiveShouldReturnFive(){
        setup();
        v.insertCoin("Quarter");
        assertEquals("25", v.display());
    }
    
    @Test
    public void testRejectImproperValueOne(){
        setup();
        v.insertCoin("penny");
        assertEquals("Not a valid coin.", v.display());
    }
    
    @Test
    public void testCoinPennyIsReturned(){
        setup();
        v.insertCoin("Penny");
        assertEquals("Penny", v.returnCoins());
    }
}
