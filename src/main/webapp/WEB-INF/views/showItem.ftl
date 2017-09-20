<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ItemData</title>
</head>
<body class="container">
<#include "templates/header.ftl">
<div class="table-responsive">
    <caption>Item info</caption>
    <table class="table table-striped">
        <tr>
            <td>Id</td>
            <td>${item.id}</a></td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${item.name}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${item.price}</td>
        </tr>
        <td>Merchant</td>
        <td>${item.merchant}</td>
        </tr>
    </table>
</div>
<a type="button" href="/items" class="button">Back</a>
</body>
</html>