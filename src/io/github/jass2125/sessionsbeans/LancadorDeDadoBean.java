package io.github.jass2125.sessionsbeans;

import java.util.Random;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class LancadorDeDadoBean {
	private Random gerador = new Random();
	
	public int lanca(){
		return this.gerador.nextInt(6) + 1;
	}
}
