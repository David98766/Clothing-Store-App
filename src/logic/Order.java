/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import DataAccess.JDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static javafxproject.FXMLClothingMainGUI.strOrders;
import static javafxproject.login.strFName;
import static javafxproject.login.strUsername;

/**
 *
 * @author David
 */
public class Order {
    //declaring strings
    private String orderID;
    private String orderUsername;
    private String arraybasket;
    private String orderPrice;
    private String OrderDate;
    private String OrderDeliveryDate;
 
    
    //declaring getters and setters
    public String getId(){
        return this.orderID;
         }
    public void setId(String orderID){
            this.orderID = orderID;
    }
    
          public String getOrderUsername(){
        return this.orderUsername;
    }
    public void setOrderUsername(String orderUsername){
        this.orderUsername = orderUsername;
    }
             public String getBasket(){
        return this.arraybasket;
    }
    public void setBasket(String arraybasket){
        this.arraybasket = arraybasket;
    }
              public String getOrderPrice(){
        return this.orderPrice;
    }
    public void setOrderPrice(String orderPrice){
        this.orderPrice = orderPrice;
    }
    public String getOrderDate(){
        return this.OrderDate;
    }
    public void setOrderDate(String OrderDate){
        this.OrderDate = OrderDate;
    }
    public String getOrderDeliveryDate(){
        return this.OrderDeliveryDate;
    }
    public void setOrderDeliveryDate(String OrderDeliveryDate){
        this.OrderDeliveryDate = OrderDeliveryDate;
    }

            //converting data to csv
            public String convertToCsv(){
        return this.getId()
                + "," + this.getOrderUsername()
                + "," + this.getBasket()
                + "," + this.getOrderPrice()
                + "," + this.getOrderDate()
                + "," + this.getOrderDeliveryDate();
                
               
             
    }
            
            //making the information in the array more easily read 
            public String convertToReadible(){
         return this.getId() + "  "
                + "Username:  " + this.getOrderUsername()
                + "  " + "Product Quantity: " + this.getBasket()
                + "  " + "Order Price: " + "€" + this.getOrderPrice()
                + "  " + "Order Date: " +  this.getOrderDate()
                + "  " + "Expected Delivery Date: " + this.getOrderDeliveryDate();
                
               
             
    }
          
}
