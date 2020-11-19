<html>
<head>
    <title>Cabinet</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="update-product-page">
    <div class="form">
        <form class="update-product-form" action="/institution/update/${service.id}" method="post">
            <input class="name" name="name" value="${service.name}" type="text" placeholder="ProductName"/>
            <input class="price" name="accreditation" value="${service.accreditation}" type="number" placeholder="accreditation"/>
            <input class="description" name="numberOfStudents" value="${service.numberOfStudents}" type="number" placeholder="numberOfStudents"/>
            <input class="description" name="numberOfUniversity" value="${service.numberOfUniversity}" type="number" placeholder="numberOfUniversity"/>
            <input class="description" name="addressUniversity" value="${service.addressUniversity}" type="text" placeholder="addressUniversity"/>
            <button type="submit">Update</button>
        </form>

    </div>
</div>
</body>
</html>