/**
 * Created by apichat on 3/30/2016 AD.
 */
$(document).ready(function() {
    $("#btnSubmit").click(function() {
        $("#alertRejectModal").modal({show:true});
    });
    $("#btnRejectReason").click(function() {
        var data = {
            inputId : $("#inputId").val(),
            action : "REQUESTDOC",
            reason : $("#inputReason").val()
        };
        $.ajax({
            url: session["context"] +"/materialPrivate/update",
            type: "POST",
            headers: {
                Accept: "application/json"
            },
            data: {
                data : JSON.stringify(data)
            },
            dataType: "json",
            success: function(data){
                console.log(data.create);
                if(data.create) {
                    window.location.href = session["context"] + "/materialType?list";
                } else {
                    console.log("Can't create.");
                    return false;
                }
            },
            error: function(data){
                alert("saved error.");
            }
        });
        return false;
    });
});