package GUI;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList {

    Scanner sc = new Scanner(System.in);

    public void addMenu() {
        this.add("Show the book list");
        this.add("Add new book");
        this.add("Update book");
        this.add("Delete book");
        this.add("Search book");
        this.add("Store data to file");
        this.add("Orthers - Quit");
    }

    public int getUserChoice() {
        int result = 0;
        boolean flag = false;
        do {
            try {
                System.out.print("Choice: ");
                result = Integer.parseInt(sc.nextLine());
                if (result >= 0 && result < 7) {
                    flag = true;
                } else if (result == 7) {
                    System.out.println("\nHave a good day!\n");
                    flag = true;
                } else if (result < 0 || result > 7) {
                    System.out.println("Choose 0 - 8, please!\n");
                    flag = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Please enter number!!\n");
            }
        } while (flag == false);
        return result;
    }

    public void printMenu() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "- " + this.get(i));
        }
    }

}
