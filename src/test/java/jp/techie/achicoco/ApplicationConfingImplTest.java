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
package jp.techie.achicoco;

import static org.junit.Assert.assertEquals;

import java.util.ResourceBundle;

import jp.techie.achicoco.framework.util.LogUtil;

import org.junit.Test;

/**
 * ApplicationConfingImpl用テストクラス
 * 
 * @author bose999
 * 
 */
public class ApplicationConfingImplTest {
	
	/**
	 * ログユーティリティ
	 */
	public static LogUtil logUtil = new LogUtil(ApplicationConfingImplTest.class);

	/**
	 * getActionPackageName()テスト<br />
	 * ApplicationConfingImpl.PAKAGE_NAME が返ってくるか？
	 */
	@Test
	public void testGetActionPackageName() {
		ApplicationConfingImpl applicationConfingImpl = new ApplicationConfingImpl();
		String actionPackageName = applicationConfingImpl
				.getActionPackageName();
		assertEquals(actionPackageName, ApplicationConfingImpl.PAKAGE_NAME);
	}

	/**
	 * getErrorUrl()テスト<br />
	 * ApplicationConfingImpl.ERROR_URL が返ってくるか？
	 */
	@Test
	public void testGetErrorUrl() {
		ApplicationConfingImpl applicationConfingImpl = new ApplicationConfingImpl();
		String errorUrl = applicationConfingImpl.getErrorUrl();
		assertEquals(errorUrl, ApplicationConfingImpl.ERROR_URL);

	}

	/**
	 * getMessageBadUrl()テスト<br />
	 * messages.propertiesのbadUrlErrorの値が返ってくるか？
	 */
	@Test
	public void testGetMessageBadUrl() {
		ApplicationConfingImpl applicationConfingImpl = new ApplicationConfingImpl();
		String badUrlError = applicationConfingImpl.getMessageBadUrl();
		ResourceBundle bundle = ResourceBundle.getBundle("messages");
		assertEquals(badUrlError, bundle.getString("badUrlError"));
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
}
