package com.highradius.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;

public class InvoiceDaoImpl implements InvoiceDao {
	Connection connection = null;
	PreparedStatement ps = null;

	public boolean insertInvoice(Invoice invoice) {
		String sql = "INSERT INTO h2h_oap VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			connection = DatabaseConnection.getConnection();

			if (connection == null)
				return false;

			// getting statement from the connection
			ps = connection.prepareStatement(sql);

			// parameters
			ps.setInt(1, invoice.getSerialNo());
			ps.setInt(2, invoice.getCustomerOrderId());
			ps.setInt(3, invoice.getSalesOrg());
			ps.setString(4, invoice.getDistributionChannel());
			ps.setString(5, invoice.getDivision());
			ps.setFloat(6, invoice.getReleasedCreditValue());
			ps.setString(7, invoice.getPurchaseOrderType());
			ps.setInt(8, invoice.getCompanyCode());
			ps.setString(9, invoice.getOrderCreationDate());
			ps.setString(10, invoice.getOrderCreationTime());
			ps.setString(11, invoice.getCreditControlArea());
			ps.setInt(12, invoice.getSoldToParty());
			ps.setFloat(13, invoice.getOrderAmount());
			ps.setString(14, invoice.getRequestedDeliveryDate());
			ps.setString(15, invoice.getOrderCurrency());
			ps.setString(16, invoice.getCreditStatus());
			ps.setInt(17, invoice.getCustomerNumber());
			ps.setFloat(18, invoice.getAmountInUSD());
			ps.setLong(19, invoice.getUniqueCustId());

			int insert = ps.executeUpdate();

			return insert > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Invoice> getInvoices() {
		String sql = "SELECT * FROM h2h_oap";
		ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
		try {
			connection = DatabaseConnection.getConnection();

			if (connection == null)
				return null;

			// getting statement from the connection
			ps = connection.prepareStatement(sql);

			ResultSet resultSet = ps.executeQuery(sql);
			int count = 0;

			// Displaying 5 data(s) due to lack of memory
			while (resultSet.next() && count < 10) {
				invoiceList.add(new Invoice(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getFloat(6), resultSet.getString(7),
						resultSet.getInt(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11),
						resultSet.getInt(12), resultSet.getFloat(13), resultSet.getString(14), resultSet.getString(15),
						resultSet.getString(16), resultSet.getInt(17), resultSet.getFloat(18), resultSet.getLong(19)));
				count++;
			}
			return invoiceList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invoiceList;
	}

	public boolean deleteInvoice(int serialNo) {
		String sql = "DELETE FROM h2h_oap WHERE Sl_no = ?";

		try {
			connection = DatabaseConnection.getConnection();

			if (connection == null)
				return false;
			// getting statement from the connection
			ps = connection.prepareStatement(sql);
			ps.setInt(1, serialNo);
			
			return ps.executeUpdate() > 0 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean editInvoice(int editSerial, String value) {
		String sql = "UPDATE h2h_oap SET DISTRIBUTION_CHANNEL=? WHERE Sl_no=?";

		try {
			connection = DatabaseConnection.getConnection();

			if (connection == null)
				return false;
			// getting statement from the connection
			ps = connection.prepareStatement(sql);
			ps.setString(1, value);
			ps.setInt(2, editSerial);
			
			return ps.executeUpdate() > 0 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
