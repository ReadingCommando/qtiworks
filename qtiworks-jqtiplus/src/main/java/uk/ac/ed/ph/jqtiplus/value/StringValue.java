/* Copyright (c) 2012, University of Edinburgh.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice, this
 *   list of conditions and the following disclaimer in the documentation and/or
 *   other materials provided with the distribution.
 *
 * * Neither the name of the University of Edinburgh nor the names of its
 *   contributors may be used to endorse or promote products derived from this
 *   software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *
 * This software is derived from (and contains code from) QTItools and MathAssessEngine.
 * QTItools is (c) 2008, University of Southampton.
 * MathAssessEngine is (c) 2010, University of Edinburgh.
 */
package uk.ac.ed.ph.jqtiplus.value;

import uk.ac.ed.ph.jqtiplus.exception.QtiParseException;

/**
 * Implementation of <code>BaseType</code> string value.
 * <p>
 * See <A href="http://www.w3.org/TR/xmlschema-2/#string">XML</A> for more accurately definition.
 * <p>
 * This class is not mutable and cannot contain NULL value.
 * <p>
 * <code>Cardinality</code> of this class is always single and <code>BaseType</code> is always string.
 * 
 * @see uk.ac.ed.ph.jqtiplus.value.Cardinality
 * @see uk.ac.ed.ph.jqtiplus.value.BaseType
 * @author Jiri Kajaba
 */
public final class StringValue extends SingleValue {

    private static final long serialVersionUID = 5898101380417066220L;

    private final String stringValue;

    /**
     * Constructs <code>StringValue</code> from given <code>String</code> representation.
     * 
     * @param value <code>String</code> representation of <code>StringValue</code>
     * @throws QtiParseException if <code>String</code> representation of <code>StringValue</code> is not valid
     */
    public StringValue(String value) {
        if (value == null || value.length() == 0) {
            throw new QtiParseException("Invalid string '" + value + "'. Length is not valid.");
        }

        this.stringValue = value;
    }

    @Override
    public BaseType getBaseType() {
        return BaseType.STRING;
    }

    @Override
    public String toQtiString() {
        return stringValue;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StringValue)) {
            return false;
        }

        final StringValue other = (StringValue) object;
        return stringValue.equals(other.stringValue);
    }

    @Override
    public int hashCode() {
        return stringValue.hashCode();
    }
}
