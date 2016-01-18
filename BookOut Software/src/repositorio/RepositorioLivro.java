package repositorio;

import src.Livro;
import gui.TelaLivros;
import java.util.ArrayList;
import src.Usuario;

public class RepositorioLivro {

	// ArrayList para GUI
        private ArrayList<Livro> lista_livros;
        private static RepositorioLivro instanciaRepositorio;

    
    
        private Livro[] livros;
	private int indice;
	private final static int MAX = 100;
	
	public RepositorioLivro(){
            
                // Construtor para GUI
                this.lista_livros = new ArrayList<Livro>();

		indice = 0;
		livros = new Livro[MAX];	
	}
        
        
                // Pega instância de um form para outro ( não perder dados do array )
        public static RepositorioLivro pegarInstancia(){
            if(instanciaRepositorio == null){
                instanciaRepositorio = new RepositorioLivro();
            }
            return instanciaRepositorio;
        }
        
        
        public ArrayList<Livro> listarLivros(){
            return this.lista_livros;
        }
               
        public void inserirLivros(Livro livro) throws Exception {
            if (livro == null) {
                throw new Exception("Sem instância");
            }
        
            if (livro.getIsbn() == null) {
                throw new Exception("Informe o ISBN");
            }
        
            this.lista_livros.add(livro);
        }

        
        public int verificaExistencia(Livro livro) {
            int retorno = -1;
            for (int i = 0; i < this.lista_livros.size(); i++){
                if (livro.getIsbn().trim().equals(this.lista_livros.get(i).getIsbn().trim())){
                    retorno = i;
                    break;
                }
            }
        return retorno;
        }

        
        //******
        
	public void inserir(Livro c){
		livros[indice] = c;
		indice++;
                lista_livros.add(c);
                
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
	
	
	public int removerLivro(String isbn){
		int flag = 0;
		
		for(int i=0; i<indice; i++){
			if(livros[i].getIsbn().equals(isbn)){
				flag = 1;
				livros[i] = livros[indice-1];
				livros[indice-1] = null;
				indice--;
                                this.lista_livros.remove(i);
			}
		}
		return flag;

	}
	
		public void imprimirLivros(){
			for(int i=0; i<indice; i++){
				System.out.println("----------------");
				System.out.println("Livro " + i);
				System.out.println("Titulo: " + livros[i].getTitulo());
				System.out.println("Autor: " + livros[i].getAutor());
				System.out.println("Quantidade: " + livros[i].getQuantidade());
				System.out.println("ISBN: " + livros[i].getIsbn());
			}
		}
	
}
