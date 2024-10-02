/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import logic.User;
import java.util.ArrayList;
import static jdk.nashorn.tools.ShellFunctions.input;
import logic.ClothingManager;
import logic.Complaints;
import logic.Order;
/**
 *
 * @author adamm
 */
public class DataAccess {
    //declaring integers that track which user is logged in and how long the array is
    public static int intUserID = 0;
    //this integer is not totally necessary but it is useful in the development of the system that we use to chcek which user is logged in 
    public static int intFileLength;
   
    //String variable Referencing the textfile for database
    Connection dataPersistenceLayer;

    ArrayList<User> storedUsers;
    ArrayList<Complaints> storedComplaints;
    ArrayList<ClothingManager> storedClothing;
    ArrayList<Order> storedOrders;

    //CONSTRUCTOR MEHTOD FOR DATAACCESS CLASS
    public DataAccess(){
        try{
            this.dataPersistenceLayer = DriverManager.getConnection("jdbc:derby://localhost:1527/Forever22;create=true;user=Manager;password=lemon");
        
        } catch (SQLException ex){
            System.out.println("Database Connection Error: " + ex.getMessage());
        }
       this.storedUsers = new ArrayList<User>();
      /* this.loadUsersFromFile();*/
        
    }


    //Create methods for all objects
    public void create(User input){
        
        this.storedUsers.add(input);
        //helper method to save changes from memory to file
        this.saveUsersToFile();

    }
    
       public void create(Complaints input){
        this.storedComplaints.add(input);
        //helper method to save changes from memory to file
        //this.saveUsersToFile(this.dataPersistenceLayer);

    }
             public void create(ClothingManager input){
        this.storedClothing.add(input);
        //helper method to save changes from memory to file
        //this.saveUsersToFile(this.dataPersistenceLayer);

    }
    public void create(Order input){
        this.storedOrders.add(input);
        //helper method to save changes from memory to file
        //this.saveUsersToFile(this.dataPersistenceLayer);

    }
    
    
    //retrieve methods for all objects
         public ArrayList<User> retrieve(){
        return this.storedUsers;
    }
         
        public ArrayList<Complaints> retrieveComplaints(){
        return this.storedComplaints;
    }
        public ArrayList<ClothingManager> retrieveClothing(){
        return this.storedClothing;
    }
        public ArrayList<Order> retrieveOrders(){
        return this.storedOrders;
    }
   
    //write methods for all projects
    public void write(){
        this.saveUsersToFile();
    }
    
     /*  public void writeComplaints(){
        this.saveComplainstToFile(this.dataPersistenceLayerComplaint);
    }
     public void writeClothing(){
         this.saveClothingToFile(this.dataPersistanceLayerClothingManager);
    }
         public void writeOrders(){
         this.saveOrdersToFile(this.dataPersistenceLayerOrder);
    }*/
         //delte methods for order and user
    /*public void OrderDelete(String orderUsername, String orderiD){
                        for (int i=0; i < this.storedOrders.size(); i++){
        if (this.storedOrders.get(i).getOrderUsername().equals(orderUsername)){
            this.storedOrders.remove(i);
        }
            }
             this.saveOrders2File(this.dataPersistenceLayerOrder);
        }*/
/*public boolean OrderDelete(String orderUsername, String orderiD) {
    boolean orderDelete;
    orderDelete = false;
    LocalDate today = LocalDate.now();
    for (int i = 0; i < this.storedOrders.size(); i++) {
        Order order = this.storedOrders.get(i);
        if (order.getOrderUsername().equals(orderUsername) && order.getId().equals(orderiD)) {
            LocalDate deliveryDate = LocalDate.parse(order.getOrderDeliveryDate());
            if (deliveryDate.isAfter(today)) {
                this.storedOrders.remove(i);
                orderDelete = true;
                
            }
            
            }
        
    }
  
        this.saveOrders2File("Output.txt");
    
    return orderDelete;
}*/
            
    //This is how we are deleting users from the file
         public void delete(String userName){
            for (int i=0; i < this.storedUsers.size(); i++){
        if (this.storedUsers.get(i).getUserName().equals(userName)){
            this.storedUsers.remove(i);
        }
            }
             this.saveUsersToFile();
        }/*
         
         //Update method for user and clothing manager
            */ public void update (User input) {
        for (int i=0; 1 < this.storedUsers.size(); i++){
            if (this.storedUsers.get(i).getUserName().equals(input.getUserName())){
                this.storedUsers.set(i, input);
                break;
            }
    }
        
        this.saveUsersToFile();
    }/*
                          public void update (ClothingManager input) {
        for (int i=0; 1 < this.storedUsers.size(); i++){
            if (this.storedClothing.get(i).getProductName().equals(input.getProductName())){
                this.storedClothing.set(i, input);
                break;
            }
    }
        
        this.saveClothing2File(this.dataPersistanceLayerClothingManager);
    }*/

