package com.orm.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.orm.shop.shop;

public class shopRowMapper implements RowMapper<shop> {

	@Override
	public shop mapRow(ResultSet rs, int rowNum) throws SQLException {
		shop sp=new shop();
		sp.setId(rs.getInt(1));
		sp.setItem(rs.getString(2));
		sp.setPrice(rs.getDouble(3));
		return sp;
	}

}
