<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ItemData</title>
</head>
<body class="container">
<#include "templates/header.ftl">
<div class="table-responsive">
    <caption>Items list</caption>
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Merchant</th>

        </tr>
    <#list items as item>
        <tr>
            <td><a href="/item/${item.id}">${item.id}</a></td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.merchant}</td>
            <td>
                <form action="/deleteItem/{id}" method="post" name="item" class="form-group">
                    <input title="id" type="hidden" name="id" value="${item.id}"/>
                    <input type="submit" title="OK" value="Delete"/>
                </form>
            </td>
        </tr>
    </#list>
    </table>
</div>
<#include "templates/createItemForm.ftl"/>
</body>
</html>