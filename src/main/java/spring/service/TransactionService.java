package spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.aspect.AnnotationLoggerAspect;

/**
 * 声明式事务
 * @author datacharm.cn
 */

@Service
public class TransactionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationLoggerAspect.class);


    @Transactional(rollbackFor = {Exception.class})
    public void save(){
        try {
            LOGGER.info("TransactionService.save()!");
            throw new Exception("TransactionService Exception");
        }catch (Exception e){
            LOGGER.error("Exception!!!");
        }
    }


}
