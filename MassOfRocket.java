import java.util.*;

class RocketComponent{
    private String name;
    private double weight;
    private final double accelerationDurToGravity = 9.8;
    private String material;
    private double costOfProduction;


    public RocketComponent(String name, double weight, String material, double costOfProduction){
        this.name = name;
        this.weight = weight;
        this.material = material;
        this.costOfProduction = costOfProduction;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public String getMaterial(){
        return material;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public double getCostOfProduction(){
        return costOfProduction;
    }

    public void setCostOfProduction(double costOfProduction){
        this.costOfProduction = costOfProduction;
    }

    public double getAccelerationDueToGravity(){
        return accelerationDurToGravity;
    }


    public double calculateMassOfRocketComponent(double weight){
        if(weight >1){
            double result = weight/accelerationDurToGravity;
            return Math.round(result*100.0)/100.0;
        }
        return -1;
    }
}


public class MassOfRocket {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the component name");
        String name = sc.nextLine();

        System.out.println("Enter the component weight on earth");
        double weight = sc.nextDouble();

        System.out.println("Enter the material used");
        String material = sc.nextLine();

        System.out.println("Enter the cost of production");
        Double costOfProduction = sc.nextDouble();
        sc.nextLine();

        RocketComponent rc = new RocketComponent(name, weight, material, costOfProduction);

        double result = rc.calculateMassOfRocketComponent(weight);

        if(result == -1){
            System.out.println(weight +" Newton is an invalid weight");
            return;
        }
        

        System.out.println("Rocket Component");
        System.out.println("Name "+ rc.getName());
        System.out.println("Weight "+ rc.getWeight());
        System.out.println("AccelerationDueToGravity is: "+ rc.getAccelerationDueToGravity());
        System.out.println("Mass "+ result);
        System.out.println("Material Used "+ rc.getMaterial());
        System.out.println("Cost of Production "+ rc.getCostOfProduction());
    }
}
