package guifx;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Hotel;
import application.model.Tilvalg;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.List;
import java.util.Optional;


public class DeltagerPane extends GridPane {
    private ListView<Deltager> lvwDeltager;
    private ListView<Hotel> lvwHotel;
    private Label lblDeltager, lblName, lblAdler, lblForedragsholder;
    private TextField txfNavn, txfAlder;
    private Button btnCreate, btnDel;
    private RadioButton rdbYes, rdbNo;


    public DeltagerPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.setPrefSize(300, 300);

        lblName = new Label("Deltager");
        this.add(lblName, 0, 0);


        lvwDeltager = new ListView<>();
        this.add(lvwDeltager, 0, 1, 2, 1);
        //lvwArran.setPrefSize(300,300);
        lvwDeltager.getItems().setAll(Controller.getDeltager(StartWindow.konference));

        lvwHotel = new ListView<>();
        this.add(lvwHotel,3,1,1,1);

        //lvwHotel.getItems().setAll(Controller.get)



        ChangeListener<Deltager> listener = (ov, oldDeltager, newDeltager) -> this.selectedArrangementChanged();
        lvwDeltager.getSelectionModel().selectedItemProperty().addListener(listener);


        lblName = new Label("Navn");
        this.add(lblName, 0, 3);

        lblAdler = new Label("Alder");
        this.add(lblAdler,1,3);

        lblForedragsholder = new Label("Foredragsholder");
        this.add(lblForedragsholder,0,5);

        txfNavn = new TextField();
        this.add(txfNavn, 0, 4, 1, 1);
        txfNavn.setPrefWidth(120);

        txfAlder = new TextField();
        this.add(txfAlder,1,4,1,1);
        txfAlder.setPrefWidth(120);

        rdbNo = new RadioButton("Nej");
        rdbYes = new RadioButton("Ja");
        ToggleGroup toggle = new ToggleGroup();
        this.add(rdbNo,0,6);
        rdbNo.setToggleGroup(toggle);
        rdbNo.setDisable(true);
        rdbYes.setToggleGroup(toggle);
        rdbYes.setDisable(true);
        this.add(rdbYes,1,6);


        HBox hbxArran = new HBox(20);
        this.add(hbxArran, 1, 0);
        HBox hbxLed = new HBox(20);
        this.add(hbxLed, 4, 0);
        hbxLed.setAlignment(Pos.BASELINE_RIGHT);

        btnCreate = new Button("Opret");
        hbxArran.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> createAction());

        btnDel = new Button("Slet");
        hbxArran.getChildren().add(btnDel);
        btnDel.setOnAction(event -> deleteAction());

    }

    public void createAction() {
        ArrangementWindow arrangementWindow = new ArrangementWindow("Tilføj arrangement");
        arrangementWindow.showAndWait();

        //venter på luk
        lvwDeltager.getItems().setAll(Controller.getDeltager(StartWindow.konference));
        int index = lvwDeltager.getItems().size() - 1;
        lvwDeltager.getSelectionModel().select(index);
    }

    private void deleteAction() {
        Deltager deltager = lvwDeltager.getSelectionModel().getSelectedItem();
        if (deltager != null) {
            if (StartWindow.konference.getDeltagere().size() == 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Slet Deltager");
                alert.setHeaderText("Er du sikker?");
                Optional<ButtonType> result = alert.showAndWait();
                if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                    Controller.deleteDeltagerFromKonference(deltager, StartWindow.konference);
                    lvwDeltager.getItems().setAll(Controller.getDeltager(StartWindow.konference));
                    this.updateControls();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Slet Deltager");
                alert.setHeaderText("Kan ikke slette deltagere");
                // wait for the modal dialog to close
                alert.show();
            }
        }
    }

    private void selectedArrangementChanged() {
        this.updateControls();
    }

    private void updateControls() {
        Deltager deltager = lvwDeltager.getSelectionModel().getSelectedItem();

        if (deltager!= null) {
            txfNavn.setText(deltager.getName());
            txfAlder.setText("" + deltager.getAge());
            if(deltager.isForedragsholder()){
                rdbYes.setSelected(true);
            }else{
                rdbNo.setSelected(true);
            }
        } else {
            txfNavn.clear();
            txfAlder.clear();
        }

    }
}







