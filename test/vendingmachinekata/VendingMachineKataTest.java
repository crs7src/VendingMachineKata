package vendingmachinekata;

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
    public void testDisplayChangeAmountIfChangeIsLeftAfterTransaction() {
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
    
    @Test
    public void testCoinReturnReturnsChangeAfterOrderCompletion(){
        setup();
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("quarter");
        v.insertCoin("dime");
        v.insertCoin("dime");
        v.insertCoin("dime");
        v.requestItem("cola");
        assertEquals("Nickel", v.returnCoins());
    }
    
    @Test
    public void testHavingSoldOutDisplayedIfRanOutOfCola(){
        setup();
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("quarter");
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("quarter");
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("quarter");
        v.requestItem("cola");
        v.requestItem("cola");
        v.requestItem("cola");
        assertEquals("SOLD OUT", v.display());
    }
    
    @Test
    public void testHavingSoldOutDisplayedIfRanOutOfColaAfterBuyingChips(){
        setup();
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("quarter");
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("quarter");
        v.insertCoin("Quarter");
        v.insertCoin("Quarter");
        v.insertCoin("quarter");
        v.insertCoin("quarter");
        v.insertCoin("quarter");
        v.requestItem("cola");
        v.requestItem("chips");
        v.requestItem("cola");
        v.requestItem("cola");
        assertEquals("SOLD OUT", v.display());
    }
    
    @Test
    public void testInsertCoinDisplayedIfRanOutOfColaAndDisplayAlreadyCheckedAndNoCoinsAreLeft(){
        setup();
        v.setItemAmount("cola", 0);
        v.requestItem("cola");
        v.display();
        assertEquals("INSERT COINS", v.display());
    }
    
    @Test
    public void testDisplayAmountIfRanOutOfColaAndDisplayAlreadyChecked(){
        setup();
        v.setItemAmount("cola", 0);
        v.insertCoin("nickel");
        v.requestItem("cola");
        v.display();
        assertEquals("0.05", v.display());
    }
    
    @Test
    public void testMachineShouldDisplayExactChangeOnlyIfItCannotMakeChange(){
        setup();
        v.setChangeAmount("nickel", 0);
        assertEquals("EXACT CHANGE ONLY", v.display());
    }
    
    @Test
    public void testMachineLosingCoinsUntilItCantMakeChangeThenItShouldDisplayExactChangeOnly(){
        setup();
        v.setChangeAmount("Nickel", 2);
        v.insertCoin("dime");
        v.insertCoin("dime");
        v.insertCoin("dime");
        v.insertCoin("quarter");
        v.requestItem("chips");
        v.returnCoins();
        v.insertCoin("dime");
        v.insertCoin("dime");
        v.insertCoin("dime");
        v.insertCoin("quarter");
        v.requestItem("chips");
        v.returnCoins();
        v.display();
        assertEquals("EXACT CHANGE ONLY", v.display());
    }
    
    @Test
    public void testMachineStartingWithNotEnoughChangeAndGainingEnoughCoins(){
        setup();
        v.setChangeAmount("Nickel", 0);
        assertEquals("EXACT CHANGE ONLY", v.display());
        v.insertCoin("Nickel");
        v.insertCoin("Dime");
        v.insertCoin("quarter");
        v.insertCoin("quarter");
        v.requestItem("candy");
        v.display();
        assertEquals("INSERT COINS", v.display());
    }
}
