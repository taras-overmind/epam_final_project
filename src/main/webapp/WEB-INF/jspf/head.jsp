<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head <%--th:fragment="head" xmlns:th="http://www.w3.org/1999/xhtml">--%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>Homepage</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/cover/">
<meta name="theme-color" content="#7952b3">

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
</script>
<script
        type="text/javascript"
        src="https://www.gstatic.com/charts/loader.js">
</script>


<style>
    /*.file-form button{*/
    /*    border: none;*/
    /*    background: transparent;*/
    /*    color: #007bff;*/
    /*    padding: 8px 16px;*/
    /*    outline: none;*/
    /*}*/
    .file-form button:hover{
        color:  #0056b3;
    }
    .file-form{
        display: flex;
        background: transparent;
        flex-flow: row;
    }
    .file-form input {
        background: transparent;
        width: 60%;
    }
    a.nav-link{
        color: #27ae60;
    }
    ::-webkit-file-upload-button{
        display: none;
    }
    .form-select{
        display: block;
        width: 100%;
        height: calc(1.5em + .75rem + 2px);
        padding: .375rem .75rem;
        font-size: 1rem;
        font-weight: 400;
        line-height: 1.5;
        color: #495057;
        background-color: #fff;
        background-clip: padding-box;
        border: 1px solid #ced4da;
        border-radius: .25rem;
        transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    }
    select option{
        width: 100%;
        height: calc(1.5em + .75rem + 2px);
        padding: .375rem .75rem;
        font-size: 1rem;
        font-weight: 400;
        line-height: 1.5;
        color: #495057;
        background-color: #fff;
    }
    .right-block{
        display: flex;
        justify-content: flex-end;
    }
    .left-block{
        display: flex;
    }
    /*.dropdown-content {*/
    /*    display: none;*/
    /*    position: absolute;*/
    /*    background-color: #40484f;*/
    /*    min-width: 120px;*/
    /*    z-index: 1;*/
    /*}*/
    /*!* Links inside the dropdown *!*/
    /*.dropdown-content a {*/
    /*    color: white;*/
    /*    padding: 12px 16px;*/
    /*    text-decoration: none;*/
    /*    display: block;*/
    /*}*/
    /*.dropdown-content button {*/
    /*    color: white;*/
    /*    padding: 12px 16px;*/
    /*    text-decoration: none;*/
    /*    display: block;*/
    /*}*/
    /*!* Change color of dropdown links on hover *!*/
    /*.dropdown-content a:hover {background-color: #ddd}*/
    /*!* Show the dropdown menu on hover *!*/
    /*.dropdown:hover .dropdown-content {*/
    /*    display: block;*/
    /*}*/
    /*!* Change the background color of the dropdown button when the dropdown content is shown *!*/
    /*.btn:hover, .dropdown:hover .btn  {*/
    /*    background-color: #0b7dda;*/
    /*}*/
    /*.alertError {*/
    /*    padding: 20px;*/
    /*    background-color: #d25951;*/
    /*    color: white;*/
    /*}*/
    /*.alertWarning {*/
    /*    padding: 20px;*/
    /*    background-color: #d7a454;*/
    /*    color: white;*/
    /*}*/
    /*.closebtn {*/
    /*    margin-left: 15px;*/
    /*    color: white;*/
    /*    font-weight: bold;*/
    /*    float: right;*/
    /*    font-size: 22px;*/
    /*    line-height: 20px;*/
    /*    cursor: pointer;*/
    /*    transition: 0.3s;*/
    /*}*/
    /*.closebtn:hover {*/
    /*    color: black;*/
    /*}*/
    /*.lupa {*/
    /*    display: flex;*/
    /*    flex-direction: row;*/
    /*    justify-content: center;*/
    /*}*/
    li {
        float: left;
        text-decoration: none;
        padding: 5px;
        list-style-type: none
    }
    .form-container {
        margin: auto;
        width: 35%;
        text-align: center;
    }
    form {
        display: flex;
        flex-direction: column;
        margin: auto;
    }
    .form-el {
        display: inherit;
        flex-direction: inherit;
    }


    .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
    }
    @media (min-width: 768px) {
        .bd-placeholder-img-lg {
            font-size: 3.5rem;
        }
    }
</style>
</head>