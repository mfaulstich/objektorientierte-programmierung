package de.fhswf.inf.oop.aufgabe12.uebung4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntegerFile {
    public static int readInt(File inputFile) throws IOException {
        int result = 0;
        FileInputStream inStream = null;
        try {
            inStream = new FileInputStream(inputFile);
            List<Byte> input = new ArrayList<>();
            int readed;
            while ((readed = inStream.read()) != -1) {
                input.add((byte) readed);
            }

            for (int byteIdx = input.size() - 1; byteIdx >= 0; byteIdx--) {
                result |= input.get(byteIdx);
                if (byteIdx != 0) {
                    result = result << 8;
                }
            }
        } finally

        {
            if (inStream != null) {
                inStream.close();
            }
        }
        System.out.println("Ergebnis readInt " + result);
        return result;
    }

    public static void writeInt(int value, File outputFile) throws IOException {
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(outputFile);

            int toWrite = value;
            byte outByte;
            for (int byteIdx = 0; byteIdx < 4; byteIdx++) {
                outByte = (byte) (toWrite & 0xFF);
                outStream.write(outByte);
                toWrite = toWrite >> 8;
            }
        } finally {
            if (outStream != null) {
                outStream.close();
            }
        }
    }

}
