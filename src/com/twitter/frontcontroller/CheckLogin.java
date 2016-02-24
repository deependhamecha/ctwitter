package com.twitter.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.twitter.DAO.UpdateDetailsDAO;
import com.twitter.businesslogic.AddDetails;
import com.twitter.businesslogic.DeleteDetails;
import com.twitter.businesslogic.GetDetails;
import com.twitter.businesslogic.UpdateDetails;
import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
       
	GetDetails getDetails = new GetDetails();
	AddDetails addDetails = new AddDetails();
	UpdateDetails updateDetails = new UpdateDetails();
	DeleteDetails deleteDetails = new DeleteDetails();
	
	
    public CheckLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doService(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doService(request,response);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		super.doDelete(req, resp);
		this.doService(req,resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPut(req, resp);
		
		this.doService(req,resp);
	}
	
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	if(request.isRequestedSessionIdValid()){
    		String username = (String) request.getParameter("loginusername");
    		String password = (String) request.getParameter("loginpassword");
    		
    		System.out.println(username);
    		System.out.println(password);
    		
    		Integer accountId = 0;
    		
    		if(username != null && password != null){
    			if((accountId = getDetails.checkCredentials(username, password)) > 0){
    				HttpSession session = request.getSession(true);
    				
    				System.out.println("session : "+session);
    				session.setAttribute("allTweets", getDetails.getAllTweets());
    				session.setAttribute("myAccountDetails", getDetails.getAccountDetails(accountId));
    				
    				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/timeline.jsp");
    				requestDispatcher.forward(request, response);
    			}else{
    				request.setAttribute("message", "<div role=\"alert\" class=\"alert alert-success alert-dismissible\">"
    						+" <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>"
    						+ "Username or Password is incorrect!</div>");
    				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
    				requestDispatcher.forward(request, response);
    				}
    		}else{
    			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
    			}
    		}else{
    		HttpSession session = request.getSession(false);
    		
    		System.out.println(session==null);
    		
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
    	}
	}
}
