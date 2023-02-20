package fr.aelion.models.course;

import fr.aelion.Interfaces.IDisplay;

import java.time.LocalDateTime;

public abstract class Media implements IDisplay {
    protected String title;
    protected String summary;
    protected LocalDateTime duration;

    protected Author author;

    public abstract void play();
    @Override
    public void display() {
        System.out.println(title + "\n" + summary + " (" + duration + ")");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDateTime getDuration() {
        return duration;
    }

    public void setDuration(LocalDateTime duration) {
        this.duration = duration;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
