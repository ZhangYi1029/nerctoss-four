$.extend($.fn.textbox.defaults.rules, { 
	 numberTx:{
	    	validator : function(value, param) {
	    		 $('#nun').html("")
	    		 
	    		var reg=/^[a-zA-Z0-9]{6,15}$/;
	        	if(!reg.test(value)){
	        		$('#nun').html("")
	        		//$.fn.textbox.defaults.rules.name.message ="请输入正确的账务账号！";
	        		 return false;
	        	} 	
	        	var haha=true;
	        	var business={number:value}
	        	var json = $.toJSON(business);
	           $.ajax({
	                type : 'POST',
	                url : '../business/test',
	                data :json,
	                contentType : "application/json",
	                async :false,
	                success : function(data) {
	        			haha=data.status
	        			}
	            })
	        	
	          if(haha==false){
	        	  $('#nun').html("此账号已重复") 
	        	  return false;
	          }
	        	  $('#nun').html("") 
		           return true; 
	        
	        	},
	        	message : '请输入6-14位的数字或字母'
	    },
    number : {  
        validator : function(value, param) { 
        	var reg=/^[a-zA-Z0-9]{6,15}$/;
            return  reg.test(value);  
        },  
        message : "请输入6-14位的数字或字母"  
        
    },
    fuwuTx : {  
        validator : function(value, param) { 
        	var reg=/^[0-9]{3}\.[0-9]{3}\.[0-9]{3}\.[0-9]{3}$/;
            return  reg.test(value);  
        },  
        message : "请输入xxx.xxx.xxx.xxx这种格式的实验室Ip"  
        
    },  
    chinese : {  
        validator : function(value, param) {  
            var reg = /^[\u4e00-\u9fa5]+$/i;  
            return reg.test(value);  
        },  
        message : "请输入中文"  
    },  
    checkLength: {  
        validator: function(value, param){  
            return param[0] >= get_length(value);  
        },  
        message: '请输入最大{0}位字符'  
    },  
    specialCharacter: {  
        validator: function(value, param){  
            var reg = new RegExp("[`~!@#$^&*()=|{}':;'\\[\\]<>~！@#￥……&*（）——|{}【】‘；：”“'、？]");  
            return !reg.test(value);  
        },  
        message: '不允许输入特殊字符'  
    } ,     
    englishLowerCase  : {// 验证英语小写  
        validator : function(value) {  
            return /^[a-z]+$/.test(value);  
        },  
        message : '请输入小写字母'  
    }

}); 
$.extend($.fn.validatebox.defaults.rules, {
    /*必须和某个字段相等*/
    equalTo: { validator: function (value, param) { return $(param[0]).val() == value; }, message: '字段不匹配' }
   });

$(document).ready(  
        function(){  
            $.ajax({  
            	type : "GET",
        		url : "../business/showstate",
        		contentType : "application/json",
        		async : true,
             success:function(data){  
            	 var combo2 =[{'number':'','id':''}];  
                 for(var i=0;i<data.length;i++){  
                 combo2.push({"number":data[i].number,"id":data[i].id});  
                 }  
             $("#a6").combobox("loadData",combo2);   
             }  
            });  
 }); 

$(document).ready(  
        function(){  
            $.ajax({  
            	type : "GET",
        		url : "../business/showexpense",
        		contentType : "application/json",
        		async : true,
             success:function(data){  
            	 var combo =[{ 'name':'','id':''}];  
                 for(var i=0;i<data.length;i++){  
                 combo.push({"name":data[i].name,"id":data[i].id});  
                 }
             $("#a5").combobox("loadData",combo);  
             $("#b4").combobox("loadData",combo);    
             }  
            });  
 }); 

function save(){
	var number=$('#a1').textbox('getValue');
	var pwd=$('#a2').val();
	var nextpwd=$('#a3').val();
	var serviceIp=$('#a4').textbox('getValue');
	var expenseId=$('#a5').combobox('getValue');
	var accountId=$('#a6').combobox('getValue');
	var expense={id:expenseId}
	var account={id:accountId}
	var business={number:number,password:pwd,serviceIp:serviceIp,expense:expense,account:account};
	var is1=$('#a1').textbox("isValid")
	var is2=$('#a2').validatebox("isValid")
	var is3=$('#a3').validatebox("isValid")
	var is4=$('#a4').textbox("isValid")
	if(is1&&is2&&is3&&is4&&expenseId!=null&&accountId!=null){
		var json = $.toJSON(business);
		$.ajax({
			type : "POST",
			url : "../business/save",
			data : json,
			contentType : "application/json",
			async : true,
			success : function(data) {
			alert(data.msg)
			$('#add').dialog('close');
			refresh();
			}

		});
		
	}
}
function updateShow(){
	var row=$('#tt').datagrid('getSelected');
	var upid=row.id;
	var uri="../business/"+upid;
	$.ajax({
		type : "GET",
		url : uri,
		//data : json,
		contentType : "application/json",
		async : true,
		success : function(msg) {	
		$('#b1').textbox('setValue', msg.number);
		$('#b2').textbox('setValue', msg.password)
		$('#b3').textbox('setValue', msg.serviceIp)
		$('#b4').combobox('setValue', msg.expense.id)
		$('#b5').textbox('setValue', msg.account.number)
		$('#b6').combobox('setValue', msg.state)
		}
	})
	
}
function update(){
	var row=$('#tt').datagrid('getSelected');
	var upid=row.id;
	var password =$('#b2').textbox('getValue');
	console.info(password)
	var expenseId=$('#b4').combobox('getValue');
	var state=$('#b6').combobox('getValue');
	var is=$('#b2').textbox("isValid")
	if(is&&expenseId!=null&&state!=null){
		var expense={id:expenseId};
		var business={id:upid,password:password,state:state,expense:expense}
		var json=$.toJSON(business);
		$.ajax({
			type : "PUT",
			url : "../business/update",
			data : json,
			contentType : "application/json",
			async : true,
			success : function(data) {
			alert(data.msg)
			$('#update').dialog('close'); 
			refresh();
			}
		})
		
	}else{
		alert("请正确修改")
	}	
}

function del(){
	var rowArr=$('#tt').datagrid('getSelections');
	if(rowArr[0]!=null){
		var json=$.toJSON(rowArr);
		$.ajax({
			type : "DELETE",
			url : "../business/del",
			data : json,
			contentType : "application/json",
			async : true,
			success : function(data) {
			alert(data.msg)
			refresh(); 
			}
		})
		
	}else{
		alert("请选择你要删除的对象")
	}
	
}