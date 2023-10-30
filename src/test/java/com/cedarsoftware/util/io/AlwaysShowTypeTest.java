package com.cedarsoftware.util.io;

import com.cedarsoftware.util.DeepEquals;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author John DeRegnaucourt (jdereg@gmail.com)
 *         <br>
 *         Copyright (c) Cedar Software LLC
 *         <br><br>
 *         Licensed under the Apache License, Version 2.0 (the "License")
 *         you may not use this file except in compliance with the License.
 *         You may obtain a copy of the License at
 *         <br><br>
 *         http://www.apache.org/licenses/LICENSE-2.0
 *         <br><br>
 *         Unless required by applicable law or agreed to in writing, software
 *         distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *         See the License for the specific language governing permissions and
 *         limitations under the License.
 */
class AlwaysShowTypeTest
{
    @Test
    void testAlwaysShowType()
    {
        TestObject btc = new TestObject("Bitcoin");
        btc._other = new TestObject("Satoshi");
        String json0 = TestUtil.toJson(btc, new WriteOptionsBuilder().forceTypeInfo().build());
        TestObject thatBtc = (TestObject) TestUtil.toJava(json0);
        assertTrue(DeepEquals.deepEquals(btc, thatBtc));
        String json1 = TestUtil.toJson(btc);
        assertTrue(json0.length() > json1.length());
    }
}