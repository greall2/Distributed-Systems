<%@ include file="includes/header.jsp" %>
<!--Apdapted from Advanced Object Orientated Programme Module-->
<div class="animated bounceInDown" style="font-size:32pt; font-family:arial; color:#990000; font-weight:bold">Dictionary Service</div>

</p>&nbsp;</p>&nbsp;</p>

<table width="600" cellspacing="0" cellpadding="7">
	<tr>
		<td valign="top">

			<form bgcolor="white" method="GET" enctype="multipart/form-data" action="doProcess">
				<fieldset>
					<legend><h3>Search the Dictionary</h3></legend>
					<b>Enter a Word:</b><br>
					<center><input name="searchStr" type="text" size="90"/></center>
					<p/>
					<center><input type="submit" value="Submit"></center>
					<br>
				</fieldset>							
			</form>	

		</td>
	</tr>
	

	
</table>
<%@ include file="includes/footer.jsp" %>

