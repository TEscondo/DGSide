package dgsidepoject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CourseBuilder {
	//Data Members
	private static Scanner input = new Scanner(System.in);
	
	//Methods
	//Main method is only here to run tests - remove later
//	public static void main(String [] args) {
//		addCourse();
//	}
	
	
	
	
	public static void addCourse () {
		System.out.println("Name of new course: ");
		String courseName = input.nextLine();
		String courseNameTxt = courseName+".txt";
		File courseFile = new File("courses", courseNameTxt);
		if (courseFile.exists()) {
			System.out.println("This already exists! Edit? Y/N");
			String editInput = input.nextLine();
			if (editInput.equalsIgnoreCase("Y")) {
				courseFile.delete();
				addCourse();
			}
			else if (editInput.equalsIgnoreCase("N")) {
				System.out.println("Go explore new courses!");
				//Add location after this
			}
		}
		else {
			try {
				courseFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("How many holes are on the course?");
			int holeNum = input.nextInt();
			int i = 1;
			while (i<=holeNum) {
				System.out.println("What's the par for hole "+i+"?");
				int parNum = input.nextInt();
				try (PrintWriter courseWriter = new PrintWriter(new FileOutputStream(courseFile, true))) {
					courseWriter.append("Hole "+i+"|"+parNum+"\n");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
				
			}
			System.out.println("Good luck!");
			//Add new location here
			
		}
	}
	
	
	
	
	
	
}
