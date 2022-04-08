package DAO;

import DTO.Author;
import DTO.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileDAO implements I_FileDAO {

    @Override
    public int writeFile(ArrayList<Book> list, String fileName) {
        File f = new File(fileName);
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            for (Book book : list) {
                pw.println(book.getISBN() + ", " + book.getTitle() + ", " + book.getAuthor().getAuthorID() + ", " + book.getAuthor().getAuthorName() + ", " + book.getPrice());
                pw.flush();
            }
            return 1;
        } catch (Exception e) {
            return -1;
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                System.out.println("Close file error!");
            }
        }
    }

    @Override
    public ArrayList<Author> readFileAuthor(String fileName) {
        ArrayList<Author> authorList = new ArrayList<>();
        FileReader f = null;
        BufferedReader r = null;
        try {
            f = new FileReader(fileName);
            r = new BufferedReader(f);
            while (r.ready()) {
                String s = r.readLine();
                if (s != null && !s.isEmpty()) {
                    String[] arr = s.split(",");
                    Author tmp = new Author(arr[0], arr[1]);
                    authorList.add(tmp);
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong!");
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (r != null) {
                    r.close();
                }
            } catch (Exception e) {
                System.out.println("Close file error");
            }
        }
        return authorList;
    }

    @Override
    public ArrayList<Book> readFile(String fileName) {
        //tạo mảng để chứa kq
        ArrayList<Book> tmpList = new ArrayList<>();
        FileReader f = null;
        BufferedReader r = null;
        try {
            f = new FileReader(fileName);
            r = new BufferedReader(f);
            while (r.ready()) {
                String s = r.readLine();
                if (s != null && !s.isEmpty()) { // cắt 1 dòng thành từng chuỗi nhỏ 
                    String[] arr = s.split(",");
                    Author tmpAuthor = new Author(arr[2], arr[3]);
                    Book x = new Book(arr[0], arr[1], tmpAuthor, Double.parseDouble(arr[4]));
                    tmpList.add(x);
                }

            }
        } catch (IOException e) {
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (r != null) {
                    r.close();
                }
            } catch (Exception e) {
                System.out.println("Something wrong");
            }
        }
        return tmpList;
    }
}
