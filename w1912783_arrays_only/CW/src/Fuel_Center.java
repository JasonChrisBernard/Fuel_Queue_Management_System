import java.util.Arrays;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;
import java.io.FileNotFoundException;
public class Fuel_Center {
    static int fuel_stock=6660;
    public static void main(String[] args) {

        String[] fuel_que_1 = {"~", "~", "~", "~", "~", "~"};
        String[] fuel_que_2 = {"~", "~", "~", "~", "~", "~"};
        String[] fuel_que_3 = {"~", "~", "~", "~", "~", "~"};


        while (true) {
            Fuel_station();
            Scanner opt_f = new Scanner(System.in);
            System.out.println("Enter a option :");
            String opt = opt_f.nextLine();

            if (opt.equals("100") || opt.equals("VFQ")) {
                Fuel_Queues(fuel_que_3, fuel_que_2, fuel_que_1);

            } else if (opt.equals("101") || opt.equals("VEQ")) {
                Fuel_Empty(fuel_que_3, fuel_que_2, fuel_que_1);

            } else if (opt.equals("102") || opt.equals("ACQ")) {
                add_c(fuel_que_3, fuel_que_2, fuel_que_1);


            } else if (opt.equals("103") || opt.equals("RCQ")) {
                remove_c(fuel_que_3, fuel_que_2, fuel_que_1);

                Fuel_Queues(fuel_que_3, fuel_que_2, fuel_que_1);
            } else if (opt.equals("104") || opt.equals("PCQ")){
                remove_sc(fuel_que_3, fuel_que_2, fuel_que_1);

                Fuel_Queues(fuel_que_3, fuel_que_2, fuel_que_1);
            } else if (opt.equals("105") || opt.equals("VCS")){
                alphabetical_order(fuel_que_3, fuel_que_2, fuel_que_1);


            } else if (opt.equals("106") || opt.equals("SPD")){
                save_file( fuel_que_3,fuel_que_2, fuel_que_1);

            }else if (opt.equals("107") || opt.equals("LPD")){
                load_file( fuel_que_3,fuel_que_2, fuel_que_1);

            }else if (opt.equals("108") || opt.equals("STK")){
                System.out.print("Remaining fuel stock : ");
                System.out.println(fuel_stock);

            }else if (opt.equals("109") || opt.equals("AFS")){
                add_fuel();




            }
        }

    }
    public static void Fuel_station() {

        System.out.println("Fuel Queue Management System".toUpperCase());
        System.out.println();
        System.out.println("Enter the following options u would like to see :");
        System.out.println("100 or VFQ: View all Fuel Queues.");
        System.out.println("101 or VEQ: View all Empty Queues");
        System.out.println("102 or ACQ: Add customer to a Queue.");
        System.out.println("103 or RCQ: Remove a customer from a Queue.");
        System.out.println("104 or PCQ: Remove a served customer.");
        System.out.println("105 or VCS: View Customers Sorted in alphabetical order");
        System.out.println("106 or SPD: Store Program Data into file.");
        System.out.println("107 or LPD: Load Program Data from file.");
        System.out.println("108 or STK: View Remaining Fuel Stock.");
        System.out.println("109 or AFS: Add Fuel Stock.");
        System.out.println("999 or EXT: Exit the Program.");

        System.out.println();
        return;
    }


    public static void Fuel_Queues(String[] fuel_que_3, String[] fuel_que_2, String[] fuel_que_1) {
        //100 or VFQ: View all Fuel Queues.



        System.out.println("1st Pump" + "                   " + "2nd Pump" + "                  " + "3rd Pump");
        for (int i = 0; i < fuel_que_3.length; i++) { //each array's contains the same number of elements
            System.out.printf("%-30s %-10s %15s", fuel_que_1[i], fuel_que_2[i], fuel_que_3[i]);
            System.out.println();

        }
        System.out.println();
    }

    public static int Fuel_Empty(String[] fuel_que_3, String[] fuel_que_2, String[] fuel_que_1) {
        //101 or VEQ: View all Empty Queues
        System.out.print("1st Pump" + "                   " + "2nd Pump" + "                   " + " 3rd Pump");
        for (int i = 0; i < (fuel_que_3.length); i++) { //each array's contains the same number of elements
            System.out.println();
            if (fuel_que_1[i].equals("~")) {
                System.out.printf("%-30s",fuel_que_1[i]);
            }

            if (fuel_que_2[i].equals("~")) {
                System.out.printf("%-10s",fuel_que_2[i]);
            }

            if (fuel_que_3[i].equals("~")) {
                System.out.printf("%15s",fuel_que_3[i]);
            }


        }
        System.out.println();
        return 0;
    }

