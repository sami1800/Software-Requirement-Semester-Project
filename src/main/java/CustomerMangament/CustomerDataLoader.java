/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerMangament;
import CustomerMangament.Customer;
import BookShopClass.Book;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerDataLoader {

    public static void loadBookDataFromFile(String fileAddress, DefaultTableModel model) {
        ArrayList<Customer> CustomerData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileAddress))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String id = parts[0];
                    String customerName = parts[1];
                    CustomerData.add(new Customer(id, customerName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        updateBookTable(model, CustomerData);
    }

    private static void updateBookTable(DefaultTableModel model, ArrayList<Customer> CustomerData) {
        model.setRowCount(0); // Clear the table before updating

        for (Customer customer : CustomerData) {
            Object[] row = {
                    customer.getCusID(),
                    customer.getName(),
            };
            model.addRow(row); // Add each book data to the table model
        }
    }
}
