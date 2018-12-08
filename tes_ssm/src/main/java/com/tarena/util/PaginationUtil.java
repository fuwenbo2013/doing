package com.tarena.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tarena.vo.Page;
@Component
public class PaginationUtil {
	@Autowired
	PageUtil pageUtil;
	public  List<Integer> getPagination(Page page) {			
		int totalPages=page.getTotalPages();		
		int pageSize=page.getPageSize();
		int currentPage=page.getCurrentPage();
		int showNum=page.getShowNum();
		List<Integer> nums = new ArrayList<>();
		//如果totalCount小于showNum
		if (totalPages<=showNum) {
			for (Integer i = 1; i <= totalPages; i++) {
				nums.add(i);
			}
		}else {
			//如果当前页码在界面的页码的前半部分,当前界面的页码保持不变
			if (currentPage<=(showNum/2+1)) {
				for (Integer i = 1; i <= showNum; i++) {
					nums.add(i);
				}
				//如果当前页在最后界面的后部,当前界面的页码显示保持不变
			}else if (currentPage>=(totalPages-showNum/2)) {
				for (Integer i = totalPages-showNum; i <= totalPages; i++) {
					nums.add(i);
				}
				//
			}else {
				for (Integer i = currentPage-showNum/2; i <= currentPage+showNum/2; i++) {
					nums.add(i);
				}
			}			
		}		
		return nums;
		
	}

}
