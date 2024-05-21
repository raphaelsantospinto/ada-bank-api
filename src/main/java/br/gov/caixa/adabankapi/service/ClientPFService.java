package br.gov.caixa.adabankapi.service;


import br.gov.caixa.adabankapi.dtoRequest.ClientPFRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.ClientPFResponseDto;
import br.gov.caixa.adabankapi.entity.Client.ClientPF;
import br.gov.caixa.adabankapi.exceptions.ClientValidationException;
import br.gov.caixa.adabankapi.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClientPFService {

    final private ClientRepository clientRepository ;
    final private ModelMapper modelMapper;


    /* Injetando a dependencia do que eu vou usar aqui. Vou usar o modelMapper para poder fazer o De-Para e vou usar
    / e vou usar a interface  ClientPFRepository para poder gravar as coisas.
    * */
    public ClientPFService(ClientRepository clientRepository, ModelMapper modelMapper){
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public ClientPFResponseDto getClientPFById(Long id)  {
            return clientRepository.findById(id)
                    .map(clientPF -> modelMapper.map(clientPF, ClientPFResponseDto.class))
                    .orElseThrow(() -> new ClientValidationException("Produto nao existe"));
    }

    public List<ClientPFResponseDto> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(client-> modelMapper.map(client, ClientPFResponseDto.class))
                .toList();

    }
    @Transactional
    public ClientPFResponseDto createClientPF(ClientPFRequestDto clientPFRequestDto) {
        ClientPF clientPF = modelMapper.map(clientPFRequestDto, ClientPF.class);
        clientRepository.save(clientPF);
        return modelMapper.map(clientPF, ClientPFResponseDto.class);
    }

    public void removeById(Long id) {
        clientRepository.deleteById(id);
    }


    public ClientPFResponseDto updateById(Long id, ClientPFRequestDto clientPFRequestDto) {
        return clientRepository.findById(id)
                .map(client -> {
                    modelMapper.map(clientPFRequestDto, client);
                    return clientRepository.save(client);
                }).map(client -> modelMapper.map(client, ClientPFResponseDto.class))
                .orElseThrow(() -> new ClientValidationException("Cliente Nao existe"));
    }
}
