package br.com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.annotation.WebServlet;


public class Server extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Server() {
        super();
        // This is your test secret API key.
        Stripe.apiKey = "sk_test_51NDY0lCOmP8vPE48Ok0fNUlPPo3C53hNLNG0QnkMR9iA5A5IyS4b9v71sxgpxwsNJoS8S4tvz7gIWShvxNorp1SM00qmT9ZUbO";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String YOUR_DOMAIN = "https://8168-177-145-70-233.ngrok-free.app/Sorveteria/";
        SessionCreateParams params =
          SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl(YOUR_DOMAIN + "/success.html")
            .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
            .addLineItem(
              SessionCreateParams.LineItem.builder()
                .setQuantity(1L)
                // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
                .setPrice("{{PRICE_ID}}")
                .build())
            .build();
        Session session = null;
		try {
			session = Session.create(params);
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.sendRedirect(session.getUrl());
    }
}
