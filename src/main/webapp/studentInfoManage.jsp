<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息管理</title>
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

    </script>
</head>
<body style="margin: 5px;">
<table id="dg" title="学生信息" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true" url="studentList" fit="true">
    <thead>
    <tr>
        <th field="cb" checkbox="true"></th>
        <th field="stuId" width="50" align="center">编号</th>
        <th field="stuNo" width="100" align="center">学号</th>
        <th field="stuName" width="100" align="center">姓名</th>
        <th field="sex" width="100" align="center">性别</th>
        <th field="birthday" width="100" align="center">出生日期</th>
        <th field="gradeName" width="100" align="center">班级名称</th>
        <th field="email" width="150" align="center">Email</th>
        <th field="stuDesc" width="250" align="center">学生备注</th>
    </tr>
    </thead>
</table>

</body>
</html>
