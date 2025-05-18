import java.util.*;

class InvalidPriceException extends Exception{
    public InvalidPriceException(String message){
        super(message);
    }
}

public class ProductDetails {

    public static boolean validateProductPrice(int price) throws InvalidPriceException{
        if(price >= 1 && price <= 20){
            return true;
        }else{
            throw new InvalidPriceException("Product price is invalid");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of product entries");

        int producEntries = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<producEntries;i++){
            System.out.println("Enter product "+ i+1+" details");
            String productDetails = sc.nextLine();

            String parts[] = productDetails.split(":");

            try{
            int productPrice = Integer.parseInt(parts[2]);

            if(validateProductPrice(productPrice)){
                System.out.println("Stocks Updated");
            }
            }catch(InvalidPriceException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
