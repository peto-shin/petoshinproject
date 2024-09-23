package petoshinproject.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petoshinproject.config.kafka.KafkaProcessor;
import petoshinproject.domain.*;

@Service
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSelectionSeat_then_CREATE_1(
        @Payload SelectionSeat selectionSeat
    ) {
        try {
            if (!selectionSeat.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setOrderId(selectionSeat.getId());
            myPage.setSeatId(selectionSeat.getSeatId());
            myPage.setSeatStatus("선택됨");
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationComp_then_UPDATE_1(
        @Payload ReservationComp reservationComp
    ) {
        try {
            if (!reservationComp.validate()) return;
            // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findByOrderId(
                Long.valueOf(reservationComp.getOrderId())
            );

            if (myPageOptional.isPresent()) {
                MyPage myPage = myPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setReservationStatus("예약됨");
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
