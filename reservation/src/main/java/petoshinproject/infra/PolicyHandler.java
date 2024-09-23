package petoshinproject.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petoshinproject.config.kafka.KafkaProcessor;
import petoshinproject.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ReservationRepository reservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SelectionSeat'"
    )
    public void wheneverSelectionSeat_SelectToSeatList(
        @Payload SelectionSeat selectionSeat
    ) {
        SelectionSeat event = selectionSeat;
        System.out.println(
            "\n\n##### listener SelectToSeatList : " + selectionSeat + "\n\n"
        );

        // Sample Logic //
        Reservation.selectToSeatList(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
