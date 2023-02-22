package HW2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class hw2 {
    public static void main(String[] args) throws IOException {
        File file = new File("user.txt");
        List<userDto> users = new ArrayList<>();

        try (InputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(" ");
                String name = fields[0];
                int age = Integer.parseInt(fields[1]);
                users.add(new userDto(name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String us = gson.toJson(users);

         FileWriter writer = new FileWriter("users.json");
         gson.toJson(users,writer);
         writer.close();
        }
        }




