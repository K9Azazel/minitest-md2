package testmanager;

import manager.MaterialManager;
import material.CrispyFlour;
import material.Material;
import material.Meat;

import java.time.LocalDate;

public class test {
    public static void main(String[] args) {
        CrispyFlour botMi = new CrispyFlour("1","Bot mi", LocalDate.of(2022,7,8), 10000, 5);
        CrispyFlour botGao = new CrispyFlour("2","Bot gao", LocalDate.of(2021,12,21), 10000, 4);
        CrispyFlour botTom = new CrispyFlour("3","Bot tom", LocalDate.of(2021,4,7), 10000, 3);
        CrispyFlour botNgo = new CrispyFlour("4","Bot ngo", LocalDate.of(2020,7,7), 10000, 7);
        CrispyFlour botSan = new CrispyFlour("5","Bot san", LocalDate.of(2022,1,15), 10000, 4);
        Meat thiGa = new Meat("6","Thi ga", LocalDate.of(2022,8,15), 70000, 2);
        Meat thiLon = new Meat("7","Thi lon", LocalDate.of(2022,7,14), 100000, 5);
        Meat thiVit = new Meat("8","Thi vit", LocalDate.of(2022,8,12), 60000, 1);
        Meat thiCa = new Meat("9","Thi ca", LocalDate.of(2022,8,16), 80000, 3);
        Meat thiBo = new Meat("10","Thi bo", LocalDate.of(2022,7,17), 120000, 4);
        MaterialManager<Material> materialManager = new MaterialManager<>();
        materialManager.add(botMi);
        materialManager.add(botGao);
        materialManager.add(botTom);
        materialManager.add(botNgo);
        materialManager.add(botSan);
        materialManager.add(thiGa);
        materialManager.add(thiLon);
        materialManager.add(thiVit);
        materialManager.add(thiCa);
        materialManager.add(thiBo);
        System.out.println("Chenh lech tien thuc te trong ngay la: ");
        System.out.println(moneyDayDifference(materialManager));
    }
    static double moneyDayDifference(MaterialManager material){
        return getSum(material) - getSumReal(material);
    }
    static double getSum(MaterialManager material){
        double sum =0.0;
        for (int i = 0; i < material.size(); i++) {
            if (material.get(i) instanceof CrispyFlour){
                CrispyFlour crispyFlour = (CrispyFlour) material.get(i);
                sum += crispyFlour.getAmount();
            }
            else {
                Meat meat = (Meat) material.get(i);
                sum+= meat.getAmount();
            }
        }
        return sum;
    }
    static double getSumReal(MaterialManager material){
        double sumReal = 0.0;
        for (int i = 0; i < material.size(); i++) {
            if (material.get(i) instanceof CrispyFlour){
                CrispyFlour crispyFlour = (CrispyFlour) material.get(i);
                sumReal+= crispyFlour.getRealMoney();
            }
            else {
                Meat meat = (Meat) material.get(i);
                sumReal+= meat.getRealMoney();
            }
        }
        return sumReal;
    }
}