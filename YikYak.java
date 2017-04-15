import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class YikYak extends Application {

    //TODO: Create a linked list called postList that holds Yaks currently in
    //the feed
    private BorderPane borderPane = new BorderPane();
    private ArrayList<StackPane> listOfPanes = new ArrayList<>();
    private ObservableList<StackPane> observableListOfPanes;
    private ListView<StackPane> listView = new ListView<>();
    private String[] phrases = {
        "Pass the buck.",
        "Excited for Java 9 to come out this summer. Can't wait for that #REPL",
        "So sad Taylor and Justin are graduating. We'll miss you!",
        "Kendrick Lamar new album out",
        "EventHandler is the thing that handles the event." };

    public void start(Stage stage) {
        Button refreshButton = new Button("Refresh");
        Button deleteButton = new Button("Delete");
        ImageView bannerImage = new ImageView(new Image("YikYakBanner.png"));
        ToolBar toolbar = new ToolBar(refreshButton, deleteButton);
        borderPane.setTop(bannerImage);
        borderPane.setBottom(toolbar);
        borderPane.setCenter(listView);
        refreshButton.setOnAction(e -> {
                generatePosts();
                updateDisplay();
            });
        deleteButton.setOnAction(e -> {
                deletePosts();
                updateDisplay();
            });
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show(); // makes the window visible to the user
    }

    /**
     * TODO: This method should add new posts to your list of posts.
     */
    public void generatePosts() {


    }

    /**
     * TODO: This method should delete posts from your list of posts.
     */
    public void deletePosts() {


    }

    /**
     * This method updates the feed that is displayed to the user.
     */
    public void updateDisplay() {
        listOfPanes = new ArrayList<>();
        for (int i = 0; i < postList.size(); i++) {
            ImageView postImage = new ImageView(new Image("YikYakPost.png"));
            Text postText = new Text(postList.get(i).getText());
            postText.setWrappingWidth(250);
            StackPane stackPane = new StackPane();
            stackPane.getChildren().addAll(postImage, postText);
            stackPane.setAlignment(postImage, Pos.CENTER_LEFT);
            listOfPanes.add(stackPane);
        }
        observableListOfPanes = FXCollections.observableArrayList(listOfPanes);
        listView = new ListView<>(observableListOfPanes);
        borderPane.setCenter(listView);
    }

    /**
     * This class represents the individual posts that make up the feed.
     */
    private class Post {
        private String text;
        private final int TEXT_LIMIT = 50;

        public Post(String text) {
            if (text.length() < TEXT_LIMIT) {
                this.text = text;
            } else {
                this.text = text.substring(0, TEXT_LIMIT);
            }
        }

        public String getText() {
            return text;
        }
    }

}
