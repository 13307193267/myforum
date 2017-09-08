<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../static/js/echarts.min.js" charset="utf-8"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js" charset="utf-8"></script>
</head>
<body>
<div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
    	$(function(){
    		console.log("毛超杰");
    		$.ajax({
    			url:'/myforum/balance/page',
    			type:'post',
    			success:function(data){
    				console.log(data.rows);
    				var mycars = new Array()
    				var mycars1 = new Array()
					 for ( var da in data.rows) {
						console.log(data.rows[da].user.username);
						 mycars[da]=data.rows[da].user.username;
						mycars1[da]=data.rows[da].balance; 
					 }
					 console.log(mycars);
				      // 基于准备好的dom，初始化echarts实例
				        var myChart = echarts.init(document.getElementById('main'));

				        option = {
				        	    title : {
				        	        text: '某站点用户访问来源',
				        	        subtext: '纯属虚构',
				        	        x:'center'
				        	    },
				        	    tooltip : {
				        	        trigger: 'item',
				        	        formatter: "{a} <br/>{b} : {c} ({d}%)"
				        	    },
				        	     legend: {
				        	        orient: 'vertical',
				        	        left: 'left',
				        	        data: [mycars[0],mycars[1],mycars[2]]
				        	    }, 
				        	    series : [
				        	        {
				        	            name: '访问来源',
				        	            type: 'pie',
				        	            radius : '55%',
				        	            center: ['50%', '60%'],
				        	            data:[
				        	                  {value:mycars1[0],name:mycars[0]},
				        	                  {value:mycars1[1],name:mycars[1]},
				        	                  {value:mycars1[2],name:mycars[2]}
				        	            ],
				        	            itemStyle: {
				        	                emphasis: {
				        	                    shadowBlur: 10,
				        	                    shadowOffsetX: 0,
				        	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				        	                }
				        	            }
				        	        }
				        	    ]
				        	};

				        // 使用刚指定的配置项和数据显示图表。
				        myChart.setOption(option); 
    			}
    		});
    	});
    
  
    </script>
</body>
</html>