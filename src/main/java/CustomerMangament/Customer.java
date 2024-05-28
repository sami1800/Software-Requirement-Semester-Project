/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerMangament;

/**
 *
 * @author Mustafa
 */
public class Customer {
    private String name;
    private  String cusID;
    public Customer(String cusID,String name){
        this.cusID=cusID;
        this.name=name;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", cusID=" + cusID + '}';
    }
    
}
