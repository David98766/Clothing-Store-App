/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxproject;
import DataAccess.DataAccess;
import DataAccess.JDBConnection;
import DataAccess.persistanceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.User;


/**
 * FXML Controller class
 *
 * @author adamm
 */
public class SignUpFXMLController implements Initializable {

    DataAccess dataAccess = new DataAccess();
    ManagerPortalFXMLController p = new ManagerPortalFXMLController();
    
      

    /**
     * Initializes the controller class.
     */

       
    @FXML
    public Button btnJoinForever22;
    
    @FXML 
    private ChoiceBox<String> cbCountry;
   
    @FXML 
    private CheckBox cbTermsAndConditions;
    
    @FXML 
    private TextField txtEmail;
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtFirstName;
    
     @FXML
    private TextField txtLastName;
     
     @FXML
    private TextField txtHouseNumber;
         
     @FXML
    private TextField txtStreetName;
     
     @FXML
    private TextField txtCity;
     
     @FXML
    private PasswordField pwfPassword1;
     
     @FXML
    private PasswordField pwfPassword2;
    
     @FXML
     private Button btnClear;
           
     @FXML 
     private Tooltip ttJoinForever22; 
     
     @FXML 
     private Tooltip ttTermsAndConditions;
     
     @FXML 
    private ChoiceBox<String> chxCardType;
     
     @FXML
    private TextField txtCardNumber;
     
     @FXML
     private DatePicker dpExpiryDate;
     
     @FXML
     private Label lblCardNumber;
     
     @FXML
     private Label lblUserName;
     
     @FXML 
    private ChoiceBox<String> chxShirtSize;
     
     @FXML
    private TextField txtShoeSize;
     
    @FXML
    private TextField txtWaistSize;
    
    @FXML
    private Tooltip ttCardNumber;
    
     @FXML
     private Label lblShoeSize;
       
       @FXML
     private Label lblWaistSize;
       
 //    @FXML 
 //    private Button btnContinue;
       //declaring public strings
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
  
    
               
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //disabling certain features
      //  persistanceUser.modifyColumnSize("TBLUSER", "STREETNAME", 35);
      //   btnContinue.setDisable(true);
        
        dpExpiryDate.setEditable(false);
        //populating choiceboxes
        cbCountry.getItems().add("Canada");
        cbCountry.getItems().add("European Union");
        cbCountry.getItems().add("United Kingdom");
        cbCountry.getItems().add("United States");
        
        chxCardType.getItems().add("Master Card");
        chxCardType.getItems().add("Visa Card");
        chxCardType.getItems().add("Debit Card");
        
