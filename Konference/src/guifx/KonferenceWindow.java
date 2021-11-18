package guifx;

import application.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KonferenceWindow extends Stage {
    private Label lblNavn, lblLokation, lblPris, lblError;
    private TextField txfName, txfLokation, txfPris;
    private Button btnOk, btnCancel;


    public KonferenceWindow(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lblNavn = new Label("Navn:");
        pane.add(lblNavn,0,0);

        txfName = new TextField();
        pane.add(txfName,0,1,2,1);

        lblLokation = new Label("Lokation");
        pane.add(lblLokation,0,2);

        txfLokation = new TextField();
        pane.add(txfLokation,0,3,2,1);

        lblPris = new Label("Pris");
        pane.add(lblPris,0,4);

        txfPris = new TextField();
        pane.add(txfPris, 0,5,2,1);

        btnOk = new Button("Opret");
        pane.add(btnOk,0,6);
        btnOk.setPrefWidth(100);
        btnOk.setOnAction(event -> okAction());

        btnCancel = new Button("Annuller");
        pane.add(btnCancel,1,6);
        btnCancel.setPrefWidth(100);
        btnCancel.setOnAction(event -> cancelAction());

        lblError = new Label("");
        pane.add(lblError,0,7);
        lblError.setStyle("-fx-text-fill: red");
    }

    private void cancelAction(){
        this.hide();
    }
    private void okAction(){
        String navn = txfName.getText().trim();
        String lokation = txfLokation.getText().trim();
        double pris = -1.0;
        if(navn.length()==0){
            lblError.setText("Mangler navn!");
        }else if (lokation.length() == 0){
            lblError.setText("Mangler lokation!");
        }else {
          try{
              pris = Double.parseDouble(txfPris.getText().trim());
          }catch(NumberFormatException ex){
              //do nothing
          } if(pris < 0){
              lblError.setText("Mangler pris!");
            }else{
                Controller.createKonference(navn, lokation, pris);
            }
        }

        this.hide();

    }

}
