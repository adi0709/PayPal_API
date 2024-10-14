package pojo;

public class PurchaseUnit {

    private Amount amount;

    //Constructor
    public PurchaseUnit(String currencyCode, String value) {
        this.amount = new Amount(currencyCode, value);
    }

    //Getter
    public Amount getAmount() {
        return amount;
    }

    //Setter
    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
