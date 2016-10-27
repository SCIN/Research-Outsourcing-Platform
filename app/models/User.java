package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class User extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String password;

    public boolean done;

/*
    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dueDate = new Date();*/

    public static Finder<Long, User> find = new Finder<Long,User>(User.class);


}