package server;

import sample.FileOperations;
import sample.Movie;
import util.NetworkUtil;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {


    private ServerSocket serverSocket;
    public HashMap<String, String> userMap;
    static List<Movie> movieList=new ArrayList<>();
    public static HashMap<String,NetworkUtil>clientMap;


    public static List<Movie> getMovieList() {
        return movieList;
    }

    public static void setMovieList(List<Movie> movieList) {
        Server.movieList = movieList;
    }

    Server() throws IOException {
        userMap = new HashMap<>();
        clientMap=new HashMap<>();
        movieList= FileOperations.readFromFile();
//        userMap.put("a", "a");
//        userMap.put("b", "b");
//        userMap.put("c", "c");
//        userMap.put("d", "d");
//        userMap.put("e", "e");
        for(int i=0;i<movieList.size();i++)
        {
            userMap.put(movieList.get(i).getProductionCompany(),movieList.get(i).getProductionCompany());
        }
        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }

    }

    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(userMap, networkUtil);
    }
    public static List<Movie> searchByProductionCompany(String s)
    {
        int count=0;
        List<Movie>m=new ArrayList<Movie>();
        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).getProductionCompany().equalsIgnoreCase(s))
            {
                count++;
                m.add(movieList.get(i));
            }
        }
        if(count==0) return null;
        else         return m;


    }

    public static void main(String[] args) throws IOException {
        new Server();
        System.out.println(movieList.size());
    }
}
