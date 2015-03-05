<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>
 
<body>
<h1>Struts 2 + Spring + Hibernate integration example</h1>
 
<h2>Add Stock</h2>
<s:form action="addStockAction" >
  <s:textfield name="stockCode" label="Stock Code" value="" />
  <s:textfield name="stockName" label="Stock Name" value="" />
  <s:submit />
</s:form>
 
<h2>All Stock</h2>
 
<s:if test="stockList.size() > 0">
<table border="1px" cellpadding="8px">
	<tr>
<!-- 		<th>Stock Id</th> -->
		<th>Stock code</th>
		<th>Stock Name</th>
		<th>Created Date</th>
		<th colspan="2">Action</th>
	</tr>
	<s:iterator value="stockList" status="st" var="item">
		<tr>
<%-- 			<td><s:property value="stockId" /></td> --%>
			<td><s:property value="stockCode" /></td>
			<td><s:property value="stockName" /></td>
			<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
			<td><s:form>
			<s:hidden name="stockCode" value="%{#item.stockCode}"></s:hidden>
			<s:submit label="Delete" value="Delete" action="deleteStockAction"/>
			
			</s:form></td>
			<td style="padding-bottom: 5%"><input type="button" onclick="location.href = 'edit-stock.html?stockCode=<s:property value="stockCode" />';" value="Edit"/></td>
		</tr>
	</s:iterator>
</table>
</s:if>
<br/>
<br/>
 
</body>
</html>