package assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Student implements Account{
	static Scanner sc = new Scanner(System.in);
	static BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
	
	private final String name;
	
	ArrayList<Submission> list_of_submissions = new ArrayList<Submission>();
	ArrayList<Assessment> list_of_submitted_assessments = new ArrayList<Assessment>();
	
	Student (String name){
		this.name = name;
	}
	
	@Override
	public String get_name(){
		return this.name;
	}
	
	public void add_submission(Submission submission) {
		this.list_of_submissions.add(submission);
	}
	
	public void submit_assessment(ArrayList<Assessment> list_of_assessments) throws IOException {
		System.out.println("Pending assessments: ");
		int n=0;
		for (int i = 0; i<list_of_assessments.size(); i++) {
			Assessment assessment = list_of_assessments.get(i);
			if ((!list_of_submitted_assessments.contains(assessment))&&assessment.get_status()){
				System.out.println("ID: "+i+" "+assessment.view_string());
			}
			n++;
		}
		
		if (n==0) {
			System.out.println("There are no pending assessments.");
			return;
		}
		
		System.out.println("Enter ID of assignment");
		int id = sc.nextInt();
		Assessment assessment = list_of_assessments.get(id);
		Submission submission = new Submission(assessment, this);
		assessment.input_string();
		
		String answer = bff.readLine();
		if (submission.add_answer(answer)) {
			this.list_of_submissions.add(submission);
			this.list_of_submitted_assessments.add(assessment);	
		}
		else {
			System.out.println("Invalid filename.");
		}
	}
	
	public void check_graded() {
		System.out.println("Graded submissions:");
		
		int n=0;
		for (int i = 0; i<list_of_submissions.size(); i++) {
			Submission submission = list_of_submissions.get(i);
			if (submission.get_if_graded()) {
				n++;
				submission.show();
			}
		}
		if (n==0) {
			System.out.println("No graded submissions");
		}
		
		System.out.println("Ungraded submissions:");
		
		n=0;
		for (int i = 0; i<list_of_submissions.size(); i++) {
			Submission submission = list_of_submissions.get(i);
			if (!submission.get_if_graded()) {
				n++;
				submission.show();
			}
		}
		if (n==0) {
			System.out.println("No ungraded submissions");
		}
	}
}
