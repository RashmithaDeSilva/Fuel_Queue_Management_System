import java.io.*;
import java.util.Scanner;

public class ArraysVersion {

    //For all fuel stock
    static int allFuelStock_liters = 6600;

    //For fuel details
    static int q1ServedCustomer = 0;
    static int q2ServedCustomer = 0;
    static int q3ServedCustomer = 0;

    //for identify int or string
    public static boolean NumbOrNot(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }



    public static void main(String[] args) {

        // All fuel center pumps arrays
        String[] FuelPumps_1 = new String[6];
        String[] FuelPumps_2 = new String[6];
        String[] FuelPumps_3 = new String[6];


        System.out.println("------------------------------------");
        System.out.println("|   Fuel Queue Management System   |");
        System.out.println("------------------------------------\n");

        do {
            Scanner User = new Scanner(System.in);
            System.out.print("If you want to start this program enter 'yes' :- ");
            String Input = User.nextLine();
            if (Input.equalsIgnoreCase("yes")) {
                System.out.println("~ ~ ~ WELCOME ~ ~ ~");
                System.out.println(" ");

                boolean menuBreak = true;
                do {
                    switch (MainMenu()) {
                        //View all Fuel Queues
                        case "100", "VFQ":
                            System.out.println(" > > > All Fuel Queues < < < ");
                            System.out.println("\nnull = empty\n\n");

                            System.out.println("Fuel Pumps 1");
                            PrintFuelQueues(FuelPumps_1);
                            System.out.println("\n\n");

                            System.out.println("Fuel Pumps 2");
                            PrintFuelQueues(FuelPumps_2);
                            System.out.println("\n\n");

                            System.out.println("Fuel Pumps 3");
                            PrintFuelQueues(FuelPumps_3);
                            System.out.println("\n\n");

                            int VFQ = ext_or_cont_loop();
                            if(VFQ == 2){
                                menuBreak = false;
                            }
                            break;

                        //View all Empty Queues
                        case "101", "VEQ":
                            System.out.println("> > > All Empty Queues < < <");
                            System.out.println("\nnull = empty\n\n");

                            System.out.println("Fuel Pumps 1");
                            AllEmptyQueues(FuelPumps_1);
                            System.out.println("\n\n");

                            System.out.println("Fuel Pumps 2");
                            AllEmptyQueues(FuelPumps_2);
                            System.out.println("\n\n");

                            System.out.println("Fuel Pumps 3");
                            AllEmptyQueues(FuelPumps_3);
                            System.out.println("\n\n");

                            int VEQ = ext_or_cont_loop();
                            if(VEQ == 2){
                                menuBreak = false;
                            }
                            break;

                        //Add customer to a Queue
                        case "102", "ACQ":
                            System.out.println("> > > Add customer to a Queue < < <\n\n");

                            System.out.println("Fuel Pumps 1");
                            AllEmptyQueues(FuelPumps_1);
                            System.out.println("\n\n");

                            System.out.println("Fuel Pumps 2");
                            AllEmptyQueues(FuelPumps_2);
                            System.out.println("\n\n");

                            System.out.println("Fuel Pumps 3");
                            AllEmptyQueues(FuelPumps_3);
                            System.out.println("\n\n\n");

                            System.out.println(">>> The above shows all empty queues");
                            System.out.println(">>> You can add people to any empty queue");
                            System.out.println(">>> If you want to stop adding customers ENTER :- 'Finish'\n");
                            System.out.println("Pump 1 queue");
                            AddCustomers(FuelPumps_1);
                            System.out.println("\n");
                            System.out.println("Pump 2 queue");
                            AddCustomers(FuelPumps_2);
                            System.out.println("\n");
                            System.out.println("Pump 3 queue");
                            AddCustomers(FuelPumps_3);
                            System.out.println("\n\n");

                            int ACQ = ext_or_cont_loop();
                            if(ACQ == 2){
                                menuBreak = false;
                            }
                            break;

                        //Remove a customer from a Queue (From a specific location)
                        case "103", "RCQ":
                            System.out.println("> > > Remove a customer from a specific location < < <\n\n");

                            System.out.println("Fuel Pumps 1");
                            PrintFuelQueues(FuelPumps_1);
                            System.out.println("\n\n");

                            System.out.println("Fuel Pumps 2");
                            PrintFuelQueues(FuelPumps_2);
                            System.out.println("\n\n");

                            System.out.println("Fuel Pumps 3");
                            PrintFuelQueues(FuelPumps_3);
                            System.out.println("\n\n\n");

                            RemoveCustomerSpecificLocation(FuelPumps_1,FuelPumps_2,FuelPumps_3);
                            System.out.println("\n\n");

                            int RCQ = ext_or_cont_loop();
                            if(RCQ == 2){
                                menuBreak = false;
                            }
                            break;

                        //Remove a served customer
                        case "104", "PCQ":
                            System.out.println("> > > Remove a customer < < <\n\n");

                            RemoveServedCustomer(FuelPumps_1,FuelPumps_2,FuelPumps_3);

                            int PCQ = ext_or_cont_loop();
                            if(PCQ == 2){
                                menuBreak = false;
                            }
                            break;

                        //View Customers Sorted in alphabetical order
                        case "105", "VCS":
                            System.out.println("> > > All customers in alphabetical order < < <\n\n");

                            System.out.println("Fuel Pumps 1");
                            AtoZ(FuelPumps_1);
                            System.out.println("\n\n");

                            System.out.println("Fuel Pumps 2");
                            AtoZ(FuelPumps_2);
                            System.out.println("\n\n");

                            System.out.println("Fuel Pumps 3");
                            AtoZ(FuelPumps_3);
                            System.out.println("\n\n");

                            int VCS = ext_or_cont_loop();
                            if(VCS == 2){
                                menuBreak = false;
                            }
                            break;

                        //Store Program Data into file
                        case "106", "SPD":
                            StoreDataInToFile(FuelPumps_1,FuelPumps_2,FuelPumps_3);
                            break;

                        //Load Program Data from file
                        case "107", "LPD":
                            LoadDateFromFile();

                            int LPD = ext_or_cont_loop();
                            if(LPD == 2){
                                menuBreak = false;
                            }
                            break;

                        //View Remaining Fuel Stock
                        case "108", "STK":
                            System.out.println("> > > View Remaining Fuel Stock < < <\n\n");

                            System.out.println("Remaining fuel ftock :- "+allFuelStock_liters+" liters\n\n");

                            int STK = ext_or_cont_loop();
                            if(STK == 2){
                                menuBreak = false;
                            }
                            break;

                        //Add Fuel Stock
                        case "109", "AFS":
                            System.out.println("> > > Add Fuel Stock < < <\n\n");
                            Scanner AFSuser = new Scanner(System.in);
                            boolean AFSloopbreak = true;
                            while (AFSloopbreak){
                                System.out.print("Give the amount of fuel you are refilling in litres :- ");
                                String AFSinput = AFSuser.nextLine();
                                if(NumbOrNot(AFSinput)){
                                    if (Integer.valueOf(AFSinput) <= 0){
                                        System.out.println("This Value is Incorrect\n");
                                    }else {
                                        allFuelStock_liters += Integer.valueOf(AFSinput);
                                        System.out.println("\n > > > Successfully added "+AFSinput+" litres");
                                        System.out.println(" > > > Now Remaining Fuel Stock is "+allFuelStock_liters+" litres\n\n\n");
                                        AFSloopbreak = false;
                                    }
                                }else {
                                    System.out.println("Enter integer value .....!\n");
                                }
                            }

                            int AFS = ext_or_cont_loop();
                            if(AFS == 2){
                                menuBreak = false;
                            }
                            break;

                        //Exit the Program
                        case "999", "EXT":
                            System.out.println("~ ~ ~ It's pleasure to serve you ~ ~ ~\n\n");
                            for (int i = 0;i <= 75; i++){
                                System.out.print("- ");
                            }
                            menuBreak = false;
                            break;
                        default:
                            System.out.println("~ ~ ~ Incorrect answer try again ............!\n\n");
                            for (int i = 0;i <= 75; i++){
                                System.out.print("- ");
                            }
                            System.out.println("\n\n");
                    }
                }while (menuBreak);
                break;

            } else {
                System.out.println("~ ~ ~ Try again............!");
            }
        }while (true);

    }

