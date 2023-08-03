import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private Author author;
    private String publishingYear;
    private String category;
    private double price;
    private int quantity;

    public Book() {
    }

    public Book(String name, Author author, String publishingYear, String category, double price, int quantity) {
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book:" + "\n" +
                "name: " + name +  "\n" +
                  author + "\n" +
                " publishingYear:" + publishingYear + "\n" +
                " category:" + category + "\n" +
                " price:" + price + " VND"+"\n"+
                " quantity:" + quantity +"\n"+
                "-------------------------------------------";
    }
}
