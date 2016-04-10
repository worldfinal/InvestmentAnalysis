define(["dojo/_base/declare"], 
		function(declare){
	return declare([], {
		parse: function(id) {
			var htmlSrcNode = dojo.query("#" + id + " *[data-dojo-type]");
			console.log(htmlSrcNode);
			var requireList = ["dojo/parser"];
			dojo.forEach(htmlSrcNode, function(item, index){
				var newRequire = dojo.attr(item, 'data-dojo-type');
				if (newRequire && dojo.indexOf(requireList, newRequire) < 0) {
					requireList.push(newRequire);
				}
			});
			console.log(requireList);
			require(requireList, function(parser){
				parser.parse(dojo.byId(id));
			});
		}
	});
});
