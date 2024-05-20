package br.gov.caixa.adabankapi.controller;

import br.gov.caixa.adabankapi.dtoRequest.ClientPFRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.ClientPFResponseDto;

import br.gov.caixa.adabankapi.dtoResponse.ClientPJResponseDto;
import br.gov.caixa.adabankapi.service.ClientPFService;
import br.gov.caixa.adabankapi.service.ClientPJService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientPFService clientPFService;
    private final ClientPJService clientPJService;
    
    public ClientController(ClientPFService clientPFService, ClientPJService clientPJService){
        this.clientPFService = clientPFService;
        this.clientPJService = clientPJService;
    }

    @GetMapping("/pf")
    public ResponseEntity<List<ClientPFResponseDto>> getAllClientsPF(){
        List<ClientPFResponseDto> listClientPFResponseDto = clientPFService.getAllClients();
        return ResponseEntity.ok(listClientPFResponseDto);
    }

    @GetMapping("/pf/{id}")
    public ResponseEntity<ClientPFResponseDto> getClientPFById(@PathVariable Long id){
        ClientPFResponseDto clientPFResponseDto = clientPFService.getClientPFById(id);

        return  ResponseEntity.ok(clientPFResponseDto);
    }
    @PostMapping("/pf")
    public ResponseEntity<ClientPFResponseDto>createClient(@RequestBody ClientPFRequestDto clientPFRequestDto){
            return ResponseEntity.ok(clientPFService.createClientPF(clientPFRequestDto));

    }

    @PutMapping ("/pf/{id}")
    public ResponseEntity<ClientPFResponseDto>updateClient(@PathVariable Long id,
                                                                       @RequestBody ClientPFRequestDto clientPFRequestDto){
        ClientPFResponseDto clientPFResponseDto = clientPFService.updateById(id,clientPFRequestDto);
        return ResponseEntity.ok(clientPFResponseDto);

    }
    @DeleteMapping("/pf/{clientId}")
    public ResponseEntity<?> removeClient(@PathVariable (name= "clientId") Long id){
        clientPFService.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/pj")
    public ResponseEntity<List<ClientPJResponseDto>> getAllClientsPJ(){
        List<ClientPJResponseDto> listClientPJResponseDto = clientPJService.getAllClients();
        return ResponseEntity.ok(listClientPJResponseDto);

    }
}

