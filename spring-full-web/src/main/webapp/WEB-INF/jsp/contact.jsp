<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<form:form method="post" commandName="contact">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="firstName">First name</form:label>
			<form:input path="firstName" type="text" class="form-control"
				required="required" />
			<form:errors path="firstName" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="lastName">Last name</form:label>
			<form:input path="lastName" type="text" class="form-control"
				required="required" />
			<form:errors path="lastName" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="email">Email</form:label>
			<form:input path="email" type="text" class="form-control"
				required="required" />
			<form:errors path="email" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="targetDate">Birth date</form:label>
			<form:input path="targetDate" type="text" class="form-control"
				required="optional" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Add contact</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf" %>