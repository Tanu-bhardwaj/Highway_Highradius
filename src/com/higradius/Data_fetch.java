package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class Data_fetch
 */
@WebServlet("/Data_fetch")
public class Data_fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Data_fetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String DB_URI = "jdbc:mysql://localhost:3306/highradius";
		String USERNAME = "root";
		String PASSWORD = "1234";
		try {
			//registering the jdbc driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URI, USERNAME, PASSWORD);
			Statement smt = con.createStatement();
			String query = "SELECT name_customer, cust_number, invoice_id, total_open_amount, due_in_date, clear_date, delay_y, notes from mytable LIMIT 10";
			ResultSet rs = smt.executeQuery(query);
			
			ArrayList<invoice_structure> invoices = new ArrayList<>();
			while(rs.next()) {
				invoice_structure invoice = new invoice_structure();
				invoice.setCustomer_name(rs.getString("name_customer"));
				invoice.setCustomer_number(rs.getString("cust_number"));
				invoice.setInvoice_number(rs.getString("invoice_id"));
				invoice.setInvoice_Amount(rs.getString("total_open_amount"));
				invoice.setDue_date(rs.getString("due_in_date"));
				invoice.setPredicted_Date(rs.getString("clear_date"));
				invoice.setDelay(rs.getString("delay_y"));
				invoice.setNotes(rs.getString("notes"));
				invoices.add(invoice);
			}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			String res = gson.toJson(invoices);
			
			out.print(res);
			System.out.println(res);
			response.setStatus(200);
			out.flush();
			smt.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
