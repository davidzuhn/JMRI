package jmri.jmrix.can.cbus.swing.cbusslotmonitor;

import java.awt.GraphicsEnvironment;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 * Test simple functioning of CbusSlotMonitorDataModel
 *
 * @author	Paul Bender Copyright (C) 2016
 */
public class CbusSlotMonitorDataModelTest {
        
 
    jmri.jmrix.can.TrafficControllerScaffold tcs = null;
    jmri.jmrix.can.CanSystemConnectionMemo memo = null;

    @Test
    public void testCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        CbusSlotMonitorDataModel model = new CbusSlotMonitorDataModel(memo,5,5);
        Assert.assertNotNull("exists", model);
    }

    @Before
    public void setUp() {
        JUnitUtil.setUp();
        tcs = new jmri.jmrix.can.TrafficControllerScaffold();
        memo = new jmri.jmrix.can.CanSystemConnectionMemo();
        memo.setTrafficController(tcs);

    }

    @After
    public void tearDown() {        JUnitUtil.tearDown();    }

}
