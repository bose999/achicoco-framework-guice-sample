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

import java.util.ResourceBundle;

import jp.techie.achicoco.guice.sample.action.SampleAction;
import jp.techie.achicoco.guice.sample.action.SampleActionImpl;
import jp.techie.achicoco.guice.sample.service.SampleService;
import jp.techie.achicoco.guice.sample.service.SampleServiceImpl;

import com.google.inject.Scopes;
import jp.techie.achicoco.framework.guice.conf.AbstractApplicationConfingImpl;

/**
 * 設定値実装クラス<br />
 * 変数とDI設定を記述する
 * 
 * @author bose999
 * 
 */
public class ApplicationConfingImpl extends AbstractApplicationConfingImpl {

	/**
	 * DIするActionクラスのパッケージ名
	 */
	public final static String PAKAGE_NAME = "jp.techie.achicoco.guice.sample.action";

	/**
	 * エラー時に遷移するURL
	 */
	public final static String ERROR_URL = "/WEB-INF/jsp/error.jsp";

	/**
	 * Guiceの設定
	 */
	@Override
	public void configure() {
		// Actionクラスなのでスコープなし サービスクラスはシングルトンで
		bind(SampleAction.class).to(SampleActionImpl.class).in(Scopes.NO_SCOPE);
		bind(SampleService.class).to(SampleServiceImpl.class).in(
				Scopes.SINGLETON);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.techie.achicoco.framework.guice.conf.AbstractApplicationConfing#
	 * getActionPackageName()
	 */
	@Override
	public String getActionPackageName() {
		return PAKAGE_NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.techie.achicoco.framework.guice.conf.AbstractApplicationConfing#
	 * getErrorUrl()
	 */
	@Override
	public String getErrorUrl() {
		return ERROR_URL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.techie.achicoco.framework.guice.conf.AbstractApplicationConfing#
	 * getMessageBadUrl()
	 */
	@Override
	public String getMessageBadUrl() {
		ResourceBundle bundle = ResourceBundle.getBundle("messages");
		return bundle.getString("badUrlError");
	}
}
