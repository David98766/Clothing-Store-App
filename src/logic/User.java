/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author adamm
 */
public class User {
   //declaring strings
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String houseNumber;
    private String streetName;
    private String city;
    private String country;
    private String shirtSize;
    private String waistSize;
    private String shoeSize;
    private String cardType;
    private String cardNumber;
    private String expiryDate;

    //declaring getters and setters
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getEmail(){
        return this.email;

    }
  
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword (String password){
        this.password = password;

    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getHouseNumber(){
        return this.houseNumber;
    }
    public void setHouseNumber(String houseNumber){
        this.houseNumber = houseNumber;
    }
    
        public String getStreetName(){
        return this.streetName;
    }
    public void setStreetName(String streetName){
        this.streetName = streetName;
    }
    
    public String getCity(){
        return this.city;
    }
    public void setCity(String city){
        this.city = city;
    }
     public String getCountry(){
        return this.country;
    }
     public void setCountry (String country){
        this.country = country;

    }
         public String getShirtSize(){
        return this.shirtSize;
    }
     public void setShirtSize (String shirtSize){
        this.shirtSize = shirtSize;

    }
         public String getWaistSize(){
        return this.waistSize;
         }
    public void setWaistSize(String waistSize){
            this.waistSize = waistSize;
    }
             public String getShoeSize(){
        return this.shoeSize;
         }
    public void setShoeSize(String shoeSize){
            this.shoeSize = shoeSize;
    }
        public String getCardType(){
        return this.cardType;
    }
     public void setCardType (String cardType){
        this.cardType = cardType;

    }
        public String getCardNumber(){
        return this.cardNumber;
    }
     public void setCardNumber (String cardNumber){
        this.cardNumber = cardNumber;

    }
        public String getExpiryDate(){
        return this.expiryDate;
    }
     public void setExpiryDate (String expiryDate){
        this.expiryDate = expiryDate;

    }
    
    //instance method that returns CSV OF THE OBJECT
    public String convertToCsv(){
        return this.getUserName()
                + "," + this.getEmail()
                + "," + this.getPassword()
                + "," + this.getFirstName()
                + "," + this.getLastName()
                + "," + this.getHouseNumber()
                + "," + this.getStreetName()
                + "," + this.getCity()
                + "," + this.getCountry()
                + "," + this.getCardNumber()
                + "," + this.getCardType()
                + "," + this.getExpiryDate()
                + "," + this.getShirtSize()
                + "," + this.getShoeSize()
                + "," + this.getWaistSize();
    }

}