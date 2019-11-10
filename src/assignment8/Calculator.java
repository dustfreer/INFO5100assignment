package assignment8;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	private JFrame frame;
	private JLabel firstLabel, secondLabel, operationLabel, resultLabel;;
	private JTextField firstNumberText, secondNumberText, resultText;
	private JComboBox<String> options;
	private JButton resultsButton;

	Calculator() {
		create();
		setMainFrame();
		Container con = frame.getContentPane();
		addComponent(con);
		addListeners();
		makeVisible();
	}

	void create() {
		frame = new JFrame("Basic Calculator");

		firstLabel = new JLabel("First Number : ");
		secondLabel = new JLabel("Second Number : ");
		operationLabel = new JLabel("Operation : ");
		resultLabel = new JLabel("Result :");

		firstNumberText = new JTextField(10);
		secondNumberText = new JTextField(10);
		resultText = new JTextField(10);
		resultText.setEditable(false);

		options = new JComboBox<String>(new String[] { "+", "-", "*", "/" });
		resultsButton = new JButton("Compute");
	}

	void setMainFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	void addComponent(Container con) {
		GridLayout layout = new GridLayout(3, 3);

		con.setLayout(layout);
		con.add(new JPanel());
		con.add(addResultsLabel());
		con.add(new JPanel());
		con.add(addPanelComponents(firstLabel, firstNumberText));
		con.add(addPanelComponents(operationLabel, options));
		con.add(addPanelComponents(secondLabel, secondNumberText));
		con.add(new JPanel());
		JPanel panel = new JPanel();
		panel.add(resultsButton);
		con.add(panel);
	}

	private JPanel addPanelComponents(Component a, Component b) {
		JPanel panel = new JPanel();
		panel.add(a);
		panel.add(b);
		return panel;
	}

	private JPanel addResultsLabel() {
		JPanel panel = new JPanel();
		panel.add(resultLabel);
		panel.add(resultText);
		return panel;
	}

	void makeVisible() {
		frame.setSize(400, 200);
		frame.setVisible(true);
	}
	
	public void addListeners() {
		resultsButton.addActionListener((e) -> calculateAndStoreResult());

	}

	void calculateAndStoreResult() {
		long a = 0;
		try {
			a = Long.parseLong(firstNumberText.getText());
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(frame, "Number should be entered in the first text field");
			throw e;
		}
		long b = Long.parseLong(secondNumberText.getText());
		String choice = options.getSelectedItem().toString();
		long result = getResult(a, b, choice);
		resultText.setText(String.valueOf(result));
	}

	private long getResult(long a, long b, String choice) {
		switch (choice) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		}
		return a / b;
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