    public static void add_c(String[] fuel_que_3, String[] fuel_que_2, String[] fuel_que_1) {
        String[][] fuelQueues = {fuel_que_1,fuel_que_2,fuel_que_3};
        Scanner input = new Scanner(System.in);
        int pumpNum=0;
        Boolean found=true;

        System.out.println("Enter the following options:");
        System.out.println("Enter a ----> Add More customers:");
        System.out.println("Enter q ----> Back to main menu");
        loop:
        while(true){
            String opt_ac=input.nextLine();
            switch (opt_ac){
                case "a":{
                    while (true) {
                        System.out.print("Enter the pump number : ");
                        if (input.hasNextInt()) {
                            pumpNum = input.nextInt();
                            if(pumpNum>0 && pumpNum<4){
                                break;
                            }

                            else{
                                System.out.println("Invalid input");

                            }

                        }
                        else {
                            System.out.println("Invalid input");
                            input.next();

                        }
                    }
                    input.nextLine();
                    if (fuelQueues[pumpNum - 1][5].equals("~")){
                        int index = 0;
                        for(int i=0; i<(fuelQueues[pumpNum - 1].length); i++){
                            fuel_stock-=10;
                            if(fuelQueues[pumpNum - 1][i].equals("~")) {
                                index=i;
                                break;
                            }

                        }

                        System.out.print("Add the name of the Customer : ");
                        fuelQueues[pumpNum - 1][index] = input.nextLine();
                        System.out.print("Customer Successfully added");
                        System.out.println();
                        System.out.print("Remaining fuel stock : ");
                        System.out.println(fuel_stock);
                        System.out.println();
                        System.out.println("Enter the following options:");
                        System.out.println("Enter a ----> Add More customers:");
                        System.out.println("Enter q ----> Back to main menu");
                        continue;

                    } else{
                        if(fuel_stock>=500){
                            System.out.println("Warning! fuel is low");
                            System.out.print("Remaining fuel stock : ");
                            System.out.println(fuel_stock);
                            System.out.println("The pump " + pumpNum + " is full at the moment");
                            System.out.println();
                            System.out.println("Enter the following options:");
                            System.out.println("Enter a ----> Add More customers:");
                            System.out.println("Enter q ----> Back to main menu");


                        }
                        System.out.print("Remaining fuel stock : ");
                        System.out.println(fuel_stock);
                        System.out.println("The pump " + pumpNum + " is full at the moment");
                        System.out.println();
                        System.out.println("Enter the following options:");
                        System.out.println("Enter a ----> Add More customers:");
                        System.out.println("Enter q ----> Back to main menu");

                    }

                }
                case "q":{
                    break loop;
                }

                default:
                System.out.println("Invalid input");
                }

            }

        }
    public static void remove_c(String[] fuel_que_3, String[] fuel_que_2, String[] fuel_que_1){
        Scanner num=new Scanner(System.in);
        Scanner word=new Scanner(System.in);
        int el_num=0;
        System.out.println("Enter the following options:");
        System.out.println("Enter a ----> remove customers ");
        System.out.println("Enter q ----> Back to main menu");
        loop:
        while(true){
            String opt_rc=word.nextLine();
            switch (opt_rc){
                case "a":{
                    while(true) {
                        System.out.println("Enter the pump no :");
                        String opt = word.next();
                        switch(opt){
                            case "1","2","3":{
                                while (true) {
                                    System.out.println("Remove the customer form position 1 to 6 :");
                                    if (num.hasNextInt()) {
                                        el_num = num.nextInt();
                                        if(el_num>0 && el_num<7){
                                            break;
                                        }
                                        else{
                                            System.out.println("Invalid input");
                                        }

                                    } else {
                                        System.out.println("Invalid input");
                                        num.next();
                                    }
                                }

                                for (int i = 0; i < (fuel_que_1.length - 1); i++) {
                                    fuel_stock += 10;
                                    if (opt.equals("1")) {
                                        i = el_num - 1;
                                        fuel_que_1[i] = "~";
                                        for (i = el_num; i < fuel_que_1.length - 1; i++) {
                                            fuel_que_1[i] = fuel_que_1[i + 1];
                                        }


                                    } else if (opt.equals("2")) {
                                        i = el_num - 1;
                                        fuel_que_2[i] = "~";
                                        for (i = el_num; i < fuel_que_2.length - 1; i++) {
                                            fuel_que_2[i] = fuel_que_2[i + 1];
                                        }

                                    } else if (opt.equals("3")) {
                                        i = el_num - 1;
                                        fuel_que_3[i] = "~";
                                        for (i = el_num; i < fuel_que_3.length - 1; i++) {
                                            fuel_que_3[i] = fuel_que_3[i + 1];
                                        }
                                    }


                                    System.out.print("Remaining fuel stock : ");
                                    System.out.println(fuel_stock);


                                }
                                break loop;
                            }

                            default:
                                System.out.println("Invalid option pls enter the correct value");
                        }


                    }
                }

                case "q":{
                    break loop;
                }

                default:
                    System.out.println("Invalid Input");

            }
        }



    }


