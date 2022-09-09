package views.menu;

import controller.RoomManager;
import model.customer.Customer;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private Menu(){}
    public static int getChoseBegin() {
        int chose;
        System.out.println("Ban la ai?(nhap 1, 2 hoac -1)");
        System.out.println("1. Quan ly");
        System.out.println("2. Khach hang");
        System.out.println("Nhap -1 de thoat");
        Scanner scanner = new Scanner(System.in);
        chose = scanner.nextInt();
        return chose;
    }
    public static int methodAdmin(){
        System.out.println("1. Quan ly phong");
        System.out.println("2. Ve khach hang");
        System.out.println("3. Them xoa cac dich vu");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static int methodServiceManager() {
        System.out.println("1. Them");
        System.out.println("2. Xoa");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static int methodCustomerManager() {
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static int choseCheckOut(){
        System.out.println("1. Check Out");
        System.out.println("2. Done");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static int choseTypeRoom(){
        System.out.println("Chon loai phong");
        System.out.println("1.Grand");
        System.out.println("2.Standard");
        System.out.println("3.Suite");
        Scanner scanner4 = new Scanner(System.in);
        return scanner4.nextInt();
    }
    public static LocalDate creatDayCheckIn(){
        System.out.println("Nhap ngay check in:");
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        System.out.println("Nhap thang check in:");
        Scanner scanner1 = new Scanner(System.in);
        int month = scanner1.nextInt();
        System.out.println("Nhap nam check in");
        Scanner scanner2 = new Scanner(System.in);
        int year = scanner2.nextInt();
        return LocalDate.of(year,month,day);
    }
    public static Customer createOneCustomer(int index , int i){
        System.out.println("Nhap ten nguoi thu " + (i +1) + " (neu khong co nhap 0)");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("nhap cmnd nguoi thu " + (i +1) + " (neu khong co nhap 0)");
        Scanner scanner1 = new Scanner(System.in);
        long cmnd = scanner1.nextLong();
        return new Customer(name, cmnd, RoomManager.getListRoom().get(index));
    }
    public static int methodRoomManager(){
        System.out.println("1. Show phong");
        System.out.println("2. Chinh sua phong");
        System.out.println("3. Them phong");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static int whatEditRoom() {
        System.out.println("1. Sua gia tien");
        System.out.println("2. Sua ten");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
