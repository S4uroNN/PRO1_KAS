package guifx;

import application.controller.Controller;
import application.model.Konference;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.SQLNonTransientConnectionException;
import java.util.List;

public class StartWindow extends Application {
    @Override
    public void init(){
        Controller.init();
    }

    @Override
    public void start(Stage stage) {


        stage.setTitle("Konference");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    private final ListView<Konference> lvwKonf = new ListView<>();
    private void initContent(GridPane pane){
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setPrefSize(200,400);
        pane.setHgap(10);
        pane.setVgap(10);


        Label lblNames = new Label("Konferencer:");
        pane.add(lblNames,0,0);

        pane.add(lvwKonf,0,1,2,2);
        lvwKonf.getItems().setAll(Controller.getKonferencer());
    }
}
