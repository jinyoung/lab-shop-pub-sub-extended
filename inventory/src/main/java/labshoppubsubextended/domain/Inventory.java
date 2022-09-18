package labshoppubsubextended.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshoppubsubextended.InventoryApplication;
import lombok.Data;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long stock;

    @PostPersist
    public void onPostPersist() {}

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    public static void decreaseStock(OrderPlaced orderPlaced) {

        /** fill out following code  */
        
        repository().findById(Long.valueOf(orderPlaced.getProductId())).ifPresent(inventory->{
            
            inventory.setStock(inventory.getStock() - orderPlaced.getQty()); 
            repository().save(inventory);


         });
      

        
    }


}
