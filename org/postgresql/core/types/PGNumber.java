/*
 * Created on May 15, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.postgresql.core.types;

import java.sql.Types;

import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;

/**
 * @author davec
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PGNumber implements PGType
{
    private Number val;
    
    public PGNumber( Number x )
    {
        val = x;
    }
    public PGType castToServerType( int targetType ) throws PSQLException
    {
        try
        {
            switch ( targetType )
            {
            case Types.BOOLEAN:
            case Types.BIT:
                return new PGBoolean( val.doubleValue() == 0?Boolean.FALSE:Boolean.TRUE );
            
            case Types.BIGINT:
                return new PGLong(new Long( val.longValue() ));
            case Types.INTEGER:
                return new PGInteger(new Integer( val.intValue() ) );
            case Types.TINYINT:
            case Types.SMALLINT:
                return new PGShort(new Short( val.shortValue() ));
            case Types.VARCHAR:
                return new PGString( toString() );
            case Types.DOUBLE:
            case Types.FLOAT:
                return( new PGDouble( new Double( val.doubleValue())));
            case Types.REAL:
                return (new PGFloat( new Float( val.floatValue())));
            case Types.DECIMAL:
            case Types.NUMERIC:
                return this;
            default:
                return new PGUnknown(val);                
            }
        }
        catch( Exception ex )
        {
            throw new PSQLException("Error", new PSQLState(""),ex);
        }
    }
    public String toString()
    {
        return val.toString();
    }
    
}