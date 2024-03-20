package org.example;

import jssc.SerialPortException;
import modbus.ModeBus;

public class Main {
    public static void main(String[] args) {
        ModeBus modeBus = new ModeBus((byte)0x01);
        try {
            while(true) {
                modeBus.connecterEsclave("COM1", 57600, 8, 0, 1);
                System.out.println(modeBus.lectureCoils(8192, 2));
                modeBus.fermerPort();
                Thread.sleep(5000);
            }
        } catch (SerialPortException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
