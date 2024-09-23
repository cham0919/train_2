package train.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import train.ReserveApplication;
import train.domain.Reserved;

@Entity
@Table(name = "Reserve_table")
@Data
//<<< DDD / Aggregate Root
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String train;

    private String seat;

    private String time;

    private String cost;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        train.external.Ticket ticket = new train.external.Ticket();
        // mappings goes here
        ReserveApplication.applicationContext
            .getBean(train.external.TicketService.class)
            .decreaseTicket(ticket);

        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();
    }

    public static ReserveRepository repository() {
        ReserveRepository reserveRepository = ReserveApplication.applicationContext.getBean(
            ReserveRepository.class
        );
        return reserveRepository;
    }
}
//>>> DDD / Aggregate Root
