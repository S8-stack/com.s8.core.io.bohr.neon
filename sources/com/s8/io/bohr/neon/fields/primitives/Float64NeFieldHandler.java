package com.s8.io.bohr.neon.fields.primitives;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.BuildScope;
import com.s8.io.bohr.neon.core.NeObjectTypeFieldsBlock;
import com.s8.io.bohr.neon.fields.NeFieldHandler;
import com.s8.io.bohr.neon.fields.NeFieldUpdate;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class Float64NeFieldHandler extends PrimitiveNeFieldHandler {


	public final static long SIGNATURE = BOHR_Types.FLOAT64;

	public @Override long getSignature() { return SIGNATURE; }




	public Float64NeFieldHandler(NeObjectTypeFieldsBlock prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.FLOAT64);
	}


	/**
	 * 
	 * @param values
	 * @return
	 */
	public double get(NeFieldUpdate wrapper) {
		return ((Update) wrapper).value;
	}


	/**
	 * 
	 * @param values
	 * @param value
	 */
	public Update createValue(double value) {
		return new Update(value);
	}





	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public class Update extends PrimitiveNeFieldHandler.Update {

		@Override
		public NeFieldHandler getFieldHandler() {
			return Float64NeFieldHandler.this;
		}
		
		private double value;

		public Update(double value) {
			super();
			this.value = value;
		}

		

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			outflow.putFloat64(value);
		}

		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			value = inflow.getFloat64();
		}
	}
}
