package pstudio.j062;

public class Book {
    private String title;
    private String author;
    private String category;
    private double price;
    private int publicationYear;

    // 생성자 - 도서명만으로 생성
    public Book(String title) {
        this.title = title;
    }

    // 생성자 - 모든 도서정보로 생성
    public Book(String title, String author, String category, double price, int publicationYear) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.publicationYear = publicationYear;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // toString method
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
