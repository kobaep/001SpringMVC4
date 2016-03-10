/**
 * Created by apichat on 3/9/2016 AD.
 */
$(document).ready(function() {

    $("#appUserId").submit(function() {
        var data = {
            inputUser : $("#inputUser").val(),
            inputPassword : $("#inputPassword").val(),
            inputName : $("#inputName").val(),
            inputDepartment : $("#inputDepartment").val(),
            inputDepartmentCode : $("#inputDepartmentCode").val(),
            inputEmail : $("#inputEmail").val(),
            inputTelephoneNumber : $("#inputTelephoneNumber").val(),
            inputRoleName : $("#inputRoleName").val(),
        };
        $.ajax({
            url: session['context'] +'/appuser/create',
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
                    window.location.href = session['context'] + '/appuser/list';
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