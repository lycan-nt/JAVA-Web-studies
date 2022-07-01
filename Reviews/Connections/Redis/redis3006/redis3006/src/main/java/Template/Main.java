package Template;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.God;
import org.jnosql.artemis.key.KeyValueTemplate;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Set<String> duties = new HashSet<>();
            duties.add("music");
            duties.add("poetry");
            duties.add("medicine");

            God apollo = new God("Apollo", "Sun", duties);
//                    .id("Apollo")
//                    .power("Sun")
//                    .duties(duties)
//                    .build();

            KeyValueTemplate keyValueTemplate = container.select(KeyValueTemplate.class).get();

            God godSaved = keyValueTemplate.put(apollo);
            System.out.println(godSaved);

            Optional<God> godFound = keyValueTemplate.get("Apollo", God.class);
            System.out.println(godFound);
        }
    }

}
