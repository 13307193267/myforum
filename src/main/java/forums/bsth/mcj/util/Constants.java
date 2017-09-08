package forums.bsth.mcj.util;


/**
 * 综合
 * @author Administrator
 *
 */
public class Constants {
	
	/** 存入session的用户信�? */
	public static final String SESSION_LOGIN_INFO = "SESSION_LOGIN_INFO";
	
	/** 上传类型 **/
	public enum uploadType {
		album("album"),
		img("img"),
		voice("voice"),
		video("video"),
		domain("domain");

		private final String value;

		uploadType(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}
	
	/**  **/
}