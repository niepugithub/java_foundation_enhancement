import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/5 14:02
 **/
public class JsonTest {

    @Test
    public void testReadTree() throws IOException {
        String jsonstr = "{\"msg\":{\"head\":{\"version\":\"1.0\",\"bizcode\":\"1006\",\"senddate\":\"20140827\",\"sendtime\":\"110325\",\"seqid\":\"1\"},\"body\":{\"datalist\":\"wahaha\",\"rstcode\":\"000000\",\"rstmsg\":\"成功\"}}}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonstr);
        System.out.println(jsonNode.get("msg").get("head"));
        System.out.println(jsonNode.get("msg").get("head").traverse());
    }
}