    public static void remove_sc(String[] fuel_que_3, String[] fuel_que_2, String[] fuel_que_1){
        Scanner word=new Scanner(System.in);
        int el_num=0;
        String opt_rrc;
        System.out.println("Enter the following options:");
        System.out.println("Enter a ----> remove customers ");
        System.out.println("Enter q ----> Back to main menu");
            loop:
            while(true) {
                opt_rrc = word.nextLine();
                switch (opt_rrc) {
                    case "a": {
                        while (true) {
                            System.out.println("Number the pump :");
                            String opt = word.nextLine();
                            switch (opt) {
                                case "1", "2", "3": {
                                    for (int i = 0; i < (fuel_que_1.length); i++) {
                                        System.out.println("Remove the served customer :".toUpperCase());
                                        if (opt.equals("1")) {
                                            i = el_num;
                                            fuel_que_1[i] = "~";
                                            for (i = el_num; i < fuel_que_1.length - 1; i++) {
                                                fuel_que_1[i] = fuel_que_1[i + 1];
                                            }


                                        } else if (opt.equals("2")) {
                                            i = el_num;
                                            fuel_que_2[i] = "~";
                                            for (i = el_num; i < fuel_que_2.length - 1; i++) {
                                                fuel_que_2[i] = fuel_que_2[i + 1];
                                            }

                                        } else if (opt.equals("3")) {
                                            i = el_num;
                                            fuel_que_3[i] = "~";
                                            for (i = el_num; i < fuel_que_3.length - 1; i++) {
                                                fuel_que_3[i] = fuel_que_3[i + 1];
                                            }

                                        }

                                    }

                                    break loop;
                                }
                                default:
                                    System.out.println("Pls Enter the correct option");
                            }

                        }
                    }

                    case "q": {
                        break loop;
                    }

                    default:
                        System.out.println("Pls Enter the correct option");
                }

            }


    }

    public static void add_fuel(){

        Scanner input = new Scanner(System.in);
        int fuel_s=0;
        System.out.println("Enter the following options:");
        System.out.println("Enter a ----> Add fuel");
        System.out.println("Enter q ----> Back to main menu");
            while (true) {
                String fuel_opt=input.nextLine();
                if (fuel_opt.equals("a")) {
                    while (true) { 
                        System.out.print("Enter the amount of fuel you want to add :");
                        if (input.hasNextInt()) {
                            fuel_s = input.nextInt();


                            break;
                        } else {
                            System.out.println("Invalid input");
                            input.next();
                        }
                    }

                    if(fuel_stock>6600){
                        System.out.println("Oops! You have reached the limit of the fuel amount");
                        System.out.println();
                        System.out.println("Enter the following options:");
                        System.out.println("Enter a ----> Add fuel:");
                        System.out.println("Enter q ----> Back to main menu");
                    }
                    else{
                        fuel_stock += fuel_s;
                        System.out.println("Fuel added Successfully!");
                        System.out.println("Fuel Stock:" + fuel_stock);
                        System.out.println();
                        System.out.println("Enter the following options:");
                        System.out.println("Enter a ----> Add fuel:");
                        System.out.println("Enter q ----> Back to main menu");
                    }

                }
                else if(fuel_opt.equals("q")){
                    break;

                }
                else{
                    continue;
                }




            }
    }



