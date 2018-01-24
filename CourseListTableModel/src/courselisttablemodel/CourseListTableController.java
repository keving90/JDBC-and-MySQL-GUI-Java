
package courselisttablemodel;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

/**
 * Glue between the view (CourseListGUI) and the model (CourseListTableModel).
 * No database specific code here. Contains a reference to both the TableModel
 * and the GUI.
 * 
 * @author Kevin
 */

public class CourseListTableController implements ListSelectionListener, RowSetListener {
    
    private CourseListTableModel tableModel = null;
    private CourseListGUI gui;
    
    public CourseListTableController(CourseListGUI gui) {
        this.gui = gui;
        // Create the tableModel using the data in the cachedRowSet
        tableModel = new CourseListTableModel();
        tableModel.getRowSet().addRowSetListener(this);
    }
    
    // Get the table model
    public TableModel getTableModel() {
        return tableModel;
    }

    // Method from the ListSelectionListener Interface
    // Called whenever the value of the selection changes.
    public void valueChanged(ListSelectionEvent e) {
        // Prevent action from being performed twice
        // https://stackoverflow.com/questions/5865343/why-does-jtable-always-trigger-listselectionlistener-twice
        if (!e.getValueIsAdjusting()) {

            ListSelectionModel selectModel = (ListSelectionModel) e.getSource();

            int firstIndex = selectModel.getMinSelectionIndex();

            // Selection is empty
            if (firstIndex == -1)
                return;

            // Read the data in each column using getValue and display it on corresponding text field
            gui.setCourseNameTextField((String) tableModel.getValueAt(firstIndex, 0));
            gui.setCourseNumberTextField((String) tableModel.getValueAt(firstIndex, 1));
            gui.setEnrollmentTextField((String) tableModel.getValueAt(firstIndex, 2));
            gui.setStartDateTextField((String) tableModel.getValueAt(firstIndex, 3));
            gui.setEndDateTextField((String) tableModel.getValueAt(firstIndex, 4));
        }
    }

    // Add a row to the database using addRow() in CourseListTableModel
    public void addRow(String[] array) {
        tableModel.addRow(array);
    }

    // Delete a row to the database using deleteRow() in CourseListTableModel
    public void deleteRow(String[] array) {
        tableModel.deleteRow(array);
    }

    // Update a row to the database using updateRow() in CourseListTableModel
    public void updateRow(String[] array, JTable jtable) {
        tableModel.updateRow(array, jtable);
    }

    // Method from the RowSetListener Interface
    // Notifies registered listeners that a RowSet object has had a change in one of its rows.
    public void rowChanged(RowSetEvent event) {
        try {
            // Get the index of the inserted row
            // getRowSet() is a method in CourseListTableModel that returns a CachedRowSet object
            // getRow() is a method in ResultSet that returns the current row
            tableModel.getRowSet().moveToCurrentRow();
            int firstIndex = tableModel.getRowSet().getRow();

            // Create a new table model with the new data
            tableModel = new CourseListTableModel(tableModel.getRowSet(), tableModel.getConnection());

            //update the JTable with the data
            gui.updateTable();

            // Read the data in each column using getValueAt and display it on the corresponding text field
            gui.setCourseNameTextField((String) tableModel.getValueAt(firstIndex, 0));
            gui.setCourseNumberTextField((String) tableModel.getValueAt(firstIndex, 1));
            gui.setEnrollmentTextField((String) tableModel.getValueAt(firstIndex, 2));
            gui.setStartDateTextField((String) tableModel.getValueAt(firstIndex, 3));
            gui.setEndDateTextField((String) tableModel.getValueAt(firstIndex, 4));
        } catch (Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
        }
    }

    // Method from the RowSetListener Interface
    // Notifies registered listeners that a RowSet object's cursor has moved.
    public void cursorMoved(RowSetEvent event) { }

    // Method from the RowSetListener Interface
    // Notifies registered listeners that a RowSet object in the given RowSetEvent object has changed its entire contents.
    public void rowSetChanged(RowSetEvent event) { }
    
}
