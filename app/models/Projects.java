package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Projects extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String projectName;

    @Constraints.Required
    public String provider;

    @Constraints.Required
    public String status;

    @Column(name = "description")
    public String description;

    @Column(name = "rate")
    public Double rate;


    //public boolean done;

/*
    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dueDate = new Date();*/

    public static Finder<Long, Projects> find = new Finder<Long,Projects>(Projects.class);


}