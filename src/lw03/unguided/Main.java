package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) { 
        Scanner input = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        Map<String, Integer> enrollment = new LinkedHashMap<>();
        List<String> checkResults = new ArrayList<>();
        
        int rejected = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine();

            String[] parts = line.split(" ");
            String type = parts[0];
            String courseCode = parts[1];

            if (type.equals("REGISTER")) {
                int count = Integer.parseInt(parts[2]);
                if (count <= 0) {
                    rejected++;
                } else {
                    if (enrollment.containsKey(courseCode)) {
                        enrollment.put(courseCode, enrollment.get(courseCode) + count);
                    } else {
                        enrollment.put(courseCode, count);
                    }
                }

            } else if (type.equals("WITHDRAW")) {
                int count = Integer.parseInt(parts[2]);
                if (count <= 0 || !enrollment.containsKey(courseCode) || enrollment.get(courseCode) < count) {
                    rejected++;
                } else {
                    enrollment.put(courseCode, enrollment.get(courseCode) - count);
                }

            } else if (type.equals("CHECK")) {
                if (enrollment.containsKey(courseCode)) {
                    checkResults.add(courseCode + ": " + enrollment.get(courseCode) + " students");
                } else {
                    checkResults.add(courseCode + ": Not found");
                }
            }
        }
        input.close();

       
        System.out.println("===== Enrollment Checks =====");
        for (String result : checkResults) {
            System.out.println(result);
        }
        
        System.out.println("===== Final Enrollment =====");
        for (Map.Entry<String, Integer> entry : enrollment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " students");
        }

        System.out.println("Rejected operations: " + rejected);
    }
}
