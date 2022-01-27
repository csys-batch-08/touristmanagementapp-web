package com.ajith.controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajith.daoImplement.RatingDaoImplement;
import com.ajith.model.UserFeedbackClass;

@WebServlet("/showAllRating")
public class ShowAllRatings extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			RatingDaoImplement ratingDao = new RatingDaoImplement();

			List<UserFeedbackClass> ratings = ratingDao.getAllFeedback();

			request.setAttribute("showAllRating", ratings);

			RequestDispatcher rd = request.getRequestDispatcher("showAllRating.jsp");
			rd.forward(request, response);

		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {

			System.out.println(e.getMessage());
		}

	}

}
