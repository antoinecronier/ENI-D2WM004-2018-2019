package fr.acos.androkado.database.base;

public abstract class DbEntity {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
