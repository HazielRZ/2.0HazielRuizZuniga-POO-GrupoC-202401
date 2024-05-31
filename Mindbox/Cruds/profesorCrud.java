package Cruds;

import Modelo.Profesor;

import java.util.ArrayList;
import java.util.Scanner;

public class profesorCrud {
    ArrayList<Profesor> profesores = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public void crearProfesor(){

        System.out.println("ingrese nombre del profesor: ");
        String nombre = sc.nextLine();
        System.out.println("ingrese apellido del profesor: ");
        String apellido = sc.nextLine();
        System.out.println("ingrese fecha de nacimiento del profesor: ");
        String fechaNacimieto = sc.nextLine();
        System.out.println("ingrese ciudad del profesor: ");
        String ciudad = sc.nextLine();
        System.out.println("ingrese estado del profesor: ");
        String estado = sc.nextLine();
        System.out.println("ingrese curp del profesor: ");
        String curp = sc.nextLine();
        System.out.println("ingrese materias que imparte del profesor: ");
        String materiaImpartida = sc.nextLine();

        System.out.println("ingrese sueldo del profesor: ");
        double sueldo = sc.nextDouble();
        System.out.println("ingrese numero de control: ");
        String numeroControl = sc.nextLine();
        Profesor profesor = new Profesor(nombre, apellido, fechaNacimieto, ciudad, estado, curp, materiaImpartida, sueldo, numeroControl);
        profesores.add(profesor);
    }
    public void eliminarProfesor(Profesor profesor){
        profesores.remove(profesor);
    }
    public void modificarProfesor(Profesor profesor){

        System.out.println("ingrese nombre del profesor: ");
        String nombre = sc.nextLine();
        profesor.setNombre(nombre);
        System.out.println("ingrese apellido del profesor: ");
        String apellido = sc.nextLine();
        profesor.setApellidos(apellido);
        System.out.println("ingrese fecha de nacimiento del profesor: ");
        String fechaNacimieto = sc.nextLine();
        profesor.setFechaNacimiento(fechaNacimieto);
        System.out.println("ingrese ciudad del profesor: ");
        String ciudad = sc.nextLine();
        profesor.setCiudad(ciudad);
        System.out.println("ingrese estado del profesor: ");
        String estado = sc.nextLine();
        profesor.setEstado(estado);
        System.out.println("ingrese curp del profesor: ");
        String curp = sc.nextLine();
        profesor.setCurp(curp);
        System.out.println("ingrese materias que imparte del profesor: ");
        String materiaImpartida = sc.nextLine();
        profesor.setMateriaImpartida(materiaImpartida);

        System.out.println("ingrese sueldo del profesor: ");
        double sueldo = sc.nextDouble();
        profesor.setSueldo(sueldo);
        System.out.println("ingrese numero de control: ");
        String numeroControl = sc.nextLine();
        profesor.setNumeroControl(numeroControl);
    }


}