package com.example;


import javafx.fxml.FXML;
        import javafx.scene.control.Alert;
        import javafx.scene.control.TextArea;

public class RestaurantController {

    @FXML
    private TextArea infoTextArea;

    @FXML
    private void showKFCInfo() {
        infoTextArea.setText("KFC (Kentucky Fried Chicken) is a fast-food restaurant chain that specializes in fried chicken. It was founded by Colonel Harland Sanders in 1952. KFC is known for its secret blend of 11 herbs and spices, which gives its chicken a unique and delicious flavor. In addition to fried chicken, KFC also offers a variety of other menu items, such as sandwiches, wraps, salads, and sides like mashed potatoes and coleslaw.");
    }

    @FXML
    private void showBiography() {
        infoTextArea.setText("Colonel Harland Sanders, the founder of KFC, was born on September 9, 1890, in Henryville, Indiana, USA. He started cooking at a young age and developed a passion for creating delicious meals. In 1930, Sanders opened a small restaurant called Sanders Court & Cafe, where he served his famous fried chicken. Over the years, Sanders perfected his recipe and cooking technique, which led to the establishment of KFC. Today, KFC is a global brand with thousands of locations worldwide, continuing Colonel Sanders' legacy of serving finger-lickin' good chicken.");
    }

    // Other methods and logic for your application

}