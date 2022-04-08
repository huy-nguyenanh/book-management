package Validation;

import java.util.Scanner;

public class AcceptInput {

    Scanner sc = new Scanner(System.in);

    public String acceptISBN(String msg) {
        String ISBN;
        System.out.println(msg);
        ISBN = sc.nextLine();
        if (ISBN.matches("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")) {
            return ISBN;
        }
        return null;
    }

    public String acceptString(String msg) {
        String s;
        System.out.println(msg);
        s = sc.nextLine();
        return s;
    }

    public String accpetName(String msg) {
        String name;
        System.out.println(msg);
        name = sc.nextLine();
        if (name.matches("[0-9]+") == false) {
            return name;
        }
        return null;
    }

    public double acceptDouble(String msg) throws NumberFormatException {
        double number = 0;
        System.out.println(msg);
        number = Double.parseDouble(sc.nextLine());
        return number;
    }

    public String acceptFileName(String msg) {
        String fileName;
        System.out.println(msg);
        fileName = sc.nextLine();
        fileName = fileName + ".txt";
        return fileName;
    }

}
