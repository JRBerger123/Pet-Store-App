/**
 * The Attendance App ONLY keeps track of attendance for two course sections. This is because it's similar to the Basketball scoreboard app that only keeps track of two sections of an Away and Home Team.
 *
 * @author Brandon Berger, Jonathan Sosa
 * @version 1.0
 * @since 2025.02.26
 * @see <a href="https://github.com/JRBerger123/attendance-app">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/jososa02">Jonathan Sosa's GitHub</a>
 */
public class AttendanceApp {
	/**
	 * Standard double dash line for display output
	 */
	private static final String DOUBLE_DASH_LINE = String.format("%50s", "").replace(' ', '=');

	/**
	 * Standard single dash line for display output
	 */
	private static final String SINGLE_DASH_LINE = DOUBLE_DASH_LINE.replace('=', '-');
	
	/**
	 * The first course selection.
	 */
	public Course section1;

	/**
	 * The second course selection.
	 */
	public Course section2;

	/**
	 * The default constructor that that creates two empty courses to maintain attendance for.
	 */
	public AttendanceApp() {
		section1 = new Course();
		section2 = new Course();
	}
    
	/**
     *  Displays the Attendance App header. Example:<br>
	 *  <pre>
	 *  =========================================
	 *  Welcome to the Attendance App
	 *  =========================================
	 *  </pre>
     */
    private void displayAppHeading() {
		System.out.println(DOUBLE_DASH_LINE);
		System.out.println("Welcome to the Attendance App");
		System.out.println(DOUBLE_DASH_LINE);
		System.out.println();
	}
    
    /**
     * Setup courses by getting the course name, plus the student names and seats. Example:<br>
	 * <pre>
	 * Enter Section 1's course name: 
	 * -----------------------------------------
	 * Enter Section 2's course name: 
	 * </pre>
	 * @throws Exception if the course or student setters throws errors back due to invalid user input.
     */
    private void setupCourses() throws Exception {
        String userInput;
        
        userInput = Input.getLine("Enter the name of course 1: ");
        section1.setName(userInput);
        setupStudents(section1);

        System.out.println();
        System.out.println(SINGLE_DASH_LINE);
        System.out.println();

        userInput = Input.getLine("Enter the name of course 2: ");
        section2.setName(userInput);
        setupStudents(section2);
    }
    
