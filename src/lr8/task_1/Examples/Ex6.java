package lr8.task_1.Examples;

import java.io.*;

public class Ex6 {

    public static void main(String[] args) throws IOException {

        Reader in = null;
        Writer out = null;

        try {

            in = new FileReader("E:\\MyFile1.txt");
            out = new FileWriter("E:\\MyFile2.txt", true);

            int oneByte;

            while ((oneByte = in.read()) !=-1) {
                //out.write((char)oneByte);

                out.append((char)oneByte);
                System.out.print((char)oneByte);
            }

        } catch (IOException e) {
            System.out.println("Error!!");
        } finally {
            in.close();
            out.close();
        }

    }

}
