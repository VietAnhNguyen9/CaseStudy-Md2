package menu;

import manager.BookManager;

import java.util.Scanner;

public class SortMenu {
    Scanner scanner = new Scanner(System.in);
    int choice ;
    BookManager bookManager = BookManager.getInstance();
    public void Arrange() {
        do {
            System.out.println("1.Sort ascending by price");
            System.out.println("2.Sort descending by price");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        bookManager.sortAscendingByPrice();
                        break;
                    case 2:
                        bookManager.sortDescendingByPrice();
                        break;
                }
            }catch (NumberFormatException e) {
                System.err.println("Please be a smart user, re-enter according to the available menu !");
            }
        }while(choice != 0);
    }
}
