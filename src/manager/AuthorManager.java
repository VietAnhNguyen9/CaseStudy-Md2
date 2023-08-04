package manager;

import model.Author;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorManager {
    private static AuthorManager instance;
    Scanner scanner = new Scanner(System.in);
    List<Author> listAuthor = new ArrayList<>();

    public static AuthorManager getInstance() {
        if (instance == null) {
            instance = new AuthorManager();
        }
        return instance;
    }

    private AuthorManager() {
        listAuthor = readAuthorFromFile();
    }

    public static void writeAuthorToFile(List<Author> listAuthor) {
        try {
            FileOutputStream fos = new FileOutputStream("listAuthor.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listAuthor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Author> readAuthorFromFile() {
        List<Author> author = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("listAuthor.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            author = (List<Author>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return author;
    }

    public Author addAuthor() {
        System.out.println("Enter the author's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter year of birth: ");
        String year = scanner.nextLine();
        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();
        Author author = new Author(name, year, gender);
        listAuthor.add(author);
        writeAuthorToFile(listAuthor);
        return author;
    }

    public void displayAuthor() {
        if (listAuthor.isEmpty()) {
            System.err.println("List author is empty !");
        } else {
            System.out.println("List of saved authors: ");
            for (Author author : listAuthor
            ) {
                System.out.println(author);
            }
        }

    }

    public Author checkNameAuthor() {
        System.out.println("Enter author's name: ");
        String nameAuthor = scanner.nextLine();
        Author author = null;
        for (int i = 0; i < listAuthor.size(); i++) {
            if (listAuthor.get(i).getName().equals(nameAuthor)) {
                author = listAuthor.get(i);
            }
        }
        return author;
    }

    public void deleteAuthor() {
        System.out.println("Enter the name of the author you want to delete: ");
        String name = scanner.nextLine();
        Author author = new Author();
        for (int i = 0; i < listAuthor.size(); i++) {
            if (listAuthor.get(i).getName().equals(name)) {
                author = listAuthor.get(i);
                listAuthor.remove(author);
                System.out.println("If the author is removed successfully, the books by this author will also be deleted !");
            }
        }
        writeAuthorToFile(listAuthor);
        BookManager.getInstance().deleteBookByAuthor(author);

    }
}
