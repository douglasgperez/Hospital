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
public class MHQuery extends X_H_Query {

	/**
	 * @param ctx
	 * @param H_Query_ID
	 * @param trxName
	 */
	public MHQuery(Properties ctx, int H_Query_ID, String trxName) {
		super(ctx, H_Query_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ctx
	 * @param rs
	 * @param trxName
	 */
	public MHQuery(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
