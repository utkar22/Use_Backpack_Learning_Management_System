package assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Instructor implements Account{
	static Scanner sc = new Scanner(System.in);
	static BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
	
	private final String name;
	
	Instructor (String name){
		this.name = name;
	}
	
	@Override
	public String get_name(){
		return this.name;
	}
	
	public ArrayList<Lecture_Material> add_lecture_material(ArrayList<Lecture_Material> list_of_lecture_materials) throws IOException {
		System.out.println("1. Add Lecture Slide");
		System.out.println("2. Add Lecture Video");
		int op2 = sc.nextInt();
		
		if (op2 == 1) {
			System.out.println("Enter topic of slides: ");
			String topic = bff.readLine();
			Slides slides = new Slides(topic, this);
			slides.add_slides();
			
			list_of_lecture_materials.add(slides);
		}
		else if (op2 == 2) {
			System.out.println("Enter topic of video: ");
			String topic = bff.readLine();
			Video video = new Video(topic, this);
			System.out.println("Enter filename of video: ");
			String filename = bff.readLine();
			
			if (video.set_filename(filename)) {
				list_of_lecture_materials.add(video);
			}
			else {
				System.out.println("Invalid filename");
			}
			
		}
		return list_of_lecture_materials;
	}
	
	//Method to add an assessment
	public ArrayList<Assessment> add_assessment(ArrayList<Assessment> list_of_assessments) throws IOException{
		System.out.println("1. Add Assignment");
		System.out.println("2. Add Quiz");
		int op = sc.nextInt();
		
		if (op==1) {
			System.out.println("Enter problem statement: ");
			String problem_statement = bff.readLine();
			System.out.println("Enter max marks: ");
			int max_marks = sc.nextInt();
			Assignment assignment = new Assignment(max_marks, problem_statement);
			list_of_assessments.add(assignment);
		}
		else if (op==2) {
			System.out.println("Enter quiz question: ");
			String question = bff.readLine();
			Quiz quiz = new Quiz(question);
			list_of_assessments.add(quiz);
		}
		
		return list_of_assessments;
	}
	
	//Method to grade a submission
	public void grade(ArrayList<Assessment> list_of_assessments){
		if (list_of_assessments.size()==0) {
			return;
		}
		System.out.println("Enter ID of assessment to view submissions: ");
		int id = sc.nextInt();
		Assessment assessment = list_of_assessments.get(id);
		assessment.grade(this);
	}
}
