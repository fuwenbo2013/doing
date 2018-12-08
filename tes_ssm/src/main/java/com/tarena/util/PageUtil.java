package com.tarena.util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PageUtil {
	@Value("#{manyProperties.pageSize}")
	private  int pageSize;
	@Value("#{manyProperties.showNum_a}")
	private int showNum;
	
	public  int getPageSize() {
		return pageSize;
	}	
	public  int getShowNum() {
		return showNum;
	}
	
	
}
