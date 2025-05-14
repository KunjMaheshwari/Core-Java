import java.util.*;

public class SquareSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Required Square Increment Sequence");
        int sqNumber = 0;
        for(int i=0;i<=10;i++){
            sqNumber = n*n+1;
            System.out.print(sqNumber+" ");
            n = n+1;
        }
    }
}
