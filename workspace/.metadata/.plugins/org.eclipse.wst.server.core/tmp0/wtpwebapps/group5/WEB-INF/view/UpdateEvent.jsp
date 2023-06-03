<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <jsp:include page="./EventMain.jsp" />

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
            <link rel="stylesheet" href="./css/jquery-ui.min.css">
            <!-- <link rel="stylesheet" href="/Item/style.css" type="text/css"> -->
            <title>活動列表</title>
            <style>
                .area1 {
                    position: absolute;
                    width: 80%;
                    margin: 180px 250px;
                }

         
            </style>
        </head>

        <body>
            <div class="context">
                <div class="area1">
                    <table id="example" class="hover row-border order-column" style="width:100%;background-color:rgb(33, 37, 41);">
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
                                <th>更新確認
                            </tr>
                        </thead>
                            <tbody>
                                <tr>
                                    <form method="post" action="UpdateCompetition">
                                        <td><input style="width: 100%" type="text" name="id" value="${event.competitionId}"
                                                readonly>
                                        <td><input style="width: 100%" type="text" name="name"
                                                value="${event.name}" required autocomplete="off">
                                        <td><select name="mode">
                                                <option>團隊賽-自由對戰</option>
                                                <option>團隊賽-單淘汰賽</option>
                                                <option>團隊賽-循環賽</option>
                                                <option>個人賽-自由對戰</option>
                                                <option>個人賽-單淘汰賽</option>
                                                <option>個人賽-循環賽</option>
                                            </select>
                                        <td><input id="pick-start_date" style="width: 100%" value="${event.startDate}"
                                                type="text" name="startDate" required autocomplete="off">
                                        <td><input id="pick-end_date" style="width: 100%" value="${event.endDate}"
                                                type="text" name="endDate" required autocomplete="off">
                                        <td><input style="width: 100%" type="text" name="location"
                                                value="${event.location}" required autocomplete="off">
                                        <td><input style="width: 100%" type="text" name="prize" value="${event.prize}" required autocomplete="off">
                                        <td><input style="width: 100%" type="text" name="quotaLimited" value="${event.quotaLimited}" required autocomplete="off">
                                        <td><input id="pick-deadline" style="width: 100%" value="${event.deadline}"
                                                type="text" name="deadline" required autocomplete="off">
                                        <td> <button type="submit">更新</button>
                                    </form>
                                </tr>
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
                                </tr>


                            </tbody>
                    </table>
                </div>
            </div>

            <script src="https://code.jquery.com/jquery-3.6.4.js"></script>
                 <script src="./js/jquery-ui.min.js"></script>
            <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
       

            <script>
                $(function () {

                    $.extend(true, $.fn.dataTable.defaults, {
                        searching: false,
                        ordering: true,
                    });

                    $(document).ready(function () {
                        $('#example').DataTable();
                    });

                    $("#pick-start_date").datepicker({
                        dateFormat: 'yy-mm-dd',
                        onSelect: function (selected) {
                            $("#pick-end_date").datepicker("option", "minDate", selected);

                            $("#pick-deadline").datepicker("option", "maxDate", selected);
                        },
                    });

                    $("#pick-end_date").datepicker({
                        dateFormat: 'yy-mm-dd',
                        onSelect: function (selected) {
                            $("#pick-start_date").datepicker("option", "maxDate", selected);
                        },
                    });

                    $("#pick-deadline").datepicker({
                        dateFormat: 'yy-mm-dd',
                        onSelect: function (selected) {
                            $("#pick-start_date").datepicker("option", "minDate", selected);
                        },
                    });

                })
            </script>
        </body>

        </html>