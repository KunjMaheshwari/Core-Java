import java.util.*;

abstract class PhonePlan {
    protected String providerName;
    protected String planName;
    protected String talkTime;
    protected int data;
    protected int smsPerDay;
    protected String planType;

    public PhonePlan(String providerName, String planName, String talkTime, int data, int smsPerDay, String planType) {
        this.providerName = providerName;
        this.planName = planName;
        this.talkTime = talkTime;
        this.data = data;
        this.smsPerDay = smsPerDay;
        this.planType = planType;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(String talkTime) {
        this.talkTime = talkTime;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getSmsPerDay() {
        return smsPerDay;
    }

    public void setSmsPerDay(int smsPerDay) {
        this.smsPerDay = smsPerDay;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    abstract public double findPlanAmount();
}

class PostpaidPlan extends PhonePlan {
    private String dataCarryOver;
    private String subscription;

    public PostpaidPlan(String providerName, String planName, String talkTime, int data, int smsPerDay, String planType, String dataCarryOver) {
        super(providerName, planName, talkTime, data, smsPerDay, planType);
        this.dataCarryOver = dataCarryOver;
    }

    public String getDataCarryOver() {
        return dataCarryOver;
    }

    public void setDataCarryOver(String dataCarryOver) {
        this.dataCarryOver = dataCarryOver;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public double findPlanAmount() {
        if (!providerName.equalsIgnoreCase("Airtel") && !providerName.equalsIgnoreCase("Jio")) {
            return -1;
        }

        if (!planName.equalsIgnoreCase("regular-postpay") &&
            !planName.equalsIgnoreCase("family plan for 2") &&
            !planName.equalsIgnoreCase("family plan for 5") &&
            !planName.equalsIgnoreCase("family plan for 8")) {
            return -1;
        }

        if (providerName.equalsIgnoreCase("Airtel")) {
            if (planName.equalsIgnoreCase("regular-postpay")) {
                subscription = "Wynk Music";
                return 399;
            } else if (planName.equalsIgnoreCase("family plan for 2")) {
                subscription = "Wynk Music, Prime";
                return 599;
            } else if (planName.equalsIgnoreCase("family plan for 5")) {
                subscription = "Wynk Music, Prime, Extra 5GB data";
                return 999;
            } else if (planName.equalsIgnoreCase("family plan for 8")) {
                subscription = "Wynk Music, Prime, Netflix, Extra 10GB data";
                return 1599;
            }
        } else if (providerName.equalsIgnoreCase("Jio")) {
            if (planName.equalsIgnoreCase("regular-postpay")) {
                subscription = "Jio Music";
                return 500;
            } else if (planName.equalsIgnoreCase("family plan for 2")) {
                subscription = "Jio Music, Prime";
                return 720;
            } else if (planName.equalsIgnoreCase("family plan for 5")) {
                subscription = "Jio Music, Prime, Extra 5GB data";
                return 980;
            } else if (planName.equalsIgnoreCase("family plan for 8")) {
                subscription = "Jio Music, Prime, Netflix, Extra 10GB data";
                return 1650;
            }
        }
        return -1;
    }
}

class PrepaidPlan extends PhonePlan {
    private int validity;
    private double extraData;

    public PrepaidPlan(String providerName, String planName, String talkTime, int data, int smsPerDay, String planType, int validity, double extraData) {
        super(providerName, planName, talkTime, data, smsPerDay, planType);
        this.validity = validity;
        this.extraData = extraData;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public double getExtraData() {
        return extraData;
    }

    public void setExtraData(double extraData) {
        this.extraData = extraData;
    }

    public double findPlanAmount() {
        if (!providerName.equalsIgnoreCase("Airtel") && !providerName.equalsIgnoreCase("Jio")) {
            return -1;
        }

        if (data != 2 && data != 3) {
            return -1;
        }

        if (validity != 28 && validity != 56 && validity != 84) {
            return -1;
        }

        if (providerName.equalsIgnoreCase("Airtel")) {
            if (data == 2) {
                if (validity == 28) return 299;
                if (validity == 56) return 549;
                if (validity == 84) return 839;
            } else if (data == 3) {
                if (validity == 28) return 399;
                if (validity == 56) return 649;
                if (validity == 84) return 939;
            }
        } else if (providerName.equalsIgnoreCase("Jio")) {
            if (data == 2) {
                if (validity == 28) return 389;
                if (validity == 56) return 620;
                if (validity == 84) return 939;
            } else if (data == 3) {
                if (validity == 28) return 400;
                if (validity == 56) return 749;
                if (validity == 84) return 839;
            }
        }
        return -1;
    }
}

public class PlanSmart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the network provider name:");
        String providerName = sc.nextLine();

        System.out.println("Enter the plan name:");
        String planName = sc.nextLine();

        System.out.println("Enter the talk Time plan:");
        String talkTime = sc.nextLine();

        System.out.println("Enter the data plan (in GB):");
        int data = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the SMS Plan (per/day):");
        int smsPerDay = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the plan Type:");
        String planType = sc.nextLine();

        if (!planType.equalsIgnoreCase("prepaidplan") && !planType.equalsIgnoreCase("postpaidplan")) {
            System.out.println("Please provide a valid Plan Type");
            return;
        }

        if (planType.equalsIgnoreCase("prepaidplan")) {
            System.out.println("Enter the validity:");
            int validity = sc.nextInt();

            System.out.println("Enter the extra data provided:");
            double extraData = sc.nextDouble();

            PrepaidPlan pr = new PrepaidPlan(providerName, planName, talkTime, data, smsPerDay, planType, validity, extraData);

            System.out.println("Provider Name: " + pr.getProviderName());
            System.out.println("Plan Name: " + pr.getPlanName());
            System.out.println("Talk Time: " + pr.getTalkTime());
            System.out.println("Data for the plan: " + pr.getData());
            System.out.println("SMS for the plan: " + pr.getSmsPerDay());
            System.out.println("Plan Type: " + pr.getPlanType());
            System.out.println("Validity for the plan: " + pr.getValidity());
            System.out.println("Extra data for the plan: " + pr.getExtraData());
            double amount = pr.findPlanAmount();
            if (amount == -1) {
                System.out.println("Invalid plan details.");
            } else {
                System.out.printf("Plan Amount to be paid for truly unlimited plan is Rs. %.2f\n", amount);
            }

        } else if (planType.equalsIgnoreCase("postpaidplan")) {
            System.out.println("Enter the data carry over option:");
            String dataCarryOver = sc.nextLine();

            PostpaidPlan pp = new PostpaidPlan(providerName, planName, talkTime, data, smsPerDay, planType, dataCarryOver);

            System.out.println("Provider Name: " + pp.getProviderName());
            System.out.println("Plan Name: " + pp.getPlanName());
            System.out.println("Talk Time: " + pp.getTalkTime());
            System.out.println("Data for the plan: " + pp.getData());
            System.out.println("SMS for the plan: " + pp.getSmsPerDay());
            System.out.println("Plan Type: " + pp.getPlanType());
            System.out.println("Data Carry Over: " + pp.getDataCarryOver());
            double amount = pp.findPlanAmount();
            if (amount == -1) {
                System.out.println("Invalid plan details.");
            } else {
                System.out.printf("Plan Amount to be paid for postpaid plan is Rs. %.2f\n", amount);
                System.out.println("Subscription Benefits: " + pp.getSubscription());
            }
        }
    }
}