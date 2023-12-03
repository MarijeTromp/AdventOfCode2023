import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2 {

    public static void twoPointOne() throws FileNotFoundException {
        String filePath = "Input/Day2.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        Map<String, Integer> maxMap = new HashMap<>();
        maxMap.put("red", 12);
        maxMap.put("green", 13);
        maxMap.put("blue", 14);

        int total = 0;

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] splitColon = line.split(":");
            String[] splitSemiColon = splitColon[1].split(";");

            boolean flag = true;

            for(int i = 0; i < splitSemiColon.length; i++){
                String[] splitComma = splitSemiColon[i].split(",");
                for(int j = 0; j < splitComma.length; j++){
                    String[] splitSpace = splitComma[j].split(" ");

                    if(maxMap.get(splitSpace[2]) < Integer.parseInt(splitSpace[1])){
                        flag = false;
                    }
                }
            }
            if(flag) {
                String[] splitSpace = splitColon[0].split(" ");
                total += Integer.parseInt(splitSpace[1]);
            }

        }
        System.out.println(total);
    }

    public static void twoPointTwo() throws FileNotFoundException {
        String filePath = "Input/Day2.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        int total = 0;

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] splitColon = line.split(":");
            String[] splitSemiColon = splitColon[1].split(";");

            Map<String, Integer> minMap = new HashMap<>();
            minMap.put("red", 0);
            minMap.put("green", 0);
            minMap.put("blue", 0);

            for(int i = 0; i < splitSemiColon.length; i++){
                String[] splitComma = splitSemiColon[i].split(",");
                for(int j = 0; j < splitComma.length; j++){
                    String[] splitSpace = splitComma[j].split(" ");

                    if(minMap.get(splitSpace[2]) < Integer.parseInt(splitSpace[1])){
                        minMap.remove(splitSpace[2]);
                        minMap.put(splitSpace[2], Integer.parseInt(splitSpace[1]));
                    }
                }
            }

            total += (minMap.get("red") * minMap.get("green") * minMap.get("blue"));

        }
        System.out.println(total);
    }

    public static void main(String args[]){
        try{
            twoPointTwo();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
