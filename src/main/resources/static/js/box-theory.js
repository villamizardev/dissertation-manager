$(function() {
	$("#fecha").datepicker({
		dateFormat : 'dd-mm-yy'
	});
});

tinymce
		.init({
			selector : '#theory',
			plugins : "textcolor, table lists code",
			toolbar : " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                    | bullist numlist outdent indent | forecolor backcolor table code"
		});