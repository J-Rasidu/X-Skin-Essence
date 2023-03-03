import org.junit.Test;

import static org.junit.Assert.*;

public class WestminsterSkinConsultationCentreTest {


    // Test-1: (Doctor date of birth validation:)
    @Test
    public void dateValidationTest1() {
        String inputDate = "2022/12/12";
        boolean result = WestminsterSkinConsultationCentre.dateValidation(inputDate);
        assertEquals(inputDate+" matches the expected date pattern",true,result);
    }

    // Test-2: (Doctor date of birth validation:)
    @Test
    public void dateValidationTest2() {
        String inputDate = "2022/13/12";
        boolean result = WestminsterSkinConsultationCentre.dateValidation(inputDate);
        assertEquals(inputDate+" matches the expected date pattern",false,result);
    }

    // Test-3: (Doctor date of birth validation:)
    @Test
    public void dateValidationTest3() {
        String inputDate = "2022/02/32";
        boolean result = WestminsterSkinConsultationCentre.dateValidation(inputDate);
        assertEquals(inputDate+" matches the expected date pattern",false,result);
    }

    // Test-4: (Doctor date of birth validation:)
    @Test
    public void dateValidationTest4() {
        String inputDate = "1999/03/31";
        boolean result = WestminsterSkinConsultationCentre.dateValidation(inputDate);
        assertEquals(inputDate+" matches the expected date pattern",true,result);
    }

    // Test-5: (Doctor date of birth validation:)
    @Test
    public void dateValidationTest5() {
        String inputDate = "2022/00/31";
        boolean result = WestminsterSkinConsultationCentre.dateValidation(inputDate);
        assertEquals(inputDate+" matches the expected date pattern",false,result);
    }

    // Test-6 (Doctor mobile Number Validation:)
    @Test
    public void mobileNoValidationTest1() {
        String inputNumber = "0771765687";
        boolean result = WestminsterSkinConsultationCentre.mobileNoValidation(inputNumber);
        assertEquals(inputNumber+" is a valid number",true,result);
    }

    // Test-7 (Doctor mobile Number Validation:)
    @Test
    public void mobileNoValidationTest2() {
        String inputNumber = "07717657";
        boolean result = WestminsterSkinConsultationCentre.mobileNoValidation(inputNumber);
        assertEquals(inputNumber+" is a valid number",false,result);
    }

    // Test-8 (Doctor mobile Number Validation:)
    @Test
    public void mobileNoValidationTest3() {
        String inputNumber = "077AB6568-";
        boolean result = WestminsterSkinConsultationCentre.mobileNoValidation(inputNumber);
        assertEquals(inputNumber+" is a valid number",false,result);
    }

    // Test-9 (Doctor mobile Number Validation:)
    @Test
    public void mobileNoValidationTest4() {
        String inputNumber = "APPLE SHOP";
        boolean result = WestminsterSkinConsultationCentre.mobileNoValidation(inputNumber);
        assertEquals(inputNumber+" is a valid number",false,result);
    }

    // Test-10 (Doctor input Field Validation:)
    @Test
    public void inputFieldValidationTest1() {
        String userInput = "Rahul";
        boolean result = WestminsterSkinConsultationCentre.inputFieldValidation(userInput);
        assertEquals(userInput+" is not empty and it does not contain colon ':' marks!",true,result);
    }

    // Test-11 (Doctor input Field Validation:)
    @Test
    public void inputFieldValidationTest2() {
        String userInput = "";
        boolean result = WestminsterSkinConsultationCentre.inputFieldValidation(userInput);
        assertEquals(userInput+" is not empty and it does not contain colon ':' marks!",false,result);
    }

    // Test-12 (Doctor input Field Validation:)
    @Test
    public void inputFieldValidationTest3() {
        String userInput = "Rahul:";
        boolean result = WestminsterSkinConsultationCentre.inputFieldValidation(userInput);
        assertEquals(userInput+" is not empty and it does not contain colon ':' marks!",false,result);
    }


    // Doctor already present Test:
    Doctor[] testDocArray1 = new Doctor[2];
    Doctor tDA1doctor1 = new Doctor("John","Smith","1999/10/10","0778987845","M01","Skin Infection Type-1");
    Doctor tDA1doctor2 = new Doctor("Mary","Jane","1980/08/20","0716677889","M02","Skin Infection Type-2");

