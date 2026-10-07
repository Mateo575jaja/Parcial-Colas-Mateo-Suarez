import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<ObjInmobiliaria> cola = new LinkedList<>();

        Metodos m = new Metodos();

        int opcion = 0;

 
        while (opcion != 10) {

            System.out.println("\n==============================");
            System.out.println(" SISTEMA DE ATENCION AL CLIENTE");
            System.out.println("==============================");
            System.out.println("1. Registrar agregar cliente");
            System.out.println("2. Mostrar todos los clientes");
            System.out.println("3. Mostrar lista de espera");
            System.out.println("4. Cambiar hora de cita");
            System.out.println("5. Atender cliente");
            System.out.println("6. Cancelar turno");
            System.out.println("7. Modificar cliente");
            System.out.println("8. Salir");
            System.out.println("==============================");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    m.Llenarcola(cola, sc);
                    break;

                case 2:
                    if (cola.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        for (ObjInmobiliaria cliente : cola) {
                            m.MostrarCliente(cliente);
                        }
                    }
                    break;

                case 3:
                    m.ConsultarEsperando(cola);
                    break;

                case 4:
                    m.modificarHora(cola, sc);
                    break;

                case 5:
                    m.MarcarAtendido(cola, sc);
                    break;

                case 6:
                    m.CancelarTurno(cola, sc);
                    break;
        
                case 7:
                    m.ModificarCliente(cola, sc);
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}

