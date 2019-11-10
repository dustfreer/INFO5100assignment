package assignment8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class UniversityFrame extends JFrame {
	private JLabel rollLabel, nameLabel;
	private JTextField rollText, nameText;
	private String hintOfRollText, hintOfNameText;
	private JButton add, modify, delete, find;
	private JTable studentsTable;
	private StudentInformationSystem model;
	private StudentsManagerImpl studentManager;

	UniversityFrame() {
		create();
		Container con = getContentPane();
		add(con);
		addListeners();
		makeItVisible();
	}

	public void create() {
		rollLabel = new JLabel("Enter Roll Number : ");
		nameLabel = new JLabel("Enter Student Name : ");
		
		add = new JButton("Add");
		modify = new JButton("Modify");
		delete = new JButton("Delete");
		find = new JButton("Find");
		
		hintOfRollText = "Input Roll Number here:";
		rollText = new HintTextField(hintOfRollText);
		hintOfNameText = "Input Student Name here:";
		nameText = new HintTextField(hintOfNameText);
		setTextHint();
		try {
			studentManager = new StudentsManagerImpl();
			model = new StudentInformationSystem(studentManager);
		} catch (Exception e) {
		}

		studentsTable = new JTable(model);
	}
	
	public void setTextHint() {
		rollText.setText(hintOfRollText);
		rollText.setHorizontalAlignment(JTextField.CENTER);
		rollText.setForeground(Color.gray);
		nameText.setText(hintOfNameText);
		nameText.setHorizontalAlignment(JTextField.CENTER);
		nameText.setForeground(Color.gray);
	}

	public void add(Container con) {
		BorderLayout b = new BorderLayout();
		con.setLayout(b);
		con.add(new JScrollPane(studentsTable), "South");
		addComponent(con);
	}
	
	public void addComponent(Container con) {
		JPanel p = new JPanel(new GridLayout(3,2));
		p.add(rollText);
		p.add(nameText);
		p.add(add);
		p.add(modify);
		p.add(delete);
		p.add(find);
		con.add(p, BorderLayout.NORTH);

	}
	
	public Student getText(Student s) {
		if ( !rollText.getText().isEmpty()) {
			try {
				int a = Integer.parseInt(rollText.getText());
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(this, "Please input numbers instead of letters");
				throw e;
			}
		}
		
		s.setId(rollText.getText());
		s.setName(nameText.getText());
		return s;
	}
	
	public void addStudent() {
		Student s = new Student();
		s = getText(s);
		studentManager.addStudent(s);
		studentsTable.updateUI();
		setTextHint();
		JOptionPane.showMessageDialog(this, "the student "+ s.getId() + " is successfully added!");
	}
	
	public void findStudent() {
		Student s = new Student();
		s = getText(s);
		String name = s.getName();
		s = studentManager.findStudent(s.getName());
		if ( s != null) {
			JOptionPane.showMessageDialog(this, "Studend id: "+ s.getId() + ", Student name: "+ s.getName());
		}else {
			JOptionPane.showMessageDialog(this, "can not find the student "+ name +"!");
		}
		setTextHint();
	}
	
	public void modifyStudent() {
		Student s = new Student();
		s = getText(s);
		
		if (studentManager.modifyStudent(s.getId(),s)) {
			JOptionPane.showMessageDialog(this, "the student "+ s.getId() + " is successfully modified!");
		}else {
			JOptionPane.showMessageDialog(this, "can not find the student id "+ s.getId() +"!");
		}
		studentsTable.updateUI();
		setTextHint();
	}
	
	public void deleteStudent() {
		Student s = new Student();
		s = getText(s);
		studentManager.deleteStudent(s.getId());
		studentsTable.updateUI();
		JOptionPane.showMessageDialog(this, "the student "+ s.getId() + " is successfully removed!");
		setTextHint();
	}

	public void addListeners() {
		add.addActionListener((e) -> addStudent()); 
		find.addActionListener((e) -> findStudent()); 
		delete.addActionListener((e) -> deleteStudent());
		modify.addActionListener((e) -> modifyStudent());
	}
	
	

	public void makeItVisible() {
		setSize(600, 600);
		setVisible(true);
	}
	class HintTextField extends JTextField implements FocusListener {

		  private final String hint;
		  private boolean showingHint;

		  public HintTextField(final String hint) {
		    super(hint);
		    this.hint = hint;
		    this.showingHint = true;
		    super.addFocusListener(this);
		  }

		  @Override
		  public void focusGained(FocusEvent e) {
		    if(this.getText().isEmpty() || this.getText().equals(hintOfNameText) || this.getText().equals(hintOfRollText)) {
		      super.setText("");
		      super.setForeground(Color.black);
		      showingHint = false;
		    }
		  }
		  @Override
		  public void focusLost(FocusEvent e) {
		    if(this.getText().isEmpty()) {		      
		      super.setText(hint);
		      super.setForeground(Color.gray);
		      showingHint = true;
		    }
		  }

		  @Override
		  public String getText() {
		    return showingHint ? "" : super.getText();
		  }
	}
	
	public static void main(String[] args) {
		new UniversityFrame();
	}
	
	
}
