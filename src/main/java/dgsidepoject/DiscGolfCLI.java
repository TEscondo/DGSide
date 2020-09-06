package dgsidepoject;

import java.io.FileNotFoundException;

public class DiscGolfCLI {
	private static final String MAIN_MENU_OPTION_BUILD_COURSE = "Create A New Course";
	private static final String MAIN_MENU_OPTION_SCORE_KEEPER = "Score Keeper";
	
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_BUILD_COURSE, MAIN_MENU_OPTION_SCORE_KEEPER};
	private static final String[] BACK_BUTTON = {"Back"};
	
	private Menu menu;

	public DiscGolfCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() throws FileNotFoundException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_BUILD_COURSE)) {
				CourseBuilder.addCourse();
			}
			else if (choice.equals(MAIN_MENU_OPTION_SCORE_KEEPER)) {
				ScoreKeeper.courseReader();
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		DiscGolfCLI cli = new DiscGolfCLI(menu);
		cli.run();
	}
	
	
}
