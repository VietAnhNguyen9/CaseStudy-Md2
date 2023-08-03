import java.util.Scanner;

public class MenuCUD {
    BookManager bookManager = BookManager.getInstance();
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Add Book");
            System.out.println("2.Update Book");
            System.out.println("3.Delete Book");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
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
            }
        }while (choice != 0);
    }
}
