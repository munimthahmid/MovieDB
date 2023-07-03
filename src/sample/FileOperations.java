package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {
    private static final String INPUT_FILE_NAME = "movies.txt";
    private static final String OUTPUT_FILE_NAME = "movies.txt";

    public static List<Movie> readFromFile() throws IOException {
        List<Movie>movieList=new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String []info=line.split(",");
            String n=info[0];
            int y=Integer.parseInt(info[1]);
            String [] g=new String[3];
            for(int i=0;i<3;i++)
            {
                g[i]=info[i+2];
            }
            int run=Integer.parseInt(info[5]);
            String p=info[6];
            int b=Integer.parseInt(info[7]);
            int r=Integer.parseInt(info[8]);
            Movie movie=new Movie(n,y,g,run,p,b,r);

            movieList.add(movie);





        }
        br.close();
        return movieList;

    }
    public static void writeToFile(List<Movie>movieList ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for(int i=0;i<movieList.size();i++)
        {
            StringBuffer text=movieList.get(i).movieFile();
            bw.write(String.valueOf(text));
            bw.write(System.lineSeparator());
        }

        bw.close();
    }




}
