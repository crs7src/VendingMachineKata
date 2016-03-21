package vendingmachinekata;

import java.util.ArrayList;

public class VendingMachine {

    public int[] coins = new int[3];
    private Double currentPaid = 0.0;
    private String currentDisplay;
    private ArrayList<String> coinReturn = new ArrayList();
    private boolean coinAllowed = true;
    private final Item cola = new Item(1.00, "cola", 2);
    private final Item chips = new Item(0.50, "chips", 2);
    private final Item candy = new Item(0.65, "candy", 2);
    private Item itemRequested;
    private boolean soldOut = false;
    private boolean cannotProvideChange;
    public Item dispenser = null;

    public VendingMachine() {
        for (int i = 0; i < 3; i++) {
            coins[i] = 4;
        }
    }

    public void insertCoin(String coin) {
        double value = checkValue(coin);
        if (value == 1) {
            coinAllowed = false;
            coinReturn.add(coin);
        } else {
            coinReturn.add(coin);
            coinAllowed = true;
            currentPaid += value;
            if (itemRequested != null && itemRequested.getValue() <= currentPaid) {
                returnItem();
            }
        }
    }

    public double getAmountPaid() {
        return currentPaid;
    }

    public String display() {
        checkCoins();
        updateDisplay();
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
        if (coinReturn.isEmpty() && currentPaid == 0) {
            return "Nothing";
        } else if (coinReturn.isEmpty()) {
            makeChange();
        }
        String returningCoins = coinReturn.get(0);
        removeCoinsFromStorage();
        for (int i = 1; i < coinReturn.size(); i++) {
            returningCoins += ", " + coinReturn.get(i);
        }
        currentPaid = 0.0;
        coinReturn.clear();
        return returningCoins;
    }

    private void removeCoinsFromStorage() {
        for (int i = 0; i < coinReturn.size(); i++) {
            if (coinReturn.get(i).toUpperCase().equals("QUARTER")) {
                coins[2]--;
            } else if (coinReturn.get(i).toUpperCase().equals("DIME")) {
                coins[1]--;
            } else if (coinReturn.get(i).toUpperCase().equals("NICKEL")) {
                coins[0]--;
            }
        }

    }

    public void setItemAmount(String item, int amount) {
        if (item.toUpperCase().equals(cola.getName().toUpperCase())) {
            cola.setQuantity(amount);
        } else if (item.toUpperCase().equals(chips.getName().toUpperCase())) {
            chips.setQuantity(amount);
        } else if (item.toUpperCase().equals(candy.getName().toUpperCase())) {
            candy.setQuantity(amount);
        }
    }

    private void updateDisplay() {
        if (soldOut) {
            currentDisplay = "SOLD OUT";
            itemRequested = null;
            soldOut = false;
        } else if (!coinAllowed) {
            currentDisplay = "Not a valid coin.";
            coinAllowed = true;
        } else if (currentPaid != 0) {
            currentDisplay = String.format("%.2f", currentPaid);
        } else if (itemRequested != null) {
            currentDisplay = "THANK YOU";
            itemRequested = null;
        } else if (cannotProvideChange) {
            currentDisplay = "EXACT CHANGE ONLY";
        } else {
            currentDisplay = "INSERT COINS";
        }
    }

    public void requestItem(String product) {
        if (product.toUpperCase().equals(cola.getName().toUpperCase())) {
            itemRequested = cola;
            processItemRequest();
        } else if (product.toUpperCase().equals(chips.getName().toUpperCase())) {
            itemRequested = chips;
            processItemRequest();
        } else if (product.toUpperCase().equals(candy.getName().toUpperCase())) {
            itemRequested = candy;
            processItemRequest();
        }
    }

    public void processItemRequest() {
        if (itemRequested.getQuantity() == 0) {
            soldOut = true;
        }
        if (currentPaid >= itemRequested.getValue()) {
            returnItem();
        }
    }

    private void returnItem() {
        if (!soldOut && (!cannotProvideChange || currentPaid == itemRequested.getValue())) {
            itemRequested.setQuantity(itemRequested.getQuantity() - 1);
            dispenser = itemRequested;
            coinReturn.clear();
            currentPaid -= itemRequested.getValue();
        }
    }

    private void makeChange() {
        double change = currentPaid;
        if (change >= .25) {
            coinReturn.add("Quarter");
            change -= .25;
        } else if (change >= .1) {
            coinReturn.add("Dime");
            change -= .10;
        } else if (change >= .05) {
            coinReturn.add("Nickel");
            change -= .05;
        }
    }

    private void checkCoins() {
        if (coins[0] == 0 || (coins[0] < 2 && coins[1] == 0)) {
            cannotProvideChange = true;
        }
    }

    public void setChangeAmount(String coin, int amount) {
        if ("QUARTER".equals(coin.toUpperCase())) {
            coins[2] = amount;
        } else if ("DIME".equals(coin.toUpperCase())) {
            coins[1] = amount;
        } else if ("NICKEL".equals(coin.toUpperCase())) {
            coins[0] = amount;
        }
    }
}
