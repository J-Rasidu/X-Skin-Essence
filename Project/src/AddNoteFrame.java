import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNoteFrame extends JFrame {
    private JTextArea noteFrameTextArea;

    public AddNoteFrame() {
        // Creating topPanel and adding lbNoteHeader to it:
        JPanel topPanel = new JPanel();
        topPanel.setBackground( new Color(0x393830) );
        JLabel lbNoteHeader = new JLabel("NOTE");
        lbNoteHeader.setFont( new Font("Arial",Font.BOLD,20) );
        lbNoteHeader.setForeground( new Color(0xe9f3e5) );
        topPanel.add(lbNoteHeader);

        // Creating centerPanel and adding txtAreaNote with a scrollPane:
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground( new Color(0x393830) );
        noteFrameTextArea = new JTextArea(10,68);
        noteFrameTextArea.setBackground( new Color(0xe9f3e5) );
        JScrollPane txtAreaScroll = new JScrollPane(noteFrameTextArea);
        centerPanel.add(txtAreaScroll);

        // Creating bottomPanel with GridLayout:
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout( new GridLayout(1,2) );

        // Creating btnReset and adding it to bottomPanel:
        JButton btnReset = new JButton("RESET");
        btnReset.setFont( new Font("Arial",Font.BOLD,18) );
        btnReset.setForeground( new Color(0xe9f3e5) );
        btnReset.setBackground( new Color(0x740000) );
        btnReset.setBorder(BorderFactory.createLineBorder(new Color(0xeb0000),3,true));
        btnReset.setFocusable(false);
        bottomPanel.add( btnReset );

        // Creating btnSetNote and adding it to bottomPanel:
        JButton btnSetNote = new JButton("SET NOTE");
        btnSetNote.setFont( new Font("Arial",Font.BOLD,18) );
        btnSetNote.setForeground( new Color(0xe9f3e5) );
        btnSetNote.setBackground( new Color(0x2e1e57) );
        btnSetNote.setBorder(BorderFactory.createLineBorder(new Color(0xb4a7d6),3,true));
        btnSetNote.setFocusable(false);
        bottomPanel.add( btnSetNote );

        // Creating finalNotePanel with BorderLayout:
        JPanel finalNotePanel = new JPanel();
        finalNotePanel.setLayout( new BorderLayout() );
        // Adding topPanel to finalNotePanel - North:
        finalNotePanel.add(topPanel,BorderLayout.NORTH);
        // Adding centerPanel to finalNotePanel - Center:
        finalNotePanel.add(centerPanel,BorderLayout.CENTER);
        // Adding bottomPanel to finalNotePanel - Bottom:
        finalNotePanel.add(bottomPanel,BorderLayout.SOUTH);
        // Adding finalNotePanel to frame:
        add(finalNotePanel);

        AddNoteFrameButtonAction addNoteFrameHandler = new AddNoteFrameButtonAction();
        btnReset.addActionListener(addNoteFrameHandler);
        btnSetNote.addActionListener(addNoteFrameHandler);
    }

    private class AddNoteFrameButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String btnLabel = event.getActionCommand();
            if ( btnLabel.equals("RESET") ) {
                noteFrameTextArea.setText("");
            }
            else if ( btnLabel.equals("SET NOTE") ) {
                BookDocFrame.txtAreaNote.setText(noteFrameTextArea.getText());
                setVisible(false);
            }
        }
    }
}
