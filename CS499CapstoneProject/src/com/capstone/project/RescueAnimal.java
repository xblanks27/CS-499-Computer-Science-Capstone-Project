package com.capstone.project;

public class RescueAnimal {
	
	// Instance variables
    private String name;
    private String animalType;
    private String gender;
    private String age;
    private String weight;
    private String acquisitionDate;
    private String acquisitionCountry;
	private String trainingStatus;
    private boolean reserved;
	private String inServiceCountry;


    // Constructor
    public RescueAnimal() {
    }

    // output animal name
	public String getName() {
		return name;
	}

	// set animal name
	public void setName(String name) {
		this.name = name;
	}

	// output animal type
	public String getAnimalType() {
		return animalType;
	}

	// set animal type
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	// output animal gender
	public String getGender() {
		return gender;
	}

	// set animal gender
	public void setGender(String gender) {
		this.gender = gender;
	}

	// output animal age
	public String getAge() {
		return age;
	}

	// set animal age
	public void setAge(String age) {
		this.age = age;
	}

	// output animal weight
	public String getWeight() {
		return weight;
	}

	// set animal weight
	public void setWeight(String weight) {
		this.weight = weight;
	}

	// output acquisition date
	public String getAcquisitionDate() {
		return acquisitionDate;
	}

	// set acquisition date
	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	// output acquisition location
	public String getAcquisitionLocation() {
		return acquisitionCountry;
	}

	// set acquisition location
	public void setAcquisitionLocation(String acquisitionCountry) {
		this.acquisitionCountry = acquisitionCountry;
	}

	// output reserve status
	public boolean getReserved() {
		return reserved;
	}

	// set reserve status
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	// output service country
	public String getInServiceCountry() {
		return inServiceCountry;
	}

	// set service country
	public void setInServiceCountry(String inServiceCountry) {
		this.inServiceCountry = inServiceCountry;
	}

	// output training status
	public String getTrainingStatus() {
		return trainingStatus;
	}

	// set training status
	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

}
