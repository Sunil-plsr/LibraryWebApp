<%@ include file="header1.jsp" %>
<div class="coverImage">
    <img src="images/bg01e.jpg"/>
</div>
<section class="layout ">
    <form action="UserController?action=sendmail" method="post">
        <div class="policymenu">
            <div class="policybox">
                <div class="pageheader">
                    <div class="headertext">Let's get together</div>
                </div>
                <div class="policyform">
                    <div class="policyfield">
                        <input class="supportinput" type="text" name="name" required placeholder="Name">
                    </div>
                    <div class="policyfield">
                        <input class="supportinput" type="email" name="email" required placeholder="Email" value=${email}>
                    </div>
                    <div class="policyfield">
                        <textarea style="font-family: Lato,sans-serif; font-size: 13px;" class="supportinput" name="emailbody" required placeholder="What is the problem" value=""></textarea>
                    </div>
                    <div class="signupmsg">${supportmsg}</div>
                    <div class="signupfail">${supportfail}</div>
                    <button class="signupbutton" type="submit"  id="submit_button">SEND IT</button>
                    <div class="signupfail"></div>
                </div>
            </div>
        </div>
        <div class="messagearea" id="messagearea"></div>
    </form>
</section>
<%@ include file="footer.jsp" %>