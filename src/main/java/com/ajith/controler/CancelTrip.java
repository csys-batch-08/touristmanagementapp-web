package com.ajith.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.BookingTableDaoImplement;
import com.ajith.daoImplement.FlightTableDaoImplement;
import com.ajith.daoImplement.UserTableDaoImplement;
import com.ajith.model.BookingClass;
import com.ajith.model.FlightClass;
import com.ajith.model.UserClass;

@WebServlet("/cancelTrip")
public class CancelTrip extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
		String bookingid = request.getParameter("bookingid");

		int bookingId = Integer.parseInt(bookingid);
		BookingTableDaoImplement cancel = new BookingTableDaoImplement();
		BookingClass book = cancel.getSingleBookingById(bookingId);

		UserTableDaoImplement userDao = new UserTableDaoImplement();

		
			UserClass user = userDao.getUserById(book.getUser());

			double fine = (book.getTotalPrice() / 100) * 10;
			double refund = book.getTotalPrice() - fine;
			double refundPrice = user.getWallet() + refund;

			FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
			FlightClass flight = flightDao.getSingleFlight(book.getFlight().getFlightNo());

			int businessSeats = flight.getBusinessClassSeat();
			int economicSeats = flight.getEconomicClassSeat();
			if (book.getFlightClass().equalsIgnoreCase("business class")) {
				businessSeats += book.getNoOfPerson();
			} else {
				economicSeats += +book.getNoOfPerson();
			}

			boolean cancelBooking = cancel.updatebooking(user.getId(), book.getStartDate(), refundPrice, businessSeats,
					economicSeats, book.getFlight().getFlightNo(), book.getBookingId());

			if (cancelBooking) {

				response.sendRedirect("cancelTrip.jsp");

			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('can not be calceled! please try again');");
				out.println("location='showAllBooking.jsp';");
				out.println("</script>");
			}

		} catch (ClassNotFoundException | SQLException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

}
