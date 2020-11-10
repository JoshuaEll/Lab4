package application.model;
/**
 * File to control user information
 * @author jbq715
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String password;
	private List<String> userList;
/**
 * Constructor
 * @param name(String)
 * @param password(String)
 */
	public User(String name, String password){
		 this.name = name;
		 this.password = password;
		 userList = new ArrayList<>();
	}

/**
 * get the username
 * @return name(String)
 */
	public String getName(){
		return name;
	}
	
/**
 * set the name
 * @param name(String)
 */
	public void setName(String name){
		this.name = name;
	}
	
/**
 * gets password
 * @return password(String)
 */
	public String getPass(){
		return password;
	}
	
/**
 * set password
 * @param password(String)
 */
	public void setPass(String password){
		this.password = password;
	}
	
/**
 * gets user list
 * @return userList(List<String>)
 */
	public List<String> getUser(){
		return userList;
	}
	
/**
 * set user list
 * @param userList(List<String>)
 */
	public void setUser(List<String> userList){
		this.userList = userList;
	}
	
/**
 * validates username and password
 * @param UName(String)
 * @param PW(String)
 * @return check(boolean)
 * @throws IOException
 */
	public boolean validate(String UName, String PW) throws IOException {
		boolean check = false;
		String line = "";
		String split = ",";
		
		BufferedReader br = new BufferedReader(new FileReader("data/users.csv"));

		while ((line = br.readLine()) != null){
			String[] c = line.split(split);
			if(c[0].equals(UName) && c[1].equals(PW)){
				check = true;
				userList.add(c[0]);

			}

		}
		br.close();
		return check;
	}

}
