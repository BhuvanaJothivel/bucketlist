package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TouristPlace;
import service.ListOperations;


@WebServlet(urlPatterns= {"/jspservlet-app-bucketlist/list"})
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<TouristPlace> bucketList = new ArrayList<TouristPlace>();
		
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
		bucketList.add(tp);
		List<TouristPlace> list = bucketList;
		ListOperations lo =new ListOperations();
	
		if(add!=null) {
			System.out.println("calling add equals method");
			request.setAttribute("bucketList", list);
			System.out.println(list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			dispatcher.forward(request, response);
		}
		
		if(view!=null) {
			if(sortbydestination!=null) {
				List<TouristPlace> list1 = lo.sortByDestination(bucketList);
				request.setAttribute("bucketList", list1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
				dispatcher.forward(request, response);
			}

			if(sortbyrank!=null) {
				List<TouristPlace> list2 = lo.sortByRank(bucketList);
				request.setAttribute("bucketList", list2);
				RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
