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
            <title>更新道具資料</title>
        </head>

        <body>
            <jsp:include page="./ItemMain.jsp" />
            <div class="d-flex justify-content-center">
                <div class="area1 my-4 mx-5 w-75">
                    <div>
                        <h2>道具資料更新</h2>
                    </div>
                    <form method="post" action="gameItemUpdate" class="row g-3 needs-validation" enctype="multipart/form-data"
                        novalidate>
                        <div class="col-md-6">
                            <div class="imgBox overflow-hidden d-flex justify-content-center align-items-center">
                                <img src="${pageContext.request.contextPath}/img/${item.itemImg}" class="rounded img-fluid" alt="${item.itemImg}" id="show">
                            </div>
                            <input type="file" name="myImg" class="form-control" id="itemImg1">
                            <input type="hidden" value="${item.itemImg}" name="itemImg"
                                class="form-control pe-none" readonly />
                        </div>
                        <div class="col-md-6 gy-3">
                            <div class="mb-3">
                                <label for="itemId1" class="form-label h4">道具編號</label>
                                <input type="text" value="${item.itemId}" name="itemId" id="itemId1"
                                    class="form-control form-control-lg pe-none" readonly />
                            </div>
                            <div class="mb-3">
                                <label for="itemName1" class="form-label h4">選擇遊戲</label>
                                <select name="gameId" id="gameId1" class="form-select form-select-lg mb-3"
                                    aria-label=".form-select-lg example">
                                    <c:forEach items="${games}" var="game" varStatus="c">
                                        <option value="${game.gameId}" selectedName="${game.gameName}">${game.gameId}
                                            ${game.gameName}</option>
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="gameName" id="gameName1" value="">
                            </div>
                            <div class="mb-3">
                                <label for="itemName1" class="form-label h4">道具名稱</label>
                                <input type="text" value="${item.itemName}" name="itemName" id="itemName1"
                                    class="form-control form-control-lg" required />
                                <div class="invalid-feedback fs-5">
                                    請輸入道具名稱
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="status1" class="form-label h4">交易狀態</label>
                                <select name="status" id="status1" class="form-select form-select-lg mb-3"
                                    aria-label=".form-select-lg example">
                                    <option id="txn" value="1">可交易</option>
                                    <option id="ntxn" value="0">不可交易</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <label for="itemDesc1" class="form-label h4">道具介紹</label>
                            <textarea class="form-control form-control-lg" name="itemDesc" id="itemDesc1"
                                style="height: 100px;"></textarea>
                        </div>
                        <div class="col-md-12">
                            <label for="itemGrade1" class="form-label h4">道具等級</label>
                            <input type="text" value="${item.itemGrade}" name="itemGrade" id="itemGrade1"
                                class="form-control form-control-lg" />
                        </div>
                        <div class="col-md-12">
                            <label for="itemType1" class="form-label h4">道具種類</label>
                            <input type="text" value="${item.itemType}" name="itemType" id="itemType1"
                                class="form-control form-control-lg" />
                        </div>
                        <div class="gap-2 d-md-flex justify-content-md-end mt-5">
                            <input type="submit" value="確定" class="btn btn-warning col-3" />
                            <a href="allGameItem" class="btn btn-secondary col-3">取消</a>
                        </div>
                    </form>
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
                	//select game
                    $('#gameId1').val("${item.gameId}");
                    $('#gameName1').attr('value', "${item.gameDTO.gameName}");
                    $('#gameId1').change(function(){
	                    var selectedName = $('#gameId1').find('option:selected').attr('selectedName');
	                    console.log(selectedName);
	                    $('#gameName1').attr('value', selectedName);
                    })

                    //select status
                    if ("${item.status}" == 0 || "${item.status}" == 1)
                        $('#status1').val("${item.status}");

                    //change tab
                    $('ul li input').removeClass('active');
                    $('ul').append(`
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">UPDATE</a>
                        </li>
                    `)

                    $('#itemDesc1').text(`${item.itemDesc}`);

                    //show image
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