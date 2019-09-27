<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!</title>
    </head>
    <body>
    <#--注释部分-->
    <#--下面使用插值-->
    <h1>Welcome ${user}!</h1>
    <p>We have these animals:</p>
    <ul>
        <#--使用ＦＴＬ指令-->
        <#list animals?sort_by("price")?reverse as being>
            <li>${being_index} ${being.name} for ${being.price} Euros</li>
        </#list>
    </ul>

    </body>
</html>