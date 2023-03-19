package com.epam.mjc.nio;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String nameLine = null;
        String ageLine = null;
        String emailLine = null;
        String phoneLine = null;
        try {
            InputStream input = new FileInputStream(file.getPath());
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            nameLine = br.readLine();
            ageLine = br.readLine();
            emailLine = br.readLine();
            phoneLine = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] name = nameLine.split(": ");
        String[] age = ageLine.split(": ");
        String[] email = emailLine.split(": ");
        String[] phone = phoneLine.split(": ");
        return new Profile(name[1], Integer.parseInt(age[1]), email[1], Long.parseLong(phone[1]));
    }
}
