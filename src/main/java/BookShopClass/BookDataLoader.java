package BookShopClass;

import BookShopClass.Book;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookDataLoader {

    public static void loadBookDataFromFile(String fileAddress, DefaultTableModel model) {
        ArrayList<Book> bookData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileAddress))) {
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

        updateBookTable(model, bookData);
    }

    private static void updateBookTable(DefaultTableModel model, ArrayList<Book> bookData) {
        model.setRowCount(0); 

        for (Book book : bookData) {
            Object[] row = {
                    book.getId(),
                    book.getBookName(),
                    book.getAuthorName(),
                    book.getSoldBooks(),
                    book.getReamingBooks(),
                    book.getTotalStock(),
                    book.getPrice()
            };
            model.addRow(row); 
        }
    }
        public static void updateBookTable1(DefaultTableModel model, Book book) {
        model.setRowCount(0);  

            Object[] row = {
                    book.getId(),
                    book.getBookName(),
                    book.getAuthorName(),
                    book.getSoldBooks(),
                    book.getReamingBooks(),
                    book.getTotalStock(),
                    book.getPrice()
            };
            model.addRow(row); 
}
}

