$(document).ready(function() {
	$(".nav-tabs a").click(function() {
		$(this).tab('show');
	});
	$('.nav-tabs a').on('shown.bs.tab', function(event) {
		var x = $(event.target).text();
		var y = $(event.relatedTarget).text();
		$(".act span").text(x);
		$(".prev span").text(y);
	});
});