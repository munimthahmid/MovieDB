package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.LoginDTO;
import util.NetworkUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HomeController {
    private static final long serialVersionUID = 0L;
    public ImageView companyImage;
    public Text companyName;
    public Button addMovie;
    public  static NetworkUtil networkUtil=Main.networkUtil;


    List<Movie> CompanyMovieList = new ArrayList<>();
    public static SenderClass senderClass;
    public TableColumn<Movie, String> titleCol;
    public TableColumn<Movie, Integer> releaseYearCol;
    public TableColumn<Movie, String> genreCol;
    public TableColumn<Movie, Integer> runningTimeCol;
    public TableColumn<Movie, Integer> BudgetCol;
    public TableColumn<Movie, Integer> RevenewCol;
    public TableView<Movie> tableView;
    public Button MovieInfo;
    public Button Refresh;
    public Button TransferMovie;
    public Button maximumRevenewSearch;
    public Button totalProfit;
    public Button runningTimeSearch;
    public Button genreSearch;
    public TextField newField1;
    public Text intro1;
    public Button releaseYearSearch;
    public Button back;
    public Button confirm;
    public TextField newField;
    public Text intro;
    public Button titleSeach;

    public TextField transfercompanyname;

    private Main main;


    @FXML
    private Label message;

    @FXML
    private ImageView image;

    @FXML
    private Button logOutButton;


    @FXML
    private Button transfersubmit;

    public void init(List<Movie> list) {
        this.CompanyMovieList = list;
        //  System.out.println(CompanyMovieList.size()+"company Size");
//        this.senderClass.movieList=new ArrayList<>();
        // this.senderClass.movieList=list;
        //  System.out.println(this.senderClass.movieList.size()+"this size");

//        message.setText(msg);
//        Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("1.png")));
//        image.setImage(img);
        intro.setVisible(false);
        intro1.setVisible(false);
        newField.setVisible(false);
        newField1.setVisible(false);
        confirm.setVisible(false);
        back.setVisible(false);
        TransferMovie.setVisible(true);
        transferPromt.setVisible(false);
        transfercompanyname.setVisible(false);
        transfersubmit.setVisible(false);


//        SpecialMethods.hover(logOutButton);
//        SpecialMethods.hover(titleSeach);
//        SpecialMethods.hover(confirm);
//        SpecialMethods.hover(back);
//        SpecialMethods.hover(releaseYearSearch);
//        SpecialMethods.hover(runningTimeSearch);
//        SpecialMethods.hover(genreSearch);
//        SpecialMethods.hover(maximumRevenewSearch);
//        SpecialMethods.hover(totalProfit);
//        SpecialMethods.hover(MovieInfo);


        System.out.println(CompanyMovieList.size());

    }

    @FXML
    void logoutAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connect(Main main) {
        this.main = main;
        main.connect(this);
    }

    List<Movie> data;
    private boolean init = true;

    private void initializeColumns() {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        releaseYearCol.setCellValueFactory(new PropertyValueFactory<>("yearOfRelease"));

        runningTimeCol.setCellValueFactory(new PropertyValueFactory<>("runningTime"));

        BudgetCol.setCellValueFactory(new PropertyValueFactory<>("budget"));

        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre1"));

        RevenewCol.setCellValueFactory(new PropertyValueFactory<>("revenew"));


        //buttonCol.setCellValueFactory(new PropertyValueFactory<>("button"));
    }

    public void load() {
        if (init) {
            initializeColumns();
            init = false;
        }
        companyName.setText(CompanyMovieList.get(0).getProductionCompany());
        tableView.setEditable(true);
        tableView.getItems().clear();

        for (Movie m : CompanyMovieList) {
            tableView.getItems().add(m);
        }
    }

    public Movie searchbyTitle(String title) {
        Movie m;
        for (int i = 0; i < CompanyMovieList.size(); i++) {
            if (CompanyMovieList.get(i).getTitle().equalsIgnoreCase(title)) {
                m = CompanyMovieList.get(i);
                return m;
            }
        }
        return null;
    }

    public List<Movie> searchByReleaseYear(int year) {
        List<Movie> m = new ArrayList<Movie>();

        int count = 0;
        for (int i = 0; i < CompanyMovieList.size(); i++) {
            count++;
            if (CompanyMovieList.get(i).getYearOfRelease() == year) {
                m.add(CompanyMovieList.get(i));
            }

        }
        if (count == 0) return null;
        else return m;

    }

    public List<Movie> searchByGenre(String s) {
        int count = 0;
        List<Movie> m = new ArrayList<Movie>();
        for (int i = 0; i < CompanyMovieList.size(); i++) {
            for (int j = 0; j < CompanyMovieList.get(i).getGenre().length; j++) {
                if (CompanyMovieList.get(i).getGenre()[j].equalsIgnoreCase(s)) {
                    count++;
                    m.add(CompanyMovieList.get(i));
                }
            }
        }
        if (count == 0) return null;
        else return m;

    }

    public List<Movie> searchByProductionCompany(String s) {
        int count = 0;
        List<Movie> m = new ArrayList<Movie>();
        for (int i = 0; i < CompanyMovieList.size(); i++) {
            if (CompanyMovieList.get(i).getProductionCompany().equalsIgnoreCase(s)) {
                count++;
                m.add(CompanyMovieList.get(i));
            }
        }
        if (count == 0) return null;
        else return m;


    }

    public List<Movie> searchByRunningTime(int low, int high) {
        int count = 0;
        List<Movie> m = new ArrayList<Movie>();
        for (int i = 0; i < CompanyMovieList.size(); i++) {
            if (CompanyMovieList.get(i).getRunningTime() >= low && CompanyMovieList.get(i).getRunningTime() <= high) {
                count++;
                System.out.print(count + ".");
                System.out.println();
                m.add(CompanyMovieList.get(i));
            }
        }
        if (count == 0) return null;
        else return m;
    }

    public List<Movie> topTenMovies() {
        int count = 0;
        List<Movie> m = new ArrayList<Movie>();
        ArrayList<Integer> budget = new ArrayList<>();
        ArrayList<Integer> revenew = new ArrayList<>();
        ArrayList<Integer> profit = new ArrayList<>();
        for (int i = 0; i < CompanyMovieList.size(); i++) {
            budget.add(CompanyMovieList.get(i).getBudget());
            revenew.add(CompanyMovieList.get(i).getRevenew());
        }
        for (int i = 0; i < budget.size(); i++) {
            profit.add(revenew.get(i) - budget.get(i));
        }
        Collections.sort(profit);
        Collections.reverse(profit);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < CompanyMovieList.size(); j++) {
                if (profit.get(i) == (CompanyMovieList.get(j).getRevenew() - CompanyMovieList.get(j).getBudget())) {
                    count++;
                    m.add(CompanyMovieList.get(j));
                }
            }
        }
        return m;
    }

    public List<Movie> mostRecentMovies(String s) {
        int countmovie = 0;
        List<Movie> m = new ArrayList<Movie>();
        ArrayList<Integer> year = new ArrayList<>();
        for (int i = 0; i < CompanyMovieList.size(); i++) {
            if (CompanyMovieList.get(i).getProductionCompany().equalsIgnoreCase(s)) {
                year.add(CompanyMovieList.get(i).getYearOfRelease());
            }
        }
        Collections.sort(year);
        Collections.reverse(year);


        for (int j = 0; j < CompanyMovieList.size(); j++) {
            if (CompanyMovieList.get(j).getProductionCompany().equalsIgnoreCase(s) && CompanyMovieList.get(j).getYearOfRelease() == year.get(0)) {
                countmovie++;
                m.add(CompanyMovieList.get(j));
            }
        }

        if (countmovie == 0) return null;
        else return m;
    }

    public List<Movie> moviesWithMaximumRevenew(String s) {
        int countmovie = 0;
        List<Movie> m = new ArrayList<Movie>();
        ArrayList<Integer> revenew = new ArrayList<Integer>();
        for (int i = 0; i < CompanyMovieList.size(); i++) {
            if (CompanyMovieList.get(i).getProductionCompany().equalsIgnoreCase(s)) {
                revenew.add(CompanyMovieList.get(i).getRevenew());
            }
        }
        Collections.sort(revenew);
        Collections.reverse(revenew);

        for (int j = 0; j < CompanyMovieList.size(); j++) {
            if (CompanyMovieList.get(j).getProductionCompany().equalsIgnoreCase(s) && CompanyMovieList.get(j).getRevenew() == revenew.get(0)) {
                countmovie++;
                m.add(CompanyMovieList.get(j));
            }
        }

        if (countmovie == 0) return null;
        else return m;

    }

    public long totalProfit(String s) {
        long sum = 0;
        int count = 0;
        for (int i = 0; i < CompanyMovieList.size(); i++) {
            if (CompanyMovieList.get(i).getProductionCompany().equalsIgnoreCase(s)) {
                count++;
                int x = CompanyMovieList.get(i).getRevenew() - CompanyMovieList.get(i).getBudget();
                sum += x;

            }
        }
        if (count > 0) return sum;
        else return 0;
    }


    void setMain(Main main) {
        this.main = main;
    }

    //    @FXML
