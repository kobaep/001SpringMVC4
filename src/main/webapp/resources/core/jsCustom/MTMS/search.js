/**
 * Created by apichat on 3/26/2016 AD.
 */
$(document).ready(function() {

    $("#formSubmit").submit(function() {
        var data = {
            inputSearch : $("#inputSearch").val()
        };
        $.ajax({
            url: session["context"] +"/material/search",
            type: "POST",
            headers: {
                Accept: "application/json"
            },
            data: {
                data : JSON.stringify(data)
            },
            dataType: "json",
            success: function(data){
                var link = session["context"] + "/material/"+ data.id +"?list";
                $(".data").remove();
                $("#dataTable").append('<tr class="data"><td>' + data["materialType"] +'</td><td>' + data["materialName"] + '</td><td><a class="btn btn-primary btn-sm" href="'+ link +'" role="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td></tr>');
                return false
            },
            error: function(data){
                alert("No data in database.");
                return false
            }
        });
        return false;
    });
});
