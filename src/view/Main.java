package view;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static MaterialManager materialManager = new MaterialManager();

    public static void main(String[] args) {
        Meat meat = new Meat("1", "chó", LocalDate.of(2021, 9, 25), 10000, 15);
        Meat meat1 = new Meat("2", "mèo", LocalDate.of(2021, 9, 24), 10000, 50);
        Meat meat2 = new Meat("3", "lợn", LocalDate.of(2021, 9, 22), 10000, 5);
        Meat meat3 = new Meat("4", "gà", LocalDate.of(2021, 9, 23), 10000, 50);
        Meat meat4 = new Meat("5", "dê", LocalDate.of(2021, 9, 24), 10000, 25);
        CrispyFlour crispyFlour = new CrispyFlour("6", "lúa", LocalDate.of(2021, 7, 20), 2000, 100);
        CrispyFlour crispyFlour1 = new CrispyFlour("7", "ngô", LocalDate.of(2021, 8, 10), 2000, 100);
        CrispyFlour crispyFlour2= new CrispyFlour("8", "khoai", LocalDate.of(2021, 5, 30), 2000, 100);
        CrispyFlour crispyFlour3 = new CrispyFlour("9", "sắn", LocalDate.of(2021, 6, 25), 2000, 100);
        CrispyFlour crispyFlour4 = new CrispyFlour("10", "đậu", LocalDate.of(2021, 7, 26), 2000, 100);

        List<Material> materialList = new ArrayList<>();
        materialManager.setMaterials(materialList);
        materialManager.addMeatMaterial(meat);
        materialManager.addMeatMaterial(meat1);
        materialManager.addMeatMaterial(meat2);
        materialManager.addMeatMaterial(meat3);
        materialManager.addMeatMaterial(meat4);
        materialManager.addCrípyFlourMaterial(crispyFlour);
        materialManager.addCrípyFlourMaterial(crispyFlour1);
        materialManager.addCrípyFlourMaterial(crispyFlour2);
        materialManager.addCrípyFlourMaterial(crispyFlour3);
        materialManager.addCrípyFlourMaterial(crispyFlour4);

        int choice;
        do {
            menu();
            System.out.println("Mời lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    display();
                    break;
                }
                case 2: {
                    addMeterial();
                    break;
                }
                case 3: {
                    removeMaterial();
                    break;
                }
                case 4: {
                    updeteMeterial();
                    break;
                }
                case 5: {
                    calculatorMoney();
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }

        } while (choice != 0);

    }

    private static void calculatorMoney() {
        System.out.println("Nhập vị trí muốn tính tiền");
        int index = scanner.nextInt();
        double money = materialManager.getRealMoney(index);
        System.out.println("Tổng tiền = " + money);
    }

    private static void updeteMeterial() {
        System.out.println("Nhập vị trí muốn sửa");
        int index = scanner.nextInt();
        scanner.nextLine();
        boolean checkIndex = materialManager.checkIndex(index);
        if (checkIndex) {
            boolean check = materialManager.checkMeterial(index);
            if (check) {
                Meat meat = createMeat();
                materialManager.updateMeat(index, meat);
            } else {
                CrispyFlour crispyFlour = createCrispyFlour();
                materialManager.updateCrispyFlour(index, crispyFlour);
            }
        } else {
            System.err.println("Không tìm thấy");
        }
    }

    private static void removeMaterial() {
        System.out.println("nhập vị trí muốn xóa");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < materialManager.getMaterials().size()) {
            materialManager.removeMaterial(index);
        } else {
            System.err.println("Không tìm thấy");
        }
    }


    private static void addMeterial() {

        int choice;
        do {
            munus();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    Meat meat = createMeat();
                    materialManager.addMeatMaterial(meat);
                    break;
                }
                case 2: {
                    CrispyFlour crispyFlour = createCrispyFlour();
                    materialManager.addCrípyFlourMaterial(crispyFlour);

                    break;
                }
                case 0: {
                    break;
                }

            }
        } while (choice != 0);
    }

    private static void munus() {
        System.out.println("menu");
        System.out.println("1. Thêm thịt");
        System.out.println("2. Thêm bột");
        System.out.println("0. Quay lại");
    }

    private static Meat createMeat() {
        System.out.print("Enter id material meat : ");
        String id = scanner.nextLine();
        System.out.print("Enter name material meat : ");
        String name = scanner.nextLine();
        System.out.println("Enter manufacturing date : ");
        System.out.print("Enter year : ");
        int year = scanner.nextInt();
        System.out.print("Enter month : ");
        int month = scanner.nextInt();
        System.out.print("Enter day : ");
        int day = scanner.nextInt();
        LocalDate manufacturingDate = LocalDate.of(year, month, day);
        System.out.print("Enter meat cost : ");
        int cost = scanner.nextInt();
        System.out.print("Enter meat weight : ");
        double weight = scanner.nextDouble();
        Meat meat = new Meat(id, name, manufacturingDate, cost, weight);
        return meat;
    }

    private static CrispyFlour createCrispyFlour() {
        System.out.print("Enter id material crispy flour : ");
        String id = scanner.nextLine();
        System.out.print("Enter name material crispy flour : ");
        String name = scanner.nextLine();
        System.out.println("Enter manufacturing date : ");
        System.out.print("Enter year : ");
        int year = scanner.nextInt();
        System.out.print("Enter month : ");
        int month = scanner.nextInt();
        System.out.print("Enter day : ");
        int day = scanner.nextInt();
        LocalDate manufacturingDate = LocalDate.of(year, month, day);
        System.out.print("Enter crispy flour cost : ");
        int cost = scanner.nextInt();
        System.out.print("Enter crispy flour quantity: ");
        double quantity = scanner.nextDouble();
        CrispyFlour crispyFlour = new CrispyFlour(id, name, manufacturingDate, cost, quantity);
        return crispyFlour;
    }

    private static void display() {
        materialManager.disPlay();
    }

    private static void menu() {
        System.out.println("Menu");
        System.out.println("1. Hiển thị");
        System.out.println("2. thêm");
        System.out.println("3. Xóa");
        System.out.println("4. Sửa");
        System.out.println("5. Tính tiền");
        System.out.println("0. Thoát");
    }
}
