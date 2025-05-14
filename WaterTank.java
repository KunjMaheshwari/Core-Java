import java.util.*;

public class WaterTank {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the radius");
        int radius = sc.nextInt();

        if(radius <= 0){
            System.out.println("Invalid measurement");
            return;
        }

        System.out.println("Enter the height");
        int height = sc.nextInt();

        if(height <= 0){
            System.out.println("Invalid measurements");
            return;
        }

        double volumeOfCylinder = 3.14 * radius * radius * height;

        double capacity = 0.75*volumeOfCylinder;

        System.out.printf("Total Volume of the tank is %.2f litres%n", volumeOfCylinder);
        System.out.printf("Total Capacity %.2f litres%n",capacity);

    }
}
