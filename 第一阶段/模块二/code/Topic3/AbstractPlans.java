package com.homework.Stage1.Section2.Topic3;

public abstract class AbstractPlans {

    private int PricePerMonth;

    public AbstractPlans() {
    }

    public AbstractPlans(int pricePerMonth) {
        setPricePerMonth(PricePerMonth);
    }

    public abstract void show();

    public int getPricePerMonth() {
        return PricePerMonth;
    }

    public void setPricePerMonth(int pricePerMonth) {
        PricePerMonth = pricePerMonth;
    }


}
