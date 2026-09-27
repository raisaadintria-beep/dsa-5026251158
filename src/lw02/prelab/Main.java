package lw02.prelab;

import java.util.* ;

public class Main {
   public static void main(String[] args) {
     Scanner input = new Scanner (Main.class.getResourceAsStream("transaction.txt"));

     LinkedList <String[]> transactions = new LinkedList<>();
     LinkedList <String[]> customers = new LinkedList<>();
     Queue <String[]> process = new LinkedList<>();
     Stack <String[]> fail = new Stack<>();

     while (input.hasNext()) {
          String[] transaction = new String[3];
            transaction[0] = input.next();
            transaction[1] = input.next();
            transaction[2] = input.next();
            transactions.add(transaction);
     }

     process.addAll(transactions);

     while (!process.isEmpty()){
        String[] transaction = process.poll();
        String name = transaction[0];
        String type = transaction[1];
        int amount = Integer.parseInt(transaction[2]);
        
        String[] customer = null;
        for (String[] data : customers) {
            if (data[0].equals(name)) {
                customer = data;
                break;
            } 
            
        }  
        if (customer == null) {
            customer = new String[2];
            customer[0] = name;
            customer[1] = "0";
            customers.add(customer);
        }
        
        int balance = Integer.parseInt(customer[1]);
        if (type.equals("DEPOSIT")) {
           balance += amount;
           customer[1] = String.valueOf(balance);  
        } else {
             if  (balance < amount) {
             fail.push(transaction);
             } else {
                 balance -= amount;
                 customer[1] = String.valueOf(balance);

             }
        }
     } 
     
     System.out.println("=== Final Balances ===");
        for (String[] customer : customers) {
            System.out.println(customer[0] + " " + customer[1]);
        }

     System.out.println("=== Failed Transactions ===");
        while (!fail.isEmpty()) {
            String[] transaction = fail.pop();
            System.out.println(transaction[0] + " " + transaction[1] + " " + transaction[2]);
        }

        input.close();
    
    }


}


