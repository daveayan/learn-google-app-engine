<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Hello App Engine</title>
</head>

<body>
<h1>Hello App Engine!</h1>

<table>
	<tr>
		<td colspan="2" style="font-weight: bold;">Email a message</td>
	</tr>
	<tr>
		<td>
		<form action="/email" method="post">
		<div><input type="submit" value="Email It !!!" /></div>
		</form>
		</td>
	</tr>
	<tr>
		<td>
		<form action="/emailqueue" method="post">
		<div><input type="submit" value="Email It Using Queue!!!" /></div>
		</form>
		</td>
	</tr>
</table>
</body>
</html>