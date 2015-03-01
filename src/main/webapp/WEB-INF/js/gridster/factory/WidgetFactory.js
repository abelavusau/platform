var WidgetFactory = (function() {
	var instance;

	var WIDGET_DIV = "div";
	var WIDGET_TABLE = "table";
	var WIDGET_IMAGE = "image";
	
	var WIDGET_TYPE_MAP = {
		WIDGET_DIV : '<li class="new" widget_type="div">The HTML of the div...</li>',
		WIDGET_TABLE : '<li class="new" widget_type="table">The HTML of the table...</li>',
		WIDGET_IMAGE : '<li class="new" widget_type="image">The HTML of the image...</li>'
	};
	
	function createInstance() {
		var object = new WidgetFactory();
		return object;
	}
	
	function getWidget(type) {
		return WIDGET_TYPE_MAP[type];
	}

	return {
		getInstance : function() {
			if (!instance) {
				instance = createInstance();
			}
			
			return instance;
		}
	};
})();