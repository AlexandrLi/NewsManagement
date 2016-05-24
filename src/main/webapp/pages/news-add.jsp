<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<div style="margin-left: 30px;margin-right: 30px; margin-top: 30px">
    <html:form action="/news?method=save">
        <p>News title: <html:text style="width: 600px;" property="title"/></p>
        <p>News date: <html:text property="date"/></p>
        <div style="margin-bottom: 20px">
            <span style="vertical-align: top">Brief: </span><html:textarea
                style="height: 150px;width: 600px; margin-left: 35px" property="brief"/>
        </div>
        <div>
            <span style="vertical-align: top">Content: </span><html:textarea
                style="height: 150px;width: 600px;margin-left: 15px" property="content"/>
        </div>
        <div align="center" style="margin-top: 30px">
            <html:submit>OK</html:submit>
            <html:reset onclick="history.back()">Reset</html:reset>
        </div>
    </html:form>
</div>