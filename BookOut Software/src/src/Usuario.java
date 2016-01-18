package src;

public class Usuario extends Pessoa{
	
	private String senha;
	
        public Usuario(){
        super();
        };
        
	public Usuario(String nome, String telefone, String email, String cpf, String rg, String senha){
		super(nome, telefone, email, cpf, rg);
		this.senha =senha;
	}

    
	
	public void setSenha(String senha){
		this.senha = senha;
	}
	public String getSenha(){
		return senha; 
	}
	

}
