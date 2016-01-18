package src;

import java.util.Date;

public class Reserva {
	
	private Usuario usuario;
	private Livro livro;
	private int numero;
	private Date data; 
	
	public Reserva(int numero, Usuario usuario, Livro livro, Date data) {
		this.usuario = usuario;
		this.livro = livro;
		this.numero = numero;
		livro.setQuantidade(livro.getQuantidade() - 1);
		this.data = data;
	}
	public int getNumero(){
		return numero;
	}
	public void setNumero(int numero){
		this.numero = numero;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public void devolverLivro(Usuario u){
		
	}
	
	public Date getdata() {
		return data;
	}
	public void setdata(Date data) {
		this.data = data;
	}

	

}
