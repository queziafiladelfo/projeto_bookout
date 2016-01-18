package src;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;
import repositorio.RepositorioLivro;
import repositorio.RepositorioReserva;
import repositorio.RepositorioUsuario;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Usuario us = new Usuario();
                Livro lv = new Livro();
                Random gerador = new Random();
        
                Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		RepositorioUsuario ru = new RepositorioUsuario();
		RepositorioLivro   rl = new RepositorioLivro();
		RepositorioReserva rr = new RepositorioReserva();
		
		
		int opcao = 0;
		
		System.out.println("Bem-vindo ao Book Out!");
		System.out.println("Seu sistema de aluguel de livros rapido e pratico por apenas R$ 1,00.");
		
		do{
			
		System.out.println("     ");	
		System.out.println("Selecione a opção:"    );
		System.out.println(" 1 - Login"            );
		System.out.println(" 2 - Cadastrar Usuario");
		System.out.println(" 3 - Sair             ");
		System.out.println("   ");
		opcao = ler.nextInt();
		
		
		switch(opcao){
		case 1: 
			System.out.println("Login Book Out");
			System.out.println("CPF: ");
			String cpf1 = ler.next();
			System.out.println("Senha: ");
			String senha1 = ler.next();
			
			if((cpf1.equals("admin")) && (senha1.equals("admin"))){
				System.out.println("   ");
				System.out.println("Administrador, seja bem-vindo!");
				int opcao2 = 0;
				do{
			    System.out.println("     ");
				System.out.println("Informe a opção: ");
				System.out.println(" 1 - Cadastrar um Usuario");
				System.out.println(" 2 - Cadastar Livro"   );
				System.out.println(" 3 - Remover Usuario"  );
				System.out.println(" 4 - Remover Livro"    );
				System.out.println(" 5 - Listar Livro"     );
				System.out.println(" 6 - Listar Usuario"   );
				System.out.println(" 7 - Listar Reservas"  );
				System.out.println(" 8 - Sair"             );
				System.out.println("   ");
				opcao2 = ler.nextInt();
				
				switch (opcao2){
				case 1: 
					System.out.println("Nome usuario: ");
					String nome = ler.next();
					System.out.println("Telefone usuario: ");
					String telefone = ler.next();
					System.out.println("E-mail usuario: ");
					String email = ler.next();
					System.out.println("CPF usuario: ");
					String cpf = ler.next();
					if(ru.procurarUsuario(cpf) != null){
						System.out.println("CPF ja cadastrado!");
						break;
					}
		                        
					System.out.println("RG usuario: ");
					String rg = ler.next();
					System.out.println("Senha usuario: ");
					String senha = ler.next();
					
					Usuario u = new Usuario(nome, telefone, email, cpf, rg, senha);
					ru.inserir(u);
					System.out.println("Usuario cadastrado com sucesso!");
					break;
					
				case 2:
					System.out.println("Titulo do livro: ");
					String titulo = ler.next();
					System.out.println("Autor do livro: ");
					String autor = ler.next();
					System.out.println("ISBN: ");
					String isbn = ler.next();
					if(rl.procurarLivro(isbn) != null){
						System.out.println("ISBN ja cadastrado");
						break;
					}
					System.out.println("Quantidade: ");
					int quantidade = ler.nextInt();
					
					Livro l = new Livro(titulo, autor, isbn, quantidade);
					rl.inserir(l);
					System.out.println("Livro cadastrado com sucesso!");
					break;
					
				case 3: 
					System.out.println("Digite o CPF que deseja remover: ");
					String cpfRemover = ler.next();
					ru.removerUsuario(cpfRemover);
					break;
					
				case 4:
					System.out.println("Informe o ISBN para remover o livro: ");
					String isbnRemover = ler.next();
					rl.removerLivro(isbnRemover);
					break;
					
				case 5:
					System.out.println("Lista de Livros: ");
					rl.imprimirLivros();
					break;
					
				case 6:
					System.out.println("Lista de Usuarios: ");
					ru.imprimirUsuarios();
					break;
					
				case 7:
					System.out.println("Lista de Reservas: ");
					rr.imprimirReservas();
					break;
					
				case 8: 
					System.out.println("Administrador desconectado! ");
					break;
				} 
				}while((opcao2 > 0) && (opcao2 < 8));
				if(opcao2 > 8){
				System.out.println("Opcaoo invalida! "); 
				break;
				}	
			} 
			else {
				if(ru.procurarUsuario(cpf1) != null){
					Usuario userTeste = new Usuario();
					userTeste = ru.procurarUsuario(cpf1);
					if(userTeste.getSenha().equals(senha1)){
						System.out.println(userTeste.getNome()  + ", seja bem-vindo!");
						int opcao3 = 0;
						do{
						System.out.println("     ");	
						System.out.println("Selecione a opção:"    );
						System.out.println(" 1 - Reservar Livro"   );
						System.out.println(" 2 - Devolver Livro"   );
						System.out.println(" 3 - Listar Livro"     );
						System.out.println(" 4 - Sair"             );
						System.out.println("   ");
						opcao3 = ler.nextInt();
						
						switch (opcao3){
						case 1:
							GregorianCalendar gc=new GregorianCalendar();
                                                        gc.add(Calendar.DAY_OF_MONTH, 7); 

							
						    //Numero da reserva; GERADO ALEATORIO DE 1 A 100;
							int numeroReserva = gerador.nextInt(100);
							
							
				                        System.out.println("Digite seu CPF para reserva: ");
							String cpfReserva = ler.next();
							                        
				                               if (ru.procurarUsuario(cpfReserva)== null) {
				                            	   System.out.println("Usuario nao encontrado!");
				                                    break;
				                                } else{
				                                   
				                                   us = ru.procurarUsuario(cpfReserva);
				                               }                         
				                        
				                        System.out.println("Digite o ISBN do livro para reserva: ");			
				                        String ReservaISBN = ler.next();            
				                                                                 
				                            if (rl.procurarLivro(ReservaISBN) == null){   
				                            	System.out.println("Livro inexistente, reserva cancelada!");
				                                break;                 
				                            } 
				                                else{ 
				                                
				                                lv = rl.procurarLivro(ReservaISBN); 
				                                Reserva rs = new Reserva(numeroReserva, us, lv, data);
				                                rr.inserir(rs);
				                                
				                               
				                        		
				                                System.out.println("Data de Reserva  : " + data);
				                                System.out.println("Data de Devolucao: " + gc.getTime());
				                                System.out.println("Livro reservado com sucesso! Reserva: " + numeroReserva);
				                                break;
				                            } 
				                            
						case 2:
							System.out.println("Informe seu CPF para devolver seu livro: ");
							String cpfDevolucao = ler.next();
							System.out.println("Digite o ISBN do livro reservado: ");
							String isbnReservado = ler.next();
							if(rl.procurarLivro(isbnReservado) == null){
								System.out.println("ISBN inexistente");
								break;
							}
							Livro liv = rl.procurarLivro(isbnReservado);
							liv.setQuantidade(liv.getQuantidade() + 1);
							rr.removerReserva(cpfDevolucao);
							
							break;
							
						case 3:
							System.out.println("Lista de Livros: ");
							rl.imprimirLivros();
							break;
						case 4:
							System.out.println("Usuario desconectado! ");
							break;
						}
			
					}while((opcao3 > 0) && (opcao3 < 4));
					if(opcao3 > 4){
					System.out.println("Opção inválida! ");  
					}
					}	
					
					break;
				}
					else{
						System.out.println("Usuario não cadastrado, favor, se cadastrar!");
						break;
					}
					
				}
				
			break;
		case 2: 
			System.out.println("Informe seu nome: ");
			String nome = ler.next();
			System.out.println("Informe seu telefone: ");
			String telefone = ler.next();
			System.out.println("Informe seu e-mail: ");
			String email = ler.next();
			System.out.println("Informe seu CPF: ");
			String cpf = ler.next();
			
                        if(ru.procurarUsuario(cpf) != null){
				System.out.println("CPF já cadastrado!");
				break;
			}
                        
			System.out.println("Informe seu RG: ");
			String rg = ler.next();
			System.out.println("Informe sua senha: ");
			String senha = ler.next();
			
			Usuario u = new Usuario(nome, telefone, email, cpf, rg, senha);
			ru.inserir(u);
			System.out.println("Usuário cadastrado com sucesso!");
			break;
		case 3:
			System.out.println("Obrigado por utilizar o Book Out! ");
			break;
	 
		}
		
		} while((opcao > 0) && (opcao < 3));
		if(opcao > 3){
		System.out.println("Opção inválida! ");  
		}	
	}
}


