package application.controller;
/**
 * Controller for the personel fxml file
 * @author jbq715
 */
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import application.Main;
import application.model.CrewMember;
import application.model.Starship;

public class PersonelController implements Initializable{
	@FXML
	private TextField UserText;
	@FXML
	private Label label1;
	@FXML
	private Label CapLabel;
	@FXML
	private ImageView CapImage;
	@FXML
	private ImageView CoImage;
	@FXML
	private ImageView ComImage;
	@FXML
	private ImageView EngImage;
	@FXML
	private ImageView HelmImage;
	@FXML
	private ImageView NavImage;
	@FXML
	private ImageView MedImage;
	@FXML
	private ImageView NurImage;
	@FXML
	private Label COLab;
	@FXML
	private Label ComLabel;
	@FXML
	private Label EngLab;
	@FXML
	private Label HelmLabel;
	@FXML
	private Label NavLabel;
	@FXML
	private Label MedLabel;
	@FXML
	private Label NurLabel;
	@FXML
	private Label NoCrew;
	@FXML
	private Button LogOut;
	
	/**
	 * handles the log out button
	 * @param event
	 * @throws IOException
	 */
	public void handle(ActionEvent event) throws IOException{
		Stage stage = (Stage) LogOut.getScene().getWindow();
	    stage.close();
	    try {
			Stage firstStage = new Stage();
			
			firstStage.setTitle("Star Fleet");

			FXMLLoader Sloader = new FXMLLoader();
			Sloader.setLocation( Main.class.getResource("controller/Login.fxml") );
			// Load the layout from the FXML and add it to the scene
			AnchorPane fLayout = (AnchorPane) Sloader.load();;	
			Scene scene = new Scene( fLayout );
			
			// Set the scene to stage and show the stage to the user
			firstStage.setScene(scene);
			firstStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * initializes the window with crew pictures and labels
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Starship st = new Starship();
		List<File> sa = new ArrayList<>();
		List<CrewMember> user = new ArrayList<CrewMember>();
		
		//set the labels initially to false to hide them
		CapLabel.setVisible(false);
		COLab.setVisible(false);
		ComLabel.setVisible(false);	
		EngLab.setVisible(false);
		HelmLabel.setVisible(false);
	    NavLabel.setVisible(false);
		MedLabel.setVisible(false);
		NurLabel.setVisible(false);

		// loads the personnel csv file and the images folder
		try { 

			user = st.loadCrew("data/personnel.csv");
			sa = st.getPicture("data/images/", user);
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		//check if user does not have a crew
		if(user.size() == 0){
			label1.setText("Welcome Captain, " + LoginController.Name);
			NoCrew.setVisible(true);
			NoCrew.setText("No Crew detected!");
		}
		//assigns pictures and labels
		if(user.size() <= 8 && user.size() > 0){
			for (CrewMember temp : user){
					
					String temp2 = temp.toString();
						
					if(temp2.contains("Captain")){
						CapLabel.setVisible(true);
						String mes = st.welMessage(temp2);
						String la = st.LabelMessage(temp);
						label1.setText("Welcome, " + mes);
						CapLabel.setText(la);
						
						for (File f : sa){
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
						        Image image1 = new Image(f.toURI().toString());
								CapImage.setImage(image1);
							}
						}
							
					}
					else if(temp2.contains("First Officer")){
						String la = st.LabelMessage(temp);
						COLab.setVisible(true);
						COLab.setText(la);
						
						for (File f : sa){
			
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
						        Image image1 = new Image(f.toURI().toString());
								CoImage.setImage(image1);
							}
						}
					}
					else if(temp2.contains("Medical")){
						String la = st.LabelMessage(temp);
						MedLabel.setVisible(true);
						MedLabel.setText(la);
						
						for (File f : sa){
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
								Image image1 = new Image(f.toURI().toString());
								MedImage.setImage(image1);
							}
						}
					}
					else if(temp2.contains("Engineering")){
							String la = st.LabelMessage(temp);
							EngLab.setVisible(true);
							EngLab.setText(la);
							
						for (File f : sa){
							
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
								Image image1 = new Image(f.toURI().toString());
								EngImage.setImage(image1);
							}
						}
					}
					else if(temp2.contains("Nurse")){
						String la = st.LabelMessage(temp);
						NurLabel.setVisible(true);
						NurLabel.setText(la);
						
						for (File f : sa){
							
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
							
							Image image1 = new Image(f.toURI().toString());
							NurImage.setImage(image1);
							}
						}
					}
					else if(temp2.contains("Communications")){
						String la = st.LabelMessage(temp);
						ComLabel.setVisible(true);
						ComLabel.setText(la);
	
						
						for (File f : sa){
							
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
							Image image1 = new Image(f.toURI().toString());
							ComImage.setImage(image1);
							
							}
						}
					}
					else if(temp2.contains("Helmsman")){
						String la = st.LabelMessage(temp);
						HelmLabel.setVisible(true);
						HelmLabel.setText(la);
						
						for (File f : sa){
							
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
							Image image1 = new Image(f.toURI().toString());
							HelmImage.setImage(image1);
							
							}
						}
					}
					else if(temp2.contains("Navigator")){
						String la = st.LabelMessage(temp);
						NavLabel.setVisible(true);
						NavLabel.setText(la);
						
						for (File f : sa){
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
							Image image1 = new Image(f.toURI().toString());
							NavImage.setImage(image1);
							
							}
						}
					}
					else if(temp2.contains("Counselor")){
						String la = st.LabelMessage(temp);
						ComLabel.setVisible(true);
						ComLabel.setText(la);
						
						for (File f : sa){
							
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
							Image image1 = new Image(f.toURI().toString());
							ComImage.setImage(image1);
							
							}
						}
					}
					else if(temp2.contains("Security")){
						String la = st.LabelMessage(temp);
						NurLabel.setVisible(true);
						NurLabel.setText(la);
						
						for (File f : sa){
							
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
							
							Image image1 = new Image(f.toURI().toString());
							NurImage.setImage(image1);
							}
						}
					}
					else if(temp2.contains("Operations")){
						String la = st.LabelMessage(temp);
						NavLabel.setVisible(true);
						NavLabel.setText(la);
						
						for (File f : sa){
							String ftemp = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
							String fileNameWithOutExt = ftemp.replaceFirst("[.][^.]+$", "");
							
							if(temp2.toLowerCase().contains(fileNameWithOutExt)){
								
							Image image1 = new Image(f.toURI().toString());
							NavImage.setImage(image1);
							
							}
						}
					}
			  }
			
			
			}
		
	}
}
	
