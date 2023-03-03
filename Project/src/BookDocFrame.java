import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookDocFrame extends JFrame {

    private int selectedDocIndex;
    private String selectedTimeSlot;
    private JPanel bookDocPanelRight;
    private JLabel lbMessage1;
    private JLabel lbMessage2;
    private JTextField txtMlNumber;
    private JTextField txtDurationInMinutes;
    private JTextField txtPatientID;
    private JTextField txtFirstName;
    private JTextField txtSurname;
    private JTextField txtMobileNumber;
    public static JTextArea txtAreaNote;
    public static JTextField txtDate;
    public static JTextField txtTime;
    public static JTextField txtPatientDateOfBirth;

    public BookDocFrame() {
        // Creating bookDocPanel1:
        JPanel bookDocPanel1 = new JPanel();
        bookDocPanel1.setBackground( new Color(0x8fa785) );
        Border addDocP1Border = BorderFactory.createLineBorder( new Color(0xe9f3e5),5 );
        bookDocPanel1.setBorder( addDocP1Border );

        // Creating lbAddDocHeader and adding it to bookDocPanel1:
        JLabel lbAddDocHeader = new JLabel("APPOINTMENT");
        lbAddDocHeader.setFont( new Font("Arial",Font.BOLD,40) );
        bookDocPanel1.add( lbAddDocHeader );

        // Creating btnState button:
        JButton btnState = new JButton("MENU");
        btnState.setFont( new Font("Arial",Font.BOLD,20) );
        btnState.setForeground( new Color(0xe9f3e5) );
        btnState.setBackground( new Color(0x525248) );
        btnState.setFocusable(false);

        // Creating bookDocPanel2 with BorderLayout:
        JPanel bookDocPanel2 = new JPanel();
        bookDocPanel2.setBackground( new Color(0xe9f3e5) );
        bookDocPanel2.setLayout( new BorderLayout() );

        // Creating messagePanel with GridLayout:
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout( new GridLayout(2,1) );

        // Creating lbMessage1 and adding it to messagePanel:
        lbMessage1 = new JLabel("");
        lbMessage1.setHorizontalAlignment(lbMessage1.CENTER);
        lbMessage1.setForeground( new Color(0xeb0000) );
        lbMessage1.setFont( new Font("Arial",Font.BOLD,20) );
        messagePanel.add(lbMessage1);

        // Creating lbMessage2 and adding it to messagePanel:
        lbMessage2 = new JLabel("");
        lbMessage2.setHorizontalAlignment(lbMessage2.CENTER);
        lbMessage2.setFont( new Font("Arial",Font.BOLD,20) );
        messagePanel.add(lbMessage2);

        // Adding messagePanel to bookDocPanel2 - North:
        bookDocPanel2.add(messagePanel,BorderLayout.NORTH);

        // Creating bookDocPanel3 with a GridLayout:
        JPanel bookDocPanel3 = new JPanel();
        bookDocPanel3.setLayout( new GridLayout(1,1) );
        bookDocPanel3.setBackground( new Color(0x393830) );

        Border innerAddDocPanel2Border = BorderFactory.createLineBorder( new Color(0x393830),80 );
        Border outerAddDocPanel2Border = BorderFactory.createLineBorder( new Color(0xe9f3e5),5 );
        bookDocPanel3.setBorder( BorderFactory.createCompoundBorder( outerAddDocPanel2Border,innerAddDocPanel2Border ) );

        // Creating bookDocPanelLeft with GridLayout:
        JPanel bookDocPanelLeft = new JPanel();
        bookDocPanelLeft.setBackground( new Color(0x393830) );
        bookDocPanelLeft.setLayout( new GridLayout(5,2,5,30) );

    // Adding the relevant components to bookDocPanelLeft:
        JLabel lbMlNumber = new JLabel("Dr. medical licence No: ",JLabel.CENTER);
        lbMlNumber.setFont( new Font("Arial",Font.BOLD,20) );
        lbMlNumber.setForeground(new Color(0xe9f3e5));
        bookDocPanelLeft.add( lbMlNumber );
        txtMlNumber = new JTextField(10);
        txtMlNumber.setHorizontalAlignment(JTextField.CENTER);
        txtMlNumber.setFont( new Font("Arial",Font.BOLD,20) );
        txtMlNumber.setBackground(new Color(0xe9f3e5));
        bookDocPanelLeft.add( txtMlNumber );

        JLabel lbDate = new JLabel("Date: ",JLabel.CENTER);
        lbDate.setFont( new Font("Arial",Font.BOLD,20) );
        lbDate.setForeground(new Color(0xe9f3e5));
        bookDocPanelLeft.add( lbDate );

        // Creating consultationDatePanel with GridLayout:
        JPanel consultationDatePanel = new JPanel();
        consultationDatePanel.setLayout( new GridLayout(1,2) );

        // Creating txtDate as Uneditable TextField and adding it to consultationDatePanel:
        txtDate = new JTextField(10);
        txtDate.setHorizontalAlignment(JTextField.CENTER);
        txtDate.setEditable(false);
        txtDate.setFont( new Font("Arial",Font.BOLD,14) );
        txtDate.setBackground(new Color(0xe9f3e5));
        consultationDatePanel.add(txtDate);

        // Creating btnDatePicker button and adding it to consultationDatePanel:
        JButton btnDatePicker = new JButton("DATE PICKER");
        btnDatePicker.setFont( new Font("Arial",Font.BOLD,14) );
        btnDatePicker.setForeground( new Color(0xe9f3e5) );
        btnDatePicker.setBackground( new Color(0x7f6000) );
        btnDatePicker.setBorder(BorderFactory.createLineBorder(new Color(0xff7500),3,true));
        btnDatePicker.setFocusable(false);
        consultationDatePanel.add( btnDatePicker );

        // Adding consultationDatePanel to bookDocPanelLeft:
        bookDocPanelLeft.add( consultationDatePanel );

        JLabel lbTime = new JLabel("Time ( 24 Hours ): ",JLabel.CENTER);
        lbTime.setFont( new Font("Arial",Font.BOLD,20) );
        lbTime.setForeground(new Color(0xe9f3e5));
        bookDocPanelLeft.add( lbTime );

        // Creating consultationTimePanel with GridLayout:
        JPanel consultationTimePanel = new JPanel();
        consultationTimePanel.setLayout( new GridLayout(1,2) );

        // Creating txtTime as Uneditable TextField and adding it to consultationTimePanel:
        txtTime = new JTextField(10);
        txtTime.setHorizontalAlignment(JTextField.CENTER);
        txtTime.setEditable(false);
        txtTime.setFont( new Font("Arial",Font.BOLD,16) );
        txtTime.setBackground(new Color(0xe9f3e5));
        consultationTimePanel.add(txtTime);

        // Creating btnTimePicker button and adding it to consultationTimePanel:
        JButton btnTimePicker = new JButton("TIME PICKER");
        btnTimePicker.setFont( new Font("Arial",Font.BOLD,14) );
        btnTimePicker.setForeground( new Color(0xe9f3e5) );
        btnTimePicker.setBackground( new Color(0x610039) );
        btnTimePicker.setBorder(BorderFactory.createLineBorder(new Color(0xc80075),3,true));
        btnTimePicker.setFocusable(false);
        consultationTimePanel.add( btnTimePicker );

        // Adding consultationTimePanel to bookDocPanelLeft:
        bookDocPanelLeft.add( consultationTimePanel );

        JLabel lbDurationInMinutes = new JLabel("Duration ( In Minutes ): ",JLabel.CENTER);
        lbDurationInMinutes.setFont( new Font("Arial",Font.BOLD,20) );
        lbDurationInMinutes.setForeground(new Color(0xe9f3e5));
        bookDocPanelLeft.add( lbDurationInMinutes );
        txtDurationInMinutes = new JTextField(10);
        txtDurationInMinutes.setHorizontalAlignment(JTextField.CENTER);
        txtDurationInMinutes.setFont( new Font("Arial",Font.BOLD,20) );
        txtDurationInMinutes.setBackground(new Color(0xe9f3e5));
        bookDocPanelLeft.add( txtDurationInMinutes );

        JButton btnCheck = new JButton("CHECK AVAILABILITY");
        btnCheck.setFont( new Font("Arial",Font.BOLD,20) );
        btnCheck.setForeground( new Color(0xe9f3e5) );
        btnCheck.setBackground( new Color(0x003464) );
        btnCheck.setBorder(BorderFactory.createLineBorder(new Color(0x368b5fd),5,true));
        btnCheck.setFocusable(false);
        bookDocPanelLeft.add( btnCheck );

        // Adding bookDocPanelLeft to bookDocPanel3:
        bookDocPanel3.add( bookDocPanelLeft );

        // Creating bookDocPanelRight with GridLayout:
        bookDocPanelRight = new JPanel();
        bookDocPanelRight.setBackground( new Color(0x393830) );
        bookDocPanelRight.setLayout( new GridLayout(7,2,5,5) );

        // Adding the relevant components to bookDocPanelRight:
        JLabel lbPatientID = new JLabel("Patient ID: ",JLabel.CENTER);
        lbPatientID.setFont( new Font("Arial",Font.BOLD,20) );
        lbPatientID.setForeground(new Color(0xe9f3e5));
        bookDocPanelRight.add( lbPatientID );
        txtPatientID = new JTextField(10);
        txtPatientID.setHorizontalAlignment(JTextField.CENTER);
        txtPatientID.setFont( new Font("Arial",Font.BOLD,20) );
        txtPatientID.setBackground(new Color(0xe9f3e5));
        bookDocPanelRight.add( txtPatientID );

        JLabel lbFirstName = new JLabel("First Name: ",JLabel.CENTER);
        lbFirstName.setFont( new Font("Arial",Font.BOLD,20) );
        lbFirstName.setForeground(new Color(0xe9f3e5));
        bookDocPanelRight.add( lbFirstName );
        txtFirstName = new JTextField(10);
        txtFirstName.setHorizontalAlignment(JTextField.CENTER);
        txtFirstName.setFont( new Font("Arial",Font.BOLD,20) );
        txtFirstName.setBackground(new Color(0xe9f3e5));
        bookDocPanelRight.add( txtFirstName );

        JLabel lbSurname = new JLabel("Surname: ",JLabel.CENTER);
        lbSurname.setFont( new Font("Arial",Font.BOLD,20) );
        lbSurname.setForeground(new Color(0xe9f3e5));
        bookDocPanelRight.add( lbSurname );
        txtSurname = new JTextField(10);
        txtSurname.setHorizontalAlignment(JTextField.CENTER);
        txtSurname.setFont( new Font("Arial",Font.BOLD,20) );
        txtSurname.setBackground(new Color(0xe9f3e5));
        bookDocPanelRight.add( txtSurname );

        JLabel lbDateOfBirth = new JLabel("Date of birth: ",JLabel.CENTER);
        lbDateOfBirth.setFont( new Font("Arial",Font.BOLD,20) );
        lbDateOfBirth.setForeground(new Color(0xe9f3e5));
        bookDocPanelRight.add( lbDateOfBirth );

        // Creating dateOfBirthPanel with GridLayout:
        JPanel dateOfBirthPanel = new JPanel();
        dateOfBirthPanel.setLayout( new GridLayout(1,2) );

        // Creating txtPatientDateOfBirth as Uneditable TextField and adding it to dateOfBirthPanel:
        txtPatientDateOfBirth = new JTextField("",10);
        txtPatientDateOfBirth.setHorizontalAlignment(JTextField.CENTER);
        txtPatientDateOfBirth.setEditable(false);
        txtPatientDateOfBirth.setFont( new Font("Arial",Font.BOLD,14) );
        txtPatientDateOfBirth.setBackground(new Color(0xe9f3e5));
        dateOfBirthPanel.add(txtPatientDateOfBirth);

        // Creating btnDOBPicker button and adding it to dateOfBirthPanel:
        JButton btnDOBPicker = new JButton("DOB PICKER");
        btnDOBPicker.setFont( new Font("Arial",Font.BOLD,14) );
        btnDOBPicker.setForeground( new Color(0xe9f3e5) );
        btnDOBPicker.setBackground( new Color(0x7f6000) );
        btnDOBPicker.setBorder(BorderFactory.createLineBorder(new Color(0xff7500),3,true));
        btnDOBPicker.setFocusable(false);
        dateOfBirthPanel.add( btnDOBPicker );

        // Adding dateOfBirthPanel to bookDocPanelRight:
        bookDocPanelRight.add( dateOfBirthPanel );

        JLabel lbMobileNumber = new JLabel("Mobile number: ",JLabel.CENTER);
        lbMobileNumber.setFont( new Font("Arial",Font.BOLD,20) );
        lbMobileNumber.setForeground(new Color(0xe9f3e5));
        bookDocPanelRight.add( lbMobileNumber );
        txtMobileNumber = new JTextField(10);
        txtMobileNumber.setHorizontalAlignment(JTextField.CENTER);
        txtMobileNumber.setFont( new Font("Arial",Font.BOLD,20) );
        txtMobileNumber.setBackground(new Color(0xe9f3e5));
        bookDocPanelRight.add( txtMobileNumber );

        JLabel lbNote = new JLabel("Note: ",JLabel.CENTER);
        lbNote.setFont( new Font("Arial",Font.BOLD,20) );
        lbNote.setForeground(new Color(0xe9f3e5));
        bookDocPanelRight.add( lbNote );

        // Creating notePanel with GridLayout:
        JPanel notePanel = new JPanel();
        notePanel.setLayout( new GridLayout(1,2) );

        // Creating txtAreaNote as Uneditable TextArea with a scrollPane and adding it to notePanel:
        txtAreaNote = new JTextArea(2,3);
        txtAreaNote.setEditable(false);
        JScrollPane txtAreaScroll = new JScrollPane(txtAreaNote);
        notePanel.add(txtAreaScroll);

        // Creating btnAddNote button and adding it to notePanel:
        JButton btnAddNote = new JButton("ADD NOTE");
        btnAddNote.setFont( new Font("Arial",Font.BOLD,14) );
        btnAddNote.setForeground( new Color(0xe9f3e5) );
        btnAddNote.setBackground( new Color(0x2e1e57) );
        btnAddNote.setBorder(BorderFactory.createLineBorder(new Color(0xb4a7d6),3,true));
        btnAddNote.setFocusable(false);
        notePanel.add( btnAddNote );

        // Adding notePanel to bookDocPanelRight:
        bookDocPanelRight.add( notePanel );

        JButton btnSchedule = new JButton("SCHEDULE");
        btnSchedule.setFont( new Font("Arial",Font.BOLD,20) );
        btnSchedule.setForeground( new Color(0xe9f3e5) );
        btnSchedule.setBackground( new Color(0x36492e) );
        btnSchedule.setBorder(BorderFactory.createLineBorder(new Color(0x3fd000),5,true));
        btnSchedule.setFocusable(false);
        bookDocPanelRight.add( btnSchedule );

        JButton btnReset = new JButton("RESET");
        btnReset.setFont( new Font("Arial",Font.BOLD,20) );
        btnReset.setForeground( new Color(0xe9f3e5) );
        btnReset.setBackground( new Color(0x740000) );
        btnReset.setBorder(BorderFactory.createLineBorder(new Color(0xeb0000),5,true));
        btnReset.setFocusable(false);
        bookDocPanelRight.add( btnReset );
        bookDocPanelRight.setVisible(false);

        // Adding bookDocPanelRight to bookDocPanel3:
        bookDocPanel3.add( bookDocPanelRight );

        // Adding bookDocPanel3 to bookDocPanel2:
        bookDocPanel2.add( bookDocPanel3 );

        // Creating bookDocPanelFinal with BorderLayout:
        JPanel bookDocPanelFinal = new JPanel();
        bookDocPanelFinal.setLayout( new BorderLayout() );

        // Adding bookDocPanel1 to bookDocPanelFinal - North:
        bookDocPanelFinal.add( bookDocPanel1,BorderLayout.NORTH );
        // Adding btnState to bookDocPanelFinal - South:
        bookDocPanelFinal.add( btnState,BorderLayout.SOUTH );
        // Adding bookDocPanel2 to bookDocPanelFinal - Center:
        bookDocPanelFinal.add( bookDocPanel2,BorderLayout.CENTER );

        // Adding bookDocPanelFinal to frame:
        add(bookDocPanelFinal);

        BookDocFrameButtonAction bookDocFrameHandler = new BookDocFrameButtonAction();
        btnState.addActionListener(bookDocFrameHandler);
        btnDatePicker.addActionListener(bookDocFrameHandler);
        btnTimePicker.addActionListener(bookDocFrameHandler);
        btnDOBPicker.addActionListener(bookDocFrameHandler);
        btnCheck.addActionListener(bookDocFrameHandler);
        btnSchedule.addActionListener(bookDocFrameHandler);
        btnReset.addActionListener(bookDocFrameHandler);
        btnAddNote.addActionListener(bookDocFrameHandler);
    }

    private class BookDocFrameButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String btnLabel = event.getActionCommand();
            if ( btnLabel.equals("MENU") ) {
                setVisible(false);
                MenuFrame menuFrame = new MenuFrame();
                menuFrame.setTitle("X-SKIN ESSENCE");
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setSize(1100,650);
                menuFrame.setLocation(90,20);
                menuFrame.setVisible(true);
                menuFrame.setResizable(false);
                ImageIcon logoIcon = new ImageIcon("Logo.png");
                menuFrame.setIconImage(logoIcon.getImage());
            }
            else if ( btnLabel.equals("DATE PICKER") ) {
                DatePickerFrame dPFrame = new DatePickerFrame("BookDocFrame-1");
                dPFrame.setVisible(true);
            }
            else if ( btnLabel.equals("TIME PICKER") ) {
                TimePickerFrame setTimeFrame = new TimePickerFrame();
                setTimeFrame.setTitle("SET TIME (24 HOURS)");
                setTimeFrame.setLocation(620,250);
                setTimeFrame.setDefaultCloseOperation(TimePickerFrame.HIDE_ON_CLOSE);
                setTimeFrame.setSize(320,180);
                ImageIcon logoIcon = new ImageIcon("Logo.png");
                setTimeFrame.setIconImage(logoIcon.getImage());
                setTimeFrame.setVisible(true);
                setTimeFrame.setResizable(false);
            }
            else if ( btnLabel.equals("DOB PICKER") ) {
                DatePickerFrame dPFrame = new DatePickerFrame("BookDocFrame-2");
                dPFrame.setVisible(true);
            }
            else if ( btnLabel.equals("CHECK AVAILABILITY") ) {
                doctorAvailability();
            }
            else if ( btnLabel.equals("SCHEDULE") ) {
                bookConsultation();
            }
            else if ( btnLabel.equals("RESET") ) {
                lbMessage1.setText("");
                lbMessage2.setText("");
                txtMlNumber.setText("");
                txtDate.setText("");
                txtTime.setText("");
                txtDurationInMinutes.setText("");
                txtPatientID.setText("");
                txtFirstName.setText("");
                txtSurname.setText("");
                txtPatientDateOfBirth.setText("");
                txtMobileNumber.setText("");
                txtAreaNote.setText("");
                bookDocPanelRight.setVisible(false);
            }
            else if ( btnLabel.equals("ADD NOTE") ) {
                AddNoteFrame setNoteFrame = new AddNoteFrame();
                setNoteFrame.setTitle("ADD NOTE");
                setNoteFrame.setLocation(500,200);
                setNoteFrame.setDefaultCloseOperation(AddNoteFrame.HIDE_ON_CLOSE);
                setNoteFrame.setSize(640,275);
                ImageIcon logoIcon = new ImageIcon("Logo.png");
                setNoteFrame.setIconImage(logoIcon.getImage());
                setNoteFrame.setVisible(true);
                setNoteFrame.setResizable(false);
            }
        }
    }

    private String doctorDateCheckValidation() {
        String output;
        if ( !(txtDate.getText().equalsIgnoreCase("")) && !(txtTime.getText().equalsIgnoreCase("")) && !(txtDurationInMinutes.getText().equalsIgnoreCase("")) ) {
            try {
                int durationInMinutes = Integer.parseInt(txtDurationInMinutes.getText());

                String dateParts[] = txtDate.getText().split("/");
                int year = Integer.parseInt( dateParts[0] );
                int month = Integer.parseInt( dateParts[1] );
                int day = Integer.parseInt( dateParts[2] );

                String timeParts[] = txtTime.getText().split(":");
                int hours = Integer.parseInt( timeParts[0] );
                int minutes = Integer.parseInt( timeParts[1] );

                Calendar cDate = new GregorianCalendar(year,month - 1,day,hours,minutes);

                SimpleDateFormat fDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

                String startDateTime = fDate.format(cDate.getTime()); // Consultation start date time
                long timeInSecs = cDate.getTimeInMillis();
                Date afterAddingDateTime = new Date(timeInSecs + (durationInMinutes * 60 * 1000));
                String endDateTime = fDate.format(afterAddingDateTime); // Consultation end date time

                output = startDateTime+" / "+endDateTime; // Consultation date time range
            }
            catch (NumberFormatException error) {
                JOptionPane.showMessageDialog( null,"Invalid duration!","MESSAGE",JOptionPane.ERROR_MESSAGE );
                output = "";
            }
            return output;
        }
        else {
            JOptionPane.showMessageDialog( null,"Fill all the Fields!","MESSAGE",JOptionPane.ERROR_MESSAGE );
            output = "";
            return output;
        }
    }

    private void doctorAvailability() {
        if ( !(txtMlNumber.getText().equalsIgnoreCase("")) && !(txtMlNumber.getText().contains("-")) ) {

            boolean docIdInvalid = true;
            for ( int x = 0; x < WestminsterSkinConsultationCentre.doctors.length; x = x + 1 ) {
                if ( WestminsterSkinConsultationCentre.doctors[x].getmLNumber().equalsIgnoreCase(txtMlNumber.getText()) ) {
                    docIdInvalid = false;
                    String dateTimeRange = doctorDateCheckValidation();
                    if ( !(dateTimeRange.equalsIgnoreCase("")) ) {
                        boolean dateTimeRangeAvailable = false;
                        if ( WestminsterSkinConsultationCentre.doctors[x].consultDateTimeRanges.size() == 0 ) {
                            dateTimeRangeAvailable = true;
                            bookDocPanelRight.setVisible(true);
                            lbMessage1.setText("");
                            lbMessage2.setText("MESSAGE: Doctor is Available! - Date and time is also okay");
                            selectedDocIndex = x;
                            selectedTimeSlot = dateTimeRange;
                            break;
                        }
                        else {
                            String inputRangeSplit[] = dateTimeRange.split(" / ");

                            DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

                            LocalDateTime inputStartDT = LocalDateTime.parse(inputRangeSplit[0],formatPattern);
                            LocalDateTime inputEndDT = LocalDateTime.parse(inputRangeSplit[1],formatPattern);

                            for ( int b = 0; b < WestminsterSkinConsultationCentre.doctors[x].consultDateTimeRanges.size(); b = b + 1 ) {

                                String rangeSplit[] = WestminsterSkinConsultationCentre.doctors[x].consultDateTimeRanges.get(b).split(" / ");
                                LocalDateTime sDT = LocalDateTime.parse(rangeSplit[0],formatPattern);
                                LocalDateTime eDT = LocalDateTime.parse(rangeSplit[1],formatPattern);

                                if ( ( ((inputStartDT.compareTo(sDT) > 0) && (inputEndDT.compareTo(sDT) > 0)) && ((inputStartDT.compareTo(eDT) > 0) && (inputEndDT.compareTo(eDT) > 0)) ) || ( ((inputStartDT.compareTo(sDT) < 0) && (inputEndDT.compareTo(sDT) < 0)) && ((inputStartDT.compareTo(eDT) < 0) && (inputEndDT.compareTo(eDT) < 0)) ) ) {
                                    dateTimeRangeAvailable = true;
                                }
                                else {
                                    dateTimeRangeAvailable = false;
                                    break;
                                }
                            }

                            if ( dateTimeRangeAvailable ) {
                                bookDocPanelRight.setVisible(true);
                                lbMessage1.setText("");
                                lbMessage2.setText("MESSAGE: Doctor is Available! - Date and time is also okay");
                                selectedDocIndex = x;
                                selectedTimeSlot = dateTimeRange;
                                break;
                            }
                            else {

                                boolean dateTimeRandomRangeAvailable = false;

                                lbMessage1.setText( "MESSAGE: Dr."+WestminsterSkinConsultationCentre.doctors[x].getFirstName()+" already has a consultation (NOT AVAILABLE!)" );

                                HashSet<Integer>doctorIndexes = new HashSet<Integer>();

                                while (true) {
                                    Random randomIndexGen = new Random();
                                    int randomDocIndex = randomIndexGen.nextInt(10);
                                    if ( !(WestminsterSkinConsultationCentre.doctors[randomDocIndex].getFirstName().equalsIgnoreCase("~")) && (WestminsterSkinConsultationCentre.doctors[randomDocIndex].consultDateTimeRanges.size() == 0) ) {
                                        dateTimeRandomRangeAvailable = true;
                                        lbMessage2.setText("Dr. "+WestminsterSkinConsultationCentre.doctors[randomDocIndex].getFirstName()+" has been allocated for you! (FOR REQUESTED TIMESLOT)");
                                        bookDocPanelRight.setVisible(true);
                                        selectedDocIndex = randomDocIndex;
                                        selectedTimeSlot = dateTimeRange;
                                        break;
                                    }
                                    else if ( !(WestminsterSkinConsultationCentre.doctors[randomDocIndex].getFirstName().equalsIgnoreCase("~")) && (WestminsterSkinConsultationCentre.doctors[randomDocIndex].consultDateTimeRanges.size() > 0) ) {
                                        for ( int b = 0; b < WestminsterSkinConsultationCentre.doctors[randomDocIndex].consultDateTimeRanges.size(); b = b + 1 ) {
                                            String rangeRandomSplit[] = WestminsterSkinConsultationCentre.doctors[randomDocIndex].consultDateTimeRanges.get(b).split(" / ");

                                            DateTimeFormatter formatRandomPattern = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                                            LocalDateTime sRDT = LocalDateTime.parse(rangeRandomSplit[0],formatRandomPattern);
                                            LocalDateTime eRDT = LocalDateTime.parse(rangeRandomSplit[1],formatRandomPattern);

                                            if (  ( ((inputStartDT.compareTo(sRDT) > 0) && (inputEndDT.compareTo(sRDT) > 0)) && ((inputStartDT.compareTo(eRDT) > 0) && (inputEndDT.compareTo(eRDT) > 0)) ) || ( ((inputStartDT.compareTo(sRDT) < 0) && (inputEndDT.compareTo(sRDT) < 0)) && ((inputStartDT.compareTo(eRDT) < 0) && (inputEndDT.compareTo(eRDT) < 0)) ) ) {
                                                dateTimeRandomRangeAvailable = true;
                                            }
                                            else {
                                                dateTimeRandomRangeAvailable = false;
                                                doctorIndexes.add(randomDocIndex);
                                                break;
                                            }
                                        }
                                        if ( dateTimeRandomRangeAvailable ) {
                                            lbMessage2.setText("Dr. "+WestminsterSkinConsultationCentre.doctors[randomDocIndex].getFirstName()+" has been allocated for you! (FOR REQUESTED TIMESLOT)");
                                            bookDocPanelRight.setVisible(true);
                                            selectedDocIndex = randomDocIndex;
                                            selectedTimeSlot = dateTimeRange;
                                            break;

                                        }
                                        else if ( doctorIndexes.size() == availableDocCount() ) {
                                            lbMessage1.setText("");
                                            JOptionPane.showMessageDialog( null,"This timeslot is (NOT AVAILABLE) for any doctor!","MESSAGE",JOptionPane.ERROR_MESSAGE );
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ( docIdInvalid ) {
                JOptionPane.showMessageDialog( null,"Invalid doctor ML number!","MESSAGE",JOptionPane.ERROR_MESSAGE );
            }

        }
        else {
            JOptionPane.showMessageDialog( null,"Doctor ML number is Empty or it contains Dash '-' marks!","MESSAGE",JOptionPane.ERROR_MESSAGE );
        }
    }

    private double calculateCost(int durationInMinutes, JTextField txtPatientID) {
        boolean firstConsultation = true;
        double pCost = 0;
        boolean exitInnerLoop =  false;
        for ( int b = 0; b < WestminsterSkinConsultationCentre.doctors.length; b = b + 1 ) {
            for ( int y = 0; y < WestminsterSkinConsultationCentre.doctors[b].consultations.size(); y = y + 1 ) {
                if ( WestminsterSkinConsultationCentre.doctors[b].consultations.get(y).patient.getPatientId().equalsIgnoreCase(txtPatientID.getText()) ) {
                    firstConsultation = false;
                    exitInnerLoop = true;
                    double cost = 25 * Double.valueOf(durationInMinutes)/60;
                    pCost = pCost + cost;
                    break;
                }
            }
            if ( exitInnerLoop ) {
                break;
            }
        }

        if ( firstConsultation ) {
            double cost = 15 * Double.valueOf(durationInMinutes)/60;
            pCost = pCost + cost;
        }
        return pCost;
    }

    private boolean patientCheckValidation() {
        boolean valid = false;
        if ( (!(txtPatientID.getText().equalsIgnoreCase(""))) && (!(txtPatientID.getText().contains("-"))) && (!(txtFirstName.getText().equalsIgnoreCase(""))) && (!(txtFirstName.getText().contains("-"))) && (!(txtSurname.getText().equalsIgnoreCase(""))) && (!(txtSurname.getText().contains("-"))) && (!(txtPatientDateOfBirth.getText().equalsIgnoreCase(""))) && (!(txtMobileNumber.getText().equalsIgnoreCase(""))) && (!(txtAreaNote.getText().equalsIgnoreCase(""))) ) {
            if ( txtMobileNumber.getText().length() == 10 ) {
                try {
                    Integer.parseInt(txtMobileNumber.getText());
                    valid = true;
                }
                catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog( null,"Invalid mobile number!","MESSAGE",JOptionPane.ERROR_MESSAGE );
                }
            }
            else {
                JOptionPane.showMessageDialog( null,"Invalid mobile number!","MESSAGE",JOptionPane.ERROR_MESSAGE );
            }
        }
        else {
            JOptionPane.showMessageDialog( null,"Fill all the Fields or They contain DASH '-' marks!","MESSAGE",JOptionPane.ERROR_MESSAGE );
        }
        return valid;
    }

    private void bookConsultation() {
        boolean validated = patientCheckValidation();
        if ( validated ) {
            double consultationCost = calculateCost(Integer.parseInt(txtDurationInMinutes.getText()),txtPatientID);
            Consultation consultation = new Consultation(txtFirstName.getText(), txtSurname.getText(), txtPatientDateOfBirth.getText(), txtMobileNumber.getText(), txtPatientID.getText(), selectedTimeSlot, consultationCost, txtAreaNote.getText());
            WestminsterSkinConsultationCentre.doctors[selectedDocIndex].consultations.add( consultation );
            WestminsterSkinConsultationCentre.doctors[selectedDocIndex].consultDateTimeRanges.add(selectedTimeSlot);
            JOptionPane.showMessageDialog( null,"Appointment confirmed!","MESSAGE",JOptionPane.INFORMATION_MESSAGE );
        }
    }

    private int availableDocCount() {
        int availableDoctorCount = 0;
        for ( int y = 0; y < WestminsterSkinConsultationCentre.doctors.length; y = y + 1 ) {
            if ( WestminsterSkinConsultationCentre.doctors[y].getFirstName().equalsIgnoreCase("~") ) {
                continue;
            }
            else {
                availableDoctorCount = availableDoctorCount + 1;
            }
        }
        return availableDoctorCount;
    }


}
