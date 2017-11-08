/**
 * 
 */
package org.curso.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

/**
 * @author informatica
 *
 */
public class MHHospitalization extends X_H_Hospitalization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4076759769177337950L;

	/**
	 * @param ctx
	 * @param H_Hospitalization_ID
	 * @param trxName
	 */
	public MHHospitalization(Properties ctx, int H_Hospitalization_ID, String trxName) {
		super(ctx, H_Hospitalization_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.compiere.model.PO#afterSave(boolean, boolean)
	 */
	
	//Primera forma
	/*public static List<MHHospitalization> getByDateFinish (Properties ctx, Timestamp DateFinish, String trxName){
		final String whereClause = "DateFinish=?";
		Query q = new Query (ctx,"H_Hospitalization", whereClause, trxName);
		q.setParameters(DateFinish);
		return (q.list());	
	}*/
	public static MHHospitalization[] getDate (Timestamp p_date) {
		MHHospitalization[] m_Hospitalization;
		ArrayList<MHHospitalization> list = new ArrayList<MHHospitalization>();
		//final String sql = "Select * from H_Hospitalization where DateFinish <= ?"
		//		+  " AND H_Bed_ID Not in (Select H_Bed_ID From H_Hospitalization where DateFinish > ? )";
		
		final String sql = "Select h.* "
				+ "from H_Hospitalization h inner join"
				+ " H_Bed b on h.H_Bed_ID = b.H_Bed_ID where h.DateFinish <= ? and b.IsAvailable='N'";
			
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
 			pstmt = DB.prepareStatement(sql, null);
			pstmt.setTimestamp (1, p_date);
			//pstmt.setTimestamp (2, p_date);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new MHHospitalization (Env.getCtx(), rs, null));			
		}
		  catch (Exception e) {
			 // log.log(Level.SEVERE, sql, e);
			  System.out.println(e);
		  }
		finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
		m_Hospitalization = new MHHospitalization [list.size()];
		list.toArray(m_Hospitalization);
		return m_Hospitalization;
	}
	
	
	private static PreparedStatement setTimestamp(int i, Timestamp p_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override	
	protected boolean afterSave(boolean newRecord, boolean success) {
		// TODO Auto-generated method stub
//		Primera Forma de hacerlo		
//		int m_query_ID = getH_Query_ID();
//		MHQuery mQuery = new MHQuery(getCtx(), m_query_ID, get_TrxName());
//		mQuery.set_CustomColumn("IsAttended","Y"); //Actualiza la tabla H_Query
//		mQuery.saveEx();
////		
//		int m_bed_ID = getH_Bed_ID();
//		//System.out.println(m_bed_ID+"id");
//		MHBed mBed = new MHBed(getCtx(), m_bed_ID, get_TrxName());
//		mBed.setIsAvailable(false);//("IsAvailable","N"); //Actualiza la tabla H_Bed
//		mBed.saveEx();
//		Segunda Forma de hacerlo	
		
		//Consulta
		MHQuery query;
		if (get_ValueOld(COLUMNNAME_H_Query_ID) != null) {
			int old = (int) get_ValueOld(COLUMNNAME_H_Query_ID);
			if(old != getH_Query_ID()) {
				query = new MHQuery (getCtx(), old, null);
				query.setIsAttended(false);
				query.saveEx();
			}
		}
		query = new MHQuery (getCtx(), getH_Query_ID(), null);
		query.setIsAttended(true);
		query.saveEx();
		
		//Camilla
		MHBed bed;
		if (get_ValueOld(COLUMNNAME_H_Bed_ID) != null) {
			int old = (int) get_ValueOld(COLUMNNAME_H_Bed_ID);
			if(old != getH_Bed_ID()) {
				bed = new MHBed (getCtx(), old, null);
				bed.setIsAvailable(true);
				bed.saveEx();
			}
		}
		bed = new MHBed (getCtx(), getH_Bed_ID(), null);
		bed.setIsAvailable(false);
		bed.saveEx();
		return super.afterSave(newRecord, success);		
	}

	/* (non-Javadoc)
	 * @see org.compiere.model.PO#beforeSave(boolean)
	 */
	@Override
	protected boolean beforeSave(boolean newRecord) {
		// TODO Auto-generated method stub
	
		return super.beforeSave(newRecord);
	}

	/* (non-Javadoc)
	 * @see org.compiere.model.PO#afterDelete(boolean)
	 */
	@Override
	protected boolean afterDelete(boolean success) {
		// TODO Auto-generated method stub
		int m_query_ID = getH_Query_ID();
		MHQuery mQuery = new MHQuery(getCtx(), m_query_ID, get_TrxName());
		mQuery.set_CustomColumn("IsAttended","N"); //Actualiza la tabla H_Query
		mQuery.saveEx();
		return super.afterDelete(success);
	}

	/**
	 * @param ctx
	 * @param rs
	 * @param trxName
	 */
	public MHHospitalization(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
