package br.com.servlets;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createintent")
public class CreatePaymentIntentServletapagar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Gson gson = new Gson();

    static class CreatePaymentItem {
        @SerializedName("id")
        String id;

        public String getId() {
            return id;
        }
    }

    static class CreatePayment {
        @SerializedName("items")
        CreatePaymentItem[] items;

        public CreatePaymentItem[] getItems() {
            return items;
        }
    }

    static class CreatePaymentResponse {
        private String clientSecret;

        public CreatePaymentResponse(String clientSecret) {
            this.clientSecret = clientSecret;
        }
    }

    static int calculateOrderAmount(Object[] items) {
        // Replace this constant with a calculation of the order's amount
        // Calculate the order total on the server to prevent
        // people from directly manipulating the amount on the client
        return 1400;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        // Convert JSON request body to CreatePayment object
        CreatePayment postBody = gson.fromJson(request.getReader(), CreatePayment.class);

        // Set your test secret API key
        Stripe.apiKey = "sk_test_51NDY0lCOmP8vPE48Ok0fNUlPPo3C53hNLNG0QnkMR9iA5A5IyS4b9v71sxgpxwsNJoS8S4tvz7gIWShvxNorp1SM00qmT9ZUbO";

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(new Long(calculateOrderAmount(postBody.getItems())))
                .setCurrency("brl")
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods
                                .builder()
                                .setEnabled(true)
                                .build()
                )
                .build();

        // Create a PaymentIntent with the order amount and currency
        PaymentIntent paymentIntent = null;
		try {
			paymentIntent = PaymentIntent.create(params);
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Create a response object
        CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());

        // Convert response object to JSON and send it back
        response.getWriter().print(gson.toJson(paymentResponse));
    }
}