    // Login User Method. Checks if password and username are correct
    public boolean dologin(User input) {
        /*this.loadUsersFromFile();*/
        boolean userP = false;
        for (int i = 0; i < this.storedUsers.size(); i++) {
            if (this.storedUsers.get(i).getUserName().equals(input.getUserName())) {
                System.out.println(i);
                if (this.storedUsers.get(i).getPassword().equals(input.getPassword())) {
                    userP = true;
                   System.out.println(i);
                   System.out.println(storedUsers.get(i));
                   
                   
                    intFileLength = storedUsers.size();
                    System.out.println(intFileLength);
                    
                    
                    
                    /*This could be the most useful piece of code we have. It counts how many rows of the array the dologin method has to filter through until it reaches the username and password that the
                    user has input in the login page. We then use this integer to track who is logged in and personalise their pages for them */
                   intUserID = i;
                    break;
                }
            }
        }
        return userP;
    }


    private void loadComplaintsFromFile(String filename) {

        //create system nuetral reference to the I/O file
        java.io.File inFile = new java.io.File(filename);
        //domain object from bus logic layer
        Complaints complaint= null;

        //try block to catch i/o exceptions
        try {
            //create new scanner
            java.util.Scanner input = new java.util.Scanner(inFile);

            while (input.hasNext()) {
                complaint= new Complaints();
                String[] lineOfCsv = input.nextLine().split(","); //split contents of line
                //first element/ column = ID
                complaint.setComplaintUserName(lineOfCsv[0]);
                complaint.setComplaintEmail(lineOfCsv[1]);
                complaint.setDateOfComplaint(lineOfCsv[2]);
                complaint.setComplaint(lineOfCsv[3]);
                this.create(complaint);
            }
            input.close();
            //basic handlign exception
        } catch (java.io.IOException ex){
            System.out.println("Error reading file " + ex.toString());
        }
    }
    
      private void loadClothingFromFile(String filename) {

        //create system nuetral reference to the I/O file
        java.io.File inFile = new java.io.File(filename);
        //domain object from bus logic layer
        ClothingManager Clothing= null;

        //try block to catch i/o exceptions
        try {
            //create new scanner
            java.util.Scanner input = new java.util.Scanner(inFile);

            while (input.hasNext()) {
                Clothing= new ClothingManager();
                String[] lineOfCsv = input.nextLine().split(","); //split contents of line
                //first element/ column = ID
                Clothing.setProdcutName(lineOfCsv[0]);
                Clothing.setMessageText(lineOfCsv[1]);
                Clothing.setProductPrice(lineOfCsv[2]);
            
                this.create(Clothing);
            }
            input.close();
            //basic handlign exception
        } catch (java.io.IOException ex){
            System.out.println("Error reading file " + ex.toString());
        }
    }
          private void loadOrdersFromFile(String filename) {

        //create system nuetral reference to the I/O file
        java.io.File inFile = new java.io.File(filename);
        //domain object from bus logic layer
        Order order= null;

        //try block to catch i/o exceptions
        try {
            //create new scanner
            java.util.Scanner input = new java.util.Scanner(inFile);

            while (input.hasNext()) {
                order= new Order();
                String[] lineOfCsv = input.nextLine().split(","); //split contents of line
                //first element/ column = ID
                order.setId(lineOfCsv[0]);
                order.setOrderUsername(lineOfCsv[1]);
                order.setBasket(lineOfCsv[2]);
                order.setOrderPrice(lineOfCsv[3]);
                order.setOrderDate(lineOfCsv[4]);
                order.setOrderDeliveryDate(lineOfCsv[5]);
               
                this.create(order);
            }
            input.close();
            //basic handlign exception
        } catch (java.io.IOException ex){
            System.out.println("Error reading file " + ex.toString());
        }
    }
    
