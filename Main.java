package assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
	
	static ArrayList<Instructor> list_of_instructors = new ArrayList<Instructor>();
	static ArrayList<Student> list_of_students = new ArrayList<Student>();
	
	static ArrayList<Lecture_Material> list_of_lecture_materials = new ArrayList<Lecture_Material>();
	static ArrayList<Assessment> list_of_assessments = new ArrayList<Assessment>();
	
	static ArrayList<Comment> forum = new ArrayList<Comment>();
	
	//Function to view all lecture materials
	static void view_lecture_materials() {
		for (int i = 0; i<list_of_lecture_materials.size(); i++) {
			list_of_lecture_materials.get(i).display();
		}
	}
	
	//Function to add comment in the forum
	static void add_comment(Account user) throws IOException {
		System.out.println("Enter comment: ");
		String content = bff.readLine();
		
		Comment comment = new Comment(content, user);
		
		forum.add(comment);
	}
	
	static void view_comments() {
		for (int i = 0; i<forum.size(); i++) {
			forum.get(i).show_comment();
		}
	}
	
	//Function to display all assessments
	static void view_assessments() {
		for (int i = 0; i<list_of_assessments.size(); i++) {
			System.out.println("ID: "+i+" "+list_of_assessments.get(i).view_string());
		}
	}
	
	//Function to close an assessment
	static void close_assessment() {
		for (int j = 0; j<list_of_assessments.size(); j++) {
			Assessment assessment = list_of_assessments.get(j);
			if (assessment.get_status()){
				System.out.println("ID: "+j+" "+assessment.view_string());
			}
		}
		System.out.println("Enter id of assignment to close: ");
		int id = sc.nextInt();
		list_of_assessments.get(id).close();
	}
	
	
	static void instructor_commands(Instructor i) {
		while (true) {
			System.out.println("Welcome "+i.get_name());
			System.out.println("INSTRUCTOR MENU");
			System.out.println("1. Add class material");
			System.out.println("2. Add assessments");
			System.out.println("3. View lecture materials");
			System.out.println("4. View assessments");
			System.out.println("5. Grade assessments");
			System.out.println("6. Close assessment");
			System.out.println("7. View comments");
			System.out.println("8. Add comments");
			System.out.println("9. Logout");
			
			try {
				int op = sc.nextInt();
				
				if (op==1) {
					list_of_lecture_materials = i.add_lecture_material(list_of_lecture_materials);		
				}
				else if(op==2) {
					list_of_assessments = i.add_assessment(list_of_assessments);
				}
				else if(op==3) {
					view_lecture_materials();			
				}
				else if(op==4) {
					view_assessments();
				}
				else if(op==5) {
					view_assessments();
					i.grade(list_of_assessments);
				}
				else if(op==6) {
					close_assessment();
				}
				else if(op==7) {
					view_comments();
				}
				else if(op==8) {
					add_comment(i);
				}
				else{
					break;
				}
			}
			catch(Exception e){
				System.out.println("Invalid input");
			}
			finally {
			}

			
		}
	}
	
	static void student_commands(Student s) {
		while (true) {
			System.out.println("Welcome "+s.get_name());
			System.out.println("STUDENT MENU");
			System.out.println("1. View lecture materials");
			System.out.println("2. View assessments");
			System.out.println("3. Submit assessment");
			System.out.println("4. View grades");
			System.out.println("5. View comments");
			System.out.println("6. Add comments");
			System.out.println("7. Logout");
			
			try {			
				int op = sc.nextInt();
				
				if (op==1) {
					view_lecture_materials();
				}
				else if(op==2) {
					view_assessments();
				}
				else if(op==3) {
					s.submit_assessment(list_of_assessments);			
				}
				else if(op==4) {
					s.check_graded();
				}
				else if(op==5) {
					view_comments();
				}
				else if(op==6) {
					add_comment(s);
				}
				else{
					break;
				}
			}
			catch(Exception e){
				System.out.println("Invalid input");
			}
			finally {
			}
		}
	}
	
	static int login() {
		System.out.println("1. Enter as instructor");
		System.out.println("2. Enter as student");
		System.out.println("3. Exit");
		
		int op = sc.nextInt();
		
		try {
			if (op==1) {
				System.out.println("Instructors: ");
				for (int i = 0; i<list_of_instructors.size(); i++) {
					System.out.println(i+" - "+list_of_instructors.get(i).get_name());
				}
				
				System.out.println("Choose id:");
				int op2 = sc.nextInt();
				instructor_commands(list_of_instructors.get(op2));
				return 1;
			}
			else if (op==2) {
				System.out.println("Students: ");
				for (int i = 0; i<list_of_students.size(); i++) {
					System.out.println(i+" - "+list_of_students.get(i).get_name());
				}
				
				System.out.println("Choose id:");
				int op2 = sc.nextInt();
				student_commands(list_of_students.get(op2));
				return 1;
			}
			else {
				return 0;
			}
		}
		catch(Exception e){
			System.out.println("Invalid input");
			return 1;
		}
		finally {
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Backpack");
		
		//Hard-coding dummy accounts
		list_of_instructors.add(new Instructor("i0"));
		list_of_instructors.add(new Instructor("i1"));
		list_of_students.add(new Student("s0"));
		list_of_students.add(new Student("s1"));
		list_of_students.add(new Student("s2"));
		
		
		
		while (true) {
			int br = login();
			if (br==0) {
				break;
			}
		}

	}

}


