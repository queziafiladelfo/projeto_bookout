package repositorio;

import src.Reserva;

public class RepositorioReserva {

	private Reserva[] reservas;
	private int indice;
	private final static int MAX = 100;
	
	public RepositorioReserva(){
		indice = 0;
		reservas = new Reserva[MAX];	
	}
	public void inserir(Reserva c){
		reservas[indice] = c;
		indice++;	
	}
	public Reserva procurarReserva(int numero){
		Reserva temp = null;
		for(int i=0; i<indice; i++){
			if(reservas[i].getNumero() == (numero)){
				temp = reservas[i];
				break;
			}
		}
		
		if(temp == null){
			System.out.println("Reserva não encontrada!");
		}
		return temp;
	}
	
	
	public void removerReserva(String cpf){
		for(int i=0; i<indice; i++){
			if(reservas[i].getUsuario().getCpf().equals(cpf)){
				reservas[i] = reservas[indice-1];
				reservas[indice-1] = null;
				indice--;
				
				System.out.println("Devolução com sucesso! Obrigado!");
			}
		}
	}
	
	
		public void imprimirReservas(){
			if(indice >0){
			for(int i=0; i<indice; i++){
				
				System.out.println("----------------");
				System.out.println("Reserva " + i);
				System.out.println("Usuario: " + reservas[i].getUsuario().getCpf());
				System.out.println("Livro: " + reservas[i].getLivro().getTitulo());
				System.out.println("Número: " + reservas[i].getNumero());
				System.out.println("----------------");
			}
			}
			else{
				System.out.println("Não existem reservas ativas! ");
			}
		}
}
