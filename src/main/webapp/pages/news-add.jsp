<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="hmtl" uri="http://struts.apache.org/tags-html" %>

<head>
    <title><bean:message key="page.add.title"/></title>
</head>
<div style="margin-left: 30px;margin-right: 30px; margin-top: 30px">
    <html:form action="/news?method=add">
        <div style="display: inline-block;width: 150px;margin-bottom: 20px">
            <bean:message key="label.news.title"/>:
        </div>
        <html:text style="width: 600px;" property="title" value=""/>
        <div style="display: inline-block;vertical-align: top;width: 150px;margin-bottom: 20px">
            <bean:message key="label.news.brief"/>:
        </div>
        <html:textarea style="height: 150px;width: 600px" property="brief" value=""/>
        <div style="display: inline-block;vertical-align:top;width: 150px;margin-bottom: 20px">
            <bean:message key="label.news.content"/>:
        </div>
        <html:textarea style="height: 150px;width: 600px" property="content" value=""/>
        <div align="center" style="margin-top: 20px">
            <html:submit><bean:message key="label.common.save"/></html:submit>
            <hmtl:link action="/news?method=list">
                <button type="button"><bean:message key="label.common.cancel"/></button>
            </hmtl:link>
        </div>
    </html:form>
</div>