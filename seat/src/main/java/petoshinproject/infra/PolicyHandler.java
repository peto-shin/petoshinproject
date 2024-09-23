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
    SeatRepository seatRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SelectionSeat'"
    )
    public void wheneverSelectionSeat_DecreaseSeat(
        @Payload SelectionSeat selectionSeat
    ) {
        SelectionSeat event = selectionSeat;
        System.out.println(
            "\n\n##### listener DecreaseSeat : " + selectionSeat + "\n\n"
        );

        // Sample Logic //
        Seat.decreaseSeat(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SeatCancelled'"
    )
    public void wheneverSeatCancelled_IncreaseSeat(
        @Payload SeatCancelled seatCancelled
    ) {
        SeatCancelled event = seatCancelled;
        System.out.println(
            "\n\n##### listener IncreaseSeat : " + seatCancelled + "\n\n"
        );

        // Sample Logic //
        Seat.increaseSeat(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
