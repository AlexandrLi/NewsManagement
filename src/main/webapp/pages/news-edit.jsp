<%@ html:taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html:form action="/news?method=add">
    Title: <html:text property="title"/>
    Brief: <html:text property="brief"/>
    Content: <html:text property="content"/>
    <html:submit>Add</html:submit>
</html:form>