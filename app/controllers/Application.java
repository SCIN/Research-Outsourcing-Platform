package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import play.data.DynamicForm;
import play.data.Form;

public class Application extends Controller {

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
        if (form.data().size() != 2) {
            return badRequest("Bad Request!!!!!!");
        } else {
            String response = "Register the user: " + "Username " + form.get("userName") + " Password " + form.get("password");
            return ok(response);
        }
    }

}
