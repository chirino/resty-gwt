/**
 * Copyright (C) 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fusesource.restygwt.server.basic;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gwt.core.client.GWT;

/**
 *
 * Super simple servlet that simply does nothing to check if timeout management
 * is okay.
 *
 * @author <a href="mailto:mail@raphaelbauer.com">rEyez</<a>
 *
 */
public class BasicTestGwtServlet extends HttpServlet {

    String DUMMY_RESPONSE = "{\"name\":\"myName\"}";
    String SAFEHTML_RESPONSE_VALUE = "<script>alert(123)</script>";
    String SAFEHTML_RESPONSE = "{\"safeHtml\":\"" + SAFEHTML_RESPONSE_VALUE + "\","
                                + "\"unsafeString\" : \"" + SAFEHTML_RESPONSE_VALUE + "\"}";

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String responseString = null;

        if (request.getPathInfo().contains("getendpoint")) {
            responseString = DUMMY_RESPONSE;
        } else if (request.getPathInfo().contains("getsafehtmldto")) {
            responseString = SAFEHTML_RESPONSE;
        }

        response.getWriter().print(responseString);
    }

}