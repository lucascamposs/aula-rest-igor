package br.edu.unicesumar.aula.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.unicesumar.aula.domain.CursoNovo;
import br.edu.unicesumar.aula.repository.CursoNovoRepository;

@Service
public class CursoNovoService {
    
    @Autowired
    private CursoNovoRepository cursoNovoRespository;


    public CursoNovo save(CursoNovo cursoNovo){
        return this.cursoNovoRespository.save(cursoNovo);
    }

    public Page<CursoNovo> findAll(Pageable pageable) {
		return cursoNovoRespository.findAll(pageable);
	}

	public CursoNovo findById(Long id) {
		return cursoNovoRespository.findById(id).orElse(null);
	}

	public CursoNovo update(CursoNovo cursoNovo, Long id) {
		Optional<CursoNovo> cursoDoBancoDeDadosOpt = cursoNovoRespository.findById(id);

		if(cursoDoBancoDeDadosOpt.isPresent()) {
			CursoNovo cursoDoBancoDeDados = cursoDoBancoDeDadosOpt.get();
			cursoDoBancoDeDados.setNome(cursoNovo.getNome());
            cursoDoBancoDeDados.setChMin(cursoNovo.getChMin());
            cursoDoBancoDeDados.setChMax(cursoNovo.getChMax());
            cursoDoBancoDeDados.setDtAprovacao(cursoNovo.getDtAprovacao());
			return this.save(cursoDoBancoDeDados);
		}
		
		return null;
		
	}
	
	public void deleteById(Long id) {
		cursoNovoRespository.deleteById(id);
	}
}
