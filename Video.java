package assignment2;

import java.util.Date;

public class Video implements Lecture_Material{
	private final String topic;
	private final Instructor uploaded_by;
	private final Date date;
	
	private String filename;
	
	Video(String topic, Instructor uploaded_by){
		this.topic = topic;
		this.uploaded_by = uploaded_by;
		this.date = new Date();
	}
	
	public boolean set_filename(String filename){
		String check = filename.substring(filename.length() - 4);
		if (check.equals(".mp4")) {
			this.filename = filename;
			return true;
		}
		return false;
	}
	
	@Override
	public String get_topic() {
		return this.topic;
	}
	
	@Override
	public void display() {
		System.out.println("Title of video: "+this.topic);
		System.out.println("Video file: "+this.filename);
		System.out.println("Date of upload: "+this.date);
		System.out.println("Uploaded by: "+this.uploaded_by.get_name());
		System.out.println();
	}

}
