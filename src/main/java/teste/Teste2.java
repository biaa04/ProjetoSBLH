package teste;

import model.Banda;
import model.DaoBanda;

public class Teste2 {
	public static void main(String[]args) throws Exception {
		Banda b = new Banda();
		b.setNome("Kiss");
		b.setGenero("Rock");
		//b.setIdbanda(1L);
		
		DaoBanda db = new DaoBanda();
		b = db.salvar(b);
		System.out.println("Banda"+ b.getNome()+ " salva");
		
	}

}
