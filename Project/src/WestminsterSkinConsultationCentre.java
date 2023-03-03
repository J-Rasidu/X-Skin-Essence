import javax.swing.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WestminsterSkinConsultationCentre {
    public static Doctor[] doctors;
    public static File doctorFile = new File("doctorDetails.txt");
    public static File consultationsFile = new File("consultationsInfo.txt");
    public static int key = 1;

    public static void main(String[] args) {
        doctors = new Doctor[10];

        doctorInitialise(doctors);

        Scanner WSCMScan = new Scanner(System.in);

        while (true) {

            System.out.print("\n");
            System.out.println("< ------ Menu ------ >");
            System.out.print("A: Add a new doctor\nD: Delete a doctor\nP: Print the list of the doctors\nS: Store program data into file\nL: Load program data from file\nG: Enter GUI view\nQ: Exit program\nEnter the option letter: ");
            String selectedOption = WSCMScan.nextLine();
            System.out.print("\n");

            WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();

            // Add a new doctor option:
            if ( selectedOption.equalsIgnoreCase("a") ) {

                System.out.println("Add a new doctor [Option Selected]:");
                if ( doctors.length == occupiedDocCount(doctors) ) {
                    System.out.println("Maximum doctor limit has been reached! (Delete a doctor first)");
                }
                else {
                    while (true) {
                        System.out.print("Medical licence number: ");
                        String medLNumber = WSCMScan.nextLine();
                        if ( !(docAlreadyPresent(doctors,medLNumber)) && inputFieldValidation(medLNumber) ) {
                            while (true) {
                                boolean exitLoop1 = false;
                                System.out.print("First name: ");
                                String firstName = WSCMScan.nextLine();
                                if ( inputFieldValidation(firstName) ) {
                                    while (true) {
                                        boolean exitLoop2 = false;
                                        System.out.print("Surname: ");
                                        String surname = WSCMScan.nextLine();
                                        if ( inputFieldValidation(surname) ) {
                                            while (true) {
                                                boolean exitLoop3 = false;
                                                System.out.print("Date of birth ( USE THIS FORMAT 2022/12/10 ): ");
                                                String dateOfBirth = WSCMScan.nextLine();
                                                if ( dateValidation(dateOfBirth) ) {
                                                    while (true) {
                                                        boolean exitLoop4 = false;
                                                        System.out.print("Mobile number: ");
                                                        String mobileNumber = WSCMScan.nextLine();
                                                        if ( mobileNoValidation(mobileNumber) ) {
                                                            while (true) {
                                                                System.out.print("Specialisation: ");
                                                                String specialisation = WSCMScan.nextLine();
                                                                if ( inputFieldValidation(specialisation) ) {

                                                                    manager.addDoctor(doctors,firstName,surname,dateOfBirth,mobileNumber,medLNumber,specialisation);

                                                                    exitLoop1 = true;
                                                                    exitLoop2 = true;
                                                                    exitLoop3 = true;
                                                                    exitLoop4 = true;
                                                                    System.out.println("Doctor has been added!");
                                                                    break;
                                                                }
                                                                else {
                                                                    System.out.println("Specialisation -> Empty string or the string contains COLON ':' marks! (Try again)");
                                                                    continue;
                                                                }
                                                            }
                                                        }
                                                        else {
                                                            System.out.println("Invalid mobile number! (Try again)");
                                                            continue;
                                                        }
                                                        if ( exitLoop4 ) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                else {
                                                    System.out.println("Invalid date! (Try again)");
                                                    continue;
                                                }
                                                if ( exitLoop3 ) {
                                                    break;
                                                }
                                            }
                                        }
                                        else {
                                            System.out.println("Surname -> Empty string or the string contains COLON ':' marks! (Try again)");
                                            continue;
                                        }
                                        if ( exitLoop2 ) {
                                            break;
                                        }
                                    }
                                }
                                else {
                                    System.out.println("First name -> Empty string or the string contains COLON ':' marks! (Try again)");
                                    continue;
                                }
                                if ( exitLoop1 ) {
                                    break;
                                }
                            }
                        }
                        else if ( docAlreadyPresent(doctors,medLNumber) ) {
                            System.out.println("Doctor is already in the Centre!");
                            break;
                        }
                        else {
                            System.out.println("Medical licence No -> Empty string or the string contains COLON ':' marks! (Try again)");
                            continue;
                        }
                        break;
                    }
                }

            }

            // Delete a doctor option:
            else if ( selectedOption.equalsIgnoreCase("d") ) {

                System.out.println("Delete a doctor [Option Selected]:");

                System.out.print("Enter medical licence number: ");
                String medLNumber = WSCMScan.nextLine();

                manager.deleteDoctor(doctors,medLNumber);
            }

            // Print the list of the doctors option:
            else if ( selectedOption.equalsIgnoreCase("p") ) {
                System.out.println("Print the list of the doctors [Option Selected]:");

                Doctor[] printDocArray = doctors.clone();
                Arrays.sort(printDocArray);

                manager.printDoctors(printDocArray);

            }

            // Store program data into file option:
            else if ( selectedOption.equalsIgnoreCase("s") ) {
                System.out.println("Store program data into file [Option Selected]:");

                manager.docFileStore(doctors);
            }

            // Load program data from file option:
            else if ( selectedOption.equalsIgnoreCase("l") ) {
                System.out.println("Load program data from file [Option Selected]:");

                manager.docFileLoad(doctors,doctorFile);
                manager.conFileLoad(doctors,consultationsFile);
            }

            // Enter GUI option:
            else if ( selectedOption.equalsIgnoreCase("g") ) {
                MenuFrame menuFrame = new MenuFrame();
                menuFrame.setTitle("X-SKIN ESSENCE");
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setSize(1100,650);
                menuFrame.setLocation(90,20);
                menuFrame.setVisible(true);
                menuFrame.setResizable(false);
                ImageIcon logoIcon = new ImageIcon("Logo.png");
                menuFrame.setIconImage(logoIcon.getImage());
                break;
            }

            // Quit option:
            else if ( selectedOption.equalsIgnoreCase("q") ) {
                System.out.println("Quit option selected!");
                break;
            }

            else {
                System.out.println("Invalid Input! (Try Again)");
            }

        }

    }

    // doctorInitialise method:
    public static void doctorInitialise( Doctor[] doctors ) {
        for ( int x = 0; x < doctors.length; x = x + 1 ) {
            doctors[x] = new Doctor();
        }
    }

    // dateValidation method:
    public static boolean dateValidation(String date) {
        boolean dateMatchFound = false;
        String[] datePatterns = {"[0-9]{4}/0[1-9]/0[1-9]","[0-9]{4}/0[1-9]/1[0-9]","[0-9]{4}/0[1-9]/2[0-9]","[0-9]{4}/0[1-9]/3[0-1]","[0-9]{4}/1[0-2]/0[1-9]","[0-9]{4}/1[0-2]/1[0-9]","[0-9]{4}/1[0-2]/2[0-9]","[0-9]{4}/1[0-2]/3[0-1]"};
        for ( int x = 0; x < datePatterns.length; x = x + 1 ) {
            Pattern datePattern = Pattern.compile(datePatterns[x]);
            Matcher dateMatcher = datePattern.matcher(date);
            dateMatchFound = dateMatcher.find();
            if(dateMatchFound) {
                break;
            }
        }
        return dateMatchFound;
    }

    // mobileNoValidation method:
    public static boolean mobileNoValidation(String mobileNo) {
        if ( !(mobileNo.equalsIgnoreCase("")) && (mobileNo.length() == 10) ) {
            try {
                Integer.parseInt(mobileNo);
                return true;
            }
            catch (NumberFormatException error) {
                return false;
            }
        }
        else {
            return false;
        }
    }

    // inputFieldValidation method:
    public static boolean inputFieldValidation(String input) {
        if ( !(input.equalsIgnoreCase("")) && !(input.contains(":")) ) {
            return true;
        }
        else {
            return false;
        }
    }

    // docAlreadyPresent method:
    public static boolean docAlreadyPresent(Doctor[] doctors,String input) {
        boolean present = false;
        for ( int x = 0; x < doctors.length; x = x + 1 ) {
            if ( doctors[x].getmLNumber().equalsIgnoreCase(input) ) {
                present = true;
                break;
            }
        }
        return present;
    }

    // occupiedDocCount method:
    public static int occupiedDocCount(Doctor[] doctors) {
        int docCount = 0;
        for ( int x = 0; x < doctors.length; x = x + 1 ) {
            if ( !(doctors[x].getFirstName().equalsIgnoreCase("~")) ) {
                docCount = docCount + 1;
            }
        }
        return docCount;
    }
}
