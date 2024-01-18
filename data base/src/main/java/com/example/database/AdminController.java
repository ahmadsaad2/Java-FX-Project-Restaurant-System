package com.example.database;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    public TableView tabelorderdetails;
    @FXML

    public TextField storenum;
    @FXML

    public TextField ordernum;

    @FXML

    public TextField customerid;
    @FXML

    public TextField orderdate;
    @FXML
    private TableView<Item> table;
    @FXML
    private TableView<Employee> employeeTable;



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
    private TableColumn<Order, Integer> orderID ;



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
private AnchorPane StoreForm;
    @FXML
    private AnchorPane firstb;
    @FXML
    private AnchorPane emloyeeForm;
    public void homee(ActionEvent event) {

        dash_list.setVisible(true);
        dash_photo.setVisible(true);
        dash_menu.setVisible(true);
        emloyeeForm.setVisible(false);
        StoreForm.setVisible(false);

    }    @FXML

    public void employee(ActionEvent fevent) {

        dash_list.setVisible(true);
        dash_photo.setVisible(true);
        dash_menu.setVisible(false);
        emloyeeForm.setVisible(true);
        StoreForm.setVisible(false);

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

    public void store(ActionEvent event) {

        dash_list.setVisible(true);
        dash_photo.setVisible(true);
        dash_menu.setVisible(false);
        emloyeeForm.setVisible(false);
        StoreForm.setVisible(true);
    }
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
    private TableColumn<OrderDetail, Integer>PRODUCTID;

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
    }    @FXML


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
    private AnchorPane forsign;

    @FXML
    private AnchorPane forlogin;

    public void changeform(ActionEvent event) {
        if (event.getSource() == sign_alreadyhave) {
            sign_form.setVisible(false);
            login_form.setVisible(true);
            forsign.setVisible(false);
            forlogin.setVisible(true);
        } else if (event.getSource() == login_cerateAccount) {
            login_form.setVisible(false);
            sign_form.setVisible(true);
            forsign.setVisible(true);
            forlogin.setVisible(false);

        }
    }
    @FXML
    private TextField idfield;
    @FXML
    private AnchorPane dash_list;
    @FXML
    private AnchorPane dash_photo;



    @FXML
    private ImageView image1;



    @FXML
    private AnchorPane reportform;


    @FXML
    private Button button_close_order;

    @FXML
    private VBox vbox_order;
    @FXML
    private DialogPane add_order_pane1;




    @FXML
    private TextField adminTextField;

    @FXML
    private Button adminButton;

    // Add any other necessary fields and UI elements





    @FXML
    public void loadDataFromSQL3() {
        try {

            // Establish a connection to the SQL database
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url, "c##kareem", "123456");

            // Create a statement to execute SQL queries
            Statement statement = con.createStatement();

            // Execute the SQL query to retrieve the data
            String query = "SELECT EMPLOYEEID, STOREID, NAME, GENDER, PHONE, JOBTITLE, SALARY FROM Employee";
            ResultSet resultSet = statement.executeQuery(query);


            // Set cell value factories for each column
            employeeID.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEmployeeID()).asObject());
            storeID_E.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStoreID()).asObject());
            name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
            gender.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender()));
            phone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhone()));
            jobTitle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobTitle()));
            salary.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getSalary()).asObject());


            ObservableList<Employee> employeeList = FXCollections.observableArrayList();

            // Populate the JavaFX table with data from the result set
            while (resultSet.next()) {
                int employeeID = resultSet.getInt("EMPLOYEEID");
                int storeId = resultSet.getInt("STOREID");
                String name1 = resultSet.getString("NAME");
                String gender = resultSet.getString("GENDER");
                String phone = resultSet.getString("PHONE");
                String jobTitle = resultSet.getString("JOBTITLE");
                double salary = resultSet.getDouble("SALARY");

                Employee employee = new Employee(employeeID, storeId, name1, gender, phone, jobTitle, salary);
                employeeList.add(employee);

            }
            employeeTable.setItems(employeeList);
            employeeTable.refresh();
            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        @FXML
        private void addEmployee(ActionEvent event) {
            try {
                // Retrieve input values from the text fields
                int employeeId = Integer.parseInt(idfield.getText());
                int storeId = Integer.parseInt(storeIdField.getText());
                String name = firstNameField.getText();
                String gender = genderField.getText();
                String phone = phoneField.getText();
                String jobTitle = jobTitleField.getText();
                double salary = Double.parseDouble(salaryField.getText());

                // Insert the new employee into the SQL database
                insertEmployeeIntoSQL(employeeId, storeId, name, gender, phone, jobTitle, salary);

                // Create a new Employee object
                Employee newEmployee = new Employee(employeeId, storeId, name, gender, phone, jobTitle, salary);

                // Add the new employee to the table's data model
                employeeTable.getItems().add(newEmployee);
                employeeTable.refresh();

                // Clear the input fields
                idfield.clear();
                storeIdField.clear();
                firstNameField.clear();
                genderField.clear();
                phoneField.clear();
                jobTitleField.clear();
                salaryField.clear();
            } finally {

            }
        }

    @FXML

        private void insertEmployeeIntoSQL(int employeeId, int storeId, String name, String gender, String phone, String jobTitle, double salary) {
            try {
                // Establish a connection to the SQL database
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##kareem", "123456");

                // Create a prepared statement for the INSERT statement
                String query = "INSERT INTO EMPLOYEE (EMPLOYEEID, STOREID, NAME, GENDER, PHONE, JOBTITLE, SALARY) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, employeeId);
                statement.setInt(2, storeId);
                statement.setString(3, name);
                statement.setString(4, gender);
                statement.setString(5, phone);
                statement.setString(6, jobTitle);
                statement.setDouble(7, salary);

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
        private void deleteEmployee(ActionEvent event) {
            // Get the selected employee from the table
            Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();

            if (selectedEmployee == null) {
                // No employee is selected, handle the error or show a message to the user
                System.out.println("No employee selected.");
                return;
            }

            // Get the ID of the employee to delete
            int employeeId = selectedEmployee.getEmployeeID();

            try {
                // Establish a connection to the SQL database
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##kareem", "123456");

                // Create a prepared statement for the DELETE statement
                String query = "DELETE FROM Employee WHERE EMPLOYEEID = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, employeeId);

                // Execute the DELETE statement
                statement.executeUpdate();

                // Close the statement and connection
                statement.close();
                connection.close();

                // Remove the employee from the table's data model
                employeeTable.getItems().remove(selectedEmployee);

                // Clear the input field
                idfield.clear();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ///////////////// for store tabel
        @FXML
        public void loadFromSQL4() {
            try {
                // Establish a connection to the SQL database
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                Connection connection = DriverManager.getConnection(url, "c##kareem", "123456");

                // Create a statement to execute SQL queries
                Statement statement = connection.createStatement();

                // Execute the SQL query to retrieve the data
                String query = "SELECT STOREID, LOCATION, PHONE, EMAIL FROM STORE";
                ResultSet resultSet = statement.executeQuery(query);
                // Clear existing data in the table
                storeTable.getItems().clear();
                storeTable.refresh();

                storeID.setCellValueFactory(new PropertyValueFactory<>("STOREID"));
                location.setCellValueFactory(new PropertyValueFactory<>("LOCATION"));
                phoneNO.setCellValueFactory(new PropertyValueFactory<>("PHONE"));
                email.setCellValueFactory(new PropertyValueFactory<>("EMAIL"));

                storeID.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getstoreID()).asObject());
                location.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocation()));
                phoneNO.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneNO()));
                email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));


                ObservableList<Store> storeObservableList = FXCollections.observableArrayList();

                // Populate the JavaFX table with data from the result set
                while (resultSet.next()) {
                    int storeIdd1 = resultSet.getInt("STOREID");
                    String location = resultSet.getString("LOCATION");
                    String phoneNO = resultSet.getString("PHONE");
                    String email = resultSet.getString("EMAIL");

                    Store store = new Store(storeIdd1, location, phoneNO, email);
                    storeObservableList.add(store);
                }

                // Set the data in the table view
                storeTable.setItems(storeObservableList);
                storeTable.refresh();
                // Close the result set, statement, and connection
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private void addStore(ActionEvent event) {
            try {
                // Retrieve input values from the text fields
                int storeId = Integer.parseInt(storetxt.getText());
                String location = locationtxt.getText();
                String phone = phonetxt.getText();
                String email = emailtxt.getText();

                // Insert the new store into the SQL database
                insertStoreIntoSQL1(storeId, location, phone, email);

                // Create a new Store object
                Store newStore = new Store(storeId, location, phone, email);

                // Add the new store to the table's data model
                storeTable.getItems().add(newStore);
                storeTable.refresh();

                // Clear the input fields
                storetxt.clear();
                locationtxt.clear();
                phonetxt.clear();
                emailtxt.clear();
            } catch (NumberFormatException e) {
                // Handle parsing errors for storeId
                e.printStackTrace();
            } finally {
                // Optionally, perform any cleanup or additional actions
            }
        }
    @FXML
    private void insertStoreIntoSQL1(int storeId, String location, String phone, String email) {
            try {
                // Establish a connection to the SQL database
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##kareem", "123456");

                // Create a prepared statement for the INSERT statement
                String query = "INSERT INTO STORE (STOREID, LOCATION, PHONE, EMAIL) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, storeId);
                statement.setString(2, location);
                statement.setString(3, phone);
                statement.setString(4, email);

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
        public void deleteStore(ActionEvent event) {
            String storeIdText = storetxt.getText();
            if (storeIdText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a store ID");
                alert.showAndWait();
                return;
            }

            try {
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                Connection connection = DriverManager.getConnection(url, "c##kareem", "123456");

                String query = "DELETE FROM STORE WHERE STOREID = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(storeIdText));

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Store deleted successfully");
                    storetxt.clear();
                    alert.showAndWait();

                    loadFromSQL4();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Store ID not found");
                    alert.showAndWait();
                }

                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadFromSQL4();
        loadDataFromSQL3();
    }

    @FXML
    void print1(ActionEvent event) throws Exception{
        try{

            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url, "c##kareem", "123456");
            con.setAutoCommit(false);
            Statement state = con.createStatement();
            InputStream inputStream = new FileInputStream(new File("Tree_1.jrxml"));
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
}