    // Test-13 (Check whether the doctor is already in the consultation Centre)
    @Test
    public void docAlreadyPresentTest1() {
        testDocArray1[0] = tDA1doctor1;
        testDocArray1[1] = tDA1doctor2;
        String mLNumber = "M02";
        boolean result = WestminsterSkinConsultationCentre.docAlreadyPresent(testDocArray1,mLNumber);
        assertEquals("Doctor is already in the Centre",true,result);
    }

    // Test-14 (Check whether the doctor is already in the consultation Centre)
    @Test
    public void docAlreadyPresentTest2() {
        testDocArray1[0] = tDA1doctor1;
        testDocArray1[1] = tDA1doctor2;
        String mLNumber = "M03";
        boolean result = WestminsterSkinConsultationCentre.docAlreadyPresent(testDocArray1,mLNumber);
        assertEquals("Doctor is already in the Centre",false,result);
    }

    // Available doctor count Test:
    Doctor[] testDocArray2 = new Doctor[5];
    Doctor tDA2doctor1 = new Doctor("John","Smith","1999/10/10","0778987845","M01","Skin Infection Type-1");
    Doctor tDA2doctor2 = new Doctor("Mary","Jane","1980/08/20","0716677889","M02","Skin Infection Type-2");
    Doctor tDA2doctor3 = new Doctor("Kane","Will","1989/09/30","0709944556","M04","Skin Infection Type-3");


