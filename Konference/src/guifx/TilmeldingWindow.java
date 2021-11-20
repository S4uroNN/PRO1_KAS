package guifx;

import application.controller.Controller;
import application.model.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TilmeldingWindow extends Stage {
    private Tilmelding tilmelding;


    public TilmeldingWindow(String title, Tilmelding tilmelding) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.tilmelding = tilmelding;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public TilmeldingWindow(String title) {
        this(title, null);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private TextField txfLedsager;
    private CheckBox chbLedsager, chbForedragsholder;
    private ComboBox<Deltager> cbbDeltager;
    private ComboBox<Konference> cbbKonference;
    private ListView<Arrangement> lvwArrangment, lvwvalgteArrangementer;
    private ComboBox<Hotel> cbbHotel;
    private ListView<Tilvalg> lvwTilvalg, lvwvalgteTilvalg;
    private Label lblError;
    private DatePicker daAnkomstDato, daUdrejseDato;


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblDeltager = new Label("Deltager");
        pane.add(lblDeltager, 0, 0);

        cbbDeltager = new ComboBox<>();
        pane.add(cbbDeltager, 0, 1);
        cbbDeltager.getItems().addAll(Controller.getDeltager());


        chbLedsager = new CheckBox("Ledsager");
        pane.add(chbLedsager, 0, 3);
        chbLedsager.setOnAction(event -> {
            if (chbLedsager.isSelected()) {
                txfLedsager.setDisable(false);
                lvwArrangment.setDisable(false);

            } else {
                txfLedsager.setDisable(true);
                txfLedsager.clear();
                lvwArrangment.setDisable(true);
            }
        });
        chbForedragsholder = new CheckBox("Foredragsholder");
        pane.add(chbForedragsholder, 0, 2);

        txfLedsager = new TextField();
        pane.add(txfLedsager, 0, 4);
        txfLedsager.setDisable(true);

        Label lblArrangement = new Label("Arrangement");
        pane.add(lblArrangement, 0, 8);

        lvwArrangment = new ListView<>();
        pane.add(lvwArrangment, 0, 9);
        lvwArrangment.setPrefHeight(100);
        lvwArrangment.setPrefWidth(100);
        lvwArrangment.setDisable(true);
        lvwArrangment.setEditable(false);

        lvwvalgteArrangementer = new ListView<>();
        pane.add(lvwvalgteArrangementer, 1, 9);
        lvwvalgteArrangementer.setPrefHeight(100);
        lvwvalgteArrangementer.setPrefWidth(100);


        Label lblHotel = new Label("Hotel");
        pane.add(lblHotel, 0, 11);

        cbbHotel = new ComboBox<>();
        pane.add(cbbHotel, 0, 12);
        cbbHotel.getItems().addAll(Controller.getHoteller());
        cbbHotel.setOnAction(event -> {
            if (cbbHotel.getSelectionModel().getSelectedItem() != null) {
                Hotel hotel = cbbHotel.getSelectionModel().getSelectedItem();
                lvwTilvalg.getItems().setAll(hotel.getTilvalgs());
            }
        });


        Label lblTilvalg = new Label("Tilvalg");
        pane.add(lblTilvalg, 0, 13);


        lvwTilvalg = new ListView<>();
        pane.add(lvwTilvalg, 0, 14);
        lvwTilvalg.setPrefHeight(100);
        lvwTilvalg.setPrefWidth(100);

        lvwvalgteTilvalg = new ListView<>();
        pane.add(lvwvalgteTilvalg, 1, 14);
        lvwvalgteTilvalg.setPrefHeight(100);
        lvwvalgteTilvalg.setPrefWidth(100);


        Button btnAddTilvalg = new Button("Add");
        pane.add(btnAddTilvalg, 0, 16);
        GridPane.setHalignment(btnAddTilvalg, HPos.RIGHT);
        btnAddTilvalg.setOnAction(event -> this.addAction());

        Button btnAddUdflugt = new Button("Add");
        pane.add(btnAddUdflugt, 0, 10);
        GridPane.setHalignment(btnAddUdflugt, HPos.RIGHT);
        btnAddUdflugt.setOnAction(event -> this.addUdflugtAction());


        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 21);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 21);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 22);
        lblError.setStyle("-fx-text-fill: red");

    }
    // -----------------------------------------------------------------------------------------------------------------


    private void cancelAction() {
        this.hide();
    }

    private void addUdflugtAction() {
        lvwvalgteArrangementer.getItems().add(lvwArrangment.getSelectionModel().getSelectedItem());
    }

    private void addAction() {
        lvwvalgteTilvalg.getItems().add(lvwTilvalg.getSelectionModel().getSelectedItem());

    }
    private void okAction() {
        Deltager deltager = cbbDeltager.getValue();
        Konference konference = StartWindow.konference;
        Hotel hotel = cbbHotel.getValue();
        Arrangement arrangement = lvwArrangment.getSelectionModel().getSelectedItem();
        Tilvalg tilvalg = lvwTilvalg.getSelectionModel().getSelectedItem();

        if (cbbDeltager.getSelectionModel().getSelectedItem() == null) {
            lblError.setText("Deltager er tom");
        } else {

            boolean foredragsholder = false;
            if (chbForedragsholder.isSelected()) {
                foredragsholder = true;
            }
            if (cbbKonference.getSelectionModel().getSelectedItem() == null) {
                lblError.setText("Vælg en konference");
            }
            if (chbLedsager.isSelected() && txfLedsager.getText().length() == 0) {
                lblError.setText("Skriv et ledsagernavn");
            } else if (chbLedsager.isSelected()) {
                String ledsagerNavn = txfLedsager.getText().trim();
                Ledsager ledsager = Controller.createLedsager(deltager,ledsagerNavn,38);
                if (arrangement != null) {
                    for (int i = 0; i < lvwvalgteArrangementer.getItems().size(); i++) {
                        Controller.addLedsagerToArrangement(ledsager,lvwvalgteArrangementer.getItems().get(i));
                    }
                }
            }
        }
        this.hide();
    }
}
