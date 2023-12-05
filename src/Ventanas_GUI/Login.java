package Ventanas_GUI;

import javax.lang.model.element.NestingKind;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JButton ingresarButton;
    private JButton cancelarButton;
    private JPasswordField txtPassword;
    private JTextField txtUsuario;
    private JPanel miPanel;

    public Login() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Password = String.valueOf(txtPassword.getPassword());
                if(txtUsuario.getText().equals("Admin") && Password.equals("1234") ) {
                    //Bienvenida
                    dispose();
                    JOptionPane.showMessageDialog(miPanel, "Bienvenido Admin");
                    String[]tipoUsuario = {"Admin"};
                    Menu.main(tipoUsuario);

                } else if (txtUsuario.getText().equals("Usuario") && Password.equals("123456") ) {
                    //si es usuario
                    JOptionPane.showMessageDialog(miPanel, "Bienvenido Usuario");
                }else {
                    //usuario contraseña invalidos
                    JOptionPane.showMessageDialog(miPanel, "Usuario Contraseña invalidos","Login",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        Login vlogin = new Login();
        vlogin.setContentPane(vlogin.miPanel);
        vlogin.setSize(400,300);
        vlogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vlogin.setVisible(true);
    }
}
