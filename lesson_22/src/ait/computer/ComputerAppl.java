package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        double a = 10; //upper casting
        int b = (int) a; //down casting
        Computer[] shop = new Computer[5];
        shop[0] = new Computer("i5", 12, 512, "HP");
        shop[1] = new Laptop("i7", 16, 512, "Asus", 3, 2.1);//upper casting from Laptop to Computer
        shop[2] = new Laptop("i7", 16, 512, "Asus", 4, 2.1);
        shop[3] = new Smartphone("Snapdragon", 8, 128, "Samsung", 24, 0.15, 123456789098l);
        printArray(shop);
        System.out.println("================================");
        Computer computer = new Computer("i5", 12, 512, "HP");
        boolean checker = shop[0].equals(computer);
        System.out.println(checker);
        checker = shop[3].equals(computer);
        System.out.println(checker);
        checker = shop[1].equals(shop[2]);
        System.out.println(checker);
        Smartphone smartphone =new Smartphone("Snapdragon", 8, 128, "Samsung", 24, 0.15, 223456789098l);
        checker = smartphone.equals(shop[3]);
        System.out.println(checker);
        System.out.println(smartphone);

    }
        public static void printArray (Computer[]arr){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    System.out.println(arr[i].toString());
                }
            }
        }
    }