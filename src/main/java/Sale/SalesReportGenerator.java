/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sale;

import BookShopClass.BookManagement;
import BookShopClass.Book;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Mustafa
 */
public class SalesReportGenerator {
    public static void generateSalesReport(BookManagement centerlizeData, String reportFileName) {
        ArrayList<Book> bookData = centerlizeData.getBookData();

        int totalBooksSold = 0;
        int totalMoneyEarned = 0;

        for (Book book : bookData) {
            int soldBooks = book.getSoldBooks();
            int price = book.getPrice();
            int earningsFromBook = soldBooks * price;

            totalBooksSold += soldBooks;
            totalMoneyEarned += earningsFromBook;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFileName))) {
            writer.write("Sales Report\n");
            writer.write("============\n");
            writer.write("Total Books Sold: " + totalBooksSold + "\n");
            writer.write("Total Money Earned: $" + formatMoney(totalMoneyEarned) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatMoney(int amount) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(amount);
    }
   public static void sellBook(int regNo, int copies, BookManagement centerlizeData) {
        Book book = findBookByRegNo(regNo, centerlizeData);
        if (book != null) {
            int remainingBooks = book.getReamingBooks() - copies;
            if (remainingBooks < 0) {
                System.out.println("Not enough copies available to sell.");
                return;
            }
            book.setReamingBooks(remainingBooks);
            book.setSoldBooks(book.getSoldBooks() + copies);

            centerlizeData.updateBook(Integer.parseInt(book.getId()), book.getBookName(), book.getAuthorName(),
                    book.getTotalStock(), book.getPrice(),book.getSoldBooks());
        }
    }

    private static Book findBookByRegNo(int regNo, BookManagement centerlizeData) {
        for (Book book : centerlizeData.getBookData()) {
            if (Integer.parseInt(book.getId()) == regNo) {
                return book;
            }
        }
        return null;
    }
}
