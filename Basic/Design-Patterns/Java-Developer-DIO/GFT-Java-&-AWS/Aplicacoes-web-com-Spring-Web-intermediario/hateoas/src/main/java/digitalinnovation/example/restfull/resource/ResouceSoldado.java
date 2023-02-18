package digitalinnovation.example.restfull.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import digitalinnovation.example.restfull.controller.SoldadoController;
import digitalinnovation.example.restfull.controller.response.SoldadoListResponse;
import digitalinnovation.example.restfull.controller.response.SoldadoResponse;
import digitalinnovation.example.restfull.entity.SoldadoEntity;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ResouceSoldado {
    private ObjectMapper objectMapper;

    public ResouceSoldado (ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public SoldadoListResponse criarLink(SoldadoEntity soldadoEntity) {
        SoldadoListResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoListResponse.class);
        Link link = linkTo(methodOn(SoldadoController.class).buscarSoldado(soldadoEntity.getId())).withSelfRel();
        soldadoListResponse.add(link);
        return soldadoListResponse;
    }

    public SoldadoResponse criarLinkDetale(SoldadoEntity soldadoEntity) {
        SoldadoResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoResponse.class);

        if (soldadoEntity.getStatus().equals("morto")){
            Link link = linkTo(methodOn(SoldadoController.class).deletarSoldado(soldadoEntity.getId()))
                    .withRel("Remover")
                    .withTitle("Deletar Soldado")
                    .withType("delete");
            soldadoListResponse.add(link);
        }
        else if (soldadoEntity.getStatus().equals("vivo")){
            Link link = linkTo(methodOn(SoldadoController.class).emGuarda(soldadoEntity.getId()))
                    .withRel("Alterar")
                    .withTitle("Em guarda")
                    .withType("put");
            soldadoListResponse.add(link);
        }
        return soldadoListResponse;
    }
}
