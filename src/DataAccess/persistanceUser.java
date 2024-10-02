/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import logic.ClothingManager;
import logic.Complaints;
import logic.Order;
import logic.User;



/**
 *
 * @author David
 */

//this class contains methods for saving and getting information to/from the database
public class persistanceUser {
    public static boolean createUser(User input){
  try {

        Connection conn = JDBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Manager.tblUser (USERNAME, FNAME, LNAME, UEMAIL, PASSWORD, HOUSENUMBER, STREETNAME, CITY, COUNTRY, CARDTYPE, SHIRTSIZE, SHOESIZE, CARDNUMBER, WAISTSIZE, EXPIRYDATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, input.getUserName());
        stmt.setString(2, input.getFirstName());
        stmt.setString(3, input.getLastName());
        stmt.setString(4, input.getEmail());
        stmt.setString(5, input.getPassword());
        stmt.setString(6, input.getHouseNumber());
        stmt.setString(7, input.getStreetName());
        stmt.setString(8, input.getCity());
        stmt.setString(9, input.getCountry());
        stmt.setString(10, input.getCardType());
        stmt.setString(11, input.getShirtSize());
        stmt.setString(12, input.getShoeSize());
        stmt.setString(13, input.getCardNumber());
        stmt.setString(14, input.getWaistSize());
        stmt.setString(15, input.getExpiryDate());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
        return true;
    } catch (SQLException sqlExcept) {
        sqlExcept.printStackTrace();
        return false;
    }
}
    public static boolean createComplaint(Complaints input){
          try {
        Connection conn = JDBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Manager.TBCOMPLAINTS (COMPLAINTUSERNAME, COMPLAINTEMAIL, DATEOFCOMPLAINT, USERCOMPLAINT) VALUES (?, ?, ?, ?)");
        stmt.setString(1, input.getComplaintUserName());
        stmt.setString(2, input.getComplaintEmail());
        stmt.setString(3, input.getDateOfComplaint());
        stmt.setString(4, input.getcomplaint());
      
        stmt.executeUpdate();
        stmt.close();
        conn.close();
        return true;
    } catch (SQLException sqlExcept) {
        sqlExcept.printStackTrace();
        return false;
    }
    }
       public static boolean createOrder(Order input){
          try {
        Connection conn = JDBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Manager.TBLORDERS (ORDERID, ORDERUSERNAME, ORDERQUANTITY, ORDERTOTAL, ORDERDATE, ORDERDELIVERYDATE) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, input.getId());
        stmt.setString(2, input.getOrderUsername());
        stmt.setString(3, input.getBasket());
        stmt.setString(4, input.getOrderPrice());
        stmt.setString(5, input.getOrderDate());
        stmt.setString(6, input.getOrderDeliveryDate());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
        return true;
    } catch (SQLException sqlExcept) {
        sqlExcept.printStackTrace();
        return false;
    }
    }
           public static boolean createProduct(ClothingManager input){
          try {
        Connection conn = JDBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Manager.TBLPRODUCTS (PRODUCTNAME, PRODUCTMESSAGE, PRODUCTPRICE) VALUES (?, ?, ?)");
        stmt.setString(1, input.getProductName());
        stmt.setString(2, input.getMessageText());
        stmt.setString(3, input.getProductPrice());

      
        stmt.executeUpdate();
        stmt.close();
        conn.close();
        return true;
    } catch (SQLException sqlExcept) {
        sqlExcept.printStackTrace();
        return false;
    }
    }
  
