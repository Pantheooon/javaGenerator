package ${urlMap.baseUrl}.${urlMap.serviceImplUrl}

import org.springframework.beans.factory.annotation.Autowired;
import ${urlMap.baseUrl}.${urlMap.daoUrl}.I${tableName?cap_first}Dao;
import ${urlMap.baseUrl}.${urlMap.beanUrl}.${tableName?cap_first};
public Class ${tableName?cap_first}Impl implements I${tableName?cap_first}Service{


    @AutoWired
    I${tableName?cap_first}Dao ${tableName}Dao;


    @Override
    public ${tableName?cap_first} findById(Long id){
        return ${tableName}Dao.findById(Long id);
    }
    @Override
    public void insert(${tableName?cap_first} ${tableName}){
        ${tableName}Dao.insert(${tableName})
    }
    @Override
    public void delete(Long id){
    ${tableName}Dao.delete(id);
    }
    @Override
    public void update(${tableName?cap_first} ${tableName}){
        ${tableName}Dao.update(id);
    }
}