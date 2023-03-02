package fr.aelion.helpers.request;

public class Request {
    private String path;
    private String verb;

    public void setPath(String path) {
        this.path = path;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public boolean match(String path, String verb) {
        return path.equals(this.path) && verb.equals(this.verb);
    }
}
