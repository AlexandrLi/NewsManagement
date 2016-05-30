<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center" width="1200px">
    <tr>
        <td height="20%" colspan="2">
            <tiles:insert attribute="header"/>
        </td>
    </tr>
    <tr>
        <td width="20%" style="vertical-align: top">
            <tiles:insert attribute="menu"/>
        </td>
        <td>
            <tiles:insert attribute="body"/>
        </td>
    </tr>
    <tr>
        <td height="20%" colspan="2">
            <tiles:insert attribute="footer"/>
        </td>
    </tr>
</table>
</body>
</html>
</html>
