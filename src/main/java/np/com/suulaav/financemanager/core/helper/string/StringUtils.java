package np.com.suulaav.financemanager.core.helper.string;

/**
 * @author Sulav created on 12/3/22
 */
public class StringUtils {
  public static boolean isBlankOrNull(String data) {
    return data == null || data.equals("");
  }
}