    //main menu
    public static String MainMenu(){

        System.out.println("< < < < *** > > > >");
        System.out.println("|    Main  Menu   |");
        System.out.println("< < < < *** > > > >\n");

        System.out.println("100 or VFQ: View all Fuel Queues");
        System.out.println("101 or VEQ: View all Empty Queues");
        System.out.println("102 or ACQ: Add customer to a Queue");
        System.out.println("103 or RCQ: Remove a customer from a Queue (From a specific location)");
        System.out.println("104 or PCQ: Remove a served customer");
        System.out.println("105 or VCS: View Customers Sorted in alphabetical order");
        System.out.println("106 or SPD: Store Program Data into file");
        System.out.println("107 or LPD: Load Program Data from file");
        System.out.println("108 or STK: View Remaining Fuel Stock");
        System.out.println("109 or AFS: Add Fuel Stock");
        System.out.println("999 or EXT: Exit the Program\n");

        if (allFuelStock_liters <= 500){
            System.out.println("\n > > > > > Fuel Stock Level is low and it is "+allFuelStock_liters+" liters\n\n");
        }

        System.out.print("Enter your selection :- ");
        Scanner UserSelection = new Scanner(System.in);
        String US = UserSelection.nextLine();
        System.out.println(" ");
        for (int i = 0;i <= 75; i++){
            System.out.print("- ");
        }
        System.out.println("\n\n");
        return US;
    }



