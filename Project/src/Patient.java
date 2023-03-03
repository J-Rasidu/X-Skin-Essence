public class Patient extends Person{
    private String patientId;

    public Patient(String fName,String sName, String DOB, String mNumber, String patientId) {
        super(fName, sName, DOB, mNumber);
        this.patientId = patientId;
    }

    public String getPatientId() {return patientId;}
    public void setPatientId(String patientId) {this.patientId = patientId;}

}
