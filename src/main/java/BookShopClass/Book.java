package BookShopClass;

public class Book {
    private String id;
    private String bookName;
    private String authorName;
    private int soldBooks;
    private int reamingBooks;
    private int totalStock;
    private int price;

    public Book(String id, String bookName, String authorName, int soldBooks, int reamingBooks, int totalStock, int price) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.soldBooks = soldBooks;
        this.reamingBooks = totalStock;
        this.totalStock = totalStock;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getSoldBooks() {
        return soldBooks;
    }

    public int getReamingBooks() {
        return reamingBooks;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setSoldBooks(int soldBooks) {
        this.soldBooks = soldBooks;
    }

    public void setReamingBooks(int reamingBooks) {
        this.reamingBooks = reamingBooks;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + ", " + bookName + ", " + authorName + ", " + soldBooks + ", " + reamingBooks + ", " + totalStock + ", " + price;
    }
}
