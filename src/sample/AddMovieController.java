package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddMovieController {
    public TextField addMovieTitle;
    public TextField addYearOfRelease;
    public TextField addRunningTime;
    public TextField addGenre1;
    public TextField addGenre2;
    public TextField addGenre3;
    public TextField addBudget;
    public TextField addRevenew;
    public static List<Movie>CompanyMovieList=new ArrayList<>();
    private Main main;
    void setMain(Main main) {
        this.main = main;
    }



    public void onAddButtonClick(ActionEvent event) throws IOException {
        String title=addMovieTitle.getText();
        int yearOfRelease=Integer.parseInt(addYearOfRelease.getText());
        int runningTime=Integer.parseInt(addRunningTime.getText());
        String genre1=addGenre1.getText();
        String genre2=addGenre2.getText();
        String genre3=addGenre3.getText();
        Integer budget=Integer.parseInt(addBudget.getText());
        Integer revenew=Integer.parseInt(addRevenew.getText());
        String[] genre =new String[3];
        genre[0]=genre1;
        genre[1]=genre2;
        genre[2]=genre3;
        Movie movie=new Movie(title,yearOfRelease,genre,runningTime,CompanyMovieList.get(0).getProductionCompany(),budget,revenew);
        HomeController.networkUtil.write(movie);




    }


}
