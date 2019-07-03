package se.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
@Slf4j
public class FileStream {
    private static String str="today is well, tomorrow will better. ";
    public static void main(String[] args) {
        
        testFileOutputStream(getMyFile());
        testFileInputStream(getMyFile());
        testBufferedInputStream();
    }

    private static void testBufferedInputStream() {
    }

    private static File getMyFile() {
        File myFile = null;
        try {
            String filePath = FileStream.class.getClassLoader().getResource("").getPath();
            myFile = new File(filePath, "file.txt");
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myFile;
    }

    private static void testFileInputStream(File file) {
        try {
            FileInputStream in=new FileInputStream(file);
            byte[] temp=new byte[80];
            in.read(temp,0,50);
            log.info(new String(temp));
            log.info(in.getFD().toString());
            in.read(temp);
            log.info(new String(temp));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void testFileOutputStream(File file) {
        try {
            OutputStream out=new FileOutputStream(file);
            out.write(str.getBytes());
            OutputStream out1=new FileOutputStream(file,true);
            out1.write(str.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
