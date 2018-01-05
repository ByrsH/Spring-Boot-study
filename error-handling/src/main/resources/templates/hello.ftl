<html>
<head>
    <meta charset="utf-8">
    <title>hello world</title>
</head>
<body>
    <span>hello weold!</span>
</body>

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
    $.ajax({
        type: 'get',
        url:'/api/index',
        contentType: "application/json",
        success: function (res) {
            
        },
        error:function (res) {

        }
    })

    $.ajax({
        type: 'get',
        url:'/api/test/jsonError',
        contentType: "application/json",
        success: function (res) {

        },
        error:function (res) {

        }
    })
</script>

</html>