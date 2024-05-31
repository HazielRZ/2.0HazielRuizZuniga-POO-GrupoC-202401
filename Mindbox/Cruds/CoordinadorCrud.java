package Cruds;

import Modelo.Coordinador;

import java.util.ArrayList;
import java.util.Scanner;

public class CoordinadorCrud {
    ArrayList <Coordinador> coordinadores = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public void crearCoordinador(){

        System.out.println("ingrese nombre del coordinador: ");
        String nombre = sc.nextLine();
        System.out.println("ingrese apellido del coodinador: ");
        String apellido = sc.nextLine();
        System.out.println("ingrese fecha de nacimiento del coordinador: ");
        String fechaNacimieto = sc.nextLine();
        System.out.println("ingrese ciudad del coordinador: ");
        String ciudad = sc.nextLine();
        System.out.println("ingrese estado del coordinador: ");
        String estado = sc.nextLine();
        System.out.println("ingrese curp del coordinador: ");
        String curp = sc.nextLine();
        System.out.println("ingrese materias que imparte del coordinador: ");
        String materiaImpartida = sc.nextLine();

        System.out.println("ingrese sueldo del coordinador: ");
        double sueldo = sc.nextDouble();

        Coordinador cordinador = new Coordinador(nombre, apellido, fechaNacimieto, ciudad, estado, curp, materiaImpartida, sueldo);
        coordinadores.add(coordinador);
    }
    public void eliminarCoordinador(Coordinador coordinador){
        coordinadores.remove(coordinador);
    }
    public void modificarCordinador(Coordinador coordinador){

        System.out.println("ingrese nombre del coordinador: ");
        String nombre = sc.nextLine();
        coordinador.setNombre(coordinador);
        System.out.println("ingrese apellido del coodinador: ");
        String apellido = sc.nextLine();
        coordinador.setApellidos(coordinador);
        System.out.println("ingrese fecha de nacimiento del coordinador: ");
        String fechaNacimieto = sc.nextLine();
        coordinador.setFechaNacimiento();
        System.out.println("ingrese ciudad del coordinador: ");
        String ciudad = sc.nextLine();
        coordinador.setCiudad();
        System.out.println("ingrese estado del coordinador: ");
        String estado = sc.nextLine();
        coordinador.setEstado();
        System.out.println("ingrese curp del coordinador: ");
        String curp = sc.nextLine();
        coordinador.setCurp();
        System.out.println("ingrese materias que imparte del coordinador: ");
        String materiaImpartida = sc.nextLine();
        coordinador.setMateriaImpartida();

        System.out.println("ingrese sueldo del coordinador: ");
        double sueldo = sc.nextDouble();
        coordinador.setSueldo();

    }


}

