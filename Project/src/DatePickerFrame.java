import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatePickerFrame extends JFrame {

    private String findDatePickerFrame = "";

    JButton[] btn = new JButton[49];
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
    JLabel lbl = new JLabel("",JLabel.CENTER);

    public DatePickerFrame( String fDPFrame ) {
        buildGUI();
        setDates();
        findDatePickerFrame = fDPFrame;
    }

    public void buildGUI() {
        setLocation(300,100);
        setDefaultCloseOperation(DatePickerFrame.HIDE_ON_CLOSE);
        ImageIcon logoIcon = new ImageIcon("Logo.png");
        setIconImage(logoIcon.getImage());
        String[] header = {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
        JPanel midPanel = new JPanel(new GridLayout(7,7));
        midPanel.setPreferredSize(new Dimension(400,400));

        for(int x = 0; x < btn.length; x = x + 1)
        {
            final int selection = x;
            btn[x] = new JButton();
            btn[x].setFont(new Font("Arial",Font.BOLD,15));
            btn[x].setFocusPainted(false);
            btn[x].setForeground( new Color(0xe9f3e5) );
            btn[x].setBackground( new Color(0x525248) );
            btn[x].setBorder(BorderFactory.createLineBorder(new Color(0x8fa785),3));

            if( x > 6 ) {
                btn[x].addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        displayDatePicked(btn[selection].getActionCommand());
                    }
                } );
            }

            if( x < 7 ) {
                btn[x].setText(header[x]);
                btn[x].setFont(new Font("Arial",Font.BOLD,10));
                btn[x].setForeground( Color.black );
                btn[x].setBackground( new Color(0xe9f3e5) );
                btn[x].setBorder(BorderFactory.createLineBorder(new Color(0x4d4d46),3));
                btn[x].setFocusable(false);
            }
            midPanel.add( btn[x] );
        }

        JPanel lowPanel = new JPanel(new GridLayout(1,3));
        JButton prevBtn = new JButton("<< Previous");
        prevBtn.setFont( new Font("Arial",Font.BOLD,15) );
        prevBtn.setForeground(Color.black);
        prevBtn.setBackground(new Color(0xff8218));
        prevBtn.setFocusable(false);

        prevBtn.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                month = month - 1;
                setDates();
            }
        } );

        lowPanel.add(prevBtn);
        lbl.setFont( new Font("Arial",Font.BOLD,15) );
        lowPanel.add(lbl);
        JButton nextBtn = new JButton("Next >>");
        nextBtn.setFont( new Font("Arial",Font.BOLD,15) );
        nextBtn.setForeground(Color.black);
        nextBtn.setBackground(new Color(0xff8218));
        nextBtn.setFocusable(false);

        nextBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                month = month + 1;
                setDates();
            }
        } );

        lowPanel.add(nextBtn);
        add(midPanel,BorderLayout.CENTER);
        add(lowPanel,BorderLayout.SOUTH);
        pack();

    }

    public void setDates() {
        for(int x = 7; x < btn.length; x = x + 1) {
            btn[x].setText("");
        }

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year,month,1);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        for( int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x = x + 1,day = day + 1 ) {
            btn[x].setText(""+day);
        }

        lbl.setText(sdf.format(cal.getTime()));
        setTitle("Date Picker  - "+lbl.getText());
    }

    public void displayDatePicked(String day) {
        if(day.equals("") == false)
        {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("YYYY/MM/dd");
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.set(year,month,Integer.parseInt(day));
            String pickedDate = sdf.format(cal.getTime());

            if ( findDatePickerFrame.equals("AddDocFrame") ) {
                AddDocFrame.txtDocDateOfBirth.setText(pickedDate);
                setVisible(false);
            }
            else if ( findDatePickerFrame.equals("BookDocFrame-1") ) {
                BookDocFrame.txtDate.setText(pickedDate);
                setVisible(false);
            }
            else if ( findDatePickerFrame.equals("BookDocFrame-2") ) {
                BookDocFrame.txtPatientDateOfBirth.setText(pickedDate);
                setVisible(false);
            }

        }
    }

}
