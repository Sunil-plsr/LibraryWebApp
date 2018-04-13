<%@ include file="header1.jsp" %>
<div class="coverImage">
    <img src="images/bg01e.jpg"/>
</div>
<section class="layout ">
    <form action="UserController?action=login" method="post">
        <div class="dropmenu" id="loginmenu">
            <div class="loginbox">
                <div class="loginform">
                    <div class="loginfield">
                        <img src="images/username.svg" class="icon">
                        <input id="email" class="logininput" type="email" name="email" required placeholder="E-mail address">
                    </div>
                    <div class="loginfield">
                        <img src="images/password.svg" class="icon">
                        <input id="password" class="logininput" type="password" name="password" required placeholder="Password">
                    </div>
                    <div class="loginfail">${msg}</div>
                    <div class="signupmsg">${signupmsg}</div>
                    <button class="loginbutton" type="submit"  id="submit_button">Log In</button>
                    <div class="loginnew"><a class="signuplink" href="./signup.jsp">Create new account</a></div>
                </div>
            </div>
        </div>
        <div class="messagearea" id="messagearea"></div>
    </form>
</section>
<%@ include file="footer.jsp" %>