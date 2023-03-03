import java.util.ArrayList;

public class Doctor extends Person implements Comparable<Doctor>{

    public ArrayList<Consultation> consultations = new ArrayList<Consultation>();

    private String mLNumber;
    private String specialisation;

    public Doctor() {
        super();
        this.mLNumber = "~";
        this.specialisation = "~";
    }

    public Doctor(String fName,String sName, String DOB, String mNumber, String mLNumber, String specialisation) {
        super(fName, sName, DOB, mNumber);
        this.mLNumber = mLNumber;
        this.specialisation = specialisation;
    }

    public String getmLNumber() {return mLNumber;}
    public void setmLNumber(String mLNumber) {this.mLNumber = mLNumber;}

    public String getSpecialisation() {return specialisation;}
    public void setSpecialisation(String specialisation) {this.specialisation = specialisation;}

    public int compareTo(Doctor doc) {
        return this.getSurname().compareTo( doc.getSurname() );
    }

    public ArrayList<String> consultDateTimeRanges = new ArrayList<String>();

}
