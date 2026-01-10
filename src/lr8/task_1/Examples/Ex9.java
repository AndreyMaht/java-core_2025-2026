package lr8.task_1.Examples;

import java.io.*;

public class Ex9 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\MyFile1.txt"), "cp1251"));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Myfile9.txt"),"cp1251"));

            int lineCount = 0;
            String s;

            while((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                bw.write(lineCount + ": " + s);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error!!");
        } finally {
            br.close();
            bw.flush();
            bw.close();
        }

    }

}
