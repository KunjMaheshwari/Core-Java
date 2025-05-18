import java.util.*;
import java.util.stream.*;

class Student {
    private String studentId;
    private String studentName;
    private int percentageScore;

    public Student() {}

    public Student(String studentId, String studentName, int percentageScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.percentageScore = percentageScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getPercentageScore() {
        return percentageScore;
    }

    public void setPercentageScore(int percentageScore) {
        this.percentageScore = percentageScore;
    }

    @Override
    public String toString() {
        return "Student Id: " + studentId + ", Student Name: " + studentName + ", Percentage Score: " + percentageScore;
    }
}

class StudentUtility {
    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Stream<Student> convertToStream() {
        return studentList.stream();
    }

    public List<Student> filterStudentInfo(Stream<Student> studentStream, int score) {
        return studentStream
                .filter(student -> student.getPercentageScore() > score)
                .sorted(Comparator.comparingInt(Student::getPercentageScore).reversed())
                .collect(Collectors.toList());
    }
}

public class StudentScoreInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentUtility utility = new StudentUtility();

        System.out.println("Enter the number of students");
        int n = sc.nextInt();
        sc.nextLine(); // consume the newline

        if (n <= 0) {
            System.out.println("Invalid number of students");
            return;
        }

        List<Student> students = new ArrayList<>();
        System.out.println("Enter the student details");

        for (int i = 0; i < n; i++) {
            String[] details = sc.nextLine().split("/");
            students.add(new Student(details[0], details[1], Integer.parseInt(details[2])));
        }

        utility.setStudentList(students);

        System.out.println("Enter the score to search:");
        int score = sc.nextInt();

        List<Student> filteredStudents = utility.filterStudentInfo(utility.convertToStream(), score);

        if (filteredStudents.isEmpty()) {
            System.out.println("No Students found");
        } else {
            System.out.println("Filtered students info whose score is above " + score + ":");
            filteredStudents.forEach(System.out::println);
        }

        sc.close();
    }
}