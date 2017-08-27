package funcoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.crypto.ExemptionMechanismSpi;

public class Calculadora {
	
	private ArrayList<Integer> intArray = new ArrayList<Integer>();
	private Map<Integer, Integer> frequencias = new HashMap<Integer, Integer>();	
	
	public Calculadora() {
		
	}
	
	public Calculadora(ArrayList<Integer> array) {
		
		for(int i = 0; i < array.size(); i++) {
			int n = array.get(i);
			if(frequencias.containsKey(n)) {
				int atual = frequencias.get(n) + 1;
				frequencias.put(n, atual);
			}else {
				frequencias.put(n, 1);
			}
		}
		
		this.intArray = array;
	}

	public boolean isVazio() {
		return intArray.size() > 0 ? false : true;
	}
	
	public void add(int n) {
		
		if(frequencias.containsKey(n)) {
			int atual = frequencias.get(n) + 1;
			frequencias.put(n, atual);
		}else {
			frequencias.put(n, 1);
		}
		
		
		this.intArray.add(n);
	}
	
	public int getMax() {
		if(!isVazio()) {
			int max = intArray.get(0);
			for(int i = 0; i < intArray.size(); i++) {
				if(intArray.get(i) > max) {
					max = intArray.get(i);
				}
			}
			return max;
		}else {
			return 0;
		}		
	}
	
	public int getMin() {
		if(!isVazio()) {
			int min = intArray.get(0);
			for(int i = 0; i < intArray.size(); i++) {
				if(intArray.get(i) < min) {
					min = intArray.get(i);
				}
			}
			return min;
		}else {
			return 0;
		}		
	}
	
	public int getSize() {
		return this.intArray.size();
	}

	public int getAmplitudeAmostral() {
		return this.getMax() - this.getMin();
	}
	
	public int getNumeroClasseSturges(int n) {
		int k = (int) Math.ceil(1 + (3.3 * Math.log10(n)));
		return k;
	}
	
	public int getNumeroClasseRaiz(int n) {
		return (int) Math.ceil(Math.sqrt(n));
	}
	
	public int getAmplitudeClasse(int n) {
		return (int) Math.ceil(getAmplitudeAmostral() / n);
	}
	
	public int getValor(int n) {
		return this.intArray.get(n);
	}
	
	public double getMedia() {
		double total = 0.0;
		for(int i = 0; i < this.intArray.size(); i++) {
			total += intArray.get(i);
		}
		return total / intArray.size();
	}
	
	public int getModa() {
		SortedSet<Integer> keys = new TreeSet<Integer>(frequencias.keySet());
		
		int valor = 0;
		int fr = 0;
		
		for(Integer key : keys) {
			if(frequencias.get(key) >= fr) {
				fr = frequencias.get(key);
				valor = key;
			}
		}
		
		return valor;
	}
	
	public double getMediana() {
		Collections.sort(intArray);
		if(intArray.size() % 2 == 0) {
			int pos1 = (intArray.size()/2) - 1;
			int pos2 = pos1 + 1;
			return ((double) intArray.get(pos1) + (double) intArray.get(pos2)) / 2.0;
		}else {
			int pos = ((intArray.size() +1 ) / 2) - 1;
			return (double) intArray.get(pos);
		}
	}
	
    public String getTabelaFrequenciaOrdenada() {
		
		SortedSet<Integer> keys = new TreeSet<Integer>(frequencias.keySet());
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n  +-----------------+-------------+");
		sb.append("\n  | Valor dos dados |             |");
		sb.append("\n  | da amostra      | Frequência  |");
		sb.append("\n  +-----------------+-------------+");
		
		for(Integer key : keys) {
			String espacos1 = "";
			String espacos2 = "";
			if(key >= 0 && key < 10) {
				espacos1 = "               ";
			}
			if(key >= 10 && key < 100) {
				espacos1 = "              ";
			}
			if(key >= 100 && key < 1000) {
				espacos1 = "             ";
			}
			if(key >= 1000 && key < 10000) {
				espacos1 = "            ";
			}
			if(frequencias.get(key) >= 0 && frequencias.get(key) < 10 ) {
				espacos2 = "           ";
			}
			if(frequencias.get(key) >= 10 && frequencias.get(key) < 100 ) {
				espacos2 = "          ";
			}
			if(frequencias.get(key) >= 100 && frequencias.get(key) < 1000 ) {
				espacos2 = "         ";
			}
			
			
			sb.append("\n  | ").append(key).append(espacos1).append("| ").append(frequencias.get(key)).append(espacos2).append("|");
		}
		
		sb.append("\n  +-----------------+-------------+ ");
		
		
		return sb.toString();
	}
	
	public String getTabelaFrequencia() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n  +-----------------+-------------+");
		sb.append("\n  | Valor dos dados |             |");
		sb.append("\n  | da amostra      | Frequência  |");
		sb.append("\n  +-----------------+-------------+");
		
		for(Integer key : frequencias.keySet()) {
			String espacos1 = "";
			String espacos2 = "";
			if(key >= 0 && key < 10) {
				espacos1 = "               ";
			}
			if(key >= 10 && key < 100) {
				espacos1 = "              ";
			}
			if(key >= 100 && key < 1000) {
				espacos1 = "             ";
			}
			if(key >= 1000 && key < 10000) {
				espacos1 = "            ";
			}
			if(frequencias.get(key) >= 0 && frequencias.get(key) < 10 ) {
				espacos2 = "           ";
			}
			if(frequencias.get(key) >= 10 && frequencias.get(key) < 100 ) {
				espacos2 = "          ";
			}
			if(frequencias.get(key) >= 100 && frequencias.get(key) < 1000 ) {
				espacos2 = "         ";
			}
			
			
			sb.append("\n  | ").append(key).append(espacos1).append("| ").append(frequencias.get(key)).append(espacos2).append("|");
		}
		
