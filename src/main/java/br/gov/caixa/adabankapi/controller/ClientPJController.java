package br.gov.caixa.adabankapi.controller;

import br.gov.caixa.adabankapi.dtoRequest.ClientPFRequestDto;
import br.gov.caixa.adabankapi.dtoRequest.ClientPJRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.ClientPFResponseDto;
import br.gov.caixa.adabankapi.dtoResponse.ClientPJResponseDto;
import br.gov.caixa.adabankapi.service.ClientPFService;
import br.gov.caixa.adabankapi.service.ClientPJService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes/pj")
public class ClientPJController {


    private final ClientPJService clientPJService;

    public ClientPJController(ClientPJService clientPJService){
        this.clientPJService = clientPJService;
    }

    @GetMapping()
    public ResponseEntity<List<ClientPJResponseDto>> getAllClientsPJ(){
        List<ClientPJResponseDto> listClientPJResponseDto = clientPJService.getAllClients();
        return ResponseEntity.ok(listClientPJResponseDto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientPJResponseDto> getClientPJById(@PathVariable Long id){
        ClientPJResponseDto clientPJResponseDto = clientPJService.getClientPJById(id);
        return  ResponseEntity.ok(clientPJResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ClientPJResponseDto> createClientPJ(@RequestBody ClientPJRequestDto clientPJRequestDto)
    {
        return ResponseEntity.ok(clientPJService.createClientPJ(clientPJRequestDto));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<ClientPJResponseDto>updateClientPJ(@PathVariable Long id,
                                                           @RequestBody ClientPJRequestDto clientPJRequestDto){
       return ResponseEntity.ok(clientPJService.updateById(id, clientPJRequestDto));

    }
    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> removeClient(@PathVariable (name= "clientId") Long id){
        clientPJService.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


    /*


    @DeleteMapping("/pf/{clientId}")
    public ResponseEntity<?> removeClient(@PathVariable (name= "clientId") Long id){
        clientPFService.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
*/



}

