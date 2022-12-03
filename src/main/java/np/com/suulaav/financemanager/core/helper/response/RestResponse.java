package np.com.suulaav.financemanager.core.helper.response;

import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sulav created on 11/21/22
 */
public class RestResponse {
  public static ResponseEntity ok(Object data) {
    String code = "0";
    String date = String.valueOf(new Date().getTime());
    Map<String, Object> map = new HashMap<>();
    map.put("code", code);
    map.put("time", date);
    map.put("data", data);
    return ResponseEntity.ok().body(map);
  }
}