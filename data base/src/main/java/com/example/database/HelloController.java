package com.example.database;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import oracle.jdbc.driver.OracleDriver;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TableView tabelorderdetails;
    public TextField storenum;
    public TextField ordernum;

    public TextField customerid;
    public TextField orderdate;
    @FXML
    private TableView<Item> table;
    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TextField order_i;
    @FXML
    private TextField order_det;
    @FXML
    private TextField order_pr;
    @FXML
    private TextField product_id;

    @FXML
    private TextField order_quantity;

    @FXML
    private TableView<Store> storeTable;


    @FXML
    private TableView<Order> table2;

    @FXML
    private AnchorPane dash_menu;


    @FXML
    private Button login_button;

    @FXML
    private Hyperlink login_cerateAccount;

    @FXML
    private Label login_label;

    @FXML
    private PasswordField login_password;
    @FXML
    private TextField priceText;

    @FXML
    private TextField storeIdField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField jobTitleField;
    @FXML
    private TextField salaryField;

    @FXML
    private TableView<OrderDetail> orderDetailTable;
    @FXML
    private TextField quant;
    @FXML
    private TextField itemname;

    @FXML
    private TextField supp;
    @FXML
    private Button add_oder;
    @FXML
    private Button order_reports;
    @FXML
    private Button order_details;
    @FXML
    private Button delete_order;
    @FXML
    private Button edit_order;
    @FXML
    private Button search_order;
    @FXML
    private TextField login_username;

    @FXML
    private TextField employee1;


    @FXML
    private TableColumn<Item, String> item;

    @FXML
    private TableColumn<Item, Integer> qunt;

    @FXML
    private TableColumn<Item, Double> price;

    @FXML
    private TableColumn<Item, String> supplier;
    //-----------------------------table 2


    @FXML
    private TextField locationtxt;


    @FXML
    private TextField phonetxt;


    @FXML
    private Button storebut;


    @FXML
    private TextField storetxt;


    @FXML
    private TableColumn<Order, Integer> storeID_O;
    @FXML
    private TableColumn<Order, Integer> orderID;


    @FXML
    private TableColumn<Order, Integer> customerID;
    @FXML
    private TableColumn<Order, Date> ORDERDATE;

    @FXML
    private TableColumn<Employee, Integer> employeeID;

    @FXML
    private TableColumn<Employee, Integer> storeID_E;

    @FXML
    private TableColumn<Employee, String> name;

    @FXML
    private TableColumn<Employee, String> gender;

    @FXML
    private TableColumn<Employee, String> phone;

    @FXML
    private TableColumn<Employee, String> jobTitle;

    @FXML
    private TableColumn<Employee, Double> salary;
    @FXML
    private TextField itemField;

    @FXML
    private TextField quantityField;
    @FXML
    private AnchorPane orderdetailsform;
    @FXML
    private TextField priceField;

    @FXML
    private TextField supplierField;
    @FXML
    private TextField emailtxt;
    @FXML
    private Button addItemButton;

    private ObservableList<HelloController> inventoryItems;

