package petoshinproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petoshinproject.domain.*;
import petoshinproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SeatCancelled extends AbstractEvent {

    private Long id;
    private String seatId;
    private String customerId;
    private String status;
    private Integer qty;

    public SeatCancelled(SeatSelection aggregate) {
        super(aggregate);
    }

    public SeatCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
