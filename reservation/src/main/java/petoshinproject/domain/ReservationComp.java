package petoshinproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petoshinproject.domain.*;
import petoshinproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReservationComp extends AbstractEvent {

    private Long id;
    private String constomerId;
    private String orderId;

    public ReservationComp(Reservation aggregate) {
        super(aggregate);
    }

    public ReservationComp() {
        super();
    }
}
//>>> DDD / Domain Event
