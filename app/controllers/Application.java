package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;
import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;
import play.data.DynamicForm;
import play.data.Form;
import play.data.*;
import play.data.format.*;
import models.*;

public class Application extends Controller {
    private dbHandle db = new dbHandle();

    public Result index() {
        return ok(index.render());
    }

    public Result getName() {
        return ok(index.render());
    }

    public Result loginSubmit() {

        DynamicForm form = Form.form().bindFromRequest();

        if (form.data().size() != 2) {
            return badRequest("Bad Login Request");
        } else {
            String userName = form.get("userName");
            String password = form.get("password");
            String dbPassword = db.getPassword(userName);
            if (password.equals(dbPassword)) {
                return ok("login Success");
            } else {
                return notFound("Invalid Login");
            }
        }
    }

    public Result registerUser() {
        DynamicForm form = Form.form().bindFromRequest();
        if (form.data().size() != 5) {
            System.out.println(form.data());
            return badRequest("Bad Register Request");
        } else {
            String userName = form.get("username");
            String password = form.get("password");
            String email = form.get("email");
            String question = form.get("question");
            String answer = form.get("answer");
            try {
                boolean register = db.saveUser(userName, password, email, question, answer);
                if (register) {
                    return ok("Register Success");
                } else {
                    return ok("User Exists");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return badRequest("Bad Register Request");
            }

        }
    }

    public Result getUserInfo(String username) {
        User user = db.getUser(username);
        return user == null ? notFound() : ok(Json.toJson(user));
    }

    public Result getProviderInfo(String username) {
        ServicePublications provider = db.getProviderInfo(username);

        //return provider == null ? notFound() : ok(Json.toJson(provider));

        return (provider == null) ? notFound() : ok(Json.toJson(provider));

    }

    public Result updateProviderInfo(String username) {
        DynamicForm form = Form.form().bindFromRequest();
        if (form.data().size() != 5) {
            System.out.println(form.data());
            return badRequest("Bad update length!");
        } else {
            String credential = form.get("credential");
            String researchAreas = form.get("researchAreas");
            String publications = form.get("publications");
            String professionalServices = form.get("professionalServices");
            try {
                boolean register = db.updateProviderInfo(username, credential, researchAreas, publications, professionalServices);
                if (register) {
                    return ok("Update Success");
                } else {
                    return ok("Update Failure");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return badRequest("Bad update Request");
            }
        }
    }
}
