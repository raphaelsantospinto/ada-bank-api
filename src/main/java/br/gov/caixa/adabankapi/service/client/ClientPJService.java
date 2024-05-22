package br.gov.caixa.adabankapi.service;
import br.gov.caixa.adabankapi.dtoRequest.ClientPJRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.ClientPJResponseDto;
import br.gov.caixa.adabankapi.entity.Client.ClientPJ;
import br.gov.caixa.adabankapi.exceptions.ValidationException;
import br.gov.caixa.adabankapi.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

//ANOTAÇÃO PARA INFORMAR AO SPRING QUE É UMA CLASSE SERVICE
@Service
public class ClientPJService {

    final private ClientRepository clientRepository ;
    final private ModelMapper modelMapper;


    // INJEÇAO DE DEPENDENCIA POR CONSTRUTOR. ESSA CLASSE AQUI PRECISA DO MODELMAPPER E DO JPAREPOSITORY PRA FUNCIONAR
    // INJETO DEPENDENCIA AQUI
    public ClientPJService(ClientRepository clientPJRepository, ModelMapper modelMapper){
        this.clientRepository = clientPJRepository;
        this.modelMapper = modelMapper;
    }

    //METODOS AQUI

    public List<ClientPJResponseDto>getAllClients(){
        return clientRepository.findAllPJ()
                .stream()
                .map(client-> {
                    return modelMapper.map(client, ClientPJResponseDto.class);
                })
                .toList();

    }

    public ClientPJResponseDto getClientPJById(Long id) {
    return clientRepository.findById(id)
            .map(cliente -> modelMapper.map(cliente, ClientPJResponseDto.class))
            .orElseThrow( () -> new ValidationException("Cliente nao localizado"));

    }

    public ClientPJResponseDto createClientPJ(ClientPJRequestDto clientPJRequestDto) {
        ClientPJ cpj = modelMapper.map(clientPJRequestDto, ClientPJ.class);
        clientRepository.save(cpj);
        return modelMapper.map(cpj, ClientPJResponseDto.class);

    }

    public ClientPJResponseDto updateById(Long id, ClientPJRequestDto clientPJRequestDto) {
        return clientRepository.findById(id)
                .map(client -> {
                    modelMapper.map(clientPJRequestDto, client);
                    return clientRepository.save(client);
                }).map(client -> modelMapper.map(client, ClientPJResponseDto.class))
                .orElseThrow(()-> new ValidationException("Cliente Nao Localizado pelo ID"));
    }

    public void removeById(Long id) { clientRepository.deleteById(id);}
}
