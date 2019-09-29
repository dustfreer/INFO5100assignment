package assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Course {
	private int courseId;
	private String courseName;
	private int maxCapacity;
	private int professorId;
	private int credits;
	private int[] studentIds;
	
	public Course(int courseId) {
		this.setCourseId(courseId);
		
	}
	
	public Course(int courseId, int professorId) {
		this.setCourseId(courseId);
		this.setProfessorId(professorId);
	}
	
	public Course(int courseId, int professorId, int credits) {
		this.setCourseId(courseId);
		this.setProfessorId(professorId);
		this.setCredits(credits);
	}
	
	public int getCourseId() {
		return this.courseId;
	}
	
	public void setCourseId(int courseId) {
		if( courseId <= 0 )
			throw new IllegalArgumentException("invalid course ID, it should not be negative or 0");
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void setCourseName(String courseName) {
		if( courseName.length() > 60 || courseName.length() < 10)
			throw new IllegalArgumentException("invalid course Name, it should be a string with minimum length 10 and maximum 60");
		this.courseName = courseName;
	}
	
	public int getMaxCapacity() {
		return this.maxCapacity;
	}
	
	public void setMaxCapacity(int maxCapacity) {
		if( maxCapacity < 10 || maxCapacity > 100)
			throw new IllegalArgumentException("invalid maxCapacity, it should not be less than 10 greater than 100");
		this.maxCapacity = maxCapacity;
	}
	
	public int getProfessorId() {
		return this.professorId;
	}
	
	public void setProfessorId(int professorId) {
		if( professorId >= 1000000 || professorId < 100000)
			throw new IllegalArgumentException("invalid professor Id, should be a six digit integer");
		this.professorId = professorId;
	}
	
	public double getCredits() {
		return this.credits;
	}
	
	public void setCredits(int credits) {
		if( credits <= 0 || credits >= 10)
			throw new IllegalArgumentException("invalid credits, it should be a single digit but greater than 0");
		this.credits = credits;
	}
	
	public int[] getStudentIds() {
		return this.studentIds;
	}
	
	public void setStudentIds(int[] studentIds) {		
		this.studentIds = studentIds;
	}
	
	public int[] registerStudent(int studentId) {
		List<Integer> tempStudentIds = new ArrayList<Integer>();
		for (int student : studentIds)
			tempStudentIds.add(student);
		tempStudentIds.add(studentId);
		for( int i = 0; i < tempStudentIds.size(); i++)
			this.studentIds[i] = tempStudentIds.get(i);
		return this.studentIds;
	}
	
	public int[] removeDuplicates(int[] studentIds) {
		Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < studentIds.length; i++)
			if( !tempMap.containsValue(studentIds[i]))			
				tempMap.put(i, studentIds[i]);
		
		int[] newStudentIds = new int[tempMap.size()];
		Set< Map.Entry<Integer, Integer> > tempSet= tempMap.entrySet();
		int i =0;
		for(Map.Entry<Integer, Integer> st : tempSet)
			newStudentIds[i++] = st.getValue();
		
		return newStudentIds;
		
	}
	
	/*
	 * Q4, find number of pairs of studentsIds whose sum is even;
	 * Designed by Kai Tian;
	 */
	public int groupsOfStudents(int[] studentIds) {
		if ( studentIds.length <= 1)
			throw new IllegalArgumentException("the length of studentIds is less than 2");
		
		int count = 0;
		for (int i = 0; i < studentIds.length; i++)
			for ( int j = 0; j < studentIds.length; j++) {
				if( j == i)
					continue;
				else {
					int sum = studentIds[i] + studentIds[j];
					if ( sum % 2 == 0)
						count++;
						
				}
					
			}
		return count++;			
	}
	

}
