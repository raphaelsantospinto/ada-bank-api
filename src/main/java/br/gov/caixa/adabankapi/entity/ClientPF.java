package br.gov.caixa.adabankapi.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ClientPF extends Client{



    private String cpf;

}
