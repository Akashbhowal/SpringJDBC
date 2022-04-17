package com.orm.shopDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.orm.rowmapper.shopRowMapper;
import com.orm.shop.shop;

@Component
public class shopDaoImpl implements shopDAO {

	@Autowired
	private JdbcTemplate jb;

	public JdbcTemplate getJb() {
		return jb;
	}

	public void setJb(JdbcTemplate jb) {
		this.jb = jb;
	}

	@Override
	public String create(String sql) {
		int x = jb.update(sql);
		return x + " rows inserted";
	}

	@Override
	public String update(String sql) {
		int x = jb.update(sql);
		return x + " rows updated";
	}

	@Override
	public String delete(String sql) {
		int x = jb.update(sql);
		return x + " rows deleted";
	}

	@Override
	public shop read(int id) {
		String sql="select * from shop where id=?";
		shopRowMapper sr=new shopRowMapper();
		shop s=jb.queryForObject(sql,sr,id);
		return s;
	}

	@Override
	public List<shop> read() {
		String sql="select * from shop";
		shopRowMapper sr= new shopRowMapper();
		List<shop> s=jb.query(sql,sr);
		return s;
	}

}
