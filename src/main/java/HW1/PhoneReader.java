package HW1;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneReader {
    public static void main(String[] args) {
        File file = new File("PhonesList.txt");
        System.out.println("file.exists() = " + file.exists());
        Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\s?\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNextLine()) {
                    String phone = scanner.nextLine();
                    Matcher matcher = pattern.matcher(phone);
                    if (matcher.matches()) {
                        System.out.println(phone);
                    }
                }

        } catch(IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
}
