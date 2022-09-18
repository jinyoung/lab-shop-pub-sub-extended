package labshoppubsubextended.domain;

import java.util.*;
import labshoppubsubextended.domain.*;
import labshoppubsubextended.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;
    private String customerId;
    private Double amount;
    private String status;
    private String address;
    // keep

}
