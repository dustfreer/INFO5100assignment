package assignment8;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentInformationSystem implements TableModel{
	private StudentsManagerImpl manager;

	public StudentInformationSystem(StudentsManagerImpl manager) {
		this.manager = manager;
	}

	public int getRowCount() {
		return manager.getStudentCount();
	}

	public int getColumnCount() {
		return 2;
	}

	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "Roll Number";
		} else {
			return "Name";
		}
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return false;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Student s = manager.getStudents().get(rowIndex);
		if (columnIndex == 0) {
			return s.getId();
		} else {
			return s.getName();
		}

	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}

	public void addTableModelListener(TableModelListener l) {
	}

	public void removeTableModelListener(TableModelListener l) {

	}

}
