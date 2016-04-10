
define(["dojo/_base/declare", 
		"dijit/_WidgetBase", 
		"dijit/_TemplatedMixin", 
		"app/invest/WFContentPane/WFContentPane",
		'dojo/string',
		"dojo/text!mywidget/listfile/template/filetable.html",
		'dojo/text!mywidget/listfile/template/download.html',
		'dojo/text!mywidget/listfile/template/columnChecked.html',
		'dojo/text!mywidget/listfile/template/columnUnchecked.html'], 
	function(declare, WidgetBase, TemplatedMixin, WFContentPane, 
			String, template, downloadHtml, columnCheckedHtml, columnUncheckedHtml){
		return declare([WFContentPane, WidgetBase, TemplatedMixin], {
//			href:"index.html",
			description: "",
			templateString:template,
			dataArr:null,
			grid:null,
			profileGrid:null,
			focusHandler:null,
			linkHandler:[],
			checkboxHandler:[],
			isGridInit:false,
			postCreate: function(){
			},
			init:function(){
				var _self = this;
				dojo.connect(dojo.byId("btn_refresh_list_file"), "onclick", dojo.hitch(this, this.listFiles));
				dojo.connect(this, "onShow", dojo.hitch(this, this.listFiles));
//				this.listFiles();
			
				
			/*	var btn = dojo.byId("btn_upload");	//"Upload" button
				console.log(btn);
				dojo.connect(btn, "onclick", this.sendFile);
				
				var ful = dijit.byId("file");
				dojo.connect(ful, "onChange", this.updateTable);*/
				console.log("[listfile.js]init completed");
			},
			listFiles:function() {
				var _self = this;
				var xhrArgs = {
					url:"servlet/FileOperationServlet",
					handleAs: "json",
					content: {"command":"list"},
					load:function(data, ioArgs) {
						if (data.response == null || data.response.retCode == "E01") {
							console.log("Logon error?" + data.response.retCode);
							dg.show();
						}
						_self.dataArr = data.response;
						_self.updateGrid(data.response);						
		//				_self.test();
					},
					error:function(response) {
						console.log("[listFiles]error:" + response);
					}
				}
				var deferred = dojo.xhrPost(xhrArgs);
				console.log("listFiles done");
			},
			updateGrid:function(dataArray) {
				var _self = this;
				require(['dojo/_base/lang', "dojox/grid/DataGrid", "dojo/data/ItemFileWriteStore", 
				         "dojo/query", 'dojo/domReady!'], 
					function(lang, DataGrid, ItemFileWriteStore,
							query){
					var data = {
							   identifier: 'id',
							   items: []
							};
					
					var dataList = [];
					for (var i = 0; i < dataArray.list.length; i++) {
						var obj = {
							index:i,
							idx:dataArray.list[i].id,
							name:dataArray.list[i].name,
							size:dataArray.list[i].size,
							unit:"B",
							uploaddate:dataArray.list[i].uploadDate,
							owenerName:dataArray.list[i].owenerName
						};
						if (dataArray.list[i].size < 1000) {
							
						} else if (dataArray.list[i].size < 1000000) {
							obj.size /= 1000;
							obj.unit = "K";
						} else{
							obj.size /= 1000000;
							obj.unit = "M";
						}
						dataList.push(obj);
						data.items.push(lang.mixin({ id: i+1 }, dataList[i]));
					}
					console.log(data.items);
						
					var store = new ItemFileWriteStore({data: data});
					var layout = [[
						{'name': 'ID', 'field': 'index', 'width': '40px'},
						{'name': 'File Name', 'field': 'name', 'width': '30%'},
						{'name': 'File Size', 'field': 'size', 'width': '15%'},
						{'name': '上传日期', 'field': 'uploaddate', 'width': '20%'},
						{'name': '上传者', 'field': 'owenerName', 'width': '15%'},
						{'name': '下载链接', 'field':'idx', 'width':'20%', formatter:_self.formatDownloadLink}
					]];
					
					if (_self.grid != null && _self.grid != undefined) {
						_self.grid.destroy();
					}
							
					_self.grid = new DataGrid({
						id: 'gridDiv',
						store: store,
						structure: layout,
						rowSelector: '20px'},
						document.createElement('div'));
					_self.grid.placeAt("grid_listFile");
					_self.grid.startup();
					
					//初始化后，激活或者点击等，则开始初始化下载链接
					_self.focusHandler = dojo.connect(_self.grid, "onFocus", function(){
		//				console.log("grid.onFocus");
						console.log("onFocus");
						_self.updateDownloadLink();
						_self._parseAllItem(_self.id);
					});
					_self.focusHandler = dojo.connect(_self.grid, "onBlur", function(){
						console.log("onBlur");
			//			_self.isGridInit = false;
			//			_self.updateDownloadLink();
					});
					_self.focusHandler = dojo.connect(_self.grid, "onHeaderCellClick", function(){
						console.log("onHeaderCellClick");
						_self.isGridInit = false;
						_self.updateDownloadLink();
						_self._parseAllItem(_self.id);
					});
					dojo.connect(_self.grid, "onCellClick", dojo.hitch(_self, _self.onClickFileCell));
					_self._parseAllItem(_self.id);
	//				console.log("connect (grid, onFocus);");
				});
			},
			onClickFileCell:function(e) {
				evt = e;
				var _self = this;
				var div = dojo.byId("div_fileInfo");
				var fileName = _self.grid.store.getValue(_self.grid.getItem(evt.rowIndex), "name");
				div.innerHTML = fileName;
				var fileId = _self.grid.store.getValue(_self.grid.getItem(evt.rowIndex), "idx");
	//			console.log("you click on the file ID = " + fileId);
				_self.listProfiles(fileId);
			},
			updateDownloadLink:function() {
				var _self = this;
				var i;
				if (_self.linkHandler.length > 0) {
					for (i = 0; i < _self.linkHandler.length; i++) {
						dojo.disconnect(_self.linkHandler[i]);
					}
				}
				_self.linkHandler = [];
				
				var arr = dojo.query("#grid_listFile a");
				for (i = 0; i < arr.length; i++) {
					var tmpObj = {
						idx:_self.grid.store.getValue(_self.grid.getItem(i), "idx"),
						tmpClick:function(){
							_self.download(this.idx);
						}
					};
					var fun = dojo.hitch(tmpObj, "tmpClick");
					var h = dojo.connect(arr[i], "onclick", fun);
					_self.linkHandler.push(h);
				}
			},
			formatDownloadLink:function(idx) {	
				var obj = {
					id: idx
				};
				var rs = String.substitute(downloadHtml, obj);
				return rs;
			},
			download: function(id) {
				console.log("download: " + id);
				 require(  
			             [
			               "dojo/dom",  
			               "dojo/io/iframe"  
			               ],  
			             function(dom) {  
			            	 var exportIframeName = "downloadPdfIframe";   
			                 var iframe = dojo.io.iframe.create(exportIframeName);  
			                 var url = encodeURI("servlet/FileDownloadServlet?id=" + id);   
			                 dojo.io.iframe.setSrc(iframe, url, true);  
			             });  
				console.log("download done");
			},
			listProfiles: function(fileId) {
				var _self = this;
				var xhrArgs = {
					url:"servlet/ListProfilesServlet",
					handleAs: "json",
					content: {"command":"listAuthorised", "fileId":fileId},
					load:function(data, ioArgs) {
						if (data.response == null || data.response.retCode == "E01") {
							console.log("Logon error?" + data.response.retCode);
							dg.show();
						}
						pfData = data;
						_self.updateProfileGrid(data.response);
					},
					error:function(response) {
						console.log("[listProfiles]error:" + response);
					}
				}
				var deferred = dojo.xhrPost(xhrArgs);
			},
			updateProfileGrid: function(dataArray) {
				var _self = this;
				require(['dojo/_base/lang', "dojox/grid/DataGrid", "dojo/data/ItemFileWriteStore", 'dojo/domReady!',
				         'dojo/string', "dojo/query"], 
					function(lang, DataGrid, ItemFileWriteStore,
							String, query, html){
					var data = {
						identifier: 'id',
						items: []
					};
					
					for (var i = 0; i < dataArray.list.length; i++) {
						var obj = {
							username:dataArray.list[i].username,
							nickName:dataArray.list[i].nickName,
							other:dataArray.list[i].other
						};
						if (dataArray.list[i].other == "true") {
							obj.checked = 1;
						}
						
						data.items.push(lang.mixin({ id: i+1 }, obj));
					}
		//			console.log(data.items);
						
					var store = new ItemFileWriteStore({data: data});
					var layout = [[
						{'name': 'ID', 'field': 'id', 'width': '40px'},
						{'name': 'username', 'field': 'username', 'width': '15%'},
						{'name': 'Nick Name', 'field': 'nickName', 'width': '15%'},
			//			{'name': "", 'field':'other', formatter:_self.formatProfileCheckbox}
						{'name': "权限", 'field':"checked", type:dojox.grid.cells.Bool}
					]];
					
					if (_self.profileGrid != null && _self.profileGrid != undefined) {
						_self.profileGrid.destroy();
					}
							
					_self.profileGrid = new DataGrid({
						id: 'ProfileGridDiv',
						store: store,
						structure: layout,
						rowSelector: '20px'},
						document.createElement('div'));
					_self.profileGrid.placeAt("grid_profiles");
					_self.profileGrid.startup();
					_self._parseAllItem(_self.id);
					
					_self.focusHandler = dojo.connect(_self.profileGrid, "onHeaderCellClick", function(){
						_self._parseAllItem(_self.id);
						_self.updateCheckboxHandler();
					});
					_self.focusHandler = dojo.connect(_self.profileGrid, "onCellClick", function(){
						_self._parseAllItem(_self.id);
						_self.updateCheckboxHandler();
					});
					
				});
				
				_self.updateCheckboxHandler();
			},
			updateCheckboxHandler:function() {
				var _self = this;
				var i;
				console.log(_self.checkboxHandler);
				for (i = 0; i < _self.checkboxHandler.length; i++) {
					dojo.disconnect(_self.checkboxHandler[i]);
				}
				
				_self.checkboxHandler = [];
				var arr = dojo.query("#ProfileGridDiv input[name=profileCheck]");
				for (i = 0; i < arr.length; i++) {
					var profileId = _self.profileGrid.store.getValue(_self.profileGrid.getItem(i), "id");
					var ownerObj = {
						id: profileId,
						index: i,
						method: function(){
							_self.onClickProfileCheckbox(this.index);
							
						}
					}
					var h = dojo.connect(arr[i], "onclick", dojo.hitch(ownerObj, "method"));
					_self.checkboxHandler.push(h);
				}
			},
			formatProfileCheckbox: function(other) {
				var _self = this;
				var obj = {
					id:1
				};
				if (other == "true") {
					return columnCheckedHtml;
				} else {
					return columnUncheckedHtml;
				}
			},
			onClickProfileCheckbox: function(idx) {
				var _self = this;
				
				var val = _self.profileGrid.store.getValue(_self.profileGrid.getItem(idx), "other");
				if (val == "true") {
					_self.profileGrid.store.setValue(_self.profileGrid.getItem(idx), "other", "false");
					console.log(idx + ": set false");
				} else {
					_self.profileGrid.store.setValue(_self.profileGrid.getItem(idx), "other", "true");
					console.log(idx + ": set true");
				}
				_self.profileGrid.startup();
			}
		});
});
