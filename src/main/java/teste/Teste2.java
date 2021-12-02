package teste;

import model.Banda;
import model.daoBanda;

public class Teste2 {
	public static void main(String[]args) throws Exception {
		Banda b = new Banda();
		b.setNome("Kiss");
		b.setGenero("Rock");
		//b.setIdbanda(1L);
		
		daoBanda db = new daoBanda();
		b = db.salvar(b);
		System.out.println("Banda"+ b.getNome()+ " salva");
		
	}

}
