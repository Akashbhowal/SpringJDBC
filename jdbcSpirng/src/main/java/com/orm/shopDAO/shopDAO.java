package com.orm.shopDAO;

import java.util.List;

import com.orm.shop.shop;

public interface shopDAO {
	
	public String create(String sql);
	
	public String update(String sql);
	
	public String delete(String sql);
	
	public shop read(int id);
	
	public List<shop> read();

}
