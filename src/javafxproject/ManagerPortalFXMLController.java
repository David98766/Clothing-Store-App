/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxproject;

import DataAccess.DataAccess;

import static DataAccess.DataAccess.intUserID;
import DataAccess.JDBConnection;
import DataAccess.persistanceUser;
import DateAndTime.dateandtime;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafxproject.FXMLClothingMainGUI.strOrders;
import logic.Complaints;
import logic.ClothingManager;
import logic.Order;
import logic.User;

/**
 * FXML Controller class
 *
 * @author adamm
 */
public class ManagerPortalFXMLController implements Initializable {
    
    DataAccess dataAccess = new DataAccess();
   // FXMLClothingMainGUI FXMLC = new FXMLClothingMainGUI();


    
     @FXML
    private Button btnUserAccounts;
     
     @FXML
    private Button btnProductOverview;
     
     @FXML
    private Button btnUserComplaints;
     
     @FXML
     private AnchorPane anchUserWindow;
    
     @FXML
     private AnchorPane anchProductOverview;
     
      @FXML
     private AnchorPane anchUserComplaints;
      
      @FXML
     private AnchorPane anchDefaultScreen;
      
      @FXML
    private Button btnBack;
       
     @FXML
    public TextArea txtUsers;
     
    @FXML
    private TextField txtUsername;
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtPassword;
    
    @FXML
    private TextField txtFirstName;
    
    @FXML
    private TextField txtLastName;
    
    @FXML
    private TextField txtHouseNumber;
    
    @FXML
    private TextField txtCity;
    
    @FXML
    private TextField txtStreetName;
    
    @FXML
    private ChoiceBox<String> chxShirtSize;
    
    @FXML
    private TextField txtShoeSize;
    
    @FXML
    private TextField txtWaistSize;
    
    @FXML
    private TextField txtCardNumber;    
    
    @FXML
    private DatePicker dpExpiryDate;  
    
    @FXML
    private Button btnDelete;
    
    @FXML 
    private Button btnUpdate;
    
    @FXML
    private TextField txtUserSearch;
    
    @FXML
    private ChoiceBox<String> chxCardType; 
    
     @FXML
    private ChoiceBox<String> chxContinent;
     
     @FXML
   private Button btnSearch;
     
    @FXML
    private Button btnClearSearch;
    
    @FXML
    private Button btnClearEdit;
    
    @FXML
    private Label lblShoeSize;
    
    @FXML
    private Label lblWaistSize;
        
    @FXML
    private Label lblCardNumber;
    
    @FXML
    private Button btnLogOut;
    @FXML
    private TextArea txtComplaint;
    @FXML
    private TextArea txtProductOverview;
    @FXML
    private ComboBox<String> cbxProductName;
    @FXML
    private ComboBox<String> cbxMessageText;
    @FXML
    private TextField txtProductPrice;
    @FXML
    private Button btnUpdateProduct;
    @FXML
    private AnchorPane anchUserOrders;
    @FXML
    private Button btnSearchOrders;
    @FXML
    private Button btnClearOrderSearch;
    @FXML
    private TextField txtOrderSearch;
    @FXML
    private Button btnUserOrders;
    @FXML
    private TextArea txtOrderView;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblTime;
    @FXML
    private TextField txtOrderUsername;
            

    
                //Declaring all parts of the User as public strings so they can be accessed through multiple forms.
       public static String strUsername;
       public static String strPartToPrint;
       public static String strEmail;
       public static String strPassword;
       public static String strFName;
       public static String strLName;
       public static String strHouseNumber;
       public static String strStreetName;
       public static String strCity;
       public static String strCountry;
       public static String strCCNumber;
       public static String strPaymentType;
       public static String strCCDate;
       public static String strShirtSize;
       public static String strShoeSize;
       public static String strWaistSize;
       public static String strLine;
       public static String strProductName;
       public static String strMessageText;
       public static String strProductPrice;
       public static String strPartToPrintClothing;
       public static String strLineClothing;
       
       
       public static String strUsers;
       
