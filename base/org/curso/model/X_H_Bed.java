/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.curso.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for H_Bed
 *  @author Adempiere (generated) 
 *  @version Release 3.8.0 - $Id$ */
public class X_H_Bed extends PO implements I_H_Bed, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171107L;

    /** Standard Constructor */
    public X_H_Bed (Properties ctx, int H_Bed_ID, String trxName)
    {
      super (ctx, H_Bed_ID, trxName);
      /** if (H_Bed_ID == 0)
        {
			setH_Bed_ID (0);
        } */
    }

    /** Load Constructor */
    public X_H_Bed (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_H_Bed[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Bed.
		@param H_Bed_ID Bed	  */
	public void setH_Bed_ID (int H_Bed_ID)
	{
		if (H_Bed_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_H_Bed_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_H_Bed_ID, Integer.valueOf(H_Bed_ID));
	}

	/** Get Bed.
		@return Bed	  */
	public int getH_Bed_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Bed_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_H_Room getH_Room() throws RuntimeException
    {
		return (I_H_Room)MTable.get(getCtx(), I_H_Room.Table_Name)
			.getPO(getH_Room_ID(), get_TrxName());	}

	/** Set Room.
		@param H_Room_ID Room	  */
	public void setH_Room_ID (int H_Room_ID)
	{
		if (H_Room_ID < 1) 
			set_Value (COLUMNNAME_H_Room_ID, null);
		else 
			set_Value (COLUMNNAME_H_Room_ID, Integer.valueOf(H_Room_ID));
	}

	/** Get Room.
		@return Room	  */
	public int getH_Room_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_H_Room_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Available.
		@param IsAvailable 
		Resource is available
	  */
	public void setIsAvailable (boolean IsAvailable)
	{
		set_Value (COLUMNNAME_IsAvailable, Boolean.valueOf(IsAvailable));
	}

	/** Get Available.
		@return Resource is available
	  */
	public boolean isAvailable () 
	{
		Object oo = get_Value(COLUMNNAME_IsAvailable);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}