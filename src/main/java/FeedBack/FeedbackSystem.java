package FeedBack;

import FeedBack.FeedBack;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FeedbackSystem {
    private static final String feedbackFileName = "feedback.txt";
    private static ArrayList<FeedBack> feedbackList = new ArrayList<>();
    private static FeedbackSystem instance;

    private FeedbackSystem() {
        loadFeedbackFromFile();
    }

    public static synchronized FeedbackSystem getInstance() {
        if (instance == null) {
            instance = new FeedbackSystem();
        }
        return instance;
    }

    public void addFeedback(String usName, String msg, String book) {
        feedbackList.add(new FeedBack(usName, msg, book));
        saveFeedbackToFile();
    }

    public void deleteFeedback(String name) {
        boolean found = false;
        Iterator<FeedBack> iterator = feedbackList.iterator();

        while (iterator.hasNext()) {
            FeedBack feed = iterator.next();
            if (feed.getUsername().equalsIgnoreCase(name)) {
                iterator.remove();
                saveFeedbackToFile();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not Found");
        }
    }

    public ArrayList<FeedBack> getFeedbackList() {
        return feedbackList;
    }

    private void loadFeedbackFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(feedbackFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String user = parts[0];
                    String message = parts[1];
                    String bookname = parts[2];
                    feedbackList.add(new FeedBack(user, message, bookname));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFeedbackToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(feedbackFileName))) {
            for (FeedBack feedback : feedbackList) {
                writer.write(feedback.getUsername() + ", " +
                        feedback.getMessage() + ", " +
                        feedback.getBookname());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
