package guifx;

import application.controller.Controller;
import application.model.Konference;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.http.WebSocket;
import java.util.Optional;

public class StartWindow extends Application {
    public static Konference konference;

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
        stage.setResizable(false);
        stage.show();

    }

    private ListView<Konference> lvwKonf;
    private Button btnOpen, btnCreate, btnDelete;


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setPrefSize(300, 400);
        pane.setHgap(10);
        pane.setVgap(10);


    //Opbygning---------------------
        Label lblNames = new Label("Konferencer:");
        pane.add(lblNames, 0, 0,2,1);

        lvwKonf = new ListView<>();
        pane.add(lvwKonf, 0, 1, 3, 2);
        lvwKonf.getItems().setAll(Controller.getKonferencer());

        ChangeListener<Konference> listener = (ov, oldCompny, newCompany) -> this.selectedKonferenceChanged();
        lvwKonf.getSelectionModel().selectedItemProperty().addListener(listener);

        btnOpen = new Button("Åben");
        pane.add(btnOpen, 0, 3);
        btnOpen.setPrefWidth(100);
        btnOpen.setOnAction(event -> openAction());

        btnCreate = new Button("Opret");
        pane.add(btnCreate, 2, 3);
        btnCreate.setPrefWidth(100);
        btnCreate.setOnAction(event -> createAction());

        btnDelete = new Button("Delete");
        pane.add(btnDelete,1,3);

        btnDelete.setPrefWidth(100);
        btnDelete.setOnAction(event -> deleteAction());
    }
    //Opbygning---------------------
    //Actions-----------------------
    private void openAction() {
        KonferenceTabPane konf = new KonferenceTabPane(setWindowName());
        konf.showAndWait();
    }

    private void createAction() {
        KonferenceWindow createkonf = new KonferenceWindow("Opret Konference");
        createkonf.showAndWait();

        //venter på luk

        lvwKonf.getItems().setAll(Controller.getKonferencer());
        int index = lvwKonf.getItems().size() - 1;
        lvwKonf.getSelectionModel().select(index);
    }
    public void deleteAction() {
        Konference konference = lvwKonf.getSelectionModel().getSelectedItem();
        if(konference != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Slet konference");
            alert.setHeaderText("Er du sikker?");
            Optional<ButtonType> result = alert.showAndWait();
            if((result.isPresent()) && (result.get() == ButtonType.OK)){
                Controller.deleteKonference(konference);
                lvwKonf.getItems().setAll(Controller.getKonferencer());
            }
        }
    }
    //Actions-----------------------

    public void selectedKonferenceChanged() {
        konference = lvwKonf.getSelectionModel().getSelectedItem();
    }

    public String setWindowName() {
        String navn = "";
        Konference konference = lvwKonf.getSelectionModel().getSelectedItem();
        navn = konference.getNavn();
        return navn;
    }


}
