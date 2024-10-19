package appMenuYBarraDeHerramientas;

import java.awt.BorderLayout;
import javax.swing.*;

public class AplicacionCombinada {

    public static void main(String[] args) {
        MarcoCombinado marco = new MarcoCombinado();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoCombinado extends JFrame {

    public MarcoCombinado() {
        setTitle("Marco con Barra y Menú");
        setBounds(300, 200, 600, 400); // Medidas actualizadas: x, y, ancho, alto

        // Añadir la lámina que contiene el menú
        LaminaMenu laminaMenu = new LaminaMenu();
        add(laminaMenu, BorderLayout.CENTER);

        // Añadir barra de herramientas, pasando la referencia del panel laminaMenu y del marco principal
        LaminaHerramientas laminaHerramientas = new LaminaHerramientas(laminaMenu, this); 
        add(laminaHerramientas, BorderLayout.WEST);
    }
}