    //Ext or Cont Loop
    public static int ext_or_cont_loop(){
        Scanner UserSelection = new Scanner(System.in);
        boolean vfqBreak = true;
        int output = 0;
        while (vfqBreak) {
            System.out.println(" 1) Back to Main Menu");
            System.out.println(" 2) Exit the Program");
            System.out.print("Enter answer :- ");
            String  ex_or_back = UserSelection.nextLine();
            System.out.println("\n");

            if (ex_or_back.equalsIgnoreCase("1")) {
                for (int i = 0; i <= 75; i++) {
                    System.out.print("- ");
                }
                System.out.println("\n\n");
                output *= 0;
                output += 1;
                vfqBreak = false;

            } else if (ex_or_back.equalsIgnoreCase("2")) {
                System.out.println("~ ~ ~ It's a pleasure to serve you ~ ~ ~");
                output *= 0;
                output += 2;
                vfqBreak = false;

            } else {
                System.out.println("Unexpected answer retry ............!");
            }
        }
        return output;
    }



    //100 or VFQ: View all Fuel Queues
    public static void PrintFuelQueues(String[] FuelCenter){
        System.out.println("           1             2             3             4             5             6              >>>Queue numbers");
        for (int i = 0; i < FuelCenter.length; i++){
            System.out.print("          "+FuelCenter[i]);
        }
    }



    //101 or VEQ: View all Empty Queues
    public static void  AllEmptyQueues(String[] VEQ){
        String laststr = VEQ[5];
        if (laststr == null){
            PrintFuelQueues(VEQ);
        }else {
            System.out.println("This queues is full");
        }
    }



    //102 or ACQ: Add customer to a Queue
    public static void AddCustomers(String[] ACQ){
        Scanner user = new Scanner(System.in);

        //Check it out last null or not
        if (ACQ[5] == null) {
            for (int i = 0; i < 6; i++) {

                boolean loopbreack = true;
                while (ACQ[i] == null && loopbreack){
                    System.out.print("Add new customer to queues position " + (i + 1) + " :- ");
                    String input = user.nextLine();
                    if (input.equalsIgnoreCase("finish")) {
                        System.out.println("\n");
                        int ii = 5-i;
                        i=i+ii;
                        loopbreack = false;
                    } else {
                        ACQ[i] = input;
                        System.out.println("Queues position " + (i + 1) + "  >>> Successfully added customer '" + ACQ[i] + "'\n");
                    }
                }
            }
        }
        //if is null Its meaning that queue is full
        else {
            System.out.println("Queue is full !");
        }
    }



