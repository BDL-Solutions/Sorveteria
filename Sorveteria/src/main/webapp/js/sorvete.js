
    $(document).ready(function(){
        $('.js-btn-plus').click(function(){
            var input = $(this).parent().siblings('.quantity');
            var price = parseFloat($('.preco').text().replace('R$', '').replace(',', '.'));
            input.val(parseInt(input.val()) + 1);
        });

        $('.js-btn-minus').click(function(){
            var input = $(this).parent().siblings('.quantity');
            var price = parseFloat($('.preco').text().replace('R$', '').replace(',', '.'));
            if (parseInt(input.val()) > 1) {
                input.val(parseInt(input.val()) - 1);
            }
        });
    });

        $('.btn-adicionar-carrinho').click(function() {
            // Extrai os dados da página do produto
            var produtoNome = $('.text-black').text();
            var idProduto = parseInt($('.idProduto').text());
            var produtoPreco = parseFloat($('.preco').text().replace('R$', '').replace(',', '.'));
            var quantidade = parseInt($('.quantity').val());

            // Faz a requisição AJAX para o servlet
            $.ajax({
                type: "POST",
                url: "AddSorveCart",
                data: {
                    produtoNome: produtoNome,
                    produtoPreco: produtoPreco,
                    quantidade: quantidade,
                    idProduto: idProduto
                },
                success: function(response) {
                    // Lógica para lidar com a resposta do servidor, se necessário
                    console.log(response);
                }
            });
        });

