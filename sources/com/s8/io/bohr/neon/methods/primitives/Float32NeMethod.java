package com.s8.io.bohr.neon.methods.primitives;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.flow.S8AsyncFlow;
import com.s8.api.web.functions.NeFunction;
import com.s8.api.web.functions.primitives.Float32NeFunction;
import com.s8.core.bohr.atom.protocol.BOHR_Types;
import com.s8.io.bohr.neon.core.NeBranch;
import com.s8.io.bohr.neon.core.NeObjectTypeMethodsBlock;
import com.s8.io.bohr.neon.methods.NeMethod;

/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class Float32NeMethod extends NeMethod {

	public final static long SIGNATURE = BOHR_Types.FLOAT32;
	public @Override long getSignature() { return SIGNATURE; }


	public Float32NeMethod(NeObjectTypeMethodsBlock prototype, String name, int ordinal) {
		super(prototype, name, ordinal);
	}

	@Override
	public void run(NeBranch branch, S8AsyncFlow flow, ByteInflow inflow, NeFunction function) throws IOException {
		float arg =  inflow.getFloat32();
		((Float32NeFunction) function).run(flow, arg);
	}
}

