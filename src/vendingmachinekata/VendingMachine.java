package vendingmachinekata;

import java.util.ArrayList;

public class VendingMachine {

    private Integer currentPaid = 0;
    private String currentDisplay;
    private ArrayList<String> coinReturn;

    public VendingMachine() {
        coinReturn = new ArrayList();
    }

    public void insertCoin(String coin) {
        int value = checkValue(coin);
        if (value == 1) {
            currentDisplay = "Not a valid coin.";
            coinReturn.add(coin);
        } else {
            currentPaid += value;
            currentDisplay = currentPaid.toString();
        }
    }

    public int getAmountPaid() {

        return currentPaid;
    }

    public String display() {
        return currentDisplay;
    }

    private int checkValue(String coin) {
        if ("QUARTER".equals(coin.toUpperCase())) {
            return 25;
        } else if ("NICKEL".equals(coin.toUpperCase())) {
            return 5;
        } else if ("DIME".equals(coin.toUpperCase())) {
            return 10;
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

}
