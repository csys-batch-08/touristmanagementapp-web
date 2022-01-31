package com.touristMgntApp.controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristMgntApp.daoImpl.HotelTableDaoImplement;
import com.touristMgntApp.models.HotelClass;

@WebServlet ("/updatehotel")
public class UpdateHotel extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)  {
		
		
		try {
			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		
		String hotelname = req.getParameter("hotelname");
		
		String hotelLocation = req.getParameter("hotellocation");
		
	   double normalRoom = Double.parseDouble(req.getParameter("standardprice"));
		
		double premiumRoom = Double.parseDouble (req.getParameter("premiumprice"));
		
		int hotelid = Integer.parseInt(req.getParameter("hotelid"));
		
		String image = req.getParameter("hotelimage");
		
		
		HotelClass hotel = new HotelClass(hotelid,hotelLocation,hotelname,normalRoom,premiumRoom,image);
		boolean hotels = hotelDao.updateHotel(hotel);
		
		PrintWriter out = res.getWriter();
		if(hotels) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Updated');");
			out.println("location='showAllHotel';");
			out.println("</script>");
			
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('can not be Updated');");
			out.println("location='showAllHotel';");
			out.println("</script>");
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}