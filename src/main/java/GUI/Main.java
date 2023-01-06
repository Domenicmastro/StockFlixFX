package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main/GUI/sample.fxml"));
        primaryStage.setTitle("hello");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }



    // load user list

    // load ticker data
    /*List<Ticker> nasdaq = createTickerList("data/nasdaq-listed-symbols.csv");
    List<Ticker> nyse = createTickerList("data/nyse-listed.csv");

    List<Ticker> merged = new ArrayList<>();
        merged.addAll(nasdaq);
        merged.addAll(nyse);

    DetailedTicker test = queryTicker("AAPL");*/

    //new LoginPage();
}
