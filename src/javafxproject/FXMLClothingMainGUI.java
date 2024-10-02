
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxproject;

import Counter.CountingVariable;
import DataAccess.DataAccess;
import DataAccess.JDBConnection;
import DataAccess.clothingdata;
import static DataAccess.clothingdata.strAdidasGazelleMessage;
import static DataAccess.clothingdata.strAdidasGazellePrice;
import static DataAccess.clothingdata.strAdidasJoggersMessage;
import static DataAccess.clothingdata.strAdidasJoggersPrice;
import static DataAccess.clothingdata.strAdidasTShirtMessage;
import static DataAccess.clothingdata.strAdidasTShirtPrice;
import static DataAccess.clothingdata.strAirJordansMessage;
import static DataAccess.clothingdata.strAirJordansPrice;
import static DataAccess.clothingdata.strCarharrtMessage;
import static DataAccess.clothingdata.strCarharrtPrice;
import static DataAccess.clothingdata.strChinosMessage;
import static DataAccess.clothingdata.strChinosPrice;
import static DataAccess.clothingdata.strConverseMessage;
import static DataAccess.clothingdata.strConversePrice;
import static DataAccess.clothingdata.strDocMartinMessage;
import static DataAccess.clothingdata.strDocMartinPrice;
import static DataAccess.clothingdata.strGraphicTeeMessage;
import static DataAccess.clothingdata.strGraphicTeePrice;
import static DataAccess.clothingdata.strJeansMessage;
import static DataAccess.clothingdata.strJeansPrice;
import static DataAccess.clothingdata.strLongSleeveMessage;
import static DataAccess.clothingdata.strLongSleevePrice;
import static DataAccess.clothingdata.strNikeAirforcesMessage;
import static DataAccess.clothingdata.strNikeAirforcesPrice;
import static DataAccess.clothingdata.strNikeJoggersMessage;
import static DataAccess.clothingdata.strNikeJoggersPrice;
import static DataAccess.clothingdata.strPlainShirtMessage;
import static DataAccess.clothingdata.strPlainShirtPrice;
import static DataAccess.clothingdata.strPlainTShirtMessage;
import static DataAccess.clothingdata.strPlainTShirtPrice;
import static DataAccess.clothingdata.strSweatpantsMessage;
import static DataAccess.clothingdata.strSweatpantsPrice;
import static DataAccess.clothingdata.strUCCShirtMessage;
import static DataAccess.clothingdata.strUCCShirtPrice;
import static DataAccess.clothingdata.strVansMessage;
import static DataAccess.clothingdata.strVansPrice;
import DataAccess.persistanceUser;
import DateAndTime.dateandtime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static javafxproject.login.strCCDate;
import static javafxproject.login.strCCNumber;
import static javafxproject.login.strEmail;
import static javafxproject.login.strFName;
import static javafxproject.login.strLName;
import static javafxproject.login.strLine;
import static javafxproject.login.strPartToPrint;
import static javafxproject.login.strShoeSize;
import static javafxproject.login.strWaistSize;
import static javafxproject.login.strShirtSize;
import static javafxproject.login.strUsername;
import static javafxproject.login.strCountry;
import static javafxproject.login.strPaymentType;
import logic.Complaints;
import logic.Order;


/**
 * FXML Controller class
 *
 * @author David
 */
public class FXMLClothingMainGUI implements Initializable {
       
    DataAccess dataAccess = new DataAccess();
    ManagerPortalFXMLController p = new ManagerPortalFXMLController();
    dateandtime dt = new dateandtime();

    @FXML
    private Label lblUsername;
    @FXML
    private RadioButton rdbCarhartt;
    @FXML
    private RadioButton rdbJeans;
    @FXML
    private RadioButton rdbNikeJoggers;
    @FXML
    private RadioButton rdbAdidasJoggers;
    @FXML
    private RadioButton rdbSweatpants;
    @FXML
    private RadioButton rdbChinos;  
    @FXML
    private Label lblDisplayOrder;
    @FXML
    private RadioButton rdbAdidasTshirt;
    @FXML
    private RadioButton rdbGraphicTee;
    @FXML
    private RadioButton rdbLongSleeve;
    @FXML
    private RadioButton rdbUCCShirt;
    @FXML
    private RadioButton rdbShirtRed;
    @FXML
    private ToggleGroup ShirtColour;
    @FXML
    private ToggleGroup Shoes;
    @FXML
    private RadioButton rdbShirtBlue;
    @FXML
    private RadioButton rdbShirtBlack;
    @FXML
    private RadioButton rdbShirtWhite;
    @FXML
    private ComboBox<String> cmbSizeShirts;
    @FXML
    private Button btnAddShirts;
    @FXML
    private ToggleGroup Shirts;
    @FXML
    private ToggleGroup Pants;
    @FXML
    private RadioButton rdbPlainTShirt;
    @FXML
    private RadioButton rdbPlainShirt;
    @FXML
    private RadioButton rdbPantsRed;
    @FXML
    private RadioButton rdbPantsBlue;
    @FXML
    private RadioButton rdbPantsBlack;
    @FXML
    private RadioButton rdbPantsWhite;
    @FXML
    private Button btnAddPants;
    @FXML
    private RadioButton rdbConverse;
    @FXML
    private RadioButton rdbAdidasGazelle; 
    @FXML
    private RadioButton rdbAirJordan; 
    @FXML
    private RadioButton rdbDocMartin; 
    @FXML
    private RadioButton rdbNikeAirforce; 
    @FXML
    private RadioButton rdbVans; 
    @FXML
    private Button btnAddShoes;
    @FXML
    private Button btnStore;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnHelp;
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnBasket;
    @FXML
    private AnchorPane anchStore;
    @FXML
    private AnchorPane anchOrders;
    @FXML
    private AnchorPane anchHelp;
    @FXML
    private AnchorPane anchBasket;
 
