import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    // addDoctor method:
    public void addDoctor( Doctor[] doctors,String firstName,String surname,String dateOfBirth,String mobileNumber,String medLNumber,String specialisation ) {
        for ( int x = 0; x < doctors.length; x = x + 1 ) {
            if ( doctors[x].getFirstName().equalsIgnoreCase("~") ) {
                doctors[x] = new Doctor(firstName,surname,dateOfBirth,mobileNumber,medLNumber,specialisation);
                break;
            }
        }
    }

    // deleteDoctor method:
    public void deleteDoctor( Doctor[] doctors,String medLNumber ) {
        String delDoctorInfo = "\nDoctor deleted! (Details are below)\n";
        int emptyIndexDocArray = 0;
        boolean invalidMLNo = true;
        for ( int x = 0; x < doctors.length; x = x + 1 ) {
            if ( doctors[x].getmLNumber().equalsIgnoreCase(medLNumber) ) {
                invalidMLNo = false;
                delDoctorInfo = delDoctorInfo + "Name: "+doctors[x].getFirstName()+" "+doctors[x].getSurname()+"\nDate of birth: "+doctors[x].getDOB()+"\nMobile number: "+doctors[x].getMobileNumber()+"\nMedical license number: "+doctors[x].getmLNumber()+"\nSpecialisatation: "+doctors[x].getSpecialisation();
                doctors[x] = new Doctor();
                doctors[x].consultations.clear();
                doctors[x].consultDateTimeRanges.clear();
                break;
            }
            else if ( doctors[x].getmLNumber().equalsIgnoreCase("~") ) {
                emptyIndexDocArray = emptyIndexDocArray + 1;
            }
        }

        if ( emptyIndexDocArray == doctors.length ) {
            System.out.println("No doctors to delete from centre!");
        }
        else if ( invalidMLNo ) {
            System.out.println("Invalid medical licence number (Try again)!");
        }
        else {
            System.out.println(delDoctorInfo);

            int availableDoctorCount = 0;
            for ( int y = 0; y < doctors.length; y = y + 1 ) {
                if ( doctors[y].getFirstName().equalsIgnoreCase("~") ) {
                    continue;
                }
                else {
                    availableDoctorCount = availableDoctorCount + 1;
                }
            }

            System.out.println("\nRemaining number of doctors: "+availableDoctorCount);
        }
    }

    // printDoctors method:
    public void printDoctors( Doctor[] printDocArray ) {
        int emptyDocSlots = 0;
        for ( int x = 0; x < printDocArray.length; x = x + 1 ) {
            if ( printDocArray[x].getFirstName().equalsIgnoreCase("~") ) {
                emptyDocSlots = emptyDocSlots + 1;
                continue;
            }
            else {
                System.out.println( "Name: "+printDocArray[x].getFirstName()+" "+printDocArray[x].getSurname()+"\nDate of birth: "+printDocArray[x].getDOB()+"\nMobile number: "+printDocArray[x].getMobileNumber()+"\nMedical license number: "+printDocArray[x].getmLNumber()+"\nSpecialisation: "+printDocArray[x].getSpecialisation() );
                System.out.println();
            }
        }
        if ( printDocArray.length == emptyDocSlots ) {
            System.out.println("No doctors at the Centre!");
        }
    }

    // fileStore method:
    public void docFileStore( Doctor[] doctors ) {
        try {
            FileWriter doctorWriter = new FileWriter("doctorDetails.txt");
            doctorWriter.write("<------Skin-Consultation-Centre-Doctor-Details------>\n");
            doctorWriter.write("\n");

            for ( int x = 0; x < doctors.length; x = x + 1 ) {
                doctorWriter.write( doctors[x].getFirstName()+" "+doctors[x].getSurname()+" : "+doctors[x].getDOB()+" : "+doctors[x].getMobileNumber()+" : "+doctors[x].getmLNumber()+" : "+doctors[x].getSpecialisation()+"\n" );
                doctorWriter.write("\n");
            }
            doctorWriter.close();
        }
        catch (IOException ex) {
            System.out.println("Doctors File Store Error! - "+ex);
        }
    }

    // fileLoad method:
    public void docFileLoad( Doctor[] doctors , File doctorFile ) {
        try {
            Scanner docLoadScan = new Scanner(doctorFile);
            String fileLine;
            while ( docLoadScan.hasNext() ) {
                fileLine = docLoadScan.nextLine();
                System.out.println(fileLine);

                if ( fileLine.contains(" ") ) {
                    for ( int x = 0; x < doctors.length; x = x + 1 ) {
                        String linePartsA[] = fileLine.split(" : ");

                        if ( fileLine.contains("~") ) {
                            doctors[x] = new Doctor();
                        }

                        else if ( fileLine.contains("/") ) {
                            String linePartsB[] = linePartsA[0].split(" ");

                            doctors[x].setFirstName( linePartsB[0] );
                            doctors[x].setSurname( linePartsB[1] );
                            doctors[x].setDOB( linePartsA[1] );
                            doctors[x].setMobileNumber( linePartsA[2] );
                            doctors[x].setmLNumber( linePartsA[3] );
                            doctors[x].setSpecialisation( linePartsA[4] );
                        }

                        else {
                            x = x - 1;
                        }

                        fileLine = docLoadScan.nextLine();
                        System.out.println(fileLine);
                    }
                }
            }
            docLoadScan.close();
        }
        catch (IOException ex) {
            System.out.println("Doctors File Load Error! - "+ex);
        }
    }

    public void conFileLoad( Doctor[] doctors , File consultationsFile ) {

        for ( int y = 0; y < doctors.length; y = y + 1 ) {
            doctors[y].consultDateTimeRanges.clear();
            doctors[y].consultations.clear();
        }

        try {
            Scanner conLoadScan = new Scanner(consultationsFile);
            String fileLine;
            while ( conLoadScan.hasNext() ) {

                fileLine = conLoadScan.nextLine();

                if ( fileLine.contains(" ") ) {

                    int x = 0;
                    while ( x < doctors.length && conLoadScan.hasNext() ) {

                        String lineParts[] = fileLine.split(" - ",8);
                        String doctorNameSplit[] = lineParts[0].split(" ");
                        String patientNameSplit[] = lineParts[2].split(" ");

                        if ( doctors[x].getFirstName().equalsIgnoreCase( doctorNameSplit[1] ) && doctors[x].getSurname().equalsIgnoreCase( doctorNameSplit[2] ) ) {
                            doctors[x].consultDateTimeRanges.add( lineParts[5] );

                            char[] decryptNoteChars = lineParts[7].toCharArray();
                            String decryptNote = "";
                            for ( char y : decryptNoteChars ) {
                                y -= WestminsterSkinConsultationCentre.key;
                                decryptNote = decryptNote + y;
                            }

                            Consultation consultation = new Consultation( patientNameSplit[0],patientNameSplit[1],lineParts[3],lineParts[4],lineParts[1],lineParts[5],Double.parseDouble(lineParts[6]),decryptNote );
                            doctors[x].consultations.add( consultation );

                            fileLine = conLoadScan.nextLine();
                            x = 0;
                        }
                        else {
                            x = x + 1;
                        }

                    }
                }
            }
            conLoadScan.close();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog( null,"Consultations File Load Error!","MESSAGE",JOptionPane.ERROR_MESSAGE );
        }
    }

}
