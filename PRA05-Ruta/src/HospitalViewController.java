import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class HospitalViewController implements Initializable {

    @FXML
    private ComboBox<?> cbGenero;
    @FXML
    private ComboBox<?> cbEdad;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void calcularCalorias(ActionEvent event) {
    }
    
}
