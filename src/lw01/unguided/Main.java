package lw01.unguided;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
    Scanner input = new Scanner (Main.class.getResourceAsStream("rentals.txt"));

    int read = input.nextInt(); 
    Rental[] list = new Rental[read];

    for (int i=0 ; i<read ; i++) {
        
        String type = input.next();
        String id = input.next();
        int days = input.nextInt();
        int unit = input.nextInt();
        

        Rental rental;

        if (type.equals("LAPTOP")) {
            rental = new LaptopRental(id, days);
        } else {
            rental = new ProjectorRental(id, days);
        }

        list[i] = rental;
   }

   for (Rental rental : list ) {
    System.out.println(rental.summary());

   }
   input.close();  
   

}


}




