import java.io.*;
import java.util.*;

public class Day6 {

    public static void sixPointOne() throws FileNotFoundException {
        String filePath = "Input/Day6.txt";

        int total = 1;

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        List<Integer> times = new ArrayList<>();
        sc.next();
        while(sc.hasNextInt()) {
            times.add(sc.nextInt());
        }

        List<Integer> distances = new ArrayList<>();
        sc.next();
        while(sc.hasNextInt()) {
            distances.add(sc.nextInt());
        }

        for(int i = 0; i < times.size(); i++) {
            int time = times.get(i);
            int distance = distances.get(i);

            int middle = time / 2;

            int possible = 0;

            // Check times before middle
            for(int j = middle; j >= 0; j--) {
                int possibleDistance = j * (time - j);

                if(possibleDistance > distance) {
                    possible += 2;
                } else {
                    break;
                }
            }

            if(time%2==0) {
                possible--;
            }

            total = total * possible;

        }

        System.out.println(total);
    }

    public static void sixPointTwo() throws FileNotFoundException {
        String filePath = "Input/Day6.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        String timeString = "";
        sc.next();
        while(sc.hasNextInt()) {
            timeString += Integer.toString(sc.nextInt());
        }

        String distanceString = "";
        sc.next();
        while(sc.hasNextInt()) {
            distanceString += Integer.toString(sc.nextInt());
        }

        long time = Long.parseLong(timeString);
        long distance = Long.parseLong(distanceString);

        long possible = Long.parseLong(timeString) + 1;

        for(long i = 0; i < time; i++) {
            if((i * (time - i)) > distance){
                break;
            } else {
                possible--;
            }
        }

        for(long i = time; i >= 0; i--) {
            if((i * (time - i)) > distance){
                break;
            } else {
                possible--;
            }
        }

        System.out.println(possible);
    }

    public static void main(String args[]){
        try{
            sixPointTwo();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
