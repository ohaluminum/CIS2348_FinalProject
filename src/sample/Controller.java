package sample;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lejing Huang
 * @version 1.0
 * @since 2020-04-28
 */
public class Controller implements Initializable {

    //Manually input assets data
    @FXML private TableView<Asset> tableView;
    @FXML private TableColumn<Asset, String> IDColumn;
    @FXML private TableColumn<Asset, String> NameColumn;
    @FXML private TableColumn<Asset, String> TypeColumn;
    @FXML private TableColumn<Asset, String> LocationColumn;
    @FXML private TableColumn<Asset, String> UsedByColumn;
    @FXML private TableColumn<Asset, String> StateColumn;

    @FXML private ComboBox<String> TypeOption;
    @FXML private ComboBox<String> StateOption;
    @FXML private TextField IDField;
    @FXML private TextField NameField;
    @FXML private TextField LocationField;
    @FXML private TextField UsedByField;
    @FXML private ComboBox<String> SubTypeOption;
    @FXML private TextField batteryCapacityField;
    @FXML private TextField usedPercentageField;
    @FXML private TextField inkCapacityField;
    @FXML private TextField remainingPercentageField;
    @FXML private TextField PriceField;
    @FXML private TextField DiscountField;


    //Create the option choice for comboboxes
    ObservableList<String> TypeOptionList = FXCollections.observableArrayList("Computer", "Printer", "Audio/Video");
    ObservableList<String> StateOptionList = FXCollections.observableArrayList("in use", "in storage", "needs repair");
    ObservableList<String> SubTypeOptionList = FXCollections.observableArrayList("Laptop", "Desktop", "Server");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Create a combobox for users to choose asset type and asset state
        TypeOption.setItems(TypeOptionList);
        StateOption.setItems(StateOptionList);
        SubTypeOption.setItems(SubTypeOptionList);

        //Disable UsedByField
        UsedByField.disableProperty()
                .bind(StateOption.valueProperty().isNotEqualTo("in use"));


        //Disable addButton
        addButton.disableProperty()
                .bind(Bindings.isEmpty(IDField.textProperty())
                        .or(Bindings.isEmpty(NameField.textProperty()))
                        .or(Bindings.isEmpty(LocationField.textProperty()))
                        .or(TypeOption.valueProperty().isNull())
                        .or(StateOption.valueProperty().isNull()));

        //Disable inputFileButton
        inputFileButton.disableProperty()
                .bind(Bindings.isEmpty(InputFileField.textProperty()));

        //Disable outputFileButton
        outputFileButton.disableProperty()
                .bind(Bindings.isEmpty(OutputFileField.textProperty()));

        //Disable deleteButton
        //Disable button when tableview row unselected tutorial: https://stackoverflow.com/questions/28128626/enabling-a-disabled-button-when-tableview-row-selected
        deleteButton.disableProperty()
                .bind(Bindings.isEmpty(tableView.getSelectionModel().getSelectedItems()));

        //Disable maintenanceButton
        //Disable button when tableview row unselected tutorial: https://stackoverflow.com/questions/28128626/enabling-a-disabled-button-when-tableview-row-selected
        maintenanceButton.disableProperty()
                .bind(Bindings.isEmpty(tableView.getSelectionModel().getSelectedItems()));

        //Disable configurationButton
        //Disable button when tableview row unselected tutorial: https://stackoverflow.com/questions/28128626/enabling-a-disabled-button-when-tableview-row-selected
        configurationButton.disableProperty()
                .bind(Bindings.isEmpty(tableView.getSelectionModel().getSelectedItems()));

        //Disable SubTypeOption
        SubTypeOption.disableProperty()
                .bind(TypeOption.valueProperty().isNotEqualTo("Computer"));

        //Disable batteryCapacityField
        batteryCapacityField.disableProperty()
                .bind(TypeOption.valueProperty().isNotEqualTo("Computer"));

        //Disable usedPercentageField
        usedPercentageField.disableProperty()
                .bind(TypeOption.valueProperty().isNotEqualTo("Computer"));

        //Disable inkCapacityField
        inkCapacityField.disableProperty()
                .bind(TypeOption.valueProperty().isNotEqualTo("Printer"));

        //Disable remainingPercentageField
        remainingPercentageField.disableProperty()
                .bind(TypeOption.valueProperty().isNotEqualTo("Printer"));

