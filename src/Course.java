import java.util.ArrayList;

/**
 * Represents Course Stats for an organization.
 * <p>
 * This class is used in {@code AttendanceApp.java} and models course stats.
 * Each course consists of a course name and list of students in the course. 
 * </p>
 *
 * @author Brandon Berger, Jonathan Sosa
 * @version 1.0
 * @since 2025-02-26
 * @see <a href="https://github.com/JRBerger123/attendance-app">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/jososa02">Jonathan Sosa's GitHub</a>
 */
public class Course {
    /**
     * Represents the course's name.
     */
    private String name;

    /**
     * Is an dynamic array of each student in the course.
     */
    private ArrayList<Student> allStudents;
    
    /**
     * The default constructor sets the course name to unknown and creates an empty allStudents ArrayList.
     */
    public Course() {
        name = "unknown";
        allStudents = new ArrayList<>();
    }
    /**
     * Gets the course's name
     * @return The course's name
     */
    public String getName() {

        return name;
    }



    /**
     * Set's the course's name
     * @param name the course's name
     * @throws Exception if the course's name is blank <br>
     */
    public void setName(String name) {
        name = name.trim(); // remove leading and trailing whitespace

        //isBlank checks for both empty or whitespace
        if (name == null || name == "") {
            throw new RuntimeException("Student name can not be blank.");
        }

        this.name = name;
    }

    /**
     * Get a Student by using their seat number using the ArrayList method
     * If the indexOf mtehod returns -1 then this method returns empty otherwise,
     * it returns the Student object associated with the seat number
     * @param seat The Student's seat
     * @return If a Student is found, it will return the Student object otherwise a empty value
     * @throws Exception Creating a student with a invalid seat could throw a error
     */
    public Student getStudent(int seat) throws Exception {
        int index = allStudents.indexOf(new Student(seat));

        if (index == -1) {
            return null;
        } else {
            return allStudents.get(index);
        }
    }

    /**
     * Add a student to the course, by using the overload constructor that allows setting their name and seat too.
     * This method will verify that the seat is not already used by another student.
     * If it is already in use then it will throw an exception back to the calling method
     * @param seat The student's seat
     * @param name The course's name
     * @throws Exception Student with seat already exists
     */
    public void addStudent(int seat, String name) throws Exception{
        if (getStudent(seat) != null) {
            System.out.println("Student with seat " + seat + " already exists.");
            return;
        }
        Student newStudent = new Student(seat, name);
        allStudents.add(newStudent);
    }

    /**
     * Displays a comprehensive summary of attendance statistics for the course.
     * <p>
     * This method aggregates attendance data across all students registered in the course
     * and presents a formatted summary report. The report includes:
     * <ul>
     *   <li>Total number of students enrolled in the course</li>
     *   <li>Cumulative count of on-time attendances</li>
     *   <li>Cumulative count of late attendances</li>
     *   <li>Cumulative count of excused absences</li>
     *   <li>Cumulative count of unexcused absences</li>
     * </ul>
     * </p>
     * <p>
     * The method iterates through the {@code allStudents} collection, accumulating
     * attendance metrics from each {@link Student} object using their respective getter
     * methods. Initial counter values are set to zero to ensure accurate aggregation.
     * </p>
     * 
     * @see Student#getOnTime() Method to retrieve a student's on-time attendance count
     * @see Student#getLate() Method to retrieve a student's late attendance count
     * @see Student#getExcused() Method to retrieve a student's excused absence count
     * @see Student#getUnexcused() Method to retrieve a student's unexcused absence count
     */
    public void displaySummaryReport() {
        // Initialize counters at zero
        int totalOnTime = 0;
        int totalLate = 0;
        int totalExcused = 0;
        int totalUnexcused = 0;
    
        // Accumulate totals from all students
        for (Student s : allStudents) {
            totalOnTime += s.getOnTime();
            totalLate += s.getLate();
            totalExcused += s.getExcused();
            totalUnexcused += s.getUnexcused();
        }
        
        // Display formatted summary
        System.out.println(this.name + " Attendance Summary:");
        System.out.println("Total Students: " + allStudents.size());
        System.out.println("On Time: " + totalOnTime);
        System.out.println("Late: " + totalLate);
        System.out.println("Excused Absences: " + totalExcused);
        System.out.println("Unexcused Absences: " + totalUnexcused);
    }

    /**
     * Displays each Student's detailed stats for the entire course
     */
    public void displayDetailReport() {
        Student student;

        displaySummaryReport();

        System.out.println("Seat   Name            OnTime Late Excused Unexcused");
        System.out.println("====== =============== ====== ==== ======= =========");

        for (Student value : allStudents) {
            student = value;
            
            System.out.printf("%6d %-15s %6d %4d %7d %9d\n",
                    student.getSeat(),        // %6d - Seat number (integer)
                    student.getName(),        // %-15s - Name (left-padded string)
                    student.getOnTime(),      // %6d - OnTime count
                    student.getLate(),        // %4d - Late count
                    student.getExcused(),     // %7d - Excused absences
                    student.getUnexcused());  // %9d - Unexcused absences
        }
        System.out.println();
    }

    /**
     * Returns the course's name
     * @return Course Name
     */
    @Override
    public String toString() {
        return name;
    }
}

