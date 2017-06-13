/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.entertainment.nifi.processor;

import com.entertainment.nifi.processor.HipchatPut;
import org.apache.nifi.util.MockFlowFile;
import org.apache.nifi.util.TestRunner;
import org.apache.nifi.util.TestRunners;
import org.junit.Before;
import org.junit.Test;


public class HipchatPutTest {

    private TestRunner runner;

    @Before
    public void init() {
        runner = TestRunners.newTestRunner(HipchatPut.class);
    }

    @Test
    public void testProcessor() {

        runner.enqueue("Test input flow file");
        runner.setValidateExpressionUsage(false);

        runner.setProperty(HipchatPut.MESSAGE_TEXT, "test");
        runner.setProperty(HipchatPut.MESSAGE_BG_COLOR, "green");
        runner.setProperty(HipchatPut.FROM, "Apache Niifi");
        String token = System.getProperty("HIPCHAT_TOKEN");
        String roomId = System.getProperty("HIPCHAT_ROOMID");
        runner.setProperty(HipchatPut.ROOM_ID, roomId);
        runner.setProperty(HipchatPut.AUTH_TOKEN, token);
        runner.setProperty(HipchatPut.API_VERSION, "v1");


        runner.run(1);

    }

}
