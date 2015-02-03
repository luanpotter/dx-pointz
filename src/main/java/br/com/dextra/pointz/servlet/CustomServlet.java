package br.com.dextra.pointz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.yawp.servlet.EndpointServlet;

public class CustomServlet extends EndpointServlet {

	private static final long serialVersionUID = 5261454529072551474L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		super.service(req, resp);
	}
}
