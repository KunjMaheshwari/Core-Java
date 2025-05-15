import java.util.*;

class Student{
    private List<String> studentList = new ArrayList<>();
    public List<String> getStudentList(){
        return studentList;
    }

    public void setStudentList(List<String> studentList){
        this.studentList = studentList;
    }

    public void addStudentToList(String student){
        studentList.add(student);
    }

    public void sortStudentList(){
        Collections.sort(studentList);
    }

    public void removeStudentList(String student){
        studentList.remove(student);
    }
}

public class CollegeNamelist{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Student studentManager = new Student();

        while (true) { 
            System.out.println("1.Add");
            System.out.println("2.Display");
            System.out.println("3.Remove");
            System.out.println("4.Exit");
    
            System.out.println("Enter your choice");
            int userChoice = sc.nextInt();

            switch(userChoice){
                case 1:
                    System.out.println("Enter the student name");
                    String name = sc.nextLine();
                    studentManager.addStudentToList(name);
                    break;
                case 2:
                    if(studentManager.getStudentList().isEmpty()){
                        System.out.println("The student list is empty");
                        break;
                    }else{
                        studentManager.sortStudentList();
                        System.out.println(studentManager.getStudentList());
                        break;
                    }
                case 3:
                    if(studentManager.getStudentList().isEmpty()){
                        System.out.println("The student list is empty");
                        break;
                    }else{
                        System.out.println("Enter the student name");
                        String removedStudent = sc.nextLine();
                        if(!studentManager.getStudentList().contains(removedStudent)){
                            System.out.println("Student is not present in the list");
                            break;
                        }else{
                            studentManager.removeStudentList(removedStudent);
                            break;
                        }
                    }
                case 4:
                    System.out.println("Thank you for using the application");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}