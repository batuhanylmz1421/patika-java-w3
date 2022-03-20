import java.util.TreeSet;

public class BookSorterMain {
    public static void main(String[] args) {
        // Initializations.
        Book book1 = new Book("A TIME TO KILL    ", 123, "JOHN GRISHAM", 1989);
        Book book2 = new Book("THE HOUSE OF MIRTH", 555, "EDITH WHARTON", 1905);
        Book book3 = new Book("EAST OF EDEN      ", 360, "JOHN STEINBECK", 1952);
        Book book4 = new Book("THE SUN ALSO RISES", 120, "ERNEST HEMINGWAY", 1926);
        Book book5 = new Book("VILE BODIES       ", 235, "EVELYN WAUGH", 1930 );

        // Creating TreeSet with default comparator (By book name).
        TreeSet<Book> BooksOrderByName = new TreeSet<>();

        // Adding books to the TreeSet.
        BooksOrderByName.add(book1);
        BooksOrderByName.add(book2);
        BooksOrderByName.add(book3);
        BooksOrderByName.add(book4);
        BooksOrderByName.add(book5);

        // Printing name TreeSet.
        System.out.println("-------------------------------------------------------");
        System.out.println("Ordered By Book Name: ");
        // Printing TreeSet.
        for (Book book : BooksOrderByName) {
            System.out.println("Book Name: " + book.getName() + "\t\t Book Page: " + book.getPageNumber());
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Ordered By Book Page Number: ");

        // Creating TreeSet with default comparator (By book name).
        TreeSet<Book> BooksOrderByPage = new TreeSet<>(new BookPageCompatator().reversed());

        // Adding books to the TreeSet.
        BooksOrderByPage.add(book1);
        BooksOrderByPage.add(book2);
        BooksOrderByPage.add(book3);
        BooksOrderByPage.add(book4);
        BooksOrderByPage.add(book5);

        // Printing TreeSet.
        for (Book book : BooksOrderByPage) {
            System.out.println("Book Name: " + book.getName() + "\t\t Book Page: " + book.getPageNumber());
        }
        System.out.println("-------------------------------------------------------");

    }

}
