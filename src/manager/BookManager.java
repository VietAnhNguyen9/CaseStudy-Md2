package manager;

import model.Author;
import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class BookManager {
    private static BookManager instance;

    Scanner scanner = new Scanner(System.in);
    AuthorManager authorManager = AuthorManager.getInstance();
    List<Book>listBook = new ArrayList<>();
    private BookManager() {
            listBook = readDataFromFile();
    }
    public static BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }
    public static void writeDataToFile(List<Book>listBook) {
        try {
            FileOutputStream fos = new FileOutputStream("listBook.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listBook);

        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    public static List<Book> readDataFromFile() {
        List<Book> book = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("listBook.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            book = (List<Book>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
        }return book;
    }
    Author author = null;
    public void addBook() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        authorManager.displayAuthor();
        System.out.println("1.The author is already on the list");
        System.out.println("2.The author is not on the list yet");
        do {
            System.out.println("Enter your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        author = authorManager.checkNameAuthor();
                        if (author == null) {
                            System.err.println("This author is not in the list ! ");
                        }
                        break;
                    case 2:
                        author = authorManager.addAuthor();
                        break;
                }
            }catch(NumberFormatException e) {
                System.err.println("Please be a smart user, re-enter according to the available menu !");
            }
        } while (author == null);
        System.out.println("Publishing Year: ");
        String publishingYear = scanner.nextLine();
        System.out.println("Enter category: ");
        String category = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        listBook.add(new Book(name, author, publishingYear, category, price, quantity));
        System.out.println("Book added !");
        writeDataToFile(listBook);
    }
    public void displayListBook() {
        if (listBook.isEmpty()){
            System.err.println("List is Empty !");
        }else {
            System.out.println("List of books of the store: ");
            for (Book a:listBook
            ) {
                System.out.println(a);
            }
        }
    }
    public void updateBook() {
        displayListBook();
        System.out.println("Enter the name of the book you want to update");
        String name = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getName().equals(name)) {
                System.out.println("Enter new price: ");
                double newPrice = Double.parseDouble(scanner.nextLine());
                listBook.get(i).setPrice(newPrice);
                System.out.println("Enter new quantity: ");
                int newQuantity = Integer.parseInt(scanner.nextLine());
                listBook.get(i).setQuantity(newQuantity);
                System.out.println("Successful update !");
                writeDataToFile(listBook);
                flag = true;
            }
        }
        if (!flag) {
            System.err.println("This book is not available in the store !");
        }
    }
    public void deleteBook() {
        displayListBook();
        System.out.println("Enter the name of the book you want to delete: ");
        String name = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getName().equals(name)) {
                listBook.remove(i);
                writeDataToFile(listBook);
                System.out.println("Successful delete ! ");
                flag = true;
            }
        }
        if (!flag) {
            System.err.println("This book is not available in the store !");
        }
    }
    public void searchByName() {
        boolean check = false;
        System.out.println("Enter name you want search: ");
        String search = scanner.nextLine();
        for (Book book:listBook
             ) {
            if (book.getName().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(book);
                check = true;
            }
        }
        if (!check) {
            System.err.println("This book is not available in the store !");
        }
    }
    public void searchByPriceUnder300k() {
        boolean flag = false;
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getPrice() < 300000) {
                System.out.println(listBook.get(i).getName());
                flag = true;
            }
        }
        if (!flag) {
            System.err.println("No book under 300000 !");
        }
    }
    public void searchByPriceOver300k() {
        boolean flag = false;
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getPrice() >= 300000) {
                System.out.println(listBook.get(i).getName());
                flag = true;
            }
        }
        if (!flag) {
            System.err.println("No book over 300000 !");
        }
    }
    public void searchByAuthor() {
        authorManager.displayAuthor();
        System.out.println("Enter author's name: ");
        String nameAuthor = scanner.nextLine();
        boolean flag = false;
        try {
            for (int j = 0; j < listBook.size(); j++) {
                if (listBook.get(j).getAuthor().getName().equals(nameAuthor)) {
                    System.out.println(listBook.get(j));
                    flag = true;
                }
            }
        }catch(Exception e) {
        }
        if (!flag) {
            System.err.println("No author in the list !");
        }
    }
    public void sortAscendingByPrice() {
        for (int i = 0; i < listBook.size()-1;i++) {
            for (int j = 0; j < listBook.size()-i-1;j++) {
                if (listBook.get(j).getPrice() > listBook.get(j+1).getPrice()) {
                    Book temp = listBook.get(j);
                    listBook.set(j, listBook.get(j+1));
                    listBook.set(j+1, temp);
                }
            }
        }
        System.out.println("Sorted list is: ");
        displayListBook();
    }
    public void sortDescendingByPrice() {
        for (int i = 0; i < listBook.size()-1;i++) {
            for (int j = 0; j < listBook.size()-i-1;j++) {
                if (listBook.get(j).getPrice() < listBook.get(j+1).getPrice()) {
                    Book temp = listBook.get(j);
                    listBook.set(j, listBook.get(j+1));
                    listBook.set(j+1, temp);
                }
            }
        }
        System.out.println("Sorted list is: ");
        displayListBook();
    }
    public void totalNumberOfBook() {
        int count = 0;
        for (int i = 0; i < listBook.size();i++) {
            count++;
        }
        System.out.println("-----------------------------");
        System.out.println("Total number of book: "+ count);
        System.out.println("-----------------------------");
    }
    public void totalCapital() {
        double total = 0;
        for (int i = 0; i < listBook.size();i++) {
            total += listBook.get(i).getPrice();
        }
        System.out.println("-----------------------------");
        System.out.println("Total capital: "+ total+" VND");
        System.out.println("-----------------------------");
    }
    public void  deleteBookByAuthor(Author author) {
        Iterator<Book> iterator = listBook.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getAuthor().equals(author)){
                iterator.remove();

            }
        }
        writeDataToFile(listBook);
    }

}
