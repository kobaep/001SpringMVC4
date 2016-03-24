/**
 * Created by apichat on 3/15/2016 AD.
 */
$("#materialSapFormId").submit(function() {
    var data = {
        inputMaterialTypeId : $("#inputId").val(),
        inputMaterialId : $("#inputMaterialName").val(),
        inputSapCode : $("#inputSapCode").val()
    };
    $.ajax({
        url: session["context"] +"/materialSapPrivate/createMaterialSap",
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
                window.location.href = session["context"] + "/material/" + $("#inputId").val() + "?list";
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
