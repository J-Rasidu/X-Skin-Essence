import java.io.File;

public interface SkinConsultationManager {
    void addDoctor( Doctor[] doctors,String firstName,String surname,String dateOfBirth,String mobileNumber,String medLNumber,String specialisation );
    void deleteDoctor( Doctor[] doctors,String medLNumber );
    void printDoctors( Doctor[] printDocArray );
    void docFileStore( Doctor[] doctors );
    void docFileLoad( Doctor[] doctors , File doctorFile );
    void conFileLoad( Doctor[] doctors , File consultationsFile );
}
