package biblioteca_poo;

import biblioteca_poo.livro.Livro;
import biblioteca_poo.livro.LivroAutoajuda;
import biblioteca_poo.livro.LivroBiografia;
import biblioteca_poo.livro.LivroGuiaGastronomico;
import biblioteca_poo.livro.LivroInfantil;
import biblioteca_poo.livro.LivroTerror;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Livro> livros; 
	
	public Biblioteca() {
		this.livros = new ArrayList<Livro>();
}
	public void adicionarLivro(Livro livro) {
		this.livros.add(livro);
	}
	public void listarLivros() {
		for (Livro livro:livros) {
			System.out.println(livro.infos());
		}
		System.out.println("Total de " + this.livros.size() + " livros listados com sucesso!\n");
	}
	public void excluirLivro(Livro livro) {
		if (this.livros.contains(livro)) {
			this.livros.remove(livro);
		} else {
			System.out.println("Este livro não existe.\n");
		}
	}
	public void excluirLivros() {
		System.out.println(livros.size() + " livros excluídos com sucesso.");
		livros.clear();
	}
	public void gravarLivros() {
		ObjectOutputStream outputStream = null;
		try {
			FileOutputStream arquivo = new FileOutputStream("c:\\temp\\livros.dat");
			outputStream = new ObjectOutputStream(arquivo);
			for(Livro livros:livros) {
				outputStream.writeObject(livros);
			}
		} catch (FileNotFoundException ex) { 
			ex.printStackTrace();
		} catch (IOException ex) { 
			ex.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
					}
			} catch (IOException ex) { 
				ex.printStackTrace();
			}
		}
	}
	public void recuperarLivros() {
		ObjectInputStream inputStream = null;
		try {
			inputStream	= new ObjectInputStream (new FileInputStream ("c:\\temp\\livros.dat"));
			Object obj = null;
			while((obj = inputStream.readObject ()) != null) {
				if (obj instanceof LivroTerror)
					this.livros.add((LivroTerror)obj);
				else if (obj instanceof LivroAutoajuda) 
					this.livros.add((LivroAutoajuda)obj);
				else if (obj instanceof LivroBiografia)
					this.livros.add((LivroBiografia)obj); 
				else if (obj instanceof LivroGuiaGastronomico) 
					this.livros.add((LivroGuiaGastronomico)obj);
				else if (obj instanceof LivroInfantil) 
					this.livros.add((LivroInfantil)obj);
			}
		}catch (EOFException ex) {
			System.out.println ("Fim do arquivo foi encontrado.");
		}catch (ClassNotFoundException ex) { 
			ex.printStackTrace();
		}catch (FileNotFoundException ex) { 
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (inputStream != null ) {
					inputStream.close(); 
					System.out.println("Livros recuperados com sucesso!\n");
				}
			}catch (IOException ex) { 
				ex.printStackTrace();
			}
		}
	}	

	public static void main(String[] args) {
		Biblioteca bib = new Biblioteca();
		
		Livro l1 = new LivroTerror("O cemitério", "Stephen King", false, 213, 8036582, 16); 
		Livro l2 = new LivroGuiaGastronomico("Curitiba Romântica", "Gustavo Guanabara", true, 182, 803611, 10);
		Livro l3 = new LivroAutoajuda("Felicidade: Modos de Usar", "Cortella & Karnal & Pondé", true, 160, 808811, "Autoajuda");
		Livro l4 = new LivroBiografia ("Eu sou Ozzy", "Ozzy Osbourne", false, 416, 298305, "Ozzy Osbourne");
		Livro l5 = new LivroInfantil ("Toda Mafalda", "Quino", false, 444, 298888, true);
		
		bib.adicionarLivro(l1);
		bib.adicionarLivro(l2);
		bib.adicionarLivro(l3);
		bib.adicionarLivro(l4);
		bib.adicionarLivro(l5);
		bib.listarLivros();
		bib.gravarLivros();
		bib.excluirLivro(l2);
		bib.listarLivros();
		bib.excluirLivros();
		bib.listarLivros();
		bib.recuperarLivros();
		bib.listarLivros();
	}
}