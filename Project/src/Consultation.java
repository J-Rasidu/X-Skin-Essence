import javax.swing.*;

public class Consultation {
    private String dateAndTime = "";
    private double cost = 0.0;
    private String note = "";
    Patient patient;
    JButton btnConsultation;

    public Consultation(String fName,String sName, String DOB, String mNumber, String patientId, String dateTimeRange, double cost, String note) {

        patient = new Patient(fName, sName, DOB, mNumber, patientId);

        this.dateAndTime = dateTimeRange;
        this.cost = cost;

        char[] noteChars = note.toCharArray();

        String encryptedNote = "";
        for ( char x : noteChars ) {
            x += WestminsterSkinConsultationCentre.key;
            encryptedNote = encryptedNote + x;
        }

        this.note = encryptedNote;

    }

    public String getDateAndTime() {return dateAndTime;}
    public void setDateAndTime(String dateAndTime) {this.dateAndTime = dateAndTime;}

    public double getCost() {return cost;}
    public void setCost(double cost) {this.cost = cost;}

    public String getNote() {return note;}
    public void setNote(String note) {this.note = note;}
}
