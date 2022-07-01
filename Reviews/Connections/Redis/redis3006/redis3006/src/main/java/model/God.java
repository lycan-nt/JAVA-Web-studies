package model;



import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Entity
public class God implements Serializable {

    @Id
    private String id;

    private String power;

    private Set<String> duties;

    @JsonbCreator
    public God(@JsonbProperty("id") String id,
               @JsonbProperty("power")String power,
               @JsonbProperty("duties")Set<String> duties) {

        this.id = requireNonNull(id, "id is required");
        this.power = requireNonNull(power, "power is required");
        this.duties = requireNonNull(duties, "duties is required");
    }

    God() {
    }

    public String getId() {
        return id;
    }

    public String getPower() {
        return power;
    }

    public Set<String> getDuties() {
        return duties;
    }

    public static GodBuilder builder () {
        return new GodBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof God)) {
            return false;
        }
        God god = (God) o;
        return Objects.equals(id, god.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("God{");
        sb.append("id='").append(id).append('\'');
        sb.append(", power='").append(power).append('\'');
        sb.append(", duties=").append(duties);
        sb.append('}');
        return sb.toString();
    }
}