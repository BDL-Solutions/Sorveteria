<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
<%
    if (session.getAttribute("name") == null) {
        //session.setAttribute("name", "");
        // You can also redirect to login.jsp if needed
        response.sendRedirect("login.jsp");
    }
%>

<jsp:include page="/components/top.jsp" />

<jsp:include page="/components/nav.jsp" />

    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <form class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th class="product-thumbnail">Image</th>
                    <th class="product-name">Product</th>
                    <th class="product-price">Price</th>
                    <th class="product-quantity">Quantity</th>
                    <th class="product-total">Total</th>
                    <th class="product-remove">Remove</th>
                  </tr>
                </thead>
                <tbody>
                    

   					
   				<c:forEach var="item" items="${cartItems}">
                  <tr data-idProduto="${item.idProduto}">
                    <td class="product-thumbnail">
                      <img src="images/cloth_1.jpg" alt="Image" class="img-fluid">
                    </td>
                    <td class="product-name">
                      <h2 class="h5 text-black">${item.nomeProduto}</h2>
                    </td>
                    <td class="price" >${item.valor}</td>
                    <td>
                      <div class="input-group mb-3" style="max-width: 120px;">
                        <div class="input-group-prepend">
                          <button class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
                        </div>
                        <input type="text" class="form-control text-center quantity" value="${item.quantidade}" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                        <div class="input-group-append">
                          <button class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
                        </div>
                      </div>

                    </td>
                    <td class="total-price total-price-element"></td>
                    <td><a href="#" class="btn btn-primary height-auto btn-sm delete">X</a></td>
                  </tr>
                   </c:forEach>

                  
                </tbody>
              </table>
            </div>
          </form>
        </div>

        <div class="row">
          <div class="col-md-6">
            <div class="row mb-5">
              <div class="col-md-6 mb-3 mb-md-0">
                <button class="btn btn-primary btn-sm btn-block">Update Cart</button>
              </div>
              <div class="col-md-6">
                <button class="btn btn-outline-primary btn-sm btn-block">Continue Shopping</button>
              </div>
            </div>

          </div>
          <div class="col-md-6 pl-5">
            <div class="row justify-content-end">
              <div class="col-md-7">
                <div class="row">
                  <div class="col-md-12 text-right border-bottom mb-5">
                    <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                  </div>
                </div>
	
                <div class="row mb-5">
                  <div class="col-md-6">
                    <span class="text-black">Total</span>
                  </div>
                  <div class="col-md-6 text-right">
                    <strong id="total" class="text-black totalCart">$230.00</strong>
                  </div>
                </div>

                <div class="row">
                  <div class="col-md-12">
                    <button class="btn btn-primary btn-lg btn-block" onclick="window.location='checkout.html'">Proceed To Checkout</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  <jsp:include page="/components/footer.jsp" />
  
<script>
$(document).ready(function(){
    $('.js-btn-plus').click(function(){
        var input = $(this).parent().siblings('.quantity');
        var price = parseFloat($(this).closest('tr').find('.price').text().replace('$', ''));
        input.val(parseInt(input.val()) + 1);
        updateTotalPrice(input, price);
    });

    $('.js-btn-minus').click(function(){
        var input = $(this).parent().siblings('.quantity');
        var price = parseFloat($(this).closest('tr').find('.price').text().replace('$', ''));
        if (parseInt(input.val()) > 1) {
            input.val(parseInt(input.val()) - 1);
            updateTotalPrice(input, price);
        }
    });

    function updateTotalPrice(input, price, updateTotalCart) {
        var quantity = parseInt(input.val());
        var totalPrice = quantity * price;
        
        // Atualize o preço total na interface do usuário
        $(input).closest('tr').find('.total-price').text('$' + totalPrice.toFixed(2));
        
        if (updateTotalCart) {
            updateTotalCartValue();
        }
        
        updateTotalCartValue();
    }
    

    $('.table tbody tr').each(function() {
        var quantity = parseInt($(this).find('.quantity').val());
        var price = parseFloat($(this).find('.price').text().replace('$', ''));
        var totalPrice = quantity * price;
        $(this).find('.total-price').text('$' + totalPrice.toFixed(2));
    });
    
    $('.delete').click(function() {
	    // Armazena uma referência ao elemento atual
	    var currentRow = $(this).closest('tr');
	    // Encontrar o nomeProduto associado à linha
	    var nomeProduto = currentRow.find('.product-name h2').text().trim();
	    // Fazer a requisição AJAX para o servlet
	    $.ajax({
	        type: "POST",
	        url: "delSorveCart",
	        data: {
	            nomeProduto: nomeProduto,
	        },
	        success: function(response) {
	            // Lógica para lidar com a resposta do servidor, se necessário
	            console.log(response);
	            // Remover a linha da tabela
	            currentRow.remove();
	        }
	    });
	});
    
    function updateTotalCartValue() {
        var totalCartValue = 0;

        // Iterar sobre todos os elementos com a classe total-price-element
        $('.total-price-element').each(function () {
            var totalPrice = parseFloat($(this).text().replace('$', ''));
            totalCartValue += totalPrice;
        });

        // Atualize o elemento com id 'total' com o valor total do carrinho
        $('#total').text('$' + totalCartValue.toFixed(2));
    }

    updateTotalCartValue();
    
});

</script>