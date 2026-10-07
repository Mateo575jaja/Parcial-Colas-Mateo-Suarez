import java.util.Queue;
import java.util.Scanner;


public class Metodos {
    

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor tenga en cuenta que se le esta pidiendo un dato numerico");
            sc.next();
        }
        return sc.nextInt();
    }

    public int turno(Queue<ObjInmobiliaria> cola) {
        int turno = 0;
        if (cola.isEmpty()) {
            turno = 1;
        } else {
            turno = cola.size() + 1;
        }
        return turno;
    }
    public Queue<ObjInmobiliaria> Llenarcola(Queue<ObjInmobiliaria> cola, Scanner sc) {

        boolean continuar = true;

        while (continuar) {

            ObjInmobiliaria o = new ObjInmobiliaria();

            o.setTurno(turno(cola));

            System.out.println("\n--- REGISTRAR CLIENTE ---");

            System.out.print("Ingrese nombre: ");
            o.setNombre(sc.nextLine());

            System.out.print("Ingrese documento de identidad: ");
            o.setId(sc.nextLine());

            System.out.print("Ingrese propiedad: ");
            o.setPropiedad(sc.nextLine());

            System.out.print("Ingrese hora de cita: ");
            o.setHora(ValidarEntero(sc));


            o.setEstado(1);

            cola.offer(o);

            System.out.println("\nCliente registrado correctamente.");
            System.out.println("Turno asignado: " + o.getTurno());

            System.out.println("\n¿Desea agregar otro cliente?");
            System.out.println("1. Si");
            System.out.println("2. No");
            int opt = sc.nextInt();
            sc.nextLine();

            if (opt == 2) {
                continuar = false;
            }
        }

        return cola;

    }
    public void MostrarCliente(ObjInmobiliaria o) {

        System.out.println("-------------------------");
        System.out.println("Nombre: " + o.getNombre());
        System.out.println("Id: " + o.getId());
        System.out.println("Turno: " + o.getTurno());
        System.out.println("Hora: " + o.getHora());
        System.out.println("Propiedad: " + o.getPropiedad());
        System.out.println("Estado: " + o.getEstado());
        System.out.println("Turno: " + o.getTurno());

        if (o.getEstado() == 1) {
            System.out.println("Estado: Pendiente");
        } else if (o.getEstado() == 2) {
            System.out.println("Estado: Atendido");
        } else if (o.getEstado() == 3) {
            System.out.println("Estado: Cancelado");
        }
    }
    public void CancelarTurno(Queue<ObjInmobiliaria> cola, Scanner sc) {

        System.out.println("\n--- CANCELAR TURNO ---");

        System.out.print("Ingrese Identificacion: ");
        String Id = sc.nextLine();

        boolean encontrado = false;

        for (ObjInmobiliaria o : cola) {

            if (o.getId().equals(Id)
                    && o.getEstado() == 1) {

                o.setEstado(3);

                System.out.println("Turno cancelado correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado o ya no está pendiente.");
        }
    }
    public Queue<ObjInmobiliaria> modificarHora(Queue<ObjInmobiliaria> cola, Scanner sc) {
        System.out.println("Ingrese el Id del cliente al que desea modificar la hora de la cita:");
        String id = sc.nextLine();

        boolean encontrado = false;
        for (ObjInmobiliaria o : cola) {
            if (o.getId().equals(id)) {
                System.out.println("Ingrese la nueva hora de la cita:");
                o.setHora(ValidarEntero(sc));
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }

        return cola;
    }
    public void ConsultarEsperando(Queue<ObjInmobiliaria> cola) {

        boolean encontrado = false;

        System.out.println("\n--- CLIENTES ESPERANDO ---");

        for (ObjInmobiliaria o : cola) {

            if (o.getEstado() == 1) {

                MostrarCliente(o);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay clientes esperando.");
        }
    }
    public void MarcarAtendido(Queue<ObjInmobiliaria> cola, Scanner sc) {

        System.out.println("\n--- MARCAR CLIENTE COMO ATENDIDO ---");

        System.out.print("Ingrese ID: ");
        String Id = sc.nextLine();

        boolean encontrado = false;

        for (ObjInmobiliaria o : cola) {

            if (o.getId().equals(Id)
                    && o.getEstado() == 1) {

                o.setEstado(2);
                encontrado = true;

                System.out.println("Cliente marcado como atendido.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado o ya no está pendiente.");
        }
    }
    public Queue<ObjInmobiliaria> ModificarCliente(Queue<ObjInmobiliaria> cola, Scanner sc) {
        System.out.println("Ingrese el Id del cliente al que desea modificar:");
        String id = sc.nextLine();

        boolean encontrado = false;
        for (ObjInmobiliaria o : cola) {
            if (o.getId().equals(id)) {
                System.out.println("Ingrese el id del nuevo cliente:");
                o.setId(sc.nextLine());
                System.out.println("Ingrese el nombre del nuevo cliente:");
                o.setNombre(sc.nextLine());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }

        return cola;
    }
}
