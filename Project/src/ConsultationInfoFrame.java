import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ConsultationInfoFrame extends JFrame {
    public static String lbText1 = "";
    public static String lbText2 = "";

    public ConsultationInfoFrame() {
        // Creating conInfoHeaderPanel and adding lbConInfoHeader to it:
        JPanel conInfoHeaderPanel = new JPanel();
        conInfoHeaderPanel.setBackground( new Color(0x393830) );
        JLabel lbConInfoHeader = new JLabel("CONSULTATION DETAILS");
        lbConInfoHeader.setHorizontalAlignment(JLabel.CENTER);
        lbConInfoHeader.setFont( new Font("Arial",Font.BOLD,20) );
        lbConInfoHeader.setForeground( new Color(0xe9f3e5) );
        conInfoHeaderPanel.add(lbConInfoHeader);

        // Creating conInfoPanel with GridLayout:
        JPanel conInfoPanel = new JPanel();
        conInfoPanel.setLayout( new GridLayout(2,1) );
        conInfoPanel.setBackground( new Color(0x8fa785) );
        conInfoPanel.setBorder( BorderFactory.createLineBorder( new Color(0x393830),7 ) );

        // Create lbContent and add it to conInfoPanel:
        JLabel lbContent = new JLabel(lbText1);
        lbContent.setHorizontalAlignment(JLabel.CENTER);
        lbContent.setFont( new Font("Arial",Font.BOLD,20) );
        lbContent.setForeground( Color.black );
        conInfoPanel.add(lbContent);

        // Creating txtAreaNoteContent and adding it to conNoteScrollPane:
        JTextArea txtAreaNoteContent = new JTextArea(lbText2);
        txtAreaNoteContent.setFont( new Font("Arial",Font.BOLD,20) );
        txtAreaNoteContent.setEditable(false);
        txtAreaNoteContent.setForeground( new Color(0x393830) );
        txtAreaNoteContent.setLineWrap(true);
        txtAreaNoteContent.setWrapStyleWord(true);
        // Creating conNoteScrollPane:
        JScrollPane conNoteScrollPane = new JScrollPane(txtAreaNoteContent);
        // Adding conNoteScrollPane to conInfoPanel:
        conInfoPanel.add(conNoteScrollPane);

        // Creating conInfoFinalPanel with BorderLayout:
        JPanel conInfoFinalPanel = new JPanel();
        conInfoFinalPanel.setLayout( new BorderLayout() );
        // Adding conInfoHeaderPanel to conInfoFinalPanel - North:
        conInfoFinalPanel.add(conInfoHeaderPanel,BorderLayout.NORTH);
        // Adding conInfoPanel to conInfoFinalPanel - Center:
        conInfoFinalPanel.add(conInfoPanel,BorderLayout.CENTER);

        // Adding conInfoFinalPanel to frame:
        add(conInfoFinalPanel);
    }
}
