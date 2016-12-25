import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("https://urnik.fri.uni-lj.si/timetable/fri-2016_2017-zimski-drugi-teden/allocations?student=63160303");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String htmlFile = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null){
            //System.out.println(inputLine);
            htmlFile += inputLine + "\n";
        }

        System.out.println(htmlFile);

        in.close();
    }
}