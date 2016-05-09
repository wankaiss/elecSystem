
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<HTML>
	<HEAD>
		<title>系统设置</title>		
		<LINK href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="${pageContext.request.contextPath }/script/function.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/script/pub.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/script/mine.js"></script>
		<script type="text/javascript"  src="${pageContext.request.contextPath }/script/jquery-1.4.2.js"></script>


		<script language="javascript">
				function returnMethod(){
					return saveDict();
				}

		 </script>
 	</HEAD>

	<body>
	 <Form name="Form1" id="Form1"  method="post" style="margin:0px;">
		<table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" colspan=3 align="center" background="${pageContext.request.contextPath }/images/b-info.gif">
						<font face="宋体" size="2"><strong>数据字典维护</strong></font>
					</td>
				</tr>
				<TR height=10><td colspan=3></td></TR>
				<tr>
					<td class="ta_01" align="right" width="35%" >类型列表：</td>
					<td class="ta_01" align="left"  width="30%" >
						<%--<s:select list="#request.list" id="keyword" name="keyword"
									listKey="keyword" listValue="keyword"
									headerKey="jerry" headerValue="" cssClass="bg" cssstyle="width:180px"
									onchange="changetype()"></s:select>--%>
						<select name="keyword" class="bg" style="width:180px" onchange="changetype()">
							<option value="jerrynew"></option>
							<s:iterator value="#request.list" var="sys">
								<option value="<s:property value="#sys.keyword"/>"><s:property value="#sys.keyword"/></option>
							</s:iterator>

						</select>
					</td>

					 <td class="ta_01"  align="right" width="35%" >
				    </td>
				</tr>
				
				
				
			    <tr>
			       <td class="ta_01" align="right" width="35%" id="newtypename">类型名称：</td>
				   <td class="ta_01"  align="left" width="30%"  height=20 id="newddlText">
				    <input type="text" name="keywordname" maxlength="25" size=24>	
				   </td>
				   <td class="ta_01"  align="right" width="35%" ></td>
				</tr>
				
				
				<TR height=10><td colspan=3 align="right">
				   <input type="button" name="saveitem" value="添加选项" style="font-size:12px; color:black; height=20;width=80" onClick="insertRows()">
				 </td></TR>   
			</TBODY>
		</table>
		</Form>
		
 <Form name="Form2" id="Form2"  method="post" style="margin:0px;">
    <table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0" >
    <tr>
     <td >
	   <table cellspacing="0"   cellpadding="1" rules="all" bordercolor="gray" border="1" id="dictTbl"
		    style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:100%; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
			
		
						
				<tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
					<td class="ta_01" align="center"  width="20%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">编号</td>
					<td class="ta_01" align="center"  width="60%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">名称</td>
					<td class="ta_01" align="center"  width="20%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">删除</td>					
				</tr>
			    
			   
			     <tr>
				   <td class="ta_01" align="center"  width="20%">1</td>
				   <td class="ta_01" align="center"  width="60%">
				   <input name="itemname" type="text"  size="45" maxlength="25"></td>
				   <td class="ta_01" align="center"  width="20%"></td>
				</tr>
	     </table>
	   </td>
	 </tr>
  <tr>
     <td >   
	 </td>
 </tr>
 <TR height=10><td colspan=3></td></TR>
  <tr>
     <td align="center" colspan=3>
       <input type="button" name="saveitem" value="保存" style="font-size:12px; color:black; height=20;width=50" onClick="returnMethod()">
	 </td>
 </tr>
 
       <input type="hidden" name="keywordname" >
       <input type="hidden" name="typeflag" >
	 
  </table>
   
    
   
  </Form>
  </body>

	<script type="text/javascript">
		function insertRows() {
			var tab1 = $("#dictTbl");
			var tempRow = $("#dictTbl tr").size();
			var $tdNum = $("<td align='center'></td>");
			$tdNum.html(tempRow);
			var $tdName = $("<td align='center'></td>");
			$tdName.html("<input name=\"itemname\" type=\"text\" id=\"" + tempRow + "\" size=\"45\" maxLength=25/>");
			var $tdDel = $("<td align='center'></td>");
			$tdDel.html("<a href='javascript:delTableRow(\"" + tempRow + "\")'><img src=${pageContext.request.contextPath}/images/delete.gif width=15 height=14 border=0 style=CURSOR:hand ></a>")


			var $tr = $("<tr></tr>")
			$tr.append($tdNum);
			$tr.append($tdName);
			$tr.append($tdDel);

			tab1.append($tr);
		}

		function delTableRow(rowNum) {
			var tb1 = $("#dictTbl")
			var tempRow = $("#dictTbl tr").size();
			if(rowNum <= tempRow) {
				$("#"+rowNum).parent().parent().remove();
				for(i = parseInt(rowNum) + 1; i < tempRow; i++) {
					$("#" + i).parent().prev().html(i-1);
					$("#" + i).parent().next().html("<a href='javascript:delTableRow(\"" + (i-1) + "\")'><img src=${pageContext.request.contextPath}/images/delete.gif width=15 height=14 border=0 style=CURSOR:hand ></a>")
					$("#" + i).attr("id",(i-1));
				}
			}
		}

		function changetype() {

			if (document.Form1.keyword.value == "jerrynew") {
				var textStr = "<input type=\"text\" id=\"keywordname\" name=\"keywordname\" maxlength=\"50\" size=\"24\"/>";
				document.getElementById("newtypename").innerHTML = "类型名称";
				document.getElementById("newddlText").innerHTML = textStr;
				Mine.submitActionWithForm('Form2', '${pageContext.request.contextPath}/system/elecSystemDDLAction_edit.action', 'Form1');
			}else {
				var textStr = "";
				document.getElementById("newtypename").innerHTML = "";
				document.getElementById("newddlText").innerHTML = textStr;
				Mine.submitActionWithForm('Form2', '${pageContext.request.contextPath}/system/elecSystemDDLAction_edit.action', 'Form1');
			}
		}

		/*function saveDict(){

			if(document.Form1.keyword.value=="jerrynew"){
				if(Trim(document.Form1.keywordname.value)==""){
					alert("请输入类型名称");
					return false;
				}

				var allkeywords= document.Form1.keyword;
				for(var i=0;i<allkeywords.length;i++){

					if(allkeywords[i].value==Trim(document.Form1.keywordname.value)){

						alert("已存在此类型名称,请重新输入");
						return false;
					}

				}

				document.Form2.keywordname.value=document.Form1.keywordname.value;
				document.Form2.typeflag.value="new";

			}else{

				document.Form2.keywordname.value=document.Form1.keyword.value;
				document.Form2.typeflag.value="add";
			}
			var tbl=document.getElementById("dictTbl");
			for (i=1;i<tbl.rows.length;i++){
				var name = tbl.rows[i].cells[1].getElementsByTagName("input")[0].value;
				if(Trim(name)==""){
					alert("名称不能为空！");

					return false;
				}
			}
			for(k=1;k<=tbl.rows.length-2;k++)
			{
				for(m=k+1;m<=tbl.rows.length-1;m++)
				{
					var name1 = tbl.rows[k].cells[1].getElementsByTagName("input")[0].value;
					var name2 = tbl.rows[m].cells[1].getElementsByTagName("input")[0].value;
					if(name1 == name2){
						alert("名称不能相同！");
						return false;
					}
				}
			}
			document.Form2.action="${pageContext.request.contextPath}/system/elecSystemDDLAction_save.action";
			document.Form2.submit();
		}*/

		function saveDict() {
			if(document.Form1.keyword.value == "jerrynew") {
				if(Trim(document.Form1.keywordname.value) == "") {
					alert("please input message");
					return false;
				}

				var allKeywords = document.Form1.keyword;
				for (var i = 0 ; i < allKeywords.length ; i++) {
					var keywordName = Trim(document.Form1.keywordname.value);
					if (keywordName == allKeywords[i].value) {
						alert("can't input save keyword!");
						return false;
					}
				}

				document.Form2.keywordname.value = Trim(document.Form1.keywordname.value);
				document.Form2.typeflag.value = "new";
			}else {
				document.Form2.keywordname.value = Trim(document.Form1.keywordname.value);
				document.Form2.typeflag.value = "add"
			}

			var tb1 = document.getElementById("dictTbl");
			for(var i = 1; i < tb1.rows.length; i++) {
				var name = tb1.rows[i].cells[1].getElementsByTagName("input")[0].value;
				if(Trim(name) == "") {
					alert("Content can't be empty!");
					return false;
				}
			}

			for(var j = 1; j < tb1.rows.length - 2; j++) {
				for(var k = (j + 1); k < tb1.rows.length; k++) {
					var name1 = tb1[j].cells[1].getElementsByTagName("input")[0].value;
					var name2 = tb1[k].cells[1].getElementsByTagName("input")[0].value;
					if(Trim(name1) == Trim(name2))
						alert("Content can't be same name!");
						return false;
				}
			}

			document.Form2.action = "${pageContext.request.contextPath}/system/elecSystemDDLAction_save.action";
			document.Form2.submit();
	</script>
</HTML>


