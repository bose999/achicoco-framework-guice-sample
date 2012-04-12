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

/**
 * シングルトンでインスタンス化されるサービスクラスのサンプル
 * 
 * @author bose999
 * 
 */
public interface SampleService {

	/**
	 * パラメータListを,区切りでString化<br />
	 * threadSafeTestListを使ってスレッドセーフチェック
	 * 
	 * @param urlParamList
	 *            List<String>
	 * @param threadSafeTestList
	 *            List<String>
	 * @return String
	 * @throws Exception
	 */
	public String outputParamLog(List<String> urlParamList,
			List<String> threadSafeTestList) throws Exception;
}
