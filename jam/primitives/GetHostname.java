//  -*- Mode: Java -*-
//////////////////////////////////////////////////////////////////////////////
//  
//  $Id: GetHostname.java,v 1.1 1998/11/04 17:08:23 marcush Exp $
//  $Source: c:/com/irs/jam/primitives/RCS/GetHostname.java,v $
//  
//  File              : GetHostname.java
//  Author(s)         : marcush <marcush@irs.home.com>
//  
//  Description       : A means for accessing the name of the computer
//                      the agent is running on.
//  
//  Original author(s): marcush <marcush@irs.home.com>
//  Organization      : Intelligent Reasoning Systems
//  Created On        : Fri Oct  2 09:35:24 1998
//  Last Modified By  : marcush <marcush@irs.home.com>
//  Last Modified On  : Tue Jul 27 13:44:40 1999
//  Update Count      : 6
//  
//////////////////////////////////////////////////////////////////////////////
//
//  JAM agent architecture
//
//  Copyright (C) 1998-1999 Marcus J. Huber and Intelligent Reasoning Systems
//  
//  Permission is granted to copy and redistribute this software so long
//  as no fee is charged, and so long as the copyright notice above, this
//  grant of permission, and the disclaimer below appear in all copies
//  made.  JAM may not be bundled, or sold alone or as part of another
//  product, without permission.
//  
//  This software is provided as is, without representation as to its
//  fitness for any purpose, and without warranty of any kind, either
//  express or implied, including without limitation the implied
//  warranties of merchantability and fitness for a particular purpose.
//  Marcus J. Huber and Intelligent Reasoning Systems shall not be
//  liable for any damages, including special, indirect, incidental, or
//  consequential damages, with respect to any claim arising out of or
//  in connection with the use of the software, even if they have been
//  or are hereafter advised of the possibility of such damages.
// 
//////////////////////////////////////////////////////////////////////////////

package com.irs.jam.primitives;

import com.irs.jam.*;

import java.io.*;
import java.net.InetAddress;

public class GetHostname implements PrimitiveAction
{

  public Value execute(String name, int arity, ExpList args,
		       Binding binding, Goal currentGoal)
  {

    if (arity != 1) {
      System.out.println("Invalid number of arguments: " + arity +
			 " to function \"" + name + "\"\n");
      return Value.FALSE;
    }

    ExpListEnumerator	ele = new ExpListEnumerator(args);
    Expression hostname = (Expression) ele.nextElement();

    String localhost;

    try {
      localhost = InetAddress.getLocalHost().getHostName();
    }
    catch (java.net.UnknownHostException he) {
      localhost = "localhost";
    }
    binding.setValue(hostname, new Value(localhost));
    
    return Value.TRUE;
  }
}

