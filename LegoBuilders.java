import java.util.*;


class LegoBuildersClass{
    protected String productId;
    protected String productType;

    public LegoBuildersClass(String productId, String productType){
        this.productId = productId;
        this.productType = productType;
    }

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getProductType(){
        return productType;
    }

    public void setProductType(String productType){
        this.productType = productType;
    }
}

class ElectricalItemDetails extends LegoBuildersClass{
    private String productName;
    private int quantity;
    double price;

    public ElectricalItemDetails(String productId, String productType, String productName, int quantity, double price){
        super(productId, productName);
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double calculateTotalBill(){

        if(productName.equalsIgnoreCase("wire") || productName.equalsIgnoreCase("ElectricalPipe")){
            return quantity*price;
        }
        return 0;
    }


}

class PlumbingItemDetails extends LegoBuildersClass{
    private String productName;
    private int quantity;
    private double price;

    public PlumbingItemDetails(String productId, String productType, String productName, int quantity, double price){
        super(productId, productType);
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double calculateTotalBill(){
        if(productName.equalsIgnoreCase("Tube") || productName.equalsIgnoreCase("PlumbingPipe")){
            return quantity*price;
        }
        return 0;
    }
}

public class LegoBuilders{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Product Id");
        String productId = sc.nextLine();

        System.out.println("Enter the Product Type");
        String productType = sc.nextLine();

        if(!productType.equalsIgnoreCase("ElectricalItem") || !productType.equalsIgnoreCase("PlumbingItem")){
            System.out.println(productType +" is an invalid product type");
            return;
        }

        System.out.println("Enter the Product Name");
        String productName = sc.nextLine();

        System.out.println("Enter the Quantity");
        int quantity = sc.nextInt();

        System.out.println("Enter the Price");
        double price = sc.nextDouble();
        
        double bill = 0.0;

        if(productType.equalsIgnoreCase("ElectricalItem")){
            ElectricalItemDetails ed = new ElectricalItemDetails(productId, productType, productName, quantity, price);

            bill = ed.calculateTotalBill();
        }

        if(productType.equalsIgnoreCase("PlumbingItem")){
            PlumbingItemDetails pb = new PlumbingItemDetails(productId, productType, productName, quantity, price);

            bill = pb.calculateTotalBill();
        }

        if(bill ==0){
            System.out.println("Product not available ");
        }else{
            System.out.println("Bill Amount is "+ bill);
        }
        
    }
}
