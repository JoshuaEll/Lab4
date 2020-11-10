package application.model;
/**
 * Class to load information from csv files and assign informations to lists
 * @author jbq715
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * This class holds the information to create a starship and will return them
 * @author Joshua Ellis
 * @author jbq715
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.controller.LoginController;

public class Starship {
	
	private String shipName;
	private String registry;
	private String shipClass;
	private ArrayList<CrewMember> crewList;
	private List<CrewMember> newList;
	private String crewPath;

/**
 * Constructor for the Starship Class
 * @param shipName
 * @param registry
 * @param shipClass
 */
	Starship(String shipName, String registry, String shipClass){
		this.setShipName(shipName);
		this.setRegistry(registry);
		this.setShipClass(shipClass);
		setCrewList(new ArrayList<>());
		newList = new ArrayList<>();
	}

public Starship() {
	setCrewList(new ArrayList<>());
	newList = new ArrayList<>();
}

/**
 * Gets the name of the ship
 * @return shipName(String)
 */
	public String getShipName() {
		return shipName;
	}

/**
 * Sets the name of the ship
 * @param shipName(String)
 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

/**
 * Gets the ships register code
 * @return registry(String)
 */
	public String getRegistry() {
		return registry;
	}

/**
 * Sets the registry code for the ship
 * @param registry(String)
 */
	public void setRegistry(String registry) {
		this.registry = registry;
	}

/**
 * Gets the class of the ship
 * @return shipClass(String)
 */
	public String getShipClass() {
		return shipClass;
	}

/**
 * Set the class of the ship
 * @param shipClass(String)
 */
	public void setShipClass(String shipClass) {
		this.shipClass = shipClass;
	}

/**
 * Gets the list of crew members
 * @return crewList(ArrayList<CrewMember>)
 */
	public ArrayList<CrewMember> getCrewList() {
		return crewList;
	}

/**
 * Sets the list of crew members
 * @param crewList(ArrayList<CrewMember>)
 */
	public void setCrewList(ArrayList<CrewMember> crewList) {
		this.crewList = crewList;
	}
	
/**
 * gets the list of ships
 * @return newList(List<CrewMember>)
 */
	public List<CrewMember> getCreList() {
		return newList;
	}

/**
 * Sets the ships in the list
 * @param newList(List<CrewMember>)
 */
	public void setCreList(List<CrewMember> newList) {
		this.newList = newList;
	}
	
/**
 * adds a CrewMember object to the list
 * @param crew (CrewMember)
 */
	public void addCrew(CrewMember crew){

		crewList.add(crew);
		crew.setAssign(registry);

	}
	
	
/**
 * Loads the crewmembers from the file to the list
 * @param crewPath
 * @return newList(List<CrewMember>)
 * @throws IOException
 */
	public List<CrewMember> loadCrew(String crewPath) throws IOException{

		LoginController us = null;
		String line = "";
		String split = ",";
		//String u;
		this.crewPath = crewPath;
		String[] c = null;
		String reg = "";
		BufferedReader br = new BufferedReader(new FileReader(crewPath));
		while ((line = br.readLine()) != null){

			 c = line.split(split);

			CrewMember cr = new CrewMember(c[0], c[1], c[2], c[3], c[4]);
			
			String test = c[0];

			if(test.toLowerCase().contains(us.Name)){
				
			 reg = c[3];
			}

		}
		  
		br.close();
		// go for a second read in case the captain was at the bottom of the file
		BufferedReader br2 = new BufferedReader(new FileReader(crewPath));
		while ((line = br2.readLine()) != null){

			 c = line.split(split);
	        
			CrewMember cr = new CrewMember(c[0], c[1], c[2], c[3], c[4]);
			String test2 = c[0];
			if(cr.getAssign().equals(reg) && !test2.contains(us.Name)){
				  newList.add(cr);

			  }
		}
		  
		br2.close();
		  return newList;


	}
	
/**
 * Sets the welcome message for the second window
 * @param captain(String)
 * @return result(String)
 */
	public String welMessage(String captain){
		String[] temp;
		String result = "";
		String delimiter = " ";

		temp = captain.split(delimiter);

		String var1 = temp[2];
		String var2 = temp[temp.length-2];
		String var3 = temp[temp.length-1];
		result = var1 + " " + var2 + "\n" + "Enterprise " + var3;
		
		return result;
	}

/**
 * Sets the crew Label
 * @param crew(CrewMember)
 * @return fullLabel
 */
	public String LabelMessage(CrewMember crew){
		String position = crew.getPosition();
		String rank = crew.getRank();
		String name = crew.getCrewName();
		String fullLabel = position + "\n" + rank + " " + name;
		
		return fullLabel;
		
	}
	
/**
 * Loads the pictures of the crew found in the list into a file list
 * @param iPath(String)
 * @param user(List<CrewMember>)
 * @return ar(List<File>)
 */
	public List<File> getPicture(String iPath, List<CrewMember> user){

	  File fi = new File(iPath);
	  List<File> ar = new ArrayList<>();
	  String list = Arrays.toString(user.toArray()).replace(", ", "");; // to get rid of the [] and commas
	  for (File f : fi.listFiles()){

		  String fname = f.getName();
		   String fileNameWithOutExt = fname.replaceFirst("[.][^.]+$", "");
		if(list.toUpperCase().contains(fileNameWithOutExt.toUpperCase())){

			ar.add(f);
			
		  }
	  }
		return ar;
	}
  
/**
 * toString to return the ships Information with the list of members
 */
	public String toString(){

		String zInfo = "";
		for(int i = 0; i < 8; i++){
			zInfo += crewList.get(i) + "\n" ;
			
		}
		System.out.println(zInfo);
		return zInfo + "\n";
	}
}
