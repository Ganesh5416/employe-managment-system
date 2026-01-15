<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>

<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 0;
    padding: 0;
    min-height: 100vh;
    position: relative;
    overflow: hidden;
    background-color: #f4f6f9;
}

/* Blurred Background */
body::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: url("bg.jpg"); /* Ensure the image is correctly linked */
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    filter: blur(10px);
    transform: scale(1.1);
    z-index: -1;
}

/* Main Container */
.container {
    width: 40%;
    margin: 80px auto;
    background-color: rgba(255, 255, 255, 0.9);
    padding: 30px;
    border-radius: 15px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
    text-align: left;
    transition: transform 0.3s ease;
}

/* Hover Effect on Container */
.container:hover {
    transform: scale(1.02);
}

/* Heading Style */
h1 {
    color: #2c3e50;
    font-size: 32px;
    font-weight: 600;
    margin-bottom: 20px;
    letter-spacing: 1px;
}

/* Information Row */
.info-row {
    margin: 18px 0;
    font-size: 16px;
    color: #333;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 6px 0;
    border-bottom: 1px solid #ecf0f1;
}

.info-row span {
    font-weight: 600;
    color: #555;
}

/* Horizontal Line */
hr {
    border: none;
    border-top: 2px solid #e0e0e0;
    margin: 20px 0;
}

/* Logout Button */
.logout-btn {
    margin-top: 30px;
    padding: 12px 30px;
    font-size: 16px;
    color: #fff;
    background-color: #e74c3c;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.3s ease;
    text-transform: uppercase;
    font-weight: 700;
}

.logout-btn:hover {
    background-color: #c0392b;
    transform: translateY(-3px);
}

/* Media Queries for Responsiveness */
@media (max-width: 768px) {
    .container {
        width: 80%;
    }

    h1 {
        font-size: 28px;
    }

    .info-row {
        font-size: 14px;
    }

    .logout-btn {
        width: 100%;
    }
}
</style>

</head>
<body>

	<div class="container">
		<h1>Employee Info</h1>

		<hr>

		<div class="info-row">
			<span>Employee ID:</span> ${empid}
		</div>

		<div class="info-row">
			<span>Employee Name:</span> ${name}
		</div>

		<div class="info-row">
			<span>Employee City:</span> ${city}
		</div>

		<div class="info-row">
			<span>Employee Mobile No:</span> ${number}
		</div>

		<div class="info-row">
			<span>Employee Email:</span> ${email}
		</div>

		<!-- Logout Button -->
		<form action="welcome.html" method="post">
			<button type="submit" class="logout-btn">Logout</button>
		</form>
	</div>

</body>
</html>
