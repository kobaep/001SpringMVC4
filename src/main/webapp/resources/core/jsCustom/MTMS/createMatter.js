/**
 * Created by apichat on 3/11/2016 AD.
 */
$(document).ready(function() {

    $("#inputDateSpec").datepicker({ dateFormat: "dd/mm/yy" });
    //$("#inputDateSpec").datepicker().datepicker("setDate", new Date());

    $("#inputDateRoHs").datepicker({ dateFormat: "dd/mm/yy" });
    //$("#inputDateRoHs").datepicker().datepicker("setDate", new Date());

    $("#inputDateMSDS").datepicker({ dateFormat: "dd/mm/yy" });
    //$("#inputDateMSDS").datepicker().datepicker("setDate", new Date());

    $("#inputDateHF").datepicker({ dateFormat: "dd/mm/yy" });
    //$("#inputDateHF").datepicker().datepicker("setDate", new Date());

    $("#materialFormId").submit(function() {
        var formData = new FormData();
        formData.append("inputSpec", $("#inputSpec")[0].files[0]);
        formData.append("inputDateSpec", $("#inputDateSpec").val());

        formData.append("inputRoHs", $('#inputRoHs')[0].files[0]);
        formData.append("inputDateRoHs", $("#inputDateRoHs").val());

        formData.append("inputMSDS", $('#inputMSDS')[0].files[0]);
        formData.append("inputDateMSDS", $("#inputDateMSDS").val());

        formData.append("inputHalogen", $('#inputHalogen')[0].files[0]);
        formData.append("inputDateHF", $("#inputDateHF").val());

        formData.append("inputManufacturing", $("#inputManufacturing").val());
        formData.append("inputMaterialName", $("#inputMaterialName").val());
        formData.append("inputStartDate", $("#inputStartDate").val());
        formData.append("inputUlNumber", $("#inputUlNumber").val());
        formData.append("id", $("#inputId").val());

        $.ajax({
            type: "POST",
            headers: {
                Accept: "application/json",
            },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: session['context'] +"/materialPrivate/create",
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
});