import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class HospitalViewController implements Initializable {

    @FXML
    private ComboBox<String> cbGenero;
    @FXML
    private TextField cbEdad;
    @FXML
    private TextField tfAltura;
    @FXML
    private TextField tfPeso;
    @FXML
    private RadioButton rbGrado1;
    @FXML
    private ToggleGroup nivelActividad;
    @FXML
    private RadioButton rbGrado2;
    @FXML
    private RadioButton rbGrado3;
    @FXML
    private RadioButton rbGrado4;
    @FXML
    private RadioButton rbGrado5;
    @FXML
    private Label lbResultado;
    
    private int genero = 0, edad, estatura, peso, nivelAct;
    private double tmb, total;
    @FXML
    private Label errorGen;
    @FXML
    private Label errorEdad;
    @FXML
    private Label errorEstatura;
    @FXML
    private Label errorPeso;
    @FXML
    private Label errorActividad;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> generos = FXCollections.observableArrayList();
        generos.addAll("Femenino","Masculino");
        this.cbGenero.setValue("");
        this.cbGenero.setItems(generos);
    }    

    @FXML
    private void calcularCalorias(ActionEvent event) {
        if(validarDatos()){
            switch(genero){
                case 1: //Genero femenino
                    tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) - 161; 
                    break;
                case 2: // Genero masculino
                    tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) +5; 
                    break;
            }
            
            switch(nivelAct){
                case 1://Poca actividad
                    total = tmb * 1.2;
                    this.lbResultado.setText(String.valueOf(total + " Calorias"));
                    break;
                case 2: //Ejercicio ligero
                    total = tmb * 1.375;
                    this.lbResultado.setText(String.valueOf(total + " Calorias"));
                    break;
                case 3: //ejercicio moderado
                    total = tmb * 1.55;
                    this.lbResultado.setText(String.valueOf(total + " Calorias"));
                    break;
                case 4: //Deporte regular
                    total = tmb * 1.725;
                    this.lbResultado.setText(String.valueOf(total + " Calorias"));
                    break;
                case 5: //Deportista de elite
                    total = tmb * 1.9;
                    this.lbResultado.setText(String.valueOf(total + " Calorias"));
                    break;
            }
        }
    }
    
    private boolean validarDatos(){
        boolean datosValidos = true;
        this.errorGen.setVisible(false);
        this.errorEdad.setVisible(false);
        this.errorEstatura.setVisible(false);
        this.errorPeso.setVisible(false);
        this.errorActividad.setVisible(false);
        try{
            this.edad = Integer.parseInt(this.cbEdad.getText());
            this.estatura = Integer.parseInt(this.tfAltura.getText());
            this.peso = Integer.parseInt(this.tfPeso.getText());
            if(this.cbGenero.getValue().equals("Femenino")){
                genero = 1;
            }else if(this.cbGenero.getValue().equals("Masculino")){
                genero = 2;
            }
            
            if(this.rbGrado1.isSelected()){
                nivelAct = 1;
            }else if(this.rbGrado2.isSelected()){
                nivelAct = 2;
            }else if(this.rbGrado3.isSelected()){
                nivelAct = 3;
            }else if(this.rbGrado4.isSelected()){
                nivelAct = 4;
            }else if(this.rbGrado5.isSelected()){
                nivelAct = 5;
            }
            
            if(genero == 0){
                this.errorGen.setVisible(true);
                datosValidos = false;
            }
            if(edad < 0 || edad > 120){
                this.errorEdad.setVisible(true);
                datosValidos = false;
            }
            if(this.estatura < 20 || this.estatura > 250){
                this.errorEstatura.setVisible(true);
                datosValidos = false;
            }
            if(this.peso < 0.25 || this.peso > 600){
                this.errorPeso.setVisible(true);
                datosValidos = false;
            }
            if(rbGrado1.isSelected() == false && rbGrado2.isSelected() == false && rbGrado3.isSelected() == false && rbGrado4.isSelected() == false && rbGrado5.isSelected() == false){
                this.errorActividad.setVisible(true);
                datosValidos = false;
            }
            System.out.println(datosValidos);
        }catch(NumberFormatException ex){
            Alert alertEmptyInfo = new Alert(Alert.AlertType.WARNING);
            alertEmptyInfo.setTitle("Advertencia");
            alertEmptyInfo.setHeaderText("");
            alertEmptyInfo.setContentText("Ingrese unicamente números");
            alertEmptyInfo.showAndWait();
        }
        return datosValidos;
    }
    
}
