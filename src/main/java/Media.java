public abstract class Media {
    protected String title;
    protected String yearPublished;
    protected int id;
    protected boolean availability;

    public Media(String title, String yearPublished, int id) {
        this.title = title;
        this.yearPublished = yearPublished;
        this.id = id;
        availability = true;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return availability;
    }


    public void setUnavailable() {
        availability = false;
    }

    public void setAvailable() {
        availability = true;
    }

    public abstract String toString();
}
