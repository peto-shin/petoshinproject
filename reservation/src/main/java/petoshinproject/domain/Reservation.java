package petoshinproject.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petoshinproject.ReservationApplication;
import petoshinproject.domain.ReservationComp;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String constomerId;

    private String orderId;

    @PostPersist
    public void onPostPersist() {
        ReservationComp reservationComp = new ReservationComp(this);
        reservationComp.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void selectToSeatList(SelectionSeat selectionSeat) {
        //implement business logic here:

        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        */

        /** Example 2:  finding and process
        
        repository().findById(selectionSeat.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