        dateandtime dt= new dateandtime();
       //switches pages to see differnt manager views
             public void switchForm(ActionEvent event){
      
          if (event.getSource() == btnUserAccounts){
              anchUserWindow.setVisible(true);
              anchProductOverview.setVisible(false);
              anchUserComplaints.setVisible(false);
              anchDefaultScreen.setVisible(false);
              anchUserOrders.setVisible(false);
              
              refresh();
          } 
          else if (event.getSource() == btnProductOverview) {
              anchUserWindow.setVisible(false);
              anchProductOverview.setVisible(true);
              anchUserComplaints.setVisible(false);
              anchDefaultScreen.setVisible(false);
              anchUserOrders.setVisible(false);
              readProductOverview();
          }
          else if (event.getSource() == btnUserComplaints){
              anchUserWindow.setVisible(false);
              anchProductOverview.setVisible(false);
              anchUserComplaints.setVisible(true);
              anchDefaultScreen.setVisible(false);
              anchUserOrders.setVisible(false);
              readComplaint();
              
          }
          else if (event.getSource() == btnBack){
              anchUserWindow.setVisible(false);
              anchProductOverview.setVisible(false);
              anchUserComplaints.setVisible(false);
              anchDefaultScreen.setVisible(true);
              anchUserOrders.setVisible(false);
          }
          else if (event.getSource() == btnUserOrders){
              anchUserWindow.setVisible(false);
              anchProductOverview.setVisible(false);
              anchUserComplaints.setVisible(false);
              anchDefaultScreen.setVisible(false);
              anchUserOrders.setVisible(true);
              readOrders();
          }
          else if (event.getSource() == btnLogOut){
              //brings user back to the log in page
                Stage MangerPoratl = (Stage) btnLogOut.getScene().getWindow();
                MangerPoratl.hide();
                              try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                    Parent root2 = (Parent) fxmlLoader.load();
                    Stage LoginStage = new Stage();
                    LoginStage.initModality(Modality.APPLICATION_MODAL);
                    LoginStage.initStyle(StageStyle.DECORATED);
                    LoginStage.setTitle("Forever 22 Login Page");
                    LoginStage.setScene(new Scene(root2));  
               
              
                    LoginStage.show();

            }
                catch(Exception e) {
                    e.printStackTrace();
                }
          }
          
          
      }
             

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          // TODO

   //calling the Wristwatch method to work on labels lblTime and lblDate
    dt.Wristwatch(lblTime, lblDate);
   //Intializing the page setting all the objects 
