/*
 * Copyright 2012 bose999.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package jp.techie.achicoco.guice.sample.action;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.Part;

import jp.techie.achicoco.framework.action.AchicocoAction;
import jp.techie.achicoco.framework.util.LogUtil;
import jp.techie.achicoco.guice.sample.service.SampleService;

import org.junit.Test;

/**
 * SampleActionImplテスト用クラス
 * 
 * @author bose999
 * 
 */
@SuppressWarnings("deprecation")
public class SampleActionImplTest {
	
	/**
	 * ログユーティリティ
	 */
	public static LogUtil logUtil = new LogUtil(SampleActionImplTest.class);

	/**
	 * run()テスト<br />
	 * HttpSession/HttpServletRequest/dispatchUrlの値をテスト
	 */
	@Test
	public void testRun() {

		AchicocoAction achicocoAction = new SampleActionImpl();

		HttpSession session = new HttpSessionMock();
		HttpServletRequest request = new HttpServletRequestMock();
		achicocoAction.session = session;
		achicocoAction.request = request;

		SampleActionImpl sampleAction = (SampleActionImpl) achicocoAction;
		SampleService sampleService = new SampleServiceMock();
		sampleAction.sampleService = sampleService;

		sampleAction.run();

		assertEquals(
				(String) achicocoAction.session.getAttribute("urlParamString"),
				"paramLogOutResult");
		assertEquals(
				(String) achicocoAction.request.getAttribute("errorString"),
				"nothing");
		assertEquals(sampleAction.dispatchUrl, "/WEB-INF/jsp/results.jsp");
	}
	
	/**
	 * テスト前処理
	 */
	protected void setUp() {
		logUtil.info("---------- start ----------");
	}

	/**
	 * テスト後処理
	 */
	protected void tearDown() {
		logUtil.info("---------- end ----------");
	}

	/**
	 * テスト用 SampleServiceのMockクラス
	 * 
	 * @author bose999
	 * 
	 */
	private class SampleServiceMock implements SampleService {
		public String outputParamLog(List<String> urlParamList,
				List<String> threadSafeTestList) throws Exception {
			return "paramLogOutResult";
		}
	}

	/**
	 * テスト用 HttpServletRequestのMockクラス
	 * 
	 * @author bose999
	 * 
	 */
	private class HttpServletRequestMock implements HttpServletRequest {

		Map<String, Object> attributeMap = new HashMap<String, Object>();

		public AsyncContext getAsyncContext() {
			return null;
		}

		public Object getAttribute(String arg0) {
			return attributeMap.get(arg0);
		}

		public Enumeration<String> getAttributeNames() {
			return null;
		}

		public String getCharacterEncoding() {
			return null;
		}

		public int getContentLength() {
			return 0;
		}

		public String getContentType() {
			return null;
		}

		public DispatcherType getDispatcherType() {
			return null;
		}

		public ServletInputStream getInputStream() throws IOException {
			return null;
		}

		public String getLocalAddr() {
			return null;
		}

		public String getLocalName() {
			return null;
		}

		public int getLocalPort() {
			return 0;
		}

		public Locale getLocale() {
			return null;
		}

		public Enumeration<Locale> getLocales() {
			return null;
		}

		public String getParameter(String arg0) {
			return null;
		}

		public Map<String, String[]> getParameterMap() {
			return null;
		}

		public Enumeration<String> getParameterNames() {
			return null;
		}

		public String[] getParameterValues(String arg0) {
			return null;
		}

		public String getProtocol() {
			return null;
		}

		public BufferedReader getReader() throws IOException {
			return null;
		}

		public String getRealPath(String arg0) {
			return null;
		}

		public String getRemoteAddr() {
			return null;
		}

		public String getRemoteHost() {
			return null;
		}

		public int getRemotePort() {
			return 0;
		}

		public RequestDispatcher getRequestDispatcher(String arg0) {
			return null;
		}

		public String getScheme() {
			return null;
		}

