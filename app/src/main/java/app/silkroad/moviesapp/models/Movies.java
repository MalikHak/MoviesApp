package app.silkroad.moviesapp.models;

public class Movies {
    String name;
    int id;
    int photo;


    public Movies() {
    }

    public Movies(String name, int id, int photo) {
        this.name = name;
        this.id = id;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
