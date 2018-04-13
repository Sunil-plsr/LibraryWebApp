
<%@ include file="header1.jsp" %>
<div class="coverImage">
    <img src="images/bg01e.jpg"/>
</div>
<section class="layout ">
    <form action="UserController?action=signup" method="post">
        <div class="signupmenu">
            <div class="signupbox">
                <div class="signupform">
                    <div class="signupfield">
                        <img src="images/username.svg" class="icon">
                        <input id="name" class="signupinput" type="text" name="name" required placeholder="Name">
                    </div>
                    <div class="signupfield">
                        <img src="images/username.svg" class="icon">
                        <input id="email" class="signupinput" type="email" name="email" required placeholder="E-mail address">
                    </div>
                    <div class="signupfield">
                        <img src="images/password.svg" class="icon">
                        <input id="password" class="signupinput" type="password" name="password" required placeholder="Password">
                    </div>
                    <div class="signupfield">
                        <img src="images/password.svg" class="icon">
                        <input id="confirm_password" class="signupinput" type="password" name="confirm_password" required placeholder="Confirm Password">
                    </div>
                    <div class="signupfield">
                        <select required name="policytype">
                            <option selected value="" disabled="">Select User Type</option>
                            <option value="Student">Student</option>
                            <option value="LibraryStaff">Library Staff</option>
                            <option value="Admin">Admin</option>
                        </select>
                    </div>
                    <button class="signupbutton" type="submit"  id="submit_button">Sign Up</button>
                    <div class="signupfail">${msg}</div>
                </div>
            </div>
        </div>
        <div class="messagearea" id="messagearea"></div>
    </form>
</section>
<%@ include file="footer.jsp" %>