<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a").click(function () {
                $.post("demo",{},function (data) {
                    var result="";
                    for(var i=0;i<data.length;i++){
                        result+="<tr>";
                        result+="<td>"+data[i].id+"</td>";
                        result+="<td>"+data[i].username+"</td>";
                        result+="<td>"+data[i].password+"</td>";
                        result+="</tr>";
                    }
                    //$("table").append(result);
                    //相当innerHTML先清空后添加
                    $("#mytbody").html(result);
                })
                return false;
            })
        });
    </script>
  </head>
  <body>
    <a href="demo">点击显示下面表单的详细信息</a>
    <br/>
    <br>
    <table border="1">
      <tr>
        <td>编号</td>
        <td>账号</td>
        <td>密码</td>
      </tr>
      <tbody id="mytbody"></tbody>
    </table>

  </body>
</html>