    @FXML
    private TextField txtEmailComplaint;
    @FXML
    private TextArea txtComplaints;
    @FXML
    private Label lblWelcome;
    @FXML
    private TextField txtWaistSize;
    @FXML
    private ToggleGroup PantsColour;
    @FXML
    private TextField txtShoeSize;
    @FXML
     private Label lblResponse1;
    @FXML
     private Label lblResponse2;
     @FXML
     private Label lblMessageTShirt;
     @FXML
     private Label lblMessagePlainShirt;
     @FXML
     private Label lblMessageUCCShirt;
     @FXML
     private Label lblAdidasShirt;
     @FXML
     private Label lblGraphicTee;
     @FXML
     private Label lblMessageLongSleeve;
     @FXML
     private Label lblMessageCarhartt;
     @FXML
     private Label lblMessageAdidasJogger;
     @FXML
     private Label lblMessageChinos;
     @FXML
     private Label lblMessageJeans;
     @FXML
     private Label lblMessageSweatPants;
     @FXML
     private Label lblMessageNikeJoggers;
     @FXML
     private Label lblMessageConvers;
     @FXML
     private Label lblMessageNikeAirforce;
     @FXML
     private Label lblMessageDocMartin;
     @FXML
     private Label lblMessageAirJordan;
     @FXML
     private Label lblMessageVans;
     @FXML
     private Label lblMessageAdidasGazelle;
     @FXML
     private Label lblPlainTShirt;
     @FXML
     private Label lblPlainShirt;
     @FXML
     private Label lblUCCShirt;
     @FXML
     private Label lblAdidasTShirt;
     @FXML
     private Label lblGRaphicTee;
     @FXML
     private Label lblLongSleeve;
     @FXML
     private Label lblCarharrt;
     @FXML
     private Label lblAdidasJoggers;
     @FXML
     private Label lblChinos;
     @FXML
     private Label lblJeans;
     @FXML
     private Label lblSweatPants;
     @FXML
     private Label lblNikeJoggers;
     @FXML
     private Label lblConvers;
     @FXML
     private Label lblNikeAirForce;
     @FXML
     private Label lblDocMartins;
     @FXML
     private Label lblAirJordans;
     @FXML
     private Label lblVans;
     @FXML
     private Label lblAdidasGazelle;
     @FXML
     private Button btnCheckout;
     @FXML 
     private TextField txtCardHolderName;
     @FXML 
     private TextField txtCardNumber;
     @FXML 
     private TextField txtCVVNumber;
     @FXML 
     private DatePicker dpExpiryDatePayment;
    @FXML
    private AnchorPane anchPaymentDetails;
    @FXML
    private AnchorPane anchBasketView;
    @FXML
    public Label lblDate;
    @FXML
    public Label lblTime;   
    @FXML
    public TextArea txtBasket;
    @FXML
    public TextField txtTotal;
    @FXML
    private Button btnDeleteItem;
    @FXML
    private Button btnClearOrder;
    @FXML 
    private Label lblCardNo;
    @FXML 
    private Label lblCVV;
    @FXML 
    private Label lblConvertCurrency;
    @FXML 
    private Button btnConvertCurrency;
    @FXML
    private ComboBox<String> cbxPaymentCardType;
    @FXML
    public TextField txtCustomerOrderSearch;
    @FXML
    private TextArea txtOrderView;

    clothingdata cd = new clothingdata();
    CountingVariable counter = new CountingVariable();
    //These Strings, Doubles and integers are used to populate the basket page and to set values to the label when a user adds an item to their basket
         /* public static DynamicArray arrayBasket = new DynamicArray();*/
          public static String strColour;
          public static String strSize;
          public static String strItemName;
          public static String strNewText;
          public static String strExistingText;
          public static Double dblNewValue;
         // public static int intExistingValue;
          public static Double dblTotal = 0.00;
          public static String strTotal;
          public static int intBasketLine = 0;
          
          public static Double dblCurrencyMultiplier =0.00;
          public static Double dblConvertedTotal = 0.00;
          public static String strCurrencySymbol = "€‎";
          private static final DecimalFormat df = new DecimalFormat("0.00");
          
           public static String strOrders;
 
