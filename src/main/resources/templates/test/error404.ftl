<html>
<head>
    <meta charset="utf-8">
    <title>test 404 error</title>
</head>
<body>
<span>test 404 error!</span>

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
    $.ajax({
        type: 'get',
        url: '/api/test/error',
        success: function (res) {

        },
        error: function (res) {
            window.alert(res.status);
        }
    })
</script>


</body>
</html>