package assignment2;

import java.util.Date;

public class Comment {
	private final String content;
	private final String username;
	private final Date date;
	
	Comment(String content, Account account){
		this.content = content;
		this.username = account.get_name();
		this.date = new Date();
	}
	
	public void show_comment() {
		System.out.println(content+" - "+username);
		System.out.println(date);
		System.out.println();
	}
}
