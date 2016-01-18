package repositorio;

import java.util.ArrayList;
import src.Reserva;
import src.Usuario;
import gui.TelaReserva;

public class RepositorioReserva {

	// ArrayList para GUI
        private ArrayList<Reserva> lista_reservag;
        private static RepositorioReserva instanciaRepositorio;
    
        //*****
	private Reserva[] reservas;
	private int indice;
	private final static int MAX = 100;
	
	public RepositorioReserva(){
            
                // Construtor para GUI
                this.lista_reservag = new ArrayList<Reserva>();
            
		//*****
                indice = 0;
		reservas = new Reserva[MAX];	
	}
        
        
        // Pega instância de um form para outro ( não perder dados do array )
        public static RepositorioReserva pegarInstancia(){
            if(instanciaRepositorio == null){
                instanciaRepositorio = new RepositorioReserva();
            }
            return instanciaRepositorio;
        }
        
        
        public ArrayList<Reserva> listarReserva(){
            return this.lista_reservag;
        }
        
        
    public void inserirReserva(Reserva reserva) throws Exception {
        if (reserva == null) {
                throw new Exception("Sem instância");
            }
        /*
         if (reservag.getNumero() == 0) {
                throw new Exception("Informe o número");
            }        
         */
        this.lista_reservag.add(reserva);
    }
        
        
        
        
        
        //*********
        
	public void inserir(Reserva c){
		reservas[indice] = c;
		indice++;
                lista_reservag.add(c);
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
                                this.lista_reservag.remove(i);
				
				System.out.println("Devolução com sucesso! Obrigado!");
			}
		}
	}
	
	
		public void imprimirReservas(){
			for(int i=0; i<indice; i++){
				System.out.println("----------------");
				System.out.println("Reserva " + i);
				System.out.println("Usuario: " + reservas[i].getUsuario().getCpf());
				System.out.println("Livro: " + reservas[i].getLivro().getTitulo());
				System.out.println("Número: " + reservas[i].getNumero());
			}
		}

}
