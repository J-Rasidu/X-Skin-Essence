import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelDocFrame extends JFrame {

    private JTextField txtMedLNumber;
    private JLabel lbDelInfo1;
    private JLabel lbDelInfo2;
    private JLabel lbDelInfo3;
    private JPanel deleteDocContentPanel;

    public DelDocFrame() {
        // Creating deleteDocPanel1:
        JPanel deleteDocPanel1 = new JPanel();
        deleteDocPanel1.setBackground( new Color(0x8fa785) );
        Border delDocP1Border = BorderFactory.createLineBorder( new Color(0xe9f3e5),5 );
        deleteDocPanel1.setBorder( delDocP1Border );

        // Creating lbDelDocHeader and adding it to deleteDocPanel1:
        JLabel lbDelDocHeader = new JLabel("DELETE DOCTOR");
        lbDelDocHeader.setFont( new Font("Arial",Font.BOLD,40) );
        deleteDocPanel1.add( lbDelDocHeader );

        // Creating btnState button:
        JButton btnState = new JButton("MENU");
        btnState.setFont( new Font("Arial",Font.BOLD,20) );
        btnState.setForeground( new Color(0xe9f3e5) );
        btnState.setBackground( new Color(0x525248) );
        btnState.setFocusable(false);

        // Creating deleteDocPanel2 with BorderLayout:
        JPanel deleteDocPanel2 = new JPanel();
        deleteDocPanel2.setLayout( new BorderLayout() );
        deleteDocPanel2.setBackground( new Color(0x393830) );

        // Creating deleteDocContentPanel with BorderLayout:
        deleteDocContentPanel = new JPanel();
        deleteDocContentPanel.setLayout( new BorderLayout() );
        deleteDocContentPanel.setBackground( new Color(0x393830) );

        // Creating delDocTitlePanel:
        JPanel delDocTitlePanel = new JPanel();
        delDocTitlePanel.setBackground( new Color(0xeb0000) );

        // Creating lbDelInfo1 and adding it to delDocTitlePanel:
        lbDelInfo1 = new JLabel("<html><body>DOCTOR DELETED!</body></html>");
        lbDelInfo1.setFont( new Font("Arial",Font.BOLD,24) );
        lbDelInfo1.setHorizontalAlignment(JLabel.CENTER);
        delDocTitlePanel.add(lbDelInfo1);

        // Adding delDocTitlePanel to deleteDocContentPanel - North:
        deleteDocContentPanel.add(delDocTitlePanel,BorderLayout.NORTH);

        // Creating lbDelInfo2 and adding it to deleteDocContentPanel - Center:
        lbDelInfo2 = new JLabel("");
        lbDelInfo2.setFont( new Font("Arial",Font.BOLD,20) );
        lbDelInfo2.setHorizontalAlignment(JLabel.CENTER);
        lbDelInfo2.setForeground(new Color(0xe9f3e5));
        deleteDocContentPanel.add(lbDelInfo2,BorderLayout.CENTER);

        // Creating docCountPanel:
        JPanel docCountPanel = new JPanel();
        docCountPanel.setBackground( new Color(0x3fd000) );

        // Creating lbDelInfo3 and adding it to docCountPanel:
        lbDelInfo3 = new JLabel("");
        lbDelInfo3.setFont( new Font("Arial",Font.BOLD,20) );
        lbDelInfo3.setHorizontalAlignment(JLabel.CENTER);
        docCountPanel.add(lbDelInfo3);

        // Adding docCountPanel to deleteDocContentPanel - South:
        deleteDocContentPanel.add(docCountPanel,BorderLayout.SOUTH);

        deleteDocContentPanel.setVisible(false);

        // Adding deleteDocContentPanel to deleteDocPanel2 - Center:
        deleteDocPanel2.add(deleteDocContentPanel,BorderLayout.CENTER);

        // Creating deleteDocPanel3 with GridLayout:
        JPanel deleteDocPanel3 = new JPanel();
        deleteDocPanel3.setLayout( new GridLayout(1,4,5,5) );
        deleteDocPanel3.setBackground( new Color(0x393830) );
        deleteDocPanel3.setBorder( BorderFactory.createLineBorder( new Color(0x393830),30 ) );

        // Adding the relevant components to deleteDocPanel3:
        JLabel lbMedLNumber = new JLabel("Medical licence number: ",JLabel.CENTER);
        lbMedLNumber.setFont( new Font("Arial",Font.BOLD,16) );
        lbMedLNumber.setForeground(new Color(0xe9f3e5));
        deleteDocPanel3.add( lbMedLNumber );
        txtMedLNumber = new JTextField(10);
        txtMedLNumber.setHorizontalAlignment(JTextField.CENTER);
        txtMedLNumber.setFont( new Font("Arial",Font.BOLD,20) );
        txtMedLNumber.setBackground(new Color(0xe9f3e5));
        deleteDocPanel3.add( txtMedLNumber );
        JButton btnDelete = new JButton("DELETE");
        btnDelete.setFont( new Font("Arial",Font.BOLD,20) );
        btnDelete.setForeground( new Color(0xe9f3e5) );
        btnDelete.setBackground( new Color(0x740000) );
        btnDelete.setBorder(BorderFactory.createLineBorder(new Color(0xeb0000),5,true));
        btnDelete.setFocusable(false);
        deleteDocPanel3.add( btnDelete );
        JButton btnReset = new JButton("RESET");
        btnReset.setFont( new Font("Arial",Font.BOLD,20) );
        btnReset.setForeground( new Color(0xe9f3e5) );
        btnReset.setBackground( new Color(0x003464) );
        btnReset.setBorder(BorderFactory.createLineBorder(new Color(0x368b5fd),5,true));
        btnReset.setFocusable(false);
        deleteDocPanel3.add( btnReset );

        // Adding deleteDocPanel3 to deleteDocPanel2 - North:
        deleteDocPanel2.add(deleteDocPanel3,BorderLayout.NORTH);

        Border innerDeleteDocPanel2Border = BorderFactory.createLineBorder( new Color(0x393830),100 );
        Border outerDeleteDocPanel2Border = BorderFactory.createLineBorder( new Color(0xe9f3e5),5 );
        deleteDocPanel2.setBorder( BorderFactory.createCompoundBorder( outerDeleteDocPanel2Border,innerDeleteDocPanel2Border ) );

        // Creating deleteDocPanelFinal with BorderLayout:
        JPanel deleteDocPanelFinal = new JPanel();
        deleteDocPanelFinal.setLayout( new BorderLayout() );

        // Adding deleteDocPanel1 to deleteDocPanelFinal - North:
        deleteDocPanelFinal.add( deleteDocPanel1,BorderLayout.NORTH );
        // Adding btnState to deleteDocPanelFinal - South:
        deleteDocPanelFinal.add( btnState,BorderLayout.SOUTH );
        // Adding deleteDocPanel2 to deleteDocPanelFinal - Center:
        deleteDocPanelFinal.add( deleteDocPanel2,BorderLayout.CENTER );

        // Adding deleteDocPanelFinal to frame:
        add(deleteDocPanelFinal);

        DelDocFrameButtonAction delDocFrameHandler = new DelDocFrameButtonAction();
        btnState.addActionListener(delDocFrameHandler);
        btnDelete.addActionListener(delDocFrameHandler);
        btnReset.addActionListener(delDocFrameHandler);
    }

    private class DelDocFrameButtonAction implements ActionListener {
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
            else if ( btnLabel.equals("DELETE") ) {
                deleteDoctor();
            }
            else if ( btnLabel.equals("RESET") ) {
                txtMedLNumber.setText("");
                deleteDocContentPanel.setVisible(false);
            }
        }
    }

    private void deleteDoctor() {
        String delDoctorInfo = "";
        int emptyIndexDocArray = 0;
        boolean invalidMLNo = true;
        for ( int x = 0; x < WestminsterSkinConsultationCentre.doctors.length; x = x + 1 ) {
            if ( WestminsterSkinConsultationCentre.doctors[x].getmLNumber().equalsIgnoreCase(txtMedLNumber.getText()) ) {
                invalidMLNo = false;
                delDoctorInfo = delDoctorInfo + "<html><body>Name: "+WestminsterSkinConsultationCentre.doctors[x].getFirstName()+" "+WestminsterSkinConsultationCentre.doctors[x].getSurname()+"<br>Date of birth: "+WestminsterSkinConsultationCentre.doctors[x].getDOB()+"<br>Mobile number: "+WestminsterSkinConsultationCentre.doctors[x].getMobileNumber()+"<br>Medical license number: "+WestminsterSkinConsultationCentre.doctors[x].getmLNumber()+"<br>Specialisation: "+WestminsterSkinConsultationCentre.doctors[x].getSpecialisation()+"</body></html>";
                WestminsterSkinConsultationCentre.doctors[x] = new Doctor();
                WestminsterSkinConsultationCentre.doctors[x].consultations.clear();
                WestminsterSkinConsultationCentre.doctors[x].consultDateTimeRanges.clear();
                break;
            }
            else if ( WestminsterSkinConsultationCentre.doctors[x].getmLNumber().equalsIgnoreCase("~") ) {
                emptyIndexDocArray = emptyIndexDocArray + 1;
            }
        }

        if ( emptyIndexDocArray == WestminsterSkinConsultationCentre.doctors.length ) {
            JOptionPane.showMessageDialog( null,"No doctors to delete from centre!","MESSAGE",JOptionPane.INFORMATION_MESSAGE );
        }
        else if ( invalidMLNo ){
            JOptionPane.showMessageDialog( null,"Invalid medical licence number (Try again)!","MESSAGE",JOptionPane.ERROR_MESSAGE );
        }
        else {
            deleteDocContentPanel.setVisible(true);
            lbDelInfo2.setText(delDoctorInfo);

            int availableDoctorCount = 0;
            for ( int y = 0; y < WestminsterSkinConsultationCentre.doctors.length; y = y + 1 ) {
                if ( WestminsterSkinConsultationCentre.doctors[y].getFirstName().equalsIgnoreCase("~") ) {
                    continue;
                }
                else {
                    availableDoctorCount = availableDoctorCount + 1;
                }
            }

            lbDelInfo3.setText("NUMBER OF REMAINING DOCTORS: "+availableDoctorCount);
        }
    }

}
