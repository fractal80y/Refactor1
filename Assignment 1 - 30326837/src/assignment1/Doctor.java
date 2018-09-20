package assignment1;

import java.util.*;

public class Doctor
{
	private String specialisation; // Doctor's special skill
	private ArrayList<Patient> listOfPatients; // Doctor's personal list of patients
	private int maxNumOfPatients; // Maximum no. of patients a Dr can have at one time
	private double hourlyRate; // Hourly rate of pay
	private static int doctorID = 1000; // Internal use only - no get/set methods
	private String name;
	private int age;
	private String identifier;

	public final boolean HasPatients(){
		return !listOfPatients.isEmpty();
	}
	
	public String getName() {
		return this.name;
	}



	public Doctor(String name, int age, int patients2, String specialisation){
		this.name = name;
		this.age = age;

		listOfPatients = new ArrayList<Patient>();
		listOfPatients.clear();
		maxNumOfPatients = patients2;
		this.specialisation = specialisation;
		hourlyRate = 100;
		this.setIdentifier();
	}

	public Doctor(String name, int age, int patients2, String specialisation, double hourlyRate){
		this.name = name;
		this.age = age;

		listOfPatients = new ArrayList<Patient>();
		listOfPatients.clear();
		maxNumOfPatients = patients2;
		this.specialisation = specialisation;
		this.setIdentifier();
		this.hourlyRate = hourlyRate;
	}

	public String toString(){
		return "*******************\n Dr " + this.name + "\n\t id number: " + identifier + "\n\t Max Number of Patients: " + this.maxNumOfPatients;
	}

	public final double getHourlyRate(){
		return this.hourlyRate;
	}

	public final boolean assignPatientToDoctorsList(Patient pt){
		if (listOfPatients.size() < this.maxNumOfPatients){
			listOfPatients.add(listOfPatients.size(),pt);
			return true;
		}
		return false;
	}

	public final String printListOfPatients(){
		String temp = "";
		temp += "\nList of Patients for Dr " + this.name + "\n\n";
		for (int i = 0; i < this.listOfPatients.size(); i++){
			temp += ((Patient) this.listOfPatients.get(i)) + "\n";
		}
		return temp;
	}

	public final void setIdentifier(){
		this.identifier = "D" + doctorID++;
	}
}