import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class DoctorFrame extends JFrame {
    private static Doctor[] selectedArray = WestminsterSkinConsultationCentre.doctors;

    public DoctorFrame() {
        // Creating doctorPanel1:
        JPanel doctorPanel1 = new JPanel();
        doctorPanel1.setBackground( new Color(0x8fa785) );
        Border docP1Border = BorderFactory.createLineBorder( new Color(0xe9f3e5),5 );
        doctorPanel1.setBorder( docP1Border );

        // Creating lbDocHeader and adding it to doctorPanel1:
        JLabel lbDocHeader = new JLabel("DOCTORS");
        lbDocHeader.setFont( new Font("Arial",Font.BOLD,40) );
        doctorPanel1.add( lbDocHeader );

        // Creating btnState button:
        JButton btnState = new JButton("MENU");
        btnState.setFont( new Font("Arial",Font.BOLD,20) );
        btnState.setForeground( new Color(0xe9f3e5) );
        btnState.setBackground( new Color(0x525248) );
        btnState.setFocusable(false);

        // Creating doctorPanel2 with BorderLayout:
        JPanel doctorPanel2 = new JPanel();
        doctorPanel2.setLayout( new BorderLayout() );
        doctorPanel2.setBackground( new Color(0x393830) );

        // Creating docTablePanel:
        JPanel docTablePanel = new JPanel();
        docTablePanel.setBackground( new Color(0x393830) );

        // Creating docTableModel:
        DoctorTableModel docTableModel = new DoctorTableModel(selectedArray);
        // Creating a docTable with docTableModel:
        JTable docTable = new JTable(docTableModel);
        // Customizing docTable:
        docTable.setFont( new Font("Arial",Font.BOLD,15) );
        docTable.setForeground( new Color(0xe9f3e5) );
        docTable.setBackground( new Color(0x525248) );
        docTable.setGridColor( new Color(0x8fa785) );
        // Center alignment of text in every column in docTable:
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for ( int c = 0; c < docTableModel.getColumnCount(); c = c + 1 ) {
            docTable.getColumnModel().getColumn(c).setCellRenderer(centerRenderer);
        }
        // Setting the height of rows in docTable:
        docTable.setRowHeight(40);
        // Setting some columns widths:
        docTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        docTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        docTable.getColumnModel().getColumn(5).setPreferredWidth(220);
        // Creating docScrollPane and passing docTable to it:
        JScrollPane docScrollPane = new JScrollPane(docTable);
        // Resizing the docScrollPane:
        docScrollPane.setPreferredSize( new Dimension(840,425) );
        // Adding docScrollPane to docTablePanel:
        docTablePanel.add(docScrollPane);
        // Adding docTablePanel to doctorPanel2 - Center:
        doctorPanel2.add(docTablePanel,BorderLayout.CENTER);

        // Creating docSortPanel with GridLayout:
        JPanel docSortPanel = new JPanel();
        docSortPanel.setBackground( new Color(0x393830) );
        docSortPanel.setLayout( new GridLayout(1,4) );

        // Adding relevant components to docSortPanel:
        JButton btnReset = new JButton("RESET");
        btnReset.setFont( new Font("Arial",Font.BOLD,20) );
        btnReset.setForeground( new Color(0xe9f3e5) );
        btnReset.setBackground( new Color(0x740000) );
        btnReset.setBorder(BorderFactory.createLineBorder(new Color(0xeb0000),3,true));
        btnReset.setFocusable(false);
        docSortPanel.add(btnReset);

        JLabel lbEmpty1 = new JLabel("");
        docSortPanel.add(lbEmpty1);
        JLabel lbEmpty2 = new JLabel("");
        docSortPanel.add(lbEmpty2);

        JButton btnSort = new JButton("SORT");
        btnSort.setFont( new Font("Arial",Font.BOLD,20) );
        btnSort.setForeground( new Color(0xe9f3e5) );
        btnSort.setBackground( new Color(0x7f6000) );
        btnSort.setBorder(BorderFactory.createLineBorder(new Color(0xff7500),3,true));
        btnSort.setFocusable(false);
        docSortPanel.add(btnSort);

        // Adding docSortPanel to doctorPanel2 - Center:
        doctorPanel2.add(docSortPanel,BorderLayout.NORTH);

        // Creating doctorPanelFinal with BorderLayout:
        JPanel doctorPanelFinal = new JPanel();
        doctorPanelFinal.setLayout( new BorderLayout() );

        // Adding doctorPanel1 to doctorPanelFinal - North:
        doctorPanelFinal.add( doctorPanel1,BorderLayout.NORTH );
        // Adding btnState to doctorPanelFinal - South:
        doctorPanelFinal.add( btnState,BorderLayout.SOUTH );
        // Adding doctorPanel2 to doctorPanelFinal - Center:
        doctorPanelFinal.add( doctorPanel2,BorderLayout.CENTER );

        // Adding doctorPanelFinal to frame:
        add(doctorPanelFinal);

        DoctorFrameButtonAction doctorFrameHandler = new DoctorFrameButtonAction();
        btnState.addActionListener(doctorFrameHandler);
        btnReset.addActionListener(doctorFrameHandler);
        btnSort.addActionListener(doctorFrameHandler);
    }

    private class DoctorFrameButtonAction implements ActionListener {
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
            else if ( btnLabel.equals("SORT") ) {
                Doctor[] printDocArray = WestminsterSkinConsultationCentre.doctors.clone();

                Arrays.sort(printDocArray);
                selectedArray = printDocArray;

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
            else if ( btnLabel.equals("RESET") ) {
                selectedArray = WestminsterSkinConsultationCentre.doctors;

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
        }
    }

}
