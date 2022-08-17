package material;

import date.CalculateDate;
import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    int quantity;
    CrispyFlour(String id, String bot_mi, int i, int cost, int quantity){

    }
    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public double getAmount(){
        return quantity*cost;
    }
    @Override
    LocalDate getExpiryDate() {
        return manufacturingDate.plusYears(1);
    }

    @Override
    public double getRealMoney() {
        if (getRealValue())
            return 0.6*getAmount();
        else return 0.95*getAmount();
    }
    public boolean getRealValue(){
        LocalDate now = LocalDate.now();
        return CalculateDate.calculateDays(getExpiryDate().getDayOfMonth(),getExpiryDate().getMonthValue(),getExpiryDate().getYear()) - CalculateDate.calculateDays(now.getDayOfMonth(),now.getMonthValue(),now.getYear()) <= 120;
    }
}