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
	
	// Construtor da classe Biblioteca que inicia a lista de objetos da classe Livro.
	public Biblioteca() {
		this.livros = new ArrayList<Livro>();
}
	// Método para adicioná-los na lista 'livros'.
	public void adicionarLivro(Livro livro) {
		this.livros.add(livro);
	}
	// Método que mostra no console o método info (com as descrições) e a quantidade de livros que constam na lista.
	public void listarLivros() {
		for (Livro livro:livros) {
			System.out.println(livro.infos());
		}
		System.out.println("Total de " + this.livros.size() + " livros listados com sucesso!\n");
	}
	// Método que verifica se o livro existe na lista e o remove através do parâmetro. Se o livro não constar na lista, mostra mensagem de erro.
	public void excluirLivro(Livro livro) {
		if (this.livros.contains(livro)) {
			this.livros.remove(livro);
		} else {
			System.out.println("Este livro não existe.\n");
		}
	}
	// Método que armazena a quantidade de livros da lista para mostrar no console quantos foram apagados e apaga todas os itens da lista livros.
	public void excluirLivros() {
		int qtdLivros = livros.size();
		livros.clear();
		System.out.println(qtdLivros + " livros excluídos com sucesso.");
	}
	/* Método para gravar livros no arquivo do diretório especificado.
	 * Se não encontrar o arquivo, mostra mensagem de erro (se necessário).
	 * Busca falhas de input/output, mostra mensagem de erro (se necessário).
	 * Testa se o output é diferente de nulo e, se for, libera o fluxo de saída para ser gravado.
	 * Fecha o fluxo de saída e libera os recursos do sistema associados a ele.
	 * Busca falhas de input/output, mostra mensagem de erro (se necessário).
	 */
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
	/* Lê da stream para o objeto.
	 * Verifica se o objeto Livro(Terror/Autoajuda/Guia/Biografia/Infantil) pertence a classe Livro(Terror/Autoajuda/Guia/Biografia/Infantil).
	 * Insere-o na lista.
	 * Mostra na tela quando chega ao fim do arquivo ou quando não encontra a classe ou arquivo.
	 * Busca falhas de input/output, mostra mensagem de erro se necessário.
	 * Testa se o objeto está apontando para algum stream.
	 * Fecha o stream e libera recursos.
 	 * Busca falhas de input/output, mostra mensagem de erro (se necessário).
	 */
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
		// Cria instância da classe Biblioteca.
		Biblioteca bib = new Biblioteca();
		
		// Criação de instâncias das classes filhas de Livro.
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