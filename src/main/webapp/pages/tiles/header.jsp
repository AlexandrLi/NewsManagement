<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<h1 style="color: blue"><bean:message key="label.header.news.management"/></h1>
<div align="right">
    <html:link action="/locale?lang=english"><bean:message key="label.language.english"/></html:link>
    <html:link action="/locale?lang=russian"><bean:message key="label.language.russian"/></html:link>
</div>
