package funcoes;

import java.util.Scanner;

public class Main {
	
	public static void menu() {
		System.out.println("1. Informar valores da amostra");
		System.out.println("2. Mostrar valores da amostra");
		System.out.println("3. Ordenar do maior para o menor");
		System.out.println("4. Orfenar do menor para o maior");
		System.out.println("5. Retornar numero de classes (Sturges)");
		System.out.println("6. Retornar numero de classes (Raiz)");
		System.out.println("7. Mostrar tabela de frequências");
		System.out.println("8. Mostrar ");
		System.out.println("Sair");
		
	}
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		Calculadora c = new Calculadora();
		
		System.out.println("Informe a quantidade de itens da amostra: ");
		int qnt = leitor.nextInt();
		
		for(int i = 0; i < qnt; i++) {
			int v = leitor.nextInt();
			c.add(v);
		}
		
		System.out.print(c.getTabelaFrequenciaOrdenada());
		System.out.print("\n\nQuantidade de elementos:  " + c.getSize());
		System.out.print("\n\nMedia:  " + c.getMedia());
		System.out.print("\n\nModa:  " + c.getModa());
		System.out.print("\n\nMediana:  " + c.getMediana());
		System.out.print("\n\nAmostra:\n" + c.getAmostra());
		
		//System.out.print("\n\n\n" + c.getAmostraOrdenada());
	}

}
