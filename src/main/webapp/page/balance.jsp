<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生活百事通</title>
<script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js" charset="utf-8"></script>
<link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="../js/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
</head>
<script type="text/javascript">


$(document).ready(function() {
	page_init();
	$("#update_ss").hide();
});
function page_init() {

	$("#dataTable").datagrid({
		url : "../balance/page", //actionName
		queryParams : {
			pageNumber : 1,
			pageSize : 20
		},//查询参数
	      title:'用户信息',
            iconCls:'icon-man',//图标 
            fit: false,//自动大小 
		loadMsg : "正在加载数据...",
		striped:true, //则把行条纹化。（即奇偶行使用不同背景色）
		singleSelect:true,//只允许选中一行
		rownumbers : true,//查询结果在表格中显示行号
		pageNumber : 2, //初始页码，得在这设置才效果，pagination设置没效果。
		pagination : true,
		columns:[[
				 	{field:'user',title:'姓名',width:120,align:'center',
						 formatter:function(value, row, index){
					        return value.username;
					    }
					} , 
			        {field:'balance',title:'余额',width:120},
			        {field:'yusuan',title:'预算',width:120},    
			        {field:'createtime',title:'创建时间',width:120,
			        	formatter : function(value, row, index) 
			        	{
							var unixTimestamp = new Date(value);
							return unixTimestamp.toLocaleDateString()+" "+unixTimestamp.toLocaleTimeString();
						}	
			        },
			        {field:'updatetime',title:'修改时间',width:120,
			        	formatter : function(value, row, index) {
							var unixTimestamp = new Date(value);
							return unixTimestamp.toLocaleDateString()+" "+unixTimestamp.toLocaleTimeString();
						}	
			        },
			        {field:'remarks',title:'备注',width:120},   
			    ]],
			    toolbar: [{//在dategrid表单的头部添加按钮
	                text: "添加",
	                iconCls: "icon-add",
	                handler: function () {
	                	$('#dd').dialog({
							title : '添加收支',
							iconCls : 'icon-sz',//图标 
							width : 500,
							height : 400,
							closed : false,
							cache : false,
							modal : true
						});
	                }
	            }, '-', {//'-'就是在两个按钮的中间加一个竖线分割，看着舒服
	                text: "删除",
	                iconCls: "icon-remove",
	                handler: function () {
	                	f_delete();
	                }
	            }, '-', {
	                text: "修改",
	                iconCls: "icon-edit",
	                handler: function () {
	                	f_update();
	                }
	            }, '-', {
	                text: "保存",
	                iconCls: "icon-save",
	                handler: function () {
	                    $("#dg").datagrid('endEdit', editFlag);
	                }
	            }, '-', {
	                text: "撤销",
	                iconCls: "icon-redo",
	                handler: function () {
	                    editFlag = undefined;
	                    $("#dg").datagrid('rejectChanges');
	                }
	            }, '-'],
	            onAfterEdit: function (rowIndex, rowData, changes) {//在添加完毕endEdit，保存时触发
	                console.info(rowData);//在火狐浏览器的控制台下可看到传递到后台的数据，这里我们就可以利用这些数据异步到后台添加，添加完成后，刷新datagrid
	                editFlag = undefined;//重置
	            }, onDblClickCell: function (rowIndex, field, value) {//双击该行修改内容
	                if (editFlag != undefined) {
	                    $("#dg").datagrid('endEdit', editFlag);//结束编辑，传入之前编辑的行
	                }
	                if (editFlag == undefined) {
	                    $("#dg").datagrid('beginEdit', rowIndex);//开启编辑并传入要编辑的行
	                    editFlag = rowIndex;
	                }
	            }
	        });
	
	    
	//分页控件
	//如果后端返回的json的格式直接是data={total:xx,rows:{xx}},不需要设置loadFilter了，
	//如果有多层封装，比如data.jsonMap = {total:xx,rows:{xx}}，则需要在loadFilter处理一下。
	/*
	loadFilter: function(data){
	    if(data.jsonMap) {
	        return data.jsonMap;
	    }
	}*/
	

	var p = $('#dataTable').datagrid('getPager');
	$(p).pagination({
		pageSize : 20,//每页显示的记录条数，默认为10
		pageList : [ 10, 20, 30, 40, 50 ,100 ],//可以设置每页记录条数的列表
		beforePageText : '第',//页数文本框前显示的汉字
		afterPageText : '页        共 {pages} 页',
		displayMsg : '共 {total} 条记录',
		onSelectPage : function(pageNumber, pageSize) {//分页触发
			find(pageNumber, pageSize);
		}
	});
	function f_update(){

		var grid = $("#dataTable").datagrid('getSelected');
		if(grid){
			var param = {};
	    	param.id = grid.id;
	    	$("#update_ss").dialog({
	    		title : '修改',
				iconCls : 'icon-man',//图标 
				width : 500,
				height : 400,
				closed : false,
				cache : false,
				modal : true
	    	});
			$('#submit').click(function() {
				var yusuan = $('#yusuan').val();
				var remarks = $('#remarks').val();
				var remarks = $('#balance').val();
			
				/* if (shouru == '') {
					alert('收入如果不填写会默认为 0');
					$('#shouru').val() = 0;
					return false;
				}
				if (zhichu == '') {
					alert('支出如果不填写会默认为 0');
					$('#zhichu').val() = 0;
					return false;
				} */
				
				$.ajax({
					url : '../balance/upd',
					type : 'post',
					/* dataType:'json', */
					data : {
						/* startTime:$('#startTime').val(),
						endTime:$('#endTime').val(), 
						shouru : $('#shouru').val(),
						zhichu : $('#zhichu').val(),*/
						yusuan : $('#yusuan').val(),
						remarks : $('#remarks').val(),
						balance : $('#balance').val()
						
					},
					success : function(data) {
						localStorage.clear();
						location.href = 'balance.jsp';
					},
					error : function() {
						/* alert("添加失败");
						location.href = 'statementOfBill.jsp'; */
					}
				});
			});
		}else{
			$.messager.alert('消息','请选择一行');    
		}
	}
	
	function f_delete() {
		var grid = $('#dataTable').datagrid('getSelected');
		if(grid){
			var param = {};
	    	param.id = grid.id;
			$.messager.confirm('确认','您确认想要删除记录吗？',function(grid){   
			    if (grid){ 
			    	$.ajax({
						url : '../balance/del',
						type:'post',
						data : param,
						success : function() {
							$.messager.alert('消息','删除成功');
							$('#dataTable').datagrid('load');
						},
						error : function(message) {
							$.messager.alert('消息','删除不成功');   
						}
					});
			    }   
			});
		}else{
	    	$.messager.alert('消息','请选择一行');    
	    } 
	}

}

