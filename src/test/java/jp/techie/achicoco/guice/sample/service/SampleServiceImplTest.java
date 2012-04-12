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
package jp.techie.achicoco.guice.sample.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import jp.techie.achicoco.framework.util.LogUtil;

import org.junit.Test;

/**
 * SampleServiceImplテスト用クラス
 * 
 * @author bose999
 * 
 */
public class SampleServiceImplTest {

	/**
	 * ログユーティリティ
	 */
	public static LogUtil logUtil = new LogUtil(SampleServiceImplTest.class);

	/**
	 * outputParamLog()テスト<br />
	 * nullを渡したら空文字になるか？
	 */
	@Test
	public void testOutputParamLog01() {
		String checkString = null;
		try {
			SampleService sampleService = new SampleServiceImpl();
			checkString = sampleService.outputParamLog(null, null);
			assertEquals(checkString, "");
		} catch (Exception e) {
			fail();
			logUtil.fatal("Exception", e);
		}
	}

	/**
	 * outputParamLog()テスト<br />
	 * Listの文字列が, 区切りで連結されるか？
	 */
	@Test
	public void testOutputParamLog02() {
		SampleService sampleService = new SampleServiceImpl();
		List<String> urlParamList = new ArrayList<String>();
		urlParamList.add("test1");
		urlParamList.add("test2");
		urlParamList.add("test3");
		String checkString = null;
		try {
			checkString = sampleService.outputParamLog(urlParamList, null);
			assertEquals(checkString, "test1, test2, test3");
		} catch (Exception e) {
			fail();
			logUtil.fatal("Exception", e);
		}
	}

	/**
	 * checkThreadSafe()テスト<br />
	 * nullが渡されたら-1になるか？
	 */
	@Test
	public void testCheckThreadSafe01() {
		SampleServiceImplMock sampleService = new SampleServiceImplMock();
		assertEquals(-1, sampleService.checkThreadSafe(null));
	}

	/**
	 * checkThreadSafe()テスト<br />
	 * 空のListが渡されたら0になるか？
	 */
	@Test
	public void testCheckThreadSafe02() {
		SampleServiceImplMock sampleService = new SampleServiceImplMock();
		List<String> threadSafeTestList = new ArrayList<String>();
		assertEquals(0, sampleService.checkThreadSafe(threadSafeTestList));
	}

	/**
	 * checkThreadSafe()テスト<br />
	 * Listが渡されたらリスト数が返ってくるか？
	 */
	@Test
	public void testCheckThreadSafe03() {
		SampleServiceImplMock sampleService = new SampleServiceImplMock();
		List<String> threadSafeTestList = new ArrayList<String>();
		threadSafeTestList.add("test1");
		threadSafeTestList.add("test2");
		threadSafeTestList.add("test3");
		assertEquals(3, sampleService.checkThreadSafe(threadSafeTestList));
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
	 * protected メソッドテスト用SampleServiceImp
	 * 
	 * @author bose999
	 * 
	 */
	private class SampleServiceImplMock extends SampleServiceImpl {
		public int checkThreadSafe(List<String> threadSafeTestList) {
			return super.checkThreadSafe(threadSafeTestList);
		}
	}
}
