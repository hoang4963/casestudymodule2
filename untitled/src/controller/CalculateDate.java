package controller;

import java.io.Serializable;
import java.time.LocalDate;

public class CalculateDate implements Serializable {
    public static boolean checkPrimeYear(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
    public static int dayOfMonth(int month, int year){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:if (checkPrimeYear(year))
                return 29;
            else return 28;
        }
    }
    public static int calculateDaysOfYears(int year){
        int count = 0;
        for (int i = 0; i < year; i++) {
            if (checkPrimeYear(i))
                count++;
        }
        return year *365 + count;

    }
    public static int calculateDaysOfMonth(int month, int year){
        int daysOfMonth=0;
        for (int i = 0; i < month ; i++) {
            daysOfMonth += dayOfMonth(month,year);
        }
        return daysOfMonth;
    }
    public static int calculateDays(int day, int month, int year){
        return day + calculateDaysOfMonth(month,year) + calculateDaysOfYears(year);
    }
    public static int countDays(int day, int month, int year){
        LocalDate now = LocalDate.now();
        if (calculateDays(now.getDayOfMonth(),now.getMonthValue(), now.getYear()) - calculateDays(day,month,year) > 1)
            return calculateDays(now.getDayOfMonth(),now.getMonthValue(), now.getYear()) - calculateDays(day,month,year);
        else return 1;
    }
}
