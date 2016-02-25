package com.twitter.frontcontroller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.sql.Update;

import com.twitter.businesslogic.AddDetails;
import com.twitter.businesslogic.GetDetails;
import com.twitter.businesslogic.UpdateDetails;
import com.twitter.businesslogic.DeleteDetails;
import com.twitter.model.AccountDetails;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	
	AddDetails addDetails = new AddDetails();
	GetDetails getDetails = new GetDetails();
	UpdateDetails updateDetails = new UpdateDetails();
	DeleteDetails deleteDetails = new DeleteDetails();
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name =  request.getParameter("name");
		String emailaddr =  request.getParameter("emailaddr");
		String username =  request.getParameter("username");
		String password =  request.getParameter("password");
		String status =  request.getParameter("status");
		
		
		AccountDetails accountDetails = null;
		if((accountDetails = getDetails.getAccountDetails(username)) != null){
			request.setAttribute("message", "<div role=\"alert\" class=\"alert alert-success alert-dismissible\">"
					+" <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>"
					+ "<b>Username</b> already exists</div>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
			
		}else if(name != null && emailaddr != null && username != null && password != null && status != null){
			
			accountDetails = new AccountDetails(name,emailaddr,null,status,username,password);
			AccountDetails aD = addDetails.addAccountDetails(accountDetails);
			if(aD != null){
				request.setAttribute("message", "<div role=\"alert\" class=\"alert alert-success alert-dismissible\">"
						+" <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>"
						+ "Registered Successfully</div>");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				
			}else{
				request.setAttribute("message", "<div role=\"alert\" class=\"alert alert-success alert-dismissible\">"
						+" <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>"
						+ "Error Occurred While Registeration. Please try again.</div>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			}
		}else{
			response.sendRedirect("/ctwitter/index.jsp");
		}
		
	}
	
	

}
