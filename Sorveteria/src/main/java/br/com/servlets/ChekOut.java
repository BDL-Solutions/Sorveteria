package br.com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

/**
 * Servlet implementation class ChekOut
 */
@WebServlet("/casquinha")
public class ChekOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChekOut() {
        super();
        // This is your test secret API key.
        Stripe.apiKey = "sk_test_51NDY0lCOmP8vPE48Ok0fNUlPPo3C53hNLNG0QnkMR9iA5A5IyS4b9v71sxgpxwsNJoS8S4tvz7gIWShvxNorp1SM00qmT9ZUbO";
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
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
                .setPrice("price_1OJgMCCOmP8vPE48e0AHjPTx")
                .build())
            .build();
        Session session;
		try {
			session = Session.create(params);
			 response.sendRedirect(session.getUrl());
		} catch (StripeException e) {
			// TODO Auto-generated catch block]
			e.printStackTrace();
		}
	

       
    }
	}


