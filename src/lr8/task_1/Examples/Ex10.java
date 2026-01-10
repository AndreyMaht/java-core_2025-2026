package lr8.task_1.Examples;

import java.io.*;

public class Ex10 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        PrintWriter out = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\MyFile1.txt"),"cp1251"));
            out = new PrintWriter("E:\\MyFile19.txt", "cp1251");

            int lineCount = 0;
            String s;

            while((s = br.readLine()) != null) {
                lineCount++;
                out.println(lineCount + ": " + s);
            }

            System.out.println("Success");

        } catch (IOException e) {
            System.out.println("Error!!");
        } finally {
            br.close();
            out.flush();
            out.close();
        }

    }
}
