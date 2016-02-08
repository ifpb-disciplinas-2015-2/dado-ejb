package io.github.jass2125.sessionsbeans;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(LancadorDeDado.class)
public class LancadorDeDadoBean implements LancadorDeDado {
	private Random gerador = new Random();
	private static int cont;

	public int lanca() {
		return this.gerador.nextInt(6) + 1;
	}

	@PostConstruct
	public void init() {
		synchronized (LancadorDeDadoBean.class) {
			LancadorDeDadoBean.cont++;
			System.out.println("Criando um lançador...");
		}
	}

	@PreDestroy	
	public void finalize() {
		synchronized (LancadorDeDadoBean.class) {
			LancadorDeDadoBean.cont--;
			System.out.println("Total: " + LancadorDeDadoBean.cont);
		}
	}
}
