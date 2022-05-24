package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isStop = false;
        System.out.println("stop - выход из программы\n" +
                "x - изменить x\n" +
                "y - получить значение функции\n" +
                "save - похранить данные\n" +
                "upload - загрузить данные\n" +
                "Введите x");
        XY xy = new XY(Double.parseDouble(scanner.nextLine()));
	    while (!isStop){
            String line = scanner.nextLine();
            switch(line){
                case "stop":
                    isStop = true;
                    break;
                case "upload":
                    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat")))
                    {
                        xy = (XY)ois.readObject();
                    }
                    catch(Exception ex){

                        System.out.println(ex.getMessage());
                        scanner.nextLine();
                    }
                    break;
                case "save":
                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat")))
                    {
                        oos.writeObject(xy);
                    }
                    catch(Exception ex){

                        System.out.println(ex.getMessage());
                        scanner.nextLine();
                    }
                    break;
                case "x":
                    try{
                        xy.setX(Double.parseDouble(scanner.nextLine()));
                    }
                    catch (Exception ex) {
                        System.out.println("Не коректное число");
                        scanner.nextLine();
                    }
                    break;
                case "y":
                    xy.findY();
                    break;
                default:
                    System.out.println("Не известная команда");
                    scanner.nextLine();
                    break;
            }
        }
    }
}
