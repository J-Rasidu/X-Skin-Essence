import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDocFrame extends JFrame {

    private JTextField txtFirstName;
    private JTextField txtSurname;
    public static JTextField txtDocDateOfBirth;
    private JTextField txtMobileNumber;
    private JTextField txtMedLNumber;
    private JTextField txtSpecialisation;

    public AddDocFrame() {
        // Creating addDocPanel1:
        JPanel addDocPanel1 = new JPanel();
        addDocPanel1.setBackground( new Color(0x8fa785) );
        Border addDocP1Border = BorderFactory.createLineBorder( new Color(0xe9f3e5),5 );
        addDocPanel1.setBorder( addDocP1Border );

        // Adding lbAddDocHeader label to addDocPanel1:
        JLabel lbAddDocHeader = new JLabel("ADD DOCTOR");
        lbAddDocHeader.setFont( new Font("Arial",Font.BOLD,40) );
        addDocPanel1.add( lbAddDocHeader );

        // Creating btnState button:
        JButton btnState = new JButton("MENU");
        btnState.setFont( new Font("Arial",Font.BOLD,20) );
        btnState.setForeground( new Color(0xe9f3e5) );
        btnState.setBackground( new Color(0x525248) );
        btnState.setFocusable(false);

        // Creating addDocPanel2:
        JPanel addDocPanel2 = new JPanel();
        addDocPanel2.setLayout( new GridLayout(7,2,5,5));
        addDocPanel2.setBackground( new Color(0x393830) );

        Border innerAddDocPanel2Border = BorderFactory.createLineBorder( new Color(0x393830),100 );
        Border outerAddDocPanel2Border = BorderFactory.createLineBorder( new Color(0xe9f3e5),5 );
        addDocPanel2.setBorder( BorderFactory.createCompoundBorder( outerAddDocPanel2Border,innerAddDocPanel2Border ) );


        // Creating lbFirstName label and txtFirstName TextField and adding them to addDocPanel2:
        JLabel lbFirstName = new JLabel("First Name: ",JLabel.CENTER);
        lbFirstName.setFont( new Font("Arial",Font.BOLD,20) );
        lbFirstName.setForeground(new Color(0xe9f3e5));
        addDocPanel2.add( lbFirstName );
        txtFirstName = new JTextField(10);
        txtFirstName.setHorizontalAlignment(JTextField.CENTER);
        txtFirstName.setFont( new Font("Arial",Font.BOLD,20) );
        txtFirstName.setBackground(new Color(0xe9f3e5));
        addDocPanel2.add( txtFirstName );

        // Creating lbSurname label and txtSurname TextField and adding them to addDocPanel2:
        JLabel lbSurname = new JLabel("Surname: ",JLabel.CENTER);
        lbSurname.setFont( new Font("Arial",Font.BOLD,20) );
        lbSurname.setForeground(new Color(0xe9f3e5));
        addDocPanel2.add( lbSurname );
        txtSurname = new JTextField(10);
        txtSurname.setHorizontalAlignment(JTextField.CENTER);
        txtSurname.setFont( new Font("Arial",Font.BOLD,20) );
        txtSurname.setBackground(new Color(0xe9f3e5));
        addDocPanel2.add( txtSurname );

        // Creating lbDateOfBirth and adding it to addDocPanel2:
        JLabel lbDateOfBirth = new JLabel("Date of birth: ",JLabel.CENTER);
        lbDateOfBirth.setFont( new Font("Arial",Font.BOLD,20) );
        lbDateOfBirth.setForeground(new Color(0xe9f3e5));
        addDocPanel2.add( lbDateOfBirth );

        // Creating dateOfBirthPanel with GridLayout:
        JPanel dateOfBirthPanel = new JPanel();
        dateOfBirthPanel.setLayout( new GridLayout(1,2) );

        // Creating txtDocDateOfBirth as Uneditable TextField and adding it to dateOfBirthPanel:
        txtDocDateOfBirth = new JTextField("",10);
        txtDocDateOfBirth.setHorizontalAlignment(JTextField.CENTER);
        txtDocDateOfBirth.setEditable(false);
        txtDocDateOfBirth.setFont( new Font("Arial",Font.BOLD,20) );
        txtDocDateOfBirth.setBackground(new Color(0xe9f3e5));
        dateOfBirthPanel.add(txtDocDateOfBirth);

        // Creating btnDOBPicker button and adding it to dateOfBirthPanel:
        JButton btnDOBPicker = new JButton("DOB PICKER");
        btnDOBPicker.setFont( new Font("Arial",Font.BOLD,20) );
        btnDOBPicker.setForeground( new Color(0xe9f3e5) );
        btnDOBPicker.setBackground( new Color(0x7f6000) );
        btnDOBPicker.setBorder(BorderFactory.createLineBorder(new Color(0xff7500),3,true));
        btnDOBPicker.setFocusable(false);
        dateOfBirthPanel.add( btnDOBPicker );

        // Adding dateOfBirthPanel to addDocPanel2:
        addDocPanel2.add( dateOfBirthPanel );

        // Creating lbMobileNumber label and txtMobileNumber TextField and adding them to addDocPanel2:
        JLabel lbMobileNumber = new JLabel("Mobile number: ",JLabel.CENTER);
        lbMobileNumber.setFont( new Font("Arial",Font.BOLD,20) );
        lbMobileNumber.setForeground(new Color(0xe9f3e5));
        addDocPanel2.add( lbMobileNumber );
        txtMobileNumber = new JTextField(10);
        txtMobileNumber.setHorizontalAlignment(JTextField.CENTER);
        txtMobileNumber.setFont( new Font("Arial",Font.BOLD,20) );
        txtMobileNumber.setBackground(new Color(0xe9f3e5));
        addDocPanel2.add( txtMobileNumber );

        // Creating lbMedLNumber label and txtMedLNumber TextField and adding them to addDocPanel2:
        JLabel lbMedLNumber = new JLabel("Medical licence number: ",JLabel.CENTER);
        lbMedLNumber.setFont( new Font("Arial",Font.BOLD,20) );
        lbMedLNumber.setForeground(new Color(0xe9f3e5));
        addDocPanel2.add( lbMedLNumber );
        txtMedLNumber = new JTextField(10);
        txtMedLNumber.setHorizontalAlignment(JTextField.CENTER);
        txtMedLNumber.setFont( new Font("Arial",Font.BOLD,20) );
        txtMedLNumber.setBackground(new Color(0xe9f3e5));
        addDocPanel2.add( txtMedLNumber );

        // Creating lbSpecialisation label and txtSpecialisation TextField and adding them to addDocPanel2:
        JLabel lbSpecialisation = new JLabel("Specialisation: ",JLabel.CENTER);
        lbSpecialisation.setFont( new Font("Arial",Font.BOLD,20) );
        lbSpecialisation.setForeground(new Color(0xe9f3e5));
        addDocPanel2.add( lbSpecialisation );
        txtSpecialisation = new JTextField(10);
        txtSpecialisation.setHorizontalAlignment(JTextField.CENTER);
        txtSpecialisation.setFont( new Font("Arial",Font.BOLD,20) );
        txtSpecialisation.setBackground(new Color(0xe9f3e5));
        addDocPanel2.add( txtSpecialisation );

        // Creating btnResetDoc button and adding it to addDocPanel2:
        JButton btnResetDoc = new JButton("RESET");
        btnResetDoc.setFont( new Font("Arial",Font.BOLD,20) );
        btnResetDoc.setForeground( new Color(0xe9f3e5) );
        btnResetDoc.setBackground( new Color(0x003464) );
        btnResetDoc.setBorder(BorderFactory.createLineBorder(new Color(0x368b5fd),5,true));
        btnResetDoc.setFocusable(false);
        addDocPanel2.add( btnResetDoc );

        // Creating btnAddDoc button and adding it to addDocPanel2:
        JButton btnAddDoc = new JButton("ADD");
        btnAddDoc.setFont( new Font("Arial",Font.BOLD,20) );
        btnAddDoc.setForeground( new Color(0xe9f3e5) );
        btnAddDoc.setBackground( new Color(0x36492e) );
        btnAddDoc.setBorder(BorderFactory.createLineBorder(new Color(0x3fd000),5,true));
        btnAddDoc.setFocusable(false);
        addDocPanel2.add( btnAddDoc );

        // Creating addDocPanelFinal with a BorderLayout:
        JPanel addDocPanelFinal = new JPanel();
        addDocPanelFinal.setLayout( new BorderLayout() );

        // Add addDocPanel1, btnState and addDocPanel2 to addDocPanelFinal:
        addDocPanelFinal.add( addDocPanel1,BorderLayout.NORTH );
        addDocPanelFinal.add( btnState,BorderLayout.SOUTH );
        addDocPanelFinal.add( addDocPanel2,BorderLayout.CENTER );

        // Add AddDocPanelFinal to frame:
        add(addDocPanelFinal);

        AddDocFrameButtonAction  addDocFrameHandler = new AddDocFrameButtonAction();
        btnState.addActionListener(addDocFrameHandler);
        btnAddDoc.addActionListener(addDocFrameHandler);
        btnResetDoc.addActionListener(addDocFrameHandler);
        btnDOBPicker.addActionListener(addDocFrameHandler);

    }

    private class AddDocFrameButtonAction implements ActionListener {
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
            else if ( btnLabel.equals("RESET") ) {
                txtFirstName.setText(null);
                txtSurname.setText(null);
                txtDocDateOfBirth.setText(null);
                txtMobileNumber.setText(null);
                txtMedLNumber.setText(null);
                txtSpecialisation.setText(null);
            }
            else if ( btnLabel.equals("DOB PICKER") ) {
                DatePickerFrame dPFrame = new DatePickerFrame("AddDocFrame");
                dPFrame.setVisible(true);
            }
            else if ( btnLabel.equals("ADD") ) {
                addDoctor();
            }
        }
    }

    private void addDoctor() {
        if ( !(txtFirstName.getText().equalsIgnoreCase("")) && !(txtSurname.getText().equalsIgnoreCase("")) && !(txtDocDateOfBirth.getText().equalsIgnoreCase("")) && !(txtMobileNumber.getText().equalsIgnoreCase("")) && !(txtMedLNumber.getText().equalsIgnoreCase("")) && !(txtSpecialisation.getText().equalsIgnoreCase("")) ) {
            if ( !(txtFirstName.getText().contains(":")) && !(txtSurname.getText().contains(":")) && !(txtDocDateOfBirth.getText().contains(":")) && !(txtMobileNumber.getText().contains(":")) && !(txtMedLNumber.getText().contains(":")) && !(txtSpecialisation.getText().contains(":")) ) {
                if ( !(txtMobileNumber.getText().equalsIgnoreCase("")) && (txtMobileNumber.getText().length() == 10) ) {
                    try {
                        Integer.parseInt(txtMobileNumber.getText());

                        if ( docAlreadyPresent(txtMedLNumber) ) {
                            JOptionPane.showMessageDialog( null,"Doctor is already in the centre!","MESSAGE",JOptionPane.ERROR_MESSAGE );
                        }
                        else {
                            int docCount = 0;
                            for ( int x = 0; x < WestminsterSkinConsultationCentre.doctors.length; x = x + 1 ) {
                                if ( WestminsterSkinConsultationCentre.doctors[x].getFirstName().equalsIgnoreCase("~") ) {
                                    WestminsterSkinConsultationCentre.doctors[x] = new Doctor(txtFirstName.getText(),txtSurname.getText(),txtDocDateOfBirth.getText(),txtMobileNumber.getText(),txtMedLNumber.getText(),txtSpecialisation.getText());
                                    break;
                                }
                                docCount = docCount + 1;
                            }
                            if ( docCount == WestminsterSkinConsultationCentre.doctors.length ) {
                                JOptionPane.showMessageDialog( null,"Maximum doctor limit has been reached! (Delete a doctor first)","MESSAGE",JOptionPane.ERROR_MESSAGE );
                            }
                            else {
                                JOptionPane.showMessageDialog( null,"Doctor has been added!","MESSAGE",JOptionPane.INFORMATION_MESSAGE );
                            }
                        }
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
                JOptionPane.showMessageDialog( null,"Cannot contain COLONs!","MESSAGE",JOptionPane.ERROR_MESSAGE );
            }
        }
        else {
            JOptionPane.showMessageDialog( null,"Fill all the Fields!","MESSAGE",JOptionPane.ERROR_MESSAGE );
        }
    }

    private boolean docAlreadyPresent(JTextField txtMedLNumber) {
        boolean present = false;
        for ( int x = 0; x < WestminsterSkinConsultationCentre.doctors.length; x = x + 1 ) {
            if ( WestminsterSkinConsultationCentre.doctors[x].getmLNumber().equalsIgnoreCase(txtMedLNumber.getText()) ) {
                present = true;
                break;
            }
        }
        return present;
    }

}
