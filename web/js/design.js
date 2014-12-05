// Login Popover

$(document).ready(function () {
    $("[data-toggle=popover]").popover({
        html: true,
        content: function () {
            return $('#popover-content').html();
        }
    });
});

$(document).ready(function () {
    $("#menus a").click(function () {
        $("#menus li").removeClass('active');
        $(this).parent().addClass('active');
    });
});