    // Test-15 (Get available doctor count)
    @Test
    public void occupiedDocCountTest1() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray2);
        testDocArray2[0] = tDA2doctor1;
        testDocArray2[1] = tDA2doctor2;
        int result = WestminsterSkinConsultationCentre.occupiedDocCount(testDocArray2);
        assertEquals("Available doctor count = 2",2,result);
    }

    // Test-16 (Get available doctor count)
    @Test
    public void occupiedDocCountTest2() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray2);
        testDocArray2[0] = tDA2doctor1;
        testDocArray2[1] = tDA2doctor2;
        testDocArray2[2] = tDA2doctor3;
        int result = WestminsterSkinConsultationCentre.occupiedDocCount(testDocArray2);
        assertEquals("Available doctor count = 3",3,result);
    }

    // Test-17 (Get available doctor count)
    @Test
    public void occupiedDocCountTest3() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray2);
        int result = WestminsterSkinConsultationCentre.occupiedDocCount(testDocArray2);
        assertEquals("Available doctor count = 0",0,result);
    }

    // Add doctor test:
    Doctor[] testDocArray3 = new Doctor[5];
    Doctor tDA3doctor1 = new Doctor("John","Smith","1999/10/10","0778987845","M01","Skin Infection Type-1");
    Doctor tDA3doctor2 = new Doctor("Mary","Jane","1980/08/20","0716677889","M02","Skin Infection Type-2");
    Doctor tDA3doctor3 = new Doctor("Kane","Will","1989/09/30","0709944556","M04","Skin Infection Type-3");

    WestminsterSkinConsultationManager manager1 = new WestminsterSkinConsultationManager();

    // Test-18 (Add doctor)
    @Test
    public void addDoctorTest1() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray3);
        testDocArray3[0] = tDA3doctor1;
        testDocArray3[1] = tDA3doctor2;
        testDocArray3[2] = tDA3doctor3;
        manager1.addDoctor(testDocArray3,"Harry","True","1990/01/07","0701111556","M06","Skin Infection Type-4");

        int docCount = 0;
        for ( int x = 0; x < testDocArray3.length; x = x + 1 ) {
            if ( !(testDocArray3[x].getFirstName().equalsIgnoreCase("~")) ) {
                docCount = docCount + 1;
            }
        }

        assertEquals("After adding the new doctor: No of available doctors = 4",4,docCount);
    }

    // Test-19 (Add doctor)
    @Test
    public void addDoctorTest2() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray3);
        testDocArray3[0] = tDA3doctor1;
        testDocArray3[1] = tDA3doctor2;
        manager1.addDoctor(testDocArray3,"Harry","True","1990/01/07","0701111556","M06","Skin Infection Type-4");

        int docCount = 0;
        for ( int x = 0; x < testDocArray3.length; x = x + 1 ) {
            if ( !(testDocArray3[x].getFirstName().equalsIgnoreCase("~")) ) {
                docCount = docCount + 1;
            }
        }

        assertEquals("After adding the new doctor: No of available doctors = 3",3,docCount);
    }

    // Test-20 (Add doctor)
    @Test
    public void addDoctorTest3() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray3);
        testDocArray3[0] = tDA3doctor1;
        testDocArray3[1] = tDA3doctor2;
        testDocArray3[2] = tDA3doctor3;
        manager1.addDoctor(testDocArray3,"Harry","True","1990/01/07","0701111556","M06","Skin Infection Type-4");
        manager1.addDoctor(testDocArray3,"Marv","Smith","1989/06/14","0701111122","M07","Skin Infection Type-5");

        int docCount = 0;
        for ( int x = 0; x < testDocArray3.length; x = x + 1 ) {
            if ( !(testDocArray3[x].getFirstName().equalsIgnoreCase("~")) ) {
                docCount = docCount + 1;
            }
        }

        assertEquals("After adding the new doctor: No of available doctors = 5",5,docCount);
    }

    // Test-21 (Add doctor)
    @Test
    public void addDoctorTest4() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray3);
        testDocArray3[0] = tDA3doctor1;
        testDocArray3[1] = tDA3doctor2;
        testDocArray3[2] = tDA3doctor3;
        manager1.addDoctor(testDocArray3,"Harry","True","1990/01/07","0701111556","M06","Skin Infection Type-4");
        manager1.addDoctor(testDocArray3,"Marv","Smith","1989/06/14","0701111122","M07","Skin Infection Type-5");
        manager1.addDoctor(testDocArray3,"Henry","Allen","1979/08/24","0701231142","M08","Skin Infection Type-6"); // This doctor will not be added to the array

        int docCount = 0;
        for ( int x = 0; x < testDocArray3.length; x = x + 1 ) {
            if ( !(testDocArray3[x].getFirstName().equalsIgnoreCase("~")) ) {
                docCount = docCount + 1;
            }
        }

        assertEquals("After adding the new doctor: No of available doctors = 5",5,docCount);
    }

    // Delete doctor test:
    Doctor[] testDocArray4 = new Doctor[5];
    Doctor tDA4doctor1 = new Doctor("John","Smith","1999/10/10","0778987845","M01","Skin Infection Type-1");
    Doctor tDA4doctor2 = new Doctor("Mary","Jane","1980/08/20","0716677889","M02","Skin Infection Type-2");
    Doctor tDA4doctor3 = new Doctor("Kane","Will","1989/09/30","0709944556","M04","Skin Infection Type-3");

    // Test-22 (Delete doctor)
    @Test
    public void deleteDoctorTest1() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray4);
        testDocArray4[0] = tDA4doctor1;
        testDocArray4[1] = tDA4doctor2;
        testDocArray4[2] = tDA4doctor3;
        manager1.deleteDoctor(testDocArray4,"M04");

        int docCount = 0;
        for ( int x = 0; x < testDocArray4.length; x = x + 1 ) {
            if ( !(testDocArray4[x].getFirstName().equalsIgnoreCase("~")) ) {
                docCount = docCount + 1;
            }
        }

        assertEquals("After deleting the doctor: No of available doctors = 2",2,docCount);
    }

    // Test-23 (Delete doctor)
    @Test
    public void deleteDoctorTest2() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray4);
        testDocArray4[0] = tDA4doctor1;
        testDocArray4[1] = tDA4doctor2;
        manager1.deleteDoctor(testDocArray4,"M01");
        manager1.deleteDoctor(testDocArray4,"M02");

        int docCount = 0;
        for ( int x = 0; x < testDocArray4.length; x = x + 1 ) {
            if ( !(testDocArray4[x].getFirstName().equalsIgnoreCase("~")) ) {
                docCount = docCount + 1;
            }
        }

        assertEquals("After deleting the doctor: No of available doctors = 0",0,docCount);
    }

    // Test-24 (Delete doctor)
    @Test
    public void deleteDoctorTest3() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray4);
        manager1.deleteDoctor(testDocArray4,"M01");

        int docCount = 0;
        for ( int x = 0; x < testDocArray4.length; x = x + 1 ) {
            if ( !(testDocArray4[x].getFirstName().equalsIgnoreCase("~")) ) {
                docCount = docCount + 1;
            }
        }

        assertEquals("After deleting the doctor: No of available doctors = 0",0,docCount);
    }

    // Test-25 (Delete doctor)
    @Test
    public void deleteDoctorTest4() {
        WestminsterSkinConsultationCentre.doctorInitialise(testDocArray4);
        testDocArray4[0] = tDA4doctor1;
        manager1.deleteDoctor(testDocArray4,"MK");

        int docCount = 0;
        for ( int x = 0; x < testDocArray4.length; x = x + 1 ) {
            if ( !(testDocArray4[x].getFirstName().equalsIgnoreCase("~")) ) {
                docCount = docCount + 1;
            }
        }

        assertEquals("After deleting the doctor: No of available doctors = 1",1,docCount);
    }

}