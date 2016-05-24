<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<div style="margin-left: 30px;margin-right: 30px">
    <html:form action="/news?method=delete" method="post">
        <logic:iterate name="newsForm" property="newsList" id="news">
            <hr>
            <div>
                <span style="float: left;"><b><bean:write name="news" property="title"/></b></span>
                <span style="float: right;text-decoration: underline">${news.formattedDate}</span>
                <br/>
            </div>
            <p><bean:write name="news" property="brief"/></p>
            <div align="right">
                <html:link action="/news?method=view&id=${news.id}">view</html:link>
                <html:link action="/news?method=edit&id=${news.id}">edit</html:link>
                <html:multibox property="deleted" value="${news.id}"/>
            </div>
            <br/>
            <hr>
        </logic:iterate>
        <div align="right">
            <html:submit>Delete</html:submit>
        </div>
    </html:form>
</div>