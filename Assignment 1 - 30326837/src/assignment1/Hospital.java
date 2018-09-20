package assignment1;

import java.util.*;

public class Hospital
{
	private ArrayList<Doctor> listOfDoctors;
	private ArrayList<Patient> listOfPatients;

	public Hospital(){
		listOfDoctors = new ArrayList<Doctor>();
		listOfDoctors.clear();
		listOfPatients = new ArrayList<Patient>();
		listOfPatients.clear();
	}

	public final String run(){
		String output = "";

		addListofDoctors();
		setListOfPatients();

		output = returnListOfregisteredDoctors(output);		
		output = returnListofPatitentsBefore(output);
		output = returnAssignDoctorsToPatient(output);
		output = listPatientAfterAssigning(output);
		output = listDocPatients(output);
		
		return output;
	}

	private String listDocPatients(String output) {
		output += "___________________\n\nList of doctors after patients assigned\n___________________\n" + "\n";
		for (int i = 0; i < this.listOfDoctors.size(); i++){
			Doctor temp = ((Doctor)this.listOfDoctors.get(i));
			output += temp.toString() + "\n";
			if (temp.HasPatients()){
				output += temp.printListOfPatients();
			}
			else{
				output += "No patients assigned to this doctor as yet";
			}
			output += "\n";
		}
		return output;
	}

	private String listPatientAfterAssigning(String output) {
		output += "\n___________________\n\nList of patients after doctors assigned\n___________________\n";
		for (int i = 0; i < this.listOfPatients.size(); i++){
			output += ((Patient)this.listOfPatients.get(i)).toString() + "\n";
		}
		return output;
	}

	private String returnAssignDoctorsToPatient(String output) {
		output += "\n___________________\n\n Assigning Doctors to Patients\n___________________\n";
		ArrayList<Patient> list = this.listOfPatients;
		for (int i = 0; i < list.size(); i++){
			Patient temp = (Patient)list.get(i);
			if (temp.assignDoctor(this.listOfDoctors) == false){
				output += "\n*******************\n Cannot assign patient to " + temp.getName() + "- No available doctors\n*******************\n";
				output += ((Patient)list.get(i)).mv();
			}
			else{
				output += "Assigning a doctor to " + temp.getName() + "\n";
			}
		}
		return output;
	}

	private String returnListofPatitentsBefore(String output) {
		output += "\n___________________\n\nList of patients before doctors assigned\n___________________\n\n";
		for (int i = 0; i < this.listOfPatients.size(); i++){
			output += ((Patient)this.listOfPatients.get(i)).toString() + "\n";
		}
		return output;
	}

	private String returnListOfregisteredDoctors(String output) {
		output += "___________________\n\nList of registered doctors\n___________________\n\n";
		for (int i = 0; i < this.listOfDoctors.size(); i++){
			Doctor temp = ((Doctor)this.listOfDoctors.get(i));
			output += temp.toString() + "\n";
			if (temp.HasPatients()){
				output += temp.printListOfPatients();
			}
			else{
				output += "No patients assigned to this doctor as yet";
			}
			output += "\n";
		}

		output += "\n";
		return output;
	}

	private void setListOfPatients() {
		this.listOfPatients.clear();

		this.listOfPatients.add(new Patient("Fred Bear", 29, "Private", "Ben Casey", "HCF236788", 10));
		this.listOfPatients.add(new Patient("Betty Davis", 37, "Medicare2562", "Public", 7));
		this.listOfPatients.add(new Patient("Bella Plant", 25, "Private", "Ben Casey", "HCF265123", 23));
		this.listOfPatients.add(new Patient("Thomas Edison", 12, "Private", "Doogie Howser", "HCF265988", 2));
		this.listOfPatients.add(new Patient("Chris Smith", 56, "Medicare5678", "Public", 1));
		this.listOfPatients.add(new Patient("Chris Jones", 56, "Medicare5679", "Public", 1));
		this.listOfPatients.add(new Patient("Chris Simpson", 56, "Medicare5690", "Public", 1));
		this.listOfPatients.add(new Patient("Chris Christoph", 56, "Medicare5878", "Public", 1));
	}

	private void addListofDoctors() {
		this.listOfDoctors.add(new Doctor("Ben Casey", 32, 3, "Ear, Nose, Throat"));
		this.listOfDoctors.add(new Doctor("Hawkeye Pierce", 47, 4, "Heart"));
		this.listOfDoctors.add(new Doctor("Doogie Howser", 22, 2, "Paediatrician", 150));
	}
}
