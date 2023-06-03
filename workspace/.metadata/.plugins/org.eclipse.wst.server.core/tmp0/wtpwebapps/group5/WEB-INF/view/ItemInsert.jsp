<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
                <style>
                    .area1 {
                        background-color: rgba(53, 53, 53, 0.705);
                        border-radius: 14px;
                        padding: 20px 50px;
                    }

                    .imgBox {
                        height: 350px;
                        border: 2px dashed rgb(40, 44, 49);
                        background-color: rgba(65, 65, 65, 0.418);
                    }
                </style>
                <title>新增道具資料</title>
            </head>

            <body>
                <jsp:include page="./ItemMain.jsp" />
                <div class="d-flex justify-content-center">
                    <div class="area1 my-4 mx-5 w-75">
                        <div>
                            <h2>新增道具資料</h2>
                        </div>
                        <form:form action="gameItemInsert" method="post" modelAttribute="item"
                            enctype="multipart/form-data" class="row g-3 needs-validation" novalidate="true">
                            <div class="col-md-6">
                                <!-- <label for="itemImg1" class="t1">圖片</label> -->
                                <div class="imgBox overflow-hidden d-flex justify-content-center align-items-center">
                                    <img src="" class="rounded img-fluid" alt="" id="show">
                                </div>
                                <input name="myImg" type="file" id="itemImg1" class="form-control" />
                            </div>
                            <div class="col-md-6 gy-3">
                                <div class="mb-3">
                                    <form:label path="gameId" class="form-label h4">選擇遊戲</form:label>
                                    <form:select path="gameId" id="gameId1" class="form-select form-select-lg mb-3"
                                        aria-label="form-select-lg example">
                                        <form:options items="${games}" itemValue="gameId" itemLabel="gameName"
                                            selectedName="gameName" />
                                    </form:select>
                                    <form:hidden path="gameName" id="gameName1" value="" />
                                </div>
                                <div class="mb-3">
                                    <form:label path="itemName" class="form-label h4">道具名稱</form:label>
                                    <form:input path="itemName" type="text" id="itemName1"
                                        class="form-control form-control-lg" placeholder="ITEM NAME" required="true" />
                                    <div class="invalid-feedback fs-5">
                                        請輸入道具名稱
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <form:label path="status" class="form-label h4">交易狀態</form:label>
                                    <form:select path="status" id="status1" class="form-select form-select-lg mb-3"
                                        aria-label=".form-select-lg example">
                                        <form:option id="txn" value="1">可交易</form:option>
                                        <form:option id="ntxn" value="0">不可交易</form:option>
                                    </form:select>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <form:label path="itemDesc" class="form-label h4">道具介紹</form:label>
                                <form:textarea path="itemDesc" class="form-control form-control-lg" id="itemDesc1"
                                    placeholder="DESCRIPTION" style="height: 100px;" />
                            </div>
                            <div class="col-md-12">
                                <form:label path="itemGrade" class="form-label h4">道具等級</form:label>
                                <form:input path="itemGrade" type="text" id="itemGrade1"
                                    class="form-control form-control-lg" placeholder="GRADE" />
                            </div>
                            <div class="col-md-12">
                                <form:label path="itemType" class="form-label h4">道具種類</form:label>
                                <form:input path="itemType" type="text" id="itemType1"
                                    class="form-control form-control-lg" placeholder="TYPE" />
                            </div>
                            <div class="gap-2 d-md-flex justify-content-md-end mt-5">
                                <input type="submit" value="確定" class="btn btn-warning col-3" />
                                <input type="reset" value="清空" class="btn btn-secondary col-3" />
                            </div>
                        </form:form>
                    </div>
                </div>
                <script src="https://code.jquery.com/jquery-3.6.4.js"></script>
                <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
                <script>
                    //Validation
                    (function () {
                        'use strict'
                        var forms = document.querySelectorAll('.needs-validation')
                        Array.prototype.slice.call(forms)
                            .forEach(function (form) {
                                form.addEventListener('submit', function (event) {
                                    if (!form.checkValidity()) {
                                        event.preventDefault()
                                        event.stopPropagation()
                                    }
                                    form.classList.add('was-validated')
                                }, false)
                            })
                    })()

                    $(function () {
                        //change tab
                        $('ul li input').toggleClass('active');

                        $('#itemDesc1').text(`${item.itemDesc}`);

                        //select game
                        var gameName = $('#gameId1').find('option:selected').attr('selectedName');
                        $('#gameName1').attr('value', gameName);
                        $('#gameId1').change(function () {
                            var selectedName = $('#gameId1').find('option:selected').attr('selectedName');
                            console.log(selectedName);
                            $('#gameName1').attr('value', selectedName);
                        })

                        $('#itemImg1').change(function () {
                            readURL(this);
                        })

                        function readURL(input) {
                            if (input.files && input.files[0]) {
                                var reader = new FileReader();
                                reader.onload = function (e) {
                                    $('#show').attr('src', e.target.result);
                                }
                                reader.readAsDataURL(input.files[0]);
                            }
                        }
                    })
                </script>

            </body>

            </html>