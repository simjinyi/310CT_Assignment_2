//  -*- Mode: Java -*-
//////////////////////////////////////////////////////////////////////////////
//  
//  $Id: PlanSimpleConstruct.java,v 1.1 1998/05/09 18:32:24 marcush Exp marcush $
//  $Source: C:\\com\\irs\\jam\\RCS\\PlanSimpleConstruct.java,v $
//  
//  File              : PlanSimpleConstruct.java
//  Original author(s): Marcus J. Huber <marcush@heron.eecs.umich.edu>
//                    : Jaeho Lee <jaeho@heron.eecs.umich.edu>
//  Created On        : Tue Sep 30 14:20:56 1997
//  Last Modified By  : marcush <marcush@irs.home.com>
//  Last Modified On  : Tue Jul 27 13:31:25 1999
//  Update Count      : 14
//  
//////////////////////////////////////////////////////////////////////////////
//
//  JAM agent architecture
//
//  Copyright (C) 1997 Marcus J. Huber and Jaeho Lee.
//  Copyright (C) 1997-1999 Intelligent Reasoning Systems
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
//  Marcus J. Huber, Jaeho Lee and Intelligent Reasoning Systems shall
//  not be liable for any damages, including special, indirect,
//  incidental, or consequential damages, with respect to any claim
//  arising out of or in connection with the use of the software, even
//  if they have been or are hereafter advised of the possibility of
//  such damages.
// 
//////////////////////////////////////////////////////////////////////////////

package com.irs.jam;

import java.io.*;

/**
 * Represents non-construct plan components
 *
 * @author Marc Huber
 * @author Jaeho Lee
 *
 **/

public class PlanSimpleConstruct extends PlanConstruct implements Serializable
{

  //
  // Members
  //
  protected Action		_action;

  //
  // Constructors
  //

  /**
   * 
   * 
   */
  public PlanSimpleConstruct(Action a)
  {
    _action = a;
    _constructType = PLAN_SIMPLE;
  }

  //
  // Member functions
  //
  public Action		getAction()		{ return _action; }
  public Action		setAction(Action a)	{ return _action = a; }

  /**
   * 
   * 
   */
  public PlanRuntimeState newRuntimeState()
  {
    if (_action.isExecutableAction())
      return new PlanRuntimeSimpleState(this);
    else
      return new PlanRuntimeGoalState(this);
  }

}
