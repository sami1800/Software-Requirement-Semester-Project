package FeedBack;



import FeedBack.FeedBack;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FeedbackLoader {

    public static void loadFeedbackDataFromFile(String fileAddress, DefaultTableModel model) {
        ArrayList<FeedBack> feedbackData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileAddress))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String username = parts[0];
                    String message = parts[1];
                    String bookname = parts[2];
                    feedbackData.add(new FeedBack(username, message, bookname));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        updateFeedbackTable(model, feedbackData);
    }

    private static void updateFeedbackTable(DefaultTableModel model, ArrayList<FeedBack> feedbackData) {
        model.setRowCount(0); 

        for (FeedBack feedback : feedbackData) {
            Object[] row = {
                    feedback.getUsername(),
                    feedback.getMessage(),
                    feedback.getBookname()
            };
            model.addRow(row); 
        }
    }
    
    public static void updateFeedbackTable1(DefaultTableModel model, FeedBack feedback) {
        model.setRowCount(0);  

        Object[] row = {
                feedback.getUsername(),
                feedback.getMessage(),
                feedback.getBookname()
        };
        model.addRow(row); 
    }
}
