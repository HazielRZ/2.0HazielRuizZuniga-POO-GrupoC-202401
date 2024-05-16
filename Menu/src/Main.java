import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestorEmpleados = new GestorEmpleados();
        GestorClientes gestorClientes = new GestorClientes();
        System.out.println("Bienvenido al Sistema del Nuevo Banco");
        System.out.println("Seleccione la sucursal:");
        System.out.println("1. Sucursal Madero");
        System.out.println("2. Sucursal Acueducto");
        int opcionSucursal = scanner.nextInt();

        Sucursal sucursalSeleccionada;
        switch (opcionSucursal) {
            case 1:
                sucursalSeleccionada = new Sucursal("Madero");

                break;
            case 2:
                sucursalSeleccionada = new Sucursal("Acueducto");
                break;
            default:
                System.out.println("Opción no válida. Saliendo del sistema...");
                return;
        }
        // Crear el gerente predeterminado
        Empleado gerentePredeterminado = new Gerente("Nombre Gerente", "Apellidos Gerente", 1980, "Ciudad", "Estado",
                "Dirección", sucursalSeleccionada, 50000, "01/01/2024", "123");

        // Agregar el gerente predeterminado a la lista de empleados
        GestorEmpleados.agregarEmpleado(gerentePredeterminado);

        // Pasar la sucursal y los gestores al menú
        Menu menu = new Menu(sucursalSeleccionada, gestorEmpleados, gestorClientes);
        Menu.sucursalActual = sucursalSeleccionada;
        menu.iniciarSistema();

    }
}
