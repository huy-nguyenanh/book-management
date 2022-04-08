package GUI;

import MANAGER.BookManager;
import Validation.AcceptInput;

public class Main {

    public static void main(String[] args) {
        BookManager function = new BookManager();
        AcceptInput tool = new AcceptInput();
        Menu menu = new Menu();
        int choice = 0;
        menu.addMenu();

        do {
            menu.printMenu();
            boolean continute = false;
            choice = menu.getUserChoice();

            switch (choice) {

                case 1: //show the book list
                    function.importListBook();
                    break;

                case 2: //add book
                    do {
                        boolean check = false;
                        int result = function.addBookToList();
                        if (result == 1) {
                            System.out.println("Added!");
                            do {
                                String userConfirm = tool.acceptString("Continute to add or Stop? (Y/N)");
                                if (userConfirm.equalsIgnoreCase("y") || userConfirm.equalsIgnoreCase("yes")) {
                                    check = false;
                                    continute = true;
                                } else if (userConfirm.equalsIgnoreCase("n") || userConfirm.equalsIgnoreCase("no")) {
                                    System.out.println("Return to menu!\n");
                                    check = false;
                                    continute = false;
                                } else {
                                    System.out.println("Choose Yes or No, please!\n");
                                    check = true;
                                }
                            } while (check);
                        } else {
                            System.out.println("Added failed!");
                            do {
                                String userConfirm = tool.acceptString("Continute to add or Stop? (Y/N)");
                                if (userConfirm.equalsIgnoreCase("y") || userConfirm.equalsIgnoreCase("yes")) {
                                    check = false;
                                    continute = true;
                                } else if (userConfirm.equalsIgnoreCase("n") || userConfirm.equalsIgnoreCase("no")) {
                                    System.out.println("Return to menu!\n");
                                    check = false;
                                    continute = false;
                                } else {
                                    System.out.println("Choose Yes or No, please!\n");
                                    check = true;
                                }
                            } while (check);
                        }
                    } while (continute);
                    break;

                case 3: //update
                    do {
                        int result = function.updateBook();
                        if (result == 0) {
                            continute = false;
                        } else if (result == -2) {
                            continute = false;
                        } else if (result == -1) {
                            continute = true;
                        } else {
                            continute = false;
                        }
                    } while (continute);

                    break;

                case 4: //delete
                    do {
                        int result = function.deleteBook();
                        if (result == 0) {
                            continute = false;
                        } else if (result == -2) {
                            System.out.println("Return to menu!");
                            continute = false;
                        } else if (result == -1) {
                            System.out.println("Delete book again!");
                            continute = true;
                        }
                    } while (continute);
                    break;

                case 5: //search
                    do {
                        int result = function.seachBook();
                        if (result == 0) {
                            continute = false;
                        } else if (result == -1) {
                            continute = false;
                        } else if (result == 1) {
                            continute = false;
                        } else {
                            continute = true;
                        }
                    } while (continute);
                    break;

                case 6: //store data to file
                    function.exportBookToList();
                    break;
            }
        } while (choice >= 0 && choice < 7);
    }
}
