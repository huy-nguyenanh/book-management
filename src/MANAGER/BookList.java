package MANAGER;

import DAO.FileDAO;
import DTO.Author;
import DTO.Book;
import java.util.ArrayList;

public class BookList implements I_BookList {

    ArrayList<Book> list = new ArrayList<>();

    @Override
    public boolean addBookToList(Book book) {
        return list.add(book);
    }

    @Override
    public Book findBook(String ISBN) {
        for (Book book : list) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public int searchBook(String ISBN) {
        int count = 0;
        for (Book book : list) {
            if (book.getISBN().startsWith(ISBN)) {
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            return -1; // k tim thay gia tri phu hop
        }
        return 1;
    }

    @Override
    public int updateBook(Book updateBook, String title, String authorID, String authorName, double price) {
        Author tmp = new Author(authorID, authorName);
        updateBook.setTitle(title);
        updateBook.setAuthorID(tmp);
        updateBook.setPrice(price);
        return 1; // update thanh cong

    }

    @Override
    public int deleteBook(String ISBN, String userConfirm) {
        Book findBook = findBook(ISBN);
        if (findBook != null) {
            if (userConfirm.equalsIgnoreCase("y") || userConfirm.equalsIgnoreCase("yes")) {
                list.remove(findBook);
                return 1; // xoa thanh cong
            } else if (userConfirm.equalsIgnoreCase("n") || userConfirm.equalsIgnoreCase("no")) {
                return -2; // quay lai menu
            } else {
                System.out.println("Choice Yes or No, please!\n");
                return -3; // lap lai
            }
        }
        return -1; // k tim thay
    }

    @Override
    public boolean checkEmpty() {
        int result = list.size();
        if (result == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int exportPhoneList(String fileName) {
        FileDAO exprotFile = new FileDAO();
        int resultExport = exprotFile.writeFile(list, fileName);
        return resultExport;
    }

    @Override
    public void importStudentList(String fileName) {
        FileDAO importFile = new FileDAO();
        list = importFile.readFile(fileName);
        if (list.isEmpty()) {
            System.out.println("File Book.txt is empty!");
        } else {
            for (Book book : list) {
                System.out.println(book);
            }
            System.out.println("Completed import!");
        }
    }
    
    public void printBook(){
        if(list.isEmpty())
            System.out.println("List book is empty!. Import form file or Add a new book!");
        for (Book book : list) {
            System.out.println(book);
        }
    }

}
