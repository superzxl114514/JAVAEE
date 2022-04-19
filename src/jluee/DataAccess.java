package jluee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ass.Output;
import dao.DataBaseOperator;
import domain.Userdata;
import biz.Userbiz;


import javax.servlet.ServletContext;
/**
 * Servlet implementation class DataAccess
 */
@WebServlet("/DataAccess")
public class DataAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataAccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		request.setCharacterEncoding("UTF-8");	
		response.setCharacterEncoding("UTF-8");
		String op=request.getParameter("op");
		int method=Integer.parseInt(op);
		switch(method) {
		case 0:
			Report(request,response);
			break;
		case 1:
			Register(request,response);
			break;
		case 2:
			Login(request,response);
			break;
		case 3:
			Welcome(request,response);
		}
		}catch (IOException |SQLException e) {
			// TODO Auto-generated catch block
			HttpSession session = request.getSession();
    		session.setAttribute("sharingvar_error", e);
    		response.sendRedirect("error.jsp");
		} 	
		
	}
	public void Register(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{	

			String username=request.getParameter("username");
	        String password=request.getParameter("password");
	        System.out.println(username);
	        Userdata ud = new Userdata();
	        ud.Set_Password(password);
	        ud.Set_Username(username);
	        DataBaseOperator.getInstance().insert(ud);
			response.sendRedirect("/ServletPractice/DataAccess?op=0");
		
			
    }
	public void Report(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Output.outputToClient("register done",response);
	}
	public void Login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	if(username==null) username ="";
    	if(password==null) password ="";
    	Userbiz.login(username, password);
    	if(Userbiz.login(username, password)) {
    		HttpSession session = request.getSession();
    		session.setAttribute("sharingvar_username", username);
    		response.sendRedirect("main.jsp");
    	}
    	else {
    		HttpSession session = request.getSession();
    		session.setAttribute("sharingvar_false", "1");
    		response.sendRedirect("login.jsp");
    		
    	}
	}
	public void Welcome (HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();	
        String un = (String) session.getAttribute("sharingvar_username");    
        Output.outputToClient("欢迎您！"+un, response);
	}
}
