package vendingmachinekata;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Caleb
 */
public class VendingMachineKataTest {

    private VendingMachine v;

    public void setup() {
        v = new VendingMachine();
    }

    @Test
    public void testGetAmountPaidTenShouldReturnTen() {
        setup();
        v.insertCoin("dime");
        assertEquals("0.10", v.display());
    }

    @Test
    public void testGetAmountPaidFiveShouldReturnFive() {
        setup();
        v.insertCoin("Quarter");
        assertEquals("0.25", v.display());
    }

    @Test
    public void testRejectImproperValueOne() {
        setup();
        v.insertCoin("penny");
        assertEquals("Not a valid coin.", v.display());
    }

    @Test
    public void testCoinPennyIsReturned() {
        setup();
        v.insertCoin("Penny");
        assertEquals("Penny", v.returnCoins());
    }

    @Test
    public void testGivingMoneyForColaAndRequestingColaShouldReturnCola() {
        setup();
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("quarter");
        v.requestItem("cola");
        assertEquals("cola", v.dispenser.getName());
    }

    @Test
    public void testGivingMoneyForChipsAndRequestingChipsShouldREturnChips() {
        setup();
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.requestItem("chips");
        assertEquals("chips", v.dispenser.getName());
    }

    @Test
    public void testGivingMoneyForChipsAndRequestingColaShouldReturnColaAfterMoneyIsInput() {
        setup();
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.requestItem("cola");
        v.insertCoin("quarter");
        v.insertCoin("quarter");
        assertEquals("cola", v.dispenser.getName());
    }

    @Test
    public void testDisplayEqualsThankYouAfterItemIsDispensed() {
        setup();
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.requestItem("cola");
        v.insertCoin("quarter");
        v.insertCoin("quarter");
        assertEquals("THANK YOU", v.display());
    }

    @Test
    public void testDisplayGoesBackToInsertCoinAfterThankYou() {
        setup();
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.requestItem("cola");
        v.insertCoin("quarter");
        v.insertCoin("quarter");
        v.display();
        assertEquals("INSERT COINS", v.display());
    }

    @Test
    public void testDisplayMoneyAmountIfMoneyIsLeftAfterTransaction() {
        setup();
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("quarter");
        v.insertCoin("dime");
        v.insertCoin("dime");
        v.insertCoin("dime");
        v.requestItem("cola");
        v.display();
        assertEquals("0.05", v.display());
    }

    @Test
    public void testCoinReturnReturnsCoinsIfCancelOrder() {
        setup();
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("quarter");
        assertEquals("Quarter, Quarter, quarter", v.returnCoins());
    }
    
    @Test
    public void testCoinReturnShouldReturnNothingIfNoCoinsWereInput(){
        setup();
        assertEquals("Nothing", v.returnCoins());
    }
}
