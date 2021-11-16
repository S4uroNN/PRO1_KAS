package guifx;

import application.controller.Controller;
import application.model.Deltager;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class DeltagerPane extends GridPane {
	private TextField txfName, txfAge, txfForedragsholder, txfLedsager, txfFirma;
	private ListView<Deltager> lvwDeltagere;

	public DeltagerPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Deltagere");
		this.add(lblComp, 0, 0);

		lvwDeltagere = new ListView<>();
		this.add(lvwDeltagere, 0, 1, 1, 5);
		lvwDeltagere.setPrefWidth(200);
		lvwDeltagere.setPrefHeight(200);
		//lvwDeltagere.getItems().setAll(Controller.lvwDeltagere());
		//ChangeListener<lvwDeltagere> listener = (ov, oldEmployee, newEmployee) -> this.selectedDeltagerChanged();
		//lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setPrefWidth(200);
		txfName.setEditable(false);

		Label lblFirma = new Label("Firma:");
		this.add(lblFirma, 1, 2);

		txfFirma = new TextField();
		this.add(txfFirma, 2, 2);
		txfFirma.setEditable(false);

		Label lblAge = new Label("Age:");
		this.add(lblAge, 1, 3);

		txfAge = new TextField();
		this.add(txfAge, 2, 3);
		txfAge.setEditable(false);

		Label lblForedragsholder = new Label("Foredragsholder?");
		this.add(lblForedragsholder, 1, 4);

		txfForedragsholder = new TextField();
		this.add(txfForedragsholder, 2, 4);
		txfForedragsholder.setEditable(false);

		Label lblLedsager = new Label("Ledsager:");
		this.add(lblLedsager, 1, 5);

		txfLedsager = new TextField();
		this.add(txfLedsager, 2, 5);
		txfLedsager.setEditable(false);

		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 6, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Update");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		if (lvwDeltagere.getItems().size() > 0) {
			lvwDeltagere.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------
	private void createAction() {}
	private void updateAction() {}
	private void deleteAction() {}

	//TODO add functionality to buttons!

	/*
	private void createAction() {
		DeltagerWindow dia = new DeltagerWindow("Create Deltager");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwDeltagere.getItems().setAll(Controller.getDeltager());
		this.updateControls();
	}

	private void updateAction() {
		Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
		if (deltager != null) {

			DeltagerWindow dia = new DeltagerWindow("Update deltager", deltager);
			dia.showAndWait();

			// Wait for the modal dialog to close

			int selectIndex = lvwDeltagere.getSelectionModel().getSelectedIndex();
			lvwDeltagere.getItems().setAll(Controller.getDeltagere());
			lvwDeltagere.getSelectionModel().select(selectIndex);
		}
	}

	private void deleteAction() {
		Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
		if (deltager != null) {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete Employee");
			// alert.setContentText("Are you sure?");
			alert.setHeaderText("Are you sure?");
			Optional<ButtonType> result = alert.showAndWait();

			// Wait for the modal dialog to close

			if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
				Controller.deleteDeltager(deltager);
				lvwDeltagere.getItems().setAll(Controller.getDeltager());
				this.updateControls();
			}
		}
	}*/

	// -------------------------------------------------------------------------

	private void selectedEmployeeChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
		if (deltager != null) {
			txfName.setText(deltager.getName());
			txfAge.setText("Age: " + deltager.getAge());
			txfForedragsholder.setText("Foredragsholder? " + deltager.isForedragsholder());
		} else {
			txfName.clear();
			txfAge.clear();
			txfForedragsholder.clear();
			txfLedsager.clear();
			txfFirma.clear();
		}
	}

}