// godsEye();
    System.out.println(strLine);
    System.out.println(strPartToPrint);
 
        cbxProductName.setValue("");
        cbxMessageText.setValue("");
        
        txtProductOverview.setEditable(false);
        txtComplaint.setEditable(false);
        txtUsers.setEditable(false);
        txtOrderView.setEditable(false);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(txtUsers);
        
        
        dpExpiryDate.setEditable(false);
        //populating choiceboxes
        chxContinent.getItems().add("Canada");
        chxContinent.getItems().add("European Union");
        chxContinent.getItems().add("United Kingdom");
        chxContinent.getItems().add("United States");
        
        chxCardType.getItems().add("Master Card");
        chxCardType.getItems().add("Visa Card");
        chxCardType.getItems().add("Debit Card");
        
        chxShirtSize.getItems().add("XS");
        chxShirtSize.getItems().add("S");
        chxShirtSize.getItems().add("M");
        chxShirtSize.getItems().add("L");
        chxShirtSize.getItems().add("XL");
        
         cbxProductName.getItems().addAll
        ("Plain T-Shirt", "Plain Shirt", "UCC Shirt", "Adidas T-Shirt","Long Sleeve", "Graphic Tee", "Nike Airforces", "Air Jordans", "Adidas Gazelle", 
                "Converse", "Doc Martin", "Vans", "Chinos", "Sweatpants", "Adidas Joggers", "Nike Joggers", "Jeans", "Carharrt");
             
          cbxMessageText.getItems().addAll
        ("Available", "Out Of Stock", "Limited time only", "Sale");
          
        anchUserWindow.setVisible(false);
        anchProductOverview.setVisible(false);
        anchUserComplaints.setVisible(false);
        anchDefaultScreen.setVisible(true);
        anchUserOrders.setVisible(false);
        
        lblCardNumber.setVisible(false);
       lblShoeSize.setVisible(false);
        lblWaistSize.setVisible(false);
        
        //setting text fields to only take numbers
      txtCardNumber.textProperty().addListener((observable, oldValue, newValue) -> {
    if (!newValue.matches("\\d*")) {
        txtCardNumber.setText(newValue.replaceAll("[^\\d]", ""));
    }
});
        
                txtShoeSize.textProperty().addListener((observable, oldValue, newValue) -> {
    if (!newValue.matches("\\d*")) {
        txtShoeSize.setText(newValue.replaceAll("[^\\d]", ""));
    }
});
                
                txtWaistSize.textProperty().addListener((observable, oldValue, newValue) -> {
    if (!newValue.matches("\\d*")) {
        txtWaistSize.setText(newValue.replaceAll("[^\\d]", ""));
    }
}); 
                txtProductPrice.setOnKeyTyped((KeyEvent event) ->{
                if(!isValidInput(event.getCharacter())){
                    event.consume();
                }
    });
              //allowing managers to delete users
            btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String userToDelete = (txtUserSearch.getText());
                
              persistanceUser.deleteUser(userToDelete);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Deleted");
          alert.setHeaderText("Delete Confirmed");
          alert.setContentText("User Successfully Deleted");
          alert.showAndWait();

              read();
                
            }
        });
                      //update button for user on the manager screen
            btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            //converting to string to make error handling easier
            String strEmail = txtEmail.getText();
            String strUserName = txtUsername.getText();
            String strPassword1 = txtPassword.getText();
            String strFirstName = txtFirstName.getText();
            String strLastName = txtLastName.getText();
            String strHouseNumber = txtHouseNumber.getText();
            String strStreetName = txtStreetName.getText();
            String strCity = txtCity.getText();
            String strCountry = chxContinent.getValue();
            String strCardType = chxCardType.getValue();
            String strCardNumber = txtCardNumber.getText();
            String strShirtSize = chxShirtSize.getValue();
            String strShoeSize = txtShoeSize.getText();
            String strWaistSize = txtWaistSize.getText();
            LocalDate selectedDate = dpExpiryDate.getValue();
            
      //conditional statements to error handle
                User userToUpdate = new User();
               if (strEmail.length() == 0 || strUserName.length() == 0 || strPassword1.length() == 0 || strFirstName.length() == 0 || strLastName.length() == 0 || strHouseNumber.length() == 0 
                || strStreetName.length()==0 || strCity.length() ==0 || strCountry == null || strCardType == null || strShirtSize == null
                || strShoeSize.length() == 0 || strCardNumber.length() == 0 || strWaistSize.length() == 0 || selectedDate == null){
        
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Error");
          alert.setHeaderText("Details Error");
          alert.setContentText("All details have to be filled in");
          alert.showAndWait();
     
               }
                       else if (strCardNumber.length()!=16){
        
            lblCardNumber.setVisible(true);
            lblCardNumber.setText("Card Number must be 16 Digits");
               }
               
               else if (Integer.parseInt(strShoeSize) < 4 || Integer.parseInt(strShoeSize) > 14 ){
               lblShoeSize.setVisible(true);
               lblShoeSize.setText("Shoe size between 4 and 14");
               }
               else if (Integer.parseInt(strWaistSize) < 22 || Integer.parseInt(strWaistSize) > 60){
               lblWaistSize.setVisible(true);
               lblWaistSize.setText("Waist size between 22 and 60");
               }
                  else {
       //saving the user data to a text file (updating)
             userToUpdate.setUserName(txtUsername.getText());
            userToUpdate.setEmail(txtEmail.getText());
            userToUpdate.setPassword(txtPassword.getText());
            userToUpdate.setFirstName(txtFirstName.getText());
            userToUpdate.setLastName(txtLastName.getText());
            userToUpdate.setHouseNumber(txtHouseNumber.getText());
            userToUpdate.setStreetName(txtStreetName.getText());
            userToUpdate.setCity(txtCity.getText());
            userToUpdate.setCountry(chxContinent.getValue());
            userToUpdate.setCardType(chxCardType.getValue());
            userToUpdate.setShirtSize(chxShirtSize.getValue());
            userToUpdate.setShoeSize(txtShoeSize.getText());
            userToUpdate.setCardNumber(txtCardNumber.getText());
            userToUpdate.setWaistSize(txtWaistSize.getText());
            userToUpdate.setExpiryDate(dpExpiryDate.getValue().toString());

            persistanceUser.updateUser(userToUpdate);
            refresh(); 

               }
                
            
            }
        });
            //lamda function for updating the product on the product overview page
                    btnUpdateProduct.setOnAction((ActionEvent event) -> {
                    String strProductName = cbxProductName.getValue();
                    String strMessageText = cbxMessageText.getValue();
                    String strProductPrice = txtProductPrice.getText();
                    
                    if (strProductName.length() == 0 || strMessageText.length() == 0 || strProductPrice.length() == 0){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Error");
                        alert.setHeaderText("Details Error");
                        alert.setContentText("All details have to be filled in");
                        alert.showAndWait();
                    }
                    
                    ClothingManager clothingUpdate = new ClothingManager();
                    clothingUpdate.setProdcutName(strProductName);
                    clothingUpdate.setMessageText(strMessageText);
                    clothingUpdate.setProductPrice(txtProductPrice.getText());
                    persistanceUser.updateProduct(clothingUpdate);
                    readProductOverview();
 });
                
      
            
         //clear buttons for the text fields in the manager pages
                  
            btnClearSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 txtUserSearch.setText("");
                 read();
            }
        });
            btnClearOrderSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtOrderSearch.setText("");
                 txtOrderView.setText("");
                 readOrders();
            }
        });
            
                   btnClearEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            txtEmail.setText("");
            txtUsername.setText("");
            txtFirstName.setText("");
            txtLastName.setText("");
            txtHouseNumber.setText("");
            txtStreetName.setText("");
            txtCity.setText("");
            chxContinent.getSelectionModel().clearSelection();
            chxCardType.getSelectionModel().clearSelection();
            txtCardNumber.setText("");
            chxShirtSize.getSelectionModel().clearSelection();
            txtWaistSize.setText("");
            dpExpiryDate.setValue(null);
            txtShoeSize.setText("");
            txtPassword.setText("");
            }
        });
            
            

              
    }                   
             public void refresh() {
                    if(anchUserWindow.isVisible()){
        read();
                    }
             }

        
    
             //functions to read the data from the database to the corresponding text areas on the manager pages
  
             public void read() {
    List<User> list = persistanceUser.getAllUsers();
    String contents = "";

    for (int i = 0; i < list.size(); i++) {
        contents += list.get(i).convertToCsv() + "\n";
    }

    txtUsers.setText(contents);

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        conn = JDBConnection.getConnection();
        stmt = conn.createStatement();
        String sql = "SELECT * FROM TBLUSER";
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            // Do something with the retrieved data
            txtUsers.setText(contents);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        
    } finally {
        JDBConnection.closeConnection(conn, stmt, rs);
    }
}

                public void readComplaint(){
                List<Complaints> list = persistanceUser.getAllComplaints();
                String contents1 = "";
                
                for(int i=0; i<list.size(); i++){
                    contents1 += list.get(i).convertToReadable() + "\n";
                }
                txtComplaint.setText(contents1);
    }
 
                
                public void readProductOverview(){
                List<ClothingManager> list = persistanceUser.getAllProducts();
                String contents4 = "";
                
                for(int i=0; i<list.size(); i++){
                    contents4 += list.get(i).convertToCsv() + "\n";
                }
                txtProductOverview.setText(contents4);
    }
                public void readOrders(){
                 List<Order> list = persistanceUser.getAllOrders();
                String contents3 = "";
                
                for(int i=0; i<list.size(); i++){
                    contents3 += list.get(i).convertToReadible() + "\n";
                }
                txtOrderView.setText(contents3);
    }
        
         public void identifyUser() {
        //This Method is how we are going to display all the logged in users information (all together no picking and choosing which info)
        ArrayList<User> list = dataAccess.retrieve();
        String contents = list.get(intUserID).convertToCsv() + "\n";
        /*txtTesting.setText(contents);*/
    }

 
      public String getMANAGERSEARCHUSERFromDatabase(String strUser) {
     strUsers = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT * FROM TBLUSER WHERE USERNAME = ?");
        stmt1.setString(1, strUser);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strUsers +=" Username: " +  rs1.getString("USERNAME") + " Name: " + rs1.getString("FNAME") + " " + rs1.getString("LNAME") + " Email: "+ rs1.getString("UEMAIL")+ " Password: " + rs1.getString("PASSWORD") +" Address: "+rs1.getString("COUNTRY")+ ", " + rs1.getString("CITY") + ", " + rs1.getString("STREETNAME")+ ", " + rs1.getString("HOUSENUMBER")+ " Card Details: " + rs1.getString("CARDTYPE")+ ", " + rs1.getString("CARDNUMBER")+ ", " + rs1.getString("EXPIRYDATE")+ " Shirt Size: " + rs1.getString("SHIRTSIZE")+ " Waist Size: " + rs1.getString("WAISTSIZE")+ " Shoe Size: " + rs1.getString("SHOESIZE")+"\n";
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strUsers;

}

      public String getMANAGERSEARCHORDERFromDatabase(String strOrderID) {
     strOrders = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT * FROM TBLORDERS WHERE ORDERID = ?");
        stmt1.setString(1, strOrderID);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            strOrders +=" ID: " +  rs1.getString("ORDERID") + " Username: " + rs1.getString("ORDERUSERNAME") + " No. of Items:  " + rs1.getString("ORDERQUANTITY") + " Total: €"+ rs1.getString("ORDERTOTAL")+ "0 Order Date: " + rs1.getString("ORDERDATE") +" Delivery Date: "+rs1.getString("ORDERDELIVERYDATE") +"\n";
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strOrders;

}
     @FXML
    private void handlebtnSearchOrders(ActionEvent event)
    {
       String strOrderID = txtOrderSearch.getText();
        txtOrderView.setText(getMANAGERSEARCHORDERFromDatabase(strOrderID));

     //  String strOrderID = txtOrderSearch.getText();
//        txtOrderView.setText(FXMLC.getCUSTOMERSEARCHORDERFromDatabase(strOrderID));
        
    }
        
    
    
    @FXML
    private void handlebtnSearch(ActionEvent event)
    {
         String strUser = txtUserSearch.getText();
        txtUsers.setText(getMANAGERSEARCHUSERFromDatabase(strUser));
        
    }
    //method to check if typed character is number or decmal point
    private boolean isValidInput(String Input){
        String regex = "[0-9]*\\.?[0-9]*";
        return Input.matches(regex);
    }
}

        
   
    

