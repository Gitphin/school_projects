public class Book implements Comparable<Book> {

    private String title;
    private String author;
    private String genre;
    private int numPages;


    public Book(String title, String author, String genre, int numPages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numPages = numPages;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumPages() {
        return numPages;
    }

    public boolean equals(Book other) {
        boolean authorMatches = author.equals(other.getAuthor());
        boolean titleMatches = title.equals(other.getTitle());
        return authorMatches && titleMatches;
    }

    // Implement this
    public int compareTo(Book book) {
        int b = this.author.compareTo(book.author);
        if (b == 0) {
            int c = this.title.compareTo(book.title);
            return c;
        }
        return b;
    }

    public static void main(String[] args) {
        Book a = new Book("1984", "Orwell", "Fiction", 528);
        Book b = new Book("1984", "Arwell", "Fiction", 528);
        Book c = new Book("Alice's Adventures in Wonderland", "Carroll", "Fantasy", 272);
        System.out.println(a.compareTo(c));
        System.out.println(a.compareTo(b));
        System.out.println(c.compareTo(b));

    }
}