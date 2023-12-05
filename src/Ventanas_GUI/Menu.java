package Ventanas_GUI;

import javax.swing.*;

public class Menu extends JFrame {
    private JButton btnAltaDoc;
    private JButton btnAltaPaciente;
    private JButton btnGeneraCita;
    private JButton salirButton;
    private JPanel miPanel;

    public static void main(String[] args) {
        Menu m = new Menu();
        m.setContentPane(m.miPanel);
        m.setSize(400,300);
        m.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        m.setVisible(true);
    }
}
