package io.github.jass2125.servlets;

import io.github.jass2125.sessionsbeans.LancadorDeDado;

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
	private LancadorDeDado lancador;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int resultado = lancador.lanca();
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}
}
