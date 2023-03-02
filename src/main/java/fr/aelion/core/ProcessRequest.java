package fr.aelion.core;

import fr.aelion.annotations.Controller;
import fr.aelion.annotations.RequestMapping;
import fr.aelion.helpers.request.Request;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class ProcessRequest {
    Request request;

    public void setRequest(Request request) {
        this.request = request;
    }

    public void process() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Set<Class<?>> controllers = new Reflections("fr.aelion.controllers").getTypesAnnotatedWith(Controller.class);
        for (Class controllerClass : controllers) {
            for (Method declaredMethod : controllerClass.getDeclaredMethods()) {
                Annotation methodAnnotation = declaredMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    if (request.match(((RequestMapping) methodAnnotation).path(), ((RequestMapping) methodAnnotation).method())) {
                        // Can instanciate Controller and invoke method
                        var controller = controllerClass.getConstructor().newInstance();
                        declaredMethod.invoke(controller, null);
                        return;
                    }
                }
            }
        }
    }
}
