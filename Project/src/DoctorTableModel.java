import javax.swing.table.AbstractTableModel;

public class DoctorTableModel extends AbstractTableModel {
    private String[] columnNames = {"Medical licence No","First name","Surname","Date of birth","Mobile No","Specialisation"};
    private Doctor[] docList;

    public DoctorTableModel( Doctor[]doctors ) {
        this.docList = doctors;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return docList.length;
    }

    public Object getValueAt(int row,int column) {
        Object value = null;
        if ( column == 0 ) {
            value = docList[row].getmLNumber();
        }
        else if ( column == 1 ) {
            value = docList[row].getFirstName();
        }
        else if ( column == 2 ) {
            value = docList[row].getSurname();
        }
        else if ( column == 3 ) {
            value = docList[row].getDOB();
        }
        else if ( column == 4 ) {
            value = docList[row].getMobileNumber();
        }
        else if ( column == 5 ) {
            value = docList[row].getSpecialisation();
        }
        return value;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

}
