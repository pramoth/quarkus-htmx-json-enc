package th.co.geniustree.quarkus;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

@Path("/")
public class GreetingResource extends HxController {
    @CheckedTemplate
    public class Template{
        public static native TemplateInstance index(Student student);
        public static native TemplateInstance index$subject(Student student);
    }


    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance index() {
        Student student = new Student();
        student.getSubjects().add("CT101");
        return Template.index(student);
    }
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public TemplateInstance addSubject(Student student) {
        student.getSubjects().add("");
        return Template.index$subject(student);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public TemplateInstance form(@Valid Student student) {
        System.out.println("student: " + student);
        return Template.index(student);
    }

}
