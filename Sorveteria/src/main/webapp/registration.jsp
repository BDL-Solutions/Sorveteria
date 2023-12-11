<jsp:include page="/components/top.jsp" />
<jsp:include page="/components/nav.jsp" />

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

<div class="main">

    <!-- Sign up form -->
    <section class="sign-up">
        <div class="container">
            <div class="signup-content text-center">
                <div class="signup-form-container">
                    <div class="signup-form" style="margin: 20px;">
                        <h2 class="form-title">Registre-se aqui</h2>

                        <form method="post" action="register" class="register-form" id="register-form">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="name" id="name" placeholder="Your Name" class="form-control" />
                                        <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" name="email" id="email" placeholder="Your Email" class="form-control" />
                                        <label for="email"><i class="zmdi zmdi-email"></i></label>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="pass" id="pass" placeholder="Password" class="form-control" />
                                        <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password" class="form-control" />
                                        <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="contact" id="contact" placeholder="Contact no" class="form-control" />
                                        <label for="Celular"><i class="zmdi zmdi-lock-outline"></i></label>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="cep" id="cep" placeholder="Enter CEP" />
                                        <label for="cep" class="form-label">CEP:</label>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="bairro" id="bairro" placeholder="Enter bairro" />
                                        <label for="bairro" class="form-label">Bairro:</label>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="localidade" id="localidade" placeholder="Enter localidade" />
                                        <label for="localidade" class="form-label">Cidade:</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit btn btn-primary" value="Register" />
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </section>

</div>
<!-- JS -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://unpkg.com/sweetalert/dist/sweetalert.css">
<script src="js/main.js"></script>

<script type="text/javascript">
    var status = document.getElementById("status").value;
    if (status == "failed") {
        swal({
            title: "Oops!",
            text: "Wrong username or password",
            icon: "error",
            button: "OK",
        });
    }
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
<script type="text/javascript">
    $(document).ready(function(){
        $("#cep").blur( function(){
            
            var url = "https://viacep.com.br/ws/"+$("#cep").val()+"/json/";
            $.get( url, function( response ){
                $("#logradouro").val(response.logradouro);
                $("#complemento").val(response.complemento);
                $("#bairro").val(response.bairro);
                $("#localidade").val(response.localidade);
                $("#uf").val(response.uf);
            }, "json");
        } );
    });
</script>

<jsp:include page="/components/footer.jsp" />
