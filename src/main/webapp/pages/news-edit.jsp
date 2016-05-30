<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="hmtl" uri="http://struts.apache.org/tags-html" %>

<head>
    <title><bean:message key="page.edit.title"/></title>
</head>
<bean:define name="newsForm" property="newsMessage" id="news" type="com.epam.ali.testapp.model.News"/>
<div style="margin-left: 30px;margin-right: 30px; margin-top: 30px">
    <html:form action="/news?method=save">
        <html:hidden property="id" value="${news.id}"/>
        <div style="display: inline-block;width: 150px;margin-bottom: 20px">
            <bean:message key="label.news.title"/>:
        </div>
        <html:text style="width: 600px;" property="title" value="${news.title}"/>
        <div style="display: inline-block;width: 150px;margin-bottom: 20px">
            <bean:message key="label.news.date"/>:
        </div>
        <html:text property="date" value="${news.formattedDate}"/>
        <div>
            <div style="display: inline-block;vertical-align:top;width: 150px;margin-bottom: 20px">
                <bean:message key="label.news.brief"/>:
            </div>
            <html:textarea style="height: 150px;width: 600px" property="brief" value="${news.brief}"/>
        </div>
        <div>
            <div style="display: inline-block;vertical-align:top;width: 150px;margin-bottom: 20px">
                <bean:message key="label.news.content"/>:
            </div>
            <html:textarea style="height: 150px;width: 600px" property="content" value="${news.content}"/>
        </div>
        <div align="center" style="margin-top: 30px">
            <html:submit><bean:message key="label.common.save"/></html:submit>
            <hmtl:link action="/news?method=list">
                <button type="button"><bean:message key="label.common.cancel"/></button>
            </hmtl:link>
        </div>
    </html:form>
</div>