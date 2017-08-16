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
		
		Calculadora c = new Calculadora();
		
		c.add(3);
		c.add(50);
		c.add(6);
		c.add(29);
		c.add(39);
		c.add(87);
		c.add(24);
		c.add(46);
		c.add(16);
		c.add(8);
		c.add(2);
		c.add(73);
		c.add(19);
		c.add(5);
		c.add(37);
		c.add(37);
		c.add(37);
		c.add(37);
		c.add(1000);
		
		System.out.print(c.getTabelaFrequenciaOrdenada());
		System.out.print("\n\n\n" + c.getSize());
		System.out.print("\n\n\n" + c.getAmostra());
	}

}
