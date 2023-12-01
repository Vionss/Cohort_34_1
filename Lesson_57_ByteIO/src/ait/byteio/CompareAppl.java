package ait.byteio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class CompareAppl {
    public static void main(String[] args) {
        // TODO HOMEWORK
        if (args.length != 2) {
            System.out.println("Пожалуйста, укажите два файла для сравнения.");
            return;
        }

        String file1Path = args[0];
        String file2Path = args[1];

        try (FileInputStream file1 = new FileInputStream(file1Path);
             FileInputStream file2 = new FileInputStream(file2Path)) {

            boolean areEqual = compareFiles(file1, file2);
            if (areEqual) {
                System.out.println("Файлы идентичны.");
            } else {
                System.out.println("Файлы отличаются.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean compareFiles(FileInputStream file1, FileInputStream file2) throws IOException {
        byte[] buffer1 = new byte[1024];
        byte[] buffer2 = new byte[1024];

        int bytesRead1 ;
        int bytesRead2 ;

        while ((bytesRead1 = file1.read(buffer1)) != -1) {
            bytesRead2 = file2.read(buffer2);
            if (bytesRead2 != bytesRead1 || !Arrays.equals(buffer1, buffer2)) {
                return false;
            }
        }

        return file2.read() == -1;
    }
}

