<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>班级信息管理</title>
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

        var url;
        function openGradeAddDialog() {
            $("#dlg").dialog("open").dialog("setTitle", "添加班级信息");
            url = "gradeSave";
        }

        function openGradeModifyDialog(){
            var selectedRows = $('#dg').datagrid('getSelections');
            if (selectedRows.length != 1) {
                $.messager.alert("系统提示", "请选择一条要编辑的数据！");
                return;
            }
            var row = selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle", "编辑班级信息");
            $("#fm").form("load", row);
            url = "gradeSave?id=" + row.id;
        }

        function closeGradeDialog() {
            $("#dlg").dialog("close");
            resetValue();
        }

        function resetValue() {
            $("#gradeName").val("");
            $("#gradeDesc").val("");
        }

        function saveGrade() {
            $("#fm").form("submit", {
                url: url,
                onSubmit: function () {
                    return $(this).form("validate");
                },
                success: function (jsonObject) {
                    if (jsonObject.errorMessage) {
                        $.messager.alert("系统提示", jsonObject.errorMessage);
                        return;
                    } else {
                        $.messager.alert("系统提示", "保存成功！");
                        resetValue();
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("reload");
                    }
                }
            });
        }


        function searchGrade() {
            $('#dg').datagrid('load', {
                gradeName: $('#s_gradeName').val()
            });
        }

        function deleteGrade() {
            var selectedRows = $('#dg').datagrid('getSelections');
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择要删除的数据！");
                return;
            }
            var strIds = [];
            for (var i = 0; i < selectedRows.length; i++) {
                strIds.push(selectedRows[i].id);
            }
            var ids = strIds.join(", ");
            alert("您选择的数据是: " + ids);

            $.messager.confirm("系统提示", "您确认要删除这 " + selectedRows.length + " 条数据吗？", function (r) {
                if (r) {
                    $.post("gradeDelete", {deleteIds: ids}, function (jsonObject) {
                        if (jsonObject.success) {
                            $.messager.alert("系统提示", "您已成功删除 " + jsonObject.deleteNumbers + " 条数据");
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示", jsonObject.errorMessage);
                        }
                    }, "json");
                }
            });

        }
    </script>
</head>
<body style="margin:5px">
<table id="dg" title="班级信息" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
       url="gradeList" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="checkBox" checkbox="true"></th>
        <th field="id" width="50" >编号</th>
        <th field="gradeName" width="100">班级名称</th>
        <th field="gradeDesc" width="250">班级描述</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openGradeAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openGradeModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteGrade()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        班级名称：&nbsp;<input type="text" name="s_gradeName" id="s_gradeName" />
        <a href="javascript:searchGrade()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>

    <div id="dlg" class="easyui-dialog" style="width:450px; height: 290px; padding: 10px 20px" closed="true"
         buttons="#dlg-buttons">
        <form id="fm" method="post">
            <table>
                <tr>
                    <td>班级名称：</td>
                    <td><input type="text" name="gradeName" id="gradeName" class="easyui-validatebox" required="true">
                    </td>
                </tr>
                <tr>
                    <td valign="top">班级描述：</td>
                    <td><textarea rows="7" cols="30" name="gradeDesc" id="gradeDesc"></textarea></td>
                </tr>
            </table>
        </form>
    </div>

    <div id="dlg-buttons">
        <a href="javascript:saveGrade()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
        <a href="javascript:closeGradeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
</div>
</body>
</html>
