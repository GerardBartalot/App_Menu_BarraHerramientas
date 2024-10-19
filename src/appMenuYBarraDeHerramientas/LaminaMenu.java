package appMenuYBarraDeHerramientas;

import javax.swing.*;

public class LaminaMenu extends JPanel {

    public LaminaMenu() {
        
    	JMenuBar mibarra = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Edición");
        JMenu herramientas = new JMenu("Herramientas");
        JMenu opciones = new JMenu("Opciones");

        // Opciones dentro de "Archivo"
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardar_como = new JMenuItem("Guardar como");

        // Opciones dentro de "Edición"
        JMenuItem cortar = new JMenuItem("Cortar");
        JMenuItem copiar = new JMenuItem("Copiar");
        JMenuItem pegar = new JMenuItem("Pegar");

        // Añadir separador y submenú "Opciones" a "Edición"
        edicion.add(cortar);
        edicion.add(copiar);
        edicion.add(pegar);
        edicion.addSeparator();
        opciones.add(new JMenuItem("Opción 1"));
        opciones.add(new JMenuItem("Opción 2"));
        edicion.add(opciones);

        // Opciones dentro de "Herramientas"
        JMenuItem generales = new JMenuItem("Generales");
        herramientas.add(generales);

        // Agregar ítems a cada menú
        archivo.add(guardar);
        archivo.add(guardar_como);

        // Agregar menús a la barra de menú
        mibarra.add(archivo);
        mibarra.add(edicion);
        mibarra.add(herramientas);

        add(mibarra);  // Añadir la barra de menú al panel
    }
}
