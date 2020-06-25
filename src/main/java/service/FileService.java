package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    static String userDir = System.getProperty("user.dir");
    static String separator = System.getProperty("file.separator");
    static String fileDir = userDir + separator + "files";
    static String fileName = userDir + separator + "files" + separator + "citilinkItem.txt";

    public static void writeItemTofile(String url, boolean append) {
        checkAndCreateFile();
        String text = SitilinkParse.getItemFromURL(url).toString();
        try (FileWriter fileWriter = new FileWriter(fileName, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(text + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void checkAndCreateFile() {


        File file = new File(fileDir);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
