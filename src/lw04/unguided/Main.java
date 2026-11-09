package lw04.unguided;

import java.util.*;

public class Main {
    static void sortCards(int [] arr , int passes) {
        for (int i = 0 ; i < passes && i < arr.length - 1; i++) {
            int index = i;
            for (int j= i+1 ; j<arr.length ; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    static int findCard(int[] arr , int target) {
        for (int i=0 ; i < arr.length ; i++){
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner ata = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int n = ata.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = ata.nextInt();
        }

        int m = ata.nextInt();
        int[] requests = new int[m];
        for (int i = 0; i < m; i++) {
            requests[i] = ata.nextInt();
        }

        ata.close();

        sortCards(cards, 2);
        
        for (int i=0 ; i<n ; i++) {
            if (i>0) {
                System.out.print(" ");
            }
            System.out.print(cards[i]);
        }
        System.out.println();

        for (int i=0 ; i<m ; i++) {
            int index = findCard(cards, requests[i]);
            if (index != -1) {
                System.out.println(requests[i] + ": FOUND at index" + index);
            } else {
                System.out.println(requests[i] + ": NOT FOUND");
            }
        }
    }
    
}
