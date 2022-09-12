package views;

import controller.CustomerManager;
import controller.RoomManager;
import controller.ServiceManager;
import model.customer.Customer;
import model.room.GrandRoom;
import model.room.Room;
import model.room.StandardRoom;
import model.room.SuiteRoom;
import model.service.Service;
import storage.customermanager.RNWCustomerManager;
import storage.roommanager.RNWRoomManager;
import storage.servicemanager.RNWServiceManager;
import views.menu.LogIn;
import views.menu.Menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static final int FIRSTCHOSEN = 1;
    public static final int SECONDCHOSEN = 2;
    public static final int THIRDCHOSEN = 3;
    public static final int QUIT = -1;

    public static void main(String[] args) {
//        ArrayList<Room> arrayList = new ArrayList<>();
//        ArrayList<Customer> customers = new ArrayList<>();
//        ArrayList<Service> services = new ArrayList<>();
//        RNWRoomManager.writeData(arrayList);
//        RNWCustomerManager.writeData(customers);
//        RNWServiceManager.writeData(services);
        int chose;
            chose = Menu.getChoseBegin();
            whoAreYou(chose);
    }
    public static void whoAreYou(int chose) {
        switch (chose){
            case FIRSTCHOSEN -> logInAdmin();
            case SECONDCHOSEN -> logInCumtomer();
            case QUIT -> System.out.println("Out");
            default -> {
                System.out.println("Nhap 1,2 hoac -1");
                whoAreYou(Menu.getChoseBegin());
            }
        }
    }

    private static void logInCumtomer() {
        System.out.println("nhap CMND");
        Scanner scanner1 = new Scanner(System.in);
        long cmnd = scanner1.nextLong();
        if (checkCustomerLogin(cmnd, CustomerManager.getCustomerList())) methodCustomer(cmnd);
        else {
            System.out.println("sai cmnd");
            int chose = Menu.getChoseBegin();
            whoAreYou(chose);
        }
    }

    private static void methodCustomer(long cmnd) {
        System.out.println("Order do an");
        ServiceManager.showService();
        Scanner scanner = new Scanner(System.in);
        int chose = scanner.nextInt();
        callService(chose, cmnd);
    }

    private static void callService(int chose, long cmnd) {
        if (chose <= ServiceManager.getServiceList().size()){
            System.out.println("Order thanh cong");
            addBill(chose, cmnd);
        }
    }

    private static void addBill(int chose, long cmnd) {
        CustomerManager.addBillService(chose,cmnd);
        RNWCustomerManager.writeData(CustomerManager.getCustomerList());
    }

    private static boolean checkCustomerLogin(long cmnd, List<Customer> customerList) {
        for (Customer customer : customerList) {
            if (customer.getIdentityCard() == cmnd)
                return true;
        }
        return false;
    }

    private static void logInAdmin() {
        if (LogIn.logInAdmin())
            methodAdmin();
        else { System.out.println("Sai");
            logInAdmin();}
    }

    private static void methodAdmin() {
        int chose = Menu.methodAdmin();
        choseMethodAdmin(chose);
    }

    private static void choseMethodAdmin(int chose) {
        switch (chose){
            case FIRSTCHOSEN -> methodRoomManager();
            case SECONDCHOSEN -> methodCustomerManager();
            case THIRDCHOSEN -> methodServiceManager();
            default -> System.out.println("nhap 1 hoac 2 hoac 3");
        }
    }

    private static void methodServiceManager() {
        int chose = Menu.methodServiceManager();
        choseMethodSevice(chose);
    }

    private static void choseMethodSevice(int chose) {
        switch (chose){
            case FIRSTCHOSEN -> createSevice();
            case SECONDCHOSEN -> deleteService();
            default -> {
                System.out.println("Nhap 1 hoac 2");
                methodServiceManager();
            }
        }
    }

    private static void deleteService() {
        System.out.println("Chon");
        ServiceManager.showService();
        Scanner scanner = new Scanner(System.in);
        int chose = scanner.nextInt();
        if (chose <= ServiceManager.getServiceList().size()){
            ServiceManager.deleteService(chose);
            System.out.println("da xoa");
        }
        else {
            System.out.println("nhap sai");
            deleteService();
        }
        RNWServiceManager.writeData(ServiceManager.getServiceList());
    }

    private static void createSevice() {
        System.out.println("Nhap ten");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Nhap gia");
        Scanner scanner1 = new Scanner(System.in);
        double cost = scanner1.nextDouble();
        ServiceManager.addService(new Service(name,cost));
        RNWServiceManager.writeData(ServiceManager.getServiceList());
    }

    private static void methodCustomerManager() {
        int chose = Menu.methodCustomerManager();
        choseMethodCustomerManager(chose);
    }

    private static void choseMethodCustomerManager(int chose) {
        switch (chose){
            case FIRSTCHOSEN -> creatCumtomerCheckIn();
            case SECONDCHOSEN -> customerCheckOut();
            default -> {
                System.out.println("chon 1 hoac 2");
                methodCustomerManager();
            }
        }
    }

    private static void customerCheckOut() {
        int chose;
        do {
            chose = Menu.choseCheckOut();
            switch (chose){
                case 1 -> checkOutOneGuy();
                case 2 -> System.out.println("Da thoat");
                default -> System.out.println("nhap 1 hoac 2");
            }
        }while (chose !=2);

    }

    private static void checkOutOneGuy() {
        System.out.println("Nhap cmnd");
        Scanner scanner = new Scanner(System.in);
        long cmnd = scanner.nextLong();
        boolean check = false;
        int index = CustomerManager.findCustomerByCmnd(cmnd);
            if (index != -1)   check = true;
            if (check)
        {

            Room tempRoom = CustomerManager.getCustomerList().get(index).getRoom();
            int indexInRoom = findIndexInRoom(tempRoom, cmnd);
            System.out.println("Bill la: " + tempRoom.calculateBill());
            tempRoom.getServiceList().clear();
            tempRoom.getCustomerList().remove(indexInRoom);
            CustomerManager.getCustomerList().remove(index);
            if (tempRoom.getCustomerList().size() == 0) {tempRoom.setEmpty(true);
            tempRoom.setDayCheckIn(null);
            tempRoom.getCustomerList().clear();
            }
            System.out.println("Check out done");
        }
        else System.out.println("khong check out duoc");
        RNWCustomerManager.writeData(CustomerManager.getCustomerList());
        RNWRoomManager.writeData(RoomManager.getListRoom());
    }

    private static int findIndexInRoom(Room room, long cmnd) {
        int index = -1;
        for (int i = 0; i < room.getCustomerList().size(); i++) {
            if (room.getCustomerList().get(i).getIdentityCard() == cmnd)
            {index = i;
            break;}
        }
        return index;
    }

    private static void creatCumtomerCheckIn() {
        int chose = Menu.choseTypeRoom();
        if (chose >0 && chose <4)
        choseTypeRoom(chose);
        else {System.out.println("nhap lai");
                creatCumtomerCheckIn();
        }
        Scanner scanner2 = new Scanner(System.in);
        String nameRoom = scanner2.nextLine();
        boolean check = false;
        int index = RoomManager.findRoomByName(nameRoom);
        if (index != -1) check = true;
        if (check) {
            checkInMoreOne(index, chose);
        }
        else {System.out.println("Nhap sai phong");
        creatCumtomerCheckIn();
        }
    }
    private static void checkInMoreOne(int index, int chose) {
        if (chose == 1){
            for (int i =0; i<4;i++){
                createOneCustomer(index, i);
            }
        }
        else if (chose == 2 || chose == 3){
            for (int i=0; i < 2; i++){
                createOneCustomer(index, i);
            }

        }
        LocalDate dayCheckIn = Menu.creatDayCheckIn();
        RoomManager.getListRoom().get(index).setDayCheckIn(dayCheckIn);
        System.out.println("Check in done");
        RNWRoomManager.writeData(RoomManager.getListRoom());
        RNWCustomerManager.writeData(CustomerManager.getCustomerList());
    }

    private static void createOneCustomer(int index, int i) {
        Customer customer1 = Menu.createOneCustomer(index,i);
        RoomManager.getListRoom().get(index).setEmpty(false);
        CustomerManager.addCumtomer(customer1);
        RoomManager.getListRoom().get(index).getCustomerList().add(customer1);
    }

    private static void choseTypeRoom(int chose) {
        switch (chose){
            case 1 -> {RoomManager.showGrandRoomNull();
            System.out.println("nhap ten phong");
            }
            case 2-> {RoomManager.showStandardRoomNull();
                System.out.println("nhap ten phong");
            }
            case 3 ->{RoomManager.showSuiteRoomNull();
                System.out.println("nhap ten phong");}
        }
    }


    private static void methodRoomManager() {
        int chose = Menu.methodRoomManager();
        choseMethodRoomManager(chose);
    }

    private static void choseMethodRoomManager(int chose) {
        switch (chose){
            case FIRSTCHOSEN -> RoomManager.showRoom();
            case SECONDCHOSEN -> editRoom();
            case THIRDCHOSEN -> addRoom();
            default -> { System.out.println("nhap 1 hoac 2 hoac 3");
                methodRoomManager();
            }
        }
    }

    private static void addRoom() {
        int chose = Menu.choseTypeRoom();
        System.out.println("nhap ten phong");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Nhap gia phong");
        Scanner scanner1 = new Scanner(System.in);
        double cost = scanner1.nextDouble();
        switch (chose){
            case FIRSTCHOSEN -> RoomManager.addRoom(new GrandRoom(name, cost));
            case SECONDCHOSEN -> RoomManager.addRoom(new StandardRoom(name, cost));
            case THIRDCHOSEN -> RoomManager.addRoom(new SuiteRoom(name, cost));
            default -> {
                System.out.println("nhap sai");
                addRoom();
            }
        }
        RNWRoomManager.writeData(RoomManager.getListRoom());
        RNWCustomerManager.writeData(CustomerManager.getCustomerList());
    }

    private static void editRoom() {
        RoomManager.showRoom();
        boolean checkNameRoom = false;
        System.out.println("Nhap ten phong muon sua");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int index = RoomManager.findRoomByName(name);
        if (index != -1) checkNameRoom = true;
        if (checkNameRoom) whatEdit(index);
        else System.out.println("khong co phong nay");
        RNWRoomManager.writeData(RoomManager.getListRoom());
        RNWCustomerManager.writeData(CustomerManager.getCustomerList());
    }

    private static void whatEdit(int index) {
        int chose;
        chose = Menu.whatEditRoom();
        chosenEditRoom(chose, index);

    }
    private static void chosenEditRoom(int chose, int index) {
        switch (chose){
            case FIRSTCHOSEN -> {
                System.out.println("Gia tien muon sua");
                Scanner scanner = new Scanner(System.in);
                double cost = scanner.nextDouble();
                RoomManager.getListRoom().get(index).setCost(cost);
            }
            case SECONDCHOSEN -> {
                System.out.println("Ten sua thanh");
                Scanner scanner1 = new Scanner(System.in);
                String name = scanner1.nextLine();
                RoomManager.getListRoom().get(index).setName(name);
            }
            default -> {System.out.println("Chon 1 hoac 2");
            chosenEditRoom(chose, index);}
        }
        RNWRoomManager.writeData(RoomManager.getListRoom());
        RNWCustomerManager.writeData(CustomerManager.getCustomerList());
    }
}
