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

import java.util.List;

import jp.techie.achicoco.framework.util.LogUtil;

/**
 * シングルトンでインスタンス化されるサービスクラス実装のサンプル
 * 
 * @author bose999
 * 
 */
public class SampleServiceImpl implements SampleService {

	/**
	 * ログユーティリティ
	 */
	public static LogUtil logUtil = new LogUtil(SampleServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.techie.achicoco.guice.sample.service.SampleService#paramLogOut(java
	 * .util.List, java.util.List)
	 */
	public String outputParamLog(List<String> urlParamList,
			List<String> threadSafeTestList) throws Exception {
		String urlParamString = "";
		int count = 0;
		if (urlParamList != null) {
			for (String urlParam : urlParamList) {
				if (urlParam == null) {
					logUtil.trace("SampleAction.run() null");
				} else {
					logUtil.trace(String.valueOf(count));
					if (count == 0) {
						urlParamString = urlParam;
					} else {
						urlParamString = urlParamString + ", " + urlParam;
					}
					logUtil.trace(urlParam);
					logUtil.trace(urlParamString);
					count++;
				}
			}
		}
		checkThreadSafe(threadSafeTestList);
		return urlParamString;
	}

	/**
	 * スレッドセーフか確かめるメソッド<br />
	 * DIコンテナの設定を間違えるとログを出力する
	 * 
	 * @param threadSafeTestList
	 * @return threadSafeTestListの要素数
	 */
	protected int checkThreadSafe(List<String> threadSafeTestList) {
		int threadSafeTestListSize = -1;
		if (threadSafeTestList != null) {
			threadSafeTestListSize = threadSafeTestList.size();
			if (threadSafeTestListSize == 0) {
				logUtil.fatal("list 0");
				threadSafeTestList.add("testData");
			} else {
				// Actionが毎回Newされてればaddは一回のみ
				logUtil.fatal("---------- non thread safe ----------");
			}
		} else {
			logUtil.fatal("---------- threadSafeTestList null ----------");
		}
		return threadSafeTestListSize;
	}
}
