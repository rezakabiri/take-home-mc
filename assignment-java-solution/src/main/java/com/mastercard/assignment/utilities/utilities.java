package com.mastercard.assignment.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rezakabiri on 6/26/18.
 */
public class utilities {

    public static String readTextFileFromResources(String fileName) throws IOException {
        ClassLoader classLoader = utilities.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        FileReader fr = new FileReader(file);
        StringBuilder finalText;
        try (BufferedReader br = new BufferedReader(fr)) {
            finalText = new StringBuilder();
            while (br.readLine() != null) {
                finalText.append(br.readLine());
            }
            br.close();
        }
        fr.close();

        return finalText.toString();
    }
}
