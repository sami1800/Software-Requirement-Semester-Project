package CustomerMangament;


import CustomerMangament.Customer;
import java.io.*;
import java.util.ArrayList;

public class CustomerManagement {
    private static CustomerManagement instance;
    private ArrayList<Customer> CustomerData;
    private final String fileName = "customerd.txt";

    private CustomerManagement() {
        CustomerData = new ArrayList<>();
        loadcustomerFromFile();
    }

    public static CustomerManagement getInstance() {
        if (instance == null) {
            instance = new CustomerManagement();
        }
        return instance;
    }

 public void addCustomer(String bookName) {
    String id = generatecustomerId();
    Customer newBook = new Customer(id, bookName);
    CustomerData.add(newBook);
    savecustomerToFile();

}
public void deletecustomer(int regNo) {
    Customer bookToRemove = null;
    for (Customer customer : CustomerData) {
        if (Integer.parseInt(customer.getCusID()) == regNo) {
            bookToRemove = customer;
            break;
        }
    }

    if (bookToRemove != null) {
        CustomerData.remove(bookToRemove);
        savecustomerToFile();
    }
}

    public void updatecustomer(int regNo, String CusName) {
        boolean found = false;
        for (Customer customer : CustomerData) {
            if (Integer.parseInt(customer.getCusID()) == regNo) {
                customer.setName(CusName);
                savecustomerToFile();                
                System.out.println("Book with ID " + regNo + " updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Book with ID " + regNo + " not found.");
        }
    }
   
 public ArrayList<Customer> getcustomerData() {
        return CustomerData;
    }
    private void loadcustomerFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String id = parts[0];
                    String CusName = parts[1];
                    CustomerData.add(new Customer(id, CusName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savecustomerToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Customer customer : CustomerData) {
                writer.write(customer.getCusID() + ", " +
                             customer.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String generatecustomerId() {
        int maxId = 0;
        for (Customer customer : CustomerData) {
            int id = Integer.parseInt(customer.getCusID());
            if (id > maxId) {
                maxId = id;
            }
        }
        return String.format("%06d", maxId + 1);
    }
}