public static void updateUser(User input) {
    try {
        Connection conn = JDBConnection.getConnection();
        String sql = "UPDATE TBLUSER SET FNAME=?, LNAME=?, UEMAIL=?, PASSWORD=?, HOUSENUMBER=?, STREETNAME=?, COUNTRY=?, CARDTYPE=?, SHIRTSIZE=?, CITY=?, SHOESIZE=?, CARDNUMBER=?, WAISTSIZE=?, EXPIRYDATE=? WHERE USERNAME=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, input.getFirstName());
        statement.setString(2, input.getLastName());
        statement.setString(3, input.getEmail());
        statement.setString(4, input.getPassword());
        statement.setString(5, input.getHouseNumber());
        statement.setString(6, input.getStreetName());
        statement.setString(7, input.getCountry());
        statement.setString(8, input.getCardType());
        statement.setString(9, input.getShirtSize());
        statement.setString(10, input.getCity());
        statement.setString(11, input.getShoeSize());
        statement.setString(12, input.getCardNumber());
        statement.setString(13, input.getWaistSize());
        statement.setString(14, input.getExpiryDate());
        statement.setString(15, input.getUserName());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("User updated successfully.");
        }
        conn.close();
    } catch (SQLException ex) {
        System.out.println(ex.toString());
    }
}
public static void updateProduct(ClothingManager input) {
    try {
        Connection conn = JDBConnection.getConnection();
    
        String sql = "UPDATE TBLPRODUCTS SET PRODUCTMESSAGE=?, PRODUCTPRICE=? WHERE PRODUCTNAME=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, input.getMessageText());
        statement.setString(2, input.getProductPrice());
        statement.setString(3, input.getProductName());
        
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Product updated successfully.");
        }
        conn.close();
    } catch (SQLException ex) {
        System.out.println(ex.toString());
    }
}





    public static void deleteUser(String username){
        try{
        java.sql.Connection conn = JDBConnection.getConnection();
        
        String sql = "DELETE FROM TBLUSER WHERE USERNAME='" + username + "'";
        
        java.sql.Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
        
        conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

   public static List<User> getAllUsers() {
    List<User> users = new ArrayList<>();

    String sql = "SELECT USERNAME, FNAME, LNAME, UEMAIL, PASSWORD, HOUSENUMBER, " +
                 "STREETNAME, CITY, COUNTRY, CARDTYPE, SHIRTSIZE, SHOESIZE, CARDNUMBER, " +
                 "WAISTSIZE, EXPIRYDATE " +
                 "FROM Manager.TBLUSER";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        conn = JDBConnection.getConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            User user = new User();
            user.setUserName(rs.getString("USERNAME"));
            user.setFirstName(rs.getString("FNAME"));
            user.setLastName(rs.getString("LNAME"));
            user.setEmail(rs.getString("UEMAIL"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setHouseNumber(rs.getString("HOUSENUMBER"));
            user.setStreetName(rs.getString("STREETNAME"));
            user.setCity(rs.getString("CITY"));
            user.setCountry(rs.getString("COUNTRY"));
            user.setCardType(rs.getString("CARDTYPE"));
            user.setShirtSize(rs.getString("SHIRTSIZE"));
            user.setShoeSize(rs.getString("SHOESIZE"));
            user.setCardNumber(rs.getString("CARDNUMBER"));
            user.setWaistSize(rs.getString("WAISTSIZE"));
            user.setExpiryDate(rs.getString("EXPIRYDATE"));
            users.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception in a more meaningful way, such as displaying an error message to the user or logging the error.
    } finally {
        JDBConnection.closeConnection(conn, stmt, rs);
    }

    return users;
}


public static List<Complaints> getAllComplaints() {
    List<Complaints> complaints = new ArrayList<>();

    try (Connection conn = JDBConnection.getConnection();
         Statement stmt = conn.createStatement()) {

        String sql = "SELECT COMPLAINTUSERNAME, COMPLAINTEMAIL, DATEOFCOMPLAINT, USERCOMPLAINT " +
                     "FROM Manager.TBCOMPLAINTS";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Complaints complaint = new Complaints();
            complaint.setComplaintUserName(rs.getString("COMPLAINTUSERNAME"));
            complaint.setComplaintEmail(rs.getString("COMPLAINTEMAIL"));
            complaint.setDateOfComplaint(rs.getString("DATEOFCOMPLAINT"));
            complaint.setComplaint(rs.getString("USERCOMPLAINT"));
            complaints.add(complaint);
        }
    } catch (SQLException sqlExcept) {
        sqlExcept.printStackTrace();
    }

    return complaints;
}

              public static List<Order> getAllOrders(){
    List<Order> orders = new ArrayList<>();
    
    try
    {
        Connection conn = JDBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Manager.TBLORDERS FETCH FIRST 100 ROWS ONLY");
        
        while (rs.next()){
            Order Orders = new Order();
            Orders.setId(rs.getString("ORDERID"));
            Orders.setOrderUsername(rs.getString("ORDERUSERNAME"));
            Orders.setBasket(rs.getString("ORDERQUANTITY"));
            Orders.setOrderPrice(rs.getString("ORDERTOTAL"));
            Orders.setOrderDate(rs.getString("ORDERDATE"));
            Orders.setOrderDeliveryDate(rs.getString("ORDERDELIVERYDATE"));
         
            orders.add(Orders);
        }
        stmt.close();
    }
       catch (SQLException sqlExcept) {
        sqlExcept.printStackTrace();
        
    }
    
    return orders;
              }
                  public static List<ClothingManager> getAllProducts(){
    java.util.ArrayList<ClothingManager> list = new java.util.ArrayList<ClothingManager>();
    
    try
    {
        Connection conn = JDBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Manager.TBLPRODUCTS FETCH FIRST 100 ROWS ONLY");
        
        while (rs.next()){
            ClothingManager product = new ClothingManager();
            product.setProdcutName(rs.getString("PRODUCTNAME"));
            product.setMessageText(rs.getString("PRODUCTMESSAGE"));
            product.setProductPrice(rs.getString("PRODUCTPRICE"));
            
         
            list.add(product);
        }
        stmt.close();
    }
       catch (SQLException sqlExcept) {
        sqlExcept.printStackTrace();
        
    }
    
    return list;
            
}
    
    public static boolean DoLogin(String username, String password){
    try (Connection conn = JDBConnection.getConnection()) {
    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TBLUSER WHERE USERNAME = ? AND PASSWORD = ?");
    stmt.setString(1,username);
    stmt.setString(2, password);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
        return true;
    }
    else {
    return false;
    }
    }catch (SQLException e) {
           
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Database Error");
            alert.setHeaderText("Unable to connect to Database");
            alert.setContentText("Error Message: " + e.getMessage() );
            alert.showAndWait();
            return false;
    }
    }

    
    }
    





