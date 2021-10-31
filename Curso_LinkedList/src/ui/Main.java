package ui;

import java.util.Scanner;

import model.Curso;
import model.Estudiante;

public class Main {
	private static Scanner sc;
	private static Curso curso;
	
	public static void main(String [] args) {
		curso= new Curso();
		sc=new Scanner (System.in);
		int opcion=1;
		while (opcion!=8) {
			System.out.println(" Elije una opcion :");
			System.out.println("1: Ingresar un estudiante");
			System.out.println("2: Ingresar un estudiante ordenado");
			System.out.println("3: Eliminar un estudiante y mostrar cuantos han sido eliminados");
			System.out.println("4: Mostrar estudiantes");
			System.out.println("5: Mostrar estudiantes atras hacia delante");
			System.out.println("6: Mostrar estudiantes con proceso recursivo");
			System.out.println("7: Mostrar el numero de estudiantes actuales");
			System.out.println("8: salir");
			opcion=sc.nextInt();
			sc.nextLine();
			
			switch(opcion) {
				case 1:
					System.out.print("Nombre del estudiante: ");
					String name=sc.nextLine();
					System.out.print("Codigo del estudiante: ");
					String code=sc.nextLine();
					curso.addEstudiante(new Estudiante(name,code));
					break;
					
				case 2:
					System.out.print("Nombre del estudiante: ");
					name=sc.nextLine();
					System.out.print("Codigo del estudiante: ");
					code=sc.nextLine();
					curso.addEstudianteOrdenado(new Estudiante(name, code));
					break;
					
				case 3:
					System.out.print("Nombre del estudiante para eliminar: ");
					name=sc.next();
					System.out.println("la cantidad de estudiantes eliminados es:"+curso.eliminarEstudiante(name));
					break;
					
				case 4:
					System.out.println(curso.pintarEstudiantes());
					break;
				case 5:
					System.out.println(curso.pintarEstudiantesAtrasAdelante());
					break;
				case 6:
					System.out.println(curso.pintarEstudiantesRecursivo(curso.getPrimerEstudiante()));
					break;
				case 7:
					System.out.println("el numero de estudiantes es: "+curso.numeroEstudiantes());
					break;
					
			}
				
		}
	}
	

}
