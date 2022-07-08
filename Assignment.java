package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment implements Assessment{
	static Scanner sc = new Scanner(System.in);
	static BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
	
	private final int max_marks;
	private final String problem_statement;
	private final String type;
	
	private boolean status;
	
	
	ArrayList<Submission> list_of_submissions = new ArrayList<Submission>();
	
	Assignment(int max_marks, String problem_statement){
		this.max_marks = max_marks;
		this.problem_statement = problem_statement;
		this.status = true;
		this.type = "Assignment";
	}
	
	@Override
	public int get_max_marks() {
		return max_marks;
	}
	
	public String get_problem_statement() {
		return this.problem_statement;
	}
	
	@Override
	public String get_query(){
		return this.problem_statement;
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
		return ("Assignment: "+this.problem_statement+" Max Marks: "+this.max_marks);
	}

	@Override
	public boolean if_valid(String answer) {
		String check = answer.substring(answer.length() - 4);
		if (check.equals(".zip")){
			return true;
		}
		return false;
	}

	@Override
	public void input_string() {
		System.out.println("Enter filename of assignment: ");
	}

	@Override
	public void grade(Instructor ins) {
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
