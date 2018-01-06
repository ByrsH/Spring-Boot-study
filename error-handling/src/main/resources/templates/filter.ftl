<html>
<head>
    <meta charset="utf-8">
    <title>filter exception</title>
</head>
<body>
    <span>filter exception</span>
</body>

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
    $.ajax({
        type: 'get',
        url:'/api/test/filterException',
        contentType: "application/json",
        success: function (res) {
            
        },
        error:function (res) {

        }
    })
</script>

</html>