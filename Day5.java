import java.io.*;
import java.util.*;
public class Day5 {

    public static List<List<long[]>> getLists(Scanner sc) {
        List<long[]> seedToSoil = new ArrayList<>();
        List<long[]> soilToFertilizer = new ArrayList<>();
        List<long[]> fertilizerToWater = new ArrayList<>();
        List<long[]> waterToLight = new ArrayList<>();
        List<long[]> lightToTemperature = new ArrayList<>();
        List<long[]> temperatureToHumidity = new ArrayList<>();
        List<long[]> humidityToLocation = new ArrayList<>();

        // Seed to soil
        boolean flag = true;
        while(flag){
            String line = sc.nextLine();
            if(line == ""){
                flag = false;
            } else {
                String[] seedToSoilStrings = line.split(" ");
                long[] seedToSoilLongs = {Long.parseLong(seedToSoilStrings[1]), Long.parseLong(seedToSoilStrings[0]), Long.parseLong(seedToSoilStrings[2])};
                seedToSoil.add(seedToSoilLongs);
            }
        }
        sc.nextLine();

        // Soil to fertilizer
        flag = true;
        while(flag){
            String line = sc.nextLine();
            if(line == ""){
                flag = false;
            } else {
                String[] soilToFertilizerStrings = line.split(" ");
                long[] soilToFertilizerLongs = {Long.parseLong(soilToFertilizerStrings[1]), Long.parseLong(soilToFertilizerStrings[0]), Long.parseLong(soilToFertilizerStrings[2])};
                soilToFertilizer.add(soilToFertilizerLongs);
            }
        }
        sc.nextLine();

        // Fertilizer to water
        flag = true;
        while(flag){
            String line = sc.nextLine();
            if(line == ""){
                flag = false;
            } else {
                String[] fertilizerToWaterStrings = line.split(" ");
                long[] fertilizerToWaterLongs = {Long.parseLong(fertilizerToWaterStrings[1]), Long.parseLong(fertilizerToWaterStrings[0]), Long.parseLong(fertilizerToWaterStrings[2])};
                fertilizerToWater.add(fertilizerToWaterLongs);
            }
        }
        sc.nextLine();

        // Water to light
        flag = true;
        while(flag){
            String line = sc.nextLine();
            if(line == ""){
                flag = false;
            } else {
                String[] waterToLightStrings = line.split(" ");
                long[] waterToLightLongs = {Long.parseLong(waterToLightStrings[1]), Long.parseLong(waterToLightStrings[0]), Long.parseLong(waterToLightStrings[2])};
                waterToLight.add(waterToLightLongs);
            }
        }
        sc.nextLine();

        // Light to temperature
        flag = true;
        while(flag){
            String line = sc.nextLine();
            if(line == ""){
                flag = false;
            } else {
                String[] lightToTempStrings = line.split(" ");
                long[] lightToTempLongs = {Long.parseLong(lightToTempStrings[1]), Long.parseLong(lightToTempStrings[0]), Long.parseLong(lightToTempStrings[2])};
                lightToTemperature.add(lightToTempLongs);
            }
        }
        sc.nextLine();

        // Temperature to humidity
        flag = true;
        while(flag){
            String line = sc.nextLine();
            if(line == ""){
                flag = false;
            } else {
                String[] tempToHumStrings = line.split(" ");
                long[] tempToHumLongs = {Long.parseLong(tempToHumStrings[1]), Long.parseLong(tempToHumStrings[0]), Long.parseLong(tempToHumStrings[2])};
                temperatureToHumidity.add(tempToHumLongs);
            }
        }
        sc.nextLine();

        // Humidity to location
        flag = true;
        while(flag){
            if(!sc.hasNextLine()){
                flag = false;
            } else {
                String line = sc.nextLine();
                String[] humToLocStrings = line.split(" ");
                long[] humToLocLongs = {Long.parseLong(humToLocStrings[1]), Long.parseLong(humToLocStrings[0]), Long.parseLong(humToLocStrings[2])};
                humidityToLocation.add(humToLocLongs);
            }
        }

        List<List<long[]>> result = new ArrayList<>();
        result.add(seedToSoil);
        result.add(soilToFertilizer);
        result.add(fertilizerToWater);
        result.add(waterToLight);
        result.add(lightToTemperature);
        result.add(temperatureToHumidity);
        result.add(humidityToLocation);

        return result;
    }

