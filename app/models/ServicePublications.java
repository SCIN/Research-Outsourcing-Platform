package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class ServicePublications extends Model {
/*
    @Id
    @Constraints.Min(10)
    public Long id;*/

    @Id
    @Constraints.Required
    public String username;

    @Column(name = "credential")
    public String credential;


    @Column(name = "researchArea")
    public String researchArea;

    @Column(name = "publications")
    public String publications;

    @Column(name = "professionalServices")
    public String professionalServices;
    //public boolean done;

/*
    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dueDate = new Date();*/

    public static Finder<String, ServicePublications> find = new Finder<String,ServicePublications>(ServicePublications.class);


}