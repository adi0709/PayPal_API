package pojo;

import java.util.ArrayList;

public class Orders {
    private String intent;
    private ArrayList<PurchaseUnit> purchase_units;

    //Constructor
    public Orders(String intent, ArrayList<PurchaseUnit> purchase_units) {
        this.intent = intent;
        this.purchase_units = purchase_units;
    }

    //Getters
    public String getIntent() {
        return intent;
    }

    public ArrayList<PurchaseUnit> getPurchase_units() {
        return purchase_units;
    }

    //Setters

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public void setPurchase_units(ArrayList<PurchaseUnit> purchase_units) {
        this.purchase_units = purchase_units;
    }
}