    public static void alphabetical_order(String[] fuel_que_3, String[] fuel_que_2, String[] fuel_que_1) {
        String[] n_fuel_que_1 = {"~", "~", "~", "~", "~", "~"};
        n_fuel_que_1[0]=fuel_que_1[0];


        boolean isSwapped = true;
        do {
            isSwapped = false
            ;
            for (int i = 0; i < fuel_que_1.length - 1; i++) {
                if (fuel_que_1[i].compareTo(fuel_que_1[i + 1]) > 0) {
                    String temp = fuel_que_1[i + 1];
                    fuel_que_1[i + 1] = fuel_que_1[i];
                    fuel_que_1[i] = temp;
                    isSwapped = true;
                }
            }
        } while ((isSwapped));


        for (int i = 0; i < n_fuel_que_1.length; i++) { //each array's contains the same number of elements
            n_fuel_que_1[i] = fuel_que_1[i];
            System.out.println(fuel_que_1[i]);

        }
        System.out.println();
    }
    public static void save_file(String[] fuel_que_3, String[] fuel_que_2, String[] fuel_que_1){
        try {
            System.out.println("File is Saved Successfully");
            FileWriter fuel_center_d = new FileWriter("D:\\IIT\\Degree\\2nd Semester\\Software development II (Programming)\\CW\\src\\fuel_center_d.txt");
            for (int i=0; i<fuel_que_1.length ; i++)
            {

                fuel_center_d.write(fuel_que_1[i]+"\n");

            }
            for (int i=0; i<fuel_que_1.length ; i++)
            {

                fuel_center_d.write(fuel_que_2[i]+"\n");

            }
            for (int i=0; i<fuel_que_1.length ; i++)
            {

                fuel_center_d.write(fuel_que_3[i]+"\n");

            }

            fuel_center_d.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public static void load_file(String[] fuel_que_3, String[] fuel_que_2, String[] fuel_que_1){
        try {
            System.out.println("File loaded successfully");
            int lineCount = 1;
            File fuel_center_d = new File("D:\\IIT\\Degree\\2nd Semester\\Software development II (Programming)\\CW\\src\\fuel_center_d.txt");
            Scanner rf = new Scanner(fuel_center_d);
            for (int i=0; i<fuel_que_1.length ; i++) {
                fuel_que_1[i]=rf.nextLine();

            }

            for (int i=0; i<fuel_que_1.length ; i++) {
                fuel_que_2[i]=rf.nextLine();

            }

            for (int i=0; i<fuel_que_1.length ; i++) {
                fuel_que_3[i]=rf.nextLine();

            }


            System.out.println();
        }
        catch (IOException FileNotFoundException) {
            System.out.println("An error occurred.");
            FileNotFoundException.printStackTrace();
        }


    }

}




        /*public static void add_c_2(String[] fuel_que_3, String[] fuel_que_2, String[] fuel_que_1) {
        Scanner opt_f = new Scanner(System.in);

        int index = 0;
        for (int i = 0; i < (fuel_que_2.length); i++) {
            if (fuel_que_2[i].equals("-")) {
                index = i;
                break;
            } else {
                System.out.println("Pump section is Full ");
            }
        }
        for (int i = index; i < (fuel_que_1.length); i++) {
            System.out.println("Add the name of the Customer:");
            String customer = opt_f.nextLine();
            System.out.println("Enter the pump number :");
            String pump_no = opt_f.nextLine();
            System.out.println("Enter (add) to Add more customers or Enter (quit) to exit the program :");
            String exit = opt_f.nextLine();
            if (pump_no.equals("1")) {
                if (exit.equals("quit")) {
                    fuel_que_1[i] = customer;
                    break;
                } else if (exit.equals("add")) {
                    fuel_que_1[i] = customer;
                    continue;
                }
            }


        }
    }
    public static void add_c_3(String[] fuel_que_3, String[] fuel_que_2, String[] fuel_que_1) {
        Scanner opt_f = new Scanner(System.in);


        int index = 0;
        for (int i = 0; i < (fuel_que_1.length); i++) {
            if (fuel_que_1[i].equals("-")) {
                index = i;
                break;
            } else {
                System.out.println("Pump section is Full ");
            }
        }
        for (int i = index; i < (fuel_que_1.length); i++) {
            System.out.println("Add the name of the Customer:");
            String customer = opt_f.nextLine();
            System.out.println("Enter the pump number :");
            String pump_no = opt_f.nextLine();
            System.out.println("Enter (add) to Add more customers or Enter (quit) to exit the program :");
            String exit = opt_f.nextLine();
            if (pump_no.equals("1")) {
                if (exit.equals("quit")) {
                    fuel_que_1[i] = customer;
                    break;
                } else if (exit.equals("add")) {
                    fuel_que_1[i] = customer;
                    continue;
                }
            }
        }
    }


        }*/





