package modbus;

public class CRC16 {
    public static int stdPoly = 0xA001;
    public static int initialValue = 0xffff;
    public static String hexaRegex = "([0-9a-fA-F][0-9a-fA-F]|[a-fA-F][0-9a-fA-F])+";
    public static String chaineHexa;
    public static int crc16;

    public int calculCRC16(byte [] octets, int valeurInitiale, int polynomme) {
        for (int i = 0; i < octets.length; i++) {
            valeurInitiale ^= (octets[i] & 0xFF);
            for (int j = 0; j < 8; j++) {
                if ((valeurInitiale & 1) != 0) {
                    valeurInitiale = (valeurInitiale >> 1) ^ polynomme;
                } else {
                    valeurInitiale = valeurInitiale >> 1;
                }
            }
        }
        return valeurInitiale;
    }

    public byte[] hexStringEnByteArray(String message) {
        int size = message.length();
        byte[] data = new byte[size / 2];
        for (int i = 0; i < size; i+=2) {
            data[i / 2] = (byte) ((Character.digit(message.charAt(i), 16) << 4) +
            Character.digit(message.charAt(i + 1), 16));
        }
        return data;
    }
    public byte[] formatage(String trame) {
        if (trame.matches(hexaRegex)) {
            int size = trame.length();
            if (size % 2 != 0) {
                trame += "0";
            }
            return hexStringEnByteArray(trame);
        }
        return null;
    }
    public int getStdPoly() {
        return stdPoly;
    }

    public int getInitialValue() {
        return initialValue;
    }
}