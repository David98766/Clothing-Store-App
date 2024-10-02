/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxproject;

import DataAccess.DataAccess;
import DataAccess.persistanceUser;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.ClothingManager;
import logic.User;

/**
 * FXML Controller class
 *
 * @author David
 */
public class FXMLDocumentController implements Initializable {
//Referencing other classes
   // FXMLClothingMainGUI p = new FXMLClothingMainGUI();
    DataAccess dataAccess = new DataAccess();
    login L = new login();
    //declaring the string Username
    public String Username;
    
    
    @FXML
    private Button btnCustomerLogin;
    @FXML
    public TextField txtUserName;
    @FXML
    private PasswordField pwfLogin;
    @FXML
    private Button btnSignUp;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnManagerLogin;
    
    @FXML 
    private Label lblLoginMessage; 

    //Declaring integers that will count down how many attempts the user/manager has remaining to log in
    int intManagerLoginAC = 3;
    
    int intCustomerLoginAC = 3;
    

    /**
     * Initializes the controller class.
     */
   
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Initializing tooltips with colours to match the GUI. These will help customers navigate the log in page
        final Tooltip ttManagerLogin = new Tooltip();
        ttManagerLogin.setText("This is only for staff");
        btnManagerLogin.setTooltip(ttManagerLogin);
        ttManagerLogin.setStyle("-fx-background-color: royalblue;");
    
        final Tooltip ttCustomerLogin = new Tooltip();
        ttCustomerLogin.setText("Click this button to log in");
        btnCustomerLogin.setTooltip(ttCustomerLogin);
        ttCustomerLogin.setStyle("-fx-background-color: royalblue;");
        
