package petoshinproject.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petoshinproject.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/seatSelections")
@Transactional
public class SeatSelectionController {

    @Autowired
    SeatSelectionRepository seatSelectionRepository;
}
//>>> Clean Arch / Inbound Adaptor
