package tv.politics.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tv.politics.kafka.producer.PoliticsMemberSender;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

  private final PoliticsMemberSender politicsMemberSender;

  @Autowired
  public KafkaController(PoliticsMemberSender p) {
    this.politicsMemberSender = p;
  }

  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
    this.politicsMemberSender.sendMessage(message);
  }

}
