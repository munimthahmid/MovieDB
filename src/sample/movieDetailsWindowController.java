package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class movieDetailsWindowController {
    public Label movieName;
    public Label productionCompanyName;
    public Label runningTime;
    public HBox genre1;
    public Label genre2;
    public Label budget;
    public Label revenew;
    public Label yearOfRelease;
    public ImageView movieImage=new ImageView();
    void setData(Movie m) throws IOException {

        yearOfRelease.setText(String.valueOf(m.getYearOfRelease()));
        movieName.setText(m.getTitle());
        productionCompanyName.setText(m.getProductionCompany());
        runningTime.setText(String.valueOf(m.getRunningTime()));
        genre2.setText(m.getGenre1());
        budget.setText(String.valueOf(m.getBudget()));
        revenew.setText(String.valueOf(m.getRevenew()));
      






    }
}