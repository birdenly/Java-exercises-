package CursoJava.FileManipulation.src.main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import CursoJava.FileManipulation.src.main.ententies.Items;


public class Main {
    public static void main(String[] args) {
        String itemsPath = "(change directory)/items.csv";

        List<Items> itemsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(itemsPath))) {

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);
                Items items = new Items(name, price, quantity);
                itemsList.add(items);
                line = br.readLine();
            } 

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String outPut = "(change directory)/out/out.csv";
        File outPutPath = new File(outPut);
        boolean subDir = new File(outPutPath.getParent()).mkdirs();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPut))){

            for (Items items : itemsList) {
                System.out.println(items.getName() + "," + items.total());
                bw.write(items.getName() + "," + items.total());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("erro IO " + e.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
