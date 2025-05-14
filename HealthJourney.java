import java.util.*;

public class HealthJourney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.nextLine();

        System.out.println("Enter your height in meters");
        double height = sc.nextDouble();

        System.out.println("Enter your weight in kilograms");
        double weight = sc.nextDouble();

        double BMI = (weight/(height*height));
        String BMICal = String.format("%.2f", BMI);

        if(BMI < 18.5){
            System.out.println("Hello "+ name+", Your BMI is "+ BMICal);
            System.out.println("You are under the category Under weight");
        }else if (BMI < 25){
            System.out.println("Hello "+ name+", Your BMI is "+ BMICal);
            System.out.println("You are under the category Normal Weight");
        }else if (BMI <= 30){
            System.out.println("Hello "+ name+", Your BMI is "+ BMICal);
            System.out.println("You are under the category Over Weight");
        }else if(BMI > 30){
            System.out.println("Hello "+ name+", Your BMI is "+ BMICal);
            System.out.println("You are under the category Obese");
        }

    }
}
