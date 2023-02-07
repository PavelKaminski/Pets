<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<html>
<head>
    <title>Error page</title>
</head>
<body>
<p>Request from ${pageContext.errorData.requestURI} is failed</p>
<p>Status code: ${pageContext.errorData.statusCode}</p>
<p>Exception: ${pageContext.exception}</p>
<p>Message from exception: ${pageContext.exception.message}</p>
</body>
</html>
