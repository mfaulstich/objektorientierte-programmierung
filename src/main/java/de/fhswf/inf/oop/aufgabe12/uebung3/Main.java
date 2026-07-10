package de.fhswf.inf.oop.aufgabe12.uebung3;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Kanal direkt über Path öffnen (wie in der Live-Demo)
        File stringFile = new File(
                "/workspaces/objektorientierte-programmierung/src/main/java/de/fhswf/inf/oop/aufgabe12/uebung2/loreipsum.txt");
        try (FileChannel fileChannel = FileChannel.open(Path.of(stringFile.getAbsolutePath()))) {

            // 2. Buffer mit Kapazität 10 allokieren
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);

            // 3. Erste 10 Bytes lesen und mit UTF-8 ausgeben
            fileChannel.read(byteBuffer);
            System.out.println(new String(byteBuffer.array(), StandardCharsets.UTF_8));

            // 4. Buffer leeren und die Lese-Position im File manipulieren
            byteBuffer.clear();
            fileChannel.position(5);

            // 5. Ab Position 5 erneut lesen und ausgeben
            fileChannel.read(byteBuffer);
            System.out.println(new String(byteBuffer.array(), StandardCharsets.UTF_8));

            // 6. Ressourcen freigeben
            fileChannel.close();
        } catch (Exception e) {
            System.err.println("Fehler bei der Dateibearbeitung: " + e.getMessage());
        }
    }
}
