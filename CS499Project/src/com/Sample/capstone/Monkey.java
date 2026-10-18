package com.Sample.capstone;


public class Monkey extends RescueAnimal{

	private String species;
	private String tailLength;
	private String height;
	private String bodyLength;
	//constructor for monkey class
	public Monkey(String name, String gender, String age, String weight, String aquisitionDate, String aquisitionCountry,
			String trainingStatus, Boolean reserved, String inServiceCountry, String species, String tailLength, String height, String bodyLength) {
		
		setName(name);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(aquisitionDate);
		setAcquisitionLocation(aquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
		setSpecies(species);
		setTailLength(tailLength);
		setHeight(height);
		setBodyLength(bodyLength);
		setAnimalType("monkey");
		
	}
	// returns monkey species
	public static String getSpecies(String species) {
		return species;
	}
	// sets monkey species
	public void setSpecies(String species) {
		this.species = species;
	}
	// returns length of the tail
	public static String getTailLength(String tailLength) {
		return tailLength;
	}
	// sets the length of the tail
	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}
	// returns the height of the monkey
	public static String getHeight(String height) {
		return height;
	}
	// sets the height of the monkey
	public void setHeight(String height) {
		this.height = height;
	}
	// returns the body length of the monkey
	public String getBodyLength(String bodyLength) {
		return bodyLength;
	}
	// sets body length of the monkey
	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}
}
