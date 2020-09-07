package local;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Cooklist_table")
public class Cooklist {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String cookproduct;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCookproduct() {
        return cookproduct;
    }

    public void setCookproduct(String cookproduct) {
        this.cookproduct = cookproduct;
    }




}
