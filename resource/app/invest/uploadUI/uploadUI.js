define(["dojo/_base/declare", 
		"dijit/_WidgetBase", 
		"dijit/_TemplatedMixin", 
		"app/invest/WFContentPane/WFContentPane",
		"dojo/text!./template/ui.html",
		"dojo/on",
		"dojox/form/Uploader"], 
	function(declare, WidgetBase, TemplatedMixin, WFContentPane, template, on){
		return declare([WFContentPane, WidgetBase, TemplatedMixin], {
//			href:"index.html",
			
			templateString:template,
			postCreate: function(){
				this.inherited(arguments);
				console.log("uploadUI.js  postCreate");
			},
			init:function(){
				//When user click on "Upload" button
				var btn = dojo.byId("btn_upload");	
				console.log(btn);
				dojo.connect(btn, "onclick", this.sendFile);
				
				//When user select a file
				var btn_select = dijit.byId("file");
				dojo.connect(btn_select, "onChange", this.onSelectFile);
			},
			sendFile : function() {
				console.log("111");
				dojo.require("dojo.io.iframe");
				dojo.io.iframe.send({
					form : "fileForm",
					url : "wf/Sample",
					method : "post",
					handleAs : "json",
					content : {
						"command" : "upload"
					},
					handle : function(data, ioArgs) {
						console.log("[wf]data:");
						console.log(data);
						return data;
					},
					error : function(response) {
						console.log("[wf]error:" + response);
					}
				});
			},
			onSelectFile: function(dataArray) {
				console.log(dataArray);
				wfArray = dataArray;
			}
		});
});
