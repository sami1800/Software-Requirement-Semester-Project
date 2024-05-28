/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FeedBack;

/**
 *
 * @author Mustafa
 */
public class FeedBack {
    private String username;
    private String message;
    private String bookname;
    public FeedBack(String username,String message,String bookname){
        this.username=username;
        this.message=message;
        this.bookname=bookname;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    
}
