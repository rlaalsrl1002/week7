package pstudio.j062;
import java.util.ArrayList;
import java.util.Scanner;

public class BookCRUD {
    private ArrayList<Book> bookList;

    public BookCRUD() {
        bookList = new ArrayList<>();
    }

    // 도서 추가
    public void addBook(String title, String author, String category, double price, int publicationYear) {
        Book book = new Book(title, author, category, price, publicationYear);
        bookList.add(book);
        System.out.println("도서가 추가되었습니다.");
    }

    // 도서 정보 수정
    public void editBook(String title, String author, String category, double price, int publicationYear) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                book.setAuthor(author);
                book.setCategory(category);
                book.setPrice(price);
                book.setPublicationYear(publicationYear);
                System.out.println("도서 정보가 수정되었습니다.");
                return;
            }
        }
        System.out.println("해당하는 도서가 존재하지 않습니다.");
    }

    // 도서 목록 출력
    public void listBooks() {
        if (bookList.isEmpty()) {
            System.out.println("도서가 없습니다.");
        } else {
            System.out.println("도서 목록:");
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

    // 도서 삭제
    public void deleteBook(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                bookList.remove(book);
                System.out.println("도서가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당하는 도서가 존재하지 않습니다.");
    }

    public static void main(String[] args) {
        BookCRUD bookCRUD = new BookCRUD();
        Scanner scanner = new Scanner(System.in);
        int menu;

        while (true) {
            System.out.println("Menu> 1 Add 2 Edit 3 List 4 Delete 0 Exit");
            menu = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (menu) {
                case 1:
                    System.out.print("도서명 입력: ");
                    String title = scanner.nextLine();
                    System.out.print("저자 입력: ");
                    String author = scanner.nextLine();
                    System.out.print("카테고리 입력: ");
                    String category = scanner.nextLine();
                    System.out.print("가격 입력: ");
                    double price = scanner.nextDouble();
                    System.out.print("출간년도 입력: ");
                    int publicationYear = scanner.nextInt();
                    bookCRUD.addBook(title, author, category, price, publicationYear);
                    break;
                case 2:
                    System.out.print("수정할 도서명 입력: ");
                    String bookToEdit = scanner.nextLine();
                    System.out.print("새로운 저자 입력: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("새로운 카테고리 입력: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("새로운 가격 입력: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("새로운 출간년도 입력: ");
                    int newPublicationYear = scanner.nextInt();
                    bookCRUD.editBook(bookToEdit, newAuthor, newCategory, newPrice, newPublicationYear);
                    break;
                case 3:
                    bookCRUD.listBooks();
                    break;
                case 4:
                    System.out.print("삭제할 도서명 입력: ");
                    String bookToDelete = scanner.nextLine();
                    bookCRUD.deleteBook(bookToDelete);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
