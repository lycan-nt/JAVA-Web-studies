package com.owl.report.service;

import com.owl.report.dto.ClientDto;
import com.owl.report.model.Client;
import com.owl.report.repository.ClientRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void save(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        this.clientRepository.save(client);
    }

    public List<Client> getClient() {
        return this.clientRepository.findAll();
    }

    public byte[] exportPDF() throws Exception {
        try {
            File file = ResourceUtils.getFile("classpath:jrxml/first-report.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            Map<String, Object> parameters = new HashMap<>();
            final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(getClient());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception exception) {
            throw new Exception("Erro ao gerar relatório: " + exception.getMessage());
        }
    }
}
