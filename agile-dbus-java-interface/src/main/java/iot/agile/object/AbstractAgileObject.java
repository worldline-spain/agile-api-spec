/*******************************************************************************
 * Copyright (C) 2017 Create-Net / FBK.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Create-Net / FBK - initial API and implementation
 ******************************************************************************/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot.agile.object;

import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.exceptions.DBusException;

/**
 *
 * @author Luca Capra <lcapra@create-net.org>
 */
abstract public class AbstractAgileObject implements AgileObjectInterface {

  protected DBusConnection connection;

  @Override
  public void dbusConnect(final String busName, final String busPath, DBusInterface iface) throws DBusException {

    connection = DBusConnection.getConnection(AgileObjectInterface.DEFAULT_DBUS_CONNECTION);

    connection.requestBusName(busName);
    connection.exportObject(busPath, iface);

    // ensure DBus object is unregistered
    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        try {
          connection.releaseBusName(busName);
          dbusDisconnect();
        } catch (DBusException ex) {
        }
      }
    });

  }

  @Override
  public void dbusDisconnect() {
    connection.disconnect();
  }

}
