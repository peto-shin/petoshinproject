package petoshinproject.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import petoshinproject.domain.*;

@Component
public class SeatHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Seat>> {

    @Override
    public EntityModel<Seat> process(EntityModel<Seat> model) {
        return model;
    }
}
