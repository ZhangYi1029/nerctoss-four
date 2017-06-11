
function del(){
	var rowArr=$('#tt').datagrid('getSelections');
	if(rowArr[0]!=null){
		var json=$.toJSON(rowArr);
		$.ajax({
			type : "DELETE",
			url : "../account/del",
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


//在修改是先显示数据

function upshow(){
	var row=$('#tt').datagrid('getSelected');
			var upid=row.id;
			var uri="../account/"+upid;
			$.ajax({
				type : "GET",
				url : uri,
				//data : json,
				contentType : "application/json",
				async : true,
				success : function(msg) {	
				$('#b1').textbox('setValue', msg.name);
				$('#b2').textbox('setValue', msg.idCard)
				$('#b3').textbox('setValue', msg.gender)
				$('#b4').textbox('setValue', msg.number)
				$('#b5').textbox('setValue', msg.password)
				$('#b6').textbox('setValue',msg.phone)
				$('#b7').textbox('setValue', msg.address)
				$('#b8').textbox('setValue', msg.qq)
				$('#b9').textbox('setValue', msg.postcode)
				$('#b10').textbox('setValue', msg.paymethod)
				$('#b11').combobox('setValue', msg.state)
				}
			})
	
}

function update(){
	var row=$('#tt').datagrid('getSelected');
	
		var password=$('#b5').textbox('getValue');
		var phone=$('#b6').textbox('getValue');
		var state=$('#b11').combobox('getValue');
		var upid=row.id;
		var is1=$('#b5').textbox("isValid")
		var is2=$('#b6').textbox("isValid")
		console.info(password)
		if(is1&&is2&&state!=null){
			var account={id:upid,password:password,phone:phone,state:state}
			var json=$.toJSON(account);
			$.ajax({
				type : "PUT",
				url : "../account/update",
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


//增加账务账号 
function save(){
	var name=$('#a1').textbox('getValue');
	var idCard=$('#a2').textbox('getValue');
	//var gender=$("input[name='gender1']").val();
	var gender=$("input[name='gender1']:checked").val();
	
	var number=$('#a3').textbox('getValue');
	var password=$('#a4').textbox('getValue');
	var phone=$('#a5').textbox('getValue');
	var address=$('#a6').textbox('getValue');
	var qq=$('#a7').textbox('getValue');
	var postcode=$('#a8').textbox('getValue');
	var paymethod=$('#a9').textbox('getValue');
	
	var ist1=$('#a1').textbox("isValid")
	var ist2=$('#a2').textbox("isValid")
	var ist3=$('#a3').textbox("isValid")
	var ist4=$('#a4').textbox("isValid")
	var ist5=$('#a5').textbox("isValid")
	var ist7=$('#a7').textbox("isValid")
	var ist8=$('#a8').textbox("isValid")
	if(ist1&&ist2&&ist3&&ist4&&ist5&&ist7&&ist8&&address.length!=0&&gender.length!=0&&paymethod.length!=0){
					var account= {name:name,idCard:idCard,gender:gender,number:number,password:password,phone:phone,address:address,qq:qq,postcode:postcode,paymethod:paymethod}
					var json = $.toJSON(account);
					$.ajax({
						type : "POST",
						url : "../account/save",
						data : json,
						contentType : "application/json",
						async : true,
						success : function(data) {
						alert(data.msg)
						$('#add').dialog('close');
						refresh();
						}

					});
					
	
	}else{
		alert("不能为空")
	}
	
	}
//给对应的下一个加点击事件
/*$(function(){
    $("input",$("#a3").next("span")).click(function(){
    	//yanzhen1();
    });
})

$(function(){
	$("input",$("#a4").next("span")).click(function(){
    	yanzhen2();
    });
})

$(function(){
    $("input",$("#a6").next("span")).click(function(){
    	yanzhen3();
    });
})
$(function(){
    $("input",$("#a5").next("span")).click(function(){
    	yanmi();
    });
})
*/
 
//验证密码、电话号码、邮编
/*function yanmi(){
	$('#mi').html("")
		var password=$('#a4').val();
	 // var password = $("#a4").textbox('getValue');
	//console.info($("#a4").textbox('getValue'));
	//console.info(password);
	if(password!=null){
		var reg=/^[a-zA-Z0-9]{6,15}$/;
		if(!reg.test(password)){
			$('#mi').html("密码为6-14位的数字或字母")
			return false;
		}else{
			$('#mi').html("")
			return true;
		}
	}else{
		$('#mi').html("请输入密码")
		return false;
	}	
}*/

/*$(function(){
    $("input",$("#a8").next("span")).click(function(){
    	yanqq();
    });
})*/
/*function yanqq(){
	$('#q').html("")
	var qq=$('#a7').val();
	if(qq!=null){
		var reg=/^[a-zA-Z0-9]{6,12}$/;
		if(!reg.test(qq)){
			$('#q').html("请输入正确的QQ号")
			return false;
		}else{
			$('#mi').html("")
			return true;
		}
	}else{
		$('#q').html("请输入QQ号")
		return false;
	}	
}*/


/*$(function(){
    $("input",$("#a9").next("span")).click(function(){
    	yanyou();
    });
})*/

/*function yanyou(){
	$('#you').html("")
	var postcode=$('#a8').val();
	if(postcode!=null){
		var reg=/^[0-9]{6}$/;
		if(!reg.test(postcode)){
			$('#you').html("请输入正确的邮编")
			return false;
		}else{
			$('#you').html("")
			return true;
		}
	}else{
		$('#you').html("请输入邮编")
		return false;
	}	
}*/
/*function name(){
	var name=$('#a1').val();
	var gender=$("input[name='gender1']").val();
	
	var address=$('#a6').val();
	if(name!=null&&gender!=null&&address!=null){
		return true;
	}else{
		$.messager.alert("不能为空");
		return false;
	}
}*/


//验证身份证号码、账号、电话号码
/*function yanzhen1(){
	$('#cd').html("")
	var idCard=$('#a2').val();
	if(idCard!=null){
		var account={idCard:idCard};
		var json = $.toJSON(account);
		$.ajax({
			type:'POST',
			url : "../account/test",
			data : json,
			contentType : "application/json",
			async : true,
			success : function(data) {
				if(!data.status){
					
				var	reg=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
					if(!reg.test(idCard)){
						$('#cd').html("身份证号错误，请输入正确的")
						return false;
					}else{
						$('#cd').html("")
						return true;
					}
					
				}else{
					$('#cd').html("身份证号已经存在，请重新输入")
					return false;
				}
			}
		})
	}else{
		$('#cd').html("请输入身份证号码，不能为空")
		return false;
	}
}*/

/*function yanzhen2(){
	$('#nu').html("")
	var number=$('#a3').val();
	if(number!=null){
		var account={number:number};
		var json = $.toJSON(account);
		$.ajax({
			type:'POST',
			url : "../account/test",
			data : json,
			contentType : "application/json",
			async : true,
			success : function(data) {
				if(!data.status){
					var reg=/^[a-zA-Z0-9]{6,15}$/
					if(!reg.test(number)){
						$('#nu').html("账号必须为6-14位的数字或字母")
						return false;
					}else{
						$('#nu').html("")
						return true;
					}
					
				}else{
					$('#nu').html("账务账号已经存在，请重新输入")
					return false;
				}
			}
		})
	}else{
		$('#nu').html("请输入账号")
		return false;
	}
}*/

/*function yanzhen3(){
	$('#hp').html("")
	var phone=$('#a5').val();
	if(phone!=null){
		var account={phone:phone};
		var json = $.toJSON(account);
		$.ajax({
			type:'POST',
			url : "../account/test",
			data : json,
			contentType : "application/json",
			async : true,
			success : function(data) {
				if(!data.status){
					 var reg=/^((13)|(15)|(18))[0-9]{9}$/;
					 if(!reg.test(phone)){
						 $('#hp').html("电话号码不正确，请重新输入")
						 return false;
					 }else{
						 $('#hp').html("")
						 return true;
					 }
					
					return true;
				}else{
					$('#hp').html("电话号码已经存在，请重新输入")
					return false;
				}
	}
		})
	}else{
		$('#hp').html("请输入电话号码")
		return false;
	}
}*/

$.extend($.fn.textbox.defaults.rules,{
	idCard: {
        validator : function(value, param) {
        	$('#cd').html("")
        	var	reg=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
        	if(!reg.test(value)){
        		$('#cd').html("身份证号错误，请输入正确的")
        	//	 $.fn.validatebox.defaults.rules.name.message ="请输入正确的身份证！";
        		 return false;
        	}
        		var haha=true;
        		var account={idCard:value};
        		var json = $.toJSON(account);
            $.ajax({
                type : 'POST',
                url : '../account/test',
                data : json,
                contentType : "application/json",
                async : true,
                success : function(data) {
        			haha=data.status
        			}
            })
            if(haha==false){
            	$('#cd').html("此身份证号码已存在！")
	        	  return false;
	          }
           			$('#cd').html("")
		           return true; 
        	},
        	message : '请输入身份证号'
  	
    },
    numberTx:{
    	validator : function(value, param) {
    		 $('#nu').html("")
    		var reg=/^[a-zA-Z0-9]{6,15}$/;
        	if(!reg.test(value)){
        		$('#nu').html("账号必须为6-14位的数字或字母")
        	//	$.fn.validatebox.defaults.rules.name.message ="请输入正确的账务账号！";
        		 return false;
        	}
        		var haha=true;
        		var account={number:value};
        		var json = $.toJSON(account);
         $.ajax({
                type : 'POST',
                url : '../account/test',
                data : json,
                contentType : "application/json",
                async : true,
                success : function(data) {
        			haha=data.status
        			}
            })
            if(haha==false){
            	 $('#nu').html("此账务账号已存在！")
	        	  return false;
	          }
         			$('#nu').html("")
		           return true; 
           
        	},
        	message : '请输入业务账号'
    },
    phoneTx:{
    	validator : function(value, param) {
     	   $('#hp').html("")
    		var reg=/^((13)|(15)|(18))[0-9]{9}$/;
        	if(!reg.test(value)){
        		$('#hp').html("电话号码不正确，请重新输入")
        	//	$.fn.validatebox.defaults.rules.name.message ="请输入正确的电话号码！";
        		 return false;
        	}	
        		var haha=true;
        		var account={phone:value};
        		var json = $.toJSON(account);
           $.ajax({
                type : 'POST',
                url : '../account/test',
                data : json,
                contentType : "application/json",
                async : true,
                success : function(data) {
        			haha=data.status
        			}
            })
            if(haha==false){
            	$('#hp').html("此电话号码已存在！")
	        	  return false;
	          }
		           $('#hp').html("")
		           return true; 
           
        	},
        	message : '请输入电话号码'
	
    },
    phonexiuTx:{
    	validator : function(value, param) {
    		var reg=/^((13)|(15)|(18))[0-9]{9}$/;
    		 return reg.test(value);  
        	},
        	message : '请输入电话号码'
	
    },
    nameTx : {  
        validator : function(value, param) {  
            var reg = /^[\u4e00-\u9fa5]+$/i;  
            return reg.test(value);  
        },  
        message : "请输入中文"  
    },  
    mimaTx : {  
        validator : function(value, param) {  
            return /^[a-zA-z0-9]{6,15}$/.test(value);  
        },  
        message : "请输入6-14位数字或字母"  
    },
    qqTx:{
    	validator : function(value, param) {  
            return /^[0-9]{6,13}$/.test(value);  
        },  
        message : "请输入正确的QQ号" 
    },
    youbTx:{
    	validator : function(value, param) {  
            return /^[1-9]\d{5}$/.test(value);  
        },  
        message : "邮编必须长短不以0开端的6位数字" 
    }
});
