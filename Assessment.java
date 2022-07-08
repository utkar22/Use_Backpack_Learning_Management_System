package assignment2;

import java.util.Scanner;

public interface Assessment {
	public int get_max_marks();
	public String get_query();
	public void add_submission(Submission submission);
	public String view_string();
	public void input_string();
	public boolean if_valid(String answer);
	boolean get_status();
	void close();
	void grade(Instructor ins);
}
