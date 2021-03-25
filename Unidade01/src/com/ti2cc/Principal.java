package com.ti2cc;
import java.util.Scanner;

public class Principal {
	public static Scanner ler = new Scanner(System.in);
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		int pegar =0;
		System.out.println("Lstar =1");
		System.out.println("Inserir=2");
		System.out.println("Excluir==3");
		System.out.println("Atualizar==4");
		System.out.println("Sair==5");
		pegar=ler.nextInt();
		switch(pegar) {
		  case 1:
			  Listar(dao);
		    break;
		  case 2:
			  Inserir(dao);
		    break;
		  case 3:
			  Excluir(dao); 
		    break;
		  case 4:
			  Atualizar(dao);
		    break;
		  default:
		    // code block
		}	
	
		
		dao.close();
	}
	
	public static void Inserir(DAO dao) {
		System.out.println("codigo Usuario ==");
		int codigo_pessoa=ler.nextInt();
		System.out.println("Nome Usuario ==");
		String Nome= ler.nextLine();
		System.out.println("Senha Usuario ==");
		String Senha= ler.nextLine();
		System.out.println("Sexo M ou F ==");
		String sexo= ler.nextLine();
		Usuario usuario = new Usuario(codigo_pessoa,Nome ,Senha ,sexo.charAt(0));
		if(dao.inserirUsuario(usuario) == true) {
			System.out.println("Inserção com sucesso -> " + usuario.toString());
		}
		
	}
	
	public static void Listar(DAO dao) {
		Usuario[] usuarios = dao.getUsuarios();
		System.out.println("==== Mostrar usuários === ");
		usuarios = dao.getUsuarios();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
	  
		
	}
	
	public static void Excluir(DAO dao) {
		
		System.out.println("codigo Usuario que ira ser deletado ==");
		int deletar_codigo=ler.nextInt();
		dao.excluirUsuario(deletar_codigo);
		
	}
	
	
	public static void Atualizar(DAO dao) {
		Usuario usuario = new Usuario();
		System.out.println("Nova Senha ==");
	  String  Senha= ler.nextLine();
		usuario.setSenha(Senha);
		dao.atualizarUsuario(usuario);
		
		Usuario[] usuarios  = dao.getUsuarios();
		System.out.println("==== Mostrar usuários Atualizado === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
				
	}
	
	
}
