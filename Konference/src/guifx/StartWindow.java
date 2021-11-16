package guifx;

import application.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {

	@Override
	public void init() {
		Controller.init();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Architecture Demo");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tabDeltagere = new Tab("Deltagere");
		tabPane.getTabs().add(tabDeltagere);

		DeltagerPane deltagerPane = new DeltagerPane();
		tabDeltagere.setContent(deltagerPane);
		tabDeltagere.setOnSelectionChanged(event -> deltagerPane.updateControls());

		Tab tabArrangementer = new Tab("Arrangementer");
		tabPane.getTabs().add(tabArrangementer);

		/*
		EmployeePane employeePane = new EmployeePane();
		tabEmployees.setContent(employeePane);
		tabEmployees.setOnSelectionChanged(event -> employeePane.updateControls());
		 */

		Tab tabForedrag = new Tab("Foredrag");
		tabPane.getTabs().add(tabForedrag);
	}
}