		public String getServerName() {
			return null;
		}

		public int getServerPort() {
			return 0;
		}

		public ServletContext getServletContext() {
			return null;
		}

		public boolean isAsyncStarted() {
			return false;
		}

		public boolean isAsyncSupported() {
			return false;
		}

		public boolean isSecure() {
			return false;
		}

		public void removeAttribute(String arg0) {
		}

		public void setAttribute(String arg0, Object arg1) {
			attributeMap.put(arg0, arg1);
		}

		public void setCharacterEncoding(String arg0)
				throws UnsupportedEncodingException {
		}

		public AsyncContext startAsync() throws IllegalStateException {
			return null;
		}

		public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1)
				throws IllegalStateException {
			return null;
		}

		public boolean authenticate(HttpServletResponse arg0)
				throws IOException, ServletException {
			return false;
		}

		public String getAuthType() {
			return null;
		}

		public String getContextPath() {
			return null;
		}

		public Cookie[] getCookies() {
			return null;
		}

		public long getDateHeader(String arg0) {
			return 0;
		}

		public String getHeader(String arg0) {
			return null;
		}

		public Enumeration<String> getHeaderNames() {
			return null;
		}

		public Enumeration<String> getHeaders(String arg0) {
			return null;
		}

		public int getIntHeader(String arg0) {
			return 0;
		}

		public String getMethod() {
			return null;
		}

		public Part getPart(String arg0) throws IOException, ServletException {
			return null;
		}

		public Collection<Part> getParts() throws IOException, ServletException {
			return null;
		}

		public String getPathInfo() {
			return null;
		}

		public String getPathTranslated() {
			return null;
		}

		public String getQueryString() {
			return null;
		}

		public String getRemoteUser() {
			return null;
		}

		public String getRequestURI() {
			return null;
		}

		public StringBuffer getRequestURL() {
			return null;
		}

		public String getRequestedSessionId() {
			return null;
		}

		public String getServletPath() {
			return null;
		}

		public HttpSession getSession() {
			return null;
		}

		public HttpSession getSession(boolean arg0) {
			return null;
		}

		public Principal getUserPrincipal() {
			return null;
		}

		public boolean isRequestedSessionIdFromCookie() {
			return false;
		}

		public boolean isRequestedSessionIdFromURL() {
			return false;
		}

		public boolean isRequestedSessionIdFromUrl() {
			return false;
		}

		public boolean isRequestedSessionIdValid() {
			return false;
		}

		public boolean isUserInRole(String arg0) {
			return false;
		}

		public void login(String arg0, String arg1) throws ServletException {
		}

		public void logout() throws ServletException {
		}

	}

	/**
	 * テスト用 HttpSessionのMockクラス
	 * 
	 * @author bose999
	 * 
	 */
	private class HttpSessionMock implements HttpSession {

		Map<String, Object> attributeMap = new HashMap<String, Object>();

		public Object getAttribute(String arg0) {
			return attributeMap.get(arg0);
		}

		public Enumeration<String> getAttributeNames() {
			return null;
		}

		public long getCreationTime() {
			return 0;
		}

		public String getId() {
			return null;
		}

		public long getLastAccessedTime() {
			return 0;
		}

		public int getMaxInactiveInterval() {
			return 0;
		}

		public ServletContext getServletContext() {
			return null;
		}

		public HttpSessionContext getSessionContext() {
			return null;
		}

		public Object getValue(String arg0) {
			return null;
		}

		public String[] getValueNames() {
			return null;
		}

		public void invalidate() {
		}

		public boolean isNew() {
			return false;
		}

		public void putValue(String arg0, Object arg1) {
		}

		public void removeAttribute(String arg0) {
		}

		public void removeValue(String arg0) {
		}

		public void setAttribute(String arg0, Object arg1) {
			attributeMap.put(arg0, arg1);
		}

		public void setMaxInactiveInterval(int arg0) {
		}
	}
}
