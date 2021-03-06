/*-------------------------------------------------------------------------
*
* Copyright (c) 2009-2014, PostgreSQL Global Development Group
*
*
*-------------------------------------------------------------------------
*/

package org.postgresql.copy;

import java.sql.SQLException;

public interface CopyOut extends CopyOperation {
  byte[] readFromCopy() throws SQLException;
}
