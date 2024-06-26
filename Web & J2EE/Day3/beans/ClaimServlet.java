package com.yourcompany.beans;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ClaimServlet", urlPatterns = {"/claim"})
public class ClaimServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process form submission
        ClaimBean claim = new ClaimBean();
        claim.setClaimNumber(request.getParameter("claimNumber"));
        claim.setPolicyNumber(request.getParameter("policyNumber"));
        claim.setClaimantName(request.getParameter("claimantName"));
        claim.setClaimAmount(Double.parseDouble(request.getParameter("claimAmount")));

        // Store claim bean in session
        request.getSession().setAttribute("claimBean", claim);

        // Redirect to confirmation page
        response.sendRedirect(request.getContextPath() + "/confirmation.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests if needed
    }
}
