import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Formulario extends JFrame {
    private JPanel contentPane;
    private JLabel lblTitulo;
    private JTextField txtNombre;
    private JLabel lblNombre;
    private JButton btnConfirmar;
    private JPasswordField pswContrasenia;
    private JLabel lblContraseña;
    private JCheckBox chkMostrar;
    private JLabel lblGenero;
    private JRadioButton rbtFemenino;
    private JRadioButton rbtMasculino;
    private JRadioButton rbtNoCorresponde;
    private JLabel lblPablo;

    public Formulario(){

        setContentPane(contentPane);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setResizable(false);
        setTitle("Form ingreso");

        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                validar();

            }
        });
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(contentPane, "Acción confirmada", "Confirmación", JOptionPane.INFORMATION_MESSAGE );

            }
        });
        chkMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(chkMostrar.isSelected()){
                    pswContrasenia.setEchoChar((char) 0);
                }else{
                    pswContrasenia.setEchoChar('•');
                }

            }
        });
        pswContrasenia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                validar();
            }
        });
        rbtFemenino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validar();
            }
        });
        rbtMasculino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validar();
            }
        });
        rbtNoCorresponde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validar();
            }
        });
    }

    public void validar(){

        boolean dato1 = txtNombre.getText().matches("^[a-zA-ZáéíóúüñÑ]{3,}+$");
        boolean dato2 = String.copyValueOf(pswContrasenia.getPassword()).matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,16}$");
        boolean dato3 = rbtFemenino.isSelected() || rbtMasculino.isSelected() || rbtNoCorresponde.isSelected();


        //Mayúsculas - Minúculas - Números - Carcateres especiales - 8 a 16 dígitos

        if(dato1 && dato2 && dato3){
            btnConfirmar.setEnabled(true);
        }else{
            btnConfirmar.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        Formulario frame = new Formulario();
    }

}
