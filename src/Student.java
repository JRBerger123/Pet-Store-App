/**
 * Represents student attendance for various classes
 * <p>
 * This class is used in {@code AttendanceApp.java} and models student attendance
 * with a seat number, student name, on time arrivals, late arrivals, number of excused absences, and unexcused absences
 * </p>
 *
 * @author Brandon Berger, Jonathan Sosa
 * @version 1.0
 * @since 2025-02-24
 * @see <a href="https://github.com/JRBerger123/attendance-app">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/jososa02">Jonathan Sosa's GitHub</a>
 */
public class Student {
    /**
     * The student's seat.
     */
    private int seat;

    /**
     * The student's name.
     */
    private String name;

    /**
     * The number of on time arrivals the students has had.
     */
    private int onTime;

    /**
     * The number of late arrivals the students has had.
     */
    private int late;

    /**
     * The number of excused absences the student has had.
     */
    private int excused;

    /**
     * The number of unexcused absences the student has had.
     */
    private int unexcused;

    /**
     * Sets the students fields to default values null and zeros
     * The default constructor is Private, so it can Only be called by overload constructor
     */
    private Student() {
        this.name = "";
        this.seat = -1;
        this.onTime = 0;
        this.late = 0;
        this.excused = 0;
        this.unexcused = 0;
    }

    /**
     * This overload constructor should only be used in the ArrayList indexOf method
     * to detect if a seat is already taken by overriding the equals method to test
     * if two students are equal based on their seat
     * @param seat The Student's Seat
     * @throws Exception if the setSeat method throws a data validation error
     */
    public Student(int seat) throws Exception{
        this();
        setSeat(seat);
    }

    /**
     * Allows creating of a Student and setting their name and seat number
     * The constructor first calls the default constructor, then
     * calls both the setName and setSeat methods
     * @param seat The Student's seat
     * @param name The Student's name
     * @throws Exception if the name or seat setters throw a error
     */
    public Student(int seat, String name) throws Exception {
        this();
        setSeat(seat);
        setName(name);
    }

    /**
     * Gets the Student's Seat
     * @return The Student's Seat
     */
    public int getSeat() {
        return seat;
    }

    /**
     * Gets the Student's Name
     * @return The Student's Name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of OnTime
     * @return The Number of OnTime
     */
    public int getOnTime() {
        return onTime;
    }
    /**
     * Gets the number of Late
     * @return The Number of Late
     */
    public int getLate() {
        return late;
    }
    /**
     * Gets the number of Excused
     * @return The Number of Excused
     */
    public int getExcused() {
        return excused;
    }
    /**
     * Gets the number of Unexcused
     * @return The Number of Unexcused
     */
    public int getUnexcused() {
        return unexcused;
    }

    /**
     * Sets the Student's Seat number if it's a positive number
     * otherwise it throws a error
     * @param seat the student's seat
     * @throws Exception if the seat isn't a positive
     */
    public void setSeat(int seat) throws Exception {
        if (seat < 1)
            throw new Exception("Seat cannot be a negative");
        else
            this.seat = seat;
    } // end of setSeat Method

    /**
     * Set's the student's name. Uses the trim method to remove leading and trailing spaces
     * and then if the name is an empty string, it will throw a error
     * if not then it will set the student's name
     * @param name The Student's Name
     * @throws Exception if the student's name is blank or empty
     */
    public void setName(String name) throws Exception {
        name = name.trim();

        if (name == "" || name == null)
            throw new Exception("Student name can not be blank");
        else
            this.name = name;
    } // end of setName method

    /**
     * Increments the status type, using a switch
     * case 0 is received then increment onTime
     * case 1 is received then increment Late
     * case 2 is received then increment Excused
     * case 3 is received then increment Unexcused
     * default throw an exception displaying the invalid value that was recieved
     * @param status The status type 0=onTime, 1=Late, 2=Excused, 3=Unexcused
     * @throws Exception if an invalid status is received
     */
    public void updateAttendance(int status) throws Exception {
        switch (status) {
            case 0:
                onTime++;
                break;
            case 1:
                late++;
                break;
            case 2:
                excused++;
                break;
            case 3:
                unexcused++;
                break;
            default:
                throw new Exception("Invalid Attendance type: " + status);
        }
    }

    /**
     * Displays the Student's Attendance, Seat, Name
     */
    public void displayAttendance() {
        System.out.println("Seat # " + seat + " " + name);
        System.out.println("On Time: " + onTime + " Late: " + late + " Excused: " + excused + " Unexcused: " + unexcused);
    }

    /**
     * Instead of verifying two students are identical by equal identities
     * This method will verify two students are the same by only their seat number
     * This allows the ArrayList method to return a player's by only checking their seat number
     * @param object a student's object to check equality of only the seat number
     * @return true if the two student's seat are equal otherwise false
     */
    @Override
    public boolean equals(Object object) {

        if(!(object instanceof Student))
            return false;

        Student other = (Student)object;

        return this.seat == other.getSeat();
    }

    /**
     * Return's the student seat number and student name
     * @return The student's seat and name
     */
    @Override
    public String toString() {

        return String.format("%s %s", seat, name);
    }
}
