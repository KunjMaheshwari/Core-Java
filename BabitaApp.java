import java.util.*;

public class BabitaApp{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the paragraph typed");
        String paragraph = sc.nextLine();
        paragraph = paragraph.toLowerCase();

        String words[] = paragraph.split("[a-zA-Z']+");

        TreeMap<String, Integer> map = new TreeMap<>();

        int totalWords = 0;

        for(String word : words){
            word = word.trim();

            if(!word.isEmpty()){
                totalWords++;
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }

        System.out.println("Total number of words "+ totalWords);
        System.out.println("Words with the count ");

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+" - "+ entry.getValue());
        }
    }
}