/////////////////sotre


    @FXML
    private TableColumn<Store, Integer> storeID;

    @FXML
    private TableColumn<Store, String> location;

    @FXML
    private TableColumn<Store, String> phoneNO;

    @FXML
    private TableColumn<Store, String> email;

    //----- order deitals

    @FXML
    private TableColumn<OrderDetail, Integer> orderDetailId;


    @FXML
    private TableColumn<OrderDetail, Integer> PRODUCTID;

    @FXML
    private TableColumn<OrderDetail, Integer> QUANTITY;

    @FXML
    private TableColumn<OrderDetail, Double> PRICE;

    @FXML
    private TableColumn<OrderDetail, Integer> ORDERID2;


    @FXML
    private Button sign_button;

    @FXML
    private TextField sign_email;

    @FXML
    private Label sign_label;

    @FXML
    private PasswordField sign_password;

    @FXML
    private TextField sign_username;


    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    void exit3(ActionEvent event) {
        add_order_pane1.setVisible(false);
    }

    ;


    @FXML
    private Hyperlink sign_alreadyhave;

    @FXML
    void textfield(MouseEvent event) {

    }

    @FXML
    private AnchorPane inventory_dash;
    @FXML
    private AnchorPane login_form;

    @FXML
    private AnchorPane sign_form;
    @FXML
    private Button dash_btnmenu;
    @FXML
    private AnchorPane menu;
    @FXML
    private AnchorPane about_d;
    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    @FXML
    private AnchorPane forsign;

    @FXML
    private AnchorPane forlogin;


    @FXML
    private AnchorPane dash_list;
    @FXML
    private AnchorPane dash_photo;

    public void dash_btnmenu(ActionEvent event) {
        inventory_dash.setVisible(false);
        dash_menu.setVisible(false);
        dash_list.setVisible(true);
        dash_photo.setVisible(true);
        menu.setVisible(true);
        order_form.setVisible(false);
        about_d .setVisible(false);

        orderdetailsform.setVisible(false);
        reportform.setVisible(false);

    }

    @FXML
    private ImageView image1;

    public void home(ActionEvent event) {

        menu.setVisible(false);
        dash_menu.setVisible(true);
        dash_list.setVisible(true);
        dash_photo.setVisible(true);
        inventory_dash.setVisible(false);
        order_form.setVisible(false);
        about_d .setVisible(false);

        orderdetailsform.setVisible(false);
        reportform.setVisible(false);


    }

    @FXML
    private AnchorPane reportform;

    public void report(ActionEvent event) {

        menu.setVisible(false);
        dash_menu.setVisible(false);
        dash_list.setVisible(true);
        dash_photo.setVisible(true);
        inventory_dash.setVisible(false);
        order_form.setVisible(false);
        about_d .setVisible(false);

        orderdetailsform.setVisible(false);
        reportform.setVisible(true);


    }

    @FXML
    private Button button_close_order;

    @FXML
    private VBox vbox_order;
    @FXML
    private DialogPane add_order_pane1;

    public void add2(ActionEvent event) {

        add_order_pane1.setVisible(true);
        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(vbox_order);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(cancelButtonType);

        Button cancelButton = (Button) dialog.getDialogPane().lookupButton(cancelButtonType);
        cancelButton.setStyle("-fx-background-color: #9a0000; -fx-background-radius: 30px; -fx-cursor: hand;-fx-text-fill:white");


        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.initStyle(StageStyle.UNDECORATED);
        add_order_pane1.setVisible(false);

        dialog.showAndWait();

    }

    public void inventory(ActionEvent event) {

        menu.setVisible(false);
        inventory_dash.setVisible(true);
        dash_list.setVisible(true);
        dash_photo.setVisible(true);
        dash_menu.setVisible(false);
        order_form.setVisible(false);
        orderdetailsform.setVisible(false);
        about_d .setVisible(false);

    }


    public void about(ActionEvent event) {

        menu.setVisible(false);
        inventory_dash.setVisible(true);
        dash_list.setVisible(true);
        dash_photo.setVisible(true);
        dash_menu.setVisible(false);
        order_form.setVisible(false);
        orderdetailsform.setVisible(false);
        about_d .setVisible(true);

    }

    @FXML
    void switchform(MouseEvent event) {

    }

    @FXML
    private Button dash_employee;

    @FXML
    private Button dash_exit;

    @FXML
    private Button dash_home;


    @FXML
    private Button dash_order;

    @FXML
    private Button dash_reports;

    @FXML
    private Button dsah_about;


    @FXML
    private AnchorPane order_form;


    public void order1(ActionEvent event) {
        menu.setVisible(false);
        order_form.setVisible(true);
        dash_list.setVisible(true);
        dash_photo.setVisible(true);
        dash_menu.setVisible(false);
        inventory_dash.setVisible(false);
        about_d .setVisible(false);

        orderdetailsform.setVisible(false);
        reportform.setVisible(false);

    }

    @FXML
    private AnchorPane StoreForm;
    @FXML
    private AnchorPane firstb;
    @FXML
    private AnchorPane emloyeeForm;
    @FXML
    private Label totalincome;

    @FXML
    private Label totalorder;

    @FXML
    private AnchorPane admin_employee;

    public void orderdetails(ActionEvent event) {
        menu.setVisible(false);
        dash_menu.setVisible(false);
        dash_list.setVisible(true);
        dash_photo.setVisible(true);
        inventory_dash.setVisible(false);
        order_form.setVisible(false);
        orderdetailsform.setVisible(true);
        reportform.setVisible(false);

    }

    @FXML
    public void closeorder(ActionEvent event) {
        add_order_pane1.setVisible(false);
    }

    private Alert alert;
    int flag = 0;

    @FXML
    public void logout(ActionEvent event) throws Exception {
        try {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erorr Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you wants to logout ?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {


                Stage currentStage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
                currentStage.close();

                Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);

                stage.initStyle(StageStyle.TRANSPARENT);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("kfc");
                stage.show();

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @FXML
    public void initialize(URL url, ResourceBundle r) {
        loadDataFromSQL();//invintory
        loadDataFromSQL2();//order
        loadData5();
        displayNumberOfCustomers();
        displayNumberOforder();
        displaytotalincome1();
        createLineChart();
        createAreaChart();
        createBarChart();
    }

    @FXML
    private BarChart<String, Number> createBarChartPane;
    private void createBarChart() {
        xAxis.setLabel("Day");
        yAxis.setLabel("Total Income");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Mon", 10));
        series.getData().add(new XYChart.Data<>("Tue", 20));
        series.getData().add(new XYChart.Data<>("Wed", 30));
        series.getData().add(new XYChart.Data<>("Thu", 40));
        series.getData().add(new XYChart.Data<>("Fri", 50));
        series.getData().add(new XYChart.Data<>("Sat", 60));
        series.getData().add(new XYChart.Data<>("Sun", 70));

        createBarChartPane.getData().add(series);
    }
    @FXML
    private AreaChart<String, Number>createAreaChartPane;
    private void createAreaChart() {
        // Create the x-axis and y-axis
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis(0, 10, 1);
        yAxis.setLabel("Number of Orders");

        // Set the x-axis tick labels to display the days
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        xAxis.setCategories(FXCollections.observableArrayList(days));
        xAxis.setLabel("Days");

        // Create a series for the data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Mon", 5));
        series.getData().add(new XYChart.Data<>("Tue", 7));
        series.getData().add(new XYChart.Data<>("Wed", 3));
        series.getData().add(new XYChart.Data<>("Thu", 8));
        series.getData().add(new XYChart.Data<>("Fri", 4));
        series.getData().add(new XYChart.Data<>("Sat", 6));
        series.getData().add(new XYChart.Data<>("Sun", 2));

        // Add the series to the area chart
        createAreaChartPane.getData().add(series);
    }

    @FXML
    public void loadDataFromSQL() {// invintory
        try {
            // Establish a connection to the SQL database
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url, "c##kareem", "123456");

            // Create a statement to execute SQL queries
            Statement statement = con.createStatement();

            // Execute the SQL query to retrieve the data
            String query = "SELECT ITEM, QUANTITY, PRICE, SUPPLIER FROM INVENTORY";
            ResultSet resultSet = statement.executeQuery(query);

            table.getItems().clear();

            // Set up cell value factories for table columns
            item.setCellValueFactory(new PropertyValueFactory<>("item"));
            qunt.setCellValueFactory(new PropertyValueFactory<>("qunt"));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));
            supplier.setCellValueFactory(new PropertyValueFactory<>("supplier"));

            // Create an observable list to hold the data
            ObservableList<Item> dataList = FXCollections.observableArrayList();

            // Populate the JavaFX table with data from the result set
            while (resultSet.next()) {
                String item = resultSet.getString("ITEM");
                int qunt = resultSet.getInt("QUANTITY");
                double price = resultSet.getDouble("PRICE");
                String supplier = resultSet.getString("SUPPLIER");

                Item newItem = new Item(item, qunt, price, supplier);
                dataList.add(newItem);
            }

            // Set the data in the table
            table.setItems(dataList);

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double x = 0.0;
    private double y = 0.0;
    @FXML
    private Label customertotal;

    @FXML
    private AreaChart<?, ?> cahrt_o;

    @FXML
    private LineChart<?, ?> chart_c;

    @FXML
    private AreaChart<?, ?> chart_income;

    public void displayNumberOfCustomers() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url, "c##kareem", "123456");

            // Create a statement to execute SQL queries
            Statement statement = con.createStatement();

            String sql = "SELECT COUNT(NAME) AS TOTAL FROM CUSTOMER";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int noc = resultSet.getInt("TOTAL");
                customertotal.setText(Integer.toString(noc));
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displaytotalincome1() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url, "c##kareem", "123456");

            // Create a statement to execute SQL queries
            Statement statement = con.createStatement();

            String sql = "SELECT SUM (PRICE) AS TOTAL FROM ORDERDETAIL";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int noc = resultSet.getInt("TOTAL");
                totalincome.setText(Integer.toString(noc));
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displaychartincome() {
        try {
            chart_c.getData().clear();
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url, "c##kareem", "123456");
            String sql = "SELECT COUNT(NAME) FROM CUSTOMER";

            // Create a statement to execute SQL queries
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            XYChart.Series chart = new XYChart.Series<>();
            if (resultSet.next()) {

                chart.getData().add(new XYChart.Data<>(resultSet.getString(1), resultSet.getInt(2)));

            }
            chart_c.getData().add(chart);
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayNumberOforder() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url, "c##kareem", "123456");

            // Create a statement to execute SQL queries
            Statement statement = con.createStatement();

            String sql = "SELECT COUNT(ORDERID ) AS TOTAL FROM ORDERS ";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int noc = resultSet.getInt("TOTAL");
                totalorder.setText(Integer.toString(noc));
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stage stg;

    public void loginFunc(ActionEvent event) {
        String username1 = login_username.getText();
        String password1 = String.valueOf(login_password.getText());

        try {
            DriverManager.registerDriver(new OracleDriver());
            String url1 = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url1, "c##kareem", "123456");
            con.setAutoCommit(false);
            String sql = "SELECT * FROM Accounts WHERE USERNAME=? AND PASSWORDS=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username1);
            preparedStatement.setString(2, password1);

            ResultSet resultSet = preparedStatement.executeQuery();
int s;
            if (resultSet.next()) {
                s = resultSet.getInt("EMPLOYEETYPE");
                // Check if the user has employee type 2 (dashboord)
                if (s == 2) {
                    // Load the dashboard.fxml file
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
                    Parent root = loader.load();

                    AdminController admin22 = loader.getController();
                    loader.setController(admin22);

                    Stage stage = (Stage) login_username.getScene().getWindow();
                    Scene sc = new Scene(root);


                    stage.setScene(sc);
                    stage.show();
                } else if (s==1) {
                    // Load the dashboard.fxml file

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                    Parent root = loader.load();
                    HelloController dashboardController = loader.getController();


                    loader.setController(dashboardController);
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) login_username.getScene().getWindow();




                    stg = stage;
                    root.setOnMousePressed(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            HelloController.this.x = event.getSceneX();
                            HelloController.this.y = event.getSceneY();
                        }
                    });
                    root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            stage.setX(event.getScreenX() - HelloController.this.x);
                        }
                    });
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setTitle("kfc");
                    stage.setScene(scene);
                    stage.show();
                }


        } else {
                showAlert("Login failed");
            }
        }
        catch (Exception e){
            e.printStackTrace();


        }
    }


    public void displayincometoday() {

    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void onAddItemButtonClicked(ActionEvent event) {
        // Retrieve input values from the user
        String item = itemname.getText();
        int qunt = Integer.parseInt(quant.getText());
        double price = Double.parseDouble(priceText.getText());
        String supplier = supp.getText();

        // Insert the new item into the SQL database
        insertItemIntoSQL(item, qunt, price, supplier);

        // Create a new Item object
        Item newItem = new Item(item, qunt, price, supplier);

        // Add the new item to the table's data model
        table.getItems().add(newItem);

        // Clear the input fields
        itemname.clear();
        quant.clear();
        priceText.clear();
        supp.clear();
    }

    @FXML
    private void insertItemIntoSQL(String item, int qunt, double price, String supplier) {
        try {
            // Establish a connection to the SQL database
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##kareem", "123456");

            // Create a prepared statement for the INSERT statement
            String query = "INSERT INTO INVENTORY (ITEM, QUANTITY, PRICE, SUPPLIER) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, item);
            statement.setInt(2, qunt);
            statement.setDouble(3, price);
            statement.setString(4, supplier);

            // Execute the INSERT statement
            statement.executeUpdate();

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private LineChart<String, Number> lineChart;

    private void createLineChart() {
        // Create the x-axis and y-axis
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis(0, 10, 1);

        lineChart.setLegendVisible(false);

        // Set the x-axis tick labels to display the days
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        xAxis.setCategories(FXCollections.observableArrayList(days));
        xAxis.setLabel("Days");

        // Create a series for the data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Mon", 5));
        series.getData().add(new XYChart.Data<>("Tue", 7));
        series.getData().add(new XYChart.Data<>("Wed", 3));
        series.getData().add(new XYChart.Data<>("Thu", 8));
        series.getData().add(new XYChart.Data<>("Fri", 4));
        series.getData().add(new XYChart.Data<>("Sat", 6));
        series.getData().add(new XYChart.Data<>("Sun", 2));

        // Add the series to the line chart
        lineChart.getData().add(series);

        // Set the x-axis and y-axis to the line chart
        lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
        lineChart.setAnimated(false);
        lineChart.setAlternativeRowFillVisible(false);
        lineChart.setAlternativeColumnFillVisible(false);
        lineChart.setHorizontalZeroLineVisible(false);
        lineChart.setVerticalZeroLineVisible(false);
        lineChart.setLegendVisible(false);
        lineChart.setCreateSymbols(false);
        lineChart.getXAxis().setTickLabelsVisible(true);
        lineChart.getYAxis().setTickLabelsVisible(true);
        lineChart.getXAxis().setTickMarkVisible(false);
        lineChart.getYAxis().setTickMarkVisible(false);
        lineChart.getXAxis().setOpacity(0);
        lineChart.getYAxis().setOpacity(0);
    }





    @FXML
    public void loadDataFromSQL2() {
        try {
            // Establish a connection to the SQL database
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection connection = DriverManager.getConnection(url, "c##kareem", "123456");

            // Create a statement to execute SQL queries
            Statement statement = connection.createStatement();

            // Execute the SQL query to retrieve the data
            String query = "SELECT ORDERID,STOREID, ORDERDATE, CUSTOMERIDS FROM ORDERS";
            ResultSet resultSet = statement.executeQuery(query);

            // Clear existing data in the table
            table2.getItems().clear();
table2.refresh();
            storeID_O.setCellValueFactory(new PropertyValueFactory<>("storeID"));
            orderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
            customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
            ORDERDATE.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));



            ObservableList<Order> orderList = FXCollections.observableArrayList();

            // Populate the JavaFX table with data from the result set
            while (resultSet.next()) {
                int storeID = resultSet.getInt("storeID");
                int orderID1 = resultSet.getInt("orderID");
                int customerID = resultSet.getInt("CUSTOMERIDS");
                String ORDERDATE3 = resultSet.getString("ORDERDATE");

                Order newOrder = new Order(storeID, orderID1, customerID, ORDERDATE3);
                orderList.add(newOrder);
            }


            // Set the data in the table
            table2.setItems(orderList);

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField idfield;
    ////////////////////////////////////////////////////////////////////////////////////////////////////// empployee








    @FXML
    private void addOrder(ActionEvent event) {
        try {
            // Retrieve input values from the text fields
            int orderNum = Integer.parseInt(ordernum.getText());
            int storeNum = Integer.parseInt(storenum.getText());
            String orderDate = orderdate.getText();
            int customerID = Integer.parseInt(customerid.getText());

            // Insert the new order into the SQL database
            insertOrderIntoSQL45(orderNum, storeNum,orderDate, customerID);

            // Create a new Order object
            Order newOrder = new Order(orderNum, storeNum, customerID, orderDate);

            // Add the new order to the table's data model
            table2.getItems().add(newOrder);
            table2.refresh();

            // Clear the input fields
            ordernum.clear();
            storenum.clear();
            // Clear the input field for order date
            customerid.clear();
            orderdate.clear();
        } catch (NumberFormatException e) {
            // Handle the case where input values are not valid integers
            e.printStackTrace();
        }
    }

    private void insertOrderIntoSQL45(int orderNum, int storeNum, String orderDate, int customerID) {
        try {
            // Establish a connection to the SQL database
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##kareem", "123456");

            // Create a prepared statement for the INSERT statement
            String query = "INSERT INTO ORDERS (ORDERID, STOREID, ORDERDATE, CUSTOMERIDS) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderNum);// storenum
            statement.setInt(2, storeNum);//date
            statement.setString(3, String.valueOf(orderDate));//ordernum
            statement.setInt(4, customerID);

            // Execute the INSERT statement
            statement.executeUpdate();

            // Close the statement and connection
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteOrder(ActionEvent event) {
        // Get the selected order from the table
        Order selectedOrder = table2.getSelectionModel().getSelectedItem();

        if (selectedOrder == null) {
            // No order is selected, handle the error or show a message to the user
            System.out.println("No order selected.");
            return;
        }

        try {
            // Establish a connection to the SQL database
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##kareem", "123456");

            // Create a prepared statement for the DELETE statement
            String query = "DELETE FROM ORDERS WHERE ORDERId= ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, selectedOrder.getOrderID());

            // Execute the DELETE statement
            statement.executeUpdate();

            // Close the statement and connection
            statement.close();
            connection.close();

            // Remove the selected order from the table's data model
            table2.getItems().remove(selectedOrder);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @FXML
    private void deleteItem(ActionEvent event) {
        // Get the selected item from the table
        Item selectedItem = table.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            // No item is selected, handle the error or show a message to the user
            System.out.println("No item selected.");
            return;
        }

        try {
            // Establish a connection to the SQL database
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##kareem", "123456");

            // Create a prepared statement for the DELETE statement
            String query = "DELETE FROM INVENTORY WHERE ITEM = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, selectedItem.getItem());

            // Execute the DELETE statement
            statement.executeUpdate();

            // Close the statement and connection
            statement.close();
            connection.close();

            // Remove the selected item from the table's data model
            table.getItems().remove(selectedItem);

            // Clear the input fields (if needed)
            itemname.clear();
            quant.clear();
            priceText.clear();
            supp.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }}
        @FXML
        private void onEditButtonClicked (ActionEvent event){
            // Get the selected item from the table
            Item selectedItem = table.getSelectionModel().getSelectedItem();

            if (selectedItem == null) {
                // No item is selected, handle the error or show a message to the user
                System.out.println("No item selected.");
                return;
            }

            // Retrieve the updated values from the user
            String updatedItem = itemname.getText();
            int updatedQuantity = Integer.parseInt(quant.getText());
            double updatedPrice = Double.parseDouble(priceText.getText());
            String updatedSupplier = supp.getText();

            // Update the item in the SQL database
            updateItemInSQL(selectedItem.getItem(), updatedItem, updatedQuantity, updatedPrice, updatedSupplier);

            // Update the item in the table's data model
            selectedItem.setItem(updatedItem);
            selectedItem.setQunt(updatedQuantity);
            selectedItem.setPrice(updatedPrice);
            selectedItem.setSupplier(updatedSupplier);

            // Refresh the table view to reflect the changes
            table.refresh();

            // Clear the input fields
            itemname.clear();
            quant.clear();
            priceText.clear();
            supp.clear();
        }
        private void updateItemInSQL (String oldItem, String newItem,int newQuantity, double newPrice, String
        newSupplier){
            try {
                // Establish a connection to the SQL database
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##kareem", "123456");

                // Create a prepared statement for the UPDATE statement
                String query = "UPDATE INVENTORY SET ITEM = ?, QUANTITY = ?, PRICE = ?, SUPPLIER = ? WHERE ITEM = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, newItem);
                statement.setInt(2, newQuantity);
                statement.setDouble(3, newPrice);
                statement.setString(4, newSupplier);
                statement.setString(5, oldItem);

                // Execute the UPDATE statement
                statement.executeUpdate();

                // Close the statement and connection
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }






    @FXML
    public void loadData5() {//ORDER DETAIL
        try {
            // Establish a connection to the SQL database
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection connection = DriverManager.getConnection(url, "c##kareem", "123456");

            // Create a statement to execute SQL queries
            Statement statement = connection.createStatement();

            // Execute the SQL query to retrieve the data
            String query = "SELECT ORDERDETAILID, ORDERID, PRODUCTID, QUANTITY, PRICE FROM ORDERDETAIL";
            ResultSet resultSet = statement.executeQuery(query);

            // Clear existing data in the table

            orderDetailId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getOrderDetailId()).asObject());

            ORDERID2.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getOrderId()).asObject());
            PRODUCTID.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getProductId()).asObject());
            QUANTITY.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());
            PRICE.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());

            ObservableList<OrderDetail> orderDetailObservableList = FXCollections.observableArrayList();

            // Populate the JavaFX table with data from the result set
            while (resultSet.next()) {
                int orderDetailId1 = resultSet.getInt("ORDERDETAILID");
                int orderId = resultSet.getInt("ORDERID");
                int productId = resultSet.getInt("PRODUCTID");
                int quantity = resultSet.getInt("QUANTITY");
                double price = resultSet.getDouble("PRICE");

                OrderDetail orderDetail = new OrderDetail(orderDetailId1, orderId, productId, quantity, price);
                orderDetailObservableList.add(orderDetail);
            }

            // Set the data in the table view
            orderDetailTable.setItems(orderDetailObservableList);
            orderDetailTable.refresh();

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//----------------------

    @FXML
    void print(ActionEvent event) throws Exception{
        try{

            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url, "c##kareem", "123456");
            con.setAutoCommit(false);
            Statement state = con.createStatement();
            InputStream inputStream = new FileInputStream(new File("Tree.jrxml"));
            System.out.print("HII");
            JasperDesign jd = JRXmlLoader.load(inputStream);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JFrame frame = new JFrame("Tree");
            frame.getContentPane().add(new JRViewer(jp));
            frame.pack();
            frame.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null , e.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null , e.toString());
        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null , e.toString());
        } catch (HeadlessException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null , e.toString());
        }



    }
