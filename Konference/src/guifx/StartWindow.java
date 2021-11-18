package guifx;

import application.controller.Controller;
import application.model.Konference;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartWindow extends Application {
    @Override
    public void init() {
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

    private ListView<Konference> lvwKonf;
    private Button btnOpen, btnCreate;


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setPrefSize(200, 300);
        pane.setHgap(10);
        pane.setVgap(10);


        Label lblNames = new Label("Konferencer:");
        pane.add(lblNames, 0, 0);

        lvwKonf = new ListView<>();
        pane.add(lvwKonf, 0, 1, 2, 2);
        lvwKonf.getItems().setAll(Controller.getKonferencer());

        ChangeListener<Konference> listener = (ov, oldCompny, newCompany) -> this.selectedKonferenceChanged();
        lvwKonf.getSelectionModel().selectedItemProperty().addListener(listener);

        btnOpen = new Button("Åben");
        pane.add(btnOpen, 0, 3);
        btnOpen.setPrefWidth(100);
        btnOpen.setOnAction(event -> openAction());

        btnCreate = new Button("Opret");
        pane.add(btnCreate, 1, 3);
        btnCreate.setPrefWidth(100);
        btnCreate.setOnAction(event -> createAction());
    }

    private void openAction() {
        KonferenceTabPane konf = new KonferenceTabPane(setWindowName());
        konf.showAndWait();
    }

    private void createAction() {
        KonferenceWindow createkonf = new KonferenceWindow("Opret Konference");
        createkonf.showAndWait();

        //venter på luk

        lvwKonf.getItems().setAll(Controller.getKonferencer());
        int index =lvwKonf.getItems().size() - 1;
        lvwKonf.getSelectionModel().select(index);
    }

    private void selectedKonferenceChanged() {
        this.setWindowName();
    }

    public String setWindowName() {
        String navn = "";
        Konference konference = lvwKonf.getSelectionModel().getSelectedItem();
        navn = konference.getNavn();
        return navn;
    }


}
