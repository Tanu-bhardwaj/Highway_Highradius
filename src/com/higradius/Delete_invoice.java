package com.higradius;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete_invoice
 */
@WebServlet("/Delete_invoice")
public class Delete_invoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_invoice() {
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
			String deleteOrder = request.getParameter("invoiceNo");
			// 885,884
			String final_values[] = deleteOrder.split(",");
			
			String sql_statement = "DELETE FROM mytable WHERE invoice_id = ?";
			
			for(int i = 0; i < final_values.length; ++i) {
				System.out.println(final_values[i]);
				PreparedStatement st = con.prepareStatement(sql_statement);
				st.setString(1, final_values[i]);
				//System.out.println(st);
				st.executeUpdate();
			}
			con.close();
			
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
