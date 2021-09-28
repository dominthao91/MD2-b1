package controller;

import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaterialManager implements Discount {
    private List<Material> materials = new ArrayList<>();

    public void addMeatMaterial(Meat meat) {
        materials.add(meat);

    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public void addCrípyFlourMaterial(CrispyFlour crispyFlour) {
        materials.add(crispyFlour);
    }

    public void disPlay() {
        for (Material materrial : materials) {
            System.out.println(materrial);
        }
    }

    public void removeMaterial(int index) {
        materials.remove(index);
    }

    public void updateMeat(int index, Meat meat) {
        materials.set(index, meat);
    }

    public void updateCrispyFlour(int index, CrispyFlour crispyFlour) {
        materials.set(index, crispyFlour);
    }

    public boolean checkMeterial(int index) {
        Material material = materials.get(index);
        if (material instanceof Meat) {
            return true;
        }
        return false;
    }

    public boolean checkIndex(int index) {
        if (index >= 0 && index < materials.size()) {
            return true;
        }
        return false;
    }

    @Override
    public double getRealMoney(int index) {
        double realMoney = 0;
        boolean check = checkIndex(index);
        if (check) {
            Material material = materials.get(index);
            if (material instanceof Meat) {
                if (material.getExpiryDate().isAfter(LocalDate.now().plusDays(5))) {
                    realMoney = material.getAmount() * 70 / 100;
                } else if (material.getExpiryDate().isAfter(LocalDate.now().plusDays(3))) {
                    realMoney = material.getAmount() * 50 / 100;
                } else {
                    realMoney = material.getAmount();
                }
            } else {
                if (material.getExpiryDate().isAfter(LocalDate.now().plusMonths(4))) {
                    realMoney = material.getAmount() * 80 / 100;
                } else if (material.getExpiryDate().isAfter(LocalDate.now().plusMonths(2))) {
                    realMoney = material.getAmount() * 60 / 100;
                } else {
                    realMoney = material.getAmount();
                }
            }
        } else {
            System.err.println("Không tìm thấy");
        }
        return realMoney;
    }
}
