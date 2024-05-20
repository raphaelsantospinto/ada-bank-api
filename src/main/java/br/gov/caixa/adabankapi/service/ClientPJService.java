package br.gov.caixa.adabankapi.service;
import br.gov.caixa.adabankapi.dtoResponse.ClientPJResponseDto;
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
    // TODO AINDA FALTA FILTRAR POR TIPO PJ
    public List<ClientPJResponseDto>getAllClients(){
        return clientRepository.findAll()
                .stream()
                .map(client-> {
                    return modelMapper.map(client, ClientPJResponseDto.class);
                })
                .toList();

    }

}
