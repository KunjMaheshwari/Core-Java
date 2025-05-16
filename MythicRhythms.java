import java.util.*;


class Customer{
    private int id;
    private String name;
    private long mobileNumber;

    public Customer(int id, String name, long mobileNumber){
        super();
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public long getMobileNumber(){
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber){
        this.mobileNumber = mobileNumber;
    }

}


abstract class MusicalInstrument{
    protected int instrumentId;
    protected String instrumentName;
    protected String instrumentType;
    protected double price;
    protected Customer customerObj;

    public MusicalInstrument(int instrumentId, String instrumentName, String instrumentType, double price, Customer customerObj){
        this.instrumentId = instrumentId;
        this.instrumentName = instrumentName;
        this.instrumentType = instrumentType;
        this.price = price;
        this.customerObj = customerObj;
    }

    public int getInstrumentId(){
        return instrumentId;
    }

    public void setInstrementId(int instrumentId){
        this.instrumentId = instrumentId;
    }

    public String getInstrumentName(){
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName){
        this.instrumentName =  instrumentName;
    }

    public String getInstrumentType(){
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType){
        this.instrumentType = instrumentType;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public Customer getCustomerObj(){
        return customerObj;
    }

    public void setCustomerObj(Customer customerObj){
        this.customerObj = customerObj;
    }

    abstract public double calculateTotalBill();
}

class StringInstrument extends MusicalInstrument{
    private int numberOfStrings;
    private String stringMaterial;


    public StringInstrument(int instrumentId, String instrumentName, String instrumentType, double price, Customer customerObj, int numberOfStrings, String stringMaterial){
        super(instrumentId, instrumentName, instrumentType, price, customerObj);
        this.numberOfStrings = numberOfStrings;
        this.stringMaterial = stringMaterial;
    }

    @Override
    public double calculateTotalBill(){
        if(this.stringMaterial.equalsIgnoreCase("Nylon")){
            double totalBill = this.getPrice() + (15.0*this.numberOfStrings);

            if(this.getPrice() > 20000){
                totalBill -= totalBill*0.3;
            }

            this.setPrice(totalBill);
            return totalBill;
        }else if (this.stringMaterial.equalsIgnoreCase("Steel")){
            double totalBill = this.getPrice() + (20.0 * this.numberOfStrings);

            if(this.getPrice() > 20000){
                totalBill -= totalBill*0.3;
            }

            this.setPrice(totalBill);
            return totalBill;
        }
        return -1;
    }
}


public class MythicRhythms {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Customer Details");
        String customerDetails = sc.nextLine();

        String details[] = customerDetails.split(":");
        int customerId = Integer.parseInt(details[0]);
        String customerName = details[1];
        long mobileNumber = Long.parseLong(details[2]);

        Customer customer = new Customer(customerId, customerName, mobileNumber);

        System.out.println("Enter the musical Instrument Details");
        String instrumentDetails = sc.nextLine();

        String insDetails[] = instrumentDetails.split(":");
        int instrumentId = Integer.parseInt(insDetails[0]);
        String instrumentName = insDetails[1];
        String instrumentType = insDetails[2];
        double price = Double.parseDouble(insDetails[3]);
        int numberOfStrings = Integer.parseInt(insDetails[4]);
        String stringMaterial = insDetails[5];

        if(!stringMaterial.equalsIgnoreCase("Nylon") || !stringMaterial.equalsIgnoreCase("Steel")){
            System.out.println("Invalid Input");
        }

        StringInstrument instrument = new StringInstrument(instrumentId, instrumentName, instrumentType, price,customer,numberOfStrings, stringMaterial );

        if(price > 20000){
            System.out.println("You have a discount! and your total is: "+ instrument.calculateTotalBill());

        }else{
            System.out.println("Total Bill is "+ instrument.calculateTotalBill());
        }

    }
}
