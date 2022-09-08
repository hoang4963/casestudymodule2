package model.user;

public class User {
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

