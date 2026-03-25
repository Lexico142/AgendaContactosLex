import java.util.Scanner;

import controlador.AgendaControlador;
import modelo.AgendaModelo;
import vista.AgendaVista;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AgendaModelo modelo = new AgendaModelo();
        AgendaVista vista = new AgendaVista();
        AgendaControlador controlador = new AgendaControlador(modelo, vista);
        controlador.iniciar();
    }
}