function find(pageNumber, pageSize) {
	$("#dataTable").datagrid('getPager').pagination({
		pageSize : pageSize,
		pageNumber : pageNumber
	});//重置
	$("#dataTable").datagrid("loading"); //加屏蔽
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../balance/page",
		data : {
			pageNumber : pageNumber,
			pageSize : pageSize
		},
		success : function(data) {
			$("#dataTable").datagrid('loadData', data);
			$("#dataTable").datagrid("loaded"); //移除屏蔽
		},
		error : function(err) {
			$.messager.alert('操作提示', '获取信息失败...请联系管理员!', 'error');
			$("#dataTable").datagrid("loaded"); //移除屏蔽
		}
	});

}
</script>
<body>
	<table id="dataTable">
	<div id="dd" href="sh.html"></div>
		<div id="update_ss">
			<form>
			<!-- <div>
		<label>开始时间:</label> <input type="text" class="easyui-datebox"
			editable="false" id="startTime" /> &emsp;&emsp;<label>结束时间:</label>
		<input type="text" class="easyui-datebox" editable="false"
			id="endTime" />
	</div> -->
				<!-- 	<div>
		<br /> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <label>余额:</label> <input
			class="easyui-textbox" type="text" id="balance" />
	</div>
	<div>
		<br />&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<label>支出:</label> <input
			class="easyui-textbox" type="text" id="zhichu" />
	</div> -->
				<div>
					<br /> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<label>余额:</label> <input
						class="easyui-textbox" type="text" name="name" id="balance" />
				</div>

				<div>
					<br /> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<label>预算:</label> <input
						class="easyui-textbox" type="text" name="name" id="yusuan" />
				</div>
				<div>
					<br /> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<label>备注:</label><br />
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<textarea style="height: 100px; width: 250px" id="remarks"></textarea>
					<!-- <input
			style="height: 100px; width: 250px; padding: 20px; margin: 20px; font-size: 36px;"
			class="easyui-textbox" type="text" id="neirong" /> -->

				</div>
				<div>
					<br />
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <input type="submit"
						value="提交" id="submit">
				</div>
			</form>
		</div>
	</table>
</body>
</html>