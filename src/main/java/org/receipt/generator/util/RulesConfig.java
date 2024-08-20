package org.receipt.generator.util;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "cor")
@Component
@Data
public class RulesConfig {

  private Map<String, List<String>> chain;
}