    //System.out.println("Username:" +user.lineOfCsv[0]);
// save methods for all objects
   private void saveUsers2File(String filename){
        java.io.File out = new java.io.File(filename);

        try{
            //create file to output text to using Printwriter
            java.io.PrintWriter output = new java.io.PrintWriter(out);
            for (int i=0; i < this.storedUsers.size(); i++){
                output.println(this.storedUsers.get(i).convertToCsv());
            }
            output.close();
        } catch (java.io.IOException ex){
            System.out.println("error writing to the file " + ex.toString());
        }
    }
    private void saveOrders2File(String filename){
        java.io.File out = new java.io.File(filename);

        try{
            //create file to output text to using Printwriter
            java.io.PrintWriter orders = new java.io.PrintWriter(out);
            for (int i=0; i < this.storedOrders.size(); i++){
                orders.println(this.storedOrders.get(i).convertToCsv());
            }
            orders.close();
        } catch (java.io.IOException ex){
            System.out.println("error writing to the file " + ex.toString());
        }
    }

   
   private void saveClothing2File(String filename){
        java.io.File out = new java.io.File(filename);

        try{
            //create file to output text to using Printwriter
            java.io.PrintWriter output = new java.io.PrintWriter(out);
            for (int i=0; i < this.storedClothing.size(); i++){
                output.println(this.storedClothing.get(i).convertToCsv());
            }
            output.close();
        } catch (java.io.IOException ex){
            System.out.println("error writing to the file " + ex.toString());
        }
    }
 /*   private void saveUsersToFile(String filename){
    java.io.File out = new java.io.File(filename);

    try{
        //create file to output text to using Printwriter
        java.io.PrintWriter output = new java.io.PrintWriter(out);
        int lastIndex = this.storedUsers.size() - 1;
        output.println(this.storedUsers.get(lastIndex).convertToCsv());
        output.close();
    } catch (java.io.IOException ex){
        System.out.println("error writing to the file " + ex.toString());
    }
}*/
    private void saveUsersToFile(){
    
    try{
        //create file to output text to using FileWriter
      Statement sql = this.dataPersistenceLayer.createStatement();
      User userCurrent = new User();
      
      for (int i=0; i < this.storedUsers.size(); i++){
          userCurrent = this.storedUsers.get(i);
          
          if (userCurrent.getUserName().equals("")){
               PreparedStatement stmt = this.dataPersistenceLayer.prepareStatement("INSERT INTO TBLUSER (USERNAME, FNAME, LNAME, UEMAIL, PASSWORD, HOUSENUMBER, STREETNAME, CITY, COUNTRY, CARDTYPE, SHIRTSIZE, SHOESIZE, CARDNUMBER, WAISTSIZE, EXPIRYDATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, userCurrent.getUserName());
        stmt.setString(2, userCurrent.getFirstName());
        stmt.setString(3, userCurrent.getLastName());
        stmt.setString(4, userCurrent.getEmail());
        stmt.setString(5, userCurrent.getPassword());
        stmt.setString(6, userCurrent.getHouseNumber());
        stmt.setString(7, userCurrent.getStreetName());
        stmt.setString(8, userCurrent.getCity());
        stmt.setString(9, userCurrent.getCountry());
        stmt.setString(10, userCurrent.getCardType());
        stmt.setString(11, userCurrent.getShirtSize());
        stmt.setString(12, userCurrent.getShoeSize());
        stmt.setString(13, userCurrent.getCardNumber());
        stmt.setString(14, userCurrent.getWaistSize());
        stmt.setString(15, userCurrent.getExpiryDate());
        stmt.executeUpdate();
          }
        else {
             sql.executeUpdate("UPDATE TBLUSER SET FNAME='"
                      + userCurrent.getFirstName() + ", LNAME='"
                      + userCurrent.getLastName() + ", UEMAIL='"
                      + userCurrent.getEmail() + ", PASSWORD='"
                      + userCurrent.getPassword() + ", HOUSENUMBER='"
                      + userCurrent.getHouseNumber() + ", STREETNAME='"
                      + userCurrent.getCity() + ", COUNTRY='"
                      + userCurrent.getCountry() + ", CARDTYPE='"
                      + userCurrent.getCardType() + ", SHIRTSIZE='"
                      + userCurrent.getShirtSize() + ", SHOESIZE='"
                      + userCurrent.getShoeSize() + ", CARDNUMBER='"
                      + userCurrent.getCardNumber() + ", WAISTSIZE='"
                      + userCurrent.getWaistSize() + ", EXPIRYDATE='"
                      + userCurrent.getExpiryDate()
                      + "' WHERE USERNAME=" + userCurrent.getUserName()) ;
                }
          }
      
    
    } catch (SQLException ex){
        System.out.println("error saving to database " + ex.toString());
    }
}
        private void saveComplainstToFile(String filename){
    java.io.File out = new java.io.File(filename);

    try{
        //create file to output text to using FileWriter
        java.io.FileWriter complaint = new java.io.FileWriter(out, true);
        int lastIndex = this.storedComplaints.size() - 1;
        complaint.write(this.storedComplaints.get(lastIndex).convertToCsv() + "\n");
        complaint.close();
    } catch (java.io.IOException ex){
        System.out.println("error writing to the file " + ex.toString());
    }
}
        
        private void saveClothingToFile(String filename){
    java.io.File out = new java.io.File(filename);

    try{
        //create file to output text to using FileWriter
        java.io.FileWriter clothing = new java.io.FileWriter(out, true);
        int lastIndex = this.storedClothing.size() - 1;
        clothing.write(this.storedClothing.get(lastIndex).convertToCsv() + "\n");
        clothing.close();
    } catch (java.io.IOException ex){
        System.out.println("error writing to the file " + ex.toString());
    }
}
        
                private void saveOrdersToFile(String filename){
    java.io.File out = new java.io.File(filename);

    try{
        //create file to output text to using FileWriter
        java.io.FileWriter order = new java.io.FileWriter(out, true);
        int lastIndex = this.storedOrders.size() - 1;
        order.write(this.storedOrders.get(lastIndex).convertToCsv() + "\n");
        order.close();
    } catch (java.io.IOException ex){
        System.out.println("error writing to the file " + ex.toString());
    }
}
 
            
}