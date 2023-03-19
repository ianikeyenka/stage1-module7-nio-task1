package com.epam.mjc.nio;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String nameLine = null;
        String ageLine = null;
        String emailLine = null;
        String phoneLine = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath())))) {
            nameLine = br.readLine();
            ageLine = br.readLine();
            emailLine = br.readLine();
            phoneLine = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] name = new String[0];
        if (nameLine != null) {
            name = nameLine.split(": ");
        }
        String[] age = new String[0];
        if (ageLine != null) {
            age = ageLine.split(": ");
        }
        String[] email = new String[0];
        if (emailLine != null) {
            email = emailLine.split(": ");
        }
        String[] phone = new String[0];
        if (phoneLine != null) {
            phone = phoneLine.split(": ");
        }
        return new Profile(name[1], Integer.parseInt(age[1]), email[1], Long.parseLong(phone[1]));
    }
}
