<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8" />
    <title>数据列表页面</title>
    <!-- layui.css -->
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <style>
        tr td:not(:nth-child(0)),
        tr th:not(:nth-child(0)) {
            text-align: center;
        }
        /*可选*/
        .layui-laypage > * {
            float: left;
        }
        .layui-field-title .layui-field-box{
            padding: 10px 20px 10px 30px;
        }
        .layui-table-cell{
            padding-top: 4px;
            height: 45px;
        }
        .star-so{
            text-align: center;
            margin-bottom: 10px;
            margin-top: 40px;
        }
        .star-so input.layui-input{
            width: 200px;
            display: inline-block;
        }

    </style>
</head>
<body>

<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field">

    <button class="layui-btn" style="position: relative;float: right;right: 100px;" onclick="javascript:location.replace(location.href)">
        <i class="layui-icon">&#x1002;</i>
    </button>
    <div class="layui-row">
        <div class="layui-form layui-col-md12 star-so">
            <input type="hidden" value="${Session.user.id?c}" id="id">
        </div>
    </div>


    <div class="layui-field-box">
        <div id="dataContent" class="">
            <table class="layui-hide" id="hclist" lay-filter="table"></table>

            <script type="text/html" id="operator">
                {{#  if(d.status == 1 ){ }}
                <a class="layui-btn " lay-event="recall">撤回</a>
                {{#  }else{ }}
                <a class="layui-btn " lay-event="pass">发布</a>
                <a class="layui-btn layui-btn-danger " lay-event="del">删除</a>
                {{# } }}
            </script>
        </div>
    </div>
</fieldset>

<!-- layui.js -->
<script src="${ctx!}/js/plugins/layui/layui.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.define([ 'layer',  'table'], function (exports) {
        var $ = layui.jquery,
                table  = layui.table ;
        var id = $("#id").val();
        table.render({
            elem: '#hclist'
            ,height: 'full-200'
            ,method:'GET'
            ,url: '/college/hcList' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'num', align:'center', title: '需求编号',unresize:true}
                ,{field: 'name', align:'center', title: '岗位名称',unresize:true}
                ,{field: 'title', align:'center', title: '岗位级别',unresize:true}
                ,{field: 'location', align:'center', title: '地点',unresize:true}
                ,{field: 'numbers', align:'center', title: '数量',unresize:true}
                ,{field: 'experience', align:'center', title: '经历要求',unresize:true}
                ,{field: 'desc', align:'center', title: '岗位描述',unresize:true}
                ,{fixed: 'right',  title:'操作',align:'center', toolbar: '#operator',unresize:true}
            ]]
        });

        //监听工具条
        table.on('tool(table)', function(obj){
            var data = obj.data;
            if(obj.event === 'public'){

            }else if(obj.event ==='pass'){
                changeStatus(data.id);
            }else if(obj.event ==='recall'){
                changeStatus(data.id);
            }else if(obj.event ==='del') {
                del(data.id);
            }
        });

        function changeStatus(id) {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "/college/addJob/" + id,
                success: function (ret) {
                    if (ret.isOk) {
                        layer.msg("操作成功", {time: 2000}, function () {
                            window.location.href = "/college/shenhe/index";
                        });
                    } else {
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
        }


        function del(id) {
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    type: "DELETE",
                    dataType: "json",
                    url: "/college/deliverys/" + id,
                    success: function (ret) {
                        if (ret.isOk) {
                            layer.msg("操作成功", {time: 2000}, function () {
                                layer.close(index);
                                window.location.href = "/college/shenhe/index";
                            });
                        } else {
                            layer.msg(ret.msg, {time: 2000});
                        }
                    }
                });
            });
        }

        function createHtml(obj) {
            var data = obj.data;
            var resume = data.jobSeeker.resume;
            var detailHtml = '';
            detailHtml += '<tr class="detail-view" style="display: none" id="detail-view-'+resume.id+'">';
            detailHtml += '<td colspan="10"><blockquote class="layui-elem-quote" style="line-height: 30px;text-align:left;padding-left: 30px;">';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">学号:</div>'+resume.num+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">姓名:</div>'+resume.name+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">性别:</div>'+resume.sex+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">年龄:</div>'+resume.age+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">电话:</div>'+resume.phone+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">邮箱:</div>'+resume.email+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">教育程度:</div>'+resume.education+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">工作经历:</div>'+resume.work+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">个人评价:</div>'+resume.personal+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">附件地址:</div><a href="'+resume.annexUrl+'">'+resume.annexUrl+'</a></br>';
            detailHtml += '</blockquote></td></tr>';
            obj.tr.after(detailHtml);
        }
    });
</script>
</body>
</html>