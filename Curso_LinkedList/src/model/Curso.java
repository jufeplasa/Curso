package model;

public class Curso {
	

	private Estudiante primerEstudiante;
	private Estudiante ultimoEstudiante;


	public Curso() {
	}
	
	public Estudiante getPrimerEstudiante() {
		return primerEstudiante;
	}



	public void addEstudiante(Estudiante nuevoE) {
		if(primerEstudiante==null) {
			primerEstudiante=nuevoE;
		}
		else {
			Estudiante aux=primerEstudiante;
			while(aux.getSiguiente()!=null) {
				aux=aux.getSiguiente();
			}
			ultimoEstudiante=nuevoE;
			aux.setSiguiente(ultimoEstudiante);
			ultimoEstudiante.setAnterior(aux);
		}
	}

	public void addEstudianteOrdenado(Estudiante nuevoE) {
		if(primerEstudiante==null) {//lista esta vacia
			primerEstudiante=nuevoE;
		}
		else {
			if(Integer.parseInt(primerEstudiante.getCodigo())>=Integer.parseInt(nuevoE.getCodigo())) {// La lista no esta vacia, y el elemento nuevo va de primero
				Estudiante temp=primerEstudiante;
				primerEstudiante=nuevoE;
				nuevoE.setSiguiente(temp);
			}
			else {//el nuevo elemento no va en la cabeza
				Estudiante current=primerEstudiante;
				while(current!=null) {
					if(current.getSiguiente()==null) {//final de la lista
						current.setSiguiente(nuevoE);
					}
					else if(Integer.parseInt(current.getSiguiente().getCodigo())>=Integer.parseInt(nuevoE.getCodigo())) {//el nuevo elemento va en el intermedio o al final de la lista
						nuevoE.setSiguiente(current.getSiguiente());
						current.setSiguiente(nuevoE);
					}
					current=current.getSiguiente();
				}

			}
		}
	}

			public int eliminarEstudiante(String name) {
				Estudiante removed=null;
				int numEstudiantes=0;
				int b=numeroEstudiantes();
				for(int i=0;i<b;i++) {
					if(name.equalsIgnoreCase(primerEstudiante.getNombre())) {
						removed=primerEstudiante;
						primerEstudiante.getSiguiente().setAnterior(null);
						primerEstudiante=primerEstudiante.getSiguiente();
						removed.setSiguiente(null);
						numEstudiantes++;
					}
					else if(name.equalsIgnoreCase(ultimoEstudiante.getNombre()) ){
						removed=ultimoEstudiante;
						ultimoEstudiante.getAnterior().setSiguiente(null);
						ultimoEstudiante=ultimoEstudiante.getAnterior();
						removed.setSiguiente(null);
						numEstudiantes++;
					}
					else  {
						Estudiante prev=primerEstudiante;
						Estudiante current=primerEstudiante.getSiguiente();
						boolean stop=false;
						while(current!=null && !stop) {
							if(current.getNombre().equalsIgnoreCase(name)) {
								removed=current;
								current.getSiguiente().setAnterior(prev);
								prev.setSiguiente(current.getSiguiente());
								removed.setSiguiente(null);
								removed.setAnterior(null);
								stop=true;
								numEstudiantes++;
							}
							else {
								prev=current;
								current=prev.getSiguiente();
							}
						}
					}
				}
				return numEstudiantes;
			}

			public String pintarEstudiantes() {
				Estudiante current = primerEstudiante;
				String message="";
				while(current!=null){
					message+=current.toString();
					current=current.getSiguiente();
				}
				return message;
			}
			public String pintarEstudiantesAtrasAdelante() {
				Estudiante current = ultimoEstudiante;
				String message="";
				while(current!=null){
					message+=current.toString();
					current=current.getAnterior();
				}
				return message;
			}

			public void pintarGeneral() {

			}

			public String pintarEstudiantesRecursivo(Estudiante nuevoEstudiante) {
				Estudiante current = nuevoEstudiante;
				String message="";
				if(current!=null) {
					message+=current.toString();
					if(current.getSiguiente()!=null) {
						message+=pintarEstudiantesRecursivo(current.getSiguiente());
					}
				}

				return message;

			}


			public int numeroEstudiantes() {
				int num=0;
				if(primerEstudiante!=null) {
					Estudiante current=primerEstudiante;
					while(current!=null) {
						num++;
						current=current.getSiguiente();
					}
				}
				return num;
			}
		}
