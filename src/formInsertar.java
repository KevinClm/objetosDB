import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formInsertar {
    public JPanel insertar;
    private JTextField nombreTxtField;
    private JTextField caracteristicasTextField;
    private JTextField tipoTxtField;
    private JTextField precioTxtField;
    private JRadioButton borrarRB;
    private JRadioButton conexionDB;
    private JButton insertarBtn;

    public formInsertar() {
        conexionDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionDB miConexion = new ConexionDB();
                miConexion.ConexionLocal("jdbc:mysql://localhost:3307/estudiantes", "root", "");
            }

        });
        borrarRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreTxtField.setText("");
                caracteristicasTextField.setText("");
                precioTxtField.setText("");
                tipoTxtField.setText("");
            }
        });

        insertarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instrumentos instrumento1 = new Instrumentos();
                instrumento1.insertaraDB(nombreTxtField.getText(), tipoTxtField.getText(), Double.parseDouble(precioTxtField.getText()), caracteristicasTextField.getText());
            }
        });
    }
}
