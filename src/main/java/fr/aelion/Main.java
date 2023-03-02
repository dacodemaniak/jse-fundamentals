package fr.aelion;

import fr.aelion.annotations.Controller;
import fr.aelion.annotations.RequestMapping;
import fr.aelion.controllers.StudentController;
import fr.aelion.core.ProcessRequest;
import fr.aelion.helpers.request.Request;
import fr.aelion.run.CourseRun;
import fr.aelion.run.MediaRun;
import fr.aelion.run.StudentRun;
import fr.aelion.services.courses.DisplayCourse;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Request request = new Request();
        request.setPath("api/v1/student");
        request.setVerb("GET");

        var processRequest = new ProcessRequest();
        processRequest.setRequest(request);
        try {
            processRequest.process();
        } catch (NoSuchMethodException e) {

        } catch (InvocationTargetException e) {

        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {

        }

    }

}