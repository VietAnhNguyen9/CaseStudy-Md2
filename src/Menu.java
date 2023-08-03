import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = BookManager.getInstance();
        MenuCUD cud = new MenuCUD();
        SearchMenu sm = new SearchMenu();
        SortMenu sort = new SortMenu();
        int choice;
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1.AddBook, UpdateBook, DeleteBook");
            System.out.println("2.Display Book");
            System.out.println("3.Arrange");
            System.out.println("4.Search");
            System.out.println("5.Total number of books in the store");
            System.out.println("6.Total capital");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    cud.menu();
                    break;
                case 2:
                    bookManager.displayListBook();
                    break;
                case 3:
                    sort.Arrange();
                    break;
                case 4:
                    sm.searchMenu();
                    break;
                case 5:
                    bookManager.totalNumberOfBook();
                    break;
                case 6:
                    bookManager.totalCapital();
                    break;
                case 0:
                    System.exit(0);
            }
        }while (true);

        }
}
