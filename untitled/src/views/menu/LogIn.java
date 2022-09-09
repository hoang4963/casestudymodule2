package views.menu;

import model.user.User;

import java.util.Scanner;

public class LogIn {
    private LogIn(){}
    public static boolean logInAdmin() {
        System.out.println("nhap ten dang nhap");
        Scanner scanner1 = new Scanner(System.in);
        String account = scanner1.nextLine();
        System.out.println("nhap mat khau (dang so)");
        Scanner scanner2 = new Scanner(System.in);
        int password = scanner2.nextInt();
        if (User.checkAccountAdmin(account,password))
            return true;
        else {System.out.println("Sai");
            logInAdmin();
        }
        return false;
    }
}
