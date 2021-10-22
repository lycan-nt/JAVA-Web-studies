package digitalinnovation.example.restfull.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import digitalinnovation.example.restfull.controller.request.SoldadoEditRequest;
import digitalinnovation.example.restfull.controller.response.SoldadoListResponse;
import digitalinnovation.example.restfull.controller.response.SoldadoResponse;
import digitalinnovation.example.restfull.dto.Soldado;
import digitalinnovation.example.restfull.entity.SoldadoEntity;
import digitalinnovation.example.restfull.repostory.SoldadoRepository;
import digitalinnovation.example.restfull.resource.ResouceSoldado;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldadoService {

    private SoldadoRepository soldadoRepository;
    private ObjectMapper objectMapper;
    private ResouceSoldado resouceSoldado;

    public SoldadoService(SoldadoRepository soldadoRepository, ObjectMapper objectMapper, ResouceSoldado resouceSoldado) {
        this.soldadoRepository = soldadoRepository;
        this.objectMapper = objectMapper;
        this.resouceSoldado = resouceSoldado;
    }

    public SoldadoResponse buscarSoldado(Long id) {
        SoldadoEntity soldado = soldadoRepository.findById(id).orElseThrow();
        SoldadoResponse soldadoResponse = resouceSoldado.criarLinkDetale(soldado);
        return soldadoResponse;
    }

    public void criarSoldado(Soldado soldado){
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldado, SoldadoEntity.class);
        soldadoRepository.save(soldadoEntity);
    }

    public void alterarSoldado(Long id, SoldadoEditRequest soldadoEditRequest) {
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldadoEditRequest, SoldadoEntity.class);
        soldadoEntity.setId(id);
        soldadoRepository.save(soldadoEntity);
    }

    public void deletarSoldado(Long id) {
        SoldadoEntity soldado = soldadoRepository.findById(id).orElseThrow();
        soldadoRepository.delete(soldado);
    }

    public Resources<SoldadoListResponse> buscarSoldados(){
        List<SoldadoEntity> all = soldadoRepository.findAll();
        List<SoldadoListResponse> soldadoStream = all.stream()
                .map(it -> resouceSoldado.criarLink(it))
                .collect(Collectors.toList());
        return new Resources<>(soldadoStream);
    }
}
