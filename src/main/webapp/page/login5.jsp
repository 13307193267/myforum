<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生活百事通</title>
<link href="../static/css/style.css" rel="stylesheet">
<link href="../static/css/bootstrap.css" rel="stylesheet">
<script src="../static/js/jquery-3.1.1.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
</head>
<body class='login-body'>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="pr-wrap">
                <div class="pass-reset">
                    <label>请输入你的注册邮箱</label>
                    <input type="email" placeholder="邮箱" />
                    <input type="submit" value="找回" class="pass-reset-submit btn btn-success btn-sm" />
                </div>
            </div>
            <div class="wrap">
                <p class="form-title">生活百事通</p>
                <form class="login">
                <input id="loginName" type="text" placeholder="用户名" />
                <input id="passWord" type="password" placeholder="密码" />
                <input id="login-do" type="submit" value="登录" class="btn btn-success btn-sm" />
                <div class="error-mess">
					<span class="error-icon"></span>
					<span id="error-message"></span>
				</div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="cendown">
                            <span id='reg'><a href="${base}/page/register.jsp">立即注册</a></span>
                            <span id='forgetpwd'><a href="javascript:void(0)" class="forgot-pass">忘记密码</a></span>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$('.error-mess').hide();
	})
	$('.forgot-pass').click(function(event) {
		     $(".pr-wrap").toggleClass("show-pass-reset");
		 }); 
	    $('.pass-reset-submit').click(function(event) {
	      $(".pr-wrap").removeClass("show-pass-reset");
	    });
		/* 登陆按钮 */
	$('#login-do').click(function(){
		window.event.returnValue = false;
		var $ln=$('#loginName').val();
		var $pw=$('#passWord').val();
		if($ln==''){
			$('.error-mess').show();
			$('#error-message').html("请输入用户名！");
			return false;
		}else if($pw==''){
			$('.error-mess').show();
			$('#error-message').html("请输入密码！");
			return false;
		}
		$.ajax({
			url:"login",
			data:{
				loginName:$ln,
				passWord:$pw
			},
			type:"post",
			success:function(data){
				if(data="success"){
					location.href='pages/main.jsp';
				}
			},
			error:function(){
				$('.error-mess').show();
				$('#error-message').html("帐户名或登录密码不正确，请重新输入!");
			}
		})
	});
</script>
</html>