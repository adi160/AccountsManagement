package signup;

import connection.sqlConnection;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signupController {
    boolean ag;
    
    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField repassword;

    @FXML
    private CheckBox agree;

    @FXML
    private Hyperlink terms;

    @FXML
    private Hyperlink alreadymember;

    @FXML
    private TextField dob;

    @FXML
    private JFXButton register;

    @FXML
    void alreadyMember(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide(); 
        Stage stage=new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Accounts Console");
        stage.setScene(scene);
        stage.show();
    }
     @FXML
    void Agree(ActionEvent event) throws SQLException {
     if(agree.isSelected()){
         ag=true;
     }else{
        ag=false; 
     }
    }
        @FXML
        void onRegister(ActionEvent event) throws SQLException{
            if(ag){
        String temail = email.getText();
        String tpassword = password.getText();
        String trepassword = repassword.getText();
        String tdob = dob.getText();
        
        if(temail.isEmpty() || tpassword.isEmpty() || trepassword.isEmpty() || tdob.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Fields must not be empty");
            alert.showAndWait();
            return;
        } 
        
        String sql = "INSERT INTO admin (email,password,repassword,dob) VALUES(?,?,?,?)";
        Connection conn;
        conn = sqlConnection.Connector();
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1,temail);
        pst.setString(2,tpassword);
        pst.setString(3,trepassword);
        pst.setString(4,tdob);
        
        pst.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Register successfully");
            alert.showAndWait();
            }
        }
            
    
    @FXML
    void onTerms(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("terms.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Accounts Console");
        stage.setScene(scene);
        stage.show();
    }


    public void initialize(URL location, ResourceBundle resources) {
        
    }
    

}
