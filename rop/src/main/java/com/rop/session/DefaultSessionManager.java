/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rop.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author libinsong@gmail.com
 * @author 陈雄华 itstamen@qq.com
 */
public final class DefaultSessionManager implements SessionManager {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private final Map<String, Session> sessionCache = new ConcurrentHashMap<String, Session>(128, 0.75f, 32);


    public void addSession(String sessionId, Session session) {
        sessionCache.put(sessionId, session);
    }


    public Session getSession(String sessionId) {
        return sessionCache.get(sessionId);
    }


    public void removeSession(String sessionId) {
        sessionCache.remove(sessionId);
    }

}