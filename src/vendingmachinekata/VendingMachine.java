package vendingmachinekata;

public class VendingMachine {

    private Integer currentPaid = 0;
    private String currentDisplay;

    public VendingMachine() {

    }

    public void insertCoin(int coin) {
        if (coin != 5 && coin != 10 && coin != 25) {
            currentDisplay = "Not a valid coin.";
        } else {
            currentPaid += coin;
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

}
