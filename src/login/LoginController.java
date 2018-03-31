package login;

import com.jfoenix.controls.JFXButton;
import connection.loginModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    public loginModel lm=new loginModel();
    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private CheckBox rememberme;

    @FXML
    private Hyperlink forget;

    @FXML
    private Hyperlink signup;

    @FXML
    private JFXButton signin;
    
    @FXML
    private Label abc;

    @FXML
    void makeSignin(ActionEvent event) throws SQLException, IOException {
     try{
         if(lm.isLogin(email.getText(), password.getText())){
         abc.setText("corrected");
     }
     else{
         abc.setText(" not corrected");
         } 
     }catch(SQLException e){
         abc.setText(" not corrected");
         e.printStackTrace();
     }  
        /*Stage stage=new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("terms.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Accounts Console");
        stage.setScene(scene);
        stage.show();*/
     }
    
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void makeSignup(ActionEvent event) throws IOException {
        try{
        ((Node)event.getSource()).getScene().getWindow().hide();    
        Stage stage=new Stage();
        //FXMLLoader loader=new FXMLLoader();
        AnchorPane root;
        root = FXMLLoader.load(getClass().getResource("/signup/signup.fxml")/*.openStream()*/);
        Scene scene = new Scene(root);
        stage.setTitle("Accounts Console");
        stage.setScene(scene);
        stage.show();
        }catch(IOException e){
            System.out.println(e);
        }
      
    }
    public void initialize(URL location, ResourceBundle resources) {
  // TODO Auto-generated method stub
  if (lm.isDbConnected()) {
   abc.setText("Connected");
  } else {
   abc.setText("Not Connected");
  }
 }

}
