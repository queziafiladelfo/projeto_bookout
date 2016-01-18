package repositorio;

import src.Livro;

public class RepositorioLivro {

	private Livro[] livros;
	private int indice;
	private final static int MAX = 100;
	
	public RepositorioLivro(){
		indice = 0;
		livros = new Livro[MAX];	
	}
	public void inserir(Livro c){
		livros[indice] = c;
		indice++;	
	}
	public Livro procurarLivro(String isbn){
		Livro temp = null;
		for(int i=0; i<indice; i++){
			if(livros[i].getIsbn().equals(isbn)){
				temp = livros[i];
				break;
			}
		}
		
		return temp;
	}
	
	
	public void removerLivro(String isbn){
		int flag = 0;
		
		for(int i=0; i<indice; i++){
			if(livros[i].getIsbn().equals(isbn)){
				flag = 1;
				livros[i] = livros[indice-1];
				livros[indice-1] = null;
				indice--;
			}
		}
		if(flag == 1){
			System.out.println("Livro removido com sucesso!");
		} else{
			System.out.println("Livro inexistente!");
		}

	}
	
		public void imprimirLivros(){
			if(indice > 0){
			for(int i=0; i<indice; i++){
				System.out.println("----------------");
				System.out.println("Livro " + i);
				System.out.println("Titulo: " + livros[i].getTitulo());
				System.out.println("Autor: " + livros[i].getAutor());
				System.out.println("Quantidade: " + livros[i].getQuantidade());
				System.out.println("ISBN: " + livros[i].getIsbn());
				System.out.println("----------------");
			}
			}
			else{
				System.out.println("Não existem livros cadastrados! ");
			}
			
		}
	
}
