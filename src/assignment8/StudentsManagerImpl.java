package assignment8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentsManagerImpl {
	private Map<String, Student> studentsMap = new HashMap<String, Student>();
	private String file = "/Users/tiankai/eclipse/eclipse-workspace/INFO5100/src/assignment8/students.txt";

	public StudentsManagerImpl() throws Exception {
		readDataFromFileAndAddToTheManager();
	}

	private void readDataFromFileAndAddToTheManager() throws Exception {
		File f = new File(file);
		if (f.exists() == false) {
			return;
		}
		FileInputStream fis = new FileInputStream(f);
		Scanner s = new Scanner(fis);
		while (s.hasNext()) {
			String l = s.nextLine();
			String[] tokens = l.split("\\|");
			Student student = new Student(tokens[0], tokens[1]);
			this.addStudentIntoMap(student);
		}
		s.close();

	}
	
	public void addStudentIntoMap(Student student) {
		String id = student.getId();
		Student s = studentsMap.get(id);
		if (s == null) {
			studentsMap.put(student.getId(), student);
		} else {

			throw new RuntimeException("Student with id -> " + id + " is already added");
		}

	}

	public void addStudent(Student student) throws RuntimeException {
		String id = student.getId();
		Student s = studentsMap.get(id);
		if (s == null) {
			studentsMap.put(student.getId(), student);
		} else {
			throw new RuntimeException("Student with id -> " + id + " is already added");
		}
		writeIntoFile(student);
	}

	private void writeIntoFile(Student student) {
		try {
			FileOutputStream fos = new FileOutputStream(file, true);
			PrintStream ps = new PrintStream(fos);
			ps.println(student.getId() + "|" + student.getName());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteStudent(String id) {
		studentsMap.remove(id);
		rewriteContentsIntoFile();
	}

	private void rewriteContentsIntoFile() {
		FileOutputStream fos = null;
		PrintStream ps = null;
		try {
			fos = new FileOutputStream(file);
			ps = new PrintStream(fos);
			for (Student s : this.getStudents()) {
				ps.println(s.getId() + "|" + s.getName());
			}

		} catch (Exception e) {

		}
		try {
			fos.close();
			ps.close();
		} catch (Exception e) {

		}

	}

	public boolean modifyStudent(String id, Student student) {
		if (!id.equals(student.getId())) {
			return false;
		}
		studentsMap.put(id, student);
		rewriteContentsIntoFile();
		return true;
	}

	public Student findStudent(String name) {
		for (Student s : studentsMap.values()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}

	public int getStudentCount() {
		return studentsMap.size();
	}

	public void display() {
		System.out.println(studentsMap.values());

	}

	public List<Student> getStudents() {
		return new ArrayList<Student>(studentsMap.values());
	}

}
