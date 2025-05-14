import java.util.*;

public class FishingCompetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split(":");

        String participantName = parts[0];
        int participantAge = Integer.parseInt(parts[1]);
        int bigFish = Integer.parseInt(parts[2]);
        int mediumFish = Integer.parseInt(parts[3]);
        int smallFish = Integer.parseInt(parts[4]);

        if(participantAge < 18){
            System.out.println(participantAge+" is an invalid age");
            return;
        }

        if(bigFish < 0){
            System.out.println(bigFish+" is an invalid input");
            return;
        }
        if(mediumFish < 0){
            System.out.println(mediumFish+" is an invalid input");
            return;
        }
        if(smallFish < 0){
            System.out.println(smallFish+" is an invalid input");
            return;
        }

        int totalFishCount = bigFish*10 + mediumFish*6 + smallFish*3;

        if(totalFishCount < 0){
            System.out.println(totalFishCount+" is an invalid input");
            return;
        }

        System.out.println(participantName+" scored "+ totalFishCount+" points");
    }
}
