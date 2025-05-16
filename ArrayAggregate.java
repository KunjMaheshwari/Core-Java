import java.util.*;

public class ArrayAggregate{

    public static String sumOfArrays(String data){
        String parts[] = data.split(":");
        int arraySize;
        try{
            arraySize = Integer.parseInt(parts[0]);
        }catch(NumberFormatException e){
            throw new NumberFormatException("Provide a valid Integer");
        }

        if(arraySize < 0){
            throw new NegativeArraySizeException("Provide a positive number");
        }

        int array[] = new int[arraySize];
        int sum = 0;

        if(parts.length-1 != arraySize){
            throw new ArrayIndexOutOfBoundsException("Error: Index out of Bound");
        }

        try{
            for(int i=0;i<arraySize;i++){
                array[i] = Integer.parseInt(parts[i]);
                sum += array[i];
            }
        }catch(NumberFormatException e){
            throw new NumberFormatException("Provide a valid Value");
        }
        return "Sum of the array element is "+ sum;

    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the data");
        String data = sc.nextLine();

        try{
            String result = sumOfArrays(data);
            System.out.println(result);
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }catch(NegativeArraySizeException e){
            System.out.println(e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}