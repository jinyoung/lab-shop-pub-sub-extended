package labshoppubsubextended.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshoppubsubextended.OrderApplication;
import labshoppubsubextended.domain.OrderPlaced;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private Integer qty;

    private String customerId;

    private Double amount;

    private String status;

    private String address;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {
        // Get request from Inventory
        //labshoppubsubextended.external.Inventory inventory =
        //    Application.applicationContext.getBean(labshoppubsubextended.external.InventoryService.class)
        //    .getInventory(/** mapping value needed */);

    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