    //103 or RCQ: Remove a customer from a Queue (From a specific location)
    public static void RemoveCustomerSpecificLocation(String[] q1, String[] q2, String[] q3){
        Scanner user = new Scanner(System.in);
        boolean loopbreak = true;
        while (loopbreak){
            System.out.print("Do you want to remove customer from which queues :- ");
            String input = user.nextLine();
            if (NumbOrNot(input)) {
                int uinp = Integer.valueOf(input);
                if (0 < uinp && uinp < 4) {
                    switch (uinp) {
                        case 1:
                            boolean loopbreak2 = true;
                            while (loopbreak2) {
                                System.out.print("And customer queues number :- ");
                                String input2 = user.nextLine();
                                if (NumbOrNot(input2)) {
                                    int uinp2 = Integer.valueOf(input2);
                                    int forsout = uinp2;
                                    if (0 < uinp2 && uinp2 <7) {
                                        String[] Q_Blank = new String[1];
                                        int removeCustomer = uinp2 -1;
                                        for (int i=uinp2;i<6;i++){
                                            q1[removeCustomer] = q1[uinp2];
                                            removeCustomer++;
                                            uinp2++;
                                        }
                                        q1[5] = Q_Blank[0];
                                        System.out.println("\nSuccessfully remove customer form fuel queue 1 position "+forsout);
                                        loopbreak2 = false;
                                    }else {
                                        System.out.println("Unexpected answer retry ............!\n");
                                    }
                                } else {
                                    System.out.println("Unexpected answer retry ............!\n");
                                }
                            }
                            loopbreak = false;
                            break;
                        case 2:
                            boolean loopbreak3 = true;
                            while (loopbreak3) {
                                System.out.print("And customer queues number :- ");
                                String input3 = user.nextLine();
                                if (NumbOrNot(input3)) {
                                    int uinp3 = Integer.valueOf(input3);
                                    int forsout2 = uinp3;
                                    if (0 < uinp3 && uinp3 <7) {
                                        String[] Q_Blank2 = new String[1];
                                        int removeCustomer2 = uinp3 -1;
                                        for (int i=uinp3;i<6;i++){
                                            q2[removeCustomer2] = q2[uinp3];
                                            removeCustomer2++;
                                            uinp3++;
                                        }
                                        q2[5] = Q_Blank2[0];
                                        System.out.println("\nSuccessfully remove customer form fuel queue 1 position "+forsout2);
                                        loopbreak3 = false;
                                    }else {
                                        System.out.println("Unexpected answer retry ............!\n");
                                    }
                                } else {
                                    System.out.println("Unexpected answer retry ............!\n");
                                }
                            }
                            loopbreak = false;
                            break;
                        case 3:
                            boolean loopbreak4 = true;
                            while (loopbreak4) {
                                System.out.print("And customer queues number :- ");
                                String input4 = user.nextLine();
                                if (NumbOrNot(input4)) {
                                    int uinp4 = Integer.valueOf(input4);
                                    int forsout3 = uinp4;
                                    if (0 < uinp4 && uinp4 <7) {
                                        String[] Q_Blank3 = new String[1];
                                        int removeCustomer3 = uinp4 -1;
                                        for (int i=uinp4;i<6;i++){
                                            q3[removeCustomer3] = q1[uinp4];
                                            removeCustomer3++;
                                            uinp4++;
                                        }
                                        q1[5] = Q_Blank3[0];
                                        System.out.println("\nSuccessfully remove customer form fuel queue 1 position "+forsout3);
                                        loopbreak4 = false;
                                    }else {
                                        System.out.println("Unexpected answer retry ............!\n");
                                    }
                                } else {
                                    System.out.println("Unexpected answer retry ............!\n");
                                }
                            }
                            loopbreak = false;
                            break;
                    }
                } else {
                    System.out.println("Unexpected answer retry ............!\n");
                }
            }else {
                System.out.println("Unexpected answer retry ............!\n");
            }
        }
    }



