package vendingmachinekata;

public class VendingMachine {

    private Integer currentPaid = 0;
    private String currentDisplay;

    public VendingMachine() {

    }

    public void insertCoin(String coin) {
        int value = checkValue(coin);
        if (value == 1) {
            currentDisplay = "Not a valid coin.";
        } else {
            currentPaid += value;
            currentDisplay = currentPaid.toString();
        }
    }

    public int getAmountPaid() {

        return currentPaid;
    }

//    public static void main(String[] args) {
//    }
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

}
