/**
 * Created by apichat on 3/9/2016 AD.
 */
$(document).ready(function() {

        var data = {};

        $.ajax({
            url: session['context'] +'/appuser/datalist',
            type: "POST",
            headers: {
                Accept: "application/json"
            },
            data: {
                data : JSON.stringify(data)
            },
            dataType: "json",
            success: function(data){
                $(".dataTableUser").remove();
                $.each(data, function (i, item) {
                    var dataTable = '<tr class="dataTableUser"><td>' + item.no + '</td><td>' + item.user + '</td><td>' + item.password + '</td><td>' + item.name + '</td><td>' + item.department + '</td><td>' + item.email + '</td><td>' + item.telephone + '</td><td><a href="'+ session['context'] +'/appuser/edit/' + item.id + '" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td></tr>';
                    $("#tableUser").append(dataTable);
                });
            },
            error: function(data){
                alert("saved error.");
            }
        });
});