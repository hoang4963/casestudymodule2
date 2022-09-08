package model.user;

import java.io.Serializable;

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
}

