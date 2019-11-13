package com.zzz.archive.nai._ddd;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class MigratoryBirds {
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer, Integer> birdRegister = new HashMap<>();
        for (int b : arr) {
            if (birdRegister.containsKey(b)) {
                birdRegister.put(b, birdRegister.get(b) + 1);
            } else {
             birdRegister.put(b,1);
            }
        }
        int maxValue = 0;
        int key = 0;
        for (HashMap.Entry<Integer, Integer> he : birdRegister.entrySet()) {
            if (he.getValue() > maxValue) {
                maxValue = he.getValue();
                key = he.getKey();
            } else if (he.getValue() == maxValue){
                key = (he.getKey() < key) ? he.getKey() : key;
            }
        }
        return key;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


