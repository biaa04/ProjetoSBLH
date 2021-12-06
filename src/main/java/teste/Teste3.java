package teste;

import java.util.ArrayList;

import model.Banda;
import model.DaoBanda;

public class Teste3 {
	public static void main(String[]argas) {
		DaoBanda daoteste = new DaoBanda();
		
		for(Banda b:daoteste.findAll()) {
			System.out.println();
		}
	}

}
