package ${baseUrl}.${controlUrl}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ${baseUrl}.${IServiceUrl}.I${tableName?cap_first}Service
import ${baseUrl}.${bean}.${tableName?cap_first};
/**
* Controller of ${tableName}
*
* @author ${author}
* @date ${date}
*/
@Controller
@RequestMapping("/${tableName}")
public class ${tableName?cap_first}Controller {

@Autowired
private I${tableName?cap_first}Service ${tableName}Service;

/**
* 查询单个${tableName}
*
*/
@RequestMapping(value = "/findById",method = RequestMethod.post)
@ResponseBody
public ${tableName?cap_first} findById(Long id){
    return ${tableName}Service.findById(id);
}

/**
* 保存${tableName}
*
*/
@RequestMapping(value = "/insert")
public void insert(${tableName?cap_first} ${tableName}){
   ${tableName}Service.insert(${tableName});
}
/**
* 删除${tableName}
*
*/
@RequestMapping(value = "/insert")
public void delete(Long id){
   ${tableName}Service.delete(${tableName});
}

/**
* 更改${tableName}
*
*/
@RequestMapping(value = "/insert")
public void update(${tableName?cap_first} ${tableName}){
    ${tableName}Service.update(${tableName});
}
}