//    void Back(ActionEvent event){
//        try {
//            main.showHomePage(senderClass);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    public void TitleSearch(ActionEvent actionEvent) {
        intro.setText("Enter Title");
        newField.setVisible(true);
        confirm.setVisible(true);
        back.setVisible(false);
        confirm.setOnAction(e -> {
//                    List<Movie>Searched=new ArrayList<>();
                    List<Movie> TitleMatched = new ArrayList<>();
                    Movie Searched;
                    String s = newField.getText();
                    Searched = searchbyTitle(s);
//                    Searched= sample.MovieInfo.searchbyTitle(newField.getText(),CompanyMovieList);
                    if (Searched == null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Error!");
                        alert.setContentText("There is no Movie with this name");
                        alert.showAndWait();
                    } else {
                        TitleMatched.add(Searched);
                        tableView.setEditable(true);
                        confirm.setVisible(false);
                        back.setVisible(true);
                        tableView.getItems().clear();
                        for (Movie m : TitleMatched) {
                            tableView.getItems().add(m);
                        }
                    }
                }
        );


    }

    private void VisibilityControl() {
        newField.setVisible(true);
        confirm.setVisible(true);
        back.setVisible(false);
        intro.setVisible(true);
    }

    public void ReleaseYearSearch(ActionEvent actionEvent) {
        intro.setText("Enter Release Year");
        VisibilityControl();
        confirm.setOnAction(e -> {
//                    List<Movie>Searched=new ArrayList<>();
                    List<Movie> ReleaseYearMatched = new ArrayList<>();

                    String s = newField.getText();
                    int x = Integer.parseInt(s);
                    ReleaseYearMatched = searchByReleaseYear(x);
//                    Searched= sample.MovieInfo.searchbyTitle(newField.getText(),CompanyMovieList);
                    if (ReleaseYearMatched == null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Error!");
                        alert.setContentText("No Movie with this Release Year");
                        alert.showAndWait();
                    } else {
                        // System.out.println(data.get(0).getTitle()+"movie is on data");

                        tableView.setEditable(true);
                        confirm.setVisible(false);
                        back.setVisible(true);
                        tableView.getItems().clear();
                        for (Movie m : ReleaseYearMatched) {
                            tableView.getItems().add(m);
                        }
                    }
                }
        );

    }

    public void GenreSearch(ActionEvent actionEvent) {
        intro.setText("Enter Genre");
        VisibilityControl();
        confirm.setOnAction(e -> {
//                    List<Movie>Searched=new ArrayList<>();
                    List<Movie> Searched = new ArrayList<>();
                    Movie movie;
                    String s = newField.getText();
                    Searched = searchByGenre(s);

                    if (Searched == null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Error!");
                        alert.setContentText("There is no Movie with this name");
                        alert.showAndWait();
                    } else {
                        System.out.println("Movie added to List");
                        tableView.setEditable(true);
                        confirm.setVisible(false);
                        back.setVisible(true);
                        tableView.getItems().clear();
                        for (Movie m : Searched) {
                            tableView.getItems().add(m);
                        }
                    }
                }
        );


    }

    public void RunningTimeSearch(ActionEvent actionEvent) {
        intro.setText("From: ");
        intro1.setVisible(true);
        newField1.setVisible(true);
        intro1.setText("To: ");
        VisibilityControl();
        confirm.setOnAction(e -> {
//                    List<Movie>Searched=new ArrayList<>();
                    List<Movie> Searched = new ArrayList<>();
                    Movie movie;
                    String s = newField.getText();
                    String s1 = newField1.getText();
                    int x = Integer.parseInt(s);
                    int x1 = Integer.parseInt(s1);
                    Searched = searchByRunningTime(x, x1);

                    if (Searched == null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Error!");
                        alert.setContentText("There is no Movie within this Running Time");
                        alert.showAndWait();
                    } else {
                        System.out.println("Movie added to List");
                        tableView.setEditable(true);
                        confirm.setVisible(false);
                        back.setVisible(true);
                        tableView.getItems().clear();
                        for (Movie m : Searched) {
                            tableView.getItems().add(m);
                        }

                    }
                }
        );

    }

    public void TotalProfitSearch(ActionEvent event) {
        back.setVisible(true);
        double total = totalProfit(CompanyMovieList.get(0).getProductionCompany());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Total Profit");
        String s = "Total Profit = " + String.format("%.2f", total);
        alert.setContentText(s);
        alert.showAndWait();


    }

    public void MaximumRevenewSearch(ActionEvent actionEvent) {
        intro.setText("Enter Title");
        intro.setVisible(false);
        newField.setVisible(false);
        confirm.setVisible(false);
        back.setVisible(false);

//                    List<Movie>Searched=new ArrayList<>();
        List<Movie> MaxRevenew = new ArrayList<>();
        Movie Searched;
        // String s=newField.getText();
        MaxRevenew = moviesWithMaximumRevenew(CompanyMovieList.get(0).getProductionCompany());
//                    Searched= sample.MovieInfo.searchbyTitle(newField.getText(),CompanyMovieList);
        if (MaxRevenew == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error!");
            alert.setContentText("Something wrong happened");
            alert.showAndWait();
        } else {
            System.out.println("Movie added to List");

            tableView.setEditable(true);
            confirm.setVisible(false);
            back.setVisible(true);
            tableView.getItems().clear();
            for (Movie m : MaxRevenew) {
                tableView.getItems().add(m);
            }
        }


    }



    @FXML
    Text transferPromt;


    public void TransferMovie(ActionEvent actionEvent) {
        Movie selectedMovie = tableView.getSelectionModel().getSelectedItem();
        if (selectedMovie == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error!");
            alert.setContentText("You have to select a Movie first");
            alert.showAndWait();
        } else {
            transfersubmit.setVisible(true);
            transfercompanyname.setVisible(true);
            transferPromt.setText("Enter a Company Name:");
            transferPromt.setVisible(true);
        }

    }


    public void refresh(ActionEvent actionEvent) {

        new Thread(() -> {
            System.out.println("refresh");
                CompanyMovieList=Main.CompanyMovieList;

            tableView.setEditable(true);
            tableView.getItems().clear();
            for(Movie m:CompanyMovieList)
            {
                tableView.getItems().add(m);
            }

        }).start();

    }


    @FXML
    void Back(ActionEvent event) {
        try {
            main.showHomePage(senderClass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void OnTransferSubmitButtonClick(ActionEvent event) {
            Movie selectedMovie = tableView.getSelectionModel().getSelectedItem();
            TransferMovie transferMovie=new TransferMovie();
            String company=transfercompanyname.getText();
            if (company == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error!");
                alert.setContentText("You have write a Company name first");
                alert.showAndWait();
            }
            else
            {
                new Thread(()->{
                    try {
                        CompanyMovieList.remove(selectedMovie);
                        selectedMovie.setProductionCompany(company);
                        transferMovie.setMovieToTransfer(selectedMovie);
                        transferMovie.getMovieToTransfer().setProductionCompany(company);
                        transferMovie.setToProductionCompany(company);

                        main.getNetworkUtil().write(transferMovie);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    tableView.setEditable(true);
                    tableView.getItems().clear();
                    for(Movie m:CompanyMovieList)
                    {
                        tableView.getItems().add(m);
                    }
                }).start();
            }

        }


    public void onAddMovieClick(ActionEvent event) throws IOException {
        AddMovieController.CompanyMovieList=this.CompanyMovieList;
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-movie.fxml")));
        Stage stage=new Stage();
        Scene scene=new Scene(root,800,600);
        stage.setTitle("Add Movie");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void MovieInfo(ActionEvent event) {

        try {
            Movie movie = tableView.getSelectionModel().getSelectedItem();
            if(movie==null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error!");
                alert.setContentText("You have Select a Movie  first");
                alert.showAndWait();
            }
        else {


                Stage window = new Stage();
                window.setTitle(movie.getTitle());

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("movieDetailsWindow.fxml"));
                Parent root = fxmlLoader.load();

                movieDetailsWindowController movieDetails = fxmlLoader.getController();
                movieDetails.setData(movie);

                Scene scene = new Scene(root);
                window.setScene(scene);
                window.showAndWait();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