        chxShirtSize.getItems().add("XS");
        chxShirtSize.getItems().add("S");
        chxShirtSize.getItems().add("M");
        chxShirtSize.getItems().add("L");
        chxShirtSize.getItems().add("XL");
        //declaring tooltips
        ttCardNumber.setText("This field only takes Numbers");
        txtCardNumber.setTooltip(ttCardNumber);
        ttCardNumber.setStyle("-fx-background-color: royalblue;");
        //setting certain labels invisible
        lblCardNumber.setVisible(false);
        lblUserName.setVisible(false);
        lblShoeSize.setVisible(false);
        lblWaistSize.setVisible(false);
        //Only allowing numbers to be input by users in necessary textfield
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
       
        
    }    
    

         @FXML
         private void handlebtnJoinForever22(ActionEvent event )throws IOException, SQLException{
                //setting values to strings
             
             strEmail = txtEmail.getText();
            strUsername = txtUserName.getText();
            String strPassword1 = pwfPassword1.getText();
             strPassword = pwfPassword2.getText();
             strFName = txtFirstName.getText();
            strLName = txtLastName.getText();
            strHouseNumber = txtHouseNumber.getText();
            strStreetName = txtStreetName.getText();
            strCity = txtCity.getText();
            strCountry = cbCountry.getValue();
            strPaymentType = chxCardType.getValue();
            strCCNumber = txtCardNumber.getText();
            strShirtSize = chxShirtSize.getValue();
            strShoeSize = txtShoeSize.getText();
            strWaistSize = txtWaistSize.getText();
            LocalDate selectedDate = dpExpiryDate.getValue();
          
            

          
            //Checking to see if usernames are unique. The user will not be able to sign up unless the username is unique. This allows us to use the username as a unique identifier (primary key)
            //This ensures that all information we pull up about our users are accurate to them specifically. This ensures our Input/Output is always correct.
            
  Connection conn = null;

    ResultSet rs = null;
conn = JDBConnection.getConnection();
PreparedStatement stmt = conn.prepareStatement("SELECT USERNAME FROM TBLUSER WHERE USERNAME=?");
stmt.setString(1, strUsername);
rs = stmt.executeQuery();
if (rs.next()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Username already exists");
    alert.setContentText("Please choose a different username.");
    alert.showAndWait();
}
                //error handling
           if (strEmail.length()== 0 || strUsername.length() == 0 || strPassword1.length()== 0 || strFName.length() == 0 || strLName.length()==0 || strHouseNumber.length()==0 
                    || strStreetName.length()==0 || strCity.length()==0 || cbTermsAndConditions.isSelected() == false || strCountry == null || strPaymentType == null || strShirtSize == null
                     || strShoeSize.length() == 0 || strCCNumber.length() == 0 || strWaistSize.length() == 0 || selectedDate == null ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Details Error");
            alert.setContentText("All Details not filled in");
            alert.showAndWait();
      
              
              
     
    }
            //ensures password and confirm password are exactly the same
         else  if (!strPassword1.equals(strPassword)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Password Error");
            alert.setContentText("Password and confirm Password dont match");
            alert.showAndWait();
               }
            //ensures Credit card number is 16 digits exactly
             else if (strCCNumber.length()!=16){
        
            lblCardNumber.setVisible(true);
            lblCardNumber.setText("Card Number must be 16 Digits");
               }
               else if (Integer.parseInt(strShoeSize) < 4 || Integer.parseInt(strShoeSize) > 14 ){
               lblShoeSize.setVisible(true);
               lblShoeSize.setText("No shoes of that size for Sale");
               }
               else if (Integer.parseInt(strWaistSize)< 22 || Integer.parseInt(strWaistSize) > 60){
               lblWaistSize.setVisible(true);
               lblWaistSize.setText("Waist size not availible sorry");
               }
      
               else {
                   
       
        
        //enabling and disabling relevant buttons to allow the user to continue
         btnJoinForever22.setDisable(true);
       // btnContinue.setDisable(false);
        btnClear.setDisable(true);
                
        //using the information to create a new user in our output.txt file
        User userToCreate = new User();
        userToCreate.setUserName(strUsername);
        userToCreate.setEmail(txtEmail.getText());
        userToCreate.setPassword(pwfPassword2.getText());
        userToCreate.setFirstName(txtFirstName.getText());
        userToCreate.setLastName(txtLastName.getText());
        userToCreate.setHouseNumber(txtHouseNumber.getText());
        userToCreate.setStreetName(txtStreetName.getText());
        userToCreate.setCity(txtCity.getText());
        userToCreate.setCountry(cbCountry.getValue());
        userToCreate.setCardType(chxCardType.getValue());
        userToCreate.setShirtSize(chxShirtSize.getValue());
        userToCreate.setShoeSize(txtShoeSize.getText());
        userToCreate.setCardNumber(txtCardNumber.getText());
        userToCreate.setWaistSize(txtWaistSize.getText());
        userToCreate.setExpiryDate(dpExpiryDate.getValue().toString());
        
        
        
        boolean isSuccess = persistanceUser.createUser(userToCreate);
        System.out.println(isSuccess);
        if (isSuccess == false)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Username Error");
            alert.setContentText("Username already taken");
            alert.showAndWait();
            
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succesful");
            alert.setHeaderText("Welcome User");
            alert.setContentText("Welcome to Forever 22");
            alert.showAndWait();
            
            Stage SignUpStage = (Stage) btnJoinForever22.getScene().getWindow();
                SignUpStage.hide();
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
       
       // read();
        
     
               }
         
         }
 
        @FXML
        public void handlebtnClear(ActionEvent event){
            //clearing all textboxes, choiceboxes etc.
            txtEmail.setText("");
            txtUserName.setText("");
            txtFirstName.setText("");
            txtLastName.setText("");
            txtHouseNumber.setText("");
            txtStreetName.setText("");
            txtCity.setText("");
            pwfPassword1.setText("");
            pwfPassword2.setText("");
            cbTermsAndConditions.setSelected(false);
            cbCountry.getSelectionModel().clearSelection();
            chxCardType.getSelectionModel().clearSelection();
            txtCardNumber.setText("");
            lblCardNumber.setText("");
            lblCardNumber.setVisible(false);
            lblUserName.setText("");
            lblUserName.setVisible(false);
            chxShirtSize.getSelectionModel().clearSelection();
            lblWaistSize.setVisible(false);
            lblWaistSize.setText("");
            txtWaistSize.setText("");
            
        }
        
   

}

