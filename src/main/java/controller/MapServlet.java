package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.TouristPlace;
import service.ListOperations;
import service.MapOperations;


@WebServlet(urlPatterns= {"/jspservlet-app-bucketlist/map"})
public class MapServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Map<Integer,TouristPlace> bucketList = new HashMap<Integer,TouristPlace>();
	
	HashMap<Integer,TouristPlace> hash = new HashMap<Integer,TouristPlace>();
	LinkedHashMap<Integer, TouristPlace> linkedhash = new LinkedHashMap<Integer,TouristPlace>(hash);
	TreeMap<Integer,TouristPlace> treemap = new TreeMap<Integer,TouristPlace>(hash);
	
	MapOperations mo = new MapOperations();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String destination = request.getParameter("travel");
		String rank = request.getParameter("rank");
		String add = request.getParameter("add");
		String view = request.getParameter("view");
		
		String sortinentryorder = request.getParameter("sortinentryorder");
		String sortinrandomly = request.getParameter("sortinrandomly");
		String sortinalphabetical = request.getParameter("sortinalphabetical");
		
		TouristPlace tp =new TouristPlace(name,destination,rank);
		int i = 0;
		bucketList.put(i,tp);
		hash = (HashMap<Integer, TouristPlace>) bucketList;
		linkedhash = (LinkedHashMap<Integer, TouristPlace>) bucketList;
		treemap = (TreeMap<Integer, TouristPlace>) bucketList;
		
		if(add!=null) {
			request.setAttribute("bucketList", hash);
			RequestDispatcher dispatcher = request.getRequestDispatcher("map.jsp");
			dispatcher.forward(request, response);
		}
		
		if(view!=null) {
			if(sortinrandomly!=null) {
				HashMap<Integer, TouristPlace> map1 = mo.sortRandomly(hash);
				request.setAttribute("bucketList", map1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("map.jsp");
				dispatcher.forward(request, response);
			}

			if(sortinentryorder!=null) {
				LinkedHashMap<Integer, TouristPlace> map2 = mo.sortInEntryOrder(linkedhash);
				request.setAttribute("bucketList", map2);
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("map.jsp");
				rd.forward(request, response);
			}
			if(sortinalphabetical!=null) {
				TreeMap<Integer, TouristPlace> map3= mo.sortAlphabetically(treemap);
				request.setAttribute("bucketList", map3);
				RequestDispatcher dispatcher = request.getRequestDispatcher("map.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		i++;
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

