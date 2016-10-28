package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;
import play.*;
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
            return badRequest("Bad Request!!!!!!");
        } else {
            String response = "Username: " + form.get("userName") + " Password: " + form.get("password");
            return ok(response);
        }
    }
    
    public Result registerUser() {
        DynamicForm form = Form.form().bindFromRequest();
        if (form.data().size() != 5) {
            return badRequest("Bad Register Request");
        } else {
            String userName = form.get("userName");
            String password = form.get("password");
            String email = form.get("email");
            String question = form.get("question");
            String answer = form.get("answer");
            
            return ok("Register Success");
        }
    }

}
