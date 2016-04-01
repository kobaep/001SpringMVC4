/**
 * Created by apichat on 3/30/2016 AD.
 */
$(document).ready(function() {
    $("#inputDateRoHs").datepicker({ dateFormat: "dd/mm/yy" });

    $("#inputDateHF").datepicker({ dateFormat: "dd/mm/yy" });

    $("#materialFormId").submit(function() {
        var formData = new FormData();
        formData.append("inputSpec", $("#inputSpec")[0].files[0]);

        formData.append("inputRoHs", $('#inputRoHs')[0].files[0]);
        formData.append("inputDateRoHs", $("#inputDateRoHs").val());
        if($('#inputRoHs')[0].files[0] != null) {
            if(!$("#inputDateRoHs").val() ) {
                $("#inputDateRoHs").focus();
                return false;
            }
        }
        formData.append("inputMSDS", $('#inputMSDS')[0].files[0]);

        formData.append("inputHalogen", $('#inputHalogen')[0].files[0]);
        formData.append("inputDateHF", $("#inputDateHF").val());
        if($('#inputHalogen')[0].files[0] != null) {
            if(!$("#inputDateHF").val()) {
                $("#inputDateHF").focus();
                return false;
            }
        }
        formData.append("inputManufacturing", $("#inputManufacturing").val());
        formData.append("inputMaterialName", $("#inputMaterialName").val());
        formData.append("inputUlNumber", $("#inputUlNumber").val());
        formData.append("id", $("#inputId").val());

        $.ajax({
            type: "POST",
            headers: {
                Accept: "application/json",
            },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: session['context'] +"/materialPrivate/updateAll",
            processData: false,
            contentType: false,
            data: formData,
            async: false,
            success: function(data){
                if(data.create) {
                    window.location.href = session["context"] + "/materialType/" + $("#inputId").val() + "?list";
                } else {
                    console.log("Can't create.");
                    return false;
                }
            },
            error: function(data){
                alert("saved error.");
                return false;
            }
        });
        return false;
    });

    $("#btnCancle").click(function() {
        var data = {
            inputId : $("#inputId").val(),
            action : "REMOVE",
            reason : "REMOVE"
        };
        $.ajax({
            url: session["context"] +"/materialPrivate/remove",
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