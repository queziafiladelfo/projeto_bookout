package repositorio;

import src.Usuario;

public class RepositorioUsuario {
	private Usuario[] usuarios;
	private int indice;
	private final static int MAX = 100;
	
	public RepositorioUsuario(){
		indice = 0;
		usuarios = new Usuario[MAX];	
	}
	public void inserir(Usuario c){
		usuarios[indice] = c;
		indice++;	
	}
	public Usuario procurarUsuario(String cpf){
		Usuario temp = null;
		for(int i=0; i<indice; i++){
			if(usuarios[i].getCpf().equals(cpf)){
				temp = usuarios[i];
				break;
			}
		}
		
		return temp;
	}
	
	
	public void removerUsuario(String cpf){
		int flag = 0;
		for(int i=0; i<indice; i++){
			if(usuarios[i].getCpf().equals(cpf)){
				flag = 1;
				usuarios[i] = usuarios[indice-1];
				usuarios[indice-1] = null;
				indice--;
			}
		}
		if(flag == 1){
			System.out.println("Usuário removido com sucesso!");
		}else{
			System.out.println("Usuário inexistente!");
		}
	}
	
		public void imprimirUsuarios(){
			if(indice > 0){
			for(int i=0; i<indice; i++){
				System.out.println("----------------");
				System.out.println("Usuario " + i);
				System.out.println("Nome: " + usuarios[i].getNome());
				System.out.println("CPF: " + usuarios[i].getCpf());
				System.out.println("RG: " + usuarios[i].getRg());
				System.out.println("Email: " + usuarios[i].getEmail());
				System.out.println("Telefone: " + usuarios[i].getTelefone());
				System.out.println("----------------");
			}
			}
			else{
				System.out.println("Não existem usuários cadastrados! ");
			}
		}

}
