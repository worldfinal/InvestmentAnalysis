
define(["dojo/_base/declare", 
		"dijit/_WidgetBase", 
		"dijit/_TemplatedMixin", 
		"app/invest/WFContentPane/WFContentPane",
		"dojo/_base/lang",
		"dojo/dom-form",
		'dojo/string',
		"dojo/on",
		"dijit/registry",
		"dojo/text!./template/ui.html",
		"dojo/text!./template/result.html",
		"dojo/store/Memory"], 
	function(declare, WidgetBase, TemplatedMixin, WFContentPane, 
			lang, domForm, String, on, registry,
			template, resultHtml,
			Memory){
		return declare([WFContentPane, WidgetBase, TemplatedMixin], {
//			href:"index.html",
			templateString:template,
			postCreate: function(){
				this.inherited(arguments);
				on(this._submitButton, "click", lang.hitch(this, this.sendRequest));
				console.log(this._submitButton);
			},
			init:function(){
				var _self = this;
				console.log("[base1.js]init completed");
			},
			sendRequest:function() {
				var _self = this;
				console.log("sendRequest");
				var form = document.forms.base1_form;
				var obj = {};
				lang.mixin(obj, domForm.toObject(form));
				console.log(obj);
				var xhrArgs = {
					url:"wf/analysis/base1",
					handleAs: "text",
					postData: dojo.toJson(obj),
					headers:{
						"Content-Type":"application/json"
					},
					load:function(data) {
						wf = data;
						console.log(data);
						_self.updateResult(data);
					},
					error:function(response) {
						console.log("[listFiles]error:" + response);
					}
				}
				console.log(xhrArgs);
				var deferred = dojo.xhrPost(xhrArgs);
				console.log("sendRequest done");
			},
			updateResult:function(data) {
				if (data == null) {
					console.log("updateResult::fail");
					return;
				}
				var obj = dojo.fromJson(data);
				console.log(obj);
				var str = String.substitute(resultHtml, obj);
				dojo.byId("base1_result").innerHTML = str;
			}
		});
});
