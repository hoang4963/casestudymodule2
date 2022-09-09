package model.user;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static final String ACCOUNT = "admin";
    private static final int PASSWORD = 1703;

    private User() {
    }

    public static String getACCOUNT() {
        return ACCOUNT;
    }

    public static int getPASSWORD() {
        return PASSWORD;
    }
    public static boolean checkAccountAdmin(String account, int password) {
        return Objects.equals(User.getACCOUNT(), account) && User.getPASSWORD() == password;
    }
}


