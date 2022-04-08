package MANAGER;

import DTO.Author;
import DTO.Book;
import Validation.AcceptInput;

public class BookManager {

    BookList list = new BookList();
    AcceptInput tool = new AcceptInput();
    AuthorList authorList = new AuthorList();

    public BookManager() {
    }

    public int addBookToList() {
        String ISBN = "", title = "", authorID = "", authorName = "";
        double price = 0;
        boolean continute = false;
        do {
            ISBN = tool.acceptISBN("Input ISBN (ex: ISBN 13: 978-0-596-52068-7/ ISBN 10: 0-596-52068-9 )");
            if (ISBN == null) {
                System.out.println("Please input ISBN 10 or ISBN 13");
                continute = true;
            } else if (ISBN != null && list.findBook(ISBN) == null) {
                continute = false;
            } else if (ISBN != null && list.findBook(ISBN) != null) {
                System.out.println("This ISBN is already in HKT Store!");
                System.out.println("Please input another ISBN!");
                continute = true;
            }
        } while (continute);

        do {
            title = tool.acceptString("Input title: (Format: String)");
            if (title.isEmpty()) {
                System.out.println("Title not be empty!");
                continute = true;
            } else {
                continute = false;
            }
        } while (continute);

        do {

            authorID = tool.acceptString("Intput author ID: (Format: String)");
            if (authorID.isEmpty()) {
                System.out.println("Author ID not be empty!");
                continute = true;
            } else if (authorList.searchAuthor(authorID) == false) {
                System.out.println("This author does not exist in File author.txt");
                continute = true;
            } else {
                continute = false;
            }
        } while (continute);

        do {
            try {
                price = tool.acceptDouble("Input price: ( > 0 )");
                if (price < 0) {
                    System.out.println("Price > 0, please!");
                    continute = true;
                } else if (price > 0) {
                    continute = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Wrong input! Input Again!!");
                continute = true;
            }
        } while (continute);
        authorName = authorList.findAuthor(authorID);
        Author author = new Author(authorID, authorName);
        Book book = new Book(ISBN, title, author, price);
        if (list.addBookToList(book)) {
            return 1; // add thanh cong
        }
        return -1;// add that bai
    }

    public int updateBook() {
        String ISBN, title, authorID, authorName;
        double price = 0;
        boolean continute = false;
        if (list.checkEmpty()) {
            System.out.println("List is empty!");
            System.out.println("Return to menu!\n");
            return 0;
        }
        do {
            ISBN = tool.acceptISBN("Input ISBN want to update (ex: ISBN 13: 978-0-596-52068-7/ ISBN 10: 0-596-52068-9 )");
            if (ISBN == null) {
                System.out.println("Please input ISBN 10 or ISBN 13");
                continute = true;
            } else {
                continute = false;
            }
        } while (continute);
        Book updateBook = list.findBook(ISBN);

        if (updateBook != null) {

            do {
                title = tool.acceptString("Update title: (Formate: String)");
                if (title.isEmpty()) {
                    System.out.println("Title not be empty!");
                    continute = true;
                } else {
                    continute = false;
                }
            } while (continute);

            do {
                authorID = tool.acceptString("Update author ID: (Formate: String)");
                if (authorID.isEmpty()) {
                    System.out.println("Author ID not be empty!");
                    continute = true;
                } else {
                    continute = false;
                }
            } while (continute);

            do {
                try {
                    price = tool.acceptDouble("Update price: ( > 0 )");
                    if (price < 0) {
                        System.out.println("Price > 0, please!");
                        continute = true;
                    } else if (price > 0) {
                        continute = false;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input! Input Again!!");
                    continute = true;
                }
            } while (continute);
            authorName = authorList.findAuthor(authorID);
            int result = list.updateBook(updateBook, title, authorID, authorName, price);
            if (result == 1) {
                System.out.println("Updated!");
                System.out.println("Return to menu!\n");
                return 1;
            } else {
                System.out.println("Update fail");
                return -1;
            }
        } else {
            System.out.println("This ISBN does not exist!");
            return -2;
        }
    }

    public int deleteBook() {
        String ISBN, userConfirm;
        boolean continute = false;
        if (list.checkEmpty()) {
            System.out.println("List is empty !");
            System.out.println("Return to menu!\n");
            return 0;
        }
        do {
            ISBN = tool.acceptISBN("Input ISBN want to update (ex: ISBN 13: 978-0-596-52068-7/ ISBN 10: 10 0-596-52068-9 )");
            if (ISBN == null) {
                System.out.println("Please input ISBN 10 or ISBN 13");
                continute = true;
            } else {
                continute = false;
            }
        } while (continute);
        int result;
        do {
            userConfirm = tool.acceptString("Are you sure to delete this book! (Y/N)");
            result = list.deleteBook(ISBN, userConfirm);
            switch (result) {
                case 1:
                    System.out.println("Deleted!");
                    System.out.println("Return to menu!\n");
                    return 1;
                case -2:
                    System.out.println("This book is not existed!");
                    return -2;
                case -1:
                    System.out.println("This ISBN does not exist!");
                    return -1;
            }
        } while (result == -3);
        return -5;
    }

    public int seachBook() {
        String ISBN;
        boolean continute = false;
        if (list.checkEmpty()) {
            System.out.println("List is empty!");
            System.out.println("Return to menu!\n");
            return 0;
        }
        do {
            ISBN = tool.acceptString("Input ISBN want to search (ex: ISBN 13: 978-0-596-52068-7/ ISBN 10: 0-596-52068-9 )");
            if (ISBN.isEmpty()) {
                System.out.println("Please input ISBN 10 or ISBN 13");
                continute = true;
            } else {
                continute = false;
            }
        } while (continute);
        int result = list.searchBook(ISBN);
        if (result == 1) {
            System.out.println("Completed!");
            System.out.println("Return to menu!\n");
            return 1;
        } else {
            System.out.println("“No book is matched!");
            System.out.println("Return to menu!\n");
            return -1;
        }
    }

    public void exportBookToList() {
        boolean continute = false;
        if (list.checkEmpty()) {
            System.out.println("List is empty!");
            System.out.println("Return to menu!\n");

        } else {
            do {
                String confirm = tool.acceptString("You want to export to file Book.txt? (Y/N)");
                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                    int resultExport = list.exportPhoneList("Book.txt");
                    if (resultExport == 1) {
                        System.out.println("Exported!");
                        System.out.println("Return to menu!\n");
                        continute = false;
                    } else if (resultExport == -1) {
                        System.out.println("Export fail!");
                        System.out.println("Return to menu!\n");
                        continute = false;
                    }
                } else if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
                    System.out.println("Return to menu!\n");
                    continute = false;
                } else {
                    System.out.println("Choice Yes or No, please!\n");
                    continute = true;
                }
            } while (continute);
        }
    }

    public void importListBook() {
        boolean continute = false;
        do {
            String confirm = tool.acceptString("You want to import file Book.txt to this program? (Y/N)");
            if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                list.importStudentList("Book.txt");
                continute = false;
            } else if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")) {
                list.printBook();
                System.out.println("Return to menu!\n");
                continute = false;
            } else {
                System.out.println("Choice Yes or No, please!\n");
                continute = true;
            }
        } while (continute);
    }
}
