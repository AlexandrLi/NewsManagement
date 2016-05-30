<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<div style="margin-left: 50px">
    <ul>
        <li><html:link action="/news?method=list"><bean:message key="label.menu.news.list"/></html:link></li>
        <li><html:link action="/addPage"><bean:message key="label.menu.news.add"/></html:link></li>
    </ul>
</div>
