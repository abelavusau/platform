$(function() { // DOM Ready

	var gridster = $(".gridster ul").gridster().data('gridster');
	var pallete = $(".pallete ul").gridster({
		widget_margins : [ 10, 10 ],
		widget_base_dimensions : [ 50, 50 ]
	});

	function addTable() {
		gridster.add_widget(WidgetFactory.getInstance().getWidget(
				WidgetFactory.WIDGET_TABLE), 1, 1);
	}

	function addDiv() {
		gridster.add_widget(WidgetFactory.getInstance().getWidget(
				WidgetFactory.WIDGET_DIV), 1, 1);
	}

	function addImage() {
		gridster.add_widget(WidgetFactory.getInstance().getWidget(
				WidgetFactory.WIDGET_IMAGE), 1, 1);
	}

	function removeWidget(el) {
		gridster.remove_widget(el);
	}

	function save() {
		var serializedLayout = gridster.serialize();
	}
});
