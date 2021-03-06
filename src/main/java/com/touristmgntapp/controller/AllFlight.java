package com.touristmgntapp.controller;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touristmgntapp.dao.Impl.FlightTableDaoImplement;
import com.touristmgntapp.model.BookingClass;
import com.touristmgntapp.model.FlightClass;

@WebServlet("/allFlights")
public class AllFlight extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
		HttpSession session = request.getSession();

		BookingClass booking = (BookingClass) session.getAttribute("booking");

		String depDate = request.getParameter("startdate");

		LocalDate depatureTimeDate = LocalDate.parse(depDate);
		String daysPlane = request.getParameter("noofdays");

		int noOfPerson = Integer.parseInt(request.getParameter("noofperson"));
		session.setAttribute("noofperson", noOfPerson);

		int days = Integer.parseInt(daysPlane.substring(0, 1));

		double totalPrice = booking.getTotalPrice() * days;

		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		List<FlightClass> flights = flightDao.getFlightByNo(booking.getPackageName(), depatureTimeDate);

		request.setAttribute("allflightpage", flights);

		BookingClass bookings = new BookingClass(booking.getUser(), booking.getPackages(), null, null, noOfPerson,
				depatureTimeDate, totalPrice, "", "", daysPlane, booking.getPackageName(), 0);
		session.setAttribute("bookings", bookings);

		RequestDispatcher rd = request.getRequestDispatcher("allFlights.jsp");
	
			rd.forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

}
