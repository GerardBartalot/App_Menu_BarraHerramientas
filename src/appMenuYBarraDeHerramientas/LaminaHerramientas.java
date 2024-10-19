package appMenuYBarraDeHerramientas;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LaminaHerramientas extends JPanel {

    private JPanel lamina; // Panel cuyo color se cambiará
    private JToolBar barraHerramientas;
    private JFrame marcoPrincipal; // Referencia al marco para cerrarlo con la "X"

    public LaminaHerramientas(JPanel lamina, JFrame marcoPrincipal) {
        this.lamina = lamina;  // Se pasa el panel donde se desea cambiar el color
        this.marcoPrincipal = marcoPrincipal;  // Se pasa el marco para poder cerrarlo

        setLayout(new BorderLayout());

        // Crear la barra de herramientas flotante
        barraHerramientas = new JToolBar("Color", JToolBar.VERTICAL);
        barraHerramientas.setFloatable(true); // Permitir que la barra de herramientas se mueva

        // Configuración de Acciones solo con imágenes
        accionAmarillo = new AccionColor(new ImageIcon(redimensionarImagen("src/appMenuYBarraDeHerramientas/bolaamarilla.png", 30, 30)), Color.YELLOW);
        accionAzul = new AccionColor(new ImageIcon(redimensionarImagen("src/appMenuYBarraDeHerramientas/bolaazul.png", 30, 30)), Color.BLUE);
        accionRojo = new AccionColor(new ImageIcon(redimensionarImagen("src/appMenuYBarraDeHerramientas/bolaroja.png", 30, 30)), Color.RED);

        // Acción para la "X" que cierra la ventana
        accionCerrar = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcoPrincipal.dispose();  // Cierra la ventana al hacer clic en la "X"
            }
        };
        accionCerrar.putValue(Action.SMALL_ICON, new ImageIcon(redimensionarImagen("src/appMenuYBarraDeHerramientas/Salir.png", 30, 30)));
        accionCerrar.putValue(Action.SHORT_DESCRIPTION, "Cerrar la aplicación");

        // Añadir botones a la barra de herramientas solo con las imágenes
        barraHerramientas.add(new JButton(accionAzul));
        barraHerramientas.add(new JButton(accionAmarillo));
        barraHerramientas.add(new JButton(accionRojo));
        barraHerramientas.add(new JButton(accionCerrar));  // Botón de cerrar

        // Añadir la barra de herramientas a este panel
        add(barraHerramientas, BorderLayout.WEST);
    }

    private class AccionColor extends AbstractAction {

        public AccionColor(Icon icono, Color colorBoton) {
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color");
            putValue("colorDeFondo", colorBoton);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = (Color) getValue("colorDeFondo");
            lamina.setBackground(color);  // Cambia el fondo del panel recibido
        }
    }

    // Método para redimensionar imagen
    private Image redimensionarImagen(String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon(ruta);
        Image imagen = icono.getImage();
        return imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    }

    // Variables de Acciones
    private Action accionAmarillo;
    private Action accionAzul;
    private Action accionRojo;
    private Action accionCerrar;
}
