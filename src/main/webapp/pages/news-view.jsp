<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<bean:define name="newsForm" property="newsMessage" id="newsMessage"/>
<div style="margin-left: 30px;margin-right: 30px;margin-top: 30px">
    <p>News Title: <b><bean:write name="newsMessage" property="title"/></b></p>
    <br/>
    <p>News date: <span>${newsMessage.formattedDate}</span></p>
    <br/>
    <p>News brief: <span><bean:write name="newsMessage" property="brief"/></span></p>
    <br/>
    <p>News content: <span><bean:write name="newsMessage" property="content"/></span></p>
    <br/>
    <div align="center">
        <html:link action="/news?method=edit&id=${newsMessage.id}">edit</html:link>
        <html:link action="/news?method=delete">delete</html:link>
    </div>
</div>