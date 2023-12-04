import java.io.*;
import java.util.*;
import java.lang.Math;
public class Day4 {

    public static void fourPointOne() throws FileNotFoundException {
        String filePath = "Input/Day4.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        int total = 0;

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] cardLine = line.split(": ");
            String[] numberLine = cardLine[1].split(" \\| ");

            String[] winningNumbers = numberLine[0].split(" ");
            String[] myNumbers = numberLine[1].split(" ");

            int matching = 0;

            for (int i = 0; i < winningNumbers.length; i++) {
                String num = winningNumbers[i];

                if(num.isEmpty()){
                    continue;
                }

                for(int j = 0; j < myNumbers.length; j++){
                    if(num.equals(myNumbers[j])){
                        matching++;
                    }
                }
            }

            if(matching ==0){
                continue;
            } else {
                total += (int) Math.pow(2, matching-1);
            }
        }
        System.out.println(total);
    }

    public static void fourPointTwo() throws FileNotFoundException {
        String filePath = "Input/Day4.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        List<Integer> numCards = new ArrayList<>();
        List<Integer> cardsWon = new ArrayList<>();

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] cardLine = line.split(": ");
            String[] numberLine = cardLine[1].split(" \\| ");

            String[] winningNumbers = numberLine[0].split(" ");
            String[] myNumbers = numberLine[1].split(" ");

            numCards.add(1);

            int matching = 0;

            for (int i = 0; i < winningNumbers.length; i++) {
                String num = winningNumbers[i];

                if(num.isEmpty()){
                    continue;
                }

                for(int j = 0; j < myNumbers.length; j++){
                    if(num.equals(myNumbers[j])){
                        matching++;
                    }
                }
            }

            cardsWon.add(matching);
        }

        for(int i = 0; i < numCards.size(); i++){
            int numCardsCurr = numCards.get(i);
            int cardsWonCurr = cardsWon.get(i);

            for(int j = 1; j <= cardsWonCurr; j++){
                if(i+j >= numCards.size()){
                    continue;
                } else {
                    int temp = numCards.get(i+j);
                    numCards.set(i+j, temp+(numCardsCurr));
                }
            }
        }

        int total = 0;

        for(int i = 0; i < numCards.size(); i++){
            total += numCards.get(i);
        }

        System.out.println(total);
    }

    public static void main(String args[]){
        try{
            fourPointTwo();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