        final Tooltip ttSignUp = new Tooltip();
        ttSignUp.setText("Click this button to create an account");
        btnSignUp.setTooltip(ttSignUp);
        ttSignUp.setStyle("-fx-background-color: royalblue;");
        
        
        
        
    }    
    
    
    
        @FXML
    private void handlebtnClear(ActionEvent event) {
        txtUserName.setText("");
        pwfLogin.setText("");
      
    }
    

      @FXML 
     private void handlebtnManagerLogin(ActionEvent event) throws IOException {
           //calls the pop up box that managers have to enter a password into to gain access to the Manager Portal
           //the password is "lemon"
         showDialog();
          }
     
     
    @FXML
     public void showDialog(){
         //Creating dialog box to take one string input
         Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Look, a Custom Login Dialog");
    //Declaring the login button
            ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
            Button btnLogin = (Button) dialog.getDialogPane().lookupButton(loginButtonType);
            dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
            
            /*dialog.setTitle("Login Dialog");
            dialog.setHeaderText("Look, a Custom Login Dialog");
            // Set the icon (must be included in the project).*/
           
            //dialog.setGraphic(new ImageView(this.getClass().getResource("/resources1/Inkedforever_22.jpg").toString()));
            

            // Create the password label and field.
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            PasswordField password = new PasswordField();
            password.setPromptText("Password");

            Label lblIncorrectPassword= new Label();
            lblIncorrectPassword.setText("You must know the manager passcode to access the manager portal");
            Label lblAttemptCounter = new Label();
            //showing manager how many attempts he/she has remaining 
            lblAttemptCounter.setText("Attempts remaining: " +intManagerLoginAC);

            grid.add(lblIncorrectPassword, 0, 0);
            grid.add(new Label("Password:"), 0, 1);
            grid.add(password, 1, 1);
            grid.add(lblAttemptCounter,0,2);
            
            dialog.getDialogPane().setContent(grid);

            Platform.runLater(() -> password.requestFocus());


            Optional<String>result = dialog.showAndWait();

            String strManagerPassword = password.getText();

           // Button btnLogin = (Button) dialog.getDialogPane().lookupButton(loginButtonType);
           
          //setting password to "lemon"
            if (result.isPresent()  && strManagerPassword.equals( "lemon")){

            
                System.out.println( "Password=" + strManagerPassword);
                //hiding login stage 
                Stage LoginStage = (Stage) btnCustomerLogin.getScene().getWindow();
                LoginStage.hide();
                //Calling manager portal stage
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManagerPortalFXML.fxml"));
                    Parent root2 = (Parent) fxmlLoader.load();
                    Stage ManagerPortalStage = new Stage();
                    ManagerPortalStage.initModality(Modality.APPLICATION_MODAL);
                    ManagerPortalStage.initStyle(StageStyle.DECORATED);
                    ManagerPortalStage.setTitle("Forever 22 Manager Portal");
                    ManagerPortalStage.setScene(new Scene(root2));  
               
                
                    ManagerPortalStage.show();

            }
                catch(Exception e) {
                    e.printStackTrace();
                }

                    }
            else {
                    //if the user gets the manager password wrong then the ManagerLoginFailed method is called
                    lblIncorrectPassword.setText("Incorrect Passccode");
                    ManagerLoginFailed();
                    
    
        }
     }
       
     @FXML
     private void ManagerLoginFailed(){
         //if the user has attempts remaining the dialog is displayed again
              if (intManagerLoginAC > 1) {
           intManagerLoginAC--;
           showDialog(); 
        }
        else {
            //if they do not then the button is disabled and they cannot attempt to log in again until they restart the application
            Dialog<String> dialog = new Dialog<>();
            
            dialog.hide();
            
            btnManagerLogin.setDisable(true);
        }
     }
             
             
    @FXML
    private void handlebtnCustomerLogin(ActionEvent event) throws IOException {
                 // get a handle to the stage

     
        String username = txtUserName.getText();
        String password = pwfLogin.getText();
     
//calling login class method to ensure username and password are correct
if (L.validateLogin(username, password)) {
    // code to execute if login is successful
    Stage LoginStage = (Stage) btnSignUp.getScene().getWindow();

         LoginStage.hide();
      try {
          
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainClothingGUI.fxml"));
        Parent root2 = (Parent) fxmlLoader.load();
        Stage MainClothingGUI = new Stage();
        MainClothingGUI.initModality(Modality.APPLICATION_MODAL);
        MainClothingGUI.initStyle(StageStyle.DECORATED);
        MainClothingGUI.setTitle("Forever22 Customer Portal");
        MainClothingGUI.setScene(new Scene(root2));  
        MainClothingGUI.show();
        
   
}
        catch(Exception e) {
        e.printStackTrace();
    }
} else {
    // code to execute if login is unsuccessful
        
            //If the attempt counter is above 2 then the user gets another attempt to log in
            if(intCustomerLoginAC > 1){
                intCustomerLoginAC--;
                //label is updated to show attempts remaining
                lblLoginMessage.setText("User Not Found. Attempts Remaining:  " + intCustomerLoginAC);
                 txtUserName.setText("");
                pwfLogin.setText("");
        }
            else {
                //if not, the user can either restart the application or else create a new user if they cannot remember their login details 
                lblLoginMessage.setText("You have no attempts remaining. Create a new account.");
                btnCustomerLogin.setDisable(true);
                
                txtUserName.setText("");
                pwfLogin.setText("");
            }
    }
}
  //brings user to the customer portal id=f the username and password is correct
    
                 /*p.setLabel(Username);*/
    
    @FXML
    private void handlebtnSignUp(ActionEvent event) throws IOException {
         // get a handle to the stage
        Stage LoginStage = (Stage) btnSignUp.getScene().getWindow();

         LoginStage.hide();
  //loads up Sign Up Stage
      try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUpFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage SignUpStage = new Stage();
        SignUpStage.initModality(Modality.APPLICATION_MODAL);
        SignUpStage.initStyle(StageStyle.DECORATED);
        SignUpStage.setTitle("Forever 22 Sign Up!");
        SignUpStage.setScene(new Scene(root1));  
        SignUpStage.show();
   
}
        catch(Exception e) {
            e.printStackTrace();
    }
          
    }
    
}
