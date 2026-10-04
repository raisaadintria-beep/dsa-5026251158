package lw03.prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Problem 1

        Scanner input = new Scanner (Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlists = new ArrayList<>();
        
        while(input.hasNextLine()) {
            String line = input.nextLine();
            String operation = line.substring(0, line.indexOf(" "));
            String details = line.substring(line.indexOf(" ") + 1);

            if (operation.equals("ADD")){
                String song = details;
                playlists.add(song);
            } else if (operation.equals("INSERT")){
                int index = Integer.parseInt(details.substring(0, details.indexOf(" ")));
                String song = details.substring(details.indexOf(" ") + 1);
                playlists.add(index, song);
            } else {
                String song = details;
                
                if (playlists.contains(song)){
                    playlists.remove(song);
                }
            }
        }

        System.out.println("===== Problem 1 =====");
        System.out.println("Total Songs: " + playlists.size());
        
        int nomor = 1;
        for (String abc : playlists){
            System.out.println(nomor + ":" + abc);
            nomor++;
        }



        //Problem 2

        Scanner input2 = new Scanner (Main.class.getResourceAsStream("participans.txt"));
        Set<String> participans = new LinkedHashSet<>();
        int duplicate=0;

        while(input2.hasNext()) {
            String name = input2.next();

            if (participans.contains(name)){
                duplicate++;
            } else {
                participans.add(name);
            }
        
        }

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique Participans: " + participans.size());
        
        int num = 1;

        for (String participan : participans){
            System.out.println(num + ". " + participan);
            num++;
        }
        System.out.println("Duplicate Participans: " + duplicate);
        


        //Problem 3

        Scanner input3 = new Scanner (Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int file = 0;

        while(input3.hasNextLine()){
            String line= input3.nextLine();
            String [] parts = line.split(" "); 

            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            
            if (type.equals("ADD")){
                if (inventory.containsKey(product)){
                    inventory.put(product, inventory.get(product)+quantity);
                } else {
                    inventory.put(product, quantity);
                }

            } else {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity){
                    inventory.put(product, inventory.get(product)-quantity);
                } else {
                    file++;
                }
            }
        }

        System.out.println("===== Problem 3 =====");
        for (String product : inventory.keySet()){
            System.out.println(product + ": " + inventory.get(product));
        }
        System.out.println("Failed Sales: " + file);
        }
    }
    

