<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404</title>
<style type="text/css">
	body {overflow-y:hidden;overflow-x:hidden;background:#f2f6ff;}
	#errorpage {width:1600px;margin:0 auto;position:relative;}
	#errorpage img {position:relative;top:30%;}
	#indexpage {color: #4991f5; display: inline-block; font-size: 16px; height: 19px; left: 892px; position: absolute; top: 500px; width: 34px; z-index: 9999;}
	#count_num {color: red; font-size: 16px; font-weight: bold; left: 756px; position: absolute; top: 500px; z-index: 9999;display:inline-block;width:9px;height:20px;}
</style>
</head>
<body>
	<div id="errorpage">
		<img src="img/404error.png">
		<a id="count_num"></a>
		<a id="indexpage" href="/"></a>
	</div>
</body>
</html>
<script type="text/javascript">
	var i = 5;
	var intervalid;
	intervalid = setInterval("count_down()", 1000);

	function count_down() {
		if (i == 0) {
			window.location.href = '${pageContext.request.contextPath}';
			clearInterval(intervalid);
		}
		document.getElementById("count_num").innerHTML = i;
		i--;
	}
</script>