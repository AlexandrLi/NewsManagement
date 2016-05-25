<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<bean:define name="newsForm" property="newsMessage" id="newsMessage"/>
<div style="margin-left: 30px;margin-right: 30px;margin-top: 30px">
    <p>News title: <b><bean:write name="newsMessage" property="title"/></b></p>
    <p> News date: ${newsMessage.formattedDate}</p>
    <div style="margin-bottom: 20px">
        <span style="vertical-align: top">Brief:</span>
        <div style="display:inline-block;width: 600px; margin-left: 35px"><bean:write name="newsMessage"
                                                                                      property="brief"/></div>
    </div>
    <div>
        <span style="vertical-align: top">Content:</span>
        <div style="display:inline-block;width: 600px; margin-left: 15px"><bean:write name="newsMessage"
                                                                                      property="content"/></div>
    </div>
    <div align="right" style="margin-top: 50px;margin-right: 300px;margin-bottom: 20px">
        <html:link action="/news?method=edit&id=${newsMessage.id}">
            <button>edit</button>
        </html:link>
        <html:link action="/news?method=delete&id=${newsMessage.id}">
            <button>delete</button>
        </html:link>
    </div>
</div>