    public static long getLocation(long seed, List<long[]> seedToSoil, List<long[]> soilToFertilizer, List<long[]> fertilizerToWater, List<long[]> waterToLight, List<long[]> lightToTemperature, List<long[]> temperatureToHumidity, List<long[]> humidityToLocation) {
        boolean flag = false;
        for(int j = 0; j < seedToSoil.size(); j++){
            long[] seedToSoilLongs = seedToSoil.get(j);

            long diff = seed - seedToSoilLongs[0];
            if((diff >= 0) && (diff < seedToSoilLongs[2]) && !flag){
                seed = seedToSoilLongs[1] + diff;
                flag = true;
            }
        }

        flag = false;
        for(int j = 0; j < soilToFertilizer.size(); j++){
            long[] soilToFertLongs = soilToFertilizer.get(j);

            long diff = seed - soilToFertLongs[0];
            if((diff >= 0) && (diff < soilToFertLongs[2]) && !flag){
                seed = soilToFertLongs[1] + diff;
                flag = true;
            }
        }

        flag = false;
        for(int j = 0; j < fertilizerToWater.size(); j++){
            long[] fertToWaterLongs = fertilizerToWater.get(j);

            long diff = seed - fertToWaterLongs[0];
            if((diff >= 0) && (diff < fertToWaterLongs[2]) && !flag){
                seed = fertToWaterLongs[1] + diff;
                flag = true;
            }
        }

        flag = false;
        for(int j = 0; j < waterToLight.size(); j++){
            long[] waterToLightLongs = waterToLight.get(j);

            long diff = seed - waterToLightLongs[0];
            if((diff >= 0) && (diff < waterToLightLongs[2]) && !flag){
                seed = waterToLightLongs[1] + diff;
                flag = true;
            }
        }

        flag = false;
        for(int j = 0; j < lightToTemperature.size(); j++){
            long[] lightToTempLongs = lightToTemperature.get(j);

            long diff = seed - lightToTempLongs[0];
            if((diff >= 0) && (diff < lightToTempLongs[2]) && !flag){
                seed = lightToTempLongs[1] + diff;
                flag = true;
            }
        }

        flag = false;
        for(int j = 0; j < temperatureToHumidity.size(); j++){
            long[] tempToHumLongs = temperatureToHumidity.get(j);

            long diff = seed - tempToHumLongs[0];
            if((diff >= 0) && (diff < tempToHumLongs[2]) && !flag){
                seed = tempToHumLongs[1] + diff;
                flag = true;
            }
        }

        flag = false;
        for(int j = 0; j < humidityToLocation.size(); j++){
            long[] humToLocLongs = humidityToLocation.get(j);

            long diff = seed - humToLocLongs[0];
            if((diff >= 0) && (diff < humToLocLongs[2]) && !flag){
                seed = humToLocLongs[1] + diff;
                flag = true;
            }
        }

        return seed;
    }

    public static void fivePointOne() throws FileNotFoundException {
        String filePath = "Input/Day5.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        List<Long> seeds = new ArrayList<>();

        // Seeds
        String[] seedsStrings = sc.nextLine().split(": ")[1].split(" ");
        for(int i = 0; i < seedsStrings.length; i++){
            seeds.add(Long.parseLong(seedsStrings[i]));
        }
        sc.nextLine();
        sc.nextLine();

        List<List<long[]>> result = getLists(sc);
        List<long[]> seedToSoil = result.get(0);
        List<long[]> soilToFertilizer = result.get(1);
        List<long[]> fertilizerToWater = result.get(2);
        List<long[]> waterToLight = result.get(3);
        List<long[]> lightToTemperature = result.get(4);
        List<long[]> temperatureToHumidity = result.get(5);
        List<long[]> humidityToLocation = result.get(6);

        long min_location = Long.MAX_VALUE;
        for(int i = 0; i < seeds.size(); i++){
            long seed = seeds.get(i);

            seed = getLocation(seed, seedToSoil, soilToFertilizer, fertilizerToWater, waterToLight, lightToTemperature, temperatureToHumidity, humidityToLocation);

            if(seed < min_location) {
                min_location = seed;
            }
        }
        System.out.println(min_location);
    }

    public static void fivePointTwo() throws FileNotFoundException {
        String filePath = "Input/Day5.txt";

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        List<long[]> seeds = new ArrayList<>();

        // Seeds
        String[] seedsStrings = sc.nextLine().split(": ")[1].split(" ");
        for(int i = 0; i < seedsStrings.length; i += 2){
            long startSeed = Long.parseLong(seedsStrings[i]);
            long range = Long.parseLong(seedsStrings[i+1]);

            seeds.add(new long[]{startSeed, range});
        }
        sc.nextLine();
        sc.nextLine();

        List<List<long[]>> result = getLists(sc);
        List<long[]> seedToSoil = result.get(0);
        List<long[]> soilToFertilizer = result.get(1);
        List<long[]> fertilizerToWater = result.get(2);
        List<long[]> waterToLight = result.get(3);
        List<long[]> lightToTemperature = result.get(4);
        List<long[]> temperatureToHumidity = result.get(5);
        List<long[]> humidityToLocation = result.get(6);

        long min_location = Long.MAX_VALUE;
        for(int i = 0; i < seeds.size(); i++){
            long[] seedAndRange = seeds.get(i);
            long start = seedAndRange[0];
            long range = seedAndRange[1];

            for(long j = 0; j < range; j++) {
                long seed = start + j;

                seed = getLocation(seed, seedToSoil, soilToFertilizer, fertilizerToWater, waterToLight, lightToTemperature, temperatureToHumidity, humidityToLocation);

                if(seed < min_location) {
                    min_location = seed;
                }
            }

        }
        System.out.println(min_location);
    }

    public static void main(String args[]){
        try{
            fivePointTwo();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
