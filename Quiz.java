package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz implements Assessment{
	static Scanner sc = new Scanner(System.in);
	static BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
	
	private final String question;
	private final int max_marks;
	private final String type;
	
	private boolean status;
	
	ArrayList<Submission> list_of_submissions = new ArrayList<Submission>();
	
	Quiz(String question){
		this.question = question;
		this.max_marks = 1;
		this.status = true;
		this.type = "Quiz";
	}
	
	
	public String get_question(){
		return this.question;
	}
	
	@Override
	public int get_max_marks() {
		return this.max_marks;
	}
	
	@Override
	public String get_query(){
		return this.question;
	}
	
	@Override
	public boolean get_status() {
		return this.status;
	}
	
	@Override
	public void close() {
		this.status = false;
	}
	
	@Override
	public void add_submission(Submission submission) {
		this.list_of_submissions.add(submission);
	}


	@Override
	public String view_string() {
		return ("Question: "+this.question);
	}


	@Override
	public boolean if_valid(String answer) {
		return true;
	}


	@Override
	public void input_string() {
		System.out.println(this.question);
	}
	
	@Override
	public void grade(Instructor ins){
		System.out.println("Choose ID from these ungraded submissions");
		
		int n = 0;
		for (int i = 0; i<this.list_of_submissions.size(); i++) {
			Submission submission = this.list_of_submissions.get(i);
			if (!submission.get_if_graded()) {
				System.out.println("ID: "+i+" "+submission.get_student().get_name());
				n++;
			}
		}
		if (n==0) {
			System.out.println("There are no ungraded submissions");
			return;
		}
		int id = sc.nextInt();
		Submission submission = this.list_of_submissions.get(id);
		submission.grade(ins);
	}

}
