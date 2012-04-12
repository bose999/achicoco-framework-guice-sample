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

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import jp.techie.achicoco.framework.action.AchicocoAction;
import jp.techie.achicoco.framework.util.LogUtil;
import jp.techie.achicoco.guice.sample.service.SampleService;

/**
 * サンプルアクション実行クラス
 * 
 * @author bose999
 * 
 */
public class SampleActionImpl extends AchicocoAction implements SampleAction {

	/**
	 * ログユーティリティ
	 */
	public static LogUtil logUtil = new LogUtil(SampleActionImpl.class);

	/**
	 * スレッドセーフテスト用List<br />
	 * このアクションが毎回インスタンス化されていればスレッドセーフ<br />
	 * アクションまでがスレッドごとに作成される<br />
	 * サービスのみシングルトン
	 */
	List<String> threadSafeTestList = new ArrayList<String>();

	String urlParamString;
	String errorMessage = "";

	/**
	 * ビジネスロジック用サービスクラス
	 */
	@Inject
	public SampleService sampleService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.npinc.achicoco.guice.action.AchicocoAction#run()
	 */
	public void run() {
		// ビジネスロジックをサービスクラスで実行
		try {
			runBefore();

			urlParamString = sampleService.outputParamLog(urlParamList,
					threadSafeTestList);

			// ビジネスロジックの返り値を設定
			session.setAttribute("urlParamString", urlParamString);
			errorMessage = "nothing";
			request.setAttribute("errorString", errorMessage);

			// Action処理後の遷移先をセット
			dispatchUrl = "/WEB-INF/jsp/results.jsp";

			runAfter();
		} catch (Exception e) {
			logUtil.fatal("SampleAction.run() Exception", e);
			errorMessage = "Server side error.";
			request.setAttribute("errorString", errorMessage);
			dispatchUrl = "/WEB-INF/error/results.jsp";
		}
	}

	/**
	 * Action前処理
	 */
	protected void runBefore() {
		logUtil.debug("SampleAction start");
	}

	/**
	 * Action後処理
	 */
	protected void runAfter() {
		logUtil.debug("SampleAction end");
	}
}
