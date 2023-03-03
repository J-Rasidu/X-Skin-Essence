public class Person {
    private String firstName;
    private String surname;
    private String DOB;
    private String mobileNumber;

    public Person() {
        this.firstName = "~";
        this.surname = "~";
        this.DOB = "~";
        this.mobileNumber = "~";
    }

    public Person(String fName,String sName, String DOB, String mNumber) {
        this.firstName = fName;
        this.surname = sName;
        this.DOB = DOB;
        this.mobileNumber = mNumber;
    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}

    public String getDOB() {return DOB;}
    public void setDOB(String DOB) {this.DOB = DOB;}

    public String getMobileNumber() {return mobileNumber;}
    public void setMobileNumber(String mobileNumber) {this.mobileNumber = mobileNumber;}

}
