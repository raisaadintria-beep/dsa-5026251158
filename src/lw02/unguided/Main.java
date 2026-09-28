package lw02.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner ata = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();

        Queue<String[]> process = new LinkedList<>();
        Stack<String[]> fail = new Stack<>();

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});
        
        
        while (ata.hasNext()) {
            String[] request = new String[2];
            request[0] = ata.next();
            request[1] = ata.next();
            requests.add(request);
            
            String name = request[0];

            String[] member = null;
            for (String[] data : members) {
                if (data[0].equals(name)) {
                    member = data;
                    break;
                }
            }
            if (member == null) {
                members.add(new String[]{name, "0"});
            }
        }

        process.addAll(requests);

       
        System.out.println("=== Successfully Processed Requests ===");

        
        while (!process.isEmpty()) {
            String[] request = process.poll();
            String name = request[0];
            String bookTitle = request[1];

            String[] targetBook = null;
            for (String[] book : books) {
                if (book[0].equals(bookTitle)) {
                    targetBook = book;
                    break;
                }
            }

            String[] targetMember = null;
            for (String[] member : members) {
                if (member[0].equals(name)) {
                    targetMember = member;
                    break;
                }
            }

            int currentStock = Integer.parseInt(targetBook[1]);
            int currentBorrowed = Integer.parseInt(targetMember[1]);

            if (currentStock > 0 && currentBorrowed < 2) {
                targetBook[1] = String.valueOf(currentStock - 1);
                targetMember[1] = String.valueOf(currentBorrowed + 1);
                
                
                System.out.println(request[0] + " " + request[1]);
            } else {
                fail.push(request);
            }
        }

        System.out.println();

        System.out.println("=== Remaining Book Stock ===");
        for (String[] book : books) {
            System.out.println(book[0] + " : " + book[1]);
        }

        System.out.println();

        System.out.println("=== Failed Requests ===");
        while (!fail.isEmpty()) {
            String[] failedReq = fail.pop();
            System.out.println(failedReq[0] + " " + failedReq[1]);
        }

        ata.close(); 
    }
}