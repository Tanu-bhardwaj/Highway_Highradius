package com.higradius;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class Add_invoice
 */
@WebServlet("/Add_invoice")
public class Add_invoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_invoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String DB_URI = "jdbc:mysql://localhost:3306/highradius";
		String USERNAME = "root";
		String PASSWORD = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URI, USERNAME, PASSWORD);
			
			String customerName = request.getParameter("custName");
			String customerNumber = request.getParameter("custNo");
			String invoiceNumber = request.getParameter("invoiceNo");
			String invoiceAmount = request.getParameter("invoiceAmount");
			String dueDate = request.getParameter("due_Date");
			String notes = request.getParameter("Notes");
			
			String sql_statement = "INSERT INTO mytable (name_customer, cust_number, invoice_id, total_open_amount, due_in_date, notes) values (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement st = con.prepareStatement(sql_statement);
			st.setString(1, customerName);
			st.setString(2, customerNumber);
			st.setString(3, invoiceNumber);
			st.setString(4, invoiceAmount);
			st.setString(5,  dueDate);
			st.setString(6, notes);
			//System.out.println(st);
			st.executeUpdate();
			con.close();
			st.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
