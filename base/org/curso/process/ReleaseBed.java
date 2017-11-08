/**
 * 
 */
package org.curso.process;

import java.sql.Timestamp;
import java.util.List;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Msg;
import org.curso.model.MHBed;
import org.curso.model.MHHospitalization;

/**
 * @author informatica
 *
 */
public class ReleaseBed extends SvrProcess {

	/**
	 * 
	 */
	public ReleaseBed() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.compiere.process.SvrProcess#prepare()
	 */
	Timestamp p_DateFinish;
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] parameter= getParameter();
		for (int i=0; i < parameter.length; i++) {
			String name = parameter[i].getParameterName();
			if ( name == null)
				;
			else if (name.equals("DateFinish")) {
				p_DateFinish = parameter[i].getParameterAsTimestamp();
				
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.compiere.process.SvrProcess#doIt()
	 */
	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		MHHospitalization [] mHospitalization = MHHospitalization.getDate(p_DateFinish);
				for (int x=0; x < mHospitalization.length; x++) {
					int mBed_ID = mHospitalization[x].getH_Bed_ID();
					MHBed mBed = new MHBed(getCtx(), mBed_ID, get_TrxName());
					mBed.setIsAvailable(true);
					mBed.saveEx();
		}
		return Msg.getMsg(getCtx(), "Camilla Liberada "); //+ qty;
		//return null;
	}

}
