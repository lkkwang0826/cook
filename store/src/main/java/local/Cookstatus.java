package local;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Cookstatus_table")
public class Cookstatus {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String status;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
