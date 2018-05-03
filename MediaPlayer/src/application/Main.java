package application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

public class Main extends Application {

	MenuBar menu;
	FileChooser fileChooser;
	Player player;

	@Override
	public void start(Stage primaryStage) {

		MenuItem open = new MenuItem("Open");

		Menu file = new Menu("File");
		file.getItems().add(open);

		menu = new MenuBar();
		menu.getMenus().add(file);

		fileChooser = new FileChooser();

		open.setOnAction((e) -> {
			player.player.pause();
			File mediaFile = fileChooser.showOpenDialog(primaryStage);
			if (file != null) {
				try {
					player = new Player(mediaFile.toURI().toURL().toExternalForm());
					player.setTop(menu);
					Scene scene = new Scene(player, 720, 535, Color.BLACK);
					player.view.setFitWidth(scene.getWidth());
					primaryStage.setScene(scene);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		player = new Player("file:///Users/arseniychernykh/Desktop/MediaPlayerS1.mp4");
		player.setTop(menu);

		Scene scene = new Scene(player, 720, 535, Color.BLACK);
		player.view.setFitWidth(scene.getWidth());
		primaryStage.setScene(scene);
		primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
			player.view.setFitWidth(newVal.doubleValue());
		});
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
