package app;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.dao.OperadorDao;
import model.dao.ProfessorDao;
import model.entities.Aluno;
import model.entities.Operador;
import model.entities.Professor;
import model.entities.enums.Modalidade;


public class Programa4 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		  
		  metodo1();
		  System.out.println("\nFim do programa!");

	}
	
	public static void metodo1() {
		
		AlunoDao alunoDao = DaoFactory.createAlunoDao();
		ProfessorDao professorDao = DaoFactory.createProfessorDao();
		OperadorDao operadorDao = DaoFactory.createOperadorDao();
		
		
		
		  Aluno newAluno = new Aluno();
		  Professor newProfessor = new Professor();
		  Operador newOperador = new Operador();
		  
		    
		  List<Aluno> list = new ArrayList<>();
		  List<Professor> list1 = new ArrayList<>();
		  List<Operador> list2 = new ArrayList<>();
		 
		  
		//try {
		Scanner sc = new Scanner(System.in);
		System.out.println("SISTEMA DE CADASTRO PARA ACADEMIA:\nMENU PRINCIPAL\n");
		  System.out.println("Entre com a opção:"); 
		  System.out.println("\t1- OPERADOR\n\t2- ALUNO\n\t3- PROFESSOR\n\t4- SAIR");
		  Integer resposta = sc.nextInt();
		  
			
		  if(resposta.equals(1)) { // OPERADOR
			  System.out.println("MENU OPERADOR\n\tEntre com a opção:\n\t1- Cadrastar\n\t2- "
			  		+ "Listar TODOS\n\t3- Editar\n\t4- "
			  		+ "Excluir\n\t5- Voltar");
			  Integer resposta_op = sc.nextInt();
			  if(resposta_op.equals(1)) { //CADRASTAR
				  sc = new Scanner(System.in);
				  
				  

				  System.out.print("CPF: ");
				  String cpf = sc.nextLine();
				  
				  
				  
				  System.out.print("Senha: ");
				  String senha = sc.nextLine();
				  
				  	 
					 			 
				
				  newOperador = new Operador(null,cpf, senha);
				  		  
				  operadorDao.insert(newOperador);
				  System.out.println("Cadrastado realizado com sucesso! Seu ID é: " +newOperador.getId());
				   
				  
			  }
			  else if(resposta_op.equals(2)) { //Listar TODOS
				  newOperador = new Operador();
				  list2 = operadorDao.finAll(); 
				  for (Operador obj : list2) { System.out.println(obj); }
				  
			  }
			  
			  else if(resposta_op.equals(3)) { //Editar
				  sc = new Scanner(System.in);
				  System.out.println("Digite um ID: ");
				  Integer id_edit = sc.nextInt();
				  
				
				  
				  System.out.println("Novo CPF: ");
				  String cpf_novo = sc.next();

				  

				  System.out.print("Nova Senha: ");
				  String senha_novo = sc.nextLine();				  
				  
				  
				  newOperador = operadorDao.findById(id_edit); 
				  	
				  	newOperador.setCpf(cpf_novo);
					newOperador.setSenha(senha_novo);
					operadorDao.update(newOperador); 
					System.out.println("Atualizado!");
			  }
			  
			  else if(resposta_op.equals(4)) { //Excluir
				  System.out.println("Digite o ID para deletar: "); 
					int id_excluir = sc.nextInt();
					operadorDao.deleteById(id_excluir); 
					System.out.println("Deletado com sucesso!");
			  }
			  
			  else if(resposta_op.equals(5)) {
				  metodo1();
			  }
		  }
			 
		  
		  if(resposta.equals(2)) { // ALUNO
			  System.out.println("MENU ALUNO\n\tEntre com a opção:\n\t1- Cadrastar\n\t2- "
			  		+ "Listar TODOS\n\t4- Editar\n\t5- "
			  		+ "Excluir\n\t6- Voltar");
			  Integer resposta_aluno = sc.nextInt();
			  if(resposta_aluno.equals(1)) { //CADRASTAR
				  sc = new Scanner(System.in);
				  
				  System.out.print("Nome");
				  String nome = sc.nextLine();

				  System.out.print("CPF: ");
				  String cpf = sc.nextLine();
				  
				  System.out.print("Modalidade: ");
				  Modalidade modalidade = Modalidade.valueOf(sc.next());
				  
				  System.out.print("Telefone: ");
				  String telefone = sc.nextLine();
				  
				  	 
					 			 
				
				  newAluno = new Aluno(null, nome , cpf, modalidade, telefone);
				  		  
				  alunoDao.insert(newAluno);
				  System.out.println("Cadrastado realizado com sucesso! Seu ID é: " +newAluno.getId());
				   
				  
			  }
			  else if(resposta_aluno.equals(2)) { //Listar TODOS
				  newAluno = new Aluno();
				  list = alunoDao.finAll(); 
				  for (Aluno obj : list) { System.out.println(obj); }
				  
			  }
			  
			  
			  else if(resposta_aluno.equals(3)) { //Editar
				  sc = new Scanner(System.in);
				  System.out.println("Digite um ID: ");
				  Integer id_edit = sc.nextInt();
				  
				  System.out.println("Novo nome: ");
				  String nome_novo = sc.next();
				  
				  System.out.println("Novo CPF: ");
				  String cpf_novo = sc.next();

				  System.out.println("Nova Modalidade: ");
				  Modalidade modalidade = Modalidade.valueOf(sc.next());

				  System.out.print("Novo Telefone: ");
				  String telefone_novo = sc.nextLine();				  
				  
				  
				  newAluno = alunoDao.findById(id_edit); 
				  	newAluno.setNome(nome_novo);
				  	newAluno.setCpf(cpf_novo);
					newAluno.setModalidade(modalidade);
					newAluno.setTelefone(telefone_novo);
					alunoDao.update(newAluno); 
					System.out.println("Atualizado!");
			  }
			  
			  else if(resposta_aluno.equals(4)) { //Excluir
				  System.out.println("Digite o ID para deletar: "); 
					int id_excluir = sc.nextInt();
					alunoDao.deleteById(id_excluir); 
					System.out.println("Deletado com sucesso!");
			  }
			  
			  else if(resposta_aluno.equals(5)) {
				  metodo1();
			  }
		  }
		  
		  else if(resposta.equals(3)) { // PROFESSOR
			  System.out.println("MENU PROFESSOR\n\tEntre com a opção:\n\t1- Cadrastar\n\t2- "
				  		+ "Listar TODOS\n\t3- Editar\n\t4- "
				  		+ "Excluir\n\t5- Voltar");
				  Integer resposta_professor = sc.nextInt();
				  if(resposta_professor.equals(1)) { //CADRASTAR
					  sc = new Scanner(System.in);
					  
					  System.out.print("Nome");
					  String nome = sc.nextLine();

					  System.out.print("CPF: ");
					  String cpf = sc.nextLine();
					  
					  System.out.print("Modalidade: ");
					  Modalidade modalidade = Modalidade.valueOf(sc.next());
					  
					  System.out.print("Telefone: ");
					  String telefone = sc.nextLine();
					  
					  	 
						 			 
					
					  newProfessor = new Professor(null, nome , cpf, modalidade, telefone);
					  		  
					  professorDao.insert(newProfessor);
					  System.out.println("Cadrastado realizado com sucesso! Seu ID é: " +newProfessor.getId());
					   
					  
				  }
				  else if(resposta_professor.equals(2)) { //Listar TODOS
					  newProfessor = new Professor();
					  list1 = professorDao.finAll(); 
					  for (Professor obj : list1) { System.out.println(obj); }
					  
				  }
				  
				  
				  else if(resposta_professor.equals(3)) { //Editar
					  sc = new Scanner(System.in);
					  System.out.println("Digite um ID: ");
					  Integer id_edit = sc.nextInt();
					  
					  System.out.println("Novo nome: ");
					  String nome_novo = sc.next();
					  
					  System.out.println("Novo CPF: ");
					  String cpf_novo = sc.next();

					  System.out.println("Nova Modalidade: ");
					  Modalidade modalidade = Modalidade.valueOf(sc.next());

					  System.out.print("Novo Telefone: ");
					  String telefone_novo = sc.nextLine();				  
					  
					  
					  newProfessor = professorDao.findById(id_edit); 
					  	newProfessor.setNome(nome_novo);
					  	newProfessor.setCpf(cpf_novo);
					  	newProfessor.setModalidade(modalidade);
					  	newProfessor.setTelefone(telefone_novo);
					  	professorDao.update(newProfessor); 
						System.out.println("Atualizado!");
				  }
				  
				  else if(resposta_professor.equals(4)) { //Excluir
					  System.out.println("Digite o ID para deletar: "); 
						int id_excluir = sc.nextInt();
						professorDao.deleteById(id_excluir); 
						System.out.println("Deletado com sucesso!");
				  }
				  
				  else if(resposta_professor.equals(5)) {
					  metodo1();
				  }
			  }
		  
		  
		  
		  
		  
		  if(resposta.equals(4)) {
			  System.out.println("Até a proxima!");
		  }
		  		  
		  sc.close();
	}
	public static void metodo3() {
		System.out.println("Entre com a opcão\n\t1- Cadrastar\n\t2- Listar\n\t3- Editar\n\t4- Excluir\n\t5- Voltar");
		
	
	}	
	}