//---------------------------- add order
   @FXML
    private void  add_or(ActionEvent event) {
        try {
            // Retrieve input values from the text fields
            int orderid = Integer.parseInt(order_i.getText());
            int orderdet = Integer.parseInt(order_det.getText());
            int product12 = Integer.parseInt(product_id.getText());
            int orderpr = Integer.parseInt(order_pr.getText());

            int quantityorder = Integer.parseInt(order_quantity.getText());

            // Insert the new order into the SQL database
            insertOrderIntoSQL456(orderid, orderdet,product12, orderpr,quantityorder);

            // Create a new Order object
            OrderDetail newOrder = new OrderDetail(orderid, orderdet, product12, orderpr,quantityorder);

            // Add the new order to the table's data model
            orderDetailTable.getItems().add(newOrder);
            orderDetailTable.refresh();

            // Clear the input fields
            order_i.clear();
            order_det.clear();
            // Clear the input field for order date
            product_id.clear();
            order_pr.clear();
            order_quantity.clear();
        } catch (NumberFormatException e) {
            // Handle the case where input values are not valid integers
            e.printStackTrace();
        }
    }

    private void insertOrderIntoSQL456(int orderNum, int det, int product, int price, int qunt) {
        try {
            // Establish a connection to the SQL database
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##kareem", "123456");

            // Create a prepared statement for the INSERT statement
            String query = "INSERT INTO ORDERDETAIL ( ORDERID,ORDERDETAILID, PRODUCTID, QUANTITY,PRICE) VALUES (?, ?, ?, ?,?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderNum);// storenum
            statement.setInt(2, det);//date
            statement.setInt(3,product);//ordernum
            statement.setInt(4, qunt);
            statement.setInt(5, price);

            // Execute the INSERT statement
            statement.executeUpdate();

            // Close the statement and connection
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}