		sb.append("\n  +-----------------+-------------+ ");
		
		intArray.get(100);
		
		
		return sb.toString();
	}
	
	public String getAmostra() {
		
		StringBuilder sb = new StringBuilder();
		int linhas = (int) Math.ceil(getSize()/6.0);
		
		String espaco = "";
		
		sb.append("\n  +-----------------------------------------------+");
		sb.append("\n  |                    AMOSTRA                    |");
		sb.append("\n  +-------+-------+-------+-------+-------+-------+");
		
		for(int i = 0; i < linhas; i++) {
			
			sb.append("\n  | ");
			
			for(int j = 0; j < 6; j++) {
				
				/* DEFININDO ESPAÇOS */
				
				try {
					
					
					for(int c = 0; c <= 4; c++) {
						
						long num1 = (long) Math.pow(10, c);
						long num2 = (long) Math.pow(10, (c + 1));
						int atual = intArray.get(c * 6 + j);
						
						if(atual >= num1 && atual < num2) {
							espaco = "    ";
						}
						
					}
					
					/*for(int c = 0; c <= 7; c++) {
						
						if(intArray.get(i * 6 + j) >= Math.pow(10, c) && intArray.get(i * 6 + j) < Math.pow(10, c + 1)) {
							espaco = "    ";
						}
						
					}*/
					
					if(intArray.get(i * 6 + j) >= 0 && intArray.get(i * 6 + j) < 10) {
						espaco = "    ";
					}
					if(intArray.get(i * 6 + j) >= 10 && intArray.get(i * 6 + j) < 100) {
						espaco = "   ";
					}
					if(intArray.get(i * 6 + j) >= 100 && intArray.get(i * 6 + j) < 1000) {
						espaco = "  ";
					}
					if(intArray.get(i * 6 + j) >= 1000 && intArray.get(i * 6 + j) < 10000) {
						espaco = " ";
					}
					if(intArray.get(i * 6 + j) >= 10000 && intArray.get(i * 6 + j) < 100000) {
						espaco = "";
					}
				}catch(Exception e) {
					//System.out.println(e.getMessage());
				}
				
				
				/* DEFININDO CÉLULAS */
				
				int atual = (i * 6) + j;
				
				if(atual < getSize() - 1) {
					sb.append(intArray.get(atual)).append(espaco).append(" | ");
					
				}
				else if(atual == getSize()) {
					sb.append(intArray.get(atual - 1)).append(espaco).append(" |");					
				}
				else {
					sb.append("       |");
				}			
			}
			
			sb.append("\n  +-------+-------+-------+-------+-------+-------+");
			
			
		}
		
		
		
		return sb.toString();		
	}
	
public String getAmostraOrdenada() {
		
		StringBuilder sb = new StringBuilder();
		int linhas = (int) Math.ceil(getSize()/6.0);
		
		String espaco = "";
		
		sb.append("\n  +-----------------------------------------------+");
		sb.append("\n  |                    AMOSTRA                    |");
		sb.append("\n  +-------+-------+-------+-------+-------+-------+");
		
		for(int i = 0; i < linhas; i++) {
			
			sb.append("\n  | ");
			
			for(int j = 0; j < 6; j++) {
				
				/* DEFININDO ESPAÇOS */
				
				try {
					
					
					/*for(int c = 0; c <= 4; c++) {
						
						long num1 = (long) Math.pow(10, c);
						long num2 = (long) Math.pow(10, (c + 1));
						int atual = intArray.get(c * 6 + j);
						
						if(atual >= num1 && atual < num2) {
							
						}
						
					}
					
					for(int c = 0; c <= 7; c++) {
						
						if(intArray.get(i * 6 + j) >= Math.pow(10, c) && intArray.get(i * 6 + j) < Math.pow(10, c + 1)) {
							espaco = "    ";
						}
						
					}*/
					
					if(intArray.get(i * 6 + j) >= 0 && intArray.get(i * 6 + j) < 10) {
						espaco = "    ";
					}
					if(intArray.get(i * 6 + j) >= 10 && intArray.get(i * 6 + j) < 100) {
						espaco = "   ";
					}
					if(intArray.get(i * 6 + j) >= 100 && intArray.get(i * 6 + j) < 1000) {
						espaco = "  ";
					}
					if(intArray.get(i * 6 + j) >= 1000 && intArray.get(i * 6 + j) < 10000) {
						espaco = " ";
					}
					if(intArray.get(i * 6 + j) >= 10000 && intArray.get(i * 6 + j) < 100000) {
						espaco = "";
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				/* DEFININDO CÉLULAS */
				
				int atual = (i * 6) + j;
				
				if(atual < getSize() - 1) {
					sb.append(intArray.get(atual)).append(espaco).append(" | ");
					
				}
				else if(atual == getSize()) {
					sb.append(intArray.get(atual - 1)).append(espaco).append(" |");					
				}
				else {
					sb.append("       |");
				}			
			}
			
			sb.append("\n  +-------+-------+-------+-------+-------+-------+");
			
			
		}
		
		
		
		return sb.toString();		
	}
	
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		
		
		return sb.toString();
	}
	
	// Implementar H
}
