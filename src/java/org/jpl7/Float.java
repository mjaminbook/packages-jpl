package org.jpl7;

import java.util.Map;

import org.jpl7.fli.Prolog;
import org.jpl7.fli.term_t;

/**
 * Float is a specialised Term with a double field, representing a Prolog 64-bit ISO/IEC floating point value. Once constructed, a Float's value cannot be altered.
 * 
 * <pre>
 * Float f = new Float(3.14159265);
 * </pre>
 * 
 * A Float can be used (and re-used) in Compound Terms. Two Float instances are equal (by .equals()) iff their (double) values are equal.
 * 
 * <hr>
 * Copyright (C) 2004 Paul Singleton
 * <p>
 * Copyright (C) 1998 Fred Dushin
 * <p>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * <ol>
 * <li> Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *
 * <li> Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in
 *      the documentation and/or other materials provided with the
 *      distribution.
 * </ol>
 *
 * <p>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * <hr>
 * 
 * @see org.jpl7.Term
 * @see org.jpl7.Compound
 */
public class Float extends Term {

	/**
	 * this Float's immutable (double) value
	 */
	protected final double value;

	/**
	 * construct a Float with the supplied (double) value
	 * 
	 * @param value
	 *            this Float's value
	 */
	public Float(double value) {
		this.value = value;
	}

	/**
	 * the (zero) arguments of a Float, as a (zero-length) Term[]
	 * 
	 * @return the (zero) arguments of a Float, as a (zero-length) Term[]
	 */
	public Term[] args() {
		return new Term[] {};
	}

	/**
	 * returns the (double) value of this Float
	 * 
	 * @return the (double) value of this Float
	 */
	public final double doubleValue() {
		return this.value;
	}

	/**
	 * Two Floats are equal if they are the same object, or their values are equal
	 * 
	 * @param obj
	 *            The Object to compare
	 * @return true if the Object satisfies the above condition
	 */
	public final boolean equals(Object obj) {
		return this == obj || (obj instanceof Float && value == ((Float) obj).value);
	}

	/**
	 * returns the (double) value of this Float, converted to a float
	 * 
	 * @return the (double) value of this Float, converted to a float
	 */
	public final float floatValue() {
		return (new Double(value)).floatValue();
	}

	/**
	 * Tests whether this Float's functor has (double) 'name' and 'arity'
	 * 
	 * @return whether this Float's functor has (double) 'name' and 'arity'
	 */
	public final boolean hasFunctor(double val, int arity) {
		return val == this.value && arity == 0;
	}

	/**
	 * returns the (double) value of this Float, converted to an int
	 * 
	 * @return the (double) value of this Float, converted to an int
	 */
	public final int intValue() {
		return (new Double(value)).intValue();
	}

	public Object jrefToObject() {
		throw new JPLException("term is not a JRef");
	}

	/**
	 * returns the (double) value of this Float, converted to a long
	 * 
	 * @return the (double) value of this Float, converted to a long
	 */
	public final long longValue() {
		return (new Double(value)).longValue();
	}

	/**
	 * To convert a JPL Float to a Prolog term, we put its value field into the term_t as a float.
	 * 
	 * @param varnames_to_vars
	 *            A Map from variable names to Prolog variables.
	 * @param term
	 *            A (previously created) term_t which is to be set to a Prolog float corresponding to this Float's value
	 */
	protected final void put(Map<String, term_t> varnames_to_vars, term_t term) {
		Prolog.put_float(term, value);
	}

	/**
	 * Returns a Prolog source text representation of this Float
	 * 
	 * @return a Prolog source text representation of this Float
	 */
	public String toString() {
		return "" + value + "";
	}

	public final int type() {
		return Prolog.FLOAT;
	}

	public String typeName() {
		return "Float";
	}

	// /**
	// * The immutable value of this jpl.Float object, as a Java double
	// *
	// * @return the Float's value
	// * @deprecated use one of doubleValue(), floatValue(), intValue(), longValue()
	// */
	// public double value() {
	// return value;
	// }

	// /**
	// * Returns a debug-friendly String representation of this Float
	// *
	// * @return a debug-friendly String representation of this Float
	// * @deprecated
	// */
	// public String debugString() {
	// return "(Float " + toString() + ")";
	// }

}
