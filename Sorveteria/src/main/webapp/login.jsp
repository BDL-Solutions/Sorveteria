<jsp:include page="/components/top.jsp" />
<jsp:include page="/components/nav.jsp" />

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

<div class="main" style="font-family: 'Arial', sans-serif; margin: 0; padding: 0; background-color: #f2f3f7; display: flex; align-items: center; justify-content: center; height: 100vh;">

    <!-- Sing in  Form -->
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">
                <div class="signin-form">
                    <h2 class="form-title">Faça Login</h2>
                    <form method="post" action="login" class="register-form" id="login-form">
                        <div class="form-group">
                            <label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="username" id="username" placeholder="Seu email" />
                        </div>
                        <div class="form-group">
                            <label for="password"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="password" placeholder="Senha" />
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                            <label for="remember-me" class="label-agree-term"><span><span></span></span>Lembrar-me</label>
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signin" id="signin" class="form-submit" value="Login" />
                        </div>
                        <div class="signin-image">
                            <a href="registration.jsp" class="signup-image-link">Click aqui para se cadastrar</a>
                        </div>
                    </form>
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

<jsp:include page="/components/footer.jsp" />
