package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Rates extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String user;

    @Constraints.Required
    public String provider;

    @Column(name = "projectRate")
    public String projectRate;

    @Column(name = "providerRecommend")
    public String providerRecommend;

    @Column(name = "comments")
    public String comments;

    //public boolean done;

/*
    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dueDate = new Date();*/

    public static Finder<Long, Rates> find = new Finder<Long,Rates>(Rates.class);


}