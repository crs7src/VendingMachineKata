package vendingmachinekata;

import java.util.ArrayList;

public class VendingMachine {

    private Double currentPaid = 0.0;
    private String currentDisplay;
    private ArrayList<String> coinReturn;
    private boolean coinAllowed;
    private final Item cola = new Item(1.00, "cola");
    private final Item chips = new Item(0.50, "chips");
    private final Item candy = new Item(0.65, "candy");
    private Item itemRequested;
    public Item dispenser = null;

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
            if(itemRequested != null && itemRequested.getValue()<=currentPaid){
                returnItem();
            }
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
            currentDisplay = String.format("%.2f", currentPaid);
        }else if(itemRequested == null){
            currentDisplay = "THANK YOU";
        }
    }
    
    public void requestItem(String product){
        if(product.toUpperCase().equals(cola.getName().toUpperCase())){
            itemRequested = cola;
            if(currentPaid >= cola.getValue()){
                returnItem();
            }
        }else if(product.toUpperCase().equals(chips.getName().toUpperCase())){
            itemRequested = chips;
            if(currentPaid >= chips.getValue()){
                returnItem();
            }
        }else if(product.toUpperCase().equals(candy.getName().toUpperCase())){
            itemRequested = candy;
            if(currentPaid >= candy.getValue()){
                returnItem();
            }
        }
    }
    
    private void returnItem(){
        if(itemRequested == cola){
            dispenser = cola;
            currentPaid -= cola.getValue();
        } else if(itemRequested == chips && currentPaid >= chips.getValue()){
            dispenser = chips;
            currentPaid -= chips.getValue();
        } else if(itemRequested == candy && currentPaid >= candy.getValue()){
            dispenser = candy;
            currentPaid-= candy.getValue();
        }
    }
    
    
}
