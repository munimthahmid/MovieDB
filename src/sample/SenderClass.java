package sample;

import util.LoginDTO;

import java.io.Serializable;
import java.util.List;

public class SenderClass implements Serializable {
    List<Movie> movieList;
    Movie movieToTransfer;

    public Movie getMovieToTransfer() {
        return movieToTransfer;
    }

    public void setMovieToTransfer(Movie movieToTransfer) {
        this.movieToTransfer = movieToTransfer;
    }

    public LoginDTO loginDTO;
    private static final long serialVersionUID = 0L;

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
    public SenderClass (List<Movie> movieList,LoginDTO loginDTO)
    {
        this.movieList=movieList;
        this.loginDTO=loginDTO;
    }
    public SenderClass()
    {

    }
}
