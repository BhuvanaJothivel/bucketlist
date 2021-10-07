package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TouristPlace;
import service.ListOperations;
import service.SetOperations;

@WebServlet(urlPatterns= {"/jspservlet-app-bucketlist/set"})

public class SetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashSet<TouristPlace> set=new HashSet<TouristPlace>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String destination = request.getParameter("travel");
		String rank = request.getParameter("rank");
		String add = request.getParameter("add");
		String view = request.getParameter("view");
		
		String sortbydestination = request.getParameter("sortbydestination");
		String sortbyrank = request.getParameter("sortbyrank");
		
		System.out.println("Entering into list");
		
		TouristPlace tp =new TouristPlace(name,destination,rank);
		set.add(tp);
		HashSet<TouristPlace> tempSet = set;
		SetOperations sp=new SetOperations();
		
		if(add!=null) {
			request.setAttribute("bucketList", tempSet);
			request.setAttribute("message", "user added successfully");
			RequestDispatcher dispatcher = request.getRequestDispatcher("set.jsp");
			dispatcher.forward(request, response);
		}

		if(view!=null) {
			if(sortbydestination!=null) {
				TreeSet<TouristPlace>  sortByDest = sp.sortByDestination(set);
				request.setAttribute("bucketList", sortByDest);
				RequestDispatcher dispatcher = request.getRequestDispatcher("set.jsp");
				dispatcher.forward(request, response);
			}

			if(sortbyrank!=null) {
				TreeSet<TouristPlace> sortByRank = sp.sortByRank(set);
				request.setAttribute("bucketList", sortByRank);
				RequestDispatcher dispatcher = request.getRequestDispatcher("set.jsp");
				dispatcher.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}



}
