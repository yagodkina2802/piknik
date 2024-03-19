package oop.pikcnik;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputTxt = new File("C:\\Users\\rekal\\IdeaProjects\\Exeption\\src\\main\\java\\oop\\pikcnik\\input.txt");
        FileInputStream inputStream = new FileInputStream(inputTxt);
        byte[] buffer = new byte[1024];
        int bytesRead;
        String basket = "";
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            basket = basket + new String(buffer, 0, bytesRead);
        }
        inputStream.close();

        basket = basket.replaceAll("\\s+", " ");
        String[] basketArray = basket.split(" ");
        System.out.println(Arrays.toString(basketArray));

        System.out.println("Всего в файле "+ basketArray.length + " слов");
        int max = 0;
        int temp = 0;
        for (int i = 0; i < basketArray.length; i++) {
            if (basketArray[i].length() > max){
                max = i;
            }
//            if (basketArray[i].length() == basketArray[max].length()){
//                temp = i;
//            }
        }
        System.out.println("Самое длинное слово " + basketArray[max] +" "+ basketArray[max].length()+ " символов");
//        System.out.println("Тоже длинное слово " + basketArray[temp]+" "+ basketArray[temp].length()+ " символов");

        Map<String, Integer> basketFruite = new HashMap<>();
        Set<String> unique = new HashSet<>(List.of(basketArray));
        for (String key : unique) {
            basketFruite.put(key, Collections.frequency(List.of(basketArray), key));
        }
        System.out.println(basketFruite);
    }

}
