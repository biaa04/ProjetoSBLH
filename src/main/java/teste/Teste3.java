package teste;

import java.util.ArrayList;

import model.Banda;
import model.daoBanda;

public class Teste3 {
	public static void main(String[]argas) {
		daoBanda daoteste = new daoBanda();
		
		for(Banda b:daoteste.findAll()) {
			System.out.println();
		}
	}

}
