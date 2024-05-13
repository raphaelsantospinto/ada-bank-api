package br.gov.caixa.adabankapi.controller;

import br.gov.caixa.adabankapi.dtoRequest.ClientPFRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.ClientPFResponseDto;

import br.gov.caixa.adabankapi.service.ClientPFService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientPFService clientPFService;
    
    public ClientController(ClientPFService clientPFService){
        this.clientPFService = clientPFService;
    }

    @GetMapping("/pf")
    public ResponseEntity<List<ClientPFResponseDto>> getAllClient(){
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
            return ResponseEntity.ok(clientPFService.insert(clientPFRequestDto));

    }

    @PutMapping public void updateClient(){

    }
    @DeleteMapping("/pf/{clientId}")
    public ResponseEntity<?> removeClient(@PathVariable (name= "clientId") Long id){
        clientPFService.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}

