package listener;

import lombok.SneakyThrows;
import model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class JsonListener {
    Logger log = LoggerFactory.getLogger(JsonListener.class);
    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) throws InterruptedException {
        log.info("Recebi o pagamento {}", payment.toString());
        // Thread.sleep(2000);
        log.info("Validando Fraude ...");
        //  Thread.sleep(2000);

        log.info("Compra Aprovada ...");
        // Thread.sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator() throws InterruptedException {
        log.info("Gerando PDF ...");
        //Thread.sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() throws InterruptedException {
        log.info("Enviando Email de Confirmação ...");
    }
}
