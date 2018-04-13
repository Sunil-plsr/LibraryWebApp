package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.User;
import database.UserDB;

public class UserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		HttpSession session = request.getSession();
		String url = "/invalid.jsp";
		
		String action = request.getParameter("action");
		
		if (action.equals(null)) {
            url = "/invalid.jsp";  // default action
        } else if (action.equals("login")) {
        	String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            UserDB obj = new UserDB();
            int flag = obj.loginUser(user);
            
/*
            if (flag == 1 && (type.equals("student") || type.equals("staff") || type.equals("admin"))) {
                session.setAttribute("userEmail", email);
                url = "/main.jsp";
            } else if (flag == 1 && type.equals("student")) {
                //session.setAttribute("theUser", "agent");
                session.setAttribute("userEmail", email);
                url = "/student.jsp";
            } else if (flag == 1 && type.equals("admin")) {
                //session.setAttribute("theUser", "admin");
                session.setAttribute("userEmail", email);
                url = "/admin.jsp";
            } else if (flag == 1 && type.equals("staff") ) {
            		url = "/staff.jsp";
            } */
            
            if(flag == 0) {
            	System.out.println("Login Failed");
                request.setAttribute("msg", "Invalid credentials");
                url = "/invalid.jsp";	
            } else if (flag == 1) {
            	
            		System.out.println("Login Sucessfull");
            		//user.setType(obj.getType(user));
                user.setName(obj.getUser(user));
                user.setType(obj.getType(user));
                switch (user.getType()) {
				case "Admin":
					url = "/admin.jsp";
					break;
				case "Staff":
					url = "/staff.jsp";
					break;
				case "Student":
					url = "/student.jsp";
					break;
				}
                
                request.setAttribute("name", user.getName());	
                request.setAttribute("email", user.getEmail());
                session.setAttribute("name", user.getName());
                session.setAttribute("email", user.getEmail());
            }
            
                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, resp);
        } else {
        		getServletContext().getRequestDispatcher("/index.jsp").forward(request, resp);
        }
		
	}
	
	

}
