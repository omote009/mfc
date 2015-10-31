package mfc.consts;

import org.seasar.framework.util.StringUtil;
import org.seasar.struts.util.MessageResourcesUtil;

public class PropConst {

	private PropConst() {

		super();
	}

	/**
	 *
	 * SAStrusのユーティリティのMessageResourceUtil.getMessage(key)のラッパー<br />
	 * 基本的にConst定義はすべてプロパティファイルに書く<br />
	 * 独自にConst定義をすると多言語化が面倒であるため。
	 *
	 * @param key
	 * @return プロパティから取得した文字列
	 */

	public static String get(final String key) {

		if (StringUtil.isBlank(key)) {
			return "";
		}
		return MessageResourcesUtil.getMessage(key);

	}

}
