/*
*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*
*/

package org.apache.airavata.experiment.catalog;
import static org.junit.Assert.*;

import org.apache.airavata.registry.core.experiment.catalog.ExpCatResourceUtils;
import org.apache.airavata.registry.core.experiment.catalog.resources.ConfigurationExperimentCatResource;
import org.junit.After;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;

public class ConfigurationExperimentCatResourceTest extends AbstractResourceTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }
    @Test
    public void testSave() throws Exception {
        ConfigurationExperimentCatResource configuration = ExpCatResourceUtils.createConfiguration("testConfigKey");
        configuration.setConfigVal("testConfigValue");
        Calendar calender = Calendar.getInstance();
        java.util.Date d = calender.getTime();
        Timestamp currentTime = new Timestamp(d.getTime());
        configuration.setExpireDate(currentTime);
        configuration.setCategoryID("SYSTEM");
        configuration.save();

        assertTrue("Configuration Save succuessful", ExpCatResourceUtils.isConfigurationExist("testConfigKey"));
        //remove test configuration
        ExpCatResourceUtils.removeConfiguration("testConfigKey");
    }

    @After
    public void tearDown() throws Exception {
    }
}