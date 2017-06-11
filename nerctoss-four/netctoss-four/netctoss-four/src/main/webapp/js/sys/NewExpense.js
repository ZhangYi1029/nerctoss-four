/*关闭添加成功后的两个对话框*/
	function closeDialog() {
		$('#add').dialog('close');
		$('#updateOk').dialog('close');
		$('#updateDiv').dialog('close');
	}

	/* 查询数据的方法 */
	function QueryData() {
		$("#tt").datagrid("load", {
			"name" : $("#tblQuery").find("input[name='name']").val(),
			"type" : $("#tblQuery").find("input[name='type']").val(),
			"state" : $("#tblQuery").find("input[name='state']").val()
		});
	}

	/* 清空查询框的方法 */
	function ClearQuery() {
		$('#nameQueryInp').textbox('clear');
		$('#typeQueryInp').textbox('clear');
		$('#stateQueryInp').textbox('clear');
	}

	$(function() {

		$('#tt').datagrid({
			title : '资费',
			width : 700,
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			//？
			url : '../expense/show',
			method : 'GET',
			//sortOrder: 'desc', //该方法用来设置排列的顺序
			remoteSort : false,
			idField : 'id',//数据的id属性是什么
			singleSelect : false,//是否单选 
			pagination : true,//分页控件是否显示
			rownumbers : true,//行号 是否显示
			toolbar : "#tb"
		});

		var p = $('#tt').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
			showRefresh : false
		});

		$('#durationInp').textbox({
			prompt : '只能输入数字',
			required : true,
			missingMessage : "请输入数字"
		});

		$('#riqi').textbox({
			prompt : '只能选择日期',
			required : true,
			missingMessage : "请选择日期"
		});

		$('#priceInp').textbox({
			prompt : '只能输入数字',
			required : true,
			missingMessage : "请输入数字"
		});

		$('#unitInp').textbox({
			prompt : '只能输入数字',
			required : true,
			missingMessage : "请输入数字"
		});

		$('#nameInp').textbox({
			prompt : '只能输入文本',
			required : true,
			missingMessage : "请输入文本"
		});

	});
	/* $('#add').dialog('open'); */

	function addlog() {
		$('#add').dialog('open');
	}

	function updatelog() {
		var updateObj = $('#tt').datagrid('getSelected');
		if (updateObj != null) {
			var nameHolder = updateObj.name;
			console.info(nameHolder);
			var introduceHolder = updateObj.introduce;
			$('#nameUpdateInp').textbox('setValue', nameHolder);
			$('#introduceUpdate').val(introduceHolder);
			$('#updateDiv').dialog('open');
		}
	}
	/*选择套餐时禁用无关输入框*/
	$(document).ready(function () {
		$("#typeSel").combobox({
				//需要传递两个参数(newVal,oldVal)
			onChange : function(n,o) {
				console.info(o);
				var type = n;
				switch (n) {
				case "包月":
					$("#priceInp").textbox({disabled : false});
					$("#unitInp").textbox({disabled : true});
					$("#durationInp").textbox({disabled : true});
					break;
				case "套餐":
					$("#priceInp").textbox({disabled : false});
					$("#durationInp").textbox({disabled : false});
					$("#unitInp").textbox({disabled : false});
					break;
				case "计时":
					$("#unitInp").textbox({disabled : false});
					$("#priceInp").textbox({disabled : true});
					$("#durationInp").textbox({disabled : true});
					break;
				}

			}

		});
	});
	/*添加资费信息*/
	function addExpense() {
		var expenseBean = {
			name : $('#nameInp').val(),
			duration : $('#durationInp').val(),
			price : $('#priceInp').val(),
			introduce : $('#introduceArea').val(),
			type : $('#typeSel').val(),
			unitPrice : $('#unitInp').val(),
			state : "暂停"
		};		
		var json = $.toJSON(expenseBean);
		validate();
		$.ajax({
			type : "POST",
			url : "../expense/addExpense",
			data : json,
			contentType : "application/json",
			async : true,
			success : function(data) {
				$('#updateOkLab').html(data.msg);
				$('#updateOk').dialog('open');
			}
		});
		refresh();
	}
	
	function validate(){
		var name = $('#nameInp').val();
		var json = $.toJSON(name);
		if(name!=null){
			$.ajax({
				type:"POST",
				url :"../expense/validate",
				data:json,
				contentType :"application/jsn",
				async:true,
				success :function(data){
					$("nameInp").next("span").html(data.msg);
				}
			});
		}
	}
	    /*删除功能*/
	function del() {
		var delArr = $('#tt').datagrid('getSelections');
		if (delArr[0] != null) {
			var json = $.toJSON(delArr);
			$.ajax({
				type : "DELETE",
				url : "../expense/delExpense",
				data : json,
				contentType : "application/json",
				async : true,
				success : function(data) {
					$('#updateOkLab').html(data.msg);
					$('#updateOk').dialog('open');
					refresh();
					delArr=null;
				}
			});

		}else if(delArr.length==0){
			alert("请选中至少一条记录");
		}
	}
	//修改记录
	function updateExpense() {
		var updateObj = $('#tt').datagrid('getSelected');
		
		if (updateObj != null) {
			
			var updateBean = {
				id : updateObj.id,
				

				name : $('#nameUpdateInp').val(),
				introduce : $('#introduceUpdate').val(),
			};
			var json = $.toJSON(updateBean);
			$.ajax({
				type : "PUT",
				url : "../expense/updateExpense",
				data : json,
				contentType : "application/json",
				async : true,
				success : function(data) {
					$('#updateOkLab').html(data.msg);
					$('#updateOk').dialog('open');
					refresh();
				}
			});
		}
	}

	/*刷新表*/
	function refresh() {
		$('#tt').datagrid('reload');
	}
	/*开通资费*/
	function drege() {
		var dregeArr = $('#tt').datagrid('getSelections');
		if (dregeArr[0] != null) {
			var json = $.toJSON(dregeArr);
			$.ajax({
				type : "POST",
				url : "../expense/dregeExpense",
				data : json,
				contentType : "application/json",
				async : true,
				success : function(data) {
					$('#updateOkLab').html(data.msg);
					$('#updateOk').dialog('open');
					refresh();
				}
			});
		}
	}
	
//	function validate(){
//		$("input",$("#nameInp").next("span")).blur(function(){
//		var expensename=$("#nameInp").val();
//		if(expensename==''){
//		    $("#validateNameSpan").html("用户名不能为空！");
//			}
//	    }
//	}