<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Your contacts</caption>
			<thead>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Birth date</th>
					<th>Active</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${contacts }" var="contact">
				
					<tr>
						<td>${contact.firstName }</td>
						<td>${contact.lastName }</td>
						<td>${contact.email }</td>
						<td><fmt:formatDate value="${todo.birthDate }" pattern="dd/MM/yyyy"></fmt:formatDate> </td>
						<td>${contact.active }</td>
						<td><a type="button" class="btn btn-success" href="/update-contact?id=${contact.id }">Update</a>
						<td><a type="button" class="btn btn-warning" href="/delete-contact?id=${contact.id }">Delete</a>
					</tr>
				
				</c:forEach>
				
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-contact">Add a Contact</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>