<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>webSocket-用户${param.userId}</title>
    <script type="text/javascript">
        var userId = '${param.userId}';
        $(function () {
            var websocket;
            if ('WebSocket' in window) {
//                websocket = new WebSocket("ws://localhost:18082/websocketTest/user001");
                websocket = new WebSocket("ws://localhost:18082/websocketDemo/" + userId);
                console.log("此浏览器支持websocket");
            } else if ('MozWebSocket' in window) {
                alert("此浏览器只支持MozWebSocket");
            } else {
                alert("此浏览器只支持SockJS");
            }
            websocket.onopen = function (evnt) {
                $("#tou").html("链接服务器成功!")
            };
            websocket.onmessage = function (evnt) {
                $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
            };
            websocket.onerror = function (evnt) {
            };
            websocket.onclose = function (evnt) {
                $("#tou").html("与服务器断开了链接!")
            };
            $('#send').bind('click', function () {
                send();
            });
            $('#close').bind('click', function () {
                closeWebSocket();
            });

            function send() {
                if (websocket !== null) {
                    var message = document.getElementById('message').value;
                    websocket.send(message);
                } else {
                    alert('未与服务器链接.');
                }
            }

            //关闭连接
            function closeWebSocket() {
                websocket.close();
            }
        });
    </script>
</head>

<body>
<div class="page-header" id="tou">
    webSocket多终端聊天测试
</div>
<div class="well" id="msg"></div>
<div class="col-lg">
    <div class="input-group">
        <input type="text" class="form-control" placeholder="发送信息..." id="message">
        <span class="input-group-btn">
            <button class="btn btn-default" type="button" id="send">发送</button>
            <button class="btn btn-default" type="button" id="close"> Close</button>
        </span>
    </div>
</div>
</body>

</html>


