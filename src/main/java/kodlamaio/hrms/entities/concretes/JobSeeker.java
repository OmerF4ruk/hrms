package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id")
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String LastName;

    @Column(name="identity_number")
    private String nationalityId;

    @Column(name="birth_date")
    private Date dateOfBirth;


}
