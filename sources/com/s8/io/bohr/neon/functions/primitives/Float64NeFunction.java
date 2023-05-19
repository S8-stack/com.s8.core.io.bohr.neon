package com.s8.io.bohr.neon.functions.primitives;

import com.s8.arch.fluor.S8AsyncFlow;
import com.s8.io.bohr.atom.BOHR_Types;
import com.s8.io.bohr.neon.functions.NeFunction;

@FunctionalInterface
public interface Float64NeFunction extends NeFunction {

	
	
	public final static long SIGNATURE = BOHR_Types.FLOAT64;

	
	@Override
	public default long getSignature() { 
		return SIGNATURE; 
	}
	
	
	public abstract void run(S8AsyncFlow flow, double arg);
	
}
