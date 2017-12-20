<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>

<script type="text/javascript">
	
	$(function(){
		$("#goTo").change(function(){
			
			//去除前后空格
			var pageNo = $.trim(this.value);

			if(pageNo == "" || isNaN(pageNo)) {
				
				//将文本框中的数据恢复为默认值
				this.value = this.defaultValue;
				
				return ;
			}
			
			//执行页面跳转
			window.location.href = "${pageContext.request.contextPath}/${pageScope.targetUrl }?pageNoStr="+pageNo;
			
		});
	});

</script>
<nav>
	<ul class="pager" >
		<c:if test="${page.hasPrev }">
			<a href="${pageScope.targetUrl }?pageNoStr=1">首页</a>★
			<a href="${pageScope.targetUrl }?pageNoStr=${page.prev }">上一页</a>
		</c:if>

		★当前是第${page.pageNo }页
			★共${page.totalPageNo }页
			★共${page.totalRecordNo }条记录
			★跳转到第<input type="text" id="goTo"/>页★</li>

		<c:if test="${page.hasNext }">
			<a href="${pageScope.targetUrl }?pageNoStr=${page.next }">下一页</a>
			★<a href="${pageScope.targetUrl }?pageNoStr=${page.totalPageNo }">末页</a>
		</c:if>
	</ul>
</nav>