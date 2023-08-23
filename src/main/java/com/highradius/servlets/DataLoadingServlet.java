package com.highradius.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

@WebServlet("/DataLoadingServlet")
public class DataLoadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InvoiceDao invoiceDao = new InvoiceDaoImpl();
		ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
		invoiceList = invoiceDao.getInvoices();
		
		Gson gson = new Gson();
		String errorString = "Sorry, no invoice found!";
		String jsonResponse = gson.toJson(errorString);
		
		if(invoiceList.size() > 0)
			jsonResponse = gson.toJson(invoiceList);
			
		response.getWriter().append(jsonResponse);
	}
}