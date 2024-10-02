/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author David
 */
public class ClothingManager {
    //declaring strings
    private String productName;
    private String messageText;
    private String flProductPrice;


        

            //declaring getters and setters
    public String getProductName(){
        return this.productName;
    }
    public void setProdcutName(String productName){
        this.productName = productName;
    }
    
    public String getMessageText(){
        return this.messageText;

    }
  
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
        public String getProductPrice(){
        return this.flProductPrice;

    }
  
    public void setProductPrice(String flProductPrice) {
        this.flProductPrice = flProductPrice;
    }
    
   
    
    //instance method that returns CSV OF THE OBJECT
    public String convertToCsv(){
        return this.getProductName()
                + "," + this.getMessageText()
                + "," + this.getProductPrice();
               
    }
    
}
