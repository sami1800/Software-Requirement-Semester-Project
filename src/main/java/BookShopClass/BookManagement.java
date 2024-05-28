package BookShopClass;

import BookShopClass.Book;
import java.io.*;
import java.util.ArrayList;

public class BookManagement {
    private static BookManagement instance;
    private ArrayList<Book> bookData;
    private final String fileName = "database.txt";

    private BookManagement() {
        bookData = new ArrayList<>();
        loadBooksFromFile();
    }

    public static BookManagement getInstance() {
        if (instance == null) {
            instance = new BookManagement();
        }
        return instance;
    }

    public void addBook(String bookName, String authorName, int totalStock, int price) {
        String id = generateBookId();
        Book newBook = new Book(id, bookName, authorName, 0, totalStock, totalStock, price);
        bookData.add(newBook);
        saveBooksToFile();
    }

    public void deleteBook(int regNo) {
        Book bookToRemove = null;
        for (Book book : bookData) {
            if (Integer.parseInt(book.getId()) == regNo) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            bookData.remove(bookToRemove);
            saveBooksToFile();
        }
    }

    public void updateBook(int regNo, String bookName, String authorName, int totalStock, int price) {
        for (Book book : bookData) {
            if (Integer.parseInt(book.getId()) == regNo) {
                book.setBookName(bookName);
                book.setAuthorName(authorName);
                book.setTotalStock(totalStock);
                book.setPrice(price);
                book.setReamingBooks(totalStock - book.getSoldBooks());
                saveBooksToFile();
                System.out.println("Book with ID " + regNo + " updated successfully.");
                return;
            }
        }
        System.out.println("Book with ID " + regNo + " not found.");
    }

    public void updateBook(int regNo, String bookName, String authorName, int totalStock, int price, int soldBooks) {
        for (Book book : bookData) {
            if (Integer.parseInt(book.getId()) == regNo) {
                book.setBookName(bookName);
                book.setAuthorName(authorName);
                book.setTotalStock(totalStock);
                book.setPrice(price);
                book.setSoldBooks(soldBooks);
                book.setReamingBooks(totalStock - soldBooks);
                saveBooksToFile();
                System.out.println("Book with ID " + regNo + " updated successfully.");
                return;
            }
        }
        System.out.println("Book with ID " + regNo + " not found.");
    }

    public ArrayList<Book> getBookData() {
        return bookData;
    }

    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 7) {
                    String id = parts[0];
                    String bookName = parts[1];
                    String authorName = parts[2];
                    int soldBooks = Integer.parseInt(parts[3]);
                    int remainingBooks = Integer.parseInt(parts[4]);
                    int totalStock = Integer.parseInt(parts[5]);
                    int price = Integer.parseInt(parts[6]);
                    bookData.add(new Book(id, bookName, authorName, soldBooks, remainingBooks, totalStock, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Book book : bookData) {
                writer.write(book.getId() + ", " +
                             book.getBookName() + ", " +
                             book.getAuthorName() + ", " +
                             book.getSoldBooks() + ", " +
                             book.getReamingBooks()+ ", " +
                             book.getTotalStock() + ", " +
                             book.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String generateBookId() {
        int maxId = 0;
        for (Book book : bookData) {
            int id = Integer.parseInt(book.getId());
            if (id > maxId) {
                maxId = id;
            }
        }
        return String.format("%06d", maxId + 1);
    }
        public Book  searchBookByName(String customerName) {
        for (Book book : bookData) {
            if (book.getBookName().equalsIgnoreCase(customerName)) {
                return book;
            }
        }
        return null; 
    }
}
