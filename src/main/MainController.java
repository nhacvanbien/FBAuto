package main;

import com.jfoenix.controls.JFXRippler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController implements Initializable {

    @FXML
    private AnchorPane parent;
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private Pane sidebar;
    @FXML
    private Pane contenPane;
    @FXML
    private Pane commentSettingMenu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeStageDrageable();
    }

    private void makeStageDrageable() {
        parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Launch.stage.setX(event.getScreenX() - xOffset);
                Launch.stage.setY(event.getScreenY() - yOffset);
                Launch.stage.setOpacity(0.9f);
                System.out.println("sdf");
            }
        });
        parent.setOnDragDone((e) -> {
            Launch.stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((e) -> {
            Launch.stage.setOpacity(1.0f);
        });
        
        JFXRippler fXRippler = new JFXRippler(commentSettingMenu);
    }

    private void minimize_app(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void close(MouseEvent event) {
        System.exit(0);
    }

}
