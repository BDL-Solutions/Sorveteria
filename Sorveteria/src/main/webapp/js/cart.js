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

        function updateTotalPrice(input, price) {
            var quantity = parseInt(input.val());
            var totalPrice = quantity * price;
            
            // Atualize o preço total na interface do usuário
            $(input).closest('tr').find('.total-price').text('$' + totalPrice.toFixed(2));
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
        
    });
