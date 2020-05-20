package br.com.hebaja.projects;

import java.io.*;
import java.util.Scanner;

public class MakeJsonFileNaMarra {

    public static void main(String[] args) throws IOException {

        InputStream fis = new FileInputStream("questions.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader brFile = new BufferedReader(isr);

        OutputStream fos = new FileOutputStream("questions_format.txt");
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bwFile = new BufferedWriter(osw);

        String lineFile = brFile.readLine();

        int count = 0;

        while(lineFile != null){
            bwFile.write(lineFile + "/");
            lineFile = brFile.readLine();

            count++;

            if(count == 5) {
                count = 0;
                bwFile.newLine();
            }

        }

        bwFile.close();
        brFile.close();

        Scanner scanner = new Scanner(new FileReader("questions_format.txt"));

        OutputStream fosJson = new FileOutputStream("questions_format.json");
        Writer oswJson = new OutputStreamWriter(fosJson);
        BufferedWriter bwJson = new BufferedWriter(oswJson);


        bwJson.write("[");
        bwJson.newLine();

        while(scanner.hasNextLine()) {
            String stringScanner = scanner.nextLine();
            Scanner formattedLine = new Scanner(stringScanner);
            formattedLine.useDelimiter("/");

            bwJson.write("\t" + "{");
            bwJson.newLine();

            bwJson.write("\t" + "\"question\"");
            bwJson.write(":");
            bwJson.newLine();
            bwJson.write("\t" +"\t" +"{");
            bwJson.newLine();

            bwJson.write("\t" +"\t" + "\t" + "\"prompt\"");
            bwJson.write(":");
            bwJson.write("\"");
            bwJson.write(formattedLine.next());
            bwJson.write("\"");
            bwJson.write(",");
            bwJson.newLine();

            bwJson.write("\t" +"\t" + "\t" + "\"optionA\"");
            bwJson.write(":");
            bwJson.write("\"");
            bwJson.write(formattedLine.next());
            bwJson.write("\"");
            bwJson.write(",");
            bwJson.newLine();

            bwJson.write("\t" +"\t" + "\t" + "\"optionB\"");
            bwJson.write(":");
            bwJson.write("\"");
            bwJson.write(formattedLine.next());
            bwJson.write("\"");
            bwJson.write(",");
            bwJson.newLine();

            bwJson.write("\t" +"\t" + "\t" + "\"optionC\"");
            bwJson.write(":");
            bwJson.write("\"");
            bwJson.write(formattedLine.next());
            bwJson.write("\"");
            bwJson.write(",");
            bwJson.newLine();

            bwJson.write("\t" +"\t" + "\t" + "\"rightOption\"");
            bwJson.write(":");
            bwJson.write("\"");
            bwJson.write(formattedLine.next());
            bwJson.write("\"");
            bwJson.newLine();

            bwJson.write("\t" +"\t" +"}");
            bwJson.newLine();

            bwJson.write("\t" + "}");

            if(scanner.hasNextLine()) {

                bwJson.write(",");
            }
            bwJson.newLine();
        }

        bwJson.write("]");

        scanner.close();
        bwJson.close();
    }
}
