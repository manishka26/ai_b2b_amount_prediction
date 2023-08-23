package com.highradius.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Invoice invoice = null;
		InvoiceDao invoiceDao = null;
		
		int serialNo = Integer.valueOf(request.getParameter("serialNo"));
		int customerOrderId = Integer.valueOf(request.getParameter("customerOrderId"));
		int companyCode = Integer.valueOf(request.getParameter("companyCode"));
		int customerNumber = Integer.valueOf(request.getParameter("customerNumber"));
		int salesOrg = Integer.valueOf(request.getParameter("salesOrg"));
		int soldToParty = Integer.valueOf(request.getParameter("soldToParty"));
		String distributionChannel = request.getParameter("distributionChannel");
		String division = request.getParameter("division");
		String orderCreationDate = request.getParameter("orderCreationDate");
		String orderCurrency = request.getParameter("orderCurrency");
		String purchaseOrderType = request.getParameter("purchaseOrderType");
		String orderCreationTime = request.getParameter("orderCreationTime");
		String creditControlArea = request.getParameter("creditControlArea");
		String requestedDeliveryDate = request.getParameter("requestedDeliveryDate");
		String creditStatus = request.getParameter("creditStatus");
		float amountInUSD = Float.valueOf(request.getParameter("amountInUSD"));
		float orderAmount = Float.valueOf(request.getParameter("orderAmount"));
		float releasedCreditValue = Float.valueOf(request.getParameter("releasedCreditValue"));
		long uniqueCustId = Long.valueOf(request.getParameter("uniqueCustId"));
		
		if (serialNo <= 0 || customerOrderId <= 0 || companyCode <= 0 || customerNumber <= 0 || salesOrg <= 0 || soldToParty <= 0) {
			response.getWriter().append("Sorry, insufficient data!");
		}
		else {
			invoice = new Invoice(serialNo, customerOrderId, salesOrg, distributionChannel, division, releasedCreditValue, purchaseOrderType, 
					companyCode, orderCreationDate, orderCreationTime, creditControlArea, soldToParty, orderAmount, 
					requestedDeliveryDate, orderCurrency, creditStatus, customerNumber, amountInUSD, uniqueCustId);
			invoiceDao = new InvoiceDaoImpl();

			Gson gson = new Gson();
			String errorString = "Oops! Data Insertion Unsuccessful...";
			String jsonResponse = gson.toJson(errorString);
			
			boolean inserted = invoiceDao.insertInvoice(invoice);
			if(inserted)
				jsonResponse = gson.toJson("Great! Data Insertion Successful...");
				
			response.getWriter().append(jsonResponse);	
		}
	}
}
