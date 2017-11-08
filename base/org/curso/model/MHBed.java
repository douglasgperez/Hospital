/**
 * 
 */
package org.curso.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author informatica
 *
 */
public class MHBed extends X_H_Bed {

	/**
	 * @param ctx
	 * @param H_Bed_ID
	 * @param trxName
	 */
	public MHBed(Properties ctx, int H_Bed_ID, String trxName) {
		super(ctx, H_Bed_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ctx
	 * @param rs
	 * @param trxName
	 */
	public MHBed(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