    /**
     * Sets up the students for the course.<br>
     * Calls getLine to get the student's name<br>
     * Calls getIntRange to get the student's seat number between 0 and 55<br>
     * Example:<br>
     * <pre>
     * Enter Math101 student's name or 'q' to quit: user input
     * Enter Billy's seat number: user input
     * </pre>
     * @param course The course to set students for.
     */
    private void setupStudents(Course course) {
        String courseName = course.getName();
        String name;
        int seatNumber;

        while (true) {
            System.out.println();
            name = Input.getLine("Enter " + courseName + " student's name or 'q' to quit: ");
            
            if (name.equals("q"))
                return;
            
            try { 
                seatNumber = Input.getIntRange("Enter " + name + "'s seat number: ", 0, 55);
                course.addStudent(seatNumber, name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Unable to add student!");
            }
        }
    }
    
	/**
 * Processes attendance for a specific course by requesting a valid student seat number.
 * 
 * @param course The course for which to process attendance
 * @return The selected seat number (0 indicates user wants to quit)
 */
private int courseAttendance(Course course) {
    int seat;
    Student student;
    
    System.out.println("Processing attendance for " + course.getName());
    System.out.println(SINGLE_DASH_LINE);
    
    while (true) {
        try {
			System.out.println();
            // Get seat number from user
            seat = Input.getIntRange("Enter " + course.getName() + "'s Student Seat # or 0 to quit: ", 0, 55);
            
            // Check if user wants to quit
            if (seat == 0) {
                System.out.println("Returning to main menu...");
                return 0;
            }
            
            // Validate seat exists in the course
            student = course.getStudent(seat);
            if (student == null) {
                System.out.println("Error: No student assigned to seat #" + seat);
                System.out.println("Please try again or enter 0 to quit.");
                continue;
            }
            
            // Return the valid seat number
            return seat;
            
        } catch (Exception e) {
            System.out.println("Error processing input: " + e.getMessage());
            System.out.println("Please try again.");
        }
    }
}

	/**
	 * Take attendance for a specific student.
	 * @param student The student to take attendance for.
	 * @throws Exception if the student's attendance setter throws an error back due to invalid user input.
	 */
	private void studentAttendance(Student student) {
		int type;

		System.out.println();

		System.out.println(SINGLE_DASH_LINE);
		System.out.println("Enter #" + student.getSeat() + " " +student.getName() + " Attendance");
		System.out.println(SINGLE_DASH_LINE);

		System.out.println("0 = On Time");
		System.out.println("1 = Late");
		System.out.println("2 = Excused");
		System.out.println("3 = Unexcused");

		System.out.println(SINGLE_DASH_LINE);
		type = Input.getIntRange("Enter Status Type: ", 0, 3);
		System.out.println(SINGLE_DASH_LINE);

		try {
			student.updateAttendance(type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Unable to update student's attendance!");
		}

		student.displayAttendance();
	}
    
    /**
     * Display the detail attendance report for both course sections.
     */
    private void displayDetailReports() {
    	section1.displayDetailReport();
    	section2.displayDetailReport();
    }

	/**
     * Displays the main menu, get the user input, and call the appropriate method. Example:<br>
	 * <pre>
	 * -----------------------------------------
	 * Main Menu
	 * -----------------------------------------
	 * 0 = End Attendance App
	 * 1 = Take 9:00 am Attendance
	 * 2 = Take 10:00 am Attendance
	 * 3 = Display All Attendance Report
	 * -----------------------------------------
	 * Menu Choice: 3
	 * -----------------------------------------
	 * </pre>
     * @throws Exception if any of the menu options throws an error back to this method.
     */
    private void mainMenu() throws Exception {
		boolean runningApp = true;
		int userInput;
		
		System.out.println();
		System.out.println(DOUBLE_DASH_LINE);    
		System.out.println("Attendance Tracking Started!");
		System.out.println(DOUBLE_DASH_LINE);
		System.out.println();
		
		while (runningApp) {
			// Display menu header
			System.out.println(SINGLE_DASH_LINE);
			System.out.println("Main Menu");
			System.out.println(SINGLE_DASH_LINE);
			
			// Display menu options
			System.out.println("0 = End Attendance App");
			System.out.println("1 = Take " + section1.getName() + " Attendance");
			System.out.println("2 = Take " + section2.getName() + " Attendance");
			System.out.println("3 = Display All Attendance Report");
			
			// Get user selection
			System.out.println(SINGLE_DASH_LINE);
			userInput = Input.getIntRange("Menu Choice: ", 0, 3);
			System.out.println(SINGLE_DASH_LINE);
			
			System.out.println();
			
			// Process user selection
			switch (userInput) {
				case 0:
					runningApp = false;
					System.out.println("Attendance App terminated. Thank you for using the system.");
					System.out.println();
					break;
					
				case 1:
					userInput = courseAttendance(section1);
					if (userInput != 0) {
						studentAttendance(section1.getStudent(userInput));
						break;
					}
					section1.displaySummaryReport();
					break;
					
				case 2:
				userInput = courseAttendance(section2);
				if (userInput != 0) {
					studentAttendance(section2.getStudent(userInput));
					break;
				}
				section2.displaySummaryReport();
				break;
					
				case 3:
					displayDetailReports();
					break;
					
				default:
					System.out.println("Error: Invalid menu choice = " + userInput);
					System.out.println("Please select a value between 0 and 3.");
			} // end of switch
		}
	}
    
	/**
	 * Creates the AttendanceApp object, displays the app's heading, and then calls the setup courses
	 * method that initializes the program with course and student information.
	 */
	public static void main(String[] args) {
		// Create the attendance application instance
		AttendanceApp attendanceApp = new AttendanceApp();

		// Display the application header
		attendanceApp.displayAppHeading();
		
		try {
			// Setup the courses and students
			attendanceApp.setupCourses();

			// Display the main menu
			attendanceApp.mainMenu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Sorry but this program ended with an error. Please contact technical support!");
		}
		
	} // end of main
	
} // end of StudentApp class