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
public class ItemTest {
    
    private Item one;
    private void setup(){
        one = new Item();
    }
    
    @Test
    public void testSettingValueOfItemAsOne() {
        setup();
        one.setValue(1.00);
        assertEquals(1.00, one.getValue(), 0);
    }
    
    @Test
    public void testSettingValueOfItemAsFiftyCents(){
        setup();
        one.setValue(0.50);
        assertEquals(0.50, one.getValue(), 0);
    }
    
    @Test
    public void testSettingNameToCola(){
        setup();
        one.setName("cola");
        assertEquals("cola", one.getName());
    }
    
    @Test
    public void testSettingNameToChips(){
        setup();
        one.setName("chips");
        assertEquals("chips", one.getName());
    }
    
}