           //swithcing pages on the clothing page
             public void switchForm(ActionEvent event){
      
          if (event.getSource() == btnStore){
              anchStore.setVisible(true);
              anchOrders.setVisible(false);
              anchHelp.setVisible(false);
              anchBasket.setVisible(false);
              txtOrderView.setText("");
              
          } 
          else if (event.getSource() == btnOrders) {
              anchStore.setVisible(false);
              anchOrders.setVisible(true);
              anchHelp.setVisible(false);
              anchBasket.setVisible(false);
              
               txtOrderView.setText(getCUSTOMERORDERFromDatabase(username));
 
          }
          else if (event.getSource() == btnHelp){
              anchStore.setVisible(false);
              anchOrders.setVisible(false);
              anchHelp.setVisible(true);
              anchBasket.setVisible(false);
//              p.godsEye();
              txtEmailComplaint.setText(strEmail);
              txtOrderView.setText("");
          }
          else if (event.getSource() == btnBasket){
              anchStore.setVisible(false);
              anchOrders.setVisible(false);
              anchHelp.setVisible(false);
              anchBasket.setVisible(true);
              anchBasketView.setVisible(true);
              anchPaymentDetails.setVisible(false);
              txtOrderView.setText("");
          }
          //allows user to log out
          else if (event.getSource() == btnLogOut){
              //brings user to login page if they log out
                Stage MainClothingGUI = (Stage) btnLogOut.getScene().getWindow();
                MainClothingGUI.hide();
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
             
             public void setLabel(String text){
               lblUsername.setText(text);
             }
             
             
    @FXML
    private void hideOrderDisplay() {
    this.lblDisplayOrder.setText("");

}
         //send complaints function stores complaints in database
         @FXML
         private void handlebtnSendComplaint(ActionEvent event) throws IOException{
          
          String strComplaint = txtComplaints.getText();
          
          Date currentDate = new Date();
          SimpleDateFormat dateFormat = new SimpleDateFormat();
          String strDate = dateFormat.format(currentDate);
  
          
          
              if (strComplaint.length() == 0) {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Error");
          alert.setHeaderText("Details Error");
          alert.setContentText("Complaint not filled in");
          alert.showAndWait();
          }
         
          
             else {
                 

                 Complaints complaintToCreate = new Complaints();
                 complaintToCreate.setComplaintUserName(strUsername);
                 complaintToCreate.setComplaintEmail(txtEmailComplaint.getText());
                 complaintToCreate.setDateOfComplaint(strDate);
                 complaintToCreate.setComplaint(txtComplaints.getText());
                 boolean userC =  persistanceUser.createComplaint(complaintToCreate);
                 if (userC == true){
                     System.out.println("Hoorah");
                 }
                 
                 
                 txtComplaints.setText("");
                 //Complaint successfully stored alertbox
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Complaint");
          alert.setHeaderText("Complaint Sent");
          alert.setContentText("Thank you for taking the time to fill out the complaint");
          alert.showAndWait();
          
          lblResponse1.setVisible(true);
          lblResponse2.setVisible(true);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e ->{
                    lblResponse1.setText("");}));
                          timeline.play();
             
             }
         }
             @FXML
         private void handlebtnCheckout(ActionEvent event )throws IOException{
             anchPaymentDetails.setVisible(true);
             
             
         }
         //pulls credit card data from file and fills the text fields with it
               @FXML
         private void handlebtnUseDefaultMethod(ActionEvent event )throws IOException{
             LocalDate Date = LocalDate.parse(strCCDate);
             txtCardHolderName.setText(strFName + " " + strLName);
             txtCardNumber.setText(strCCNumber);
             dpExpiryDatePayment.setValue(Date);
             cbxPaymentCardType.setValue(strPaymentType);
             
         }
         //clear method for checkout
                    @FXML
         private void handlebtnClearPayment(ActionEvent event )throws IOException{
             txtCardHolderName.setText("");
             txtCardNumber.setText("");
             dpExpiryDatePayment.setValue(null);
             cbxPaymentCardType.setValue(null);
         }
   
          
            
 
    //button to add a shirt to the basket
        @FXML
         private void handlebtnAddShirts(ActionEvent event )throws IOException{
                
       
        String strShirtSize = cmbSizeShirts.getValue();
        //error handling
        if (strShirtSize == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Size Error");
            alert.setContentText("No size chosen");
            alert.showAndWait(); 
        }
        else  if (ShirtColour.getSelectedToggle() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Colour Error");
            alert.setContentText("No colour chosen");
            alert.showAndWait(); 
             }
        else if (Shirts.getSelectedToggle() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Shirt Error");
            alert.setContentText("No shirt chosen");
            alert.showAndWait(); 
        }
        else {
             //Declaring necessary variables and strings for adding items to basket
            strExistingText = txtBasket.getText();

                           strSize = strShirtSize;
                           
             if(rdbShirtRed.isSelected()){
            strColour = ("Red");
        }
        else if(rdbShirtBlue.isSelected()){
                strColour = ("Blue");
                }
        else if(rdbShirtBlack.isSelected()){
                strColour = ("Black");
                }
                else{
                strColour = ("White");
                }
              //setting txtBasket and txtTotal strings and double values depending on what is being added to the basket
        if(rdbPlainTShirt.isSelected()){
             strItemName = ("Plain T-Shirt");

                BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " +strItemName + " €" + strPlainTShirtPrice + "\n");
                txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strPlainTShirtPrice);
             CountingCoins();
            // arrayBasket.add(strItemName);
         }
        else if (rdbPlainShirt.isSelected()){
            strItemName = ("Plain Shirt");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName + " €" + strPlainShirtPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strPlainShirtPrice);
             CountingCoins();
            // arrayBasket.add(strItemName);
        }
        else if (rdbUCCShirt.isSelected()){
            strItemName = ("UCC Shirt");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName+ " €" + strUCCShirtPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strUCCShirtPrice);
             CountingCoins();
            // arrayBasket.add(strItemName);
        }
         else if (rdbAdidasTshirt.isSelected()){
            strItemName = ("Adidas T-Shirt");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName + " €" + strAdidasTShirtPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strAdidasTShirtPrice);
             CountingCoins();
           //  arrayBasket.add(strItemName);
        }
        else if (rdbLongSleeve.isSelected()){
            strItemName = ("Long Sleeve");

               BasketLineIncrease();
               
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName + " €" + strLongSleevePrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strLongSleevePrice);
             CountingCoins();
            // arrayBasket.add(strItemName);
        }
        else{
            strItemName = ("Graphic Tee");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName + " €" + strGraphicTeePrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strGraphicTeePrice);
             CountingCoins();
            // arrayBasket.add(strItemName);
        }
         
         String order = (strColour + " " + strItemName +" size: " + strSize + " added to your basket!");
         lblDisplayOrder.setText(order); 
         
        
          //reset all shirt radiobuttons
        rdbShirtRed.setSelected(false);
        rdbShirtBlue.setSelected(false);
        rdbShirtBlack.setSelected(false);
        rdbShirtWhite.setSelected(false);
        rdbPlainTShirt.setSelected(false);
        rdbPlainShirt.setSelected(false);
        rdbUCCShirt.setSelected(false);
        rdbAdidasTshirt.setSelected(false);
        rdbLongSleeve.setSelected(false);
        rdbGraphicTee.setSelected(false);
       // cmbSizeShirts.setValue(null);
        
        // Create a Timeline to hide the orderDisplay lbl after 3 seconds
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e ->{
                    this.lblDisplayOrder.setText("");}));
                          timeline.play();
                                              
                         
        }
    
         }
   //button to add shoes to the basket
  @FXML
         private void handlebtnAddShoes(ActionEvent event )throws IOException{
       
        String strShoeSize = txtShoeSize.getText();
        //errror handling
                   if (strShoeSize.length() == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Size Error");
            alert.setContentText("No shoe size chosen");
            alert.showAndWait(); 
        }
   else if (Integer.parseInt(strShoeSize) < 4 || Integer.parseInt(strShoeSize) > 14 ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Size Error");
            alert.setContentText("Shoe sizes from 4 to 14 only in stock");
            alert.showAndWait(); 
   }
   else if (Shoes.getSelectedToggle() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Shoes Error");
            alert.setContentText("No shoes chosen");
            alert.showAndWait(); 
        }
   else {
       strExistingText = txtBasket.getText();

                           strSize = txtShoeSize.getText();
                           
         if(rdbNikeAirforce.isSelected()){
             strItemName = ("Nike Airforces");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize + " " + strItemName + " €" + strNikeAirforcesPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strNikeAirforcesPrice);
             CountingCoins();
           //  arrayBasket.add(strItemName);
         }
        else if (rdbAirJordan.isSelected()){
            strItemName = ("Air Jordans");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize + " " + strItemName + " €" + strAirJordansPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strAirJordansPrice);
             CountingCoins();
           //  arrayBasket.add(strItemName);
        }
        else if (rdbAdidasGazelle.isSelected()){
            strItemName = ("Adidas Gazelle");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize + " " +strItemName + " €" + strAdidasGazellePrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strAdidasGazellePrice);
             CountingCoins();
            // arrayBasket.add(strItemName);
        }
         else if (rdbConverse.isSelected()){
            strItemName = ("Converse");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize + " " + strItemName + " €" + strConversePrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strConversePrice);
             CountingCoins();
           //  arrayBasket.add(strItemName);
        }
        else if (rdbDocMartin.isSelected()){
            strItemName = ("Doc Martins");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize + " " + strItemName + " €" + strDocMartinPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strDocMartinPrice);
             CountingCoins();
          //   arrayBasket.add(strItemName);
        }
        else{
            strItemName = ("Vans");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize + " " + strItemName + " €" + strVansPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strVansPrice);
             CountingCoins();
           //  arrayBasket.add(strItemName);
        }
         
         String order = (strItemName +" size: " + strSize + " added to your basket!");
         lblDisplayOrder.setText(order); 
         
         // Reset all shoe buttons after the order is added
        rdbVans.setSelected(false);
        rdbConverse.setSelected(false);
        rdbAirJordan.setSelected(false);
        rdbDocMartin.setSelected(false);
        rdbNikeAirforce.setSelected(false);
        rdbAdidasGazelle.setSelected(false);
       // txtShoeSize.setText("");
             // Create a Timeline to hide the orderDisplay lbl after 3 seconds
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e ->{
                    this.lblDisplayOrder.setText("");}));
                          timeline.play();
   }
    }
    
    //reset all pants buttons after the order is added
 
        @FXML
         private void handlebtnAddPants(ActionEvent event )throws IOException{
        
        String strWaistSize = txtWaistSize.getText(); 
        
       //error handling
               if (strWaistSize.length() == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Size Error");
            alert.setContentText("No Waist size chosen");
            alert.showAndWait(); 
        }
                 else if (Integer.parseInt(strWaistSize) < 22 || Integer.parseInt(strWaistSize) > 60 ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Size Error");
            alert.setContentText("sizes from 22 to 60 only in stock");
            alert.showAndWait(); 
                 }
   else if (Pants.getSelectedToggle() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("shirt Error");
            alert.setContentText("No Pants chosen");
            alert.showAndWait(); 
        }
        else  if (PantsColour.getSelectedToggle() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Color Error");
            alert.setContentText("No Colour chosen");
            alert.showAndWait(); 
             }

        else {
            //Declaring necessary variables and strings for adding items to basket
            strExistingText = txtBasket.getText();

                           strSize = txtWaistSize.getText();
           
             if(rdbPantsRed.isSelected()){
            strColour = ("Red");
        }
        else if(rdbPantsBlue.isSelected()){
                strColour = ("Blue");
                }
        else if(rdbPantsBlack.isSelected()){
                strColour = ("Black");
                }
                else{
                strColour = ("White");
                }
        if(rdbChinos.isSelected()){
             strItemName = ("Chinos");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName + " €" + strChinosPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strChinosPrice);
             CountingCoins();
           //  arrayBasket.add(strItemName);
    
         }
        else if (rdbSweatpants.isSelected()){
            strItemName = ("Sweatpants");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName + " €" + strSweatpantsPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strSweatpantsPrice);
             CountingCoins();
            // arrayBasket.add(strItemName);
             
        }
        else if (rdbAdidasJoggers.isSelected()){
            strItemName = ("Adidas Joggers");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName + " €" + strAdidasJoggersPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strAdidasJoggersPrice);
             CountingCoins();
            // arrayBasket.add(strItemName);
        }
         else if (rdbNikeJoggers.isSelected()){
            strItemName = ("Nike Joggers");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName + " €" + strNikeJoggersPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strNikeJoggersPrice);
             CountingCoins();
           //  arrayBasket.add(strItemName);
        }
        else if (rdbJeans.isSelected()){
            strItemName = ("Jeans");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName + " €" + strJeansPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strJeansPrice);
             CountingCoins();
           //  arrayBasket.add(strItemName);
        }
        else{
            strItemName = ("Carhartt");

               BasketLineIncrease();
               strNewText = (intBasketLine + ". size: " + strSize +" " +strColour + " " + strItemName + " €" + strCarharrtPrice + "\n");
             txtBasket.setText(strExistingText + strNewText);
             dblNewValue = Double.parseDouble(strCarharrtPrice);
             CountingCoins();
           //  arrayBasket.add(strItemName);
        }
         
         String order = (strColour + " " + strItemName +" size: " + strSize + " added to your basket!");
         lblDisplayOrder.setText(order); 
         //resetting buttons
             rdbPantsRed.setSelected(false);
             rdbPantsBlue.setSelected(false);
             rdbPantsBlack.setSelected(false);
             rdbPantsWhite.setSelected(false);
             rdbAdidasJoggers.setSelected(false);
             rdbNikeJoggers.setSelected(false);
             rdbJeans.setSelected(false);
             rdbCarhartt.setSelected(false);
             rdbSweatpants.setSelected(false);
             rdbChinos.setSelected(false);
           //  txtWaistSize.setText("");
                
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e ->{
                    this.lblDisplayOrder.setText("");}));
                          timeline.play();
                          
        
        }

                
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
        
        cbxPaymentCardType.getItems().addAll
        ("Master Card", "Visa Card", "Debit Card"); 
        //importing the godsEye method to allow us to personalise the page depending on which user is logged in
