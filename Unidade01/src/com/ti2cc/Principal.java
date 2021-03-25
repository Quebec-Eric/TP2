package com.ti2cc;
import java.util.Scanner;

public class Principal {
	public static Scanner ler = new Scanner(System.in);
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		
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
		
				
		System.out.println("==== Mostrar usuários do sexo masculino === ");
		Usuario[] usuarios = dao.getUsuariosMasculinos();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}

		//Atualizar usuário
		usuario.setSenha("nova senha");
		dao.atualizarUsuario(usuario);

		//Mostrar usuários do sexo masculino
		System.out.println("==== Mostrar usuários === ");
		usuarios = dao.getUsuarios();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		System.out.println("codigo Usuario que ira ser deletado ==");
		int deletar_codigo=ler.nextInt();
		dao.excluirUsuario(deletar_codigo);
		
		//Mostrar usuários
		usuarios = dao.getUsuarios();
		System.out.println("==== Mostrar usuários Atualizado === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		dao.close();
	}
}
