package assignment1;

/*
 * A Course Registration Platform;
 * Pseudo code;
 * Designed by Kai Tian;
 */

Objects of Platform: {
	Students, 
	Teachers, 
	Courses;
}
------------------------------------------------------------------------------------

Objects of Student{
	Student.ID;
	Student.name;
	Student.username;
	Student.password;
	Student.term;
	Student.subject;
	Student.email;
	
}
Function of Student{ 
	login;
	search Courses basing on parameters(term, subject, courseNumber, courseName);
	register for Courses;
	drop Courses;
}
------------------------------------------------------------------------------------

Objects of Teacher{
	Teacher.ID;
	Teacher.username;
	Teacher.password;
	Teacher.term;
	Teacher.subject;
	Teacher.email;
}
Function of Teacher{
	login;
	search Courses basing on parameters(term, subject, teacherID, teacherName);
	Opening a course;
	Closing a course;
}
------------------------------------------------------------------------------------

Objects of Course{
	Course.number;
	Course.name;
	Course.introduction;
	Course.credit;
	Course.teacher;
	Course.schedule;
	Course.courseroomNumber;
	Course.capacity;
	Course.seatRemain;	
}

Function of Course{
	create;
	delete;
	search basing on Parameters(number, name);
	modify basing on parameters(schedule, teacher, courseroomNumber);
}
------------------------------------------------------------------------------------
class CourseSystem //set by system manager;
Behaviour: initiate(username, studentOrteacher); {
	if (studentOrteacher == 0) { //for student
		Set {Student.ID;
			Student.name;
			Student.username;
			Student.password;
			Student.term;
			Student.subject;
			Student.email;}
		to database;
	}else {   //for teacher
		set {Teacher.ID;
			Teacher.username;
			Teacher.password;
			Teacher.term;
			Teacher.subject;
			Teacher.email;}
		to database;
	}
}
Behaviour: createCourse(List<course> Course){
	set {	course.number;
		Course.name;
		Course.introduction;
		Course.credit;
		Course.teacher;
		Course.schedule;	
		Course.courseroomNumber;
		Course.capacity;
		Course.seatRemain;}
	to database;
}
Behaviour: searchCourse(parameter)
	search course basing on parameter from databases
	return List<Course> course;

Behaviour: registerCourse(parameter)
	register for course basing on parameter from databases
	return List<Course> course;
			
Behaviour: dropCourse(parameter)
	drop course basing on parameter from databases
	return "drop success";
			
Behaviour: deleteCourse(parameter)
	searchCourse(parameter)
	delete course basing on parameter from databases
	return "delete success";

Behaviour: modifyCourse(parameter)	
	ModifyCourse(parameter)
	modify course basing on parameter from databases
	return "modify success";
------------------------------------------------------------------------------------		
	
public class AccountRegister //for both students and teachers
State: email, username, password;
Behaviour: accountRegister(email, username, password)
	switch(student or teacher form email)
	if (student)
		List<Student> student = courseSystem.initiate(username, 0); // 0 on behalf of student
	else 
		List<Teacher> teacher = courseSystem.initiate(username, 1); // 1 on behalf of teacher

public class Identification //for both students and teachers
State: username, password;
Behaviour: login(username, password){
	if (username is valid && password is valid) {
		return "login in Success"; 
		switch(student or teacher)
		//access to related system and distribute related function;
	}else 
		return "login in Fail";

public class Searchcourse //for both students and teachers
State: term, subject, courseNumber, courseName, teacherID, teacherName;
Behaviour: searchcourseForStudent(term, subject){
	Switch(term or subject)
		List<Course> course = courseSystem.searchCourse(searchParams, 0); // 0 on behalf of student
		//display information of the course to student;
		return list include courseNumber, courseName
}

Behaviour: searchcourseForTeacher(term, subject, teacherID, teacherName){
	Switch(term or subject or teacherID or teacherName)
		List<Course> course = courseSystem.searchCourse(searchParams, 1);// 1 on behalf of teacher
		//display related information of the course to teacher
}
	
private class Student
State: username,password,term,subject,email;
Behaviour: login(){
	if (first login in) {
		AccountRegister.accountRegister(email, username, password);
	}else {
		Identification.login(username,password);
	}
}

Behaviour: registerCourse(term, subject){
	List<courseInfo> courseInfo = Searchcourse.searchcourseForStudent(term, subject)
	//get courseNumber, courseName
	int courseNumber = courseInfo.courseNumber;
	String courseName = courseInfo.courseName;
	CourseSystem.registerCourse(courseNumber);
}

Behaviour: dropCourse(courseNumber){
	CourseSystem.dropcourse(courseNumber);
	//get whether drop success or not information;
}
}

private class teacher
state: username, password, term, subject, email
Behaviour: login(){
	if (first login in) {
		AccountRegister.accountRegister(email, username, password);
	}else {
		Identification.login(username,password);
	}

Behaviour: OpenCourse(term, subject){
		List<courseInfo> courseInfo = Searchcourse.searchcourseForTeacher(term, subject)
	    if(courseInfo.capacity ! = 0) {
	    	CourseSystem.createCourse;
	    }
		
}

Behaviour: CloseCourse(term, subject){
		List<courseInfo> courseInfo = Searchcourse.searchcourseForTeacher(term, subject)
		if(courseInfo.capacity == 0) {
			CourseSystem.closeCourse;
		}
	}
}



