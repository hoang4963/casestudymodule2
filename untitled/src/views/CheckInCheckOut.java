package views;

import java.util.Scanner;

public class CheckInCheckOut {
    public static void checkIn(){
        System.out.println("nhap ten");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        System.out.println("nhap so CMND");
        Scanner scanner2 = new Scanner(System.in);
        long cmnd = scanner1.nextLong();
        System.out.println("nhap phong muon thue");
        Scanner scanner3 = new Scanner(System.in);
        String roomName = scanner3.nextLine();

    }
}
