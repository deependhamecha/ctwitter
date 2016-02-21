package com.twitter.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.twitter.businesslogic.GetDetails;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
       
	GetDetails getDetails = new GetDetails();
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public CheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	
    	if(session == null){
    		String username = (String) request.getParameter("username");
    		String password = (String) request.getParameter("password");
    		
    		if(username != null && password != null){
    			if(getDetails.checkCredentials(username, password)){
    				session = request.getSession(true);
    				
    				RequestDispatcher requestDispatcher = request.getRequestDispatcher("timeline.html");
    				requestDispatcher.forward(request, response);
    			}else{
    				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
    	    		requestDispatcher.forward(request, response);
    			}
    		}else{
    			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
    			requestDispatcher.forward(request, response);
    		}
    	}else if(!session.isNew()){
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("timeline.html");
    		requestDispatcher.forward(request, response);
    	}else if(session.isNew()){
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("timeline.html");
    		requestDispatcher.forward(request, response);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	

}
