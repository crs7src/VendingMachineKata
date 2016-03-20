package vendingmachinekata;

import java.util.ArrayList;

public class VendingMachine {

    private Double currentPaid = 0.0;
    private String currentDisplay;
    private ArrayList<String> coinReturn;
    private boolean coinAllowed;

    public VendingMachine() {
        coinReturn = new ArrayList();
    }

    public void insertCoin(String coin) {
        double value = checkValue(coin);
        if (value == 1) {
            coinReturn.add(coin);
            coinAllowed = false;
        } else {
            coinAllowed = true;
            currentPaid += value;
        }
        updateDisplay();
    }

    public double getAmountPaid() {

        return currentPaid;
    }

    public String display() {
        return currentDisplay;
    }

    private double checkValue(String coin) {
        if ("QUARTER".equals(coin.toUpperCase())) {
            return .25;
        } else if ("NICKEL".equals(coin.toUpperCase())) {
            return .05;
        } else if ("DIME".equals(coin.toUpperCase())) {
            return .10;
        } else {
            return 1;
        }
    }

    public String returnCoins() {
        String coins = coinReturn.get(0);
        for (int i = 1; i < coinReturn.size(); i++) {
            coins += ", " + coinReturn.get(i);
        }
        return coins;
    }
    
    private void updateDisplay(){
        if(coinAllowed == false){
            currentDisplay = "Not a valid coin.";
        }else if(currentPaid != 0){
            currentDisplay = currentPaid.toString();
        }
    }
    
    private void requestItem(Item product){
        
    }
}
