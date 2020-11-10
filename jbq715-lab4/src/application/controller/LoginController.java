package application.controller;
/**
 * 
 * Controller class that handles the login fxml file
 * @author jbq715
 *
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.Initializable;
import application.model.User;

public class LoginController implements Initializable{
	//declared statically to be called by the user class
	public static String Name;

	@FXML
	private Label ULabel;
	
	@FXML
	private Label pwLabel;
	
	@FXML
	private TextField UserText;
	
	@FXML
	private PasswordField PWText;
	
	@FXML 
	private Label ErLabel;
	
	@FXML
	private Button LogIn;
	
/**
 * Handles the log in button. Gets user name and password, after login button is pushed and validates information
 * @param event
 * @throws IOException
 */
	
	public void handleInput(ActionEvent event) throws IOException{
		Name = UserText.getText();
		String PW = PWText.getText();

		User u = new User(Name, PW);
		List<String> li = new ArrayList<>();
		boolean check = false;

		try {
			check = u.validate(Name, PW);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//closes login view and opens the second window
		if (check) {
			ErLabel.setText("Successful Login");
			li.add(Name);
			u.setUser(li);
			Stage stage = (Stage) LogIn.getScene().getWindow();

		    stage.close();
			try {
				Stage seconStage = new Stage();
				
				seconStage.setTitle("Star Fleet");

				FXMLLoader Sloader = new FXMLLoader();
				Sloader.setLocation( Main.class.getResource("controller/Personel.fxml") );
				// Load the layout from the FXML and add it to the scene
				AnchorPane seconLayout = (AnchorPane) Sloader.load();;	
				Scene scene = new Scene( seconLayout );
				
				// Set the scene to stage and show the stage to the user
				seconStage.setScene(scene);
				seconStage.show();
			
				
			} catch(Exception e) {
				e.printStackTrace();
			}

			
		}else {
			ErLabel.setText("Invalid Username/Password");
			
		}
	
	}
	/**
	 * Initializes the screen with the two labels
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ULabel.setText("Please enter your Username :");
		pwLabel.setText("Please enter your Password :");
	}
}
