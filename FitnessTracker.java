import java.util.*;

interface FitnessMonitor{

    public abstract String findFitnessLevel();

    public static double calculateCaloriesBurnt(double weight, double distanceCovered, boolean runningStatus){
        if(runningStatus){
            return 0.75*weight*distanceCovered;
        }else{
            return 0.53*weight*distanceCovered;
        }
    }

}

class UserFitnessData implements FitnessMonitor{
    private String userName;
    private double weight;
    private int stepsTaken;
    private double distanceCovered;
    private boolean runningStatus;

    public UserFitnessData(){

    }

    public UserFitnessData(String userName, double weight, int stepsTaken, double distanceCovered, boolean runningStatus){
        this.userName = userName;
        this.weight = weight;
        this.stepsTaken = stepsTaken;
        this.distanceCovered = distanceCovered;
        this.runningStatus = runningStatus;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public int getStepsTaken(){
        return stepsTaken;
    }

    public void setStepsTaken(int stepsTaken){
        this.stepsTaken = stepsTaken;
    }

    public double getDistanceCovered(){
        return distanceCovered;
    }

    public void setDistanceCovered(double distanceCovered){
        this.distanceCovered = distanceCovered;
    }

    public boolean getRunningStatus(){
        return runningStatus;
    }

    public void setRunningStatus(boolean runningStatus){
        this.runningStatus = runningStatus;
    }


    public String findFitnessLevel(){
        double fitnessScore = ((0.1*stepsTaken)+(1.8*distanceCovered))/weight;

        if(fitnessScore <= 5){
            return "Low";
        }else if (fitnessScore <= 10){
            return "Moderate";
        }else{
            return "High";
        }
    }
}

public class FitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the user name");
        String name = sc.nextLine();

        System.out.println("Enter the weight in kg");
        double weight = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter number of steps taken");
        int steps = sc.nextInt();

        System.out.println("Enter distance covered in km");
        double distance = sc.nextDouble();

        System.out.println("Is the user running?(true/false)");
        boolean status = sc.nextBoolean();

        UserFitnessData uf = new UserFitnessData(name, weight, steps, distance, status);

        String fitnessLevel = uf.findFitnessLevel();

        double CaloriesBurnt = FitnessMonitor.calculateCaloriesBurnt(uf.getWeight(), uf.getDistanceCovered(), uf.getRunningStatus());

        System.out.println("User Name: "+ uf.getUserName());
        System.out.println("Weight: "+ uf.getWeight()+" kg");
        System.out.println("Steps Taken: "+ uf.getStepsTaken());
        System.out.println("Distance Covered: "+ uf.getDistanceCovered()+" km");
        System.out.println("Running: "+ uf.getRunningStatus());
        System.out.println("Fitness Level: "+ fitnessLevel);
        System.out.printf("Calories Burnt: %.2f", CaloriesBurnt);
    }
}
