
package pkg2dit.borja.midterm;

import java.util.Scanner;


public class BorjaMidterm {

   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;
        CourseManager manager = new CourseManager();

        do {
            System.out.println("1. ADD COURSE");
            System.out.println("2. VIEW COURSES");
            System.out.println("3. UPDATE COURSE");
            System.out.println("4. DELETE COURSE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            sc.nextLine();  

            switch (action) {
                case 1:
                    addCourse(manager, sc);
                    break;
                case 2:
                    viewCourses(manager);
                    break;
                case 3:
                    updateCourse(manager, sc);
                    break;
                case 4:
                    deleteCourse(manager, sc);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }

            System.out.print("Continue? (yes/no): ");
            response = sc.nextLine();
        } while (response.equalsIgnoreCase("yes"));

        System.out.println("Thank you for using the Course Management System!");
    }

    private static void addCourse(CourseManager manager, Scanner sc) {
        System.out.print("Course ID: ");
        String courseId = sc.nextLine();

        System.out.print("Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Course Code: ");
        String courseCode = sc.nextLine();

        System.out.print("Credits: ");
        int credits = sc.nextInt();
        sc.nextLine();  
        System.out.print("Semester: ");
        String semester = sc.nextLine();

        System.out.print("Year: ");
        int year = sc.nextInt();
        sc.nextLine();  

        String query = "INSERT INTO Course (course_id, course_name, course_code, credits, semester, year) VALUES (?, ?, ?, ?, ?, ?)";
        manager.addCourse(query, courseId, courseName, courseCode, credits, semester, year);
    }

    private static void viewCourses(CourseManager manager) {
        String query = "SELECT * FROM Course";
        String[] headers = {"Course ID", "Course Name", "Course Code", "Credits", "Semester", "Year"};
        String[] columns = {"course_id", "course_name", "course_code", "credits", "semester", "year"};
        manager.viewCourses(query, headers, columns);
    }

    private static void updateCourse(CourseManager manager, Scanner sc) {
        System.out.print("Enter Course ID to update: ");
        String courseId = sc.nextLine();

        System.out.print("New Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("New Course Code: ");
        String courseCode = sc.nextLine();

        System.out.print("New Credits: ");
        int credits = sc.nextInt();
        sc.nextLine();  

        System.out.print("New Semester: ");
        String semester = sc.nextLine();

        System.out.print("New Year: ");
        int year = sc.nextInt();
        sc.nextLine();  
        String query = "UPDATE Course SET course_name = ?, course_code = ?, credits = ?, semester = ?, year = ? WHERE course_id = ?";
        manager.updateCourse(query, courseName, courseCode, credits, semester, year, courseId);
    }

    private static void deleteCourse(CourseManager manager, Scanner sc) {
        System.out.print("Enter Course ID to delete: ");
        String courseId = sc.nextLine();

        String query = "DELETE FROM Course WHERE course_id = ?";
        manager.deleteCourse(query, courseId);
    }
}
