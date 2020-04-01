package documentProject;

import Controller.DocumentController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

    public static void main(String[]args) {
        try {
            DocumentLibrary.getLibrary().readInFilesToList();
         //   launch(args);
            Hub.displayHub();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        try{
            DocumentController.getController(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
