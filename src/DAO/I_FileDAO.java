package DAO;

import DTO.Author;
import DTO.Book;
import java.util.ArrayList;

public interface I_FileDAO {

    public int writeFile(ArrayList<Book> list, String fileName);

    public ArrayList<Author> readFileAuthor(String fileName);

    public ArrayList<Book> readFile(String fileName);

}
