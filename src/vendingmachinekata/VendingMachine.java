/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vendingmachinekata;

/**
 * @Caleb Smith
 * @CS 1180
 * @Miss Starkey
 * @Wyatt Dunn
 */
public class VendingMachine {
    
    private Integer currentPaid = 0;

    public VendingMachine() {
        
    }
    public void insertCoin(int coin){
        currentPaid += coin;
    }
    public String getAmountPaid(){
        return currentPaid.toString();
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }

}
