package br.com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@WebServlet("/personalizadoPayment")
public class CheckOutPersonalizado extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public CheckOutPersonalizado() {
        super();
        // This is your test secret API key.
        Stripe.apiKey = "sk_test_51NDY0lCOmP8vPE48Ok0fNUlPPo3C53hNLNG0QnkMR9iA5A5IyS4b9v71sxgpxwsNJoS8S4tvz7gIWShvxNorp1SM00qmT9ZUbO";
    }

    
	private Gson gson = new Gson();
	
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
		    return 1400;
		  }
		  
		

		  @Override
		  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  //  Stripe.apiKey = "sk_test_51NDY0lCOmP8vPE48Ok0fNUlPPo3C53hNLNG0QnkMR9iA5A5IyS4b9v71sxgpxwsNJoS8S4tvz7gIWShvxNorp1SM00qmT9ZUbO";

		    CreatePayment postBody = gson.fromJson(req.getReader(), CreatePayment.class);

		    @SuppressWarnings("removal")
			PaymentIntentCreateParams params =
		      PaymentIntentCreateParams.builder()
		        .setAmount(new Long(calculateOrderAmount(postBody.getItems())))
		        .setCurrency("brl")
		        .setAutomaticPaymentMethods(
		          PaymentIntentCreateParams.AutomaticPaymentMethods
		            .builder()
		            .setEnabled(true)
		            .build()
		        )
		        .build();

		    PaymentIntent paymentIntent = null;
			try {
				paymentIntent = PaymentIntent.create(params);
			} catch (StripeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
		    resp.getWriter().write(gson.toJson(paymentResponse));
		  }
}