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
package iot.agile;

import iot.agile.object.DeviceOverview;
import java.util.List;
import org.freedesktop.dbus.DBusInterface;

/**
 *
 * @author koustabhdolui
 */
public interface DeviceFactory extends DBusInterface {
    
    static String AGILE_INTERFACE = "iot.agile.DeviceFactory";
    /*
    *get a particular device based on the type of device provided as input
    */
    @org.freedesktop.DBus.Description("Returns an instance of Device of specified type")
    public Device getDevice(String deviceType, DeviceOverview deviceOverview) throws Exception;
    
    /*
    *Returns a list of matching device types based on the input device overview
    */
    @org.freedesktop.DBus.Description("Returns a list of matching device types from Device Factory")
    public List<String> MatchingDeviceTypes(DeviceOverview deviceOverview);
    
}
