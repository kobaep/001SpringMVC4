<%@page session="true"%>
<div class="container">
    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">User :</label>
            <div class="col-sm-10">
                <p class="form-control-static">${appuser.username}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <p class="form-control-static">email@example.com</p>
            </div>
        </div>
    </form>
</div>