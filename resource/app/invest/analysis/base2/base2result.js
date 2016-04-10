
define(["dojo/_base/declare", 
	/*	"dijit/_WidgetBase", 
		"dijit/_TemplatedMixin", 
		"app/invest/WFContentPane/WFContentPane",*/
		"dojo/_base/lang",
		"dojo/dom-form",
		'dojo/string',
		"dojo/on",
		"dijit/registry",
		"dojo/dom-construct",
		"dojo/text!./template/result.html",
		"dojo/data/ItemFileWriteStore",
		"dojox/grid/DataGrid",
		"dojo/store/Memory"], 
	function(declare, /*WidgetBase, TemplatedMixin, WFContentPane, */
			lang, domForm, String, on, registry, domConstruct,
			template, ItemFileWriteStore, DataGrid,
			Memory){
		return declare([/*WFContentPane, WidgetBase, TemplatedMixin*/], {
//			href:"index.html",
//			templateString:template,
			grid: null,
			postCreate: function(){
		//		this.inherited(arguments);
		//		this.updateRequestInfo();
		//		this.updateDatagrid();
				
			},
			updateRequestInfo: function(responseData) {
				var req = responseData.request;
				console.log(req);
				var str = "";
				str += "<p>从" + req.fromDate + "到" + req.toDate + "(类型:" + req.type + ")</p>";
				str += "<p>在" + req.price + "开仓 (" + req.param + "), 赚" + req.earn + "元后平仓</p>";
				str += "<p>开仓/平仓时间如下</p>";
//				info  =this.requestInfo;
//				console.log(info);
//				this.requestInfo.innerHTML = str;
				dojo.byId("base2_requestInfo").innerHTML = str;
			},
			updateDatagrid:function(responseData) {
				var data = {
					identifier: 'id',
					items: []
				};
				var dataList = responseData.trades;
				console.log(dataList);
				for (var i = 0; i < dataList.length; i++) {
					data.items.push(dojo.mixin({ id: i+1 }, dataList[i]));
				}
				
				var store = new ItemFileWriteStore({data: data});
				
				/*set up layout*/
			    var layout = [[
			      {'name': 'ID', 'field': 'id', 'width': '60px'},
			      {'name': '开仓时间', 'field': 'inDate', 'width': '180px'},
			      {'name': '平仓时间', 'field': 'outDate', 'width': '180px'},
			      {'name': '经历时间（日）', 'field': 'lastDays', 'width': '180px'}
			    ]];
				
			    console.log("To be destroy: grid!!!");
			    console.log(this.grid);
			   
			    if (this.grid != null) {
			    	this.grid.destroy();
			    	this.grid = null;
			    }
			    if (dijit.byId("base2_grid") != null) {
			    	dijit.byId("base2_grid").destroy();
			    }
			    dojo.byId("base2_grid_container").innerHTML = "";
			    
			    var grid = new DataGrid({
			    	id:"base2_grid",
			        store: store,
			        structure: layout,
			        autoWidth: true,
			        autoHeight: true,
			        rowSelector: '20px'},
			      document.createElement('div'));
			    
			    this.grid = grid;
			    
	//		    this.resultContainerNode.innerHTML = "";
			    console.log("clear this.resultContainerNode");
//			    dojo.byId("requestInfo").appendChild(grid.domNode);
			    grid.placeAt("base2_grid_container");
			    grid.startup();
			}
		});
});
