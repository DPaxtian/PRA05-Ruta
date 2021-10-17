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
    
    private int edad, estatura, peso;
    private String genero;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> generos = FXCollections.observableArrayList();
        generos.addAll("Femenino","Masculino");
        this.cbGenero.setItems(generos);
    }    

    @FXML
    private void calcularCalorias(ActionEvent event) {
        validarDatos();
    }
    
    private void validarDatos(){
        try{
            this.edad = Integer.parseInt(this.cbEdad.getText());
            this.estatura = Integer.parseInt(this.tfAltura.getText());
            this.peso = Integer.parseInt(this.tfPeso.getText());
            
            if(edad < 0 || edad > 120){
                System.out.println("Valores de edad permitidos entre 0 y 120");
            }
            if(this.estatura < 20 || this.estatura > 250){
                System.out.println("Error en la estatura");
            }
            if(this.peso < 0.25 || this.peso > 600){
                System.out.println("error en el peso");
            }
            if(rbGrado1.isSelected() == false && rbGrado2.isSelected() == false && rbGrado3.isSelected() == false && rbGrado4.isSelected() == false && rbGrado5.isSelected() == false){
                System.out.println("No selecciono ningun nivel de actividad");
            }
        }catch(NumberFormatException ex){
            Alert alertEmptyInfo = new Alert(Alert.AlertType.WARNING);
            alertEmptyInfo.setTitle("Advertencia");
            alertEmptyInfo.setHeaderText("");
            alertEmptyInfo.setContentText("Ingrese unicamente números");
            alertEmptyInfo.showAndWait();
        }
    }
    
}
