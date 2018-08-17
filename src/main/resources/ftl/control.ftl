package ${urlMap.baseUrl}.${urlMap.controlUrl};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ${urlMap.baseUrl}.${urlMap.serviceUrl}.I${tableName?cap_first}Service;
import ${urlMap.baseUrl}.${urlMap.beanUrl}.${tableName?cap_first};
/**
* Controller of ${tableName}
*
* @author ${author}
*/
@Controller
@RequestMapping("/${tableName}")
public class ${tableName?cap_first}Controller {

         @Autowired
         private I${tableName?cap_first}Service ${tableName}Service;


}