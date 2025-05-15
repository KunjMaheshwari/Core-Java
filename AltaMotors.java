import java.util.*;

class DepartmentGrouping{

    public HashSet<String> employeeSet = new HashSet<>();

    public HashSet<String> getEmployeeSet(){
        return employeeSet;
    }

    public void setEmployeeSet(HashSet<String> employeeSet){
        this.employeeSet = employeeSet;
    }


    public void addEmployeeId(String details){
        String parts[] = details.split(":");
        String employeeID = parts[0];

        if(employeeID.matches("[PQMS]\\d{3}")){
            employeeSet.add(employeeID);
        }
    }

    public HashSet<String> findDepartmentNameWithEmployeeId(){
        HashSet<String> result = new HashSet<>();

        for(String employeeID : employeeSet){
            String production = "";
            switch(employeeID.charAt(0)){
                case 'P':
                    production = "Product";
                    break;
                case 'Q':
                    production = "Quality";
                    break;
                case 'M':
                    production = "Maintenance";
                    break;
                case 'S':
                    production = "Sales";
                    break;
            }
            result.add(employeeID+" : "+ production);
        }
        return result;
    }   
}

public class AltaMotors{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        DepartmentGrouping dg = new DepartmentGrouping();
        System.out.println("Enter the number of details");
        int input = sc.nextInt();
        sc.nextLine();

        if(input <= 0){
            System.out.println("Invalid input from the user");
            return;
        }
        System.out.println("Enter the details");

        for(int i=0;i<input;i++){
            String inputString = sc.nextLine();
            dg.addEmployeeId(inputString);
        }

        HashSet<String> result = dg.findDepartmentNameWithEmployeeId();

        if(result.isEmpty()){
            System.out.println("All the provided employee ids are invalid");
        }else{
            for(String entry: result){
                System.out.println(entry);
            }
        }
    }
}