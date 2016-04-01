/**
 * Created by apichat on 3/29/2016 AD.
 */
$(document).ready(function() {

    $("#materialTypeFormId").submit(function() {
        var data = {
            inputLotNumber : $("#inputLotNumber").val(),
            inputOrderNumber : $("#inputOrderNumber").val(),
            inputQty : $("#inputQty").val(),
            inputPartNumber : $("#inputPartNumber").val(),
            inputRevision : $("#inputRevision").val(),
            inputRemark : $("#inputRemark").val(),
            inputIssueName : $("#inputIssueName").val()
        };
        $.ajax({
            url: session["context"] +"/testJasper/create",
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
                    window.open(session["context"] + "/resources/fileOutPutPDF/" + data["urlPdf"]);
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