package punto1.model;

import punto1.persistencia.Serializacion;
import punto1.persistencia.Configuracion;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestionEnvios {
    public static void main(String[] args) {
        Configuracion config = new Configuracion("src/punto1/resources/config.properties");
        try {
            registrarNuevoEnvio(config);


        } catch (IOException e) {
            System.out.println("Error al registrar el nuevo envío: " + e.getMessage());
        }
    }

    private static void registrarNuevoEnvio(Configuracion config) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese el código del envío: ");
        String codigo = lector.readLine();

        System.out.print("Ingrese la fecha del envío (yyyy-mm-dd): ");
        String fechaEnvio = lector.readLine();

        System.out.print("Ingrese la zona (urbana/rural) [Predeterminada: " + config.getTipoZonaPredeterminada() + "]: ");
        String zona = lector.readLine();



        if (zona.isEmpty()) {
            zona = config.getTipoZonaPredeterminada();
        }

        System.out.print("Ingrese el total del envío: ");
        double total = Double.parseDouble(lector.readLine());

        System.out.print("Ingrese la cédula del cliente: ");
        String cedula = lector.readLine();

        System.out.print("Ingrese el tipo de identificación: ");
        String tipoIdentificacion = lector.readLine();

        System.out.print("Ingrese el número de identificación: ");
        String numeroIdentificacion = lector.readLine();

        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = lector.readLine();

        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = lector.readLine();

        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = lector.readLine();

        System.out.print("Ingrese la zona del cliente: ");
        String zonaCliente = lector.readLine();

        List<Paquete> paquetes = new ArrayList<>();
        String agregarOtroPaquete;

        do {
            System.out.println("Ingrese el código del paquete: ");
            String codigoPaquete = lector.readLine();

            System.out.print("Ingrese el peso del paquete: ");
            double pesoPaquete = Double.parseDouble(lector.readLine());

            paquetes.add(new Paquete(codigoPaquete, pesoPaquete));

            System.out.print("¿Desea agregar otro paquete? (s/n): ");
            agregarOtroPaquete = lector.readLine();
        } while (agregarOtroPaquete.equalsIgnoreCase("s"));

        Envio envio = new Envio(codigo, fechaEnvio, zona, total, nombre + " " + apellido, paquetes);

        Serializacion.guardarEnvioXML(envio, config.getRutaXML(), config.getRutaLog());
        Serializacion.guardarEnvioBinario(envio, config.getRutaBinario(), config.getRutaLog());

        guardarCliente(cedula, tipoIdentificacion, numeroIdentificacion, nombre, apellido, telefono, zonaCliente, envio.getCodigo());
    }

    private static void guardarCliente(String cedula, String tipoIdentificacion,
                                       String numeroIdentificacion, String nombres,
                                       String apellidos, String telefono, String zona,
                                       String codigoEnvio) {
        String registroCliente = String.join("@", cedula, tipoIdentificacion, numeroIdentificacion,
                nombres, apellidos, telefono, zona) + "@" + codigoEnvio;

        try (FileWriter fw = new FileWriter("src/punto1/resources/clientes.txt", true)) {
            fw.write(registroCliente + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
        }
    }
}
