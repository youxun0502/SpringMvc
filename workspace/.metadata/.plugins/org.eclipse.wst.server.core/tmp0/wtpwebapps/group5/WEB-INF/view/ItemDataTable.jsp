<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
				<style>
					table {
						background-color: rgb(33, 37, 41);
					}

					table td {
						max-width: 170px;
					}

					.tdCenter {
						text-align: center;
					}

					.imgBox {
						width: 100px;
						height: 100px;
					}

					.showDesc {
						cursor: pointer;
					}
				</style>
				<title>查詢道具</title>
			</head>

			<body>

				<div class="context">
					<jsp:include page="./ItemMain.jsp" />
					<div class="area1 row my-3">
						<table id="example" class="hover row-border" style="width:100%;">
							<thead>
								<tr>
									<th>道具編號
									<th>圖片
									<th>道具名稱
									<th>遊戲
									<th>道具介紹
									<th>道具等級
									<th>道具種類
									<th>可交易
									<th>新增時間
									<th>更新時間
									<th>
									<th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${items}" var="item" varStatus="c">
									<tr>
										<td class="tdCenter">${item.itemId}
										<td class="imgBox overflow-hidden"><img
												src="/group5/img/${item.itemImg}"
												alt="${item.itemImg}" class="img-fluid">
										<td>${item.itemName}
										<td>${item.gameDTO.gameId} ${item.gameDTO.gameName}
										<td class="showDesc text-truncate">${item.itemDesc}
										<td>${item.itemGrade}
										<td>${item.itemType}
										<td class="ps-3">
											<c:if test="${item.status == 1}"><i class="fa-regular fa-circle-check fa-2xl" style="color: #31dd39;"></i></c:if>
											<c:if test="${item.status == 0}"><i class="fa-solid fa-ban fa-2xl" style="color: #ff0000;"></i></c:if>
										<td>
											<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
										<td>
											<fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
										<td>
											<form method="post" action="getGameItemById">
												<button type="submit" value="${item.itemId}" name="itemId"
													class="btn btn-info"><i class="fa-solid fa-pen"></i></button>

											</form>
										<td>
											<form method="post" action="gameItemDelete" class="delForm">
												<input type="hidden" value="${item.itemId}" name="itemId">
												<button type="submit" class="delBtn btn btn-secondary"><i
														class="fa-solid fa-trash-can"></i></button>
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
						// dataTable
						$.extend(true, $.fn.dataTable.defaults, {
							searching: false,
						});
						$(document).ready(function () {
							$('#example').DataTable({
								scrollX: true,
							});
						});
						
						//showDesc
						$('.showDesc').on('click', function(){
							$(this).toggleClass('text-truncate');
						});

						// sweetAlert2
						$('.delForm').on('click', '.delBtn', function (e) {
							e.preventDefault();
							var form = $(this).parents('form');
							Swal.fire({
								title: 'Are you sure?',
								text: "You won't be able to revert this!",
								icon: 'warning',
								showCancelButton: true,
								confirmButtonColor: '#3085d6',
								cancelButtonColor: '#d33',
								confirmButtonText: 'Yes, delete it!'
							}).then((result) => {
								if (result.isConfirmed) {
									Swal.fire(
										'Deleted!',
										'Your file has been deleted.',
										'success'
									).then(() => {
										form.submit();
									})
								}
							})
						})
					})
				</script>
			</body>

			</html>