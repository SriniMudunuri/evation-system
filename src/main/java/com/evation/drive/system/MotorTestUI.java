package com.evation.drive.system;

import com.evation.drive.system.components.BottomBracket;
import com.evation.drive.system.components.Drivepack;
import com.evation.drive.system.components.Remote;
import com.evation.drive.system.exceptions.MotorException;
import com.evation.drive.system.exceptions.MotorRuntimeException;
import com.evation.drive.system.service.MotorService;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This is for testing the Evation Drive System for Motor
 * 
 * @author Srinivasa Raju
 *
 */
public class MotorTestUI extends Application {
	// Drivepack
	private int serialNumberDrivepack;
	private short softwareVersionDrivepack;
	private short motorSerialNumberDrivepack;

	// Bottom Bracket
	private int serialNumberBottomBracket;
	private int torqueSensorSerialNumberBottomBracket;

	// Remote
	private int serialNumberRemote;
	private short hmiBoardSerialNumberRemote;

	private Text actiontarget;
	private String textMsg;

	public static void main(String[] args) throws InterruptedException {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		showScreen(primaryStage);

	}

	private void showScreen(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// Drivepack
		Text scenetitledp = new Text("Drivepack");
		scenetitledp.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitledp, 0, 0, 2, 1);

		Label serialNumberDrivepackLebel = new Label("Serial number:");
		grid.add(serialNumberDrivepackLebel, 0, 1);

		TextField serialNumberDrivepackTextField = new TextField();
		grid.add(serialNumberDrivepackTextField, 1, 1);

		Label softwareVersionDrivepackLabel = new Label("Software version:");
		grid.add(softwareVersionDrivepackLabel, 0, 2);

		TextField softwareVersionDrivepackTextField = new TextField();
		grid.add(softwareVersionDrivepackTextField, 1, 2);

		Label motorSerialNumberDrivepackLabel = new Label("Motor serial number:");
		grid.add(motorSerialNumberDrivepackLabel, 0, 3);

		TextField motorSerialNumberDrivepackTextField = new TextField();
		grid.add(motorSerialNumberDrivepackTextField, 1, 3);

		// Bottom Bracket
		Text scenetitlebb = new Text("Bottom Bracket");
		scenetitlebb.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitlebb, 0, 4, 2, 1);

		Label serialNumberBottomBracketLabel = new Label("Serial number:");
		grid.add(serialNumberBottomBracketLabel, 0, 5);

		TextField serialNumberBottomBracketTextField = new TextField();
		grid.add(serialNumberBottomBracketTextField, 1, 5);

		Label torqueSensorSerialNumberBottomBracketLabel = new Label("Torque sensor serial number:");
		grid.add(torqueSensorSerialNumberBottomBracketLabel, 0, 6);

		TextField torqueSensorSerialNumberBottomBracketTextField = new TextField();
		grid.add(torqueSensorSerialNumberBottomBracketTextField, 1, 6);

		// Remote
		Text scenetitlerm = new Text("Remote");
		scenetitlerm.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitlerm, 0, 7, 2, 1);

		Label serialNumberRemoteLabel = new Label("Serial number:");
		grid.add(serialNumberRemoteLabel, 0, 8);

		TextField serialNumberRemoteTextField = new TextField();
		grid.add(serialNumberRemoteTextField, 1, 8);

		Label hmiBoardSerialNumberRemoteLabel = new Label("HMI board serial number:");
		grid.add(hmiBoardSerialNumberRemoteLabel, 0, 9);

		TextField hmiBoardSerialNumberRemoteTextField = new TextField();
		grid.add(hmiBoardSerialNumberRemoteTextField, 1, 9);

		// Submit button
		Button btn = new Button("Check Motor");
		btn.setOnAction(butttonClicked(serialNumberDrivepackTextField, softwareVersionDrivepackTextField,
				motorSerialNumberDrivepackTextField, serialNumberBottomBracketTextField,
				torqueSensorSerialNumberBottomBracketTextField, serialNumberRemoteTextField,
				hmiBoardSerialNumberRemoteTextField));
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 10);

		actiontarget = new Text();
		grid.add(actiontarget, 1, 12);

		Scene scene = new Scene(grid, 600, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Evation Drive System");
		primaryStage.show();
	}

	private EventHandler<ActionEvent> butttonClicked(TextField serialNumberdpTextField,
			TextField softwareVersionDrivepackTextField, TextField motorSerialNumberDrivepackTextField,
			TextField serialNumberBottomBracketTextField, TextField torqueSensorSerialNumberBottomBracketTextField,
			TextField serialNumberRemoteTextField, TextField hmiBoardSerialNumberRemoteTextField) {
		return e -> {
						Drivepack drivePack = null;
			BottomBracket bottomBracket = null;
			Remote remote = null;
			MotorService motorService = null;
			try {
				if (!serialNumberdpTextField.getText().isEmpty() && !softwareVersionDrivepackTextField.getText().isEmpty()
						&& !motorSerialNumberDrivepackTextField.getText().isEmpty()) {
					this.serialNumberDrivepack = Integer.parseInt(serialNumberdpTextField.getText());
					this.softwareVersionDrivepack = Short.parseShort(softwareVersionDrivepackTextField.getText());
					this.motorSerialNumberDrivepack = Short.parseShort(motorSerialNumberDrivepackTextField.getText());
				} else {
					throw new MotorRuntimeException("Drivepack production values are not valid");
				}
				if (!serialNumberBottomBracketTextField.getText().isEmpty()
						&& !torqueSensorSerialNumberBottomBracketTextField.getText().isEmpty()) {
					this.serialNumberBottomBracket = Integer.parseInt(serialNumberBottomBracketTextField.getText());
					this.torqueSensorSerialNumberBottomBracket = Integer
							.parseInt(torqueSensorSerialNumberBottomBracketTextField.getText());
				} else {
					throw new MotorRuntimeException("Bottom Bracket production values are not valid");
				}

				if (!serialNumberRemoteTextField.getText().isEmpty() && !serialNumberRemoteTextField.getText().isEmpty()) {
					this.serialNumberRemote = Integer.parseInt(serialNumberRemoteTextField.getText());
					this.hmiBoardSerialNumberRemote = Short.parseShort(hmiBoardSerialNumberRemoteTextField.getText());
				} else {
					throw new MotorRuntimeException("Remote production values are not valid");
				}

				drivePack = new Drivepack(this.serialNumberDrivepack, this.softwareVersionDrivepack,
						this.motorSerialNumberDrivepack);
				bottomBracket = new BottomBracket(this.serialNumberBottomBracket, this.torqueSensorSerialNumberBottomBracket);
				remote = new Remote(this.serialNumberRemote, this.hmiBoardSerialNumberRemote);

				motorService = new MotorService();
				actiontarget.setFill(Color.DARKGREEN);
				actiontarget.setText("Moter cycle is moving.....");
				String driveSystem = motorService.driveSystem(drivePack, bottomBracket, remote);
				if (driveSystem != null) {
					actiontarget.setFill(Color.DARKGREEN);
					actiontarget.setText(driveSystem);
				} else {
					throw new MotorRuntimeException("Motoer drive stystem is not constructed");
				}
			} catch (MotorRuntimeException | MotorException me) {
				this.textMsg = me.getMessage();
				actiontarget.setText(this.textMsg);
				actiontarget.setFill(Color.DARKRED);
			} catch (Exception ex) {
				this.textMsg = ex.getMessage();
				actiontarget.setText(this.textMsg);
				actiontarget.setFill(Color.DARKRED);
				ex.printStackTrace();

			}
		};
	}

}
