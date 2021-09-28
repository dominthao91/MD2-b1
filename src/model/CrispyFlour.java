package model;

import java.time.LocalDate;

public class CrispyFlour extends Material {
    private double quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(double quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }


    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost) {
        super(id, name, manufacturingDate, cost);
    }

    @Override
    public double getAmount() {
        return quantity * getCost() * 95 / 100;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusMonths(12);
    }

    @Override
    public double getRealMoney(int index) {
        return 0;
    }
}
