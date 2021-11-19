package guifx;


import application.controller.Controller;
import application.model.Arrangement;
import application.model.Ledsager;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.util.Optional;

public class ArrangementerPane extends GridPane {
    private ListView<Arrangement> lvwArran;
    private ListView<Ledsager> lvwLed;
    private Label lblArran, lblName, lblLokation,lblLedsager;
    private TextField txfNavn ,txfLokation;
    private Button btnCreate,btnAddLedsager, btnDel,btnRemoveLedsager;


    public ArrangementerPane() {
        Controller.initStorage();

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        this.setPrefSize(580, 580);

        lblArran = new Label("Arrangementer");
        this.add(lblArran,0,0);

        lblLedsager = new Label("Ledsager");
        this.add(lblLedsager,2,0);

        lvwArran = new ListView<>();
        this.add(lvwArran,0,1,2,1);
        //lvwArran.setPrefSize(300,300);
        lvwArran.getItems().setAll(Controller.getArrangement(StartWindow.konference));

        ChangeListener<Arrangement> listener = (ov, oldArrangement, newArrangement) -> this.selectedArrangementChanged();
        lvwArran.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwLed = new ListView<>();
        this.add(lvwLed,2,1,3,1);

        lblName = new Label("Navn");
        this.add(lblName,0,3);

        lblLokation = new Label("Lokation");
        this.add(lblLokation,1,3);

        txfNavn = new TextField();
        this.add(txfNavn,0,4,1,1);
        txfNavn.setPrefWidth(120);

        txfLokation = new TextField();
        this.add(txfLokation,1,4,1,1);
        txfLokation.setPrefWidth(120);

        HBox hbxArran = new HBox(20);
        this.add(hbxArran,1,0);
        HBox hbxLed = new HBox(20);
        this.add(hbxLed,4,0);
        hbxLed.setAlignment(Pos.BASELINE_RIGHT);

        btnCreate = new Button("Opret");
        hbxArran.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> createAction());

        btnDel = new Button("Slet");
        hbxArran.getChildren().add(btnDel);
        btnDel.setOnAction(event -> deleteAction());

        btnAddLedsager = new Button("Tilføj");
        hbxLed.getChildren().add(btnAddLedsager);

        btnRemoveLedsager = new Button("Fjern");
        hbxLed.getChildren().add(btnRemoveLedsager);

    }

    public void createAction(){
        ArrangementWindow arrangementWindow = new ArrangementWindow("Tilføj arrangement");
        arrangementWindow.showAndWait();

        //venter på luk
        lvwArran.getItems().setAll(Controller.getArrangement(StartWindow.konference));
        int index = lvwArran.getItems().size() -1;
        lvwArran.getSelectionModel().select(index);
    }
    private void deleteAction() {
        Arrangement arrangement = lvwArran.getSelectionModel().getSelectedItem();
        if (arrangement != null) {
            if (arrangement.getLedsagere().size() == 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Slet Arrangement");
                alert.setHeaderText("Er du sikker?");
                Optional<ButtonType> result = alert.showAndWait();
                if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                    Controller.deleteArrangement(arrangement,StartWindow.konference);
                    lvwArran.getItems().setAll(Controller.getArrangement(StartWindow.konference));
                    this.updateControls();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Slet arrangement");
                alert.setHeaderText("Du kan ikke slette en arrangement, hvor der er personer tilmeldt");
                // wait for the modal dialog to close
                alert.show();
            }
        }
    }

    private void selectedArrangementChanged(){
        this.updateControls();
    }
    private void updateControls(){
        Arrangement arrangement = lvwArran.getSelectionModel().getSelectedItem();

        if(arrangement != null){
            txfNavn.setText(arrangement.getNavn());
            txfLokation.setText(arrangement.getLokation());
            lvwLed.getItems().setAll(arrangement.getLedsagere());
        }else{
            txfNavn.clear();
            txfLokation.clear();
        }

    }
}