    //104 or PCQ: Remove a served customer
    public static void RemoveServedCustomer(String[] q1,String[] q2,String[] q3){

        Scanner PCQuser = new Scanner(System.in);
        System.out.println("Fuel Pumps 1");
        if(q1[0] == null){
            System.out.println("This queue is empty .....!");
        }else {
            boolean PCQloopbreak = true;
            while (PCQloopbreak){
                System.out.print("Do you want to remove served customer from this queue ? (yes/no) :- ");
                String PCQinput = PCQuser.nextLine();
                if (PCQinput.equalsIgnoreCase("yes")){
                    allFuelStock_liters -= 10;
                    q1ServedCustomer += 1;
                    String[] Q_blank1 = new String[1];
                    for (int i=0;i<5;i++){
                        q1[i] = q1[(i+1)];
                    }
                    q1[5] = Q_blank1[0];
                    System.out.println("Successfully remove served customer");
                    PCQloopbreak = false;
                }
                else if (PCQinput.equalsIgnoreCase("no")) {
                    System.out.println(">>> Skip..........!");
                    PCQloopbreak = false;
                } else {
                    System.out.println("Unexpected answer retry ............!\n");
                }
            }
        }
        System.out.println("\n\n");
        System.out.println("Fuel Pumps 2");
        if(q2[0] == null){
            System.out.println("This queue is empty .....!");
        }else {
            boolean PCQloopbreak = true;
            while (PCQloopbreak){
                System.out.print("Do you want to remove served customer from this queue ? (yes/no) :- ");
                String PCQinput = PCQuser.nextLine();
                if (PCQinput.equalsIgnoreCase("yes")){
                    allFuelStock_liters -= 10;
                    q2ServedCustomer += 1;
                    String[] Q_blank2 = new String[1];
                    for (int i=0;i<5;i++){
                        q2[i] = q2[(i+1)];
                    }
                    q2[5] = Q_blank2[0];
                    System.out.println("Successfully remove served customer");
                    PCQloopbreak = false;
                }
                else if (PCQinput.equalsIgnoreCase("no")) {
                    System.out.println(">>> Skip..........!");
                    PCQloopbreak = false;
                } else {
                    System.out.println("Unexpected answer retry ............!\n");
                }
            }
        }
        System.out.println("\n\n");
        System.out.println("Fuel Pumps 3");
        if(q3[0] == null){
            System.out.println("This queue is empty .....!");
        }else {
            boolean PCQloopbreak = true;
            while (PCQloopbreak){
                System.out.print("Do you want to remove served customer from this queue ? (yes/no) :- ");
                String PCQinput = PCQuser.nextLine();
                if (PCQinput.equalsIgnoreCase("yes")){
                    q3ServedCustomer += 1;
                    allFuelStock_liters -= 10;
                    String[] Q_blank3 = new String[1];
                    for (int i=0;i<5;i++){
                        q3[i] = q3[(i+1)];
                    }
                    q3[5] = Q_blank3[0];
                    System.out.println("Successfully remove served customer");
                    PCQloopbreak = false;
                }
                else if (PCQinput.equalsIgnoreCase("no")) {
                    System.out.println(">>> Skip..........!");
                    PCQloopbreak = false;
                } else {
                    System.out.println("Unexpected answer retry ............!\n");
                }
            }
        }
        System.out.println("\n\n");
    }



    //105 or VCS: View Customers Sorted in alphabetical order
    public static void AtoZ(String[] VCS){

        if(VCS[0] != null) {

            //Counting null count
            int null_count = 0;
            for (int i = 0; i < VCS.length; i++) {
                if (VCS[i] == null) {
                    null_count = null_count + 1;
                }
            }

            //For remove null elements
            String[] VCS2 = new String[VCS.length - null_count];
            for (int i = 0; i < VCS.length; i++) {
                if (VCS[i] != null) {
                    VCS2[i] = VCS[i];
                }
            }

            char[][] strToChar2D = new char[VCS2.length][];
            char[] all_1st_Elements = new char[VCS2.length];
            char[] withOutSameElements = new char[VCS2.length];
            char[][] AtoZ = new char[VCS2.length][];
            int x = 0;
            int y = 0;
            int z = 0;
            char temp;

            //Converting all string array elements to char array
            for (int i = 0; i < VCS2.length; i++) {
                strToChar2D[i] = VCS2[i].toCharArray();
            }

            //Selecting the first element from all the elements in the char array
            for (int i = 0; i < VCS2.length; i++) {
                all_1st_Elements[i] = strToChar2D[i][0];
            }

            //Converting all elements to A to Z order
            for (int i = 0; i < VCS2.length; i++) {
                for (int ii = i + 1; ii < VCS2.length; ii++) {
                    if (all_1st_Elements[i] > all_1st_Elements[ii]) {
                        temp = all_1st_Elements[i];
                        all_1st_Elements[i] = all_1st_Elements[ii];
                        all_1st_Elements[ii] = temp;
                    }
                }
            }

            //Counting similar elements
            for (int i = 0; i < all_1st_Elements.length - 1; i++) {
                if (all_1st_Elements[i] != all_1st_Elements[i + 1]) {
                    withOutSameElements[x++] = all_1st_Elements[i];
                } else {
                    y = y + 1;
                }
            }
            withOutSameElements[x++] = all_1st_Elements[all_1st_Elements.length - 1];

            char[] withOutSameElementsAndSize = new char[VCS2.length - y];

            //Append without all element and size in new array
            for (int i = 0; i < withOutSameElementsAndSize.length; i++) {
                withOutSameElementsAndSize[i] = withOutSameElements[i];
            }

            //Append A to Z all elements in new array
            for (int i = 0; i < withOutSameElementsAndSize.length; i++) {
                for (int ii = 0; ii < VCS2.length; ii++) {
                    if (withOutSameElementsAndSize[i] == strToChar2D[ii][0]) {
                        AtoZ[z++] = strToChar2D[ii];
                    }
                }
            }

            //Printing all elements in A to Z oder
            for (int i = 0; i < AtoZ.length; i++) {
                System.out.print(" "+(i+1)+") ");
                System.out.println(AtoZ[i]);
            }
        }else {
            System.out.println(">>> This queues Empty .........!");
        }
    }


