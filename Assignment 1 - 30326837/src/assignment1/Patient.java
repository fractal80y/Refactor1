package assignment1;

import java.util.*;

public class Patient
{
	private Doctor assignedDoctor; // Doctor assigned to Patient
	private static int patientIDnumber = 100000; // No get and set methods - internal use only
	private String name;
	private int age;
	private String identifier;
	private String patientType; // can be "Private" or "Public" - public "default"
	private String preferredDoctor; // Only useful for "Private" - null for public
	private String privateHealthFundNo; // Fund number for patients with private health
	private String medicareNo;
	private int hoursTreated; // No of hours patient treated by Doctor

	public String getName(){
		return name;
	}
	
	private Patient() {
		
	}
	
	public Patient(String name, int age, String medicareNo, String patientType, int hoursTreated){
		this.name = name;
		this.age = age;
		assignedDoctor = null;
		this.SetIdentifier();
		this.patientType = patientType;
		this.preferredDoctor = null;
		this.privateHealthFundNo = null;
		this.medicareNo = medicareNo;
		this.hoursTreated = hoursTreated;
	}

	public Patient(String name, int age, String patientType, String preferredDoctor, String privateHealthFundNo, int hoursTreated){
		this.name = name;
		this.age = age;
		assignedDoctor = null;
		this.SetIdentifier();
		this.patientType = patientType;
		this.preferredDoctor = preferredDoctor;
		this.privateHealthFundNo = privateHealthFundNo;
		this.hoursTreated = hoursTreated;
	}

	public final boolean assignDoctor(ArrayList<Doctor> listOfDoctors){
		if (patientType.equals("Private")){
			for (int i = 0; i < listOfDoctors.size(); i++){
				Doctor temp = (Doctor)listOfDoctors.get(i);
				if (this.preferredDoctor.equals(temp.getName())){
					assignedDoctor = temp;
					return (temp.assignPatientToDoctorsList(this));
				}
			}
		}
		else if (patientType.equals("Public")){

			int docs = listOfDoctors.size();

			for (int i = 0; i < docs; i++){
				if (i >= docs){
					i = i - docs;
				}
				Doctor temp = (Doctor)(listOfDoctors.get(i));

				if (temp.assignPatientToDoctorsList(this)){
					assignedDoctor = temp;
					return true;
				}
			}
		}
		return false;
	}

	public final String mv(){
		String output = "";
		if (patientType.equals("Public")){
			output += "Assigning public patient " + this.name +
								  " to the waiting list until a doctor becomes available";
		}
		else if (patientType.equals("Private")){
			output += "Reassigning Private Patient " + this.name + " to a different hospital";
		}
		return output;
	}

	public final void SetIdentifier(){
		this.identifier = "P" + patientIDnumber++;
	}

	
	public String toString(){
		if (patientType.equals("Public")){
			String temp = "Public Patient - " + this.name + "\n\t Identifier: " + this.identifier + "\n\t Medicare Number: " + this.medicareNo + "\n\t Assigned Doctor: ";

			String temp2;
			if (this.assignedDoctor == null){
				temp2 = "not assigned as yet";
			}
			else{
				temp2 = this.assignedDoctor.getName() + "\n\t Fee for consultation = $" + this.hoursTreated * this.assignedDoctor.getHourlyRate();
			}
			return temp + temp2 + "\n";
		}
		else { //if (patientType == "Private")
			String temp = "Private Patient - " + this.name + "\n\t Identifier: " + this.identifier + "\n\t Preferred Doctor " + this.preferredDoctor + "\n\t Private Health Fund Number: " + this.privateHealthFundNo +
						  "\n\t Assigned Doctor: ";
			String temp2;
			if (this.assignedDoctor == null){
				temp2 = "not assigned as yet";
			}
			else{
				temp2 = this.assignedDoctor.getName() + "\n\t Fee for consultation = $" + this.hoursTreated * this.assignedDoctor.getHourlyRate();
			}
			return temp + temp2 + "\n";
		}
	}
}