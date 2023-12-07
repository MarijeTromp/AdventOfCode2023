import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Day1 {

    public static void one_point_one() throws IOException {
        String filePath = "Input/generated_lines.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        FileWriter fileWriter = new FileWriter("labels.txt");
        BufferedWriter writer = new BufferedWriter(fileWriter);

        int total = 0;

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            char[] lineChar = line.toCharArray();

            boolean first = false;

            char[] numChar = new char[2];

            int line_length = lineChar.length;

            for(int i = 0; i < line_length; i++){
                if(!first && isNumber(lineChar[i])){
                    numChar[0] = lineChar[i];
                    first = true;
                }
                if(isNumber(lineChar[i])){
                    numChar[1] = lineChar[i];
                }
            }

            String numString = String.valueOf((char)numChar[0]) + String.valueOf((char)numChar[1]);
            writer.write(numString + "\n");

            total += Integer.valueOf(numString);
        }

        writer.close();

        System.out.println(total);

    }

    public static void one_point_two() throws FileNotFoundException {
        List<char[]> numberStrings = new ArrayList<>();
        numberStrings.add(new char[]{'o', 'n', 'e'});
        numberStrings.add(new char[]{'t', 'w', 'o'});
        numberStrings.add(new char[]{'t', 'h', 'r', 'e', 'e'});
        numberStrings.add(new char[]{'f', 'o', 'u', 'r'});
        numberStrings.add(new char[]{'f', 'i', 'v', 'e'});
        numberStrings.add(new char[]{'s', 'i', 'x'});
        numberStrings.add(new char[]{'s', 'e', 'v', 'e', 'n'});
        numberStrings.add(new char[]{'e', 'i', 'g', 'h', 't'});
        numberStrings.add(new char[]{'n', 'i', 'n', 'e'});
        numberStrings.add(new char[]{'t', 'e', 'n'});

        String filePath = "./Input/Day1.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        int total = 0;

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            char[] lineChar = line.toCharArray();

            int line_length = lineChar.length;

            char[] numChar = findNumbers(lineChar, line_length, numberStrings).toCharArray();

            String numString = String.valueOf((char)numChar[0]) + String.valueOf((char)numChar[numChar.length - 1]);

            total += Integer.valueOf(numString);

        }

        System.out.println(total);

    }

    public static String findNumbers(char[] chars, int lineLength, List<char[]> numberStrings){
        String answer = "";

        for(int i = 0; i < lineLength; i++){
            if(isNumber(chars[i])){
                answer += chars[i];
            } else {
                for(int j = 0; j < 9; j++){
                    char[] temp = numberStrings.get(j);
                    int tempLen = temp.length;

                    if(lineLength - i >= tempLen){
                        boolean flag = true;
                        for(int k = 0; k < tempLen; k++){
                            if(chars[i+k] != temp[k]){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            answer += Character.valueOf(Character.forDigit(j+1, 10));
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isNumber(char character){
        if(character == '0' || character == '1' || character == '2' || character == '3' || character == '4' || character == '5' || character == '6' || character == '7' || character == '8' || character == '9'){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        try{
            one_point_one();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
