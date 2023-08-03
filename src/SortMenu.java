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
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookManager.sortAscendingByPrice();
                    break;
                case 2:
                    bookManager.sortDescendingByPrice();
                    break;
            }
        }while(choice != 0);
    }
}
