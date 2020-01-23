package net.fullproject.spring_fullproject.Entity;
import java.lang.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
//@Table(name = "student_list")
public class Student {

    @Id
   @NotBlank(message = "Name is mandatory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   // @NotBlank(message = "Name is mandatory")
   // @Column(name = "name")
    private String name;

   // @NotBlank(message = "coursename is mandatory")
    @Column(name = "coursename")
    private String coursename;

   // @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "phoneno")
    private long phoneNo;

    public Student() {
    }


    public Student(@NotBlank(message = "Name is mandatory") String name ,
                   @NotBlank(message = "coursename is mandatory") String coursename ,
                   @NotBlank(message = "Email is mandatory") String email ,
                   long phoneNo) {
        this.name = name;
        this.coursename = coursename;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
}