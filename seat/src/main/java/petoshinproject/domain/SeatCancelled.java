package petoshinproject.domain;

import java.util.*;
import lombok.*;
import petoshinproject.domain.*;
import petoshinproject.infra.AbstractEvent;

@Data
@ToString
public class SeatCancelled extends AbstractEvent {

    private Long id;
    private String seatId;
    private String customerId;
    private String status;
    private Integer qty;
}
