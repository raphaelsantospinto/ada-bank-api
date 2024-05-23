package br.gov.caixa.adabankapi.controller.client;

import br.gov.caixa.adabankapi.dtoRequest.client.ClientPFRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.client.ClientPFResponseDto;
import br.gov.caixa.adabankapi.service.ClientPFService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes/pf")
public class ClientPFController {

    private final ClientPFService clientPFService;

    
    public ClientPFController(ClientPFService clientPFService){
        this.clientPFService = clientPFService;
    }

    @GetMapping()
    public ResponseEntity<List<ClientPFResponseDto>> getAllClientsPF(){
        List<ClientPFResponseDto> listClientPFResponseDto = clientPFService.getAllClients();
        return ResponseEntity.ok(listClientPFResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientPFResponseDto> getClientPFById(@PathVariable Long id){
        ClientPFResponseDto clientPFResponseDto = clientPFService.getClientPFById(id);
        return  ResponseEntity.ok(clientPFResponseDto);
    }
    @PostMapping()
    public ResponseEntity<ClientPFResponseDto>createClient(@RequestBody ClientPFRequestDto clientPFRequestDto){
            return ResponseEntity.ok(clientPFService.createClientPF(clientPFRequestDto));

    }

    @PutMapping ("/{id}")
    public ResponseEntity<ClientPFResponseDto>updateClient(@PathVariable Long id,
                                                                       @RequestBody ClientPFRequestDto clientPFRequestDto){
        ClientPFResponseDto clientPFResponseDto = clientPFService.updateById(id,clientPFRequestDto);
        return ResponseEntity.ok(clientPFResponseDto);

    }
    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> removeClient(@PathVariable (name= "clientId") Long id){
        clientPFService.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }




}

