package br.gov.caixa.adabankapi.service;


import br.gov.caixa.adabankapi.dtoRequest.ClientPFRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.ClientPFResponseDto;
import br.gov.caixa.adabankapi.entity.ClientPF;
import br.gov.caixa.adabankapi.exceptions.ClientValidationException;
import br.gov.caixa.adabankapi.repository.ClientPFRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClientPFService {

    final private ClientPFRepository clientPFRepository ;
    final private ModelMapper modelMapper;


    /* Injetando a dependencia do que eu vou usar aqui. Vou usar o modelMapper para poder fazer o De-Para e vou usar
    / e vou usar a interface  ClientPFRepository para poder gravar as coisas.
    * */
    public ClientPFService(ClientPFRepository clientPFRepository, ModelMapper modelMapper){
        this.clientPFRepository = clientPFRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public ClientPFResponseDto getClientPFById(Long id)  {
            return clientPFRepository.findById(id)
                    .map(clientPF -> modelMapper.map(clientPF, ClientPFResponseDto.class))
                    .get();
    }

    public List<ClientPFResponseDto> getAllClients() {
        return clientPFRepository.findAll()
                .stream()
                .map(client-> modelMapper.map(client, ClientPFResponseDto.class))
                .toList();

    }
    @Transactional
    public ClientPFResponseDto insert(ClientPFRequestDto clientPFRequestDto) {
        ClientPF clientPF = modelMapper.map(clientPFRequestDto, ClientPF.class);
        clientPFRepository.save(clientPF);
        return modelMapper.map(clientPF, ClientPFResponseDto.class);
    }

    public void removeById(Long id) {
        clientPFRepository.deleteById(id);
    }
}
