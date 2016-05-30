<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<bean:define name="newsForm" property="newsMessage" id="newsMessage"/>
<head>
    <title>${newsMessage.title}</title>
</head>
<div style="margin-left: 30px;margin-right: 30px;margin-top: 30px">
    <div style="display: inline-block;width: 150px;margin-bottom: 20px">
        <bean:message key="label.news.title"/>:
    </div>
    <b><bean:write name="newsMessage" property="title"/></b></p>
    <div style="display: inline-block;width: 150px;margin-bottom: 20px">
        <bean:message key="label.news.date"/>:
    </div>
    ${newsMessage.formattedDate}
    <div>
        <div style="display: inline-block;width: 150px;margin-bottom: 20px">
            <bean:message key="label.news.brief"/>:
        </div>
        <div style="display:inline-block;vertical-align:top;width: 600px">
            <bean:write name="newsMessage" property="brief"/>
        </div>
    </div>
    <div>
        <div style="display: inline-block;width: 150px;margin-bottom: 20px">
            <bean:message key="label.news.content"/>:
        </div>
        <div style="display:inline-block;vertical-align: top;width: 600px">
            <bean:write name="newsMessage" property="content"/></div>
    </div>
</div>
<div align="right" style="margin-top: 50px;margin-right: 300px;margin-bottom: 20px">
    <html:link action="/news?method=edit&id=${newsMessage.id}">
        <button><bean:message key="label.common.edit"/></button>
    </html:link>
    <html:link action="/news?method=delete&id=${newsMessage.id}">
        <button><bean:message key="label.common.delete"/></button>
    </html:link>
</div>
</div>