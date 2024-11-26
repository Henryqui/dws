package br.com.henryqui.orcamento.services;

import br.com.henryqui.orcamento.model.Municipio;
import br.com.henryqui.orcamento.repositories.MunicipioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    public Municipio salvar(Municipio municipio) {
        return municipioRepository.save(municipio);
    }

    public Municipio Atualizar(Integer id, Municipio municipio){
        Municipio municipioSalvo = buscarMunicipioExistente(id);

        BeanUtils.copyProperties(municipio, municipioSalvo, "id");

        return municipioRepository.save(municipioSalvo);
    }

    private Municipio buscarMunicipioExistente(Integer id) {
        Optional<Municipio> municipioSalvo = municipioRepository.findById(id);

        if(!municipioSalvo.isPresent()){
            throw new IllegalArgumentException();
        }
        return municipioSalvo.get();
    }


}
