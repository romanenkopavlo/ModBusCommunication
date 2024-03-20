package org.example;

import jssc.SerialPortException;
import modbus.ModeBus;

public class Main {
    public static void main(String[] args) {
        ModeBus modeBus = new ModeBus((byte)0x01);
        try {
            modeBus.connecterEsclave("COM1", 57600, 8, 0, 1);
            System.out.print(modeBus.lectureCoils(8192, 2));
        } catch (SerialPortException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
