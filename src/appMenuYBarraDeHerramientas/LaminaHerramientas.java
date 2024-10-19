package appMenuYBarraDeHerramientas;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LaminaHerramientas extends JPanel {

    private JPanel lamina;
    private JToolBar barraHerramientas;
    private JFrame marcoPrincipal;

    public LaminaHerramientas(JPanel lamina, JFrame marcoPrincipal) {
        
    	this.lamina = lamina;
        this.marcoPrincipal = marcoPrincipal;

        setLayout(new BorderLayout());

        // Crear la barra de herramientas
        barraHerramientas = new JToolBar("Color", JToolBar.VERTICAL);
        barraHerramientas.setFloatable(true);

        // Configuración de acciones
        accionAmarillo = new AccionColor(new ImageIcon(redimensionarImagen("src/appMenuYBarraDeHerramientas/bolaamarilla.png", 30, 30)), Color.YELLOW);
        accionAzul = new AccionColor(new ImageIcon(redimensionarImagen("src/appMenuYBarraDeHerramientas/bolaazul.png", 30, 30)), Color.BLUE);
        accionRojo = new AccionColor(new ImageIcon(redimensionarImagen("src/appMenuYBarraDeHerramientas/bolaroja.png", 30, 30)), Color.RED);
        accionCerrar = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcoPrincipal.dispose();
            }
        };
        
        accionCerrar.putValue(Action.SMALL_ICON, new ImageIcon(redimensionarImagen("src/appMenuYBarraDeHerramientas/Salir.png", 30, 30)));
        accionCerrar.putValue(Action.SHORT_DESCRIPTION, "Cerrar la aplicación");

        // Añadir botones a la barra de herramientas
        barraHerramientas.add(new JButton(accionAzul));
        barraHerramientas.add(new JButton(accionAmarillo));
        barraHerramientas.add(new JButton(accionRojo));
        barraHerramientas.add(new JButton(accionCerrar));

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
            lamina.setBackground(color);
        }
        
    }

    // Método para redimensionar imagen
    private Image redimensionarImagen(String ruta, int ancho, int alto) {
        
    	ImageIcon icono = new ImageIcon(ruta);
        Image imagen = icono.getImage();
        return imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        
    }

    private Action accionAmarillo;
    private Action accionAzul;
    private Action accionRojo;
    private Action accionCerrar;
    
}