package com.tactfactory.demo1.lang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoFile {

    public static void run() {
        File file = new File("/tmp/test.txt"); // Path for UNIX only !!!

        if (file.exists()) {
            // Read access
            FileReader reader;
            String line;

            try {
                reader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(reader);

                while ((line = buffer.readLine()) != null) {
                    System.out.println(line);
                }

                buffer.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Write access
            FileWriter writer;
            try {
                writer = new FileWriter(file);
                BufferedWriter buffer = new BufferedWriter(writer);

                buffer.append("Hello from code");

                buffer.flush();
                buffer.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // List file in folder.
        File directory = new File("/tmp"); // Path for UNIX only !!!
        for (File tmpFile : directory.listFiles()) {
            System.out.println(tmpFile);
        }

        // New IO stack
        Path fileNg = Paths.get("/tmp");
        File fileOld = fileNg.toFile();

    }

}
