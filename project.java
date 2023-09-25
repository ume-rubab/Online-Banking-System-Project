import java.io.*;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class project {
    static Scanner input = new Scanner(System.in);
    static Scanner st = new Scanner(System.in);
    static int x = 0; // for customer count in branch 01
    static int y = 0; // for customer count in branch 02
    static int z = 0; // for employee count in branch 02
    static int e = 0; // for employee count in branch 01

  public static void main(String[] args) {
    menu.branchmenu();
  }

  // menu class containng  main menu of program
    class menu {
        public static void branchmenu() {
            System.out.println("---------------------------------------------");
            System.out.println("    WELCOME     TO      BANK     OF     JAVA");
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println("  CHOOSE YOUR BRANCH TO PERFORM ANY ACTIONS: ");
            System.out.println("---------------------------------------------");
            System.out.println("1. For Branch 01");
            System.out.println("2. For Branch 02");
            System.out.println("3. Exit");
            int b;
            while (true) {
                try {
                    b = input.nextInt();
                    while (!(b == 1 || b == 2 || b == 3) || (String.valueOf(b).isBlank())) {
                        System.out.println("Invalid option.Choose option from menu: ");
                        b = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Integer value only please...:");
                    input.nextLine();
                }
            }
            switch (b) {
                case 1: {
                    System.out.println("---------------------------------------------");
                    System.out.println("        YOU ARE IN BRANCH 01        ");
                    System.out.println("---------------------------------------------");
                    branch01.menu();
                }
                    break;
                case 2: {
                    System.out.println("---------------------------------------------");
                    System.out.println("        YOU ARE IN BRANCH 02        ");
                    System.out.println("---------------------------------------------");
                    branch02.menu();
                }
                    break;
                case 3: {
                    System.out.println("You are exiting of system....Thank you for using our services!!! ");
                    System.exit(1);
                }
                    break;
            }// switch closed.......
        } // method closed
    } // menu class closed

    // ______________________________________________________________________BRANCH01________________________________________________________________
    class branch01 {
        public static Scanner input = new Scanner(System.in);

        public static void menu() {
            System.out.println("CHOOSE  YOUR    STATUS: ");
            System.out.println("---------------------------------------------");
            System.out.println("1. You are Admin");
            System.out.println("2. You are Employee");
            System.out.println("3. You are Customer");
            System.out.println("4. Return to Menu of Branches");
            System.out.println("5. Exit the system");
            int opt;
            // validation check on user input
            while (true) {
                try {
                    opt = input.nextInt();
                    while (!(opt == 1 || opt == 2 || opt == 3 || opt == 4 || opt == 5) || (String.valueOf(opt).isBlank())) {
                        System.out.println("Invalid option.Choose option from menu please: ");
                        opt = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Integer value only please...:");
                    input.nextLine();
                }
            }
            switch (opt) {
                case 1: {
                    System.out.println("YOU ARE ADMIN");
                    login_admin(); // call admin login first
                    System.out.println("Choose your authority:");
                    displayadminmenu();
                    break;
                }
                case 2: {
                    System.out.println("YOU ARE EMPLOYEE");
                    login_employee_menu(); // employee login / sign up first
                    displayemployeemenu();
                    break;
                }
                case 3: {
                    System.out.println("YOU ARE A CUSTOMER");
                    login_customer_menu(); // customer login / sign up first
                    displaycustomermenu();
                    break;
                }
                case 4: {
                    System.out.println("Returning to branch Menu");
                    project.main(null);
                    break;
                }
                default: {
                    System.out.println("You are exiting the system....Thank you for using our services!!! ");
                    System.exit(1);
                    break;
                }
            } // switch closed
        } // menu method closed

        public static void displayadminmenu() {
            System.out.println("1. Add Employees:");
            System.out.println("2. View Employees:");
            System.out.println("3. Search Employees:");
            System.out.println("4. Edit Employees:");
            System.out.println("5. Delete Employees:");
            System.out.println("6. View Customers:");
            System.out.println("7. Return to Main Menu of current Branch");
            System.out.println("8. Exit system");
            System.out.println("-------------------------------------");
            System.out.println("Enter your choice: ");
            int choice;
            // validation check on user input
            while (true) {
                try {
                    choice = input.nextInt();
                    while (!(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6
                            || choice == 7 || choice == 8) || (String.valueOf(choice).isBlank())) {
                        System.out.println("Invalid option.Choose option from menu: ");
                        choice = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Integer value only please...:");
                    input.nextLine();
                }
            }
            switch (choice) {
                case 1: {
                    addemployees();
                    displayadminmenu();
                }
                    break;
                case 2: {
                    try {
                        viewemployees();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayadminmenu();
                }
                    break;
                case 3: {
                    try {
                        searchemployee();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayadminmenu();
                }
                    break;
                case 4: {
                    try {
                        editemployee();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayadminmenu();
                }
                case 5: {
                    try {
                        deletemployee();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayadminmenu();
                }
                case 6: {
                    try {
                        viewcustomers();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayadminmenu();
                }
                    break;
                case 7: {
                    System.out.println("Returning to Menu of Branch 01");
                    branch01.menu();
                }
                    break;
                default: {
                    System.out.println("You are exiting the system...Thank you for using our services!! ");
                    System.exit(1);
                }
            }// admin switch closed
        } // method closed

        // employee menu
        // method................................................................................................................
        public static void displayemployeemenu() {
            System.out.println("1. Add Customer account:");
            System.out.println("2. View Customers Account:");
            System.out.println("3. Search Customer Account:");
            System.out.println("4. Edit Customer Account:");
            System.out.println("5. Delete Customer Account:");
            System.out.println("6. Return to Main Menu Current of Branch:");
            System.out.println("7. Exit the system:");
            System.out.println("-------------------------------------");
            System.out.println("Enter your choice: ");
            int ch;
            // validation check on user input
            while (true) {
                try {
                    ch = input.nextInt();
                    while (!(ch == 1 || ch == 2 || ch == 3 || ch == 4 || ch == 5 || ch == 6 || ch == 7) || (String.valueOf(ch).isBlank())) {
                        System.out.println("Invalid option.Choose option from menu: ");
                        ch = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Integer value only please...:");
                    input.nextLine();
                }
            }
            switch (ch) {
                case 1: {
                    try {
                        addcustomeraccount();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    displayemployeemenu();
                }
                    break;
                case 2: {
                    try {
                        viewcustomeraccount();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayemployeemenu();
                }
                    break;
                case 3: {
                    try {
                        searchcustomer();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayemployeemenu();
                }
                    break;
                case 4: {
                    try {
                        editcustomer();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayemployeemenu();
                }
                case 5: {
                    try {
                        deletecustomer();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayemployeemenu();
                }
                    break;
                case 6: {
                    System.out.println("Returning to Menu");
                    branch01.menu();
                }
                    break;
                default: {
                    System.out.println("You are exiting the system...Thank you for using our services!! ");
                    System.exit(1);
                }
            } // employee switch closed.....
        }// employee method closed...............................
// CUSTOMER MENU METHOD..............................................................................................................

        public static void displaycustomermenu() {
            System.out.println("1. View account");
            System.out.println("2. Withdraw cash");
            System.out.println("3. Deposit cash");
            System.out.println("4. Transfer cash");
            System.out.println("5. Return to Main Menu Current of Branch");
            System.out.println("6. exit the system");
            System.out.println("-------------------------------------");
            System.out.println("Enter your choice: ");
            int option;
            // validation check on user input
            while (true) {
                try {
                    option = input.nextInt();
                    while (!(option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6) || (String.valueOf(option).isBlank())) {
                        System.out.println("Invalid option.Choose option from menu: ");
                        option = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Integer value only please...:");
                    input.nextLine();
                }
            }
            switch (option) {
                case 1: {
                    try {
                        viewaccount();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displaycustomermenu();
                }
                    break;
                case 2: {
                    try {
                        Withdraw();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displaycustomermenu();
                }
                    break;
                case 3: {
                    try {
                        deposit();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displaycustomermenu();
                }
                    break;
                case 4: {
                    try {
                        transfercash();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displaycustomermenu();
                }
                    break;
                case 5: {
                    System.out.println("Returning to Menu");
                    branch01.menu();
                }
                    break;
                default: {
                    System.out.println("You are exiting the system...Thank you for using our services!! ");
                    System.exit(1);
                }
                    break;
            }// customer switch closed....
        }// customer method closed............................................

    //...............................................................all employee methods......................................................
        public static void addcustomeraccount() {
            int sentinel = 0;
            String cnic, name, accountno;
            int lenphoneno;
            String phoneno;
            int age;
            double balance;
            int num;
            String[][] details = new String[10][6];
            while (sentinel == 0) {
                if (x == details.length - 1) {
                    System.out.println("sorry array is full");
                    break;
                } else {
                    System.out.println("enter customer name:");
                    while (true) {
                        name = st.nextLine();
                        if (name.isBlank()) {
                            System.out.println("Enter name...this field cannot be empty:");
                        } else if (name.length() > 30) {
                            System.out.println("Your name caanot exceed 30 characters..try again:");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Non-alphabetic characters detected in name..please enter alphabets only!!:");
                        } else {
                            break;
                        }
                    }
                    details[x][0] = name;
                    System.out.println("enter customer age:");
                    while (true) {
                        try {
                            age = input.nextInt();
                            if (String.valueOf(age).isBlank()) {
                                System.out.println("Enter age...this field cannot be empty:"); }
                            else if (age < 0) {
                                System.out.println("Your age can't be negative numbers...Set again: ");
                            } else if (age < 18) {
                                System.out.println("Your age can't be less than 18...Set again: ");
                            } else if (age > 100) {
                                System.out.println("Your age can't be more  than 100...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Non numeric age is not excepted..Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[x][1] = String.valueOf(age);
                    System.out.println("enter customer phone no(without dashes):");
                    while (true) {
                        phoneno = st.nextLine();
                        lenphoneno = phoneno.length();
                        if (phoneno.isBlank()) {
                            System.out.println("Enter phone No...this field cannot be empty:");
                        } else if (lenphoneno > 11 || lenphoneno < 11) {
                            System.out.println("Your phone No cannot exceed or less than 11 numbers..try again:");
                        } else if (!phoneno.matches("[0-9]+")) {
                            System.out.println("Phone no cannot contain characters or can't be nagative..Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[x][2] = String.valueOf(phoneno);
                    System.out.println("enter CNIC in format(00000-0000000-0)");
                    while (true) {
                        cnic = st.next();
                        if(cnic.isBlank()) {
                            System.out.println("This field cannot be empty..enter cnic:");
                        }
                        else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                            System.out.println("Invalid CNIC. Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[x][3] = cnic;
                    System.out.println("enter customer initial balance:");
                    while (true) {
                        try {
                            balance = input.nextDouble();
                            if (String.valueOf(balance).isBlank()) {
                                System.out.println("This field cannot be empty..enter some number value: ");
                            }
                            else if (balance < 0) {
                                System.out.println("Your balance can't be  negative...Set again: ");
                            } else if (balance > 800000) {
                                System.out.println("Deposit upto 800000 only please :");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Balance can't be non-numeric.Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[x][4] = String.valueOf(balance);
                    Random r = new Random();
                    num = r.nextInt(1000000);
                    accountno = "B01-" + String.valueOf(num);
                    details[x][5] = accountno;
                    System.out.println("Your account has been created");
                    try {
                        FileWriter file = new FileWriter("customersOf1.txt", true);
                        for (int i = 0; i <= x; i++) {
                            file.write(details[i][0] + "#");
                            file.write(details[i][1] + "#");
                            file.write(details[i][2] + "#");
                            file.write(details[i][3] + "#");
                            file.write(details[i][4] + "#");
                            file.write(details[i][5]);
                            file.write("\n");
                        }
                        System.out.println("....Data is successfully stored in file....");
                        file.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }  
                    displayemployeemenu();                
                    x++; // increment customer count of branch 1
                } // else closed
            } // outer while closed
        } // method closed

    public static void viewcustomeraccount() throws FileNotFoundException {
            File file = new File("customersOf1.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split("#");
                System.out.println("Name: " + details[0]);
                System.out.println("Age: " + details[1]);
                System.out.println("Phone no: " + details[2]);
                System.out.println("CNIC: " + details[3]);
                System.out.println("Balance: " + details[4]);
                System.out.println("Account no: " + details[5]);
                System.out.println("-------------------------------------------------");
            }
            sc.close();
        } // method closed

        public static void searchcustomer() throws FileNotFoundException {
            String cnic;
            try {
                File file = new File("customersOf1.txt");
                Scanner sc = new Scanner(file);
                System.out.println("Enter the CNIC(format:00000-0000000-0) of the customer you want to see:");
                while (true) {
                    cnic = st.next();
                    if(cnic.isBlank()) {
                        System.out.println("This field cannot be empty..enter cnic: ");
                            }
                    else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                        System.out.println("Invalid CNIC. Set again: ");
                    } else {
                        break;
                    }
                }
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] details = line.split("#");
                    if (details[3].equals(cnic)) {
                        System.out.println("Name: " + details[0]);
                        System.out.println("Age: " + details[1]);
                        System.out.println("Phone no: " + details[2]);
                        System.out.println("CNIC: " + details[3]);
                        System.out.println("Balance: " + details[4]);
                        System.out.println("Account no: " + details[5]);
                    }
                }
                sc.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } // method closed

        public static void editcustomer() throws FileNotFoundException {
            String name, cnic, phoneno; // declaring variables.............
            int lenName, lenphoneno, age;
            double balance;
            File file = new File("customersOf1.txt");
            Scanner sc = new Scanner(file);
            System.out.println("Enter the CNIC(format:00000-0000000-0) of the customer you want to edit");
            while (true) {
                cnic = st.next();
                if(cnic.isBlank()) {
                    System.out.println("This field cannot be empty..enter cnic: ");
                        }
                else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            String[][] editedRecords = new String[100][6];
            int i = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split("#");
                if (details[3].equals(cnic)) {
                    System.out.println("Enter the new name");
                    while (true) {
                        name = st.nextLine();
                        lenName = name.length();
                        if (name.isBlank()) {
                            System.out.println("Enter name...this field cannot be empty:");
                        } else if (lenName > 30) {
                            System.out.println("Your name cannot exceed 30 characters..try again:");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Non-alphabetic characters detected in name..please enter alphabets only!!:");
                        } else {
                            break;
                        }
                    }
                    details[0] = name;
                    System.out.println("Enter the new age");
                    while (true) {
                        try {
                            age = input.nextInt();
                            if (String.valueOf(age).isBlank()) {
                                System.out.println("This field cannot be empty....set again:");
                            }
                            else if (age < 0) {
                                System.out.println("Your age can't be negative numbers...Set again: ");
                            } else if (age < 18) {
                                System.out.println("Your age can't be less than 18...Set again: ");
                            } else if (age > 100) {
                                System.out.println("Your age can't be more  than 100...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Non numeric age is not excepted..Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[1] = String.valueOf(age);
                    System.out.println("Enter the new phone no");
                    while (true) {
                        phoneno = st.nextLine();
                        lenphoneno = phoneno.length();
                        if (phoneno.isBlank()) {
                            System.out.println("Enter phone No...this field cannot be empty:");
                        } else if (lenphoneno > 11 || lenphoneno < 11) {
                            System.out.println("Your phone No cannot exceed or less than 11 numbers..try again:");
                        } else if (!phoneno.matches("[0-9]+")) {
                            System.out.println("Phone no cannot contain characters or can't be negative..Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[2] = phoneno;
                    System.out.println("Enter the new balance");
                    while (true) {
                        try {
                            balance = input.nextDouble();
                            if(String.valueOf(balance).isBlank()) {
                                System.out.println("This field cannot be empty..enter some balance value: ");
                                    }
                            else if (balance < 0) {
                                System.out.println("Your balance can't be negative...Set again: ");
                            } else if (balance > 8000000) {
                                System.out.println("Your account limit is 80 lac only..try again:");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Balance can't be non-numeric.Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[3] = cnic;
                    details[4] = String.valueOf(balance);
                    details[5] = details[5];
                    editedRecords[i] = details;
                    i++;
                } else {
                    editedRecords[i] = details;
                    i++;
                }
            }
            sc.close();
            try {
                FileWriter newfile = new FileWriter("customersOf1.txt");
                for (int j = 0; j <= i-1; j++) {
                    newfile.write(editedRecords[j][0] + "#");
                    newfile.write(editedRecords[j][1] + "#");
                    newfile.write(editedRecords[j][2] + "#");
                    newfile.write(editedRecords[j][3] + "#");
                    newfile.write(editedRecords[j][4] + "#");
                    newfile.write(editedRecords[j][5]);
                    newfile.write("\n");
                }
                newfile.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } // method closed

        public static void deletecustomer() throws IOException {
            File originalFile = new File("customersOf1.txt");
            File tempFile = new File("temp.txt");
            Scanner in = new Scanner(System.in);
            String cnic;
            System.out.println("Enter the cnic(format:00000-0000000-0) of the customer you want to delete");
            while (true) {
                cnic = in.nextLine();
                if (cnic.isBlank()) {
                    System.out.println("This field cannot be empty...Set again: ");
                }
                else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            // Open the original text file and the temporary text file
            try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                // Read the contents of the original text file and remove the specific string
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.contains(cnic)) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            originalFile.delete();
            // Rename the temporary text file to the name of the original text file using the renameTo() method
            if (tempFile.renameTo(originalFile)) {
                System.out.println("Customer deleted successfully");
            } else {
                System.out.println("Failed to rename the temp file");
            }
    
        } // method closed

        // ....................................employee methods.................................used by admin...............................................................
        public static void addemployees() {
            int control = 0;
            String name;
            String cnic;
            double salary;
            String phoneno;
            int age;
            int lenphoneno;
            String[][] details = new String[10][6];  
            while (control == 0) {
                if (e == details.length - 1) {
                    System.out.println("sorry array is full");
                    break;
                } else {
                    System.out.println("enter employee name");
                    while (true) {
                        name = st.nextLine();
                        if (name.isBlank()) {
                            System.out.println("Enter name...this field cannot be empty:");
                        } else if (name.length() > 30) {
                            System.out.println("Your name cannot exceed 30 characters..try again:");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Non-alphabetic characters detected in name..please enter alphabets only!!:");
                        } else {
                            break;
                        }
                    }
                    details[e][0] = name;
                    System.out.println("enter employee age:");
                    while (true) {
                        try {
                            age = input.nextInt();
                             if (String.valueOf(age).isBlank()) {
                                System.out.println("This field can't be empty...Set again: ");
                            } 
                            else if (age < 0) {
                                System.out.println("Your age can't be negative numbers...Set again: ");
                            } else if (age < 18) {
                                System.out.println("Your age can't be less than 18...Set again: ");
                            } else if (age > 100) {
                                System.out.println("Your age can't be more  than 100...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Non numeric age is not excepted..Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[e][1] = String.valueOf(age);
                    System.out.println("enter employee phone no(without dashes):");
                    while (true) {
                        phoneno = st.nextLine();
                        lenphoneno = phoneno.length();
                        if (phoneno.isBlank()) {
                            System.out.println("Enter phone No...this field cannot be empty:");
                        } else if (lenphoneno > 11 || lenphoneno < 11) {
                            System.out.println("Your phone No cannot exceed or less than 11 numbers..try again:");
                        } else if (!phoneno.matches("[0-9]+")) {
                            System.out.println("Phone no cannot contain characters or can't be negative..Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[e][2] = phoneno;
                    System.out.println("enter CNIC in format(00000-0000000-0)");
                    while (true) {
                        cnic = st.next();
                        if (cnic.isBlank()) {
                            System.out.println("Enter cnic...this field cannot be empty:"); }
                        else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                            System.out.println("Invalid CNIC. Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[e][3] = cnic;
                    System.out.println("enter employee's salary: ");
                    while (true) {
                        try {
                            salary = input.nextDouble();
                            if (String.valueOf(salary).isBlank()) {
                                System.out.println("Enter some salary..this field cannot be empty: ");
                            }
                            else if (salary <= 0) {
                                System.out.println("Salary can't be zero or negative...Set again: ");
                            } else if (salary < 15000 || salary > 5000000) {
                                System.out.println("employee Salary can't in this range ...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Salary can't be non-numeric.Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[e][4] = String.valueOf(salary);
                    System.out.println("Employee's data has been stored");
                    try {
                        FileWriter file = new FileWriter("employeesOf1.txt", true);
                        for (int i = 0; i <= e; i++) {
                            file.write(details[i][0] + "#");
                            file.write(details[i][1] + "#");
                            file.write(details[i][2] + "#");
                            file.write(details[i][3] + "#");
                            file.write(details[i][4]);
                            file.write("\n");
                        }
                        System.out.println("....Data is successfully stored in file....");
                        file.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    System.out.println("Record Saved");
                    displayadminmenu();
                    e++; // increment employee count in branch01
                } // else closed
            } // outer while closed
        } // method closed

        public static void viewemployees() throws FileNotFoundException {
            try {
                File file = new File("employeesOf1.txt");
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] details = line.split("#");
                    System.out.println("Name: " + details[0]);
                    System.out.println("Age: " + details[1]);
                    System.out.println("Phone no: " + details[2]);
                    System.out.println("CNIC: " + details[3]);
                    System.out.println("SALARY:  " + details[4]);
                    System.out.println("-------------------------------------------------");
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        } // method closed

        public static void searchemployee() throws FileNotFoundException {
            String cnic;
            try {
                File file = new File("employeesOf1.txt");
                Scanner sc = new Scanner(file);
                System.out.println("Enter the CNIC(format:00000-0000000-0) of the employee you want to search");
                while (true) {
                    cnic = st.next();
                    if(cnic.isBlank()) {
                        System.out.println("This field cannot be empty..enter cnic: ");
                    }
                    else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                        System.out.println("Invalid CNIC. Set again: ");
                    } else {
                        break;
                    }
                }
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] details = line.split("#");
                    if (details[3].equals(cnic)) {
                        System.out.println("NAME: " + details[0]);
                        System.out.println("AGE: " + details[1]);
                        System.out.println("PHONE NO: " + details[2]);
                        System.out.println("CNIC: " + details[3]);
                        System.out.println("SALARY:  " + details[4]);
                    }
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }

        public static void editemployee() throws FileNotFoundException {
            String cnic;
            String name, phoneno;
            int lenName, lenphoneno;
            double salary;
            int age;
            File file = new File("employeesOf1.txt");
            Scanner sc = new Scanner(file);
            System.out.println("Enter the cnic(format:00000-0000000-0) of the employee you want to edit");
            while (true) {
                cnic = st.next();
                if(cnic.isBlank()) {
                    System.out.println("This field cannot be empty..enter cnic: ");
                }
                else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            String[][] editedRecords = new String[200][5];
            int i = 0;
            // first read form file and edit
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split("#");
                if (details[3].equals(cnic)) {
                    System.out.println("Enter the new name");
                    while (true) {
                        name = st.nextLine();
                        lenName = name.length();
                        if (name.isBlank()) {
                            System.out.println("Enter name...this field cannot be empty:");
                        } else if (lenName > 30) {
                            System.out.println("Your name caanot exceed 30 characters..try again:");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println(
                                    "Non-alphabetic characters detected in name..please enter alphabets only!!:");
                        } else {
                            break;
                        }
                    }
                    details[0] = name;
                    System.out.println("Enter the new age");
                    while (true) {
                        try {
                            age = input.nextInt();
                            if(String.valueOf(age).isBlank()) {
                                System.out.println("This field cannot be empty..enter age:");
                            }
                            else if (age < 0) {
                                System.out.println("Your age can't be negative numbers...Set again: ");
                            } else if (age < 18) {
                                System.out.println("Your age can't be less than 18...Set again: ");
                            } else if (age > 100) {
                                System.out.println("Your age can't be more  than 100...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Non numeric age is not excepted..Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[1] = String.valueOf(age);
                    System.out.println("Enter the new phone no(without dashes): ");
                    while (true) {
                        phoneno = st.nextLine();
                        lenphoneno = phoneno.length();
                        if (phoneno.isBlank()) {
                            System.out.println("Enter phone No...this field cannot be empty:");
                        } else if (lenphoneno > 11 || lenphoneno < 11) {
                            System.out.println("Your phone No cannot exceed or less than 11 numbers..try again:");
                        } else if (!phoneno.matches("[0-9]+")) {
                            System.out.println("Phone no cannot contain characters or can't be nagative..Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[2] = phoneno;
                    System.out.println("Enter the new salary: ");
                    while (true) {
                        try {
                            salary = input.nextDouble();
                            if(String.valueOf(salary).isBlank()) {
                                System.out.println("This field cannot be empty..enter some salary:");
                            }
                            if (salary <= 0) {
                                System.out.println("Salary can't be zero or negative...Set again: ");
                            } else if (salary < 15000 || salary > 5000000) {
                                System.out.println("employee Salary can't be in this range...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Salary can't be non-numeric.Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[3] = cnic;
                    details[4] = String.valueOf(salary);
                    editedRecords[i] = details;
                } else {
                    editedRecords[i] = details;
                }
                i++; // employee numbers incremented in branch01
            }
            sc.close();
            // then write into same file
            try {
                FileWriter newfile = new FileWriter("employeesOf1.txt");
                for (int j = 0; j <= i - 1; j++) {
                    newfile.write(editedRecords[j][0] + "#");
                    newfile.write(editedRecords[j][1] + "#");
                    newfile.write(editedRecords[j][2] + "#");
                    newfile.write(editedRecords[j][3] + "#");
                    newfile.write(editedRecords[j][4]);
                    newfile.write("\n");
                }
                newfile.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        public static void deletemployee() throws IOException {
            File originalFile = new File("employeesOf1.txt");
            File tempFile = new File("temp.txt");
            Scanner in = new Scanner(System.in);
            String cnic;
            System.out.println("Enter the cnic(format:00000-0000000-0) of the employee you want to delete");
            while (true) {
                cnic = in.nextLine();
                if (cnic.isBlank()) {
                    System.out.println("This field cannot be empty..set again: ");
                }
                else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            // Open the original text file and the temporary text file
            try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                // Read the contents of the original text file and remove the specific string
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.contains(cnic)) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            originalFile.delete(); // orginal file is deleted
            // Rename the temporary text file to the name of the original text file using the renameTo() method
            if (tempFile.renameTo(originalFile)) {
                System.out.println("Employee deleted successfully");
            } else {
                System.out.println("Failed to rename the temp file");
            }
    
        }  // method closed

        public static void viewcustomers() throws FileNotFoundException {
            File file = new File("customersOf1.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split("#");
                System.out.println("Name: " + details[0]);
                System.out.println("Age: " + details[1]);
                System.out.println("Phone no: " + details[2]);
                System.out.println("CNIC: " + details[3]);
                System.out.println("Balance: " + details[4]);
                System.out.println("Account no: " + details[5]);
                System.out.println("-------------------------------------------------");
            }
            sc.close();
        } // method closed

        // customer methods......................used by customer....................
        public static void viewaccount() {
            String cnic;
            try {
                File file = new File("customersOf1.txt");
                Scanner reader = new Scanner(file);
                System.out.println("Enter Your CNIC(format:00000-0000000-0) to see your account: ");
                while (true) {
                    cnic = st.next();
                    if(cnic.isBlank()) {
                        System.out.println("This field cannot be empty..enter cnic:");
                    }
                    else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                        System.out.println("Invalid CNIC. Set again: ");
                    } else {
                        break;
                    }
                }
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] details = line.split("#");
                    if (details.length < 6) {
                        System.out.println(file.getName() + " maybe corrupted.");
                        return;
                    }
                    else {
                    if (details[3].equals(cnic)) {
                        System.out.println("Name: " + details[0]);
                        System.out.println("Age: " + details[1]);
                        System.out.println("Phone no: " + details[2]);
                        System.out.println("CNIC: " + details[3]);
                        System.out.println("Balance: " + details[4]);
                        System.out.println("Account no: " + details[5]); }
                    }
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } // method closed

    // withdraw method......................................................................................................................
    public static void Withdraw() throws IOException {
        Scanner sc = new Scanner(System.in);
        String cnic;
        System.out.println("Enter your CNIC(format:00000-0000000-0) to withdraw amount:");
        while (true) {
            cnic = sc.next();
            if (cnic.isBlank()) {
                System.out.println("This field can't be empty...");
            } else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                System.out.println("Invalid CNIC. Set again: ");
            } else {
                break;
            }
        }
        System.out.print("Enter the amount you want to withdraw: ");
        double amount;
        while (true) {
            try {
                amount = sc.nextDouble();
                if (String.valueOf(amount).isBlank()) {
                    System.out.println("This field can't be empty...Set again: ");
                }
                if (amount <= 0) {
                    System.out.println("your amount can't be negative or zero.Enter again:");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Amount can't be non-numeric..Enter again:");
                sc.nextLine();
            }
        }

        // Read the user account information from the text file
        BufferedReader br = new BufferedReader(new FileReader("customersOf1.txt"));
        String line;
        String accountData = "";
        while ((line = br.readLine()) != null) {
            String[] accountInfo = line.split("#");
            if (accountInfo[3].equals(cnic)) {   // Account is found..balance checked and updated
                double currentBalance = Double.parseDouble(accountInfo[4]);
                if (amount > currentBalance) {
                    System.out.println("Insufficient balance...cannot withdraw this amount now");
                     displaycustomermenu(); //call customer menuu.........
                } else {
                    currentBalance -= amount;
                    System.out.println("Amount withdrawn Successfully.......");
                    accountInfo[4] = String.valueOf(currentBalance);
                }
            }
            // Add the updated account information to the new data string
            accountData += accountInfo[0] + "#" + accountInfo[1] + "#" + accountInfo[2] + "#" + accountInfo[3] + "#"
                    + accountInfo[4] + "#" + accountInfo[5] + "\n";
        }
        br.close();

        // Write the updated account information to the text file
        BufferedWriter bw = new BufferedWriter(new FileWriter("customersOf1.txt"));
        bw.write(accountData);
        bw.close();
    }
            
        // deposit method............................................................................................................
        public static void deposit() throws IOException {
            String cnic;
            // File path of the user account text file
            String filePath = "customersOf1.txt";

            // Get the user's account information
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your CNIC(format:00000-0000000-0) to deposit amount:");
            while (true) {
                cnic = sc.next();
                if (cnic.isBlank()) {
                    System.out.println("This field can't be empty...");
                } else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            System.out.print("Enter the amount you want to deposit: ");
            double amount;
            while (true) {
                try {
                    amount = sc.nextDouble();
                    if (String.valueOf(amount).isBlank()) {
                        System.out.println("This field can't be empty...Set again: ");
                    } else if (amount <= 0) {
                        System.out.println("your amount can't be negative or zero.Enter again:");
                    } else if (amount > 1000000) {
                        System.out.println("Sorry!! you cannot deposit more than 10 lac at a time..try again:");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Amount can't be non-numeric..Enter again:");
                    sc.nextLine();
                }
            }

            // Read the user account information from the text file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            String accountData = "";
            while ((line = br.readLine()) != null) {
                String[] accountInfo = line.split("#");
                if (accountInfo[3].equals(cnic)) {
                    double currentBalance = Double.parseDouble(accountInfo[4]);
                    currentBalance += amount;
                    System.out.println("Amount deposited successfully........");
                    accountInfo[4] = String.valueOf(currentBalance);
                }
                // Add the updated account information to the new data string
                accountData += accountInfo[0] + "#" + accountInfo[1] + "#" + accountInfo[2] + "#" + accountInfo[3] + "#"
                        + accountInfo[4] + "#" + accountInfo[5] + "\n";
            }
            br.close();

            // Write the updated account information to the text file
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(accountData);
            bw.close(); }  // method closed

    // transfer cash method.....................................................................................................................
        public static void transfercash() throws IOException {
            Scanner sc = new Scanner(System.in);
            String sendercnic;
            String receivercnic;
            System.out.println("Enter  CNIC(format:00000-0000000-0) of sender:");
            while (true) {
                sendercnic = sc.next();
                if (sendercnic.isBlank()) {
                    System.out.println("This field can't be empty...");
                } else if (!(sendercnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            System.out.println("Enter  CNIC(format:00000-0000000-0) of receiver:");
            while (true) {
                receivercnic = sc.next();
                if (receivercnic.isBlank()) {
                    System.out.println("This field can't be empty...");
                } else if (!(receivercnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break; }
            }
            System.out.print("Enter the amount you want to transfer: ");
            double amount;
            while (true) {
                try {
                    amount = sc.nextDouble();
                    if (String.valueOf(amount).isBlank()) {
                        System.out.println("This field can't be empty...Set again: ");
                    }
                    if (amount <= 0) {
                        System.out.println("your amount can't be negative or zero.Enter again:");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Amount can't be non-numeric..Enter again:");
                    sc.nextLine(); }
            } 
            // Read the user account information from the text file
            BufferedReader br = new BufferedReader(new FileReader("customersOf1.txt"));
            String line;
            String accountData = "";
            while ((line = br.readLine()) != null) { // line by line read till end of file 
                String[] accountInfo = line.split("#");  // get all account information of single cnic
                if (accountInfo[3].equals(sendercnic)) {
                    double currentBalance = Double.parseDouble(accountInfo[4]);
                    if (amount > currentBalance) {
                        System.out.println("Insufficient balance...Transfer Process not completed!! ");
                        displaycustomermenu(); //call customer menu............
                        break;
                    } else {
                        currentBalance -= amount;
                        System.out.println("Amount withdrawn from sender account..........");
                        accountInfo[4] = String.valueOf(currentBalance); }
                    }
                else if (accountInfo[3].equals(receivercnic)) {
                    double currntBalance = Double.parseDouble(accountInfo[4]);
                    currntBalance += amount;
                    System.out.println("Amount deposited to receiver account.........");
                    accountInfo[4] = String.valueOf(currntBalance); }
                else { }
                // Add the updated account information to the new data string
                accountData += accountInfo[0] + "#" + accountInfo[1] + "#" + accountInfo[2] + "#" + accountInfo[3] + "#"
                        + accountInfo[4] + "#" + accountInfo[5] + "\n"; 
            } // whole file is read 
            br.close();
            // Write the updated account information to the text file
            BufferedWriter bw = new BufferedWriter(new FileWriter("customersOf1.txt"));
            bw.write(accountData);
            bw.close();
        }
    } // branch01 class closed

    // ______________________________________________________________________BRANCH02________________________________________________________________
    class branch02 {
        public static Scanner input = new Scanner(System.in);

        public static void menu() {
            System.out.println("CHOOSE  YOUR    STATUS: ");
            System.out.println("---------------------------------------------");
            System.out.println("1. You are Admin");
            System.out.println("2. You are Employee");
            System.out.println("3. You are Customer");
            System.out.println("4. Return to Menu of Branches");
            System.out.println("5. Exit the system");
            int opt;
            // validation check on user input
            while (true) {
                try {
                    opt = input.nextInt();
                    while (!(opt == 1 || opt == 2 || opt == 3 || opt == 4 || opt == 5) || (String.valueOf(opt).isBlank())) {
                        System.out.println("Invalid option.Choose option from menu please: ");
                        opt = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Integer value only please...:");
                    input.nextLine();
                }
            }
            switch (opt) {
                case 1: {
                    System.out.println("YOU ARE ADMIN");
                    login_admin(); // call admin login
                    System.out.println("Choose your authority:");
                    displayadminmenu();
                    break;
                }
                case 2: {
                    System.out.println("YOU ARE EMPLOYEE");
                    login_employee_menu(); // employee login / sign up first
                    displayemployeemenu();
                    break;
                }
                case 3: {
                    System.out.println("YOU ARE A CUSTOMER");
                    login_customer_menu(); // customer login / sign up first
                    displaycustomermenu();
                    break;
                }
                case 4: {
                    System.out.println("Returning to branch Menu");
                    project.main(null);
                    break;
                }
                default: {
                    System.out.println("You are exiting the system....Thank you for using our services!!! ");
                    System.exit(1);
                    break;
                }
            } // switch closed
        } // menu method closed

        public static void displayadminmenu() {
            System.out.println("1. Add Employees:");
            System.out.println("2. View Employees:");
            System.out.println("3. Search Employees:");
            System.out.println("4. Edit Employees:");
            System.out.println("5. Delete Employees:");
            System.out.println("6. View Customers:");
            System.out.println("7. Return to Main Menu of current Branch");
            System.out.println("8. Exit system");
            System.out.println("-------------------------------------");
            System.out.println("Enter your choice: ");
            int choice;
            // validation check on user input
            while (true) {
                try {
                    choice = input.nextInt();
                    while (!(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6
                            || choice == 7 || choice == 8) || (String.valueOf(choice).isBlank())) {
                        System.out.println("Invalid option.Choose option from menu: ");
                        choice = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Integer value only please...:");
                    input.nextLine();
                }
            }
            switch (choice) {
                case 1: {
                    try {
                    addemployees(); }
                    catch (Exception e) { 
                        e.printStackTrace(); }
                    displayadminmenu();
                }
                    break;
                case 2: {
                    try {
                        viewemployees();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayadminmenu();
                }
                    break;
                case 3: {
                    try {
                        searchemployee();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayadminmenu();
                }
                    break;
                case 4: {
                    try {
                        editemployee();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayadminmenu();
                }
                case 5: {
                    try {
                        deletemployee();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayadminmenu();
                }
                case 6: {
                    try {
                        viewcustomers();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayadminmenu();
                }
                    break;
                case 7: {
                    System.out.println("Returning to Menu of Branch 02");
                    branch02.menu();
                }
                    break;
                default: {
                    System.out.println("You are exiting the system...Thank you for using our services!! ");
                    System.exit(1);
                }
            }// admin switch closed
        } // method closed

    // employee menu method................................................................................................................
        public static void displayemployeemenu() {
            System.out.println("1. Add Customer account:");
            System.out.println("2. View Customers Account:");
            System.out.println("3. Search Customer Account:");
            System.out.println("4. Edit Customer Account:");
            System.out.println("5. Delete Customer Account:");
            System.out.println("6. Return to Main Menu Current of Branch:");
            System.out.println("7. Exit the system:");
            System.out.println("-------------------------------------");
            System.out.println("Enter your choice: ");
            int ch;
            // validation check on user input
            while (true) {
                try {
                    ch = input.nextInt();
                    while (!(ch == 1 || ch == 2 || ch == 3 || ch == 4 || ch == 5 || ch == 6 || ch == 7) || (String.valueOf(ch).isBlank())) {
                        System.out.println("Invalid option.Choose option from menu: ");
                        ch = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Integer value only please...:");
                    input.nextLine();
                }
            }
            switch (ch) {
                case 1: {
                    try {
                    addcustomeraccount(); }
                    catch(Exception e) {
                        e.printStackTrace();
                    }
                    displayemployeemenu();
                }
                    break;
                case 2: {
                    try {
                        viewcustomeraccount();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayemployeemenu();
                }
                    break;
                case 3: {
                    try {
                        searchcustomer();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayemployeemenu();
                }
                    break;
                case 4: {
                    try {
                        editcustomer();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayemployeemenu();
                }
                case 5: {
                    try {
                        deletecustomer();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displayemployeemenu();
                }
                    break;
                case 6: {
                    System.out.println("Returning to Menu");
                    branch02.menu();
                }
                    break;
                default: {
                    System.out.println("You are exiting the system...Thank you for using our services!! ");
                    System.exit(1);
                }
            } // employee switch closed.....
        }// employee method closed...............................

    // CUSTOMER MENU METHOD.................................................................................................................
        public static void displaycustomermenu() {
            System.out.println("1. View account");
            System.out.println("2. Withdraw cash");
            System.out.println("3. Deposit cash");
            System.out.println("4. Transfer cash");
            System.out.println("5. Return to Main Menu Current of Branch");
            System.out.println("6. exit the system");
            System.out.println("-------------------------------------");
            System.out.println("Enter your choice: ");
            int option;
            // validation check on user input
            while (true) {
                try {
                    option = input.nextInt();
                    while (!(option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6) || (String.valueOf(option).isBlank())) {
                        System.out.println("Invalid option.Choose option from menu: ");
                        option = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Integer value only please...:");
                    input.nextLine();
                }
            }
            switch (option) {
                case 1: {
                    try {
                        viewcustomeraccount();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displaycustomermenu();
                }
                    break;
                case 2: {
                    try {
                        withdraw();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displaycustomermenu();
                }
                    break;
                case 3: {
                    try {
                        deposit();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displaycustomermenu();
                }
                    break;
                case 4: {
                    try {
                        transfercash();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    displaycustomermenu();
                }
                    break;
                case 5: {
                    System.out.println("Returning to Menu");
                    branch02.menu();
                }
                    break;
                default: {
                    System.out.println("You are exiting the system...Thank you for using our services!! ");
                    System.exit(1);
                }
                    break;
            }// customer switch closed....
        }// customer method closed............................................

    // ............................................................all employee methods......................................................
        
        public static void addcustomeraccount() {
            int sentinel = 0;
            String cnic, name, accountno;
            int lenphoneno;
            String phoneno;
            int age;
            double balance;
            int num;
            String[][] details = new String[10][6];
            while (sentinel == 0) {
                if (y == details.length - 1) {
                    System.out.println("sorry array is full");
                    break;
                } else {
                    System.out.println("enter customer name:");
                    while (true) {
                        name = st.nextLine();
                        if (name.isBlank()) {
                            System.out.println("Enter name...this field cannot be empty:");
                        } else if (name.length() > 30) {
                            System.out.println("Your name cannot exceed 30 characters..try again:");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Non-alphabetic characters detected in name..please enter alphabets only!!:");
                        } else {
                            break;
                        }
                    }
                    details[y][0] = name;
                    System.out.println("enter customer age:");
                    while (true) {
                        try {
                            age = input.nextInt();
                            if (String.valueOf(age).isBlank()) {
                                System.out.println("this field cannot be empty..enter age: ");
                            }
                            else if (age < 0) {
                                System.out.println("Your age can't be negative numbers...Set again: ");
                            } else if (age < 18) {
                                System.out.println("Your age can't be less than 18...Set again: ");
                            } else if (age > 100) {
                                System.out.println("Your age can't be more  than 100...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Non numeric age is not excepted..Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[y][1] = String.valueOf(age);
                    System.out.println("enter customer phone no(without dashes):");
                    while (true) {
                        phoneno = st.nextLine();
                        lenphoneno = phoneno.length();
                        if (phoneno.isBlank()) {
                            System.out.println("Enter phone No...this field cannot be empty:");
                        } else if (lenphoneno > 11 || lenphoneno < 11) {
                            System.out.println("Your phone No cannot exceed or less than 11 numbers..try again:");
                        } else if (!phoneno.matches("[0-9]+")) {
                            System.out.println("Phone no cannot contain characters or can't be negative..Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[y][2] = String.valueOf(phoneno);
                    System.out.println("enter CNIC in format(00000-0000000-0)");
                    while (true) {
                        cnic = st.next();
                        if (cnic.isBlank()) {
                            System.out.println("This field cannot be empty..enter cnic: ");
                        }
                        else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                            System.out.println("Invalid CNIC. Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[x][3] = cnic;
                    System.out.println("enter customer initial balance:");
                    while (true) {
                        try {
                            balance = input.nextDouble();
                            if (balance < 0) {
                                System.out.println("Your balance can't be  negative...Set again: ");
                            } else if (balance > 800000) {
                                System.out.println("Deposit upto 800000 only please :");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Balance can't be non-numeric.Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[y][4] = String.valueOf(balance);
                    Random r = new Random();
                    num = r.nextInt(2000000);
                    accountno = "B02-" + String.valueOf(num);
                    details[y][5] = accountno;
                    System.out.println("Your account has been created");
                    try {
                        FileWriter file = new FileWriter("customersOf2.txt", true);
                        for (int i = 0; i <= y; i++) {
                            file.write(details[i][0] + "#");
                            file.write(details[i][1] + "#");
                            file.write(details[i][2] + "#");
                            file.write(details[i][3] + "#");
                            file.write(details[i][4] + "#");
                            file.write(details[i][5]);
                            file.write("\n");
                        }
                        System.out.println("....Data is successfully stored in file....");
                        file.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }  
                    displayemployeemenu();                
                    y++; // increment customer count of branch 2
                } // else closed
            } // outer while closed
        } // method closed

        public static void viewcustomeraccount() throws FileNotFoundException {
            File file = new File("customersOf2.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split("#");
                System.out.println("Name: " + details[0]);
                System.out.println("Age: " + details[1]);
                System.out.println("Phone no: " + details[2]);
                System.out.println("CNIC: " + details[3]);
                System.out.println("Balance: " + details[4]);
                System.out.println("Account no: " + details[5]);
                System.out.println("-------------------------------------------------");
            }
            sc.close();
        } // method closed

        public static void searchcustomer() throws FileNotFoundException {
            String cnic;
            try {
                File file = new File("customersOf2.txt");
                Scanner sc = new Scanner(file);
                System.out.println("Enter the CNIC(format:00000-0000000-0) of the customer you want to search");
                while (true) {
                    cnic = st.next();
                    if (cnic.isBlank()){
                        System.out.println("This field cannot be empty..enter cnic: ");
                    }
                    else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                        System.out.println("Invalid CNIC. Set again: ");
                    } else {
                        break;
                    }
                }
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] details = line.split("#");
                    if (details[3].equals(cnic)) {
                        System.out.println("Name: " + details[0]);
                        System.out.println("Age: " + details[1]);
                        System.out.println("Phone no: " + details[2]);
                        System.out.println("CNIC: " + details[3]);
                        System.out.println("Balance: " + details[4]);
                        System.out.println("Account no: " + details[5]);
                    }
                }
                sc.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } // method closed

        public static void editcustomer() throws FileNotFoundException {
            String name, cnic, phoneno; // declaring variables.............
            int lenName, lenphoneno, age;
            double balance;
            File file = new File("customersOf2.txt");
            Scanner sc = new Scanner(file);
            System.out.println("Enter the CNIC(format:00000-0000000-0) of the customer you want to edit");
            while (true) {
                cnic = st.next(); 
                if(cnic.isBlank()) {
                    System.out.println("This field cannot be empty...enter cnic:");
                }
                else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            String[][] editedRecords = new String[100][6];
            int i = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split("#");
                if (details[3].equals(cnic)) {
                    System.out.println("Enter the new name");
                    while (true) {
                        name = st.nextLine();
                        lenName = name.length();
                        if (name.isBlank()) {
                            System.out.println("Enter name...this field cannot be empty:");
                        } else if (lenName > 30) {
                            System.out.println("Your name caanot exceed 30 characters..try again:");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Non-alphabetic characters detected in name..please enter alphabets only!!:");
                        } else {
                            break;
                        }
                    }
                    details[0] = name;
                    System.out.println("Enter the new age");
                    while (true) {
                        try {
                            age = input.nextInt();
                            if (String.valueOf(age).isBlank()) {
                                System.out.println("This field cannot be empty..enter age: ");
                            }
                            else if (age < 0) {
                                System.out.println("Your age can't be negative numbers...Set again: ");
                            } else if (age < 18) {
                                System.out.println("Your age can't be less than 18...Set again: ");
                            } else if (age > 100) {
                                System.out.println("Your age can't be more  than 100...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Non numeric age is not excepted..Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[1] = String.valueOf(age);
                    System.out.println("Enter the new phone no");
                    while (true) {
                        phoneno = st.nextLine();
                        lenphoneno = phoneno.length();
                        if (phoneno.isBlank()) {
                            System.out.println("Enter phone No...this field cannot be empty:");
                        } else if (lenphoneno > 11 || lenphoneno < 11) {
                            System.out.println("Your phone No cannot exceed or less than 11 numbers..try again:");
                        } else if (!phoneno.matches("[0-9]+")) {
                            System.out.println("Phone no cannot contain characters or can't be nagative..Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[2] = phoneno;
                    System.out.println("Enter the new balance");
                    while (true) {
                        try {
                            balance = input.nextDouble();
                            if (String.valueOf(balance).isBlank()) {
                                System.out.println("This field cannot be empty..enter some balance amount: ");
                            }
                            else if (balance < 0) {
                                System.out.println("Your balance can't be negative...Set again: ");
                            } else if (balance > 8000000) {
                                System.out.println("Your account limit is 80 lac only..try again:");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Balance can't be non-numeric.Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[3] = cnic;
                    details[4] = String.valueOf(balance);
                    details[5] = details[5];
                    editedRecords[i] = details;
                    i++;
                } else {
                    editedRecords[i] = details;
                    i++;
                }
            }
            sc.close();
            try {
                FileWriter newfile = new FileWriter("customersOf2.txt");
                for (int j = 0; j <= i-1 ; j++) {
                    newfile.write(editedRecords[j][0] + "#");
                    newfile.write(editedRecords[j][1] + "#");
                    newfile.write(editedRecords[j][2] + "#");
                    newfile.write(editedRecords[j][3] + "#");
                    newfile.write(editedRecords[j][4] + "#");
                    newfile.write(editedRecords[j][5]);
                    newfile.write("\n");
                }
                newfile.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } // method closed

        public static void deletecustomer() throws IOException {
            File originalFile = new File("customersOf2.txt");
            File tempFile = new File("temp.txt");
            Scanner in = new Scanner(System.in);
            String cnic;
            System.out.println("Enter the cnic(format:00000-0000000-0) of the customer you want to delete: ");
            while (true) {
                cnic = in.nextLine();
                if (cnic.isBlank()) {
                    System.out.println("This field cannot be empty...Set again: ");
                }
                else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            // Open the original text file and the temporary text file
            try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                // Read the contents of the original text file and remove the specific record at the given cnic
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.contains(cnic)) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            originalFile.delete();  // delete original file
            if (tempFile.renameTo(originalFile)) {   // and rename temp file to original file
                System.out.println("customer deleted succesfully!");
            } else {
                System.out.println("Failed to rename the temp file");
            }
    
        } // method closed

    //....................................employee methods..............................used by admin.......................................
        public static void addemployees() {
            int control = 0;
            String name;
            String cnic;
            double salary;
            String phoneno;
            int age;
            int lenphoneno;
            String[][] details = new String[10][6];
            while (control == 0) {
                if (z == details.length - 1) {
                    System.out.println("sorry array is full");
                    break;
                } else {
                    System.out.println("enter employee name");
                    while (true) {
                        name = st.nextLine();
                        if (name.isBlank()) {
                            System.out.println("Enter name...this field cannot be empty:");
                        } else if (name.length() > 30) {
                            System.out.println("Your name cannot exceed 30 characters..try again:");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Non-alphabetic characters detected in name..please enter alphabets only!!:");
                        } else {
                            break;
                        }
                    }
                    details[z][0] = name;
                    System.out.println("enter employee age:");
                    while (true) {
                        try {
                            age = input.nextInt();
                            if (String.valueOf(age).isBlank()) {
                                System.out.println("This field cannot be empty..enter age: ");
                            }
                            else if (age < 0) {
                                System.out.println("Your age can't be negative numbers...Set again: ");
                            } else if (age < 18) {
                                System.out.println("Your age can't be less than 18...Set again: ");
                            } else if (age > 100) {
                                System.out.println("Your age can't be more  than 100...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Non numeric age is not excepted..Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[z][1] = String.valueOf(age);
                    System.out.println("enter employee phone no(without dashes):");
                    while (true) {
                        phoneno = st.nextLine();
                        lenphoneno = phoneno.length();
                        if (phoneno.isBlank()) {
                            System.out.println("Enter phone No...this field cannot be empty:");
                        } else if (lenphoneno > 11 || lenphoneno < 11) {
                            System.out.println("Your phone No cannot exceed or less than 11 digits..try again:");
                        } else if (!phoneno.matches("[0-9]+")) {
                            System.out.println("Phone no cannot contain characters or can't be negative..Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[z][2] = phoneno;
                    System.out.println("enter CNIC in format(00000-0000000-0)");
                    while (true) {
                        cnic = st.next();
                        if (cnic.isBlank()) {
                            System.out.println("This field cannot be empty..enter cnic: ");
                        }
                        else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                            System.out.println("Invalid CNIC. Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[z][3] = cnic;
                    System.out.println("enter employee's salary in range 15,000 to 5,000,000: ");
                    while (true) {
                        try {
                            salary = input.nextDouble();
                            if (String.valueOf(salary).isBlank()) {
                                System.out.println("This field cannot be empty..enter salary: ");
                            }
                            else if (salary <= 0) {
                                System.out.println("Salary can't be zero or negative...Set again: ");
                            } else if (salary < 15000 || salary > 5000000) {
                                System.out.println("employee Salary can't be in this range ...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Salary can't be non-numeric.Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[z][4] = String.valueOf(salary);
                    System.out.println("Employee's data has been stored");
                    try {
                        FileWriter file = new FileWriter("employeesOf2.txt", true);
                        for (int i = 0; i <= z; i++) {
                            file.write(details[i][0] + "#");
                            file.write(details[i][1] + "#");
                            file.write(details[i][2] + "#");
                            file.write(details[i][3] + "#");
                            file.write(details[i][4]);
                            file.write("\n");
                        }
                        System.out.println("....Data is successfully stored in file....");
                        file.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    System.out.println("Record Saved");
                    displayadminmenu();
                    z++; // employee count increment in branch02
                } // else closed
            } // outer while closed
        } // outer while closed

        public static void viewemployees() throws FileNotFoundException {
            try {
                File file = new File("employeesOf2.txt");
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] details = line.split("#");
                    System.out.println("Name: " + details[0]);
                    System.out.println("Age: " + details[1]);
                    System.out.println("Phone no: " + details[2]);
                    System.out.println("CNIC: " + details[3]);
                    System.out.println("SALARY:  " + details[4]);
                    System.out.println("-------------------------------------------------");
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        } // method closed

        public static void searchemployee() throws FileNotFoundException {
            String cnic;
            try {
                File file = new File("employeesOf2.txt");
                Scanner sc = new Scanner(file);
                System.out.println("Enter the CNIC(format:00000-0000000-0) of the employee you want to search");
                while (true) {
                    cnic = st.next();
                    if (cnic.isBlank()) {
                        System.out.println("This field cannot be empty..enter cnic: ");
                    }
                    else if (cnic.isBlank()) {
                        System.out.println("This field cannot be empty..enter cnic: ");
                    }
                    else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                        System.out.println("Invalid CNIC. Set again: ");
                    } else {
                        break;
                    }
                }
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] details = line.split("#");
                    if (details[3].equals(cnic)) {
                        System.out.println("Name: " + details[0]);
                        System.out.println("Age: " + details[1]);
                        System.out.println("Phone no: " + details[2]);
                        System.out.println("CNIC: " + details[3]);
                        System.out.println("SALARY:  " + details[4]);
                        System.out.println("______________________________________________________________");
                    }
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        } // method closed

        public static void editemployee() throws FileNotFoundException {
            String cnic;
            String name, phoneno;
            int lenName, lenphoneno;
            double salary;
            int age;
            File file = new File("employeesOf2.txt");
            Scanner sc = new Scanner(file);
            System.out.println("Enter the cnic(format:00000-0000000-0) of the employee you want to edit");
            while (true) {
                cnic = st.next();
                if (cnic.isBlank()) {
                    System.out.println("This field cannot be empty..enter cnic: ");
                }
                else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            String[][] editedRecords = new String[200][5];
            int i = 0;
            // first read form file and edit
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split("#");
                if (details[3].equals(cnic)) {
                    System.out.println("Enter the new name");
                    while (true) {
                        name = st.nextLine();
                        lenName = name.length();
                        if (name.isBlank()) {
                            System.out.println("Enter name...this field cannot be empty:");
                        } else if (lenName > 30) {
                            System.out.println("Your name caanot exceed 30 characters..try again:");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Non-alphabetic characters detected in name..please enter alphabets only!!:");
                        } else {
                            break;
                        }
                    }
                    details[0] = name;
                    System.out.println("Enter the new age");
                    while (true) {
                        try {
                            age = input.nextInt();
                            if (String.valueOf(age).isBlank()) {
                                System.out.println("This field cannot be empty..enter age: ");
                            }
                            else if (age < 0) {
                                System.out.println("Your age can't be negative numbers...Set again: ");
                            } else if (age < 18) {
                                System.out.println("Your age can't be less than 18...Set again: ");
                            } else if (age > 100) {
                                System.out.println("Your age can't be more than 100...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Non numeric age is not excepted..Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[1] = String.valueOf(age);
                    System.out.println("Enter the new phone no(without dashes): ");
                    while (true) {
                        phoneno = st.nextLine();
                        lenphoneno = phoneno.length();
                        if (phoneno.isBlank()) {
                            System.out.println("Enter phone No...this field cannot be empty:");
                        } else if (lenphoneno > 11 || lenphoneno < 11) {
                            System.out.println("Your phone No cannot exceed or less than 11 numbers..try again:");
                        } else if (!phoneno.matches("[0-9]+")) {
                            System.out.println("Phone no cannot contain characters or can't be nagative..Set again: ");
                        } else {
                            break;
                        }
                    }
                    details[2] = phoneno;
                    System.out.println("Enter the new salary: ");
                    while (true) {
                        try {
                            salary = input.nextDouble();
                            if (String.valueOf(salary).isBlank()) {
                                System.out.println("This field cannot be empty..enter salary: ");
                            }
                            else if (salary <= 0) {
                                System.out.println("Salary can't be zero or negative...Set again: ");
                            } else if (salary < 15000 || salary > 5000000) {
                                System.out.println("employee Salary can't be in this range...Set again: ");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Salary can't be non-numeric.Enter again: ");
                            input.nextLine();
                        }
                    }
                    details[3] = cnic;
                    details[4] = String.valueOf(salary);
                    editedRecords[i] = details;
                } else {
                    editedRecords[i] = details;
                }
                i++;
            }
            sc.close();
            // then write into same file
            try {
                FileWriter newfile = new FileWriter("employeesOf2.txt");
                for (int j = 0; j <= i - 1; j++) {
                    newfile.write(editedRecords[j][0] + "#");
                    newfile.write(editedRecords[j][1] + "#");
                    newfile.write(editedRecords[j][2] + "#");
                    newfile.write(editedRecords[j][3] + "#");
                    newfile.write(editedRecords[j][4]);
                    newfile.write("\n");
                }
                newfile.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public static void deletemployee() throws IOException {
            File originalFile = new File("employeesOf2.txt");
            File tempFile = new File("temp.txt");
            Scanner in = new Scanner(System.in);
            String cnic;
            System.out.println("Enter the cnic(format:00000-0000000-0) of the customer you want to delete");
            while (true) {
                cnic = in.nextLine();
                if (cnic.isBlank()) {
                    System.out.println("This field cannot be empty...Set again: ");
                }
                else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            // Open the original text file and the temporary text file
            try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                // Read the contents of the original text file and remove the specific string
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.contains(cnic)) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            originalFile.delete();
            // Rename the temporary text file to the name of the original text file using the renameTo() method
            if (tempFile.renameTo(originalFile)) {
                System.out.println("employee record deleted successfully");
            } else {
                System.out.println("Failed to rename the temp file");
            }
    
        } // method closed

    public static void viewcustomers() throws FileNotFoundException {
            File file = new File("customersOf2.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split("#");
                System.out.println("Name: " + details[0]);
                System.out.println("Age: " + details[1]);
                System.out.println("Phone no: " + details[2]);
                System.out.println("CNIC: " + details[3]);
                System.out.println("Balance: " + details[4]);
                System.out.println("Account no: " + details[5]);
                System.out.println("-------------------------------------------------");
            }
            sc.close();
        } // method closed

    // customer methods......................................used by customer............................................................
    
        // withdraw method.......................
        public static void withdraw() throws IOException {
            Scanner sc = new Scanner(System.in);
            String cnic;
            System.out.println("Enter your CNIC(format:00000-0000000-0) to withdraw amount:");
            while (true) {
                cnic = sc.next();
                if (cnic.isBlank()) {
                    System.out.println("This field can't be empty...");
                } else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            System.out.print("Enter the amount you want to withdraw: ");
            double amount;
            while (true) {
                try {
                    amount = sc.nextDouble();
                    if (String.valueOf(amount).isBlank()) {
                        System.out.println("This field can't be empty...Set again: ");
                    }
                    if (amount <= 0) {
                        System.out.println("your amount can't be negative or zero.Enter again:");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Amount can't be non-numeric..Enter again:");
                    sc.nextLine();
                }
            }
    
            // Read the user account information from the text file
            BufferedReader bf = new BufferedReader(new FileReader("customersOf2.txt"));
            String line;
            String accountData = "";
            // boolean accountFound = false;
            while ((line = bf.readLine()) != null) {
                String[] accountInfo = line.split("#");
                if (accountInfo[3].equals(cnic)) {
                    // Account found, update the balance
                    double currentBalance = Double.parseDouble(accountInfo[4]);
                    if (amount > currentBalance) {
                        System.out.println("Insufficient balance....cannot withdraw this amount");
                         displaycustomermenu(); //call customer menuu.........
                    } else {
                        currentBalance -= amount;
                        System.out.println("Amount withdrawn successfully.......");
    
                        accountInfo[4] = String.valueOf(currentBalance);
                        // accountFound = true;
                    }
                }
                // Add the updated account information to the new data string
                accountData += accountInfo[0] + "#" + accountInfo[1] + "#" + accountInfo[2] + "#" + accountInfo[3] + "#"
                        + accountInfo[4] + "#" + accountInfo[5] + "\n";
            }
            bf.close();
    
            // Write the updated account information to the text file
            BufferedWriter bw = new BufferedWriter(new FileWriter("customersOf2.txt"));
            bw.write(accountData);
            bw.close(); 
        }

        // deposit method.................
        public static void deposit() throws IOException {
            String cnic;
            // File path of the user account text file
            String filePath = "customersOf2.txt";
            // Get the user's account information
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your CNIC(format:00000-0000000-0) to deposit amount:");
            while (true) {
                cnic = sc.next();
                if (cnic.isBlank()) {
                    System.out.println("This field can't be empty...");
                } else if (!(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            System.out.print("Enter the amount you want to deposit: ");
            double amount;
            while (true) {
                try {
                    amount = sc.nextDouble();
                    if (String.valueOf(amount).isBlank()) {
                        System.out.println("This field can't be empty...Set again: ");
                    } else if (amount <= 0) {
                        System.out.println("your amount can't be negative or zero.Enter again:");
                    } else if (amount > 1000000) {
                        System.out.println("Sorry!! you cannot deposit more than 10 lac at a time..try again:");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Amount can't be non-numeric..Enter again:");
                    sc.nextLine();
                }
            }
            // Read the user account information from the text file using cnic
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            String accountData = "";
            while ((line = br.readLine()) != null) {
                String[] accountInfo = line.split("#");
                if (accountInfo[3].equals(cnic)) {
                    double currentBalance = Double.parseDouble(accountInfo[4]);
                    currentBalance += amount;
                    System.out.println("Amount deposited successfully........");
                    accountInfo[4] = String.valueOf(currentBalance);
                }
                // Add the updated account information to the new data string
                accountData += accountInfo[0] + "#" + accountInfo[1] + "#" + accountInfo[2] + "#" + accountInfo[3] + "#"
                        + accountInfo[4] + "#" + accountInfo[5] + "\n";
            }
            br.close();
            // Write the updated account information to the text file
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(accountData);
            bw.close();
        } // method closed

        // transfer cash.................
        public static void transfercash() throws IOException,FileNotFoundException {
            Scanner sc = new Scanner(System.in);
            String sendercnic;
            String receivercnic;
            System.out.println("Enter  CNIC(format:00000-0000000-0) of sender:");
            while (true) {
                sendercnic = sc.next();
                if (sendercnic.isBlank()) {
                    System.out.println("This field can't be empty...");
                } else if (!(sendercnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break;
                }
            }
            System.out.println("Enter  CNIC(format:00000-0000000-0) of receiver:");
            while (true) {
                receivercnic = sc.next();
                if (receivercnic.isBlank()) {
                    System.out.println("This field can't be empty...");
                } else if (!(receivercnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))) {
                    System.out.println("Invalid CNIC. Set again: ");
                } else {
                    break; }
            }
            System.out.print("Enter the amount you want to transfer: ");
            double amount;
            while (true) {
                try {
                    amount = sc.nextDouble();
                    if (String.valueOf(amount).isBlank()) {
                        System.out.println("This field can't be empty...Set again: ");
                    }
                    if (amount <= 0) {
                        System.out.println("your amount can't be negative or zero.Enter again:");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Amount can't be non-numeric..Enter again:");
                    sc.nextLine(); }
            } 
            // Read the user account information from the text file
            BufferedReader br = new BufferedReader(new FileReader("customersOf2.txt"));
            String line;
            String accountData = "";
            while ((line = br.readLine()) != null) { // line by line read till end of file 
                String[] accountInfo = line.split("#");  // get all account information of single cnic
                if (accountInfo[3].equals(sendercnic)) {
                    double currentBalance = Double.parseDouble(accountInfo[4]);
                    if (amount > currentBalance) {
                        System.out.println("Insufficient balance...Sorry Transfer Process not completed!! ");
                        displaycustomermenu(); //call customer menu............
                        break;
                    } else {
                        currentBalance -= amount;
                        System.out.println("Amount withdrawn from sender account..........");
                        accountInfo[4] = String.valueOf(currentBalance); }
                    }
                else if (accountInfo[3].equals(receivercnic)) {
                    double currntBalance = Double.parseDouble(accountInfo[4]);
                    currntBalance += amount;
                    System.out.println("Amount deposited to receiver account.........");
                    accountInfo[4] = String.valueOf(currntBalance); }
                else { }
                // Add the updated account information to the new data string
                accountData += accountInfo[0] + "#" + accountInfo[1] + "#" + accountInfo[2] + "#" + accountInfo[3] + "#"
                        + accountInfo[4] + "#" + accountInfo[5] + "\n"; 
            } // whole file is read 
            br.close();
            // Write the updated account information to the text file
            BufferedWriter bw = new BufferedWriter(new FileWriter("customersOf2.txt"));
            bw.write(accountData);
            bw.close(); 
        } // method closed
    } // branch02 class closed

    // _________________________________________________________________________METHODS SHARED BY BRANCHES___________________________________________
      // Admin login method.........................................

    public static void login_admin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String uName;
        // empty input field validation
        while (true) {
            uName = sc.nextLine();
            if (uName.isBlank()) {
                System.out.println("This field cannot be empty...enter again:");
            } else {
                break;
            }
        }
        System.out.println("Enter your Password: ");
        String pass;
        while (true) {
            pass = sc.nextLine();
            if (pass.isBlank()) {
                System.out.println("This field cannot be empty....enter again:");
            } else {
                break;
            }
        }
        uName = uName.trim();
        pass = pass.trim();
        String given = uName + " " + pass; // string containing user given inputs
        try {
            File inFile = new File("admin_logins.txt");
            if (!inFile.exists())
                inFile.createNewFile();
            Scanner in = new Scanner(inFile);
            boolean login_check = false;
            while (in.hasNextLine()) {
                String data = in.nextLine();
                if (data.equals(given)) {
                    System.out.println("Login Successful!!");
                    System.out.println("You can continue further...");
                    //System.out.println("-----------------------------------------------------------------------------------");
                    login_check = true;
                    break;
                }
            }
            in.close();
            if (!(login_check)) {
                System.out.println("Incorrect password..or incorrect username..login Failed..");
                login_admin();
            } // demand login from admin again
        } catch (Exception e) {
            System.out.println(e);
        }
    } // method closed

    // ........................employee login interface.............................

    public static void login_employee_menu() {
        System.out.println("\t\t Login/Sign up Menu");
        System.out.println("1. sign up");
        System.out.println("2. log in");
        int o;
        while (true) {
            try {
                System.out.println("Enter your choice: ");
                o = input.nextInt();
                while (!(o == 1 || o == 2) || (String.valueOf(o).isBlank())) {
                    System.out.println("Invalid option.Choose option from menu: ");
                    o = input.nextInt();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Only integer option is allowed!!...");
                input.nextLine();
            }
        }
        switch (o) {
            case 1:
                signup_employee();
                break;
            case 2:
                login_employee();
                break;
        }
    } // method closed

      // .........................................................signup Employee method...................................................

    public static void signup_employee() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Username: ");
            String user;
            // validating username for different conditions
            while (true) {
                user = sc.nextLine();
                if (user.isBlank()) {
                    System.out.println("Please Enter something...username cannot be null: ");
                } else if (user.length() > 20) {
                    System.out.println("user name cannot be greater than 20..try again:");
                } else {
                    break;
                }
            }
            System.out.println("Enter Password: ");
            String password;
            // validating passwords for different conditions
            while (true) {
                password = sc.nextLine();
                if (password.isEmpty()) {
                    System.out.println("Please Enter Some password...it cannot be null");
                } else if (password.length() < 10 || password.length() > 10) {
                    System.out.println("Please Enter password of length 10: ");
                } else {
                    break;
                }
            }
            user = user.trim();
            password = password.trim();
            System.out.println("Confirm Password: ");
            String ConPass;
            while (true) {
                ConPass = sc.nextLine();
                ConPass = ConPass.trim();
                if (!(password.equals(ConPass)))
                    System.out.println("Recheck");
                else
                    break;
            }
            String n = user + " " + password;
            // write username and password in designated file
            File inFile = new File("employee_logins.txt");
            if (!inFile.exists())
                inFile.createNewFile();
            Scanner in = new Scanner(inFile);
            int check = 0;
            while (in.hasNextLine()) {
                String info = in.nextLine();
                if (info.equals(n)) {
                    System.out.println("Already Registered!");
                    check = 1;
                    signup_employee(); // again call sign up method
                    break;
                }
            }
            in.close();
            // if username and password are unique then write it in file
            if (check == 0) {
                try {
                    FileWriter fw = new FileWriter("employee_logins.txt", true);
                    fw.write(user + " " + password + "\n");
                    fw.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("Successfully signed up");
            System.out.println(
                    "........................................Now Please login to continue further..................................");
            login_employee();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    } // method closed

      // ..........................................................login employee method.............................................................

    public static void login_employee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String uName;
        // empty input field validation
        while (true) {
            uName = sc.nextLine();
            if (uName.isBlank()) {
                System.out.println("Empty field is not allowed!..enter your username:");
            } else {
                break;
            }
        }
        System.out.println("Enter your Password: ");
        String pass = sc.nextLine();
        if (pass.isBlank()) {
            System.out.println("Empty field is not allowed!..enter your password:");
            pass = sc.nextLine();
        }
        uName = uName.trim();
        pass = pass.trim();
        String given = uName + " " + pass; // string containing user given inputs
        try {
            File inFile = new File("employee_logins.txt");
            if (!inFile.exists())
                inFile.createNewFile();
            Scanner in = new Scanner(inFile);
            boolean login_check = false;
            while (in.hasNextLine()) {
                String data = in.nextLine();
                if (data.equals(given)) {
                    System.out.println("Login Successful!!");
                    System.out.println("You can continue further...");
                    login_check = true;
                    break;
                }
            }
            in.close();
            if (!login_check) {
                System.out.println("Incorrect password..or incorrect username..login Failed..");
                login_employee();
            } // demand login from user again
        } catch (Exception e) {
            System.out.println(e);
        }
    } // method closed

    // ...................................................customer login interface.........................................................

    public static void login_customer_menu() {
        System.out.println("\t\t Login/Sign up Menu");
        System.out.println("1. sign up");
        System.out.println("2. log in");
        int o;
        while (true) {
            try {
                System.out.println("Enter your choice: ");
                o = input.nextInt();
                while (!(o == 1 || o == 2) || (String.valueOf(o).isBlank())) {
                    System.out.println("Invalid option.Choose option from menu: ");
                    o = input.nextInt();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Only integer option is allowed!!...");
                input.nextLine();
            }
        }
        switch (o) {
            case 1:
                signup_customer();
                break;
            case 2:
                login_customer();
                break;
        }
    } // method closed

    // .........................................................signup Customer method...................................................

    public static void signup_customer() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Username: ");
            String user;
            // validating username for different conditions
            while (true) {
                user = sc.nextLine();
                if (user.isBlank()) {
                    System.out.println("Please Enter something...username cannot be null: ");
                } else if (user.length() > 20) {
                    System.out.println("user name cannot be greater than 20..try again:");
                } else {
                    break;
                }
            }
            System.out.println("Enter Password: ");
            String password;
            // validating passwords for different conditions
            while (true) {
                password = sc.nextLine();
                if (password.isEmpty()) {
                    System.out.println("Please Enter Some password...it cannot tbe null");
                } else if (password.length() < 10 || password.length() > 10) {
                    System.out.println("Please Enter password of length 10: ");
                } else {
                    break;
                }
            }
            user = user.trim();
            password = password.trim();

            System.out.println("Confirm Password: ");
            String ConPass;
            while (true) {
                ConPass = sc.nextLine();
                ConPass = ConPass.trim();
                if (!(password.equals(ConPass)))
                    System.out.println("Recheck");
                else
                    break;
            }
            String n = user + " " + password;
            // write username and password in designated file
            File inFile = new File("customer_logins.txt");
            if (!inFile.exists())
                inFile.createNewFile();
            Scanner in = new Scanner(inFile);
            int check = 0;
            while (in.hasNextLine()) {
                String info = in.nextLine();
                if (info.equals(n)) {
                    System.out.println("Already Registered!");
                    check = 1;
                    signup_customer(); // again call sign up method
                    break;
                }
            }
            in.close();
            // if username and password are unique then write it in file
            if (check == 0) {
                try {
                    FileWriter fw = new FileWriter("customer_logins.txt", true);
                    fw.write(user + " " + password + "\n");
                    fw.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("Successfully signed up");
            System.out.println(
                    "........................................Now Please login to continue further..................................");
            login_customer();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    } // method closed
      // ..........................................................login customer method.............................................................

    public static void login_customer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String uName;
        // empty input field validation
        while (true) {
            uName = sc.nextLine();
            if (uName.isBlank()) {
                System.out.println("Null string is not allowed!..enter again:");
            } else {
                break;
            }
        }
        System.out.println("Enter your Password: ");
        String pass = sc.nextLine();
        if (pass.isBlank()) {
            System.out.println("Null string is not allowed!..enter again:");
            pass = sc.nextLine();
        }
        uName = uName.trim();
        pass = pass.trim();
        String given = uName + " " + pass; // string containing user given inputs
        try {
            File inFile = new File("customer_logins.txt");
            if (!inFile.exists())
                inFile.createNewFile();
            Scanner in = new Scanner(inFile);
            boolean login_check = false;
            while (in.hasNextLine()) {
                String data = in.nextLine();
                if (data.equals(given)) {
                    System.out.println("Login Successful!!");
                    System.out.println("You can continue further...");
                    login_check = true;
                    break;
                }
            }
            in.close();
            if (!login_check) {
                System.out.println("Incorrect password..or incorrect username..login Failed..");
                login_customer();
            } // demand login from user again
        } catch (Exception e) {
            System.out.println(e);
        }
    } // method closed
}
