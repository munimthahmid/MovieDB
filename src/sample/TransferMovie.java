package sample;

import javafx.scene.shape.MoveTo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransferMovie implements Serializable {
    private static final long serialVersionUID = 0L;
   private Movie movieToTransfer;
   private String fromProductionCompany;
   private String toProductionCompany;
   public SenderClass senderClass=new SenderClass();
   List<Movie> movieList=new ArrayList<>();

    public Movie getMovieToTransfer() {
        return movieToTransfer;
    }

    public void setMovieToTransfer(Movie movieToTransfer) {
        this.movieToTransfer = movieToTransfer;
    }

    public String getFromProductionCompany() {
        return fromProductionCompany;
    }

    public void setFromProductionCompany(String fromProductionCompany) {
        this.fromProductionCompany = fromProductionCompany;
    }

    public String getToProductionCompany() {
        return toProductionCompany;
    }

    public void setToProductionCompany(String toProductionCompany) {
        this.toProductionCompany = toProductionCompany;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
