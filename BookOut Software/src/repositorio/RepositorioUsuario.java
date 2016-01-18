package repositorio;

import src.Usuario;
import gui.TelaUsuarios;
import java.util.ArrayList;

public class RepositorioUsuario {
        
        // ArrayList para GUI
        private ArrayList<Usuario> lista_usuarios;
        private static RepositorioUsuario instanciaRepositorio;
    
        // trecho original modo texto
	private Usuario[] usuarios;
	private int indice;
	private final static int MAX = 100;
	
    
	public RepositorioUsuario(){
                
                // Construtor para GUI
                this.lista_usuarios = new ArrayList<Usuario>();
                
                // e para texto
		indice = 0;
		usuarios = new Usuario[MAX];	
                
	}
        
        // Pega instância de um form para outro ( não perder dados do array )
        public static RepositorioUsuario pegarInstancia(){
            if(instanciaRepositorio == null){
                instanciaRepositorio = new RepositorioUsuario();
            }
            return instanciaRepositorio;
        }
        
        
        public ArrayList<Usuario> listarUsuarios(){
            return this.lista_usuarios;
        }
        
                      
        public void inserirUsuario(Usuario usuario) throws Exception {
            if (usuario == null) {
                throw new Exception("O usuário não foi instanciado");
            }
        
            if (usuario.getCpf() == null) {
                throw new Exception("Informe o CPF do usuário");
            }
            
            if (usuario.getCpf().trim().equals("")) {
                throw new Exception("Informe o CPF");
            }
            
            if (usuario.getNome() == null) {
                throw new Exception("Informe o nome do usuario");
            }
            
            if (usuario.getNome().trim().equals("")) {
                throw new Exception("Informe o nome do usuario");
            }
            
            if (this.verificaExistencia(usuario) >= 0) {
                throw new Exception("Usuário já cadastrado");
            }
        
            this.lista_usuarios.add(usuario);
        }

        
        public int verificaExistencia(Usuario usuario) {
            int retorno = -1;
            for (int i = 0; i < this.lista_usuarios.size(); i++){
                if (usuario.getCpf().trim().equals(this.lista_usuarios.get(i).getCpf().trim())){
                    retorno = i;
                    break;
                }
            }
        return retorno;
        }
        
        
        ////***** Código original modo texto
	public void inserir(Usuario c){
		usuarios[indice] = c;
		indice++;
                lista_usuarios.add(c);
	}
        
	public Usuario procurarUsuario(String cpf){
		Usuario temp = null;
		for(int i=0; i<indice; i++){
			if(usuarios[i].getCpf().equals(cpf)){
				temp = usuarios[i];
				break;

			}
		}
		
		if(temp == null){
			System.out.println("Usuário não encontrado!");
                        
		}
		return temp;
	}
	
	
	public int removerUsuario(String cpf){
		int flag = 0;
		for(int i=0; i<indice; i++){
			if(usuarios[i].getCpf().equals(cpf)){
				flag = 1;
				usuarios[i] = usuarios[indice-1];
				usuarios[indice-1] = null;
				indice--;
                                this.lista_usuarios.remove(i);
			}
		}
                return flag;
		
	}
	
		public void imprimirUsuarios(){
			for(int i=0; i<indice; i++){
				System.out.println("----------------");
				System.out.println("Usuario " + i);
				System.out.println("Nome: " + usuarios[i].getNome());
				System.out.println("CPF: " + usuarios[i].getCpf());
				System.out.println("Email: " + usuarios[i].getEmail());
				System.out.println("Telefone: " + usuarios[i].getTelefone());
			}
		}

}
