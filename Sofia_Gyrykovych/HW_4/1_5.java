class Main {

    public static void main(String[] args) {
        Book[] books = Book.createBooks();

        System.out.println("all books:");
        for (Book book : books) {
            System.out.println(book);
        }

        String author = "Bar";

        System.out.println();
        System.out.println("books where author = '" + author + "'");
        for (Book book : books) {
            if (book.getAuthor() != null && book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }

        String publisher = "Zzz";

        System.out.println();
        System.out.println("books where publisher = '" + publisher + "'");
        for (Book book : books) {
            if (book.getPublisher() != null && book.getPublisher().equals(publisher)) {
                System.out.println(book);
            }
        }

        int year = 2015;

        System.out.println();
        System.out.println("books where year > " + year);
        for (Book book : books) {
            if (book.getYear() > year) {
                System.out.println(book);
            }
        }
    }
}

class Book {

    private int id;
    private String name;
    private String author;
    private String publisher;
    private int year;
    private int pageCount;
    private double price;
    private String binding;

    public Book() {
    }

    public Book(
            int id,
            String name,
            String author,
            String publisher,
            int year,
            int pageCount,
            double price,
            String binding
    ) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pageCount = pageCount;
        this.price = price;
        this.binding = binding;
    }

    public static Book[] createBooks() {
        return new Book[] {
                new Book(4, "Book 1", "Baz", "Xxx", 2018, 207, 35.99, "stitched"),
                new Book(1, "Book 9", "Foo", "Zzz", 2017, 240, 34.99, "thermal"),
                new Book(2, "Book 8", "Foo", "Yyy", 2019, 150, 31.99, "stitched"),
                new Book(7, "Book 6", "Bar", "Zzz", 2016, 244, 38.99, "hardcover"),
                new Book(8, "Book 4", "Baz", "Xxx", 2013, 113, 39.99, "hardcover"),
                new Book(3, "Book 5", "Bar", "Yyy", 2011, 292, 37.99, "hardcover"),
                new Book(9, "Book 2", "Bar", "Yyy", 2012, 160, 32.99, "stitched"),
                new Book(6, "Book 3", "Foo", "Zzz", 2014, 228, 33.99, "thermal"),
                new Book(5, "Book 7", "Baz", "Xxx", 2015, 189, 36.99, "thermal")
        };
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", author='" + author + "'" +
                ", publisher='" + publisher + "'" +
                ", year=" + year +
                ", pageCount=" + pageCount +
                ", price=" + price +
                ", binding='" + binding + "'" +
                "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }
}