
package local.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="store", url="http://store:8080")
public interface CooklistService {

    @RequestMapping(method= RequestMethod.DELETE, path="/cooklists")
    public void cancel(@RequestBody Cooklist cooklist);

}