    //106 or SPD: Store Program Data into file
    public static void StoreDataInToFile(String[] q1, String[] q2, String[] q3){

        File fuelQ = new File("Fuel_Queues_Deta.txt");

        String FQ1 = "\n                    < < < < < < <***> > > > > > >\n";
        String FQ2 = "                    |     Fuel Station Data     |\n";
        String FQ3 = "                    < < < < < < <***> > > > > > >\n";
        String total = "\n\nTotal amount of oil currently remaining :- ";
        String FQCount = "\n\n\n\n     Fuel Queue ";
        String AOCD = "\nAmount of oil currently delivered :- ";
        String NPCRO = "\nNumber of people currently receiving oil :- ";
        String PCWQ = "\nPeople currently waiting in queue";

        try{
            fuelQ.createNewFile();
            BufferedWriter write = new BufferedWriter(new FileWriter("Fuel_Queues_Deta.txt"));
            write.write(FQ1+FQ2+FQ3+total+(allFuelStock_liters)+FQCount+"1"+AOCD+(q1ServedCustomer*10)+NPCRO+(q1ServedCustomer)+PCWQ);
            for (int i = 0; i < q1.length; i++){
                if(q1[0]==null){
                    write.write(" :- This queue is empty .....!");
                    break;
                }else if (q1[i]==null){
                    break;
                }else {
                    write.write("\n");
                    write.write((i+1)+") "+q1[i]);
                }
            }
            write.write(FQCount+"2"+AOCD+(q2ServedCustomer*10)+NPCRO+(q2ServedCustomer)+PCWQ);
            for (int i = 0; i < q2.length; i++){
                if(q2[0]==null){
                    write.write(" :- This queue is empty .....!");
                    break;
                }else if (q2[i]==null){
                    break;
                }else {
                    write.write("\n");
                    write.write((i+1)+") "+q2[i]);
                }
            }
            write.write(FQCount+"3"+AOCD+(q3ServedCustomer*10)+NPCRO+(q3ServedCustomer)+PCWQ);
            for (int i = 0; i < q3.length; i++){
                if(q3[0]==null){
                    write.write(" :- This queue is empty .....!");
                    break;
                }else if (q3[i]==null){
                    break;
                }else {
                    write.write("\n");
                    write.write((i+1)+") "+q3[i]);
                }
            }
            System.out.println("Successfully Store Program Data Into File .....!");
            System.out.println("\n");
            for (int i = 0;i <= 75; i++){
                System.out.print("- ");
            }
            System.out.println("\n\n");
            write.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }


    //107 or LPD: Load Program Data from file
    public static void LoadDateFromFile(){
        File fuelQ = new File("Fuel_Queues_Deta.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fuelQ));

            String str;
            while ((str = reader.readLine()) != null){
                System.out.println(str);
            }
            System.out.println("\n");

        }catch (Exception e){
            System.out.println(e);
        }
    }

}