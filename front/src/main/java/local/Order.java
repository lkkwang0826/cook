package local;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer qty;

    @PrePersist
    public void onPrePersist(){
        Orderplaced orderplaced = new Orderplaced();
        BeanUtils.copyProperties(this, orderplaced);
        orderplaced.publishAfterCommit();


        Ordercanceled ordercanceled = new Ordercanceled();
        BeanUtils.copyProperties(this, ordercanceled);
        ordercanceled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        local.external.Cooklist cooklist = new local.external.Cooklist();
        // mappings goes here
        FrontApplication.applicationContext.getBean(local.external.CooklistService.class)
            .cancel(cooklist);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }




}
