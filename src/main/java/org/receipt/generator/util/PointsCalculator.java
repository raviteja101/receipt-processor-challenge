package org.receipt.generator.util;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.receipt.generator.model.ReceiptRequest;
import org.receipt.generator.service.rulehandler.RuleHandler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PointsCalculator {


    @Autowired
    private RulesUtil rulesUtil;

    @Autowired
    private BeanFactory beanFactory;

    public int processRules(ReceiptRequest receiptRequest) {

        List<String> tasks = rulesUtil.getRulesOperations("rules");
        int points = 0;

        for(String task : tasks) {
            try {
                RuleHandler ruleHandler = (RuleHandler) beanFactory.getBean(task);
                points += ruleHandler.handleRequest(receiptRequest);
            } catch (Exception e) {
                log.error("Exception occured while calculating rules due to: {}", e.getMessage());
                throw e;
            }
        }
        return points;
    }
}
