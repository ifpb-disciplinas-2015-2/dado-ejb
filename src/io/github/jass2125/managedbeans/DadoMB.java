package io.github.jass2125.managedbeans;

import io.github.jass2125.sessionsbeans.LancadorDeDadoBean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name = "soma", urlPatterns = {"/soma"})
public class DadoMB extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private LancadorDeDadoBean lancador;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int resultado = lancador.lanca();
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}
}
