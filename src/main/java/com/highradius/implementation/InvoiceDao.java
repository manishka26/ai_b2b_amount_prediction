package com.highradius.implementation;

import java.util.ArrayList;

import com.highradius.model.Invoice;

public interface InvoiceDao {
	public ArrayList<Invoice> getInvoices();
	
    public boolean insertInvoice(Invoice invoice);

	public boolean deleteInvoice(int deleteSerial);
	
	public boolean editInvoice(int editSerial, String value);
}
