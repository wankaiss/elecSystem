<%@ taglib prefix="s" uri="/struts-tags" %>


<%@ page language="java" pageEncoding="UTF-8"%>












<html>
<head>
	<title>load</title>
	<link href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet" />
</head>
  
<body>
<table width="100%" border="0" id="table8">
	<tr>
		<td align="left" valign="middle"  style="word-break: break-all">
			<span class="style1">
				<s:property value="devRun" escapeHtml="true"/>
			</span></td>
	</tr>
	
	<tr>
		<td align="left" valign="middle"  style="word-break: break-all">
			<span class="style1">
				<font color="red">
					<s:date name="createDate" format="yyyy-MM-dd hh:mm:ss"/>
				</font>
			</span>
		</td>
	</tr>
	
	
				
</table>
</body>
</html>