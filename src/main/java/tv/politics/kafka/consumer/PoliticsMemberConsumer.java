package tv.politics.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PoliticsMemberConsumer {

  private final Logger logger = LoggerFactory.getLogger(PoliticsMemberConsumer.class);

  @KafkaListener(topics = "users", groupId = "group_id")
  public void consume(String message) {
    logger.info(String.format("$$ -> Consumed Message -> %s", message));
  }

}
