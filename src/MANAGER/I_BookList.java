package MANAGER;

import DTO.Book;

public interface I_BookList {

    public boolean addBookToList(Book book);

    public Book findBook(String ISBN);//tìm giá trị so sánh điều kiện

    public int searchBook(String ISBN);// tìm gần đúng

    public int updateBook(Book updateBook, String title, String authorID, String authorName, double price);

    public int deleteBook(String ISBN, String userConfirm);

    public int exportPhoneList(String fileName);

    public void importStudentList(String fileName);

    public boolean checkEmpty();
}
