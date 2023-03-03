import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimePickerFrame extends JFrame {
    private String hourCountString;
    private String minuteCountString;
    private int hourCount = 0;
    private int minuteCount = 0;
    private JButton hourIncreaseBtn;
    private JButton minuteIncreaseBtn;
    private JButton hourDecreaseBtn;
    private JButton minuteDecreaseBtn;
    private JTextField txtTimeDisplay;
    private JButton btnReset;
    private JButton btnSetTime;

    public TimePickerFrame() {
        // Creating timePickerPanel with GridLayout:
        JPanel timePickerPanel = new JPanel();
        timePickerPanel.setLayout( new GridLayout(4,1) );

        // Creating increaseBtnPanel with GridLayout:
        JPanel increaseBtnPanel = new JPanel();
        increaseBtnPanel.setLayout( new GridLayout(1,2));

        // Creating hourIncreaseBtn and adding it to increaseBtnPanel:
        hourIncreaseBtn = new JButton("^");
        hourIncreaseBtn.setFont( new Font("Arial",Font.BOLD,20) );
        hourIncreaseBtn.setForeground( new Color(0xe9f3e5) );
        hourIncreaseBtn.setBackground( new Color(0x7f6000) );
        hourIncreaseBtn.setBorder(BorderFactory.createLineBorder(new Color(0xff7500),2,true));
        hourIncreaseBtn.setFocusable(false);
        increaseBtnPanel.add(hourIncreaseBtn);

        // Creating minuteIncreaseBtn and adding it to increaseBtnPanel:
        minuteIncreaseBtn = new JButton("^");
        minuteIncreaseBtn.setFont( new Font("Arial",Font.BOLD,20) );
        minuteIncreaseBtn.setForeground( new Color(0xe9f3e5) );
        minuteIncreaseBtn.setBackground( new Color(0x7f6000) );
        minuteIncreaseBtn.setBorder(BorderFactory.createLineBorder(new Color(0xff7500),2,true));
        minuteIncreaseBtn.setFocusable(false);
        increaseBtnPanel.add(minuteIncreaseBtn);

        // Adding increaseBtnPanel to timePickerPanel:
        timePickerPanel.add(increaseBtnPanel);

        // Creating txtTimeDisplay as Uneditable TextField and adding it to timePickerPanel:
        hourCountString = String.format("%02d", hourCount);
        minuteCountString = String.format("%02d", minuteCount);

        txtTimeDisplay = new JTextField(hourCountString+":"+minuteCountString,5);
        txtTimeDisplay.setFont( new Font("Arial",Font.BOLD,20) );
        txtTimeDisplay.setHorizontalAlignment(JTextField.CENTER);
        txtTimeDisplay.setForeground( Color.black );
        txtTimeDisplay.setBackground( new Color(0xe9f3e5) );
        txtTimeDisplay.setEditable(false);
        timePickerPanel.add(txtTimeDisplay);

        // Creating decreaseBtnPanel with GridLayout:
        JPanel decreaseBtnPanel = new JPanel();
        decreaseBtnPanel.setLayout( new GridLayout(1,2));

        // Creating hourDecreaseBtn and adding it to decreaseBtnPanel:
        hourDecreaseBtn = new JButton("V");
        hourDecreaseBtn.setFont( new Font("Arial",Font.BOLD,15) );
        hourDecreaseBtn.setForeground( new Color(0xe9f3e5) );
        hourDecreaseBtn.setBackground( new Color(0x610039) );
        hourDecreaseBtn.setBorder(BorderFactory.createLineBorder(new Color(0xc80075),2,true));
        hourDecreaseBtn.setFocusable(false);
        decreaseBtnPanel.add(hourDecreaseBtn);

        // Creating minuteDecreaseBtn and adding it to decreaseBtnPanel:
        minuteDecreaseBtn = new JButton("V");
        minuteDecreaseBtn.setFont( new Font("Arial",Font.BOLD,15) );
        minuteDecreaseBtn.setForeground( new Color(0xe9f3e5) );
        minuteDecreaseBtn.setBackground( new Color(0x610039) );
        minuteDecreaseBtn.setBorder(BorderFactory.createLineBorder(new Color(0xc80075),2,true));
        minuteDecreaseBtn.setFocusable(false);
        decreaseBtnPanel.add(minuteDecreaseBtn);

        // Adding decreaseBtnPanel to timePickerPanel:
        timePickerPanel.add(decreaseBtnPanel);

        // Creating setTimeOptionPanel with GridLayout:
        JPanel setTimeOptionPanel = new JPanel();
        setTimeOptionPanel.setLayout( new GridLayout(1,2) );

        // Creating btnReset and adding it to setTimeOptionPanel:
        btnReset = new JButton("RESET");
        btnReset.setFont(new Font("Arial",Font.BOLD,15));
        btnReset.setFocusPainted(false);
        btnReset.setForeground( new Color(0xe9f3e5) );
        btnReset.setBackground( new Color(0x003464) );
        btnReset.setBorder(BorderFactory.createLineBorder(new Color(0x368b5fd),3,true));
        setTimeOptionPanel.add(btnReset);

        // Creating btnSetTime and adding it to setTimeOptionPanel:
        btnSetTime = new JButton("SET TIME");
        btnSetTime.setFont(new Font("Arial",Font.BOLD,15));
        btnSetTime.setFocusPainted(false);
        btnSetTime.setForeground( new Color(0xe9f3e5) );
        btnSetTime.setBackground( new Color(0x36492e) );
        btnSetTime.setBorder(BorderFactory.createLineBorder(new Color(0x3fd000),3,true));
        setTimeOptionPanel.add(btnSetTime);

        // Adding setTimeOptionPanel to timePickerPanel:
        timePickerPanel.add(setTimeOptionPanel);

        // Adding timePickerPanel to frame:
        add(timePickerPanel);

        TimePickerFrameBtnAction timePickerFrameHandler = new TimePickerFrameBtnAction();
        hourIncreaseBtn.addActionListener(timePickerFrameHandler);
        hourDecreaseBtn.addActionListener(timePickerFrameHandler);
        minuteIncreaseBtn.addActionListener(timePickerFrameHandler);
        minuteDecreaseBtn.addActionListener(timePickerFrameHandler);
        btnReset.addActionListener(timePickerFrameHandler);
        btnSetTime.addActionListener(timePickerFrameHandler);
    }

    private class TimePickerFrameBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if ( hourCount < 23 ) {
                if (  event.getSource() == hourIncreaseBtn ) {
                    hourCount = hourCount + 1;
                    hourCountString = String.format("%02d", hourCount);
                    minuteCountString = String.format("%02d", minuteCount);
                    txtTimeDisplay.setText(hourCountString+":"+minuteCountString);
                }
            }

            if ( 0 < hourCount ) {
                if (  event.getSource() == hourDecreaseBtn ) {
                    hourCount = hourCount - 1;
                    hourCountString = String.format("%02d", hourCount);
                    minuteCountString = String.format("%02d", minuteCount);
                    txtTimeDisplay.setText(hourCountString+":"+minuteCountString);
                }
            }

            if ( minuteCount < 59 ) {
                if (  event.getSource() == minuteIncreaseBtn ) {
                    minuteCount = minuteCount + 1;
                    hourCountString = String.format("%02d", hourCount);
                    minuteCountString = String.format("%02d", minuteCount);
                    txtTimeDisplay.setText(hourCountString+":"+minuteCountString);
                }
            }

            if ( 0 < minuteCount ) {
                if (  event.getSource() == minuteDecreaseBtn ) {
                    minuteCount = minuteCount - 1;
                    hourCountString = String.format("%02d", hourCount);
                    minuteCountString = String.format("%02d", minuteCount);
                    txtTimeDisplay.setText(hourCountString+":"+minuteCountString);
                }
            }

            if (  event.getSource() == btnReset ) {
                hourCount = 0;
                minuteCount = 0;
                hourCountString = String.format("%02d", hourCount);
                minuteCountString = String.format("%02d", minuteCount);
                txtTimeDisplay.setText(hourCountString+":"+minuteCountString);
            }

            if (  event.getSource() == btnSetTime ) {
                BookDocFrame.txtTime.setText(txtTimeDisplay.getText());
                setVisible(false);
            }

        }
    }

}
