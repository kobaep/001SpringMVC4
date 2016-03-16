/**
 * Created by apichat on 3/11/2016 AD.
 */
$(document).ready(function() {

    $("#materialTypeFormId").submit(function() {
        var data = {
            inputMaterialType : $("#inputMaterialType").val()
        };
        $.ajax({
            url: session["context"] +"/materialTypePrivate/createMaterialType",
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
                    window.location.href = session["context"] + "/materialType/?list";
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