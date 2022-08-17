package material;

import java.time.LocalDate;

import date.CalculateDate;

public class Meat extends Material implements Discount {
    double weight;
    public Meat(){

    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    LocalDate getExpiryDate(){
        return manufacturingDate.plusDays(7);
    }
    @Override
    public double getAmount(){
        return weight*cost;
    }

    @Override
    public double getRealMoney() {
        if (getRealValue())
            return 0.7*getAmount();
        else return 0.9*getAmount();
    }
    public boolean getRealValue(){
        LocalDate now = LocalDate.now();
        return CalculateDate.calculateDays(getExpiryDate().getDayOfMonth(),getExpiryDate().getMonthValue(),getExpiryDate().getYear()) - CalculateDate.calculateDays(now.getDayOfMonth(),now.getMonthValue(),now.getYear()) <= 5;
    }
}