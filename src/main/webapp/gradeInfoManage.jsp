<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级信息管理</title>
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="dg" title="班级信息" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true" url="gradeList">
    <thead>
    <tr>
        <th field="id" width="50">编号</th>
        <th field="gradeName" width="100">班级名称</th>
        <th field="gradeDesc" width="250">班级描述</th>
    </tr>
    </thead>
</table>
</body>
</html>
