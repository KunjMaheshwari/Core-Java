import java.util.*;

class Restaurant{
    private String customerName;
    private int orderNumber;
    private String deliveryType;
    private String foodName;
    private long phoneNumber;

    public Restaurant(String customerName, int orderNumber, String deliveryType, String foodName, long phoneNumber){
        this.customerName = customerName;
        this.orderNumber = orderNumber;
        this.deliveryType = deliveryType;
        this.foodName = foodName;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }

    public String getDeliveryType(){
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType){
        this.deliveryType = deliveryType;
    }

    public String getFoodName(){
        return foodName;
    }

    public void setFoodName(String foodName){
        this.foodName = foodName;
    }

    public long getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public double calculateTotalBill(double cost){
        double tax = 0;

        switch(deliveryType){
            case "HomeDelivery":
                tax = 0.8;
                break;
            case "Parcel":
                tax = 0.5;
                break;
            case "NormalOrder":
                tax = 0.3;
                break;
        }
        return (cost*tax)+cost;
    }
}

public class BrilliantRestaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name");
        String name = sc.nextLine();

        System.out.println("Enter the order number");
        int orderNumber = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the delivery type");
        String deliveryType = sc.nextLine();

        if(!deliveryType.equals("HomeDelivery") && !deliveryType.equals("Parcel") && !deliveryType.equals("NormalOrder")){
            System.out.println("Invalid Delivery Order");
            return;
        }

        System.out.println("Enter the food Name");
        String foodName = sc.nextLine();

        System.out.println("Enter the phone number");
        long phoneNumber = sc.nextLong();

        System.out.println("Enter the price of the item");
        double price = sc.nextDouble();

        Restaurant r = new Restaurant(name, orderNumber, deliveryType, foodName, phoneNumber);
        double bill = r.calculateTotalBill(price);

        System.out.println("Name "+ r.getCustomerName());
        System.out.println("Order Number "+ r.getCustomerName());
        System.out.println("Delivery Type "+ r.getDeliveryType());
        System.out.println("Food Name "+ r.getFoodName());
        System.out.println("Phone Number "+ r.getPhoneNumber());
        System.out.println("Bill Amount "+ bill);

    }
}
