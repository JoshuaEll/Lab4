package application;
/**
 * launches program and opens the first view
 * @author jbq715
 */
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane mainLayout;
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Star Fleet");

			// Load the FXML document (we created with SceneBuilder)
			showLogin();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * opens the login view
	 * @throws IOException
	 */
	public void showLogin() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation( Main.class.getResource("controller/Login.fxml") );
		// Load the layout from the FXML and add it to the scene
		mainLayout =  loader.load();				
		Scene scene = new Scene( mainLayout );
		
		// Set the scene to stage and show the stage to the user
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