//        p.godsEye();
        lblCardNo.setVisible(false);
        lblCVV.setVisible(false);
        //importing the Wristwatch method so the date and time label will update itself to keep the time accurate.
         dt.Wristwatch(lblTime, lblDate);
         //setting buttons to disabled so that users cannot click them unless they should be able to
         btnDeleteItem.setDisable(true);
         btnClearOrder.setDisable(true);
         //This if statement keeps the application running smoothly as it does not allow users to checkout with 0 euro worth of products in their basket
         if(dblTotal==0){
             btnCheckout.setDisable(true);
             
         }
         else{
             btnCheckout.setDisable(false);
         }
         
         //Only allowing numbers to be input in applicable textboxes
         txtCardNumber.textProperty().addListener((observable, oldValue, newValue) -> {
    if (!newValue.matches("\\d*")) {
        txtCardNumber.setText(newValue.replaceAll("[^\\d]", ""));
    }
});
          txtCVVNumber.textProperty().addListener((observable, oldValue, newValue) -> {
    if (!newValue.matches("\\d*")) {
        txtCVVNumber.setText(newValue.replaceAll("[^\\d]", ""));
    }
});
          //allowing users to convert the total price to their home currency if they are from outside the EU
          if(strCountry.equals( "Canada")){
              lblConvertCurrency.setText("Convert total to Canadian Dollars?");
              lblConvertCurrency.setVisible(true);
              
              btnConvertCurrency.setVisible(true);
          }
         else if(strCountry.equals("United States")){
              lblConvertCurrency.setText("Convert total to American Dollars?");
              lblConvertCurrency.setVisible(true);
              
              btnConvertCurrency.setVisible(true);
          }
          else if(strCountry.equals("United Kingdom")){
              lblConvertCurrency.setText("Convert total to British Pounds?");
              lblConvertCurrency.setVisible(true);
              
              btnConvertCurrency.setVisible(true);
          }
          else{
              //So that EU users do not get confused, They will not be able to see the change currency label and button
          lblConvertCurrency.setVisible(false);
          btnConvertCurrency.setVisible(false);
          }
          
   
   
     //This section of code is devoted to making users see the prices and availibility status of clothes, which can be altered by managers
       cd.setClothing();
       
      lblPlainTShirt.setText("Plain T-Shirt "+ "€"+ strPlainTShirtPrice);
      lblMessageTShirt.setText(strPlainTShirtMessage);
      
      lblPlainShirt.setText("Plain Shirt "+ "€"+ strPlainShirtPrice);
      lblMessagePlainShirt.setText(strPlainShirtMessage);
      
      lblUCCShirt.setText("UCC Shirt  "+ "€"+ strUCCShirtPrice);
      lblMessageUCCShirt.setText(strUCCShirtMessage);
    
       lblAdidasShirt.setText(strAdidasTShirtMessage);
       lblAdidasTShirt.setText("Adidas Shirt "+ "€"+ strAdidasTShirtPrice);
       
       lblMessageLongSleeve.setText(strLongSleeveMessage);
       lblLongSleeve.setText("Long Sleeve " + "€"+ strLongSleevePrice);
       
       lblGraphicTee.setText(strGraphicTeeMessage);
       lblGRaphicTee.setText("Graphic Tee "+"€"+ strGraphicTeePrice);
   
       lblMessageNikeAirforce.setText(strNikeAirforcesMessage);
       lblNikeAirForce.setText("Nike Airforces "+ "€"+ strNikeAirforcesPrice);
       
       lblMessageAirJordan.setText(strAirJordansMessage);
       lblAirJordans.setText("AirJordans "+"€"+ strAirJordansPrice);
       
       lblMessageAdidasGazelle.setText(strAdidasGazelleMessage);
       lblAdidasGazelle.setText("Adidas Gazelles " + "€" + strAdidasGazellePrice);
       
       lblMessageConvers.setText(strConverseMessage);
       lblConvers.setText("Converse "+"€"+ strConversePrice);
       
       lblMessageDocMartin.setText(strDocMartinMessage);
       lblDocMartins.setText("Doc Martins "+"€"+ strDocMartinPrice);
       
       lblMessageVans.setText(strVansMessage);
       lblVans.setText("Vans "+"€"+ strVansPrice);
       
       lblMessageChinos.setText(strChinosMessage);
       lblChinos.setText("Chinos "+"€"+ strChinosPrice);
       
       lblMessageSweatPants.setText(strSweatpantsMessage);
       lblSweatPants.setText("Sweatpants "+"€"+ strSweatpantsPrice);
       
       lblMessageAdidasJogger.setText(strAdidasJoggersMessage);
       lblAdidasJoggers.setText("Adidas Joggers " + " €" +strAdidasJoggersPrice);
       
       lblMessageNikeJoggers.setText(strNikeJoggersMessage);
       lblNikeJoggers.setText("Nike Joggers " + " €" + strNikeJoggersPrice);
       
       lblMessageJeans.setText(strJeansMessage);
       lblJeans.setText("Jeans " + " €" + strJeansPrice);
       
        lblMessageCarhartt.setText(strCarharrtMessage);
       lblCarharrt.setText("Carharrt "+ " €" + strCarharrtPrice);
    
               
       //This code sets different colours for different availablity labels
       if(lblMessageTShirt.getText().contains("Available")){
          lblMessageTShirt.setStyle("-fx-text-fill: green;");
       
       }
       else if(lblMessageTShirt.getText().contains("Sale")){
              lblMessageTShirt.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageTShirt.getText().contains("Limited time only")){
              lblMessageTShirt.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageTShirt.getText().contains("Out Of Stock")){
                lblMessageTShirt.setStyle("-fx-text-fill: red;");
                rdbPlainTShirt.setDisable(true);
                rdbPlainTShirt.setStyle("-fx-background-color: grey;");
                rdbPlainTShirt.setOpacity(0.3);
       }
       else {
            lblMessageTShirt.setStyle("-fx-text-fill: black;");
       }
       if (lblMessagePlainShirt.getText().contains("Available")){
           lblMessagePlainShirt.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessagePlainShirt.getText().contains("Sale")){
              lblMessagePlainShirt.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessagePlainShirt.getText().contains("Limited time only")){
              lblMessagePlainShirt.setStyle("-fx-text-fill: mediumorchid;");
       }
       //If the item is set as out of stock, users cannot click on the item and it is greyed out to let them know they cant click it
       else if (lblMessagePlainShirt.getText().contains("Out Of Stock")){
           lblMessagePlainShirt.setStyle("-fx-text-fill: red;");
           rdbPlainShirt.setDisable(true);
           rdbPlainShirt.setStyle("-fx-background-color: grey;");
           rdbPlainShirt.setOpacity(0.3);
       }
       else {
           lblMessagePlainShirt.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageUCCShirt.getText().contains("Available")){
           lblMessageUCCShirt.setStyle("-fx-text-fill: green;");
       }
       
       else if(lblMessageUCCShirt.getText().contains("Sale")){
              lblMessageUCCShirt.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageUCCShirt.getText().contains("Limited time only")){
              lblMessageUCCShirt.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageUCCShirt.getText().contains("Out Of Stock")){
           lblMessageUCCShirt.setStyle("-fx-text-fill: red;");
           rdbUCCShirt.setDisable(true);
           rdbUCCShirt.setStyle("-fx-background-color: grey;");
           rdbUCCShirt.setOpacity(0.3);
       }
       else {
           lblMessageUCCShirt.setStyle("-fx-text-fill: black;");
       }
       if (lblAdidasShirt.getText().contains("Available")){
           lblAdidasShirt.setStyle("-fx-text-fill: green;");
       }
       else if(lblAdidasShirt.getText().contains("Sale")){
              lblAdidasShirt.setStyle("-fx-text-fill: orange;");
       }
       else if(lblAdidasShirt.getText().contains("Limited time only")){
              lblAdidasShirt.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblAdidasShirt.getText().contains("Out Of Stock")){
           lblAdidasShirt.setStyle("-fx-text-fill: red;");
           rdbAdidasTshirt.setDisable(true);
           rdbAdidasTshirt.setStyle("-fx-background-color: grey;");
           rdbAdidasTshirt.setOpacity(0.3);
       }
       else {
           lblAdidasShirt.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageLongSleeve.getText().contains("Available")){
           lblMessageLongSleeve.setStyle("-fx-text-fill: green;");
       }
        else if(lblMessageLongSleeve.getText().contains("Sale")){
             lblMessageLongSleeve.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageLongSleeve.getText().contains("Limited time only")){
              lblMessageLongSleeve.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageLongSleeve.getText().contains("Out Of Stock")){
           lblMessageLongSleeve.setStyle("-fx-text-fill: red;");
           rdbLongSleeve.setDisable(true);
           rdbLongSleeve.setStyle("-fx-background-color: grey;");
           rdbLongSleeve.setOpacity(0.3);
       }
       else {
           lblMessageLongSleeve.setStyle("-fx-text-fill: black;");
       }
       if (lblGraphicTee.getText().contains("Available")){
           lblGraphicTee.setStyle("-fx-text-fill: green;");
       }
       else if(lblGraphicTee.getText().contains("Sale")){
             lblGraphicTee.setStyle("-fx-text-fill: orange;");
       }
       else if(lblGraphicTee.getText().contains("Limited time only")){
              lblGraphicTee.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblGraphicTee.getText().contains("Out Of Stock")){
            lblGraphicTee.setStyle("-fx-text-fill: red;");
            rdbGraphicTee.setDisable(true);
            rdbGraphicTee.setStyle("-fx-background-color: grey;");
            rdbGraphicTee.setOpacity(0.3);
       }
       else {
            lblGraphicTee.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageNikeAirforce.getText().contains("Available")){
           lblMessageNikeAirforce.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageNikeAirforce.getText().contains("Sale")){
             lblMessageNikeAirforce.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageNikeAirforce.getText().contains("Limited time only")){
              lblMessageNikeAirforce.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageNikeAirforce.getText().contains("Out Of Stock")){
           lblMessageNikeAirforce.setStyle("-fx-text-fill: red;");
           rdbNikeAirforce.setDisable(true);
           rdbNikeAirforce.setStyle("-fx-background-color: grey;");
           rdbNikeAirforce.setOpacity(0.3);
       }
       else {
          lblMessageNikeAirforce.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageAirJordan.getText().contains("Available")){
           lblMessageAirJordan.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageAirJordan.getText().contains("Sale")){
             lblMessageAirJordan.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageAirJordan.getText().contains("Limited time only")){
             lblMessageAirJordan.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageAirJordan.getText().contains("Out Of Stock")){
           lblMessageAirJordan.setStyle("-fx-text-fill: red;");
           rdbAirJordan.setDisable(true);
           rdbAirJordan.setStyle("-fx-background-color: grey;");
           rdbAirJordan.setOpacity(0.3);
       }
       else {
         lblMessageAirJordan.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageAdidasGazelle.getText().contains("Available")){
           lblMessageAdidasGazelle.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageAdidasGazelle.getText().contains("Sale")){
             lblMessageAdidasGazelle.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageAdidasGazelle.getText().contains("Limited time only")){
             lblMessageAdidasGazelle.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageAdidasGazelle.getText().contains("Out Of Stock")){
           lblMessageAdidasGazelle.setStyle("-fx-text-fill: red;");
           rdbAdidasGazelle.setDisable(true);
           rdbAdidasGazelle.setStyle("-fx-background-color: grey;");
           rdbAdidasGazelle.setOpacity(0.3);
       }
       else {
           lblMessageAdidasGazelle.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageConvers.getText().contains("Available")){
           lblMessageConvers.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageConvers.getText().contains("Sale")){
             lblMessageConvers.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageConvers.getText().contains("Limited time only")){
             lblMessageConvers.setStyle("-fx-text-fill: mediumorchid;");
       }
      
       else if (lblMessageConvers.getText().contains("Out Of Stock")){
           lblMessageConvers.setStyle("-fx-text-fill: red;");
           rdbConverse.setDisable(true);
           rdbConverse.setStyle("-fx-background-color: grey;");
           rdbConverse.setOpacity(0.3);
       }
       else {
           lblMessageConvers.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageDocMartin.getText().contains("Available")){
           lblMessageDocMartin.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageDocMartin.getText().contains("Sale")){
             lblMessageDocMartin.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageDocMartin.getText().contains("Limited time only")){
             lblMessageDocMartin.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageDocMartin.getText().contains("Out Of Stock")){
           lblMessageDocMartin.setStyle("-fx-text-fill: red;");
           rdbDocMartin.setDisable(true);
           rdbDocMartin.setStyle("-fx-background-color: grey;");
           rdbDocMartin.setOpacity(0.3);
       }
       else {
           lblMessageDocMartin.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageVans.getText().contains("Available")){
           lblMessageVans.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageVans.getText().contains("Sale")){
             lblMessageVans.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageVans.getText().contains("Limited time only")){
            lblMessageVans.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageVans.getText().contains("Out Of Stock")){
           lblMessageVans.setStyle("-fx-text-fill: red;");
           rdbVans.setDisable(true);
           rdbVans.setStyle("-fx-background-color: grey;");
           rdbVans.setOpacity(0.3);
       }
       else {
           lblMessageVans.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageChinos.getText().contains("Available")){
           lblMessageChinos.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageChinos.getText().contains("Sale")){
             lblMessageChinos.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageChinos.getText().contains("Limited time only")){
           lblMessageChinos.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageChinos.getText().contains("Out Of Stock")){
           lblMessageChinos.setStyle("-fx-text-fill: red;");
           rdbChinos.setDisable(true);
           rdbChinos.setStyle("-fx-background-color: grey;");
           rdbChinos.setOpacity(0.3);
       }
       else {
           lblMessageChinos.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageSweatPants.getText().contains("Available")){
           lblMessageSweatPants.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageSweatPants.getText().contains("Sale")){
             lblMessageSweatPants.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageSweatPants.getText().contains("Limited time only")){
           lblMessageSweatPants.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageSweatPants.getText().contains("Out Of Stock")){
           lblMessageSweatPants.setStyle("-fx-text-fill: red;");
           rdbSweatpants.setDisable(true);
           rdbSweatpants.setStyle("-fx-background-color: grey;");
           rdbSweatpants.setOpacity(0.3);
       }
       else {
           lblMessageSweatPants.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageAdidasJogger.getText().contains("Available")){
           lblMessageAdidasJogger.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageAdidasJogger.getText().contains("Sale")){
             lblMessageAdidasJogger.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageAdidasJogger.getText().contains("Limited time only")){
           lblMessageAdidasJogger.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageAdidasJogger.getText().contains("Out Of Stock")){
           lblMessageAdidasJogger.setStyle("-fx-text-fill: red;");
           rdbAdidasJoggers.setDisable(true);
           rdbAdidasJoggers.setStyle("-fx-background-color: grey;");
           rdbAdidasJoggers.setOpacity(0.3);
       }
       else {
           lblMessageAdidasJogger.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageNikeJoggers.getText().contains("Available")){
           lblMessageNikeJoggers.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageNikeJoggers.getText().contains("Sale")){
             lblMessageNikeJoggers.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageNikeJoggers.getText().contains("Limited time only")){
          lblMessageNikeJoggers.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageNikeJoggers.getText().contains("Out Of Stock")){
           lblMessageNikeJoggers.setStyle("-fx-text-fill: red;");
           rdbNikeJoggers.setDisable(true);
           rdbNikeJoggers.setStyle("-fx-background-color: grey;");
           rdbNikeJoggers.setOpacity(0.3);
       }
       else {
           lblMessageNikeJoggers.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageJeans.getText().contains("Available")){
           lblMessageJeans.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageJeans.getText().contains("Sale")){
             lblMessageJeans.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageJeans.getText().contains("Limited time only")){
          lblMessageJeans.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageJeans.getText().contains("Out Of Stock")){
           lblMessageJeans.setStyle("-fx-text-fill: red;");
           rdbJeans.setDisable(true);
           rdbJeans.setStyle("-fx-background-color: grey;");
           rdbJeans.setOpacity(0.3);
       }
       else {
           lblMessageJeans.setStyle("-fx-text-fill: black;");
       }
       if (lblMessageCarhartt.getText().contains("Available")){
           lblMessageCarhartt.setStyle("-fx-text-fill: green;");
       }
       else if(lblMessageCarhartt.getText().contains("Sale")){
             lblMessageCarhartt.setStyle("-fx-text-fill: orange;");
       }
       else if(lblMessageCarhartt.getText().contains("Limited time only")){
          lblMessageCarhartt.setStyle("-fx-text-fill: mediumorchid;");
       }
       else if (lblMessageCarhartt.getText().contains("Out Of Stock")){
           lblMessageCarhartt.setStyle("-fx-text-fill: red;");
           rdbCarhartt.setDisable(true);
           rdbCarhartt.setStyle("-fx-background-color: grey;");
           rdbCarhartt.setOpacity(0.3);
       }
       else {
           lblMessageCarhartt.setStyle("-fx-text-fill: black;");
       }
       
    lblWelcome.setText("Welcome " + strFName);
    
    //populating sizes with the sizes users selected when they signed up to make a more seamless and faster experience for users
    txtShoeSize.setText(strShoeSize);
    txtWaistSize.setText(strWaistSize);
  
    
    btnAddShirts.setDisable(false);
    btnAddPants.setDisable(false);
    btnAddShoes.setDisable(false);
    
    txtEmailComplaint.setEditable(false);
    
    lblResponse1.setVisible(false);
    lblResponse2.setVisible(false);
        
        anchStore.setVisible(true);
        anchOrders.setVisible(false);
        anchHelp.setVisible(false);
        anchBasket.setVisible(false);
     
        //Highlighting area of code: highlights the item the user clicks to buy, if it is available.
        //Shirts first
        rdbAdidasTshirt.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbAdidasTshirt.setStyle("-fx-background-color: red;");
        rdbAdidasTshirt.setOpacity(0.2);
    } else {
        rdbAdidasTshirt.setStyle("");
        rdbAdidasTshirt.setOpacity(0.0);
    }
});
        rdbPlainTShirt.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbPlainTShirt.setStyle("-fx-background-color: red;");
        rdbPlainTShirt.setOpacity(0.2);
    } else {
        rdbPlainTShirt.setStyle("");
        rdbPlainTShirt.setOpacity(0.0);
    }
});
        rdbGraphicTee.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbGraphicTee.setStyle("-fx-background-color: red;");
        rdbGraphicTee.setOpacity(0.2);
    } else {
        rdbGraphicTee.setStyle("");
        rdbGraphicTee.setOpacity(0.0);
    }
});
        rdbPlainShirt.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbPlainShirt.setStyle("-fx-background-color: red;");
        rdbPlainShirt.setOpacity(0.2);
    } else {
        rdbPlainShirt.setStyle("");
        rdbPlainShirt.setOpacity(0.0);
    }
});
        rdbUCCShirt.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbUCCShirt.setStyle("-fx-background-color: red;");
        rdbUCCShirt.setOpacity(0.2);
    } else {
        rdbUCCShirt.setStyle("");
        rdbUCCShirt.setOpacity(0.0);
    }
});
        rdbLongSleeve.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbLongSleeve.setStyle("-fx-background-color: red;");
        rdbLongSleeve.setOpacity(0.2);
    } else {
        rdbLongSleeve.setStyle("");
        rdbLongSleeve.setOpacity(0.0);
    }
});
        //Pants Second
        rdbAdidasJoggers.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbAdidasJoggers.setStyle("-fx-background-color: royalblue;");
        rdbAdidasJoggers.setOpacity(0.2);
    } else {
        rdbAdidasJoggers.setStyle("");
        rdbAdidasJoggers.setOpacity(0.0);
    }
});
         rdbNikeJoggers.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbNikeJoggers.setStyle("-fx-background-color: royalblue;");
        rdbNikeJoggers.setOpacity(0.2);
    } else {
        rdbNikeJoggers.setStyle("");
        rdbNikeJoggers.setOpacity(0.0);
    }
});
          rdbJeans.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbJeans.setStyle("-fx-background-color: royalblue;");
        rdbJeans.setOpacity(0.2);
    } else {
        rdbJeans.setStyle("");
        rdbJeans.setOpacity(0.0);
    }
});
        rdbCarhartt.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbCarhartt.setStyle("-fx-background-color: royalblue;");
        rdbCarhartt.setOpacity(0.2);
    } else {
        rdbCarhartt.setStyle("");
        rdbCarhartt.setOpacity(0.0);
    }
});
        rdbSweatpants.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbSweatpants.setStyle("-fx-background-color: royalblue;");
        rdbSweatpants.setOpacity(0.2);
    } else {
        rdbSweatpants.setStyle("");
        rdbSweatpants.setOpacity(0.0);
    }
});
         rdbChinos.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbChinos.setStyle("-fx-background-color: royalblue;");
        rdbChinos.setOpacity(0.2);
    } else {
        rdbChinos.setStyle("");
        rdbChinos.setOpacity(0.0);
    }
});
         //Shoes Third
         rdbConverse.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbConverse.setStyle("-fx-background-color: mediumorchid;");
        rdbConverse.setOpacity(0.3);
    } else {
        rdbConverse.setStyle("");
        rdbConverse.setOpacity(0.0);
    }
}); 
          rdbNikeAirforce.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbNikeAirforce.setStyle("-fx-background-color: mediumorchid;");
        rdbNikeAirforce.setOpacity(0.3);
    } else {
        rdbNikeAirforce.setStyle("");
        rdbNikeAirforce.setOpacity(0.0);
    }
}); 
          rdbAirJordan.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbAirJordan.setStyle("-fx-background-color: mediumorchid;");
        rdbAirJordan.setOpacity(0.3);
    } else {
        rdbAirJordan.setStyle("");
        rdbAirJordan.setOpacity(0.0);
    }
}); 
          rdbDocMartin.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbDocMartin.setStyle("-fx-background-color: mediumorchid;");
        rdbDocMartin.setOpacity(0.3);
    } else {
        rdbDocMartin.setStyle("");
        rdbDocMartin.setOpacity(0.0);
    }
}); 
          rdbVans.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbVans.setStyle("-fx-background-color: mediumorchid;");
        rdbVans.setOpacity(0.3);
    } else {
        rdbVans.setStyle("");
        rdbVans.setOpacity(0.0);
    }
}); 
          rdbAdidasGazelle.selectedProperty().addListener((observable, oldValue, newValue) -> {
 
            if (newValue) {
        rdbAdidasGazelle.setStyle("-fx-background-color: mediumorchid;");
        rdbAdidasGazelle.setOpacity(0.3);
    } else {
        rdbAdidasGazelle.setStyle("");
        rdbAdidasGazelle.setOpacity(0.0);
    }
}); 
        
                        txtWaistSize.textProperty().addListener((observable, oldValue, newValue) -> {
    if (!newValue.matches("\\d*")) {
        txtWaistSize.setText(newValue.replaceAll("[^\\d]", ""));
    }
});
                        
                                        txtShoeSize.textProperty().addListener((observable, oldValue, newValue) -> {
    if (!newValue.matches("\\d*")) {
        txtShoeSize.setText(newValue.replaceAll("[^\\d]", ""));
    }
});
       

    //Makes the background more white
    ((Node) lblDisplayOrder.getParent()).setStyle("-fx-background-color: white;");  
    ((Node) lblDisplayOrder.getParent()).setStyle("-fx-scrollpane-color: white;"); 
 

     // Sets the label that displays "Item added" message to invisible as default
       lblDisplayOrder.setText("");
    
    //Adds options to combo boxes    
       cmbSizeShirts.getItems().addAll
        ("XS", "S", "M", "L","XL");
    
    cmbSizeShirts.getSelectionModel().select(strShirtSize);

    }
   
    //This method is what we use to calculate the total price of all items added to the basket
       
  public void CountingCoins(){
        
            dblTotal = (dblNewValue + dblTotal);
            strTotal = Double.toString(dblTotal);
             txtTotal.setText("€‎" + strTotal);
             //enables buttons to allow users to purchase the item in their bakset or to clear their basket or delete the most recently added item
             btnDeleteItem.setDisable(false);
             btnClearOrder.setDisable(false);
             btnCheckout.setDisable(false);
}
  public void BasketLineIncrease(){
      //increases the line number everytime an item is added
      intBasketLine = intBasketLine + 1;
  }
  @FXML
  public void DeleteLastItem(){
      //Deletes the most recently added item from the basket and takes away the price of that item from the total
    dblTotal= (dblTotal-dblNewValue);
     strTotal = Double.toString(dblTotal);
             txtTotal.setText("€" + strTotal);
             dblNewValue = 0.00;
              String text = txtBasket.getText();
              //deletes most recent line by identifying the new line('/n') symbol
    int lastLineStartIndex = text.lastIndexOf('\n', text.length() - 2) + 1;
    txtBasket.deleteText(lastLineStartIndex, txtBasket.getLength());
    //disables neccessary buttons, depending on if the item the user deleted was the last item in their basket or not
    btnDeleteItem.setDisable(true);
    if(dblTotal==0){
             btnCheckout.setDisable(true);
             btnClearOrder.setDisable(true);
         }
         else{
             btnCheckout.setDisable(false);
             btnClearOrder.setDisable(false);
         }
    //decreases the basket line integer so that it stays correct.
    intBasketLine = (intBasketLine -1);
  }
  
  @FXML
  private void ClearOrder(){
     // Resetting all necessary values and text areas, disabling applicable buttons
      btnDeleteItem.setDisable(true);
      dblNewValue =0.00;
      dblTotal = 0.00;
      txtBasket.setText("");
      txtTotal.setText("");
      btnClearOrder.setDisable(true);
      btnCheckout.setDisable(true);
      intBasketLine = 0;
  }
  
  @FXML
  private void ConfirmPayment(){
      //deals with how to confirm a payment, create an order for that user
  counter.increment();
  String strCounter = Integer.toString(counter.getValue());
  LocalDate DateConvert = LocalDate.now();

 // 7 day delivery
  LocalDate dateDelivery = DateConvert.plusDays(7);
  
  
  String strTodayDate = DateConvert.toString();
  String strDeliveryDate = dateDelivery.toString();
  //inbasket line counts the number of items in a delivery
  String strQuantity = Integer.toString(intBasketLine);
  
  String  strCardHolder = txtCardHolderName.getText();
  String strCardNo = txtCardNumber.getText();
  LocalDate selectedDate = dpExpiryDatePayment.getValue();
  String strCVV = txtCVVNumber.getText();
      //error handling
  if ( strCardHolder.length()==0 || strCVV.length() == 0 || strCardNo.length() == 0 || selectedDate == null ) {
            
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Details Error");
            alert.setContentText("All Details not filled in");
            alert.showAndWait();
      
    }
      else if (strCardNo.length()!=16){
        
            lblCardNo.setVisible(true);
            lblCardNo.setText("Card Number must be 16 Digits");
               }
      else if (strCVV.length()!=3){
        
            lblCVV.setVisible(true);
            lblCVV.setText("CVV must be 3 Digits");
               }
      else{
          //Informing the user of their purchase, the total cost, delivery date and order ID
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment Confirmed");
          alert.setHeaderText("Transaction Completed");
          alert.setContentText("Your account (card number: " + txtCardNumber.getText() +  ") has been charged " + txtTotal.getText() + "0. View your orders to find more details about this order. Order ID = " + strCounter + " Delivery date: " + dateDelivery);
          alert.showAndWait();
          ClearOrder();
          
          //Creating a new order
          Order orderToCreate = new Order();
         
          
          orderToCreate.setId(strCounter);
          orderToCreate.setOrderUsername(strUsername);
          orderToCreate.setBasket(strQuantity);
          orderToCreate.setOrderPrice(strTotal);
          orderToCreate.setOrderDate(strTodayDate);
          orderToCreate.setOrderDeliveryDate(strDeliveryDate);
          
          boolean userO = persistanceUser.createOrder(orderToCreate);
          if (userO == true){
              System.out.println("Hoorah");
         
          }
          
          anchPaymentDetails.setVisible(false);
          
      }
  }
  //The method used to calculate the cost in each currency. We used the Currency exchange as of 29/03/2023
  @FXML
  private void ConvertCurrency(){
   
     //Setting how each currency will be converted depending on which country the user said they were from when they signed up to the Forever 22 Website
      if (strCountry.equals("Canada")){
          
          dblCurrencyMultiplier = 1.48;
          strCurrencySymbol = "C$";
         dblConvertedTotal = (dblCurrencyMultiplier * dblTotal);
      }
          else  if (strCountry.equals("United States")){
          dblCurrencyMultiplier = 1.09;
          strCurrencySymbol = "$";
          dblConvertedTotal = (dblCurrencyMultiplier * dblTotal);
      }
          else if (strCountry.equals("United Kingdom")){
            dblCurrencyMultiplier = 0.88;
            strCurrencySymbol = "£";
            dblConvertedTotal = (dblCurrencyMultiplier * dblTotal);
          }
      //Informing the user of the total price in their currency so they have a better understanding of just how much they are paying
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Currency Conversion");
          alert.setHeaderText("Converting from Euro to Home Currency");
          alert.setContentText("The current total in Euro: (€‎" + dblTotal + ") is equal to: " + strCurrencySymbol + df.format(dblConvertedTotal));
          alert.showAndWait();
          
  }

                   @FXML
    private void handlebtnSearchCustomerOrders(ActionEvent event)
    {
        String strOrderID = txtCustomerOrderSearch.getText();
        txtOrderView.setText(getCUSTOMERSEARCHORDERFromDatabase(strOrderID));
        
    }

    
    //Allows users to look through their own past orders on the orders page
 String username = strUsername;
