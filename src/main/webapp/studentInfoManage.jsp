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
<table id="dg" title="学生信息" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
       url="studentList" fit="true" toolbar="#tb">
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
<div id="tb">
    <div>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        学号：&nbsp;<input type="text" name="s_stuNo" id="s_stuNo" size="10"/>&nbsp;
        姓名：&nbsp;<input type="text" name="s_stuName" id="s_stuName" size="10"/>&nbsp;
        性别：&nbsp;
        <select class="easyui-combobox" id="s_sex" name="s_sex" editable="false" panelHeight="auto">
            <option name="">请选择</option>
            <option name="female">female</option>
            <option name="male">male</option>
        </select>&nbsp;
        出生日期：&nbsp;
        <input class="easyui-datebox" name="s_bbirthday" id="s_bbirthday" editable="false" size="12" />
        &nbsp;-&nbsp;
        <input class="easyui-datebox" name="s_ebirthday" id="s_ebirthday" editable="false" size="12" />&nbsp;
        班级：&nbsp;<input class="easyui-combobox" name="s_gradeId" id="s_gradeId"  size="12"
                        data-options="panelHeight:'auto', editable:false, valueField:'id', textField:'gradeName', url:'gradeComboList'"/>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>

</div>
</body>
</html>
