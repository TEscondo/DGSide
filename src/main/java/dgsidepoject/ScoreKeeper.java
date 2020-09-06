package dgsidepoject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScoreKeeper {

	//Data Members
	private static Scanner userInput = new Scanner(System.in);
	private static Map<String, Integer> courseMap = new HashMap<>();
	
	//Methods
	//This is just here to run tests - remove later
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			courseReader();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//This should read the course file and put the parNum to a Map
	public static void courseReader() throws FileNotFoundException {
	System.out.println("Where are you playing?");
	String courseName = userInput.nextLine();
	String courseNameScore = courseName+"Scores.txt";
	String courseNameTxt = courseName+".txt";
	File scoreFile = new File ("scores", courseNameScore);
	File courseFile = new File ("courses", courseNameTxt);
	if (scoreFile.exists()) {
		System.out.println("Take this chance to improve!");
	}
	else {
		try {
			scoreFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	if (!courseFile.exists()) {
		CourseBuilder.addCourse();
		courseReader();
	}
	else {
		String [] courseArr = new String [2];
		try (Scanner courseRead = new Scanner (courseFile)) {
			while (courseRead.hasNextLine()) {
				String courseLine = courseRead.nextLine();
				courseArr = courseLine.split("\\|");
				courseMap.put(courseArr[0], Integer.parseInt(courseArr[1]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		String [] messages = {"Hole-in-one!", "Eagle!", "Birdie!", "Par!",
				"Bogey!", "Double Bogey",
				"Maybe take a deep breath..."};
		
		int courseSize = courseMap.size();
		int i = 1;
		int totalScore = 0;
		while (i<=courseSize) {
			System.out.println("How did you do on Hole "+i+"?");
			int strokes = userInput.nextInt();
			int par = courseMap.get("Hole "+i);
			int scoreInt = strokes - par;
			if (strokes == 1) {
				System.out.println(messages[0]);
				}
				else if (strokes <= par -2) {
				System.out.println(messages[1]);
				}
				else if (strokes == par -1) {
				System.out.println(messages[2]);
				}
				else if (strokes == par) {
				System.out.println(messages[3]);
				}
				else if (strokes == par +1) {
				System.out.println(messages[4]);
				}
				else if (strokes == par +2) {
				System.out.println(messages[5]);
				}
				else if (strokes >= par +3) {
				System.out.println(messages[6]);
				}
			//Append scores to text and tally total score
			try (PrintWriter scores = new PrintWriter(new FileOutputStream(scoreFile, true))) {
				scores.append(scoreInt+"\n");
			}
		totalScore = totalScore + scoreInt;	
		i++;
		}
		//Read the scoreFile, give this round's final score, give avg final score
		System.out.println("Your total score for this round is: "+totalScore);
	}
	
	
	
}
