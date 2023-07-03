package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private static final long serialVersionUID = 0L;


    private Stage stage;
    public static   NetworkUtil networkUtil;
    public SenderClass senderClass;
    public static List<Movie> CompanyMovieList;
    HomeController homeController;

    public Stage getStage() {
        return stage;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public  SenderClass getSenderClass() {
        return senderClass;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        connectToServer();
        showLoginPage();

    }

    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);
    }
    public void connect(HomeController controller)
    {
            homeController=controller;
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    public void showHomePage(SenderClass senderClass) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        System.out.println("newTransferDebug+in Main1");

        this.senderClass=senderClass;
        HomeController.senderClass=senderClass;
        System.out.println("newTransferDebug+in Main2");



        loader.setLocation(getClass().getResource("home.fxml"));
        System.out.println("newTransferDebug+in Main3");



        Parent root = loader.load();
        System.out.println("newTransferDebug+in Main4");



        // Loading the controller

        HomeController controller = loader.getController();
        System.out.println("newTransferDebug+in Main5");


        System.out.println("Debug6");

        controller.init(senderClass.movieList);
        controller.load();
        System.out.println("        newTransferDebug+in Main6");




        controller.connect(this);
        System.out.println("Debug8");



        System.out.println(senderClass.movieList.get(0).getTitle());
        System.out.println("Debug9");



        controller.setMain(this);
        System.out.println("  newTransferDebug+in Main8");




        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 1100, 800));
        stage.show();
        System.out.println("Debug11");

    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        // This will launch the JavaFX application
        launch(args);
    }
}
