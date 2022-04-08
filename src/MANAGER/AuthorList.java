package MANAGER;

import DAO.FileDAO;
import DTO.Author;
import java.util.ArrayList;

public class AuthorList {

    ArrayList<Author> authorList;

    public AuthorList() {
        String fileName = "authorList.txt";
        FileDAO importFile = new FileDAO();
        authorList = importFile.readFileAuthor(fileName);
    }

    public boolean searchAuthor(String authorID) {
        for (Author author : authorList) {
            if (authorID.equalsIgnoreCase(author.getAuthorID())) {
                return true;
            }
        }
        return false;
    }

    public String findAuthor(String authorID) {
        for (Author author : authorList) {
            if (author.getAuthorID().equalsIgnoreCase(authorID)) {
                return author.getAuthorName();
            }
        }
        return null;
    }

    public void printAuthor() {
        for (Author author : authorList) {
            System.out.println(author);
        }
    }
}
