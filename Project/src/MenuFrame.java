import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuFrame extends JFrame {

    public MenuFrame() {
        // Creating menuPanel1 with a GridLayout:
        JPanel menuPanel1 = new JPanel();
        menuPanel1.setLayout( new GridLayout(7,1));

    // Creating JButtons and adding them to menuPanel1:
        // Creating the doctorButton:
        JButton doctorButton = new JButton("DOCTORS");
        doctorButton.setFont( new Font("Arial",Font.BOLD,20) );
        Border innerDocBtnBorder = BorderFactory.createLineBorder( new Color(0x8fa785),5 );
        Border outerDocBtnBorder = BorderFactory.createLineBorder( new Color(0xe9f3e5),3 );
        doctorButton.setBorder( BorderFactory.createCompoundBorder( outerDocBtnBorder,innerDocBtnBorder ) );
        doctorButton.setBackground( new Color(0x8fa785) );
        doctorButton.setFocusable(false);
        menuPanel1.add( doctorButton );

        // Creating the consultationButton:
        JButton consultationButton = new JButton("CONSULTATIONS");
        consultationButton.setFont( new Font("Arial",Font.BOLD,20) );
        Border innerConBtnBorder = BorderFactory.createLineBorder( new Color(0x8fa785),5 );
        Border outerConBtnBorder = BorderFactory.createLineBorder( new Color(0xe9f3e5),3 );
        consultationButton.setBorder( BorderFactory.createCompoundBorder( outerConBtnBorder,innerConBtnBorder ) );
        consultationButton.setBackground( new Color(0x8fa785) );
        consultationButton.setFocusable(false);
        menuPanel1.add( consultationButton );

        // Creating the bookButton:
        JButton bookButton = new JButton("APPOINTMENT");
        bookButton.setFont( new Font("Arial",Font.BOLD,20) );
        Border innerBookBtnBorder = BorderFactory.createLineBorder( new Color(0x8fa785),5 );
        Border outerBookBtnBorder = BorderFactory.createLineBorder( new Color(0xe9f3e5),3 );
        bookButton.setBorder( BorderFactory.createCompoundBorder( outerBookBtnBorder,innerBookBtnBorder ) );
        bookButton.setBackground( new Color(0x8fa785) );
        bookButton.setFocusable(false);
        menuPanel1.add( bookButton );

        // Creating the addDocButton:
        JButton addDocButton = new JButton("ADD DOCTOR");
        addDocButton.setFont( new Font("Arial",Font.BOLD,20) );
        Border innerAddDocBtnBorder = BorderFactory.createLineBorder( new Color(0x8fa785),5 );
        Border outerAddDocBtnBorder = BorderFactory.createLineBorder( new Color(0xe9f3e5),3 );
        addDocButton.setBorder( BorderFactory.createCompoundBorder( outerAddDocBtnBorder,innerAddDocBtnBorder ) );
        addDocButton.setBackground( new Color(0x8fa785) );
        addDocButton.setFocusable(false);
        menuPanel1.add( addDocButton );

        // Creating the delDocButton:
        JButton delDocButton = new JButton("DELETE DOCTOR");
        delDocButton.setFont( new Font("Arial",Font.BOLD,20) );
        Border innerDelDocBtnBorder = BorderFactory.createLineBorder( new Color(0x8fa785),5 );
        Border outerDelDocBtnBorder = BorderFactory.createLineBorder( new Color(0xe9f3e5),3 );
        delDocButton.setBorder( BorderFactory.createCompoundBorder( outerDelDocBtnBorder,innerDelDocBtnBorder ) );
        delDocButton.setBackground( new Color(0x8fa785) );
        delDocButton.setFocusable(false);
        menuPanel1.add( delDocButton );

        // Creating the fileBackupButton:
        JButton fileBackupButton = new JButton("BACKUP");
        fileBackupButton.setFont( new Font("Arial",Font.BOLD,20) );
        Border innerFileBackupBtnBorder = BorderFactory.createLineBorder( new Color(0x8fa785),5 );
        Border outerFileBackupBtnBorder = BorderFactory.createLineBorder( new Color(0xe9f3e5),3 );
        fileBackupButton.setBorder( BorderFactory.createCompoundBorder( outerFileBackupBtnBorder,innerFileBackupBtnBorder ) );
        fileBackupButton.setBackground( new Color(0x8fa785) );
        fileBackupButton.setFocusable(false);
        menuPanel1.add( fileBackupButton );

        // Creating the fileRestoreButton:
        JButton fileRestoreButton = new JButton("RESTORE");
        fileRestoreButton.setFont( new Font("Arial",Font.BOLD,20) );
        Border innerFileRestoreBtnBorder = BorderFactory.createLineBorder( new Color(0x8fa785),5 );
        Border outerFileRestoreBtnBorder = BorderFactory.createLineBorder( new Color(0xe9f3e5),3 );
        fileRestoreButton.setBorder( BorderFactory.createCompoundBorder( outerFileRestoreBtnBorder,innerFileRestoreBtnBorder ) );
        fileRestoreButton.setBackground( new Color(0x8fa785) );
        fileRestoreButton.setFocusable(false);
        menuPanel1.add( fileRestoreButton );

        // Creating menuPanel1 with a FlowLayout (Default) and adding lbHeader with an ImageIcon to it:
        JPanel menuPanel2 = new JPanel();
        menuPanel2.setBackground( new Color(0x525248) );

        Border innerP2Border = BorderFactory.createLineBorder( new Color(0xBEBBA9),5,true );
        Border outerP2Border = BorderFactory.createLineBorder( new Color(0x525248),5 );
        menuPanel2.setBorder( BorderFactory.createCompoundBorder( outerP2Border,innerP2Border ) );

        JLabel lbHeader = new JLabel("X-SKIN ESSENCE");

        ImageIcon logoIcon = new ImageIcon("Logo.png");
        Image logoImage = logoIcon.getImage();
        Image logoImageResize = logoImage.getScaledInstance(65,60,Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon( logoImageResize );
        lbHeader.setIcon( logoIcon );

        lbHeader.setFont( new Font("Arial",Font.BOLD,40) );
        lbHeader.setForeground( new Color(0xe9f3e5) );
        menuPanel2.add( lbHeader );

        // Creating the Sate button:
        JButton btnState = new JButton("MENU");
        btnState.setFont( new Font("Arial",Font.BOLD,20) );
        btnState.setForeground( new Color(0xe9f3e5) );
        btnState.setBackground( new Color(0x525248) );
        btnState.setFocusable(false);

        // Creating menuPanel3 with a BorderLayout:
        JPanel menuPanel3 = new JPanel();
        menuPanel3.setLayout( new BorderLayout() );

        // Resizing an image and adding it to bgLabel1:
        ImageIcon bgIcon1 = new ImageIcon("MenuBG.jpg");
        Image bgImage1 = bgIcon1.getImage();
        Image bgImage1Resize = bgImage1.getScaledInstance(900,500,Image.SCALE_SMOOTH);
        bgIcon1 = new ImageIcon( bgImage1Resize );
        JLabel bgLabel1 = new JLabel( bgIcon1 );

        // Adding components to menuPanel3:
        menuPanel3.add( menuPanel1,BorderLayout.EAST );
        menuPanel3.add( menuPanel2,BorderLayout.NORTH );
        menuPanel3.add( bgLabel1,BorderLayout.CENTER );
        menuPanel3.add( btnState,BorderLayout.SOUTH );

        // Adding menuPanel3 to frame:
        add(menuPanel3);

        MenuFrameButtonAction menuFrameHandler = new MenuFrameButtonAction();
        doctorButton.addActionListener(menuFrameHandler);
        consultationButton.addActionListener(menuFrameHandler);
        bookButton.addActionListener(menuFrameHandler);
        addDocButton.addActionListener(menuFrameHandler);
        delDocButton.addActionListener(menuFrameHandler);
        fileBackupButton.addActionListener(menuFrameHandler);
        fileRestoreButton.addActionListener(menuFrameHandler);
        btnState.addActionListener(menuFrameHandler);
    }

    private class MenuFrameButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String btnLabel = event.getActionCommand();
            if ( btnLabel.equals("DOCTORS") ) {
                setVisible(false);
                DoctorFrame doctorFrame = new DoctorFrame();
                doctorFrame.setTitle("X-SKIN ESSENCE (DOCTORS)");
                doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                doctorFrame.setSize(1100,650);
                doctorFrame.setLocation(90,20);
                doctorFrame.setVisible(true);
                doctorFrame.setResizable(false);
                ImageIcon logoIcon = new ImageIcon("Logo.png");
                doctorFrame.setIconImage(logoIcon.getImage());
            }
            else if ( btnLabel.equals("CONSULTATIONS") ) {
                setVisible(false);
                ConsultationFrame consultationFrame = new ConsultationFrame();
                consultationFrame.setTitle("X-SKIN ESSENCE (CONSULTATIONS)");
                consultationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                consultationFrame.setSize(1100,650);
                consultationFrame.setLocation(90,20);
                consultationFrame.setVisible(true);
                consultationFrame.setResizable(false);
                ImageIcon logoIcon = new ImageIcon("Logo.png");
                consultationFrame.setIconImage(logoIcon.getImage());
            }
            else if ( btnLabel.equals("APPOINTMENT") ) {
                setVisible(false);
                BookDocFrame bookDocFrame = new BookDocFrame();
                bookDocFrame.setTitle("X-SKIN ESSENCE (APPOINTMENT)");
                bookDocFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                bookDocFrame.setSize(1100,650);
                bookDocFrame.setLocation(90,20);
                bookDocFrame.setVisible(true);
                bookDocFrame.setResizable(false);
                ImageIcon logoIcon = new ImageIcon("Logo.png");
                bookDocFrame.setIconImage(logoIcon.getImage());
            }
            else if ( btnLabel.equals("ADD DOCTOR") ) {
                setVisible(false);
                AddDocFrame addDocFrame = new AddDocFrame();
                addDocFrame.setTitle("X-SKIN ESSENCE (ADD DOCTOR)");
                addDocFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addDocFrame.setSize(1100,650);
                addDocFrame.setLocation(90,20);
                addDocFrame.setVisible(true);
                addDocFrame.setResizable(false);
                ImageIcon logoIcon = new ImageIcon("Logo.png");
                addDocFrame.setIconImage(logoIcon.getImage());
            }
            else if ( btnLabel.equals("DELETE DOCTOR") ) {
                setVisible(false);
                DelDocFrame deleteDocFrame = new DelDocFrame();
                deleteDocFrame.setTitle("X-SKIN ESSENCE (DELETE DOCTOR)");
                deleteDocFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                deleteDocFrame.setSize(1100,650);
                deleteDocFrame.setLocation(90,20);
                deleteDocFrame.setVisible(true);
                deleteDocFrame.setResizable(false);
                ImageIcon logoIcon = new ImageIcon("Logo.png");
                deleteDocFrame.setIconImage(logoIcon.getImage());
            }
            else if ( btnLabel.equals("BACKUP") ) {
                docFileStore(WestminsterSkinConsultationCentre.doctors);
                conFileStore(WestminsterSkinConsultationCentre.doctors);
                JOptionPane.showMessageDialog( null,"Backup successful!","MESSAGE",JOptionPane.INFORMATION_MESSAGE );
            }
            else if ( btnLabel.equals("RESTORE") ) {
                docFileLoad(WestminsterSkinConsultationCentre.doctors,WestminsterSkinConsultationCentre.doctorFile);
                conFileLoad(WestminsterSkinConsultationCentre.doctors,WestminsterSkinConsultationCentre.consultationsFile);
                JOptionPane.showMessageDialog( null,"Restore successful!","MESSAGE",JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }

    // fileStore method:
    private static void docFileStore( Doctor[] doctors ) {
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
            JOptionPane.showMessageDialog( null,"Doctors File Store Error!","MESSAGE",JOptionPane.ERROR_MESSAGE );
        }
    }

    private static void conFileStore( Doctor[] doctors ) {
        try {
            FileWriter consultationWriter = new FileWriter("consultationsInfo.txt");
            consultationWriter.write("<------Skin-Consultation-Centre-Consultations-Info------>\n");
            consultationWriter.write("\n");

            for ( int a = 0; a < doctors.length; a = a + 1 ) {
                if ( !( doctors[a].getFirstName().equalsIgnoreCase("~") ) ) {
                    if ( 0 < doctors[a].consultations.size() ) {
                        for ( int x = 0; x < doctors[a].consultations.size(); x = x + 1 ) {
                            consultationWriter.write( "Dr. "+doctors[a].getFirstName()+" "+doctors[a].getSurname()+" - "+doctors[a].consultations.get(x).patient.getPatientId()+" - "+doctors[a].consultations.get(x).patient.getFirstName()+" "+doctors[a].consultations.get(x).patient.getSurname()+" - "+doctors[a].consultations.get(x).patient.getDOB()+" - "+doctors[a].consultations.get(x).patient.getMobileNumber()+" - "+doctors[a].consultations.get(x).getDateAndTime()+" - "+doctors[a].consultations.get(x).getCost()+" - "+doctors[a].consultations.get(x).getNote() );
                            consultationWriter.write("\n");
                        }
                    }
                }
            }
            consultationWriter.write("< --------------- END --------------- >");
            consultationWriter.close();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog( null,"Consultations File Store Error!","MESSAGE",JOptionPane.ERROR_MESSAGE );
        }
    }

    // fileLoad method:
    private static void docFileLoad( Doctor[] doctors , File doctorFile ) {
        try {
            Scanner docLoadScan = new Scanner(doctorFile);
            String fileLine;
            while ( docLoadScan.hasNext() ) {
                fileLine = docLoadScan.nextLine();

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
                    }
                }
            }
            docLoadScan.close();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog( null,"Doctors File Load Error!","MESSAGE",JOptionPane.ERROR_MESSAGE );
        }
    }

    private static void conFileLoad( Doctor[] doctors , File consultationsFile ) {

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
