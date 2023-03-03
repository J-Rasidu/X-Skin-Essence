import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class ConsultationFrame extends JFrame {
    private int key = 1;

    public ConsultationFrame() {
        // Creating EventHandler:
        ConsultationFrameButtonAction consultationFrameHandler = new ConsultationFrameButtonAction();

        // Creating consultationPanel1:
        JPanel consultationPanel1 = new JPanel();
        consultationPanel1.setBackground( new Color(0x8fa785) );
        Border conP1Border = BorderFactory.createLineBorder( new Color(0xe9f3e5),5 );
        consultationPanel1.setBorder( conP1Border );

        // Creating lbConHeader and adding it to consultationPanel1:
        JLabel lbConHeader = new JLabel("CONSULTATIONS");
        lbConHeader.setFont( new Font("Arial",Font.BOLD,40) );
        consultationPanel1.add( lbConHeader );

        // Creating btnState button:
        JButton btnState = new JButton("MENU");
        btnState.setFont( new Font("Arial",Font.BOLD,20) );
        btnState.setForeground( new Color(0xe9f3e5) );
        btnState.setBackground( new Color(0x525248) );
        btnState.setFocusable(false);

        // Creating consultationPanel2:
        JPanel consultationPanel2 = new JPanel();
        consultationPanel2.setBackground( new Color(0x393830) );
        consultationPanel2.setLayout( new GridLayout(consultationRowCount(),1,6,0) );
        Border innerConsultationPanel2Border = BorderFactory.createLineBorder( new Color(0x393830),50 );
        Border outerConsultationPanel2Border = BorderFactory.createLineBorder( new Color(0xe9f3e5),5 );
        consultationPanel2.setBorder( BorderFactory.createCompoundBorder( outerConsultationPanel2Border,innerConsultationPanel2Border ) );

        int absentDocCount = 0;
        int noConsultationCount = 0;
        for ( int a = 0; a < WestminsterSkinConsultationCentre.doctors.length; a = a + 1 ) {
            if ( !( WestminsterSkinConsultationCentre.doctors[a].getFirstName().equalsIgnoreCase("~") ) ) {
                if ( WestminsterSkinConsultationCentre.doctors[a].consultations.size() > 0 ) {
                    for ( int x = 0; x < WestminsterSkinConsultationCentre.doctors[a].consultations.size(); x = x + 1 ) {

                        String dateTimeParts[] = WestminsterSkinConsultationCentre.doctors[a].consultations.get(x).getDateAndTime().split(" / ");

                        String conBtnText = "<html><body>Doctor's name: "+WestminsterSkinConsultationCentre.doctors[a].getFirstName()+" "+WestminsterSkinConsultationCentre.doctors[a].getSurname()+"<br>Patient ID: "+WestminsterSkinConsultationCentre.doctors[a].consultations.get(x).patient.getPatientId()+"<br>"+localToSimpleDateTime(dateTimeParts)+"</body></html>";

                        WestminsterSkinConsultationCentre.doctors[a].consultations.get(x).btnConsultation = new JButton(conBtnText);
                        WestminsterSkinConsultationCentre.doctors[a].consultations.get(x).btnConsultation.setFont( new Font("Arial",Font.BOLD,20) );
                        WestminsterSkinConsultationCentre.doctors[a].consultations.get(x).btnConsultation.setForeground( new Color(0xe9f3e5) );
                        WestminsterSkinConsultationCentre.doctors[a].consultations.get(x).btnConsultation.setBackground( new Color(0x525248) );
                        WestminsterSkinConsultationCentre.doctors[a].consultations.get(x).btnConsultation.setBorder( BorderFactory.createLineBorder(new Color(0x8fa785),2) );
                        WestminsterSkinConsultationCentre.doctors[a].consultations.get(x).btnConsultation.setFocusable(false);

                        // Register btnConsultation to event handler:
                        WestminsterSkinConsultationCentre.doctors[a].consultations.get(x).btnConsultation.addActionListener(consultationFrameHandler);
                        // Adding btnConsultation to consultationPanel2:
                        consultationPanel2.add( WestminsterSkinConsultationCentre.doctors[a].consultations.get(x).btnConsultation );
                    }
                }
                else {
                    noConsultationCount = noConsultationCount + 1;
                }
            }
            else {
                absentDocCount = absentDocCount + 1;
            }
        }
        if ( absentDocCount == WestminsterSkinConsultationCentre.doctors.length ) {
            JLabel lbNoConsultations = new JLabel("NO DOCTORS AT THE CENTRE!");
            lbNoConsultations.setFont( new Font("Arial",Font.BOLD,38) );
            lbNoConsultations.setHorizontalAlignment(JLabel.CENTER);
            lbNoConsultations.setForeground( new Color(0xeb0000) );
            consultationPanel2.add(lbNoConsultations);
        }
        else if ( (absentDocCount + noConsultationCount) == WestminsterSkinConsultationCentre.doctors.length ) {
            JLabel lbNoConsultations = new JLabel("NO CONSULTATIONS HAS BEEN ALLOCATED YET!");
            lbNoConsultations.setFont( new Font("Arial",Font.BOLD,38) );
            lbNoConsultations.setHorizontalAlignment(JLabel.CENTER);
            lbNoConsultations.setForeground( new Color(0xeb0000) );
            consultationPanel2.add(lbNoConsultations);
        }
        JScrollPane consultationScroll = new JScrollPane(consultationPanel2);


        // Creating consultationPanelFinal with BorderLayout:
        JPanel consultationPanelFinal = new JPanel();
        consultationPanelFinal.setLayout( new BorderLayout() );

        // Adding consultationPanel1 to consultationPanelFinal - North:
        consultationPanelFinal.add( consultationPanel1,BorderLayout.NORTH );
        // Adding btnState to consultationPanelFinal - South:
        consultationPanelFinal.add( btnState,BorderLayout.SOUTH );
        // Adding consultationPanel2 to consultationPanelFinal - Center:
        consultationPanelFinal.add( consultationScroll,BorderLayout.CENTER );

        // Adding consultationPanelFinal to frame:
        add(consultationPanelFinal);

        // Register btnState to event handler:
        btnState.addActionListener(consultationFrameHandler);
    }

    private class ConsultationFrameButtonAction implements ActionListener {
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

            boolean exitOuter = false;
            for ( int b = 0; b < WestminsterSkinConsultationCentre.doctors.length; b = b + 1 ) {
                if ( !( WestminsterSkinConsultationCentre.doctors[b].getFirstName().equalsIgnoreCase("~") ) ) {
                    if ( WestminsterSkinConsultationCentre.doctors[b].consultations.size() > 0 ) {
                        for ( int y = 0; y < WestminsterSkinConsultationCentre.doctors[b].consultations.size(); y = y + 1 ) {
                            if ( event.getSource() == WestminsterSkinConsultationCentre.doctors[b].consultations.get(y).btnConsultation ) {

                                String conDateTimeParts[] = WestminsterSkinConsultationCentre.doctors[b].consultations.get(y).getDateAndTime().split(" / ");

                                String encryptedNote = WestminsterSkinConsultationCentre.doctors[b].consultations.get(y).getNote();
                                char[] decryptNoteChars = encryptedNote.toCharArray();
                                String decryptNote = "";
                                for ( char z : decryptNoteChars ) {
                                    z -= key;
                                    decryptNote = decryptNote + z;
                                }

                                String info1 = "";
                                info1 = info1 + "<html><body><br>Doctor's name: "+WestminsterSkinConsultationCentre.doctors[b].getFirstName()+" "+WestminsterSkinConsultationCentre.doctors[b].getSurname()+"<br><br>Patient Details:<br><br>ID: "+WestminsterSkinConsultationCentre.doctors[b].consultations.get(y).patient.getPatientId()+"<br>Name: "+WestminsterSkinConsultationCentre.doctors[b].consultations.get(y).patient.getFirstName()+" "+WestminsterSkinConsultationCentre.doctors[b].consultations.get(y).patient.getSurname()+"<br>Date of birth: "+WestminsterSkinConsultationCentre.doctors[b].consultations.get(y).patient.getDOB()+"<br>Mobile number: "+WestminsterSkinConsultationCentre.doctors[b].consultations.get(y).patient.getMobileNumber()+"<br>Time slot: "+localToSimpleDateTime(conDateTimeParts)+"<br>Cost: "+WestminsterSkinConsultationCentre.doctors[b].consultations.get(y).getCost()+"<br><br>NOTE: <br><br></body></html>";
                                ConsultationInfoFrame.lbText1 = info1;

                                ConsultationInfoFrame.lbText2 = decryptNote;

                                ConsultationInfoFrame infoFrame = new ConsultationInfoFrame();
                                infoFrame.setTitle("CONSULTATION DETAILS");
                                infoFrame.setDefaultCloseOperation(ConsultationInfoFrame.HIDE_ON_CLOSE);
                                infoFrame.setLocation(500,0);
                                infoFrame.setSize(550,680);
                                infoFrame.setVisible(true);
                                infoFrame.setResizable(false);
                                ImageIcon logoIcon = new ImageIcon("Logo.png");
                                infoFrame.setIconImage(logoIcon.getImage());

                                exitOuter = true;
                                break;
                            }
                        }
                    }
                }
                if ( exitOuter ) {
                    break;
                }
            }
        }
    }

    private int consultationRowCount() {
        int conRowCount = 0;
        for ( int a = 0; a < WestminsterSkinConsultationCentre.doctors.length; a = a + 1 ) {
            if ( !( WestminsterSkinConsultationCentre.doctors[a].getFirstName().equalsIgnoreCase("~") ) ) {
                if ( WestminsterSkinConsultationCentre.doctors[a].consultations.size() > 0 ) {
                    for ( int x = 0; x < WestminsterSkinConsultationCentre.doctors[a].consultations.size(); x = x + 1 ) {
                        conRowCount = conRowCount + 1;
                    }
                }
            }
        }
        return conRowCount;
    }

    private String localToSimpleDateTime( String[] dateTimeParts ) {
        DateTimeFormatter formatRandomPattern = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        String localDateTimeStart = dateTimeParts[0];
        LocalDateTime dTStart = LocalDateTime.parse(localDateTimeStart,formatRandomPattern);
        String localDateTimeEnd = dateTimeParts[1];
        LocalDateTime dTEnd = LocalDateTime.parse(localDateTimeEnd,formatRandomPattern);

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm");
        String dateTimeStart = dateFormat.format( Date.from(dTStart.atZone(ZoneId.systemDefault()).toInstant()) );
        String dateTimeEnd = dateFormat.format( Date.from(dTEnd.atZone(ZoneId.systemDefault()).toInstant()) );

        String timeSlot = "From "+dateTimeStart+" - "+dateTimeEnd;
        return timeSlot;
    }
}
