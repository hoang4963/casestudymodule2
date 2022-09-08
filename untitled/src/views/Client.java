package views;

import controller.RoomManager;
import model.user.User;

import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int chose;
        do {
            System.out.println("Ban la ai?( nhap 1, 2 hoac -1");
            System.out.println("1. Quan ly");
            System.out.println("2. Khach hang");
            System.out.println("Nhap -1 de thoat");
            Scanner scanner = new Scanner(System.in);
            chose = scanner.nextInt();
            whoAreYou(chose);
        } while (chose != -1);
    }

    private static void whoAreYou(int chose) {
        switch (chose){
            case 1 -> logInAdmin();
            case 2 -> logInCumtomer();
            default -> System.out.println("Nhap 1,2 hoac -1");
        }
    }

    private static void logInCumtomer() {
        System.out.println("nhap CMND");
        Scanner scanner1 = new Scanner(System.in);
        long cmnd = scanner1.nextLong();
    }

    private static void logInAdmin() {
        System.out.println("nhap ten dang nhap");
        Scanner scanner1 = new Scanner(System.in);
        String account = scanner1.nextLine();
        System.out.println("nhap mat khau ( dang so )");
        Scanner scanner2 = new Scanner(System.in);
        int password = scanner2.nextInt();
        if (checkAccountAdmin(account,password))
            methodAdmin();
    }

    private static void methodAdmin() {
        System.out.println("1. Quan ly phong");
        System.out.println("2. Ve khach hang");
        System.out.println("3. Them sua xoa cac dich vu");
        Scanner scanner = new Scanner(System.in);
        int chose = scanner.nextInt();
        choseMethodAdmin(chose);
    }

    private static void choseMethodAdmin(int chose) {
        switch (chose){
            case 1 -> methodRoomManager();
            case 2 -> methodCustomerManager();
            case 3 -> methodServiceManager();
            default -> System.out.println("nhap 1 hoac 2 hoac 3");
        }
    }

    private static void methodRoomManager() {
        System.out.println("1. Show phong");
        System.out.println("2. Chinh sua phong");
        Scanner scanner = new Scanner(System.in);
        int chose = scanner.nextInt();
        choseMethodRoomManager(chose);
    }

    private static void choseMethodRoomManager(int chose) {
        switch (chose){
            case 1 -> showRoom();
            case 2 -> editRoom();
            default -> System.out.println("nhap 1 hoac 2");
        }
    }

    private static void showRoom() {
        for (int i = 0; i < RoomManager.getListRoom().size(); i++){
            System.out.println(RoomManager.getListRoom().get(i));
        }
    }

    private static boolean checkAccountAdmin(String account, int password) {
        return Objects.equals(User.getACCOUNT(), account) && User.getPASSWORD() == password;
    }
}
