/**
 * Created by hhy on 2017/6/2.
 */
(function ($) {
var row=15;
var column=15;
var url="/am";
var speed;
function create_map() {
    var map = $("#map");
    map.html("");
    for(var i=0;i<row;i++) {
        for(var j=0;j<column;j++){
            var id_temp = i+'-'+j;
            map.append('<div '+'id='+id_temp+' class="item"></div>');
        }
    }
}
function next() {
    // console.log("next");
    // $("#map").children()
    $("#map .item").each(function () {
        $(this).css("background","black")
    });
    $.get(url,{}, function (data) {
        var parsedJson = jQuery.parseJSON(data);
         console.log(data);
        $.each(parsedJson, function (idx, item) {
            // console.log(item.x);
            var id_temp = item.x+'-'+item.y;
            $("#"+id_temp).css("background","orange");
        });
    })
}
    function start() {
        $.get("/am",{"start":"start"}, function (data) {
            console.log("click start");
        })
    }
    function setspeed() {
        clearInterval(speed);
        new_speed = $("#speed").val();
        speed = window.setInterval(next, new_speed);
        console.log("new speed");
    }
    $(function () {
        // alert("init done");
        create_map();
        $("#start-btn").click(start);
        $("#speed-btn").click(setspeed);
        speed = window.setInterval(next, 1000);
        // clearInterval(refresh);
        // $("#btn-start").onclick(start);
    });
})(jQuery);