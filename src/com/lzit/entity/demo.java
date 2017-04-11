package com.lzit.entity;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure();
		SchemaExport sx=new SchemaExport(cfg);
		sx.create(true, true);
		
	}

}
