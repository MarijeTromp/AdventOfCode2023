import java.io.*;
import java.util.*;

public class Day3 {
    public static void threePointOne() throws FileNotFoundException {
        String filePath = "Input/Day3.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        int total = 0;

        List<char[]> chars = new ArrayList<>();

        while(sc.hasNextLine()) {
            String lineInput = sc.nextLine();
            char[] line = lineInput.toCharArray();

            chars.add(line);
        }

        for(int i = 0; i < chars.size(); i++) {
            char[] line = chars.get(i);
            StringBuilder num = new StringBuilder();
            boolean flag = false;
            for(int j = 0; j < line.length; j++) {
                if(Day1.isNumber(line[j])){
                    num.append(line[j]);
                    if(!flag) {
                        flag = checkTouchingSymbol(chars, i, j);
                    }
                } else {
                    if(flag){
                        total += Integer.parseInt(String.valueOf(num));
                    }
                    num = new StringBuilder();
                    flag = false;
                }
            }
            if(flag){
                total += Integer.parseInt(String.valueOf(num));
            }
        }
        System.out.println(total);
    }

    public static boolean checkTouchingSymbol(List<char[]> chars, int i, int j){
        boolean iLargerThan0 = i > 0;
        boolean jLargerThan0 = j > 0;
        boolean iSmallerLen = i < chars.size() - 1;
        boolean jSmallerLen = j < chars.get(0).length - 1;


        if (iLargerThan0 && !Day1.isNumber(chars.get(i-1)[j]) && chars.get(i-1)[j] != '.') {
            return true;
        }
        if (iLargerThan0 && jLargerThan0 && !Day1.isNumber(chars.get(i-1)[j-1]) && chars.get(i-1)[j-1] != '.'){
            return true;
        }
        if (iLargerThan0 && jSmallerLen && !Day1.isNumber(chars.get(i-1)[j+1]) && chars.get(i-1)[j+1] != '.'){
            return true;
        }

        if (jLargerThan0 && !Day1.isNumber(chars.get(i)[j-1]) && chars.get(i)[j-1] != '.'){
            return true;
        }
        if (jSmallerLen && !Day1.isNumber(chars.get(i)[j+1]) && chars.get(i)[j+1] != '.'){
            return true;
        }

        if (iSmallerLen && !Day1.isNumber(chars.get(i+1)[j]) && chars.get(i+1)[j] != '.') {
            return true;
        }
        if (iSmallerLen && jLargerThan0 && !Day1.isNumber(chars.get(i+1)[j-1]) && chars.get(i+1)[j-1] != '.'){
            return true;
        }
        if (iSmallerLen && jSmallerLen && !Day1.isNumber(chars.get(i+1)[j+1]) && chars.get(i+1)[j+1] != '.'){
            return true;
        }

        return false;
    }

    public static void threePointTwo() throws FileNotFoundException {
        String filePath = "Input/Day3.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        int total = 0;

        List<char[]> chars = new ArrayList<>();

        while(sc.hasNextLine()) {
            String lineInput = sc.nextLine();
            char[] line = lineInput.toCharArray();

            chars.add(line);
        }

        for(int i = 0; i < chars.size(); i++) {
            char[] line = chars.get(i);
            StringBuilder num = new StringBuilder();
            boolean flag = false;
            for(int j = 0; j < line.length; j++) {
                if(line[j] == '*') {
                    List<Integer> adjacentNumbers = getAdjacentNumbers(chars, i, j);

                    if(adjacentNumbers.size() == 2) {
                        total += (adjacentNumbers.get(0) * adjacentNumbers.get(1));
                    }
                }
            }
            if(flag){
                total += Integer.parseInt(String.valueOf(num));
            }
        }
        System.out.println(total);
    }

    public static List<Integer> getAdjacentNumbers(List<char[]> chars, int i, int j){
        List<Integer> adjacentNumbers = new ArrayList<>();

        boolean iLargerThan0 = i > 0;
        boolean jLargerThan0 = j > 0;
        boolean iSmallerLen = i < chars.size() - 1;
        boolean jSmallerLen = j < chars.get(0).length - 1;


        if (iLargerThan0 && jLargerThan0 && Day1.isNumber(chars.get(i-1)[j-1])){
            adjacentNumbers.add(Integer.valueOf(getNumBefore(chars.get(i-1), j-1) + chars.get(i-1)[j-1] + getNumAfter(chars.get(i-1), j-1)));
        } else if (iLargerThan0 && Day1.isNumber(chars.get(i-1)[j])){
            adjacentNumbers.add(Integer.valueOf(chars.get(i-1)[j] + getNumAfter(chars.get(i-1), j)));
        }
        if (iLargerThan0 && jSmallerLen && !Day1.isNumber(chars.get(i-1)[j]) && Day1.isNumber(chars.get(i-1)[j+1])){
            adjacentNumbers.add(Integer.valueOf(chars.get(i-1)[j+1] + getNumAfter(chars.get(i-1), j+1)));
        }

        if (jLargerThan0 && Day1.isNumber(chars.get(i)[j-1])){
            adjacentNumbers.add(Integer.valueOf(getNumBefore(chars.get(i), j-1) + chars.get(i)[j-1]));
        }
        if (jSmallerLen && Day1.isNumber(chars.get(i)[j+1])){
            adjacentNumbers.add(Integer.valueOf(chars.get(i)[j+1] + getNumAfter(chars.get(i), j+1)));
        }

        if (iSmallerLen && jLargerThan0 && Day1.isNumber(chars.get(i+1)[j-1])){
            adjacentNumbers.add(Integer.valueOf(getNumBefore(chars.get(i+1), j-1) + chars.get(i+1)[j-1] + getNumAfter(chars.get(i+1), j-1)));
        } else if (iSmallerLen && Day1.isNumber(chars.get(i+1)[j])) {
            adjacentNumbers.add(Integer.valueOf(chars.get(i+1)[j] + getNumAfter(chars.get(i+1), j)));
        }
        if (iSmallerLen && jSmallerLen && !Day1.isNumber(chars.get(i+1)[j]) && Day1.isNumber(chars.get(i+1)[j+1])){
            adjacentNumbers.add(Integer.valueOf(chars.get(i+1)[j+1] + getNumAfter(chars.get(i+1), j+1)));
        }

        return adjacentNumbers;
    }

    public static String getNumBefore(char[] chars, int j){
        String num = "";

        while(j > 0){
            j--;

            if(Day1.isNumber(chars[j])){
                num = chars[j] + num;
            } else {
                break;
            }
        }

        return num;
    }

    public static String getNumAfter(char[] chars, int j) {
        String num = "";

        while(j < chars.length - 1){
            j++;

            if(Day1.isNumber(chars[j])){
                num += chars[j];
            } else {
                break;
            }
        }

        return num;
    }

    public static void main(String args[]){
        try{
            threePointTwo();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
