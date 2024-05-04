/**
 * 2021-12-01
 * 权限相关的js
 * 
 */
//定住搜索下拉列表的值
		$("select[name=departId]").val($("#departId").val());
		$("select[name=position]").val($("#position").val());
		$("select[name=state]").val($("#state").val());
	
		
		//删除一条记录
		function deleteRow(empId) {
			
			if(confirm("确定删除吗")){
				
				location.href="employee/remove?empId="+empId;
				
			}
		}
	
		//全选全不选
		$("#mainCheckbox").click(function() {
			
			$(".listCheckbox").prop("checked",$("#mainCheckbox").prop("checked"));
		})
		
		//批量删除
		$("#deleteAll").click(function() {
			
			var empIds=[];
			
			$(".listCheckbox:checked").each(function() {
				
				empIds.push($(this).val());
				
			})
			
			if (empIds.length>0) {
				
				if(confirm("确定删除吗")){
					
					location.href="employee/removes?empIds="+empIds;
					
				}
				
			}else{
				
				alert("请先选择要删除的信息!")
			}
		})