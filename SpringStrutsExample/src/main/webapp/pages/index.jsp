<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>
 
<body>
<h1>Struts 2 + Spring + Hibernate integration example</h1>
 
<h2>Add Stock</h2>
<s:form action="updateStockAction" >
  <s:textfield name="stockCode" label="Stock Code" value="%{stockCode}" disabled=""/>
  <s:textfield name="stockName" label="Stock Name" value="%{stockName}" />
  <s:submit />
</s:form>
 