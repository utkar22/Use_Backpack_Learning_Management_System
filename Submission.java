package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Submission {
	static Scanner sc = new Scanner(System.in);
	static BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
	
	private final Assessment assessment;
	private final Student student;
	
	private String answer;
	private int marks;
	private boolean if_graded;
	private Instructor graded_by;
	
	Submission(Assessment assessment, Student student){
		this.assessment = assessment;
		this.student = student;
		this.if_graded = false;
	}
	
	public Student get_student() {
		return this.student;
	}
	
	public boolean get_if_graded() {
		return this.if_graded;
	}
	
	public boolean add_answer(String answer) {
		if (this.assessment.if_valid(answer)) {
			this.answer = answer;
			assessment.add_submission(this);
			return true;
		}
		return false;
	}
	
	public void grade(Instructor ins) {
		System.out.println("Submission: "+this.answer);
		System.out.println("Max marks: "+this.assessment.get_max_marks());
		System.out.println("Marks Scored: ");
		this.marks = sc.nextInt();
		this.if_graded = true;
		this.graded_by = ins;
	}
	
	public void show(){
		System.out.println("Submission: "+this.answer);
		if (this.if_graded) {
			System.out.println("Marks scored: "+this.marks);
			System.out.println("Graded by: "+this.graded_by.get_name());
		}
		System.out.println();
	}
}
