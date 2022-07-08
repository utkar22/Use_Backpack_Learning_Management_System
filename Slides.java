package assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

public class Slides implements Lecture_Material{
	static Scanner sc = new Scanner(System.in);
	static BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
	
	private final String topic;
	private final Instructor uploaded_by;
	private final Date date;
	
	private int no_of_slides;
	private String[] all_slides;
	
	Slides(String topic, Instructor uploaded_by){
		this.topic = topic;
		this.uploaded_by = uploaded_by;
		this.date = new Date();
	}
	
	@Override
	public String get_topic() {
		return this.topic;
	}
	
	public void add_slides() throws IOException{
		System.out.println("Enter no of slides: ");
		this.no_of_slides = sc.nextInt();
		all_slides = new String[this.no_of_slides];
		
		System.out.println("Enter content of slides");
		for (int i = 0; i<this.no_of_slides; i++) {
			System.out.println("Content of slide "+i);
			all_slides[i] = bff.readLine();
		}
	}
	
	@Override
	public void display() {
		System.out.println("Title: "+this.topic);
		for (int i = 0; i<this.no_of_slides; i++) {
			System.out.println("Slide "+i+": "+all_slides[i]);
		}
		System.out.println("No of slides: "+this.no_of_slides);
		System.out.println("Date of upload: "+this.date);
		System.out.println("Uploaded by: "+this.uploaded_by.get_name());
		System.out.println();
	}
}
