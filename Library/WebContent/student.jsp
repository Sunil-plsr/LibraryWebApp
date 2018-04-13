<%@ include file="headerStudent.jsp" %>
<div class="coverImage">
    <img src="images/bg01e.jpg"/>
</div>
<div class="welcometext">Hello ${name}.<br>
</div>
<section class="layout">
    <aside class="primary">
        <div class="tiles">
            <div class="tile">
                <a href="UserController?action=searchBooks">
                    <div class="label ">Search books in library</div>
                    <div>
                        <button class="tileButton">Search Books</button>
                    </div>
                </a>
            </div>
            <div class="tile">
                <a href="UserController?action=extend">
                    <div class="label">Extend due date on books</div>
                    <div>
                        <button class="tileButton">Extend</button>
                    </div>
                </a>
            </div>
        </div>
    </aside>
</section>
<%@ include file="footer.jsp" %>