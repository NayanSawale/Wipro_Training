<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Claim Submission Form</h1>
    <form action="claim" method="post">
        Claim Number: <input type="text" name="claimNumber"><br>
        Policy Number: <input type="text" name="policyNumber"><br>
        Claimant Name: <input type="text" name="claimantName"><br>
        Claim Amount: <input type="text" name="claimAmount"><br>
        <input type="submit" value="Submit Claim">
    </form>
</body>
</html>
