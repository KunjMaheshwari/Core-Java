import java.util.*;

public class WordZee {
    public static boolean checkSentence(String sentence) {
        return sentence.matches("[a-zA-Z ]+");
    }

    public static boolean checkWord(String word) {
        return word.matches("[a-zA-Z ]+");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String sentence = sc.nextLine();

        if (!checkSentence(sentence)) {
            System.out.println(sentence + " is an invalid sentence");
            return;
        }

        System.out.println("Enter a word");
        String word = sc.nextLine();


        if (!checkWord(word)) {
            System.out.println(word + " is an invalid word");
        }

        if (!sentence.contains(word)) {
            System.out.println(word + " is not in the sentence");
        } else {
            String reveredWord = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reveredWord += word.charAt(i);
            }

            String modified = sentence.replace(word, reveredWord);

            System.out.println(modified);
        }

    }
}