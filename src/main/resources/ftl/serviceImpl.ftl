package ${urlMap.baseUrl}.${urlMap.serviceImplUrl};

import ${urlMap.baseUrl}.${urlMap.serviceUrl}.I${tableName?cap_first}Service;
import org.springframework.beans.factory.annotation.Autowired;
import ${urlMap.baseUrl}.${urlMap.daoUrl}.I${tableName?cap_first}Dao;
import ${urlMap.baseUrl}.${urlMap.beanUrl}.${tableName?cap_first};
import org.springframework.stereotype.Service;

@Service
public class ${tableName?cap_first}ServiceImpl implements I${tableName?cap_first}Service{


    @Autowired
    I${tableName?cap_first}Dao ${tableName}Dao;


}