<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="com.dxh.common.utils.*" %>
<%@ page language="java" import="com.dxh.po.*" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itheima" uri="http://baidu.com/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
	Page<Score> score=(Page<Score>)request.getAttribute("page");
	
%>
<!DOCTYPE>
<html>
<head>
	<title>学生学籍管理系统</title>
	<!-- 引入css样式文件 -->
	<!-- Bootstrap Core CSS -->
	<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" />
	<!-- MetisMenu CSS -->
	<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet" />
	<!-- DataTables CSS -->
	<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet" />
	<!-- Custom CSS -->
	<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet" />
	<!-- Custom Fonts -->
	<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
		type="text/css" />
	<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
		type="text/css" />
</head>

<body>
	<div>
		<div id="wrapper">
		<!-- 导航栏部分 -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=basePath%>student/list.action">学生学籍管理系统
					v3.0</a>
			</div>
			<!-- 导航栏右侧图标部分 -->
			<ul class="nav navbar-top-links navbar-right">
				<!-- 用户信息和系统设置 start -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i>
								用户：${USER_SESSION.username} </a></li>
						<li><a href="#"  data-toggle="modal"  data-target="#userEditDialog" onclick="editUser(${USER_SESSION.id})"><i class="fa fa-gear fa-fw"></i> 修改密码</a></li>
						<li class="divider"></li>
						<li><a
							href="${pageContext.request.contextPath }/logout.action"> <i
								class="fa fa-sign-out fa-fw"></i>退出登录
						</a></li>
					</ul></li>
				<!-- 用户信息和系统设置结束 -->
			</ul>
			<!-- 左侧显示列表部分 start-->
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="查询内容...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search" style="padding: 3px 0 3px 0;"></i>
									</button>
								</span>
							</div>
						</li>
						<li><a
							href="${pageContext.request.contextPath }/student/list.action"
							class="active"> <i class="fa fa-edit fa-fw"></i> 学生管理
						</a></li>
						<li><a 
							href="${pageContext.request.contextPath }/course/list.action" 
							class="active"> <i class="fa fa-edit fa-fw"></i> 课程管理
						</a></li>
						<li><a
							href="${pageContext.request.contextPath }/score/list.action"
							class="active"> <i class="fa fa-edit fa-fw"></i> 成绩管理
						</a></li>
					</ul>
				</div>
			</div>
			<!-- 左侧显示列表部分 end-->
		</nav>
		<!-- 学生列表查询部分  start-->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">成绩管理</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" method="post"
						action="${pageContext.request.contextPath }/score/list.action">
						<div class="form-group">
							<label for="Student">学生名字或学号</label> <input type="text"
								class="form-control" id="Student" value="${Student}"
								name="Student" />
						</div>
						<button type="submit" class="btn btn-primary">查询</button>
					</form>
				</div>
			</div>
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">学生信息列表</div>
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>学号</th>
									<th>姓名</th>
									<th>课程老师</th>
									<th>课程名</th>
									<th>成绩</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.rows}" var="row">
									<tr>
										<td>${row.student_id}</td>
										<td>${row.student_name}</td>
										<td>${row.course_tea}</td>
										<td>${row.course_name}</td>
										<c:if test="${row.score <60}">
											<td><font color="red">${row.score}</font></td>
										</c:if>
										<c:if test="${row.score>=60}">
											<td>${row.score}</td>
										</c:if>
										<c:if test="${row.score==null}">
											<td>&nbsp;</td>
										</c:if>
										<td style="text-align:center;"><a href="#" class="btn btn-primary btn-xs"
											data-toggle="modal" data-target="#scoreEditDialog"
											onclick="editScore(${row.score_id})">修改</a> 
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-md-12 text-right">
							<itheima:page
								url="${pageContext.request.contextPath }/score/list.action" />
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- 客户列表查询部分  end-->
	</div>
	<!-- 修改客户模态框 -->
	<div class="modal fade" id="scoreEditDialog" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改学生学籍信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_score_form">
						<input type="hidden" id="edit_student_id" name="student_id" />
						<input type="hidden" id="edit_score_id" name="score_id" />
						<div class="form-group">
							<label for="edit_studentName" class="col-sm-2 control-label">学生姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_studentName"
									placeholder="学生姓名" name="student_name" disabled="disabled"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_courseName" class="col-sm-2 control-label">课程名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_courseName"
									placeholder="课程名" name="course_name" disabled="disabled"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_score" class="col-sm-2 control-label">分数</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_score"
									placeholder="分数" name="score" />
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="updateScore()">保存修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 修改客户密码模态框 -->
	<div class="modal fade" id="userEditDialog" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改密码</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_user_form">
						<input type="hidden" id="edit_id" name="id" />
						<div class="form-group">
							<label for="edit_usercode" class="col-sm-2 control-label">账号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_usercode"
									placeholder="学生账号" name="usercode"  disabled="disabled"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_password" class="col-sm-2 control-label">原密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" 
									placeholder="原密码" name="password" />
							</div>
						</div>
						<div class="form-group">
							<label for="edit_password1" class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" 
									placeholder="新密码" name="password1" />
							</div>
						</div>
						<div class="form-group">
							<label for="edit_password2" class="col-sm-2 control-label">新建密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" 
									placeholder="新建密码" name="password2" />
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="updateuser()">保存修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 引入js文件 -->
	<!-- jQuery -->
	<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="<%=basePath%>js/bootstrap.min.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="<%=basePath%>js/metisMenu.min.js"></script>
	<!-- DataTables JavaScript -->
	<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="<%=basePath%>js/sb-admin-2.js"></script>
	<!-- 编写js代码 -->
	<script type="text/javascript">
		function editScore(id) {
	   		$.ajax({
		        type:"get",
		        url:"<%=basePath%>score/getScoreById.action",
		        data:{"id":id},
		        success:function(data) {
		            $("#edit_score_id").val(data.score_id);
		            $("#edit_student_id").val(data.student_id);
		            $("#edit_studentName").val(data.student_name);
		            $("#edit_courseName").val(data.course_name)
		            $("#edit_score").val(data.score)
	        	}
	    	});
		}
	    // 执行修改客户操作
		function updateScore() {
			$.post("<%=basePath%>score/update.action",$("#edit_score_form").serialize(),function(data){
				if(data =="OK"){
					alert("学生成绩更新成功！");
					window.location.reload();
				}else{
					alert("学生成绩更新失败！");
					window.location.reload();
				}
			});
		}
			function updateuser(){
		$.post("<%=basePath%>user/update.action",$("#edit_user_form").serialize(),function(data){
				if(data =="OK"){
					alert("学生密码修改成功！");
					window.location.reload();
				}else{
					alert("学生密码修改失败！");
					window.location.reload();
				}
			});
	}
	function editUser(id) {
	   		$.ajax({
		        type:"get",
		        url:"<%=basePath%>user/getUserById.action",
		        data:{"id":id},
		        success:function(data) {
		            $("#edit_id").val(data.id);
		            $("#edit_usercode").val(data.usercode);
		            $("#edit_password").val(data.password);
	        	}
	    	});
	}
	</script>
</body>
</html>