public String getCUSTOMERORDERFromDatabase(String username) {
     strOrders = "";
    Connection conn = null;
    PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
    try {
        conn = JDBConnection.getConnection();
        stmt1 = conn.prepareStatement("SELECT * FROM TBLORDERS WHERE ORDERUSERNAME = ?");
        stmt1.setString(1, username);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
             strOrders += " ID: " +  rs1.getString("ORDERID") + " Username " + rs1.getString("ORDERUSERNAME") + " No. of Items:  " + rs1.getString("ORDERQUANTITY") + " Total: €"+ rs1.getString("ORDERTOTAL")+ "0 Order Date: " + rs1.getString("ORDERDATE") +" Delivery Date: "+rs1.getString("ORDERDELIVERYDATE") +"\n";
        }
        rs1.close();
        stmt1.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return strOrders;

}
       //Allows users to SEARCH through their own orders
 
public String getCUSTOMERSEARCHORDERFromDatabase(String strOrderID) {
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
//Allows users to delete their order but only if it is before the delivery date (method)
public boolean OrderDelete( String strOrderID) {
    boolean orderDelete;
    orderDelete = false;
    LocalDate today = LocalDate.now();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = JDBConnection.getConnection();
        stmt = conn.prepareStatement("DELETE FROM TBLORDERS WHERE ORDERID = ? AND ORDERDELIVERYDATE > ?");
        stmt.setString(1, strOrderID);
        stmt.setDate(2, java.sql.Date.valueOf(today));
        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            orderDelete = true;
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return orderDelete;
}



       //Allows users to cancel orders that have not yet arrived
@FXML
public void handlebtnCancelOrder(ActionEvent event) {
   
    
    String strOrderID = txtCustomerOrderSearch.getText();
     txtOrderView.setText(getCUSTOMERSEARCHORDERFromDatabase(strOrderID));
     //error handling
    if(strOrderID.length() == 0){
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Error");
             alert.setHeaderText("Details Error");
             alert.setContentText("Please give an order ID");
             alert.showAndWait();
    }
    
    boolean userC = OrderDelete( strOrderID);
    //Does not allow users to cancel an order that is arriving that day or has already arrived (Past its delivery date)
    if(userC == false){
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Error");
             alert.setHeaderText("Date Error");
             alert.setContentText("The order date has passed please use the Help to contact a manager");
             alert.showAndWait();
    }
    else{
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Success");
          alert.setHeaderText("Order successfully deleted");
          alert.setContentText("Have a good day");
          alert.showAndWait();
         // txtOrderView.setText("");
      
         txtOrderView.setText(getCUSTOMERORDERFromDatabase(username));
   
    }
    
    
}


@FXML
 public void btnClearOrderSearch(ActionEvent event) {
    //Clears the search and repopulates the text area
     txtCustomerOrderSearch.setText("");
 
     txtOrderView.setText(getCUSTOMERORDERFromDatabase(username));
     
 }
 }