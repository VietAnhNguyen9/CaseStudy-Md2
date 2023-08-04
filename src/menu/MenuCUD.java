package menu;

import manager.AuthorManager;
import manager.BookManager;

import java.util.Scanner;

public class MenuCUD {
    BookManager bookManager = BookManager.getInstance();
    AuthorManager authorManager = AuthorManager.getInstance();
    int choice;
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1.Add Book");
            System.out.println("2.Update Book");
            System.out.println("3.Delete Book");
            System.out.println("4.Delete Author");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        bookManager.addBook();
                        break;
                    case 2:
                        bookManager.updateBook();
                        break;
                    case 3:
                        bookManager.deleteBook();
                        break;
                    case 4:
                        authorManager.deleteAuthor();
                        break;
                }
            }catch (NumberFormatException e) {
                System.err.println("Please be a smart user, re-enter according to the available menu !");
            }
        }while (choice != 0);
    }
}
