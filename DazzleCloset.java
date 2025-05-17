import java.util.*;

class Order {
    private String dressCode;
    private String style;
    private String material;
    private String size;
    private double price;

    public Order(String dressCode, String style, String material, String size, double price) {
        this.dressCode = dressCode;
        this.style = style;
        this.material = material;
        this.size = size;
        this.price = price;
    }

    public Order(String dressCode, String style, String material, double price) {
        this.dressCode = dressCode;
        this.style = style;
        this.material = material;
        this.size = "XL";
        this.price = price;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String dressCode) {
        this.dressCode = dressCode;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static double calculateBill(double basePrice, String preferredSize) {
        if (preferredSize.equalsIgnoreCase("XXL") || preferredSize.equalsIgnoreCase("XXXL") || preferredSize.equalsIgnoreCase("XXXXL")) {
            return (basePrice + 100.0);
        } else if (preferredSize.equalsIgnoreCase("S") || preferredSize.equalsIgnoreCase("M") || preferredSize.equalsIgnoreCase("XL")) {
            return basePrice;
        } else {
            System.out.println("Wrong size input");
            return -1;
        }
    }
}

public class DazzleCloset {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dress code");
        String dressCode = sc.nextLine();

        System.out.println("Enter the dress style");
        String dressStyle = sc.nextLine();

        System.out.println("Enter the dress Material");
        String dressMaterial = sc.nextLine();

        System.out.println("Enter the dress price");
        double dressPrice = sc.nextDouble();
        sc.nextLine(); // consume leftover newline

        System.out.println("Preferred Size XL? (Yes/No)");
        String preferredSizeAnswer = sc.nextLine();

        String dressSize;
        double bill;

        if (preferredSizeAnswer.equalsIgnoreCase("yes")) {
            dressSize = "XL";
            bill = Order.calculateBill(dressPrice, dressSize);
        } else {
            System.out.println("Enter your Preferred Size");
            dressSize = sc.nextLine();
            bill = Order.calculateBill(dressPrice, dressSize);
        }

        if (bill != -1) {
            Order o = new Order(dressCode, dressStyle, dressMaterial, dressSize, bill);
            System.out.println("Dress Code: " + o.getDressCode());
            System.out.println("Dress Style: " + o.getStyle());
            System.out.println("Material Type: " + o.getMaterial());
            System.out.println("Dress Size: " + o.getSize());
            System.out.println("Dress Price: " + o.getPrice());
        }
    }
}