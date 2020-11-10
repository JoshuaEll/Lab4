package application.model;
/**
 * This class contains the information needed to create a crew member
 * @author Joshua Ellis
 * @author jbq715
 */
public class CrewMember {

	private String crewName;
	private String position;
	private String rank;
	private String assigned;
	private String species;
	/**
	 * Constructor of the class
	 * @param crewName
	 * @param position
	 * @param rank
	 * @param assigned
	 * @param species
	 */
	CrewMember(String crewName, String position, String rank, String assigned, String species){
		this.crewName = crewName;
		this.position = position;
		this.rank = rank;
		this.assigned = assigned;
		this.species = species;
	}
	
/**
 * gets the name of the member
 * @return crewName(String)
 */
	public String getCrewName() {
		return crewName;
	}
	
/**
 * Sets the name of the member 
 * @param crewName(String)
 */
	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

/**
 * gets the members position
 * @return position(String)
 */
	public String getPosition() {
		return position;
	}

/**
 * Sets the members position
 * @param position(String)
 */
	public void setPosition(String position) {
		this.position = position;
	}

/**
 * Gets the members rank
 * @return rank(String)
 */
	public String getRank() {
		return rank;
	}

/**
 * Sets the members rank
 * @param rank(String)
 */
	public void setRank(String rank) {
		this.rank = rank;
	}

/**
 * Gets the member's ship assignment
 * @return assigned(String)
 */
	public String getAssign() {
		return assigned;
	}

/**
 * Sets the member's ship assignment
 * @param assigned(String)
 */
	public void setAssign(String assigned) {
		this.assigned = assigned;
	}
	
/**
 * get the member's species
 * @return species(String)
 */
	public String getSpecies() {
		return species;
	}

/**
 * Sets the member's species
 * @param species(String)
 */
	public void setSpecies(String species) {
		this.species = species;
	}
	
/**
 * toString that returns the info required to create a crew member
 */
	public String toString(){
		return "" + position + " " + rank + " " + crewName + " " + assigned ;
	}
}
