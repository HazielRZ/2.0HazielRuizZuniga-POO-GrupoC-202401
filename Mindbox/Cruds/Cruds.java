package Cruds;

import Modelo.Alumno;

import java.util.ArrayList;
import java.util.Scanner;

public class Cruds {
    ArrayList <Alumno> alumnos = new ArrayList<>();
   Scanner sc = new Scanner(System.in);

    public void crearAlumno(){

        System.out.println("ingrese nombre del alumno: ");
        String nombre = sc.nextLine();
        System.out.println("ingrese apellido del alumno: ");
        String apellido = sc.nextLine();
        System.out.println("ingrese fecha de nacimiento del alumno: ");
        String fechaNacimieto = sc.nextLine();
        System.out.println("ingrese ciudad del alumno: ");
        String ciudad = sc.nextLine();
        System.out.println("ingrese estado del alumno: ");
        String estado = sc.nextLine();
        System.out.println("ingrese carrera del alumno: ");
        String carrera = sc.nextLine();
        System.out.println("ingrese semestre del alumno: ");
        String semestre = sc.nextLine();

        System.out.println("ingrese grupo del alumno: ");
        String grupo = sc.nextLine();
        Alumno alumno = new Alumno(nombre, apellido, fechaNacimieto, ciudad, estado, carrera, semestre, grupo);
        alumnos.add(alumno);
    }
    public void eliminarAlumno(Alumno alumno){
        alumnos.remove(alumno);
    }
    public void modificarAlumno(Alumno alumno){

        System.out.println("ingrese nombre del alumno: ");
        String nombre = sc.nextLine();
        alumno.setNombre(nombre);
        System.out.println("ingrese apellido del alumno: ");
        String apellido = sc.nextLine();
        alumno.setApellidos(apellido);
        System.out.println("ingrese fecha de nacimiento del alumno: ");
        String fechaNacimieto = sc.nextLine();
        alumno.setFechaNacimiento(fechaNacimieto);
        System.out.println("ingrese ciudad del alumno: ");
        String ciudad = sc.nextLine();
        alumno.setCiudad(ciudad);
        System.out.println("ingrese estado del alumno: ");
        String estado = sc.nextLine();
        alumno.setEstado(estado);


    }


}