        //Disable PriceField
        PriceField.disableProperty()
                .bind(TypeOption.valueProperty().isNotEqualTo("Audio/Video"));

        //Disable DiscountField
        DiscountField.disableProperty()
                .bind(TypeOption.valueProperty().isNotEqualTo("Audio/Video"));


        //Update the table to allow users to edit data
        //Editing Data in the table tutorial: https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
        tableView.setEditable(true);

        IDColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        IDColumn.setOnEditCommit(new EventHandler<>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Asset, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setID(event.getNewValue());
            }
        });

        NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NameColumn.setOnEditCommit(new EventHandler<>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Asset, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
            }
        });

        TypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TypeColumn.setOnEditCommit(new EventHandler<>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Asset, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setType(event.getNewValue());
            }
        });

        LocationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        LocationColumn.setOnEditCommit(new EventHandler<>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Asset, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setLocation(event.getNewValue());
            }
        });

        UsedByColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        UsedByColumn.setOnEditCommit(new EventHandler<>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Asset, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setUsedBy(event.getNewValue());
            }
        });

        StateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        StateColumn.setOnEditCommit(new EventHandler<>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Asset, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setState(event.getNewValue());
            }
        });
    }

    //Add users input assets data
    @FXML private Button addButton;

    @FXML
    protected void addAsset(ActionEvent event) {
        ObservableList<Asset> manualData = tableView.getItems();

        if (TypeOption.getValue().equals("Computer"))
        {
            if (StateOption.getValue().equals("in use"))
            {
                manualData.add(new Computer(IDField.getText(),
                        NameField.getText(),
                        TypeOption.getValue(),
                        LocationField.getText(),
                        UsedByField.getText(),
                        StateOption.getValue(),
                        SubTypeOption.getValue(),
                        Double.parseDouble(batteryCapacityField.getText()),
                        Double.parseDouble(usedPercentageField.getText())
                ));
            }
            else
            {
                manualData.add(new Computer(IDField.getText(),
                        NameField.getText(),
                        TypeOption.getValue(),
                        LocationField.getText(),
                        "",
                        StateOption.getValue(),
                        SubTypeOption.getValue(),
                        Double.parseDouble(batteryCapacityField.getText()),
                        Double.parseDouble(usedPercentageField.getText())
                ));
            }
        }

        else if (TypeOption.getValue().equals("Printer"))
        {
            if (StateOption.getValue().equals("in use"))
            {
                manualData.add(new Printer(IDField.getText(),
                        NameField.getText(),
                        TypeOption.getValue(),
                        LocationField.getText(),
                        UsedByField.getText(),
                        StateOption.getValue(),
                        Double.parseDouble(inkCapacityField.getText()),
                        Double.parseDouble(remainingPercentageField.getText())
                ));
            }
            else
            {
                manualData.add(new Printer(IDField.getText(),
                        NameField.getText(),
                        TypeOption.getValue(),
                        LocationField.getText(),
                        "",
                        StateOption.getValue(),
                        Double.parseDouble(inkCapacityField.getText()),
                        Double.parseDouble(remainingPercentageField.getText())
                ));
            }
        }

        else
        {
            if (StateOption.getValue().equals("in use"))
            {
                manualData.add(new AudioVideo(IDField.getText(),
                        NameField.getText(),
                        TypeOption.getValue(),
                        LocationField.getText(),
                        UsedByField.getText(),
                        StateOption.getValue(),
                        Double.parseDouble(PriceField.getText()),
                        Double.parseDouble(DiscountField.getText())
                ));
            }
            else
            {
                manualData.add(new AudioVideo(IDField.getText(),
                        NameField.getText(),
                        TypeOption.getValue(),
                        LocationField.getText(),
                        "",
                        StateOption.getValue(),
                        Double.parseDouble(PriceField.getText()),
                        Double.parseDouble(DiscountField.getText())
                ));
            }
        }

        IDField.setText("");
        NameField.setText("");
        LocationField.setText("");
        UsedByField.setText("");
        inkCapacityField.setText("");
        remainingPercentageField.setText("");
        PriceField.setText("");
        DiscountField.setText("");
        batteryCapacityField.setText("");
        usedPercentageField.setText("");
    }

    //Read assets data from CSV file
    //Reading CSV file tutorial: https://attacomsian.com/blog/read-write-csv-files-core-java#1-using-scanner-class
    @FXML private TextField InputFileField;
    @FXML private Button inputFileButton;

    @FXML
    protected void inputFile(ActionEvent event) {
        ObservableList<Asset> inputData = tableView.getItems();

        try
        {
            //CSV file delimiter
            String DELIMITER = ",";

            //Create a reader
            BufferedReader br = new BufferedReader(new FileReader(InputFileField.getText()));

            //Read the file line by line
            String line;
            while ((line = br.readLine()) != null)
            {
                //Convert line into token
                String[] token = line.split(DELIMITER);

                if (token[2].equals("Computer"))
                {
                    //ID Number, Name, Type, Location, Used By, State, SubType
                    inputData.add(new Computer(token[0], token[1], token[2], token[3], token[4], token[5], token[6], Double.parseDouble(token[7]), Double.parseDouble(token[8])));
                }
                else if (token[2].equals("Printer"))
                {
                    //ID Number, Name, Type, Location, Used By, State, inkCapacity, remainingPercentage
                    inputData.add(new Printer(token[0], token[1], token[2], token[3], token[4], token[5], Double.parseDouble(token[6]), Double.parseDouble(token[7])));
                }
                else
                {
                    //ID Number, Name, Type, Location, Used By, State,
                    inputData.add(new AudioVideo(token[0], token[1], token[2], token[3], token[4], token[5], Double.parseDouble(token[6]), Double.parseDouble(token[7])));
                }
            }

            //Close the reader
            br.close();

            InputFileField.setText("");
        }
        catch (IOException ex)
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Save assets to CSV file
    //Writing CSV file tutorial: https://attacomsian.com/blog/read-write-csv-files-core-java#1-using-scanner-class
    @FXML private TextField OutputFileField;
    @FXML private Button outputFileButton;

    @FXML
    protected void outputFile(ActionEvent event) {

        try {
            //Create a list of objects
            ObservableList<Asset> outputData = tableView.getItems();

            //Create a writer
            BufferedWriter writer = new BufferedWriter(new FileWriter(OutputFileField.getText()));

            //Write header record
            writer.write("AssetIDNumber,AssetName,AssetType,AssetLocation,UsedBy,AssetState");
            writer.newLine();

            //Write all records
            //String.join() with examples: https://www.geeksforgeeks.org/java-string-join-examples/
            for (Asset eachAsset : outputData) {
                writer.write(String.join(",", eachAsset.getID(), eachAsset.getName(), eachAsset.getType(), eachAsset.getLocation(), eachAsset.getUsedBy(), eachAsset.getState()));
                writer.newLine();
            }

            //Close the writer
            writer.close();

            OutputFileField.setText("");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    //Delete selected assets
    @FXML private Button deleteButton;

    @FXML protected void deleteAsset(ActionEvent event) {

        if (tableView.getSelectionModel().getSelectedItem().getType().compareTo("Computer") == 0)
        {
            Computer.NUMBER--;
        }
        if (tableView.getSelectionModel().getSelectedItem().getType().compareTo("Printer") == 0)
        {
            Printer.NUMBER--;
        }
        if (tableView.getSelectionModel().getSelectedItem().getType().compareTo("Audio/Video") == 0)
        {
            AudioVideo.NUMBER--;
        }

        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
        tableView.getSelectionModel().clearSelection();
    }

    //Maintanence Plans
    @FXML private Button maintenanceButton;

    @FXML protected void maintain(ActionEvent event) {

        tableView.getSelectionModel().getSelectedItem().MaintenancePlans();
    }

    //IP Configuration
    @FXML private Button configurationButton;

    @FXML protected void configure(ActionEvent event) {

        tableView.getSelectionModel().getSelectedItem().IPConfiguration();
    }

    //View the number of assets per category
    @FXML private Button countButton;
    @FXML private Label totalComputer;
    @FXML private Label totalPrinter;
    @FXML private Label totalAudioVideo;

    @FXML protected void countSubtype(ActionEvent event) {

        totalComputer.setText("Total Computers: " + Computer.NUMBER);
        totalPrinter.setText("Total Printers: " + Printer.NUMBER);
        totalAudioVideo.setText("Total Audio/Video: " + AudioVideo.NUMBER);
    }
}


