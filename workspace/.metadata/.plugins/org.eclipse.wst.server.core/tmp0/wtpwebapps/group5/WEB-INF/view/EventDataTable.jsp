<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <jsp:include page="./EventMain.jsp" />

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
            <!-- <link rel="stylesheet" href="/Item/style.css" type="text/css"> -->
            <title>活動列表</title>
            <style>
                .area1 {
                    position: absolute;
                    width: 80%;
                    margin: 180px 250px;
                }

                table {
                    background-color: rgb(33, 37, 41);
                }
            </style>
        </head>

        <body>
            <div class="context">
                <div class="area1">
                    <table id="example" class="hover row-border order-column" style="width:100%">
                        <thead>
                            <tr>
                                <th>賽事ID
                                <th>賽事名稱
                                <th>對戰模式
                                <th>開始日期
                                <th>結束日期
                                <th>賽事地點
                                <th>獎金
                                <th>名額限制
                                <th>報名截止日期
                                <th>更新
                                <th>刪除
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${events}" var="event" varStatus="c">
                                <tr>
                                    <td>${event.competitionId}
                                    <td>${event.name}
                                    <td>${event.mode}
                                    <td>${event.startDate}
                                    <td>${event.endDate}
                                    <td>${event.location}
                                    <td>${event.prize}
                                    <td>${event.quotaLimited}
                                    <td>${event.deadline}

                                    <td>
                                        <form method="post" action="OneCompetition">
                                            <button type="submit" value="${event.competitionId}" name="eventId">更新</button>

                                        </form>
                                    <td>
                                        <form method="post" action="DeleteCompetition">
                                            <input type="hidden" name="eventId" value="${event.competitionId}">
                                            <button class="delete-btn" type="submit" value="${event.competitionId}"
                                                name="eventId">刪除</button>
                                        </form>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <script src="https://code.jquery.com/jquery-3.6.4.js"></script>
            <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

            <script>
                $(function () {

                    $.extend(true, $.fn.dataTable.defaults, {
                        searching: false,
                        ordering: true,
                    });

                    $(document).ready(function () {
                        $('#example').DataTable();
                    });

                    $('.delete-btn').click(function (event) {
                        event.preventDefault();
                        var eventId = parseInt($(this).val());
                        Swal.fire({
                            title: '確定要刪除嗎?',
                            text: "刪除後就找不回資料嘍",
                            icon: 'warning',
                            showCancelButton: true,
                            confirmButtonColor: '#3085d6',
                            cancelButtonColor: '#d33',
                            confirmButtonText: '確定',
                            cancelButtonText: '取消'
                        }).then((result) => {
                            if (result.isConfirmed) {
                                $(this).closest('form').find('input[name="eventId"]').val(eventId);
                                $(this).closest('form').submit();
                            }
                        })
                    });



                })
            </script>
        </body>

        </html>