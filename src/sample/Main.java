package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.Plane;
import sample.model.Position;
import sample.model.Radar;

import java.util.ArrayList;

public class Main extends Application {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/layout/main.fxml"));
        Parent root = (Parent) loader.load();
        controller = loader.getController();
        primaryStage.setTitle("Radar HQ");
        primaryStage.setScene(new Scene(root, 1358, 680));
        primaryStage.show();

        dummyContent();
    }

    private void dummyContent() {
        ArrayList<Radar> dummyRadars = new ArrayList<Radar>() {{
            add(new Radar(0, 20, 40, 500, new Position(300, 100)));
            add(new Radar(1, 10, 100, 1000, new Position(400, 200)));
            add(new Radar(2, null, null, 700, new Position(800, 70)));
        }};

        controller.drawRadars(dummyRadars);

        controller.addPlane(new Plane("F-16", 1000, new Position[]{new Position(110, 230)}));
        controller.addPlane(new Plane("F-16", 1000, new Position[]{new Position(400, 210)}));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
