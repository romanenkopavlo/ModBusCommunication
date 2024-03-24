package org.example;

import jssc.SerialPortException;
import modbus.ModeBus;

public class Main {
    public static void main(String[] args) {
        try {
            while (true) {
                for (int i = 0; i < 3; i++) {
                    ModeBus modeBus = new ModeBus((byte)(i + 1));
                    modeBus.connecterEsclave("COM1", 57600, 8, 0, 1);
                    System.out.println("              __________Esclave №" + (i + 1) + "____________");
                    System.out.print("Tension: " + modeBus.lectureCoils(8192, 2) + " _______");
                    System.out.print(" Frequence: " + modeBus.lectureCoils(8224, 2) + " _______");
                    System.out.println(" Courant: " + modeBus.lectureCoils(8288, 2));
                    modeBus.fermerLiasonSerie();
                    Thread.sleep(3000);
                }
                System.out.println("\n");
            }
        } catch (SerialPortException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
