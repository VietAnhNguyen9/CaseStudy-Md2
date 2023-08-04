package menu;

import manager.BookManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchMenu {
    Scanner scanner = new Scanner(System.in);
    int choice ;
    BookManager bookManager = BookManager.getInstance();
    public void searchByPriceMenu() {
        do {
            System.out.println("1.Price over 300.000 VND");
            System.out.println("2.Price under 300.000 VND");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        bookManager.searchByPriceOver300k();
                        break;
                    case 2:
                        bookManager.searchByPriceUnder300k();
                        break;
                }
            }catch(NumberFormatException e) {
                System.err.println("Please be a smart user, re-enter according to the available menu !");
            }
        }while (choice != 0);
    }
    public void searchMenu() {
        do {
            System.out.println("1.Search by name");
            System.out.println("2.Search by price");
            System.out.println("3.Search by author");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        bookManager.searchByName();
                        break;
                    case 2:
                        searchByPriceMenu();
                        break;
                    case 3:
                        bookManager.searchByAuthor();
                        break;

                }
            }catch (NumberFormatException | InputMismatchException e) {
                System.err.println("Please be a smart user, re-enter according to the available menu !");
            }
        }while (choice != 0);
    }
}
