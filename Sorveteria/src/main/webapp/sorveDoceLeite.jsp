<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="/components/top.jsp" />
<jsp:include page="/components/nav.jsp" />

<div class="site-section">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <div class="item-entry">
          <a href="#" class="product-item md-height bg-gray d-block">
            <img src="https://baciodilatte.com.br/wp-content/uploads/2021/09/Doce-de-Leite.png" alt="DoceLeite" alt="Image" class="img-fluid">
          </a>
        </div>
      </div>
      <div class="col-md-6">
        <h2 class="text-black">Sorvete de Doce de Leite</h2>
        <p>Saboreie a doçura sublime do sorvete de Doce de Leite, onde a suavidade cremosa encontra a intensidade caramelizada em cada colherada, proporcionando uma experiência indulgente que é puro deleite para o paladar.</p>
        <p><strong class="text-primary h4">R$50.00</strong></p>
        <div class="mb-1 d-flex">
        </div>
        <div class="mb-5">
          <div class="input-group mb-3" style="max-width: 120px;">
            <div class="input-group-prepend">
              <button class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
            </div>
            <input type="text" class="form-control text-center" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
            <div class="input-group-append">
              <button class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
            </div>
          </div>
        </div>
        <p><a href="cart.jsp" class="buy-now btn btn-sm height-auto px-4 py-3 btn-primary">Adicionar ao Carrinho</a></p>
      </div>
    </div>
  </div>
</div>

<jsp:include page="/components